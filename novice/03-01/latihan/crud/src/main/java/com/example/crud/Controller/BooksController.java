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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="buku")
public class BooksController{

    @Autowired  
    BooksService booksService; 

    @GetMapping(path="/getBuku")
    private List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }
    @GetMapping(path="/getBuku/{id}")
    public Books getBooks(@PathVariable Long id) {
        return booksService.getBooksById(id);
    }
    @DeleteMapping(path="/delete/{id}")
    private void deleteBook(@PathVariable Long bookid)
    {
        booksService.delete(id);
    }
    @PostMapping(path="/add")
    public Books addBooks(@RequestBody Books books) {
        return booksService.addBooks(books);
    }

}