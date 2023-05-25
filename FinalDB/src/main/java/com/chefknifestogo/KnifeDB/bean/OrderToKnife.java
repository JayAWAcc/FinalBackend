package com.chefknifestogo.KnifeDB.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name ="ORDER_TO_KNIFE")
public class OrderToKnife {

    @Id
    @SequenceGenerator(name="order_knife_seq", sequenceName = "ORDER_KNIFE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "order_knife_seq", strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "qty")
    private int quantity;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Knife knife;


    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.DETACH)
    private Order order;

    public OrderToKnife() {
    }

    public OrderToKnife(int id, int quantity, Knife knife, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.knife = knife;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Knife getKnife() {
        return knife;
    }

    public void setKnife(Knife knife) {
        this.knife = knife;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderToKnife{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", knife=" + knife +
                ", order=" + order +
                '}';
    }
}
