package com.paazl.cases.test2;

import com.paazl.cases.common.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    /*
     * TODO
     * Implement a main method that is functionally identical to Test #1. In
     * this case, use a DeveloperFactory that is able to produce 3 types of
     * developers that implement a "print" method. The Factory should have a
     * create method that takes the user's score as an argument.
     */
    private static int scoreCounter = 0;
    private static int questionNumber = 1;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("To check your Java knowledge please answer all the questions.");
        Constants.QUESTIONS.entrySet().forEach(question -> {
            try {
                quizzer(question);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Developer developer = DeveloperFactory.createDeveloper(scoreCounter);
        System.out.println(developer.getDeveloperLevel());
    }

    private static void quizzer(Map.Entry<String, Character> question) throws IOException {
        System.out.println("Question №" + questionNumber + "\n" + question.getKey());
        questionNumber++;
        while (true) {
            System.out.println("Please input 'Y' or 'N'");
            String name = reader.readLine();
            if (name.equals("Y") || name.equals("N")) {
                validateAnswer(name, question.getValue().toString());
                break;
            }
        }
    }

    private static void validateAnswer(String answer, String correctAnswer) {
        if (answer.equals(correctAnswer)) {
            scoreCounter++;
        }
    }
}
