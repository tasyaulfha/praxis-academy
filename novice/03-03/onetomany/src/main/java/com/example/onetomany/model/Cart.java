package com.example.onetomany.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="CART")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "cart")
    private Set<Items> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    public Set<Items> getItems() {
        return items;
    }

}
