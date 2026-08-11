package com.example.DBProjects.Library.services;

import com.example.DBProjects.Library.entities.Book;
import com.example.DBProjects.Library.repositories.BookRepository;
import com.example.DBProjects.Library.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements Serializable {

    @Autowired
    private BookRepository repository;

    public Book findById(Long id){
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Id not found"));

    }

    public List<Book> findAll(){ return repository.findAll();}
}
