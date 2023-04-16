package com.spring.SpringMavenDemo.band;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Singer {
    @Value("Arjit Singh")
    private String name;
    @Autowired
    @Qualifier("violin")
    private Instrument instrument;

    public Singer() {
    }

    public void display(){
        System.out.println("Singer - "+name+"is singing");
        instrument.play();
    }
}
