package com.example.hm02spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ComponentScan
public class MyApplicationConfig {


    @Bean
    public Person person() {
        return new Person();
    }


}
