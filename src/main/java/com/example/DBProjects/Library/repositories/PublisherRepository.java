package com.example.DBProjects.Library.repositories;

import com.example.DBProjects.Library.entities.Book;
import com.example.DBProjects.Library.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{

}
