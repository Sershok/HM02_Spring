package com.example.hm02spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationConfig.class);


        QuizController quizController = ctx.getBean(QuizController.class);

        quizController.show();
    }
}
