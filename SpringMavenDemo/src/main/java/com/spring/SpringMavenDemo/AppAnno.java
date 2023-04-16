package com.spring.SpringMavenDemo;

import com.spring.SpringMavenDemo.entity.Author;
import com.spring.SpringMavenDemo.entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppAnno {
    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("spring-anno.xml");
        Author a1=context.getBean(Author.class);
        System.out.println(a1);
        //Spring will not automatically go and check for annotations in the bean class
        //Make some changes in spring-anno.xml

        Book b1=context.getBean(Book.class);
        System.out.println(b1);
    }
}
