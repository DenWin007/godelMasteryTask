package by.test.godelMasteryTask.controllers;

import by.test.godelMasteryTask.models.Basket;
import by.test.godelMasteryTask.models.Order;
import by.test.godelMasteryTask.service.BasketService;
import by.test.godelMasteryTask.service.OrderService;
import by.test.godelMasteryTask.views.BasketView;
import by.test.godelMasteryTask.views.OrderView;
import by.test.godelMasteryTask.views.OrderViewList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private OrderService orderService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public OrderViewList addOrder() {
        List<Basket> data = basketService.getAllByOrderIsNull();
        List<OrderView> orders = new ArrayList<OrderView>();
        Order a = new Order();
        OrderView show = new OrderView();
        double orderPrice = 0.0;
        String timeOrder = new SimpleDateFormat("dd.MM.yyyy:HH.mm.ss").format(new Date());
        List<BasketView> baskets = new ArrayList<BasketView>();

        a.setTimestamp(timeOrder);
        for (Basket n : data) {
            orderPrice += n.getTotal();
        }
        a.setOrderPrice(orderPrice);
        Order addO = orderService.create(a);

        for (Basket n : data) {
            n.setOrder(addO);
            basketService.create(n);
            BasketView bas = new BasketView();
            bas.setQuantity(n.getQuantity());
            bas.setTitle(n.getItem().getName());
            bas.setTotal(n.getTotal());
            baskets.add(bas);
        }
        show.setOrderPrise(orderPrice);
        show.setTimestamp(timeOrder);
        show.setItems(baskets);
        orders.add(show);
        OrderViewList orderViewList = new OrderViewList(orders.size(), orders);
        return orderViewList;

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public OrderViewList orders() {
        List<Order> a = orderService.getAll();
        List<OrderView> orders = new ArrayList<OrderView>();

        for (Order n : a) {
            OrderView ow = new OrderView();
            ow.setId(n.getId());
            ow.setTimestamp(n.getTimestamp());
            ow.setOrderPrise(n.getOrderPrice());
            List<Basket> bs = basketService.getByOrder(n);
            List<BasketView> bv = new ArrayList<>();

            for (Basket b1 : bs) {
                BasketView j = new BasketView();
                j.setTitle(b1.getItem().getName());
                j.setQuantity(b1.getQuantity());
                j.setTotal(b1.getTotal());
                bv.add(j);
            }

            ow.setItems(bv);
            orders.add(ow);
        }

        OrderViewList orderViewList = new OrderViewList(orders.size(), orders);
        return orderViewList;
    }
}
