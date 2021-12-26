package by.test.godelMasteryTask.service;

import by.test.godelMasteryTask.models.Item;
import by.test.godelMasteryTask.models.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getAll() {
        return itemDao.findAll();
    }

    @Override
    public Item getItemById(long id) {
        return itemDao.findItemById(id);
    }

    @Override
    public void delete(long id) {
        if(itemDao.existsById(id))
            itemDao.deleteById(id);
    }

    @Override
    public Item create(Item request) {
        return itemDao.save(request);
    }
}
