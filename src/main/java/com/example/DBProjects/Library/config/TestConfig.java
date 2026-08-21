package com.example.DBProjects.Library.config;

import com.example.DBProjects.Library.entities.Author;
import com.example.DBProjects.Library.entities.Book;
import com.example.DBProjects.Library.entities.enums.Material;
import com.example.DBProjects.Library.entities.enums.Status;
import com.example.DBProjects.Library.entities.enums.Stock;
import com.example.DBProjects.Library.repositories.AuthorRepository;
import com.example.DBProjects.Library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    BookRepository booksRepository;

    @Autowired
    AuthorRepository authorsRepository;

    @Override
    public void run(String... args) throws Exception {

        booksRepository.saveAll(List.of(

                new Book(null, "Cem Dias Entre Céu & Mar", LocalDate.of(2026, 7, 21), 216, 85.40, Status.NOT_READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Herói Invisível", LocalDate.of(1970, 1, 1), 168, 56.00, Status.NOT_READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Os Seis Finalistas", LocalDate.of(2018, 6, 12), 328, 43.87, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Um Passeio Aleatório por Wall Street", LocalDate.of(2021, 11, 17), 384, 71.43, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Código da Mente Extraordinária", LocalDate.of(2017, 9, 1), 304, 42.98, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Mude Seus Horários, Mude Sua Vida", LocalDate.of(2020, 1, 2), 240, 39.90, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Os Hábitos Secretos dos Gênios", LocalDate.of(2021, 4, 25), 336, 46.92, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Personal Branding", LocalDate.of(2015, 1, 1), 272, 79.90, Status.NOT_READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Quem Pensa Enriquece", LocalDate.of(2018, 5, 28), 368, 33.50, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Príncipe", LocalDate.of(2022, 1, 12), 96, 15.00, Status.NOT_READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Sapiens", LocalDate.of(2020, 11, 13), 472, 63.00, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Poder do Hábito", LocalDate.of(2012, 9, 24), 408, 55.90, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Mundo é Plano - Uma Breve História do Século XXI", LocalDate.of(2012, 9, 24), 560, 30.00, Status.NOT_READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Como Fazer Amigos e Influenciar Pessoas", LocalDate.of(2025, 12, 5), 240, 26.50, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "A Coragem de Ser Imperfeito", LocalDate.of(2016, 9, 19), 208, 44.90, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Tudo que Você Precisa Saber Sobre Economia", LocalDate.of(2017, 6, 1), 240, 54.04, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Mais Esperto Que o Diabo", LocalDate.of(2014, 7, 10), 208, 28.11, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Milagre da Manhã Para se Tornar um Milionário", LocalDate.of(2019, 3, 11), 238, 41.90, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Milagre da Manhã", LocalDate.of(2016, 7, 19), 196, 36.62, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Assassin's Creed: Bandeira Negra", LocalDate.of(2013, 11, 21), 336, 62.42, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Assassin's Creed: Renegado", LocalDate.of(2012, 11, 26), 350, 74.90, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Assassin's Creed: Revelações", LocalDate.of(2013, 3, 11), 392, 34.90, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Assassin's Creed: A Cruzada Secreta", LocalDate.of(2012, 9, 12), 418, 53.43, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Assassin's Creed: Irmandade", LocalDate.of(2012, 3, 12), 392, 20.00, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Assassin's Creed: Renascença", LocalDate.of(2011, 6, 29), 378, 63.92, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Assassin's Creed: Unity", LocalDate.of(2014, 10, 13), 364, 74.90, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Assassin's Creed: Submundo", LocalDate.of(2015, 11, 3), 364, 56.70, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Diário de Anne Frank", LocalDate.of(2014, 11, 10), 416, 81.01, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Cavaleiro Preso na Armadura", LocalDate.of(2020, 10, 5), 112, 26.26, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Uma Dobra no Tempo", LocalDate.of(2017, 11, 1), 240, 36.60, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "A Coragem de Ser Feliz", LocalDate.of(2020, 9, 15), 272, 36.48, Status.NOT_READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Felicidade Crônica", LocalDate.of(2014, 8, 8), 256, 54.60, Status.NOT_READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Alexandre O Grande", LocalDate.of(2017, 3, 6), 136, 43.55, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Napoleão Bonaparte", LocalDate.of(2017, 3, 6), 144, 49.90, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Gêngis Khan", LocalDate.of(2017, 3, 6), 136, 41.13, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "O Caso dos Exploradores de Caverna", LocalDate.of(2017, 3, 6), 96, 22.40, Status.READ, Stock.HAVE, Material.PHYSICAL),
        new Book(null, "Os Irmãos Karamázov", LocalDate.of(2021, 3, 15), 1254, 67.40, Status.READING, Stock.HAVE, Material.PHYSICAL)
        ));

    }
}
