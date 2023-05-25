package com.chefknifestogo.KnifeDB.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="USERS")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name="knife_user_seq_gen",sequenceName = "KNIFE_USER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "knife_user_seq_gen", strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinTable(
            name="KNIFE_USER_KNIFE_PROFILE",
            joinColumns = {
                    @JoinColumn(name="USER_ID",referencedColumnName = "ID")

            },
            inverseJoinColumns = {
                    @JoinColumn(name="USER_PROFILE_ID", referencedColumnName = "ID")
            }

    )

    private List<Profile> profiles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return profiles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    public User() {
    }

    public User(int id, String username, String password, List<Profile> profiles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.profiles = profiles;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profiles=" + profiles +
                '}';
    }
}
