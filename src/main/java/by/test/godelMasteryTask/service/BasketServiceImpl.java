package by.test.godelMasteryTask.service;

import by.test.godelMasteryTask.models.Basket;
import by.test.godelMasteryTask.models.BasketDao;
import by.test.godelMasteryTask.models.Item;
import by.test.godelMasteryTask.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketDao basketDao;

    @Override
    public List<Basket> getAll() {
        return basketDao.findAll();
    }

    @Override
    public List<Basket> getAllByOrderIsNull() {
        return basketDao.findAllByOrderIsNull();
    }

    @Override
    public List<Basket> getAllByOrderIsNotNull() {
        return basketDao.findAllByOrderIsNotNull();
    }

    @Override
    public List<Basket> getByOrder(Order order) {
        return basketDao.findByOrder(order);
    }

    @Override
    public Basket getById(long id) {
        return basketDao.findById(id);
    }

    @Override
    public Basket getByItem(Item item) {
        return basketDao.findByItem(item);
    }

    @Override
    public void delete(long id) {
        if (basketDao.existsById(id))
            basketDao.deleteById(id);

    }

    @Override
    public Basket create(Basket request) {
        return basketDao.save(request);
    }
}
