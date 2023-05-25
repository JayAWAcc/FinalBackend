package com.chefknifestogo.KnifeDB.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "ACCESSORY_TO_TYPE")
public class AccessoryToType {

    @Id
    @SequenceGenerator(name="accessory_to_type_seq_gen", sequenceName = "ACCESSORY_TO_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "accessory_to_type_seq_gen", strategy = GenerationType.AUTO)
    private int id;

    @JsonBackReference
    @ManyToOne(fetch =FetchType.EAGER , cascade = CascadeType.DETACH)
    private Accessory accessory;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.DETACH)
    private AccessoryType type;

    public AccessoryToType() {
    }

    public AccessoryToType(int id, Accessory accessory, AccessoryType type) {
        this.id = id;
        this.accessory = accessory;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public AccessoryType getType() {
        return type;
    }

    public void setType(AccessoryType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AccessoryToType{" +
                "id=" + id +
                ", accessory=" + accessory +
                ", type=" + type +
                '}';
    }
}
