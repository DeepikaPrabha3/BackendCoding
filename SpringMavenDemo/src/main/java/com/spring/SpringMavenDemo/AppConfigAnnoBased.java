package com.spring.SpringMavenDemo;

import com.spring.SpringMavenDemo.entity.Author;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.*;

@Configuration
@ComponentScan
public class AppConfigAnnoBased {

    /**
     * Suppose the class that we want to annotate the class that is in jar-- we cant modify the class in the jar right?
     * There we can do like below
     * Use @Bean => very common annotation
     * **/
    @Bean
    public Author author(){
        return new Author();
    }
    @Bean
    public List<String> getFruits()
    {
        return Arrays.asList("Grape","Musambi","Pomergranate");
    }
    @Bean
    public Set<Integer> getIds()
    {
        Set<Integer> ids=new HashSet<Integer>();
        ids.add(30);
        ids.add(31);
        ids.add(32);
        ids.add(33);
        return ids;
    }
    @Bean
    public Map<String,Integer> getMap()
    {
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("PK",30);
        map.put("UK",31);
        map.put("AK",32);
        map.put("MK",33);
        return map;
    }
    @Bean
    public List<Author> getAuthors()
    {
        return Arrays.asList(author());
    }


}
