package com.chefknifestogo.KnifeDB.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class Image {

    @Id
    @SequenceGenerator(name="Image_seq",sequenceName = "image_seq",allocationSize = 1)
    @GeneratedValue(generator = "Image_seq" , strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String image;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JsonBackReference
    @JoinColumn(name="knife_id")
    private Knife knife;



    public Image() {
    }

    public Image(int id, Knife knife, String image) {
        this.id = id;
        this.knife = knife;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Knife getKnife() {
        return knife;
    }

    public void setKnife(Knife knife) {
        this.knife = knife;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", knife=" + knife +
                ", image='" + image + '\'' +
                '}';
    }
}
