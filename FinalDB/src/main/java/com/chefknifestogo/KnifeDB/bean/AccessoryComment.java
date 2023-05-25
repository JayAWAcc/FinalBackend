package com.chefknifestogo.KnifeDB.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ACCESSORY_COMMENT")
public class AccessoryComment {
    @Id
    @SequenceGenerator(name = "comment_seq", sequenceName = "COMMENT_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "comment_seq", strategy = GenerationType.AUTO)
    private int id;
    @Column
    private float rating;
    @Column(name = "_comments")
    private String comments;
    @Column(name = "user_id")
    private int userid;

    @ManyToOne
    @JoinColumn(name="accessory_id",referencedColumnName = "id")
    private Accessory accessory;

    public AccessoryComment() {
    }

    public AccessoryComment(int id, float rating, String comments, int userid, Accessory accessory) {
        this.id = id;
        this.rating = rating;
        this.comments = comments;
        this.userid = userid;
        this.accessory = accessory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    @JsonIgnore
    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    @Override
    public String toString() {
        return "AccessoryComment{" +
                "id=" + id +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                ", userid=" + userid +
                ", accessory=" + accessory +
                '}';
    }
}
