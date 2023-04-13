package com.spring.SpringMavenDemo;

import com.spring.SpringMavenDemo.entity.Author;
import com.spring.SpringMavenDemo.entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        //This will create spring application context and load all the beans
        //specified in the xml file and intantiate them
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
        //ambiguity which author to choose
    /*Author author=context.getBean(Author.class);
    System.out.println(author);*/
        //By default spring creates single instance of a bean
        //singleton pattern
        Author author1= (Author) context.getBean("a1");
        System.out.println("1."+author1.getAname());
        Author author2= (Author) context.getBean("a2");
        System.out.println("2."+author2.getAname());

        //DEPENDENCY INJECTION -- WE WILL BE USING 'ref'
        Book book=context.getBean(Book.class);
        System.out.println(book);
    }

}
