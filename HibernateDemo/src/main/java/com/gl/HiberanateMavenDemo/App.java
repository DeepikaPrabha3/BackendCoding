package com.gl.HiberanateMavenDemo;

import com.gl.HibernateMavenDemo.entity.Author;
import com.gl.HibernateMavenDemo.entity.Employee;
import com.gl.com.gl.HibernateMavenDemo.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


/**
 * 1. Create  maven project --  quickstart
     * archetype -  templates
     * artifact id
     * group id
 * 2.  Add Hibernate and mysql dependency
 * 3. hibernate =>  needs connection parameters
     * hibernate.cfg.xml file => src/main/resources
     * Project => right click =>  Build Path => Configure Build Path
     * =>  Sources  tab =>  Add new folder => Create new folder => src/main/resources
 * 4. Mapping of java class with table  =>  need a class and add annotations
 * 5. Add Mapping <mapping> </mapping> tag for your class  in hibernate.cfg.xml file
 * 6. Load the configuration file hibernateConfig.java file
 *
 * Hibernate Architecture / API
 * Configuration  => Session Factory
 * SessionFactory => long lived and it is  available  1 per database
 * appn needs to connect  with more than  2 databases => 2 configuration  file
 * and 2 session  factory  objects
 * Session => short lived => created per db transaction
 * select => update =>  delete , should close them
 * Transaction
 */
public class App
{
    private static SessionFactory factory= HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Config Loaded" );
        Author a1=new Author("Shekar Shambu","Kids");
       /*System.out.println(insertAuthor(a1));
        System.out.println(a1);*/
           a1.setName("Shikar Sen ");
        a1.setAid(3);
/*
        System.out.println(updateAuthor(a1));
        deleteAuthor(a1);
        for (Author author:getAllAuthors()) {
            System.out.println(author);}*/
       /* System.out.println(getAuthorById(5));// if there is no ID present in table -- returns null
        System.out.println("---------------");
        System.out.println(loadAuthorById(5));*/// if there is no ID present in table -- throws exception
                                                        //Benefit of 'load'
                                                        //we need to use 'load' only when we are sure data exists

//'LazyInitializationException' - because it did not load the class
        Author author=getAuthorById(2);
        System.out.println(author.getAid());
        System.out.println("---------------");
       /* Author authorProxy=loadAuthorById(2000);
        System.out.println(authorProxy.getAid());*/
       // System.out.println(authorProxy.getName());
 /*     EmployeeApp ea=new EmployeeApp();
        Employee employee=new Employee("bpk@ac.in","bpk","8998");
        System.out.println(ea.insertEmployee(employee));
        employee.setEmployeeName("bindhu");
        employee.setPhone("898905");
        System.out.println(ea.updateEmployee(employee));
*/


    }
    public static int insertAuthor(Author author){
        //create a session
        //DML  commit => transaction
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(author);// newly created row will persist in DB // equivalent to save // returns void
        tx.commit();// associates ur author object to id // once u commit, it flushes the data and created the author id
        session.close();
        System.out.println(author);
        return author.getAid();
    }
    /*States of an Object
    1. Transient => newly created
    2. Persistent =>  save
    3. Detached => After you closed the session
    4. Difference betn merge and update -- update is deprecated

    */

    public static Author updateAuthor(Author author){
        //create a session
        //DML  commit => transaction
        //when we update , we basically update a detached object// so thats y merge
        //merge => will copy and covert to an update
        //so it will be in persistence state and return persistence instance but in detached state
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Author updatedAuthor=session.merge(author);// equivalent to update
        tx.commit();// associates ur author object to id // once u commit, it flushes the data and created the author id
        session.close();
        //System.out.println(author);
        return updatedAuthor;
    }
    //Delete
    public static void deleteAuthor(Author author){
        //create a session
        //DML  commit => transaction
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(author);// equivalent to update
        tx.commit();// associates ur author object to id // once u commit, it flushes the data and created the author id
        session.close();
        //System.out.println(author);

    }
    //Select
    public static Author getAuthorById(int authorId){
        //create a session
        //DML  commit => transaction
        Session session = factory.openSession();
        Author author= session.get(Author.class,authorId);
        session.close();
        //System.out.println(author);
        return author;
    }
    public static Author loadAuthorById(int authorId){
        //create a session
        //DML  commit => transaction
        Session session = factory.openSession();
        Author author=new Author();
        session.load(author,authorId);
        session.close();
        //System.out.println(author);
        return author;
    }
    //If you want to get List of Authors
    public static List<Author> getAllAuthors(){
        //create a session
        //DML  commit => transaction
        Session session = factory.openSession();
        List<Author> authors = session.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        session.close();
        return authors;
    }
}
