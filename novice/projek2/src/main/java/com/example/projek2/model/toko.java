package com.example.projek2.model;


import javax.persistence.*;

@Entity
@Table(name="toko")
public class toko {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nama_toko;
    public String alamat_toko;
    public String jenis_toko;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlamat_toko() {
        return alamat_toko;
    }

    public void setAlamat_toko(String alamat_toko) {
        this.alamat_toko = alamat_toko;
    }

    public String getJenis_toko() {
        return jenis_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }

    public void setJenis_toko(String jenis_toko) {
        this.jenis_toko = jenis_toko;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    @Override
    public String toString(){
        return "id = " + id + ", nama_toko="+nama_toko+",alamat_toko="+alamat_toko+",jenis_toko"+jenis_toko;
    }
}
