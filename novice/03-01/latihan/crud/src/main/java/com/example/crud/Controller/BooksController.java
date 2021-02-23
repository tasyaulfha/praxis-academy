package com.example.crud.Controller;

import java.util.List;

import com.example.crud.Service.BooksService;
import com.example.crud.model.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BooksController{
    @Autowired
    BooksService booksService;
    @GetMapping(path="/buku")
    private List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }
    @GetMapping(path="/get/{bukuid}")
    private Books getBooks(@PathVariable("bookid" ) int bookid){
        return booksService.getBooksById(bookid);
    }
    @DeleteMapping(path="/delete/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid)
    {
        booksService.delete(bookid);
    }
    @PostMapping(path="/post")
    private Books update(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books;
    }

}