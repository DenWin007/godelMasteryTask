package by.test.godelMasteryTask.service;

import by.test.godelMasteryTask.models.Order;
import by.test.godelMasteryTask.models.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    @Override
    public Order getOrderById(long id) {
        return orderDao.findOrderById(id);
    }

    @Override
    public void delete(long id) {
        if (orderDao.existsById(id))
            orderDao.deleteById(id);
    }

    @Override
    public Order create(Order request) {
        return orderDao.save(request);
    }
}
