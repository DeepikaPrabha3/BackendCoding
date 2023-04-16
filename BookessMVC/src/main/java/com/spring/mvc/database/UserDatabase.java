package com.spring.mvc.database;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDatabase {
    @Autowired
    private SessionFactory factory;
}
