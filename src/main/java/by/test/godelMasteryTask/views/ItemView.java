package by.test.godelMasteryTask.views;

public class ItemView {
    long id;
    String title;
    String price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ItemView(long id, String title, String price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public ItemView() {
    }
}
