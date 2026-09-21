package com.example.DBProjects.Library.config;

import com.example.DBProjects.Library.entities.Author;
import com.example.DBProjects.Library.entities.Book;
import com.example.DBProjects.Library.entities.Publisher;
import com.example.DBProjects.Library.entities.enums.Dora;
import com.example.DBProjects.Library.repositories.AuthorRepository;
import com.example.DBProjects.Library.repositories.BookRepository;
import com.example.DBProjects.Library.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//Avisa que este arquivo contém configurações da aplicação (n vai ser ignorado pelo spring)
@Configuration

@Profile("test")
@Order(2)
//Ao iniciar o programa, o Spring procuro todas as classes que contém "Command Line Ruunner" e executa run() automaticamente
public class DataImportConfig implements CommandLineRunner {

    // Ei Spring, pegue a instância pronta do BookRepository e injete nesta variavel aqui
    // (BookRepository bookRepository = new BookRepositoryImpl(); Modo antigo)
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    // Avisa o Spring para manter a execução com o DB até o final do run() (E faz o RollBack caso algo der errado)
    @Transactional
    public void run(String... args) throws Exception {

        // É o dictionary do C#
        Map<String, Author> authorCache = new HashMap<>();
        Map<String, Publisher> publisherCache = new HashMap<>();
        //Abre uma conexão de leitura de fluxo de bytes (InputStream) diretamente do arquivo publishers.txt que está dentro da pasta de recursos do projeto.
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

                // "Compute (crie/calcule) se estiver ausente (absent)"
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

                Dora dora = Dora.textOf(doraTxt.toUpperCase());

                Author author = authorCache.computeIfAbsent(authorName, name -> {
                    Author newAuthor = new Author(null, name, age, country, dora);
                    return authorRepository.save(newAuthor);
                });
            }
        }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(bookInputStream, StandardCharsets.UTF_8))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    //Se a linha estiver vazia, pule para a prx imediatamente
                    if (line.trim().isEmpty()) continue;

                    String[] data = line.split(";");
                    String bookTitle = data[0].trim();
                    String publisherName = data[1].trim();
                    String authorName = data[2].trim();

                    Optional<Book> bookSearch = bookRepository.findByTitleIgnoreCase(bookTitle);
                    Optional<Author> authorSearch = authorRepository.findByNameIgnoreCase(authorName);
                    Optional<Publisher> publisherSearch = publisherRepository.findByNameIgnoreCase(publisherName);

                    if (bookSearch.isPresent()){
                        Book book = bookSearch.get();

                        authorSearch.ifPresent(author -> book.getAuthors().add(author));
                        publisherSearch.ifPresent(book::setPublisher);

                        bookRepository.save(book);
                    }
                    };
                }
        }
    }
