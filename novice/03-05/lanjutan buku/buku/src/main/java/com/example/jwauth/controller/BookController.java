package com.example.jwauth.controller;

import com.example.jwauth.model.Book;
import com.example.jwauth.security.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jwt")
public class BookController {
    public static final Logger logger= LoggerFactory.getLogger(BookController.class);
    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @PostMapping("/book/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Book addBook (@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @DeleteMapping ("/book/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }




}
