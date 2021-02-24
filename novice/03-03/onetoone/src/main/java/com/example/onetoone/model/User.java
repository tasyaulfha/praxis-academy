package com.example.onetoone.model;


import javax.persistence.*;
import com.example.onetoone.model.Address;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", referencedColumnName = "id",insertable =false, updatable = false)
    private  Address address;
    private Long address_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public Long getAddress_id() {
        return address_id;
    }
}
