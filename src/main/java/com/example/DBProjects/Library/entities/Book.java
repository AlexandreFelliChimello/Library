package com.example.DBProjects.Library.entities;

import com.example.DBProjects.Library.entities.enums.Material;
import com.example.DBProjects.Library.entities.enums.Status;
import com.example.DBProjects.Library.entities.enums.Stock;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate publishDate;
    private Integer pages;
    private Double price;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private Integer status;
    private Integer stock;
    private Integer material;

    public Book(){}

    public Book(Long id, String title, LocalDate publishDate, Integer pages, Double price, Status status, Stock stock, Material material) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.pages = pages;
        this.price = price;
        setStatus(status);
        setStock(stock);
        setMaterial(material);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Status getStatus() {return Status.valueOf(status);}

    public void setStatus(Status status) {
        if (status != null){
            this.status = status.getCode();
        };
    }

    public Stock getStock() {
        return Stock.valueOf(stock);
    }

    public void setStock(Stock stock) {
        if (stock != null){
            this.stock = stock.getCode();
        };
    }

    public Material getMaterial() {
        return Material.valueOf(material);
    }

    public void setMaterial(Material material) {
        if (material != null){
            this.material = material.getCode();
        }
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @JsonIgnore
    public Set<Author> getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
