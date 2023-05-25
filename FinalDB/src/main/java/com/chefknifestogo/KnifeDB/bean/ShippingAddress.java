package com.chefknifestogo.KnifeDB.bean;

import javax.persistence.*;

@Entity
@Table (name = "shipping_address")
public class ShippingAddress {
    @Id
    @SequenceGenerator(name="shipping_seq", sequenceName = "SHIPPING_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "shipping_seq", strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String address1;
    @Column
    private String address2;
    @Column
    private String city;
    @Column(name="states")
    private String state;
    @Column
    private String zip;



    public ShippingAddress() {
    }

    public ShippingAddress(int id, String address1, String address2, String city, String state, String zip) {
        this.id = id;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "id=" + id +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
