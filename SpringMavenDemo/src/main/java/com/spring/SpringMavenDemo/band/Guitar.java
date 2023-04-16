package com.spring.SpringMavenDemo.band;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Guitar implements Instrument{
    @Override
    public void play() {
        System.out.println("The instrument is Guitar");
    }
}
