package com.example.projek.model;


import javax.persistence.*;

@Entity
@Table(name="divisi")
public class Divisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;

    public Divisi(Long id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Divisi() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
