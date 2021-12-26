package by.test.godelMasteryTask.service;

import by.test.godelMasteryTask.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order getOrderById(long id);

    void delete(long id);

    Order create(Order request);
}
