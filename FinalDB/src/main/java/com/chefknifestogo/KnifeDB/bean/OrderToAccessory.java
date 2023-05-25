package com.chefknifestogo.KnifeDB.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_TO_ACCESSORY")
public class OrderToAccessory {

    @Id
    @SequenceGenerator(name="order_accessory_seq", sequenceName = "ORDER_ACCESSORY_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "order_accessory_seq", strategy = GenerationType.AUTO)
    private int id;

    @Column(name="QTY")
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Accessory accessory;

    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.DETACH)
    private Order order;

    public OrderToAccessory() {
    }

    public OrderToAccessory(int id, int quantity, Accessory accessory, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.accessory = accessory;
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

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderToAccessory{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", accessory=" + accessory +
                ", order=" + order +
                '}';
    }
}
