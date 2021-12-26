package by.test.godelMasteryTask.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ItemDao extends CrudRepository<Item, Long> {
    List<Item> findAll();
    Item findItemById(long id);
}
