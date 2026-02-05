package com.hillel.cw_14.steams;

import java.util.List;
import java.util.function.Predicate;

public class TestStream {

    public static void main(String[] args) {
        List<String> ints = List.of("1","2","3","a","4","5");

        Predicate<String> isDigit = (s) -> {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException nfe){
                System.out.println("log: incorrect input value : " + s);
                return false;
            }

            return true;
        };
        ints.stream()
            .filter(isDigit)
            .map(Integer::parseInt)
            .forEach(System.out::println);
    }



}
