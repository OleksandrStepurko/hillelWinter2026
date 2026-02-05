package com.hillel.cw_14.funcInterface;

import java.util.function.Function;
/*
    Представляє функцію, яка приймає аргумент типу T і повертає результат типу R.
 */
public class FunctionExample {

    public static void main(String[] args) {
        Function<String, Integer> convertToInteger = Integer::valueOf; // <in, out>
        int result = convertToInteger.apply("123");
        System.out.println("Converter result: " + result);
    }

}
