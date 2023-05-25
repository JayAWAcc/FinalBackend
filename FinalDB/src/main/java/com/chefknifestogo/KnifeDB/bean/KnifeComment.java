package com.chefknifestogo.KnifeDB.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="KNIFE_COMMENT")
public class KnifeComment {
    @Id
    @SequenceGenerator(name = "knife_comment_seq", sequenceName = "KNIFE_COMMENT_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "knife_comment_seq", strategy = GenerationType.AUTO)
    private int id;
    @Column
    private float rating;
    @Column(name = "_comments")
    private String comments;
    @Column(name = "user_id")
    private int userid;

    @ManyToOne
    @JoinColumn(name="knife_id",referencedColumnName = "id")
    private Knife knife;

    public KnifeComment() {
    }

    public KnifeComment(int id, float rating, String comments, int userid, Knife knife) {
        this.id = id;
        this.rating = rating;
        this.comments = comments;
        this.userid = userid;
        this.knife = knife;
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
    public Knife getKnife() {
        return knife;
    }

    public void setKnife(Knife knife) {
        this.knife = knife;
    }

    @Override
    public String toString() {
        return "KnifeComment{" +
                "id=" + id +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                ", userid=" + userid +
                ", knife=" + knife +
                '}';
    }
}
