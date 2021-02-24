package com.example.crud.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="buku")
    public class Books{
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private long id;
        private String nama_buku;
        private String penulis;
        private String harga;
        
        public long getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public void setNama_buku(String nama_buku) {
            this.nama_buku = nama_buku;
        }
        public String getNama_buku() {
            return nama_buku;
        }
        public void setPenulis(String penulis) {
            this.penulis = penulis;
        }
        public String getPenulis() {
            return penulis;
        }
        public void setHarga(String harga) {
            this.harga = harga;
        }
        public String getHarga() {
            return harga;
        }
    }