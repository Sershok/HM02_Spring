package com.example.hm02spring;

import com.example.hm02spring.utils.Constants;
import com.example.hm02spring.utils.Validator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

@Setter
@Getter
@Component
public class QuizView {

    static Scanner sc;
    String title;
    @Autowired
    private Person person;
    @Autowired
    private QuizModel quizModel;



    static String[] bundleMsg = {Constants.BUNDLE_MSG, Constants.BUNDLE_MSG_EN, Constants.BUNDLE_MSG_IT};

    static ResourceBundle resourceBundle;

    static public int inputSetting() {
        sc = new Scanner(System.in);

        System.out.println("Choice language\n" +
                "1: Ukrainian\n" +
                "2: English\n" +
                "3: Italian");
        int language = 3;
        language = Validator.validateNumber(sc);
        resourceBundle = ResourceBundle.getBundle(bundleMsg[language - 1]);

        return language;


    }

    public void inputName() {
        sc = new Scanner(System.in);

        System.out.println(new String(resourceBundle.getString("greetings").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));

        person.setFirstName(Validator.validateSTR(sc));

        System.out.println(new String(resourceBundle.getString("InputLName").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));

        person.setLastName(Validator.validateSTR(sc));

        System.out.println(new String(resourceBundle.getString("gameAlert").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));


    }

    public void start(List<String> list, List<String> answerList) throws UnsupportedEncodingException {
        inputName();
        int cntList = 1;
        int score = 0;


        for (int i = 0; i < list.size(); i++) {

            int finalCntList = cntList;
            list.stream()
                    .filter(str -> str.startsWith(String.valueOf(finalCntList)))
                    .forEach(System.out::println);

            if (answerList.contains(cntList + " - " + inputAnswer())) {
                score++;
                System.out.println(new String(resourceBundle.getString("correctAnswer").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + score + "\n");

            } else
                System.out.println(new String(resourceBundle.getString("incorrectAnswer").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + score + "\n");

            cntList++;
        }
        showRes(score);
    }

    public int inputAnswer() {
        sc = new Scanner(System.in);
        System.out.println(new String(resourceBundle.getString("choice").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        return Validator.validateNumber(sc);
    }

    public void showRes(int score) {
        String res = new String(resourceBundle.getString("gameAlertEnd").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + person.getFirstName() + " " + person.getLastName()
                + new String(resourceBundle.getString("score").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + score;

        System.out.println(res);
    }

}
