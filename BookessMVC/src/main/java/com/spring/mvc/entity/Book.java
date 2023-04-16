package com.spring.mvc.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
    private boolean isBookMovedToReadLater;
    private boolean isBookLiked;
    @Autowired
    private User user;

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isBookMovedToReadLater() {
        return isBookMovedToReadLater;
    }

    public void setBookMovedToReadLater(boolean bookMovedToReadLater) {
        isBookMovedToReadLater = bookMovedToReadLater;
    }

    public boolean isBookLiked() {
        return isBookLiked;
    }

    public void setBookLiked(boolean bookLiked) {
        isBookLiked = bookLiked;
    }
}
