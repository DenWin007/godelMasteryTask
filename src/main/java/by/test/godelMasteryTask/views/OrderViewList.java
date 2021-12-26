package by.test.godelMasteryTask.views;

import java.util.List;

public class OrderViewList {

    int count;
    List<OrderView> orders;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<OrderView> getItems() {
        return orders;
    }

    public void setItems(List<OrderView> items) {
        this.orders = items;
    }

    public OrderViewList(int count, List<OrderView> items) {
        this.count = count;
        this.orders = items;
    }

    public OrderViewList() {
    }
}
