package com.example.DBProjects.Library.config;

import com.example.DBProjects.Library.entities.Book;
import com.example.DBProjects.Library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    BookRepository booksRepository;

    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book(null, "Cem Dias Entre Céu & Mar", LocalDate.of(2026, 7, 21), 216, 85.40);

        booksRepository.save(book1);



    }
}
