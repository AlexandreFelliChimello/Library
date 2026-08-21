package com.example.DBProjects.Library.services;

import com.example.DBProjects.Library.entities.Author;
import com.example.DBProjects.Library.repositories.AuthorRepository;
import com.example.DBProjects.Library.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements Serializable {

    @Autowired
    private AuthorRepository repository;

    public Author findById(Long id){
        Optional<Author> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Id not found"));

    }
    public List<Author> findAll(){ return repository.findAll();}
}
