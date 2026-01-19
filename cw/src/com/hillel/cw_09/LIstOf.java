package com.hillel.cw_09;

import java.util.List;

public class LIstOf {

    public static void main(String[] args) {
        List<String> str = List.of("1", "2"); // create immutable collection
        System.out.println(str.getClass().getSimpleName());

        str = List.of("1", "2", "1", "2"); // create immutable collection
        System.out.println(str.getClass().getSimpleName());

    }
}
