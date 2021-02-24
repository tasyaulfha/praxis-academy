package com.example.crud.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.crud.model.Books;
import com.example.crud.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

        public List<Books> getAllBooks(){            
            List<Books> books1 = new ArrayList<>();
            booksRepository.findAll().forEach(books1::add);
            return books1;
        }
        public Books getBooksById(Long id){
            Books books = booksRepository.findById(id).orElse(null);
            return books;
        }
        public Books addBooks(Books books) {
            booksRepository.save(books);
            return books;
        }
        public void delete(Long id){
            booksRepository.deleteById(id);
        }
        public Books updateBooks(Long id, Books books) {
            booksRepository.save(books);
            return books;
        }
}