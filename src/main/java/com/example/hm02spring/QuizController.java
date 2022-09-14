package com.example.hm02spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;


@Component
public class QuizController {
    @Autowired
    private QuizView quizView;
    @Autowired
    private QuizModel quizModel;


    public void show() {
        try {
            quizView.start(quizModel.readQuizResource(), quizModel.readAnswerResource());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
