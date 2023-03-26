package com.spring.SpringMavenDemo;

import com.spring.SpringMavenDemo.entity.Author;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. QuickStart maven project
 * 2. Add  spring-context  maven dependency in pom.xml  file
 * 3.  do change java version  in pom.xml
 * 4. create a bean( In spring, every class is a bean
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //create the spring application  context  and load all the beans
        //specified the  xml  file and  instantiate them
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
        /*Author author = context.getBean(Author.class);
        System.out.println(author);*/
        Author author1 = (Author) context.getBean("a1");
        System.out.println(author1);
        Author author2 = (Author) context.getBean("a2");
        System.out.println(author2);

    }
}
