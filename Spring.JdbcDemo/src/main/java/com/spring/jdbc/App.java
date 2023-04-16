package com.spring.jdbc;

import com.spring.jdbc.database.CustomerDB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println( "Hello World!" );
        CustomerDB cdb=context.getBean(CustomerDB.class);
        System.out.println(cdb.getTemplate());
        System.out.println(cdb.getCustomerCount());
        System.out.println(cdb.getCustomerByEmail("iam@a.com"));

    }
}
