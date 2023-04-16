package com.spring.SpringMavenDemo;

import com.spring.SpringMavenDemo.band.Singer;
import com.spring.SpringMavenDemo.entity.Author;
import com.spring.SpringMavenDemo.entity.Book;
import com.spring.SpringMavenDemo.entity.CollectionsDemo;
import com.spring.SpringMavenDemo.events.EmployeePublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
   This file show if we want to replace the xml with java based configuration
   @Configuration class - basically tells spring the corresponding the java class on which this annotation is used
   represents spring configuration
   We need to tell in xml file => which all java classes to be scanned
   ComponentScan - use this => after which we cant use ApplicationContext
*/
/*@Configuration
@ComponentScan*/
public class AppAnnotationJavaBasedConfig {
    public static void main(String[] args) {

        /*ApplicationContext context=new ClassPathXmlApplicationContext("spring-anno.xml");*/
        //Java Based Confg file can be use anywhere not only in 'main' => It can be anywhere
        /*AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppAnnotationJavaBasedConfig.class);*/
        //the @Configuration and @Component can be on a different config file and we can even load that file as shown below
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfigAnnoBased.class);
      /*  for(String bean:context.getBeanDefinitionNames())
        {
            System.out.println(bean);
        }*/
        CollectionsDemo demo=context.getBean(CollectionsDemo.class);
/*        System.out.println(demo.getAuthors());
        System.out.println(demo.getFruits());
        System.out.println(demo.getMap());
        System.out.println(demo.getIds());*/
        /*Author a1=context.getBean(Author.class);
        System.out.println(a1);

        Book b1=context.getBean(Book.class);
        System.out.println(b1);
        Singer singer=context.getBean(Singer.class);
        singer.display();*/

        EmployeePublisher publisher=context.getBean(EmployeePublisher.class);
        publisher.createNewEmployee();
        context.registerShutdownHook();
    }
}
/**
 *          Task
 * 1. Create an Interface Instrument => void play()
 * Creates 2 classes  Guitar and Violin that implements Instrument Interface
 * 2. Create a class Singer with following members --
 * String name
 * Instrument instrument
 *
 * details(){
 *     //display the name of the current singer
 *     //and the  instrument  is playing => instrument.play()
 * }
 * **/