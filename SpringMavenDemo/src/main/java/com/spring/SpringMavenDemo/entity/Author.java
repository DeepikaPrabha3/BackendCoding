package com.spring.SpringMavenDemo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Writer")
public class Author {
    //Injected the properties using Annotations
    //This is Field Injection
    @Value("101")
    private int  aid;
    @Value("Sreevidhya")
    private String aname;
    @Value("Motivation")
    private String genre;

    public Author() {
        System.out.println("Author Default Constructor");
    }

    public Author( @Value("101")int aid, @Value("Sreevidhya")String aname, @Value("Motivation")String genre) {
        System.out.println("Author Parameter Constructor");
        this.aid = aid;
        this.aname = aname;
        this.genre = genre;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Author{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
