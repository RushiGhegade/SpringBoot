package com.laibraryManagement.LaibraryManagementProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "BookShopsBooks")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    String name;
    int price;
    String author;
    int copies;

    public BookEntity() {
    }

    public BookEntity(int id, String name, int price, String author, int copies) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.copies = copies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
