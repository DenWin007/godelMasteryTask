package by.test.godelMasteryTask.views;

import java.util.List;

public class OrderView {
    long id;
    double orderPrise;
    String timestamp;
    List<BasketView> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getOrderPrise() {
        return orderPrise;
    }

    public void setOrderPrise(double orderPrise) {
        this.orderPrise = orderPrise;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<BasketView> getItems() {
        return items;
    }

    public void setItems(List<BasketView> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderView{" +
                "id=" + id +
                ", orderPrise=" + orderPrise +
                ", timestamp='" + timestamp + '\'' +
                ", items=" + items +
                '}';
    }
}
