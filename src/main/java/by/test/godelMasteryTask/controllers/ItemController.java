package by.test.godelMasteryTask.controllers;

import by.test.godelMasteryTask.models.Item;
import by.test.godelMasteryTask.service.ItemService;
import by.test.godelMasteryTask.views.ItemView;
import by.test.godelMasteryTask.views.ItemViewList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ItemViewList itemsView() {
        List<Item> a = itemService.getAll();
        List<ItemView> a1 = new ArrayList<>();

        for (Item i : a) {
            ItemView itemView = new ItemView(i.getId(), i.getName(), String.valueOf(i.getPrice()) + "$");
            a1.add(itemView);
        }

        ItemViewList show = new ItemViewList(a1.size(), a1);
        return show;
    }
}
