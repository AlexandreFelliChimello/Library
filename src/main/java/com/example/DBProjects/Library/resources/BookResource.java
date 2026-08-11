package com.example.DBProjects.Library.resources;

import com.example.DBProjects.Library.entities.Book;
import com.example.DBProjects.Library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookResource implements Serializable {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> books = service.findAll();
        return ResponseEntity.ok().body(books);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book book = service.findById(id);
        return ResponseEntity.ok().body(book);
    }
}
