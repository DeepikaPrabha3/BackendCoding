package com.gl.HiberanateMavenDemo;

import com.gl.HibernateMavenDemo.entity.Author;
import com.gl.HibernateMavenDemo.entity.Employee;
import com.gl.com.gl.HibernateMavenDemo.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeApp {
    private static SessionFactory factory= HibernateConfig.getSessionFactory();
    public static String insertEmployee(Employee employee){
        //create a session
        //DML  commit => transaction
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employee);// newly created row will persist in DB // equivalent to save // returns void
        tx.commit();// associates ur employee object to id // once u commit, it flushes the data and created the author id
        session.close();
        System.out.println(employee);
        return employee.getEmailId();
    }
    /*States of an Object
    1. Transient => newly created
    2. Persistent =>  save
    3. Detached => After you closed the session
    4. Difference betn merge and update -- update is deprecated

    */

    public static Employee updateEmployee(Employee employee){
        //create a session
        //DML  commit => transaction
        //when we update , we basically update a detached object// so thats y merge
        //merge => will copy and covert to an update
        //so it will be in persistence state and return persistence instance but in detached state
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Employee updatedEmployee=session.merge(employee);// equivalent to update
        tx.commit();// associates ur employee object to id // once u commit, it flushes the data and created the author id
        session.close();
        //System.out.println(employee);
        return updatedEmployee;
    }
    //Delete
    public static void deleteEmployee(Employee employee){
        //create a session
        //DML  commit => transaction
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(employee);// equivalent to update
        tx.commit();// associates ur author object to id // once u commit, it flushes the data and created the author id
        session.close();
        //System.out.println(author);

    }
    //Select
    public static Employee getEmployeeByEmailId(String emailId){
        //create a session
        //DML  commit => transaction
        Session session = factory.openSession();
        Employee employee= session.get(Employee.class,emailId);
        session.close();
        //System.out.println(author);
        return employee;
    }
    //If you want to get List of Authors
    public static List<Employee> getAllEmployees(){
        //create a session
        //DML  commit => transaction
        Session session = factory.openSession();
        List<Employee> employee = session.createQuery("SELECT a FROM Employee a", Employee.class).getResultList();
        session.close();
        return employee;
    }
}
