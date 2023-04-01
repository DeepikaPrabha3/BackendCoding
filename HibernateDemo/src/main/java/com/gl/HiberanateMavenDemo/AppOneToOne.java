package com.gl.HiberanateMavenDemo;

import com.gl.HibernateMavenDemo.entity.Employee;
import com.gl.HibernateMavenDemo.entity.Identification;
import com.gl.com.gl.HibernateMavenDemo.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AppOneToOne {
    private static SessionFactory factory= HibernateConfig.getSessionFactory();
    public static void main(String[] args) {
        Session session=factory.openSession();
        Employee emp=session.get(Employee.class,"dpk@ac.in");
        session.close();
        System.out.println(emp.getEmailId());
        System.out.println(emp.getEmployeeName());
        System.out.println(emp.getIdentification().getFullname());

        session=factory.openSession();
        Identification ob=session.get(Identification.class,"B003");
        session.close();
        System.out.println(ob.getBdate());
        System.out.println(ob.getFullname());
        //System.out.println(ob.getEmployee().getEmail()); --- This is not possible as the relation is unidirectional
        //hence we need to make it bidirectional
        //by making the reverse relationship in Identitification table
        System.out.println(ob.getEmp().getEmailId());


    }
}
