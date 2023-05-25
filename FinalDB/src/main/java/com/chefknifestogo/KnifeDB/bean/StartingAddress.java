package com.chefknifestogo.KnifeDB.bean;

import javax.persistence.*;

@Entity
@Table(name = "starting_address")
public class StartingAddress {
    @Id
    @SequenceGenerator(name="starting_seq", sequenceName = "STARTING_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "starting_seq", strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String address1;
    @Column
    private String address2;
    @Column
    private String city;
    @Column
    private String states;
    @Column
    private String zip;


    public StartingAddress() {
    }

    public StartingAddress(int id, String address1, String address2, String city, String states, String zip) {
        this.id = id;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.states = states;
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StartingAddress{" +
                "id=" + id +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", states='" + states + '\'' +
                ", zip='" + zip + '\'' +
                '}';
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

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
