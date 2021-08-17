package com.paazl.cases.test3;

import com.paazl.cases.test2.Developer;
import com.paazl.cases.test2.DeveloperFactory;

public class Main {
    /*
     * TODO
     * Implement a main method that is functionally identical to Test #2. In
     * this case, use a Singleton that poses the questions and gathers the answers.
     */
    public static void main(String[] args) {
        QuizService quizService = QuizService.getInstance();

        int developerScore = quizService.startQuiz();

        Developer developer = DeveloperFactory.createDeveloper(developerScore);

        System.out.println(developer.getDeveloperLevel());
    }
}