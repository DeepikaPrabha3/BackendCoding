package com.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class AppConfig {
    /**
     * The below method Provides  functionalities to inject the datasource communication details
     * Using @Bean => because DriverManagerSource is a .class file meaning inside the jdbc.datasource jar
     * @return
     * @Bean Anntoation - is used on the class that you want to inject dependency for
     * The moment @Bean and @Autowired is called => jdbc template is injected
     * Setter Injection => Template is injected
     * */
    @Bean
    public DataSource datasource(){
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/gl2023");
        ds.setUsername("root");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory()
    {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(datasource());
        sessionFactoryBean.setPackagesToScan("com.spring.jdbc.entity");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        System.out.println("session factory created");
        return sessionFactoryBean;
    }
//	@Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//		System.out.println("tx manager");
//        HibernateTransactionManager transactionManager
//          = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFactory().getObject());
//        System.out.println(transactionManager);
//        return transactionManager;
//    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        return hibernateProperties;
    }

    @Bean
    @Autowired
    public JdbcTemplate template(DataSource source){
        System.out.println("Template Created");
        return new JdbcTemplate(source);
    }
}
