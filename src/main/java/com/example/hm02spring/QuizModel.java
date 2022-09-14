package com.example.hm02spring;


import com.example.hm02spring.utils.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

import static com.example.hm02spring.QuizView.inputSetting;


@Getter
@Setter
@Component
public class QuizModel {


    private List<String> quizList = new ArrayList<>();
    private QuizView quizView;

    @Autowired
    private QuizModel(QuizView quizView) {
        this.quizView = quizView;
    }

    private List<String> answerQuizList = new ArrayList<>();

    private FileReader file;
    private String[] languages = {Constants.RES_QUIZ_UA, Constants.RES_QUIZ_EN, Constants.RES_QUIZ_IT};

    public List<String> readQuizResource() {



        try (BufferedReader br = new BufferedReader(
                new FileReader(languages[inputSetting() - 1]))) {

            String values;

            while ((values = br.readLine()) != null) {

                quizList.add(values);

            }
        } catch (IOException e) {
            System.err.println("Error!!!!!");
        }
        return quizList;
    }

    public List<String> readAnswerResource() {
        try (BufferedReader br = new BufferedReader(
                new FileReader(Constants.RES_ANSWER))) {
            String values;
            while ((values = br.readLine()) != null) {
                answerQuizList.add(values);
            }

        } catch (IOException e) {
            System.err.println("Error!!!!!");
        }

        return answerQuizList;
    }
}





