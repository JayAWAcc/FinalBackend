package com.chefknifestogo.KnifeDB.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Knife {

    @Id
    @SequenceGenerator(name="knife_id_seq_gen", sequenceName = "KNIFE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "knife_id_seq_gen", strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "knife")
    private List<Image> image;
    @Column
    private String brand;
    @Column
    private String knifeType;
    @Column
    private String steel;
    @Column
    private int stock;
    @Column
    private float price;
    @Column
    private String supplier;


    @OneToMany(cascade= CascadeType.ALL, mappedBy = "knife")
    private List<KnifeComment> comment;


    public Knife() {
    }

    public Knife(int id, String name, String description, List<Image> image, String brand, String knifeType, String steel, int stock, float price, String supplier, List<KnifeComment> comment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.brand = brand;
        this.knifeType = knifeType;
        this.steel = steel;
        this.stock = stock;
        this.price = price;
        this.supplier = supplier;
        this.comment = comment;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getKnifeType() {
        return knifeType;
    }

    public void setKnifeType(String knifeType) {
        this.knifeType = knifeType;
    }

    public String getSteel() {
        return steel;
    }

    public void setSteel(String steel) {
        this.steel = steel;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public List<KnifeComment> getComment() {
        return comment;
    }

    public void setComment(List<KnifeComment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Knife{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", brand='" + brand + '\'' +
                ", knifeType='" + knifeType + '\'' +
                ", steel='" + steel + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", supplier='" + supplier + '\'' +
                ", comment=" + comment +
                '}';
    }
}
