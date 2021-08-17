package com.paazl.cases.test3;


import com.paazl.cases.common.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

class QuizService {
    private static QuizService INSTANCE;

    private static int scoreCounter = 0;
    private static int questionNumber = 1;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private QuizService() {
    }

    static QuizService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuizService();
        }

        return INSTANCE;
    }

    int startQuiz() {
        System.out.println("To check your Java knowledge please answer all the questions.");
        Constants.QUESTIONS.entrySet().forEach(question -> {
            try {
                quizzer(question);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return scoreCounter;
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