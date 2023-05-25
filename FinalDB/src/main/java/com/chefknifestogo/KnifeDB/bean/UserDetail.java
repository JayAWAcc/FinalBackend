package com.chefknifestogo.KnifeDB.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="USER_DETAIL")
public class UserDetail {

    @Id
    @SequenceGenerator(name="knife_user_seq", sequenceName = "KNIFE_USER_DETAIL_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "knife_user_seq", strategy = GenerationType.AUTO)
    private int id;

    @Column
    String name;
    @Column
    String phone;
    @Column
    String email;
    @Column
    String address1;
    @Column
    String address2;
    @Column
    String city;
    @Column
    String state;
    @Column
    String zip;

    @OneToOne
    @JoinColumn(name = "ID")
    @JsonIgnore
    private User user;

    public UserDetail() {
    }

    public UserDetail(String name, String phone, String email, String address1, String address2, String city, String state, String zip, User user) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.user = user;
    }

    public UserDetail(int id, String name, String phone, String email, String address1, String address2, String city, String state, String zip, User user) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", user=" + user +
                '}';
    }
}
