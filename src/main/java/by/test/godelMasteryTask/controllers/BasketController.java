package by.test.godelMasteryTask.controllers;


import by.test.godelMasteryTask.models.Basket;
import by.test.godelMasteryTask.models.Item;
import by.test.godelMasteryTask.service.BasketService;
import by.test.godelMasteryTask.service.ItemService;
import by.test.godelMasteryTask.views.BasketView;
import by.test.godelMasteryTask.views.BasketViewList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BasketController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private BasketService basketService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public BasketViewList basket() {
        List<Basket> bs = basketService.getAllByOrderIsNull();
        List<BasketView> a = new ArrayList<BasketView>();
        for (Basket i : bs) {
            BasketView j = new BasketView();
            j.setTitle(i.getItem().getName());
            j.setQuantity(i.getQuantity());
            j.setTotal(i.getTotal());
            a.add(j);
        }
        BasketViewList basketViewList = new BasketViewList(a.size(), a);
        return basketViewList;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "basket/add/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> addBasket(@PathVariable("id") Long id) {
        Basket a = null;
        Item addItem = itemService.getItemById(id);
        if (addItem == null)
            return ResponseEntity.noContent().build();
        if (basketService.getByItem(addItem) == null) {
            a = new Basket();
            a.setItem(addItem);
            a.setQuantity(1);
            a.setTotal(addItem.getPrice());
            a.setOrder(null);
        } else {
            a = basketService.getByItem(addItem);
            a.setQuantity(a.getQuantity() + 1);
            a.setTotal(a.getTotal() + addItem.getPrice());

        }
        basketService.create(a);

        return ResponseEntity.ok("Entity added");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "basket/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delBasket(@PathVariable("id") Long id) {
        Basket a = null;

        if (basketService.getById(id) == null) {
            return ResponseEntity.noContent().build();
        } else if (basketService.getById(id).getQuantity() == 1) {
            basketService.delete(id);
        } else {
            a = basketService.getById(id);
            a.setQuantity(a.getQuantity() - 1);
            a.setTotal(a.getTotal() - a.getItem().getPrice());
            basketService.create(a);
        }
        return ResponseEntity.ok("Entity deleted");
    }
}