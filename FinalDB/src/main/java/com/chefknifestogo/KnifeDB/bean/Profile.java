package com.chefknifestogo.KnifeDB.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USER_PROFILE")
public class Profile implements GrantedAuthority {
    @Id
    private int id;
    @Column
    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "profiles", fetch = FetchType.EAGER)
    private List<User> user= new ArrayList<User>();

    public Profile(int id) {
        this.id = id;
    }

    public Profile() {
    }

    public Profile(int id, String role, List<User> user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}
