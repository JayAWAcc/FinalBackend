package com.chefknifestogo.KnifeDB.bean;

import javax.persistence.*;

@Entity
@Table(name = "ACCESSORY_TYPE")
public class AccessoryType {
    @Id
    @SequenceGenerator(name="type_seq_gen",sequenceName = "ACCESSORY_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "type_seq_gen",strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String type;

    public AccessoryType() {
    }

    public AccessoryType(String type) {
        this.type = type;
    }

    public AccessoryType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AccessoryType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
