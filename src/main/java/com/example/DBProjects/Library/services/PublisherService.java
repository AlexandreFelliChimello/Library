package com.example.DBProjects.Library.services;

import com.example.DBProjects.Library.entities.Book;
import com.example.DBProjects.Library.entities.Publisher;
import com.example.DBProjects.Library.repositories.BookRepository;
import com.example.DBProjects.Library.repositories.PublisherRepository;
import com.example.DBProjects.Library.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService implements Serializable {

    @Autowired
    private PublisherRepository repository;

    public Publisher findById(Long id){
        Optional<Publisher> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Id not found"));

    }

    public List<Publisher> findAll(){ return repository.findAll();}
}
