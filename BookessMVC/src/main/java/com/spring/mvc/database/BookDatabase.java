package com.spring.mvc.database;

import com.spring.mvc.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDatabase {
    @Autowired
    public SessionFactory factory;
    public List<Book> getAllBooks()
    {
        Session session = factory.openSession();
        List<Book> tasks = session.createQuery("from Book", Book.class).getResultList();
        session.close();
        return tasks;
    }
}
