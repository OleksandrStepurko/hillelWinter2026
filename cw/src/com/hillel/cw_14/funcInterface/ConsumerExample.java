package com.hillel.cw_14.funcInterface;

import java.util.function.Consumer;
/*
    Представляє споживача (споживача значення), який приймає аргумент типу T і не повертає результат.
 */
public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> toUpperCaseConsumer = s -> System.out.println(s.toUpperCase());
        toUpperCaseConsumer.accept("Hello, World!");

        toUpperCaseConsumer = s -> System.out.println(s.toLowerCase());
        toUpperCaseConsumer.accept("Hello, World!");
    }

}
