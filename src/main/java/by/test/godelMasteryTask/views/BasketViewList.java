package by.test.godelMasteryTask.views;

import java.util.List;

public class BasketViewList {
    int count;
    List<BasketView> baskets;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BasketView> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<BasketView> baskets) {
        this.baskets = baskets;
    }

    public BasketViewList(int count, List<BasketView> baskets) {
        this.count = count;
        this.baskets = baskets;
    }

    public BasketViewList() {
    }
}
