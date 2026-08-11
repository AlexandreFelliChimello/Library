package com.example.DBProjects.Library.repositories;

import com.example.DBProjects.Library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
