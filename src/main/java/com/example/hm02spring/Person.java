package com.example.hm02spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Person {

    private String firstName;
    private String lastName;

}
