package com.example.onetomany.model;


import javax.persistence.*;

@Entity
@Table(name="ITEMS")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;
    public Items(){}

    public Items(Cart c){
        this.cart =c;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
