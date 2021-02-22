package com.example.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
    public class Books{
        @Id
        @Column
        private int bookid;
        @Column
        private String nama_buku;
        @Column
        private String penulis;
        @Column
        private String harga;
        public int getBookid() {
            return bookid;
        }
        public void setBookid(int bookid) {
            this.bookid = bookid;
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