package com.spring.SpringMavenDemo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    //For Annotation Based - the property thats primitive --to inject value - use @Value
    @Value("1090")
    private int bid;
    @Value("Jab Rishi Met Dimple")
    private String bname;
    @Value("879.50")
    private double price;
    //The book class has 'Author' as a reference. It is a 'has a ' Relationship
    //While Using Annotation Method for Spring - for object based property we cant use @Value , hence use @Autowired
    @Autowired
    private Author author;
    public Book() {
        System.out.println("Book Default Constructor");
    }

    public Book(int bid, String bname, double price) {
        System.out.println("Book Parameter Constructor");
        this.bid = bid;
        this.bname = bname;
        this.price = price;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
