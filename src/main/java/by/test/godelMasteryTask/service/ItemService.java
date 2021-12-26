package by.test.godelMasteryTask.service;

import by.test.godelMasteryTask.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAll();
    Item getItemById(long id);
    void delete(long id);
    Item create(Item request);
}
