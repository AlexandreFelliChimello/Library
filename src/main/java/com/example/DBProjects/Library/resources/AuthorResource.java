package com.example.DBProjects.Library.resources;

import com.example.DBProjects.Library.entities.Author;
import com.example.DBProjects.Library.entities.Author;
import com.example.DBProjects.Library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorResource implements Serializable {

    @Autowired
    private AuthorService service;

    @GetMapping
    public ResponseEntity<List<Author>> findAll(){
        List<Author> authors = service.findAll();
        return ResponseEntity.ok().body(authors);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        Author author = service.findById(id);
        return ResponseEntity.ok().body(author);
    }
}
