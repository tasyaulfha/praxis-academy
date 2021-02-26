package com.example.jwauth.model;


import javax.persistence.*;

@Entity
@Table(name="penulis")
public class Penulis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="book_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Book book;
    private Long book_id;

    private String nama;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getBook_id() {
        return book_id;
    }
}
