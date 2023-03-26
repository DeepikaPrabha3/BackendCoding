package com.gl.HibernateMavenDemo.entity;

import jakarta.persistence.*;

//author is a database managed entity
@Entity //This annotation tells Hibernate that this class needs to be mapped to database table . By Default - the table anme is the same as class name. If you want to cahnge the table name.
@Table(name = "author")
public class Author {
    //we need to tell hibernate that out of these 3 columns which is the priority
    @Id //This tells hibernate that this aid is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Used INCREMENT -FOR AID VALUE : Since the aid value is not passed through constructor, strategy tells the hibernate that aid value is generated using increment
    @Column(name = "authorid")
    private int  aid;
    @Column(name="authorname",length = 120, nullable = false)//i need the author name , it cant be null
    private String name;
    private String genre;

    //Therefore Hiberanate helps us to use many functionalities using annotations
    public Author() {
    }

    public Author(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Author{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
