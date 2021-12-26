package by.test.godelMasteryTask.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BasketDao extends CrudRepository<Basket, Long> {
    List<Basket> findAll();

    Basket findByItem(Item item);

    Basket findById(long id);

    List<Basket> findAllByOrderIsNotNull();

    List<Basket> findAllByOrderIsNull();

    List<Basket> findByOrder(Order order);

}
