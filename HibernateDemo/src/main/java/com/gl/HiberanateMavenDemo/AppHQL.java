package com.gl.HiberanateMavenDemo;

import com.gl.HibernateMavenDemo.entity.Author;
import com.gl.com.gl.HibernateMavenDemo.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AppHQL {
    private static SessionFactory factory= HibernateConfig.getSessionFactory();
    public static void main(String[] args) {
        Session session=factory.openSession();
        /*List<Author> authors = session.createQuery("from Author where genre=:genre and  year=:year",Author.class)
                        .setParameter("genre","IT")
                                .setParameter("year",2015)
                                        .getResultList();
        session.close();
        for (Author author:
             authors) {
            System.out.println(author);
        }*/
           Long count = session.createQuery("select count(*) from Author",Long.class).uniqueResult();
        session.close();
            System.out.println(count);
    }
}
