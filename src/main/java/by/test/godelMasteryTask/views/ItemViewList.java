package by.test.godelMasteryTask.views;

import java.util.List;

public class ItemViewList {
    int count;
    List<ItemView> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ItemView> getItems() {
        return items;
    }

    public void setItems(List<ItemView> items) {
        this.items = items;
    }

    public ItemViewList(int count, List<ItemView> items) {
        this.count = count;
        this.items = items;
    }

    public ItemViewList() {
    }
}
