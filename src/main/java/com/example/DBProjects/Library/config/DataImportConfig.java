package com.example.DBProjects.Library.config;

import com.example.DBProjects.Library.entities.Author;
import com.example.DBProjects.Library.entities.Publisher;
import com.example.DBProjects.Library.entities.enums.Dora;
import com.example.DBProjects.Library.repositories.AuthorRepository;
import com.example.DBProjects.Library.repositories.BookRepository;
import com.example.DBProjects.Library.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("test")
public class DataImportConfig implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        // É o dictionary do C#
        Map<String, Author> authorCache = new HashMap<>();
        Map<String, Publisher> publisherCache = new HashMap<>();

        InputStream publisherInputStream = getClass().getResourceAsStream("/publishers.txt");
        InputStream authorInputStream = getClass().getResourceAsStream("/authors.txt");
        InputStream bookInputStream = getClass().getResourceAsStream("/books.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(publisherInputStream, StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                //Se a linha estiver vazia, pule para a prx imediatamente
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(";");
                String publisherName = data[0].trim();
                String country = data[1].trim();

                Publisher publisher = publisherCache.computeIfAbsent(publisherName, name -> {
                    Publisher newPublisher = new Publisher(null, name, country);
                    return publisherRepository.save(newPublisher);
                });
            }
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(authorInputStream, StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                //Se a linha estiver vazia, pule para a prx imediatamente
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(";");
                String authorName = data[0].trim();
                Integer age = Integer.parseInt(data[1].trim());
                String country = data[2].trim();
                String doraTxt = data[3].trim();

                Dora dora = Dora.textOf(doraTxt);


                Author author = authorCache.computeIfAbsent(authorName, name -> {
                    Author newAuthor = new Author(null, name, age, country, dora);
                    return authorRepository.save(newAuthor);
                });
            }
        }
    }
}
