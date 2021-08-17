package com.paazl.cases.common;

import java.util.Map;

public class Constants {
    // You'll need these questions in tests 1-4
    public static final Map<String, Character> QUESTIONS = Map.ofEntries(
            Map.entry("A Thread is a process", 'N'),
            Map.entry("A List cannot contain duplicates", 'N'),
            Map.entry("A Set can contain duplicates", 'N'),
            Map.entry("Java is platform independent", 'Y'),
            Map.entry("Java supports copy constructors like C++", 'Y'),
            Map.entry("The primitive data types supported by the Java programming language are: byte, short, int, long, float, double, boolean, char", 'Y'),
            Map.entry("Constructor overloading is similar to method overloading in Java", 'N'),
            Map.entry("The purpose of garbage collection in Java is to reclaim and reuse objects which are no longer used", 'Y'),
            Map.entry("Autoboxing is the automatic conversion made by the Java compiler between the primitive types and their corresponding object wrapper classes", 'Y'),
            Map.entry("JDBC is an abstraction layer that allows users to choose between databases", 'Y'),
            Map.entry("Java supports the usage of pointers", 'N'));
}