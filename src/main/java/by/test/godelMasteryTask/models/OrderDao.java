package by.test.godelMasteryTask.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderDao extends CrudRepository<Order, Long> {
    List<Order> findAll();
    Order findOrderById(long id);

}
