package com.chefknifestogo.KnifeDB.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="ORDER_PLACED")
public class Order {

    @Id
    @SequenceGenerator(name="order_seq", sequenceName = "ORDER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "order_seq", strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String shippingStatus;

    @Column
    private String contact;
    @Column
    private Date orderDate;
    @Column
    private int userId;
    @Column
    private float total;


    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="order")
    private Set<OrderToKnife> knifePurchase;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "order")
    private Set<OrderToAccessory> accessoryPurchase;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private StartingAddress startingAddress;

    public Order() {
    }

    public Order(int id, String shippingStatus, String contact, Date orderDate, int userId, float total, Set<OrderToKnife> knifePurchase, Set<OrderToAccessory> accessoryPurchase, ShippingAddress shippingAddress, StartingAddress startingAddress) {
        this.id = id;
        this.shippingStatus = shippingStatus;
        this.contact = contact;
        this.orderDate = orderDate;
        this.userId = userId;
        this.total = total;
        this.knifePurchase = knifePurchase;
        this.accessoryPurchase = accessoryPurchase;
        this.shippingAddress = shippingAddress;
        this.startingAddress = startingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Set<OrderToKnife> getKnifePurchase() {
        return knifePurchase;
    }

    public void setKnifePurchase(Set<OrderToKnife> knifePurchase) {
        this.knifePurchase = knifePurchase;
    }

    public Set<OrderToAccessory> getAccessoryPurchase() {
        return accessoryPurchase;
    }

    public void setAccessoryPurchase(Set<OrderToAccessory> accessoryPurchase) {
        this.accessoryPurchase = accessoryPurchase;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public StartingAddress getStartingAddress() {
        return startingAddress;
    }

    public void setStartingAddress(StartingAddress startingAddress) {
        this.startingAddress = startingAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", shippingStatus='" + shippingStatus + '\'' +
                ", contact='" + contact + '\'' +
                ", orderDate=" + orderDate +
                ", userId=" + userId +
                ", total=" + total +
                ", knifePurchase=" + knifePurchase +
                ", accessoryPurchase=" + accessoryPurchase +
                ", shippingAddress=" + shippingAddress +
                ", startingAddress=" + startingAddress +
                '}';
    }
}
