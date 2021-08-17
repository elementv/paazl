package com.paazl.cases.test2;

public class DeveloperFactory {
    public static Developer createDeveloper(int score) {
        if (score >= 0 && score < 4) {
            return new Developer("Junior Java developer");
        }

        if (score >= 4 && score < 8) {
            return new Developer("Medior Java developer");
        }

        if (score >= 8 && score < 12) {
            return new Developer("Senior Java developer");
        }

        return new Developer("Undefined developer");
    }
}