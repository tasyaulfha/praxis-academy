package com.example.jwauth.security.services;

import com.example.jwauth.model.Book;
import com.example.jwauth.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBook(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
    public Book getBook(Long id){
        Book book = bookRepository.findById(id).orElse(null);
        return book;
    }
    public Book updateBook(Long id, Book book){
        bookRepository.save(book);
        return book;
    }
    public Book deleteBook(Long id){
        Book book = bookRepository.findById(id).orElse(null);
        return book;
    }
    public Book addBook(Book book){
        bookRepository.save(book);
        return book;
    }

}
