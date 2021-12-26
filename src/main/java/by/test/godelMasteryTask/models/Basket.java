package by.test.godelMasteryTask.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;

    private double total;

    @ManyToOne
    @JoinColumn(name = "item_ID", nullable = false)
    @JsonIgnore
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_ID", nullable = true)
    @JsonIgnore
    private Order order;

    public Basket() {
    }


}
