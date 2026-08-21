package com.example.DBProjects.Library.resources;

import com.example.DBProjects.Library.entities.Author;
import com.example.DBProjects.Library.entities.Publisher;
import com.example.DBProjects.Library.services.AuthorService;
import com.example.DBProjects.Library.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherResource implements Serializable {

    @Autowired
    private PublisherService service;

    @GetMapping
    public ResponseEntity<List<Publisher>> findAll(){
        List<Publisher> publishers = service.findAll();
        return ResponseEntity.ok().body(publishers);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable Long id){
        Publisher publisher = service.findById(id);
        return ResponseEntity.ok().body(publisher);
    }
}
