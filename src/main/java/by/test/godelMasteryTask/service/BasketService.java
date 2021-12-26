package by.test.godelMasteryTask.service;

import by.test.godelMasteryTask.models.Basket;
import by.test.godelMasteryTask.models.Item;
import by.test.godelMasteryTask.models.Order;

import java.util.List;

public interface BasketService {
    List<Basket> getAll();

    List<Basket> getAllByOrderIsNull();

    List<Basket> getAllByOrderIsNotNull();

    List<Basket> getByOrder(Order order);

    Basket getById(long id);

    Basket getByItem(Item item);

    void delete(long id);

    Basket create(Basket request);

}
