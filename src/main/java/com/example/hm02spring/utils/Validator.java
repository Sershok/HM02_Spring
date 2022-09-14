package com.example.hm02spring.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

    public static String validateSTR(Scanner sc) {
        String str = sc.nextLine().trim();
        while (str.isEmpty()) {
            System.out.print(Constants.EMPTY_NAME_MSG);
            str = sc.nextLine().trim();
        }
        return str;
    }

    public static int validateNumber(Scanner scanner) {

        int number;
        String str1 = null;

        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf(Constants.NAN_NUMBER_MSG, str);
        }
        number = scanner.nextInt();
        while (number <= 0) {
            System.out.println(Constants.INCORRECT_NUMBER_MSG);
            while (!scanner.hasNextInt()) {
                try {
                    str1 = scanner.next().trim();
                } catch (InputMismatchException ime) {
                    System.out.printf(Constants.NAN_NUMBER_MSG, str1);
                }
            }
            number = scanner.nextInt();
        }
        return number;
    }

}