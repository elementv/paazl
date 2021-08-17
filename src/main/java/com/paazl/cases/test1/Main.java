package com.paazl.cases.test1;

import com.paazl.cases.common.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


public class Main {

    private static int scoreCounter = 0;
    private static int questionNumber = 1;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /*
     * TODO
     * Implement the main method:
     * * Show the user the questions from Constants.QUESTIONS on a console and collect the answers.
     * * If the user scores 0-3 points, print "You are a junior Java developer".
     * * If the user scores 4-7 points, print "You are a medior Java developer".
     * * If the user scores 8-10 points, print "You are a senior Java developer".
     */

    /*
    DEV comment: there are 11 questions, so was decided in case of 11 right answers also choose
    "You are a senior Java developer".
     */

    public static void main(String[] args) {
        System.out.println("To check your Java knowledge please answer all the questions.");
        Constants.QUESTIONS.entrySet().forEach(question -> {
            try {
                quizzer(question);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(scoreDecider(scoreCounter));
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

    private static String scoreDecider(int score) {
        if (score >= 0 && score < 4) {
            return "You are a junior Java developer";
        }

        if (score >= 4 && score < 8) {
            return "You are a medior Java developer";
        }

        if (score >= 8 && score < 12) {
            return "You are a senior Java developer";
        }

        return "quiz is broken :(";
    }
}