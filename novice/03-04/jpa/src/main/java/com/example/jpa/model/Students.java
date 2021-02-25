package com.example.jpa.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(targetEntity=Library.class)
    private List pinjam_buku;

    public List getPinjam_buku() {
        return pinjam_buku;
    }

    public void setPinjam_buku(List pinjam_buku) {
        this.pinjam_buku = pinjam_buku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
