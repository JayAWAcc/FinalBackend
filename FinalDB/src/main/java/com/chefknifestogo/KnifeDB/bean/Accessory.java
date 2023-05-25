package com.chefknifestogo.KnifeDB.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ACCESSORY")
public class Accessory {
    @Id
    @SequenceGenerator(name="accessory_seq_gen", sequenceName="ACCESSORY_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "accessory_seq_gen", strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String accessoryName;
    @Column
    private float price;
    @Column
    private String description;
    @Column
    private String imageUrl;
    @Column
    private int stock;
    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "accessory")
    private List<AccessoryToType> type;

    @OneToMany(cascade= CascadeType.DETACH, mappedBy = "accessory")
    private List<AccessoryComment> comment;


    @Column
    private String supplier;

    public Accessory() {
    }

    public Accessory(int id, String accessoryName, float price, String description, String imageUrl, int stock, List<AccessoryToType> type, List<AccessoryComment> comment, String supplier) {
        this.id = id;
        this.accessoryName = accessoryName;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.stock = stock;
        this.type = type;
        this.comment = comment;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<AccessoryToType> getType() {
        return type;
    }

    public void setType(List<AccessoryToType> type) {
        this.type = type;
    }

    public List<AccessoryComment> getComment() {
        return comment;
    }

    public void setComment(List<AccessoryComment> comment) {
        this.comment = comment;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "id=" + id +
                ", accessoryName='" + accessoryName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", stock=" + stock +
                ", type=" + type +
                ", comment=" + comment +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}
