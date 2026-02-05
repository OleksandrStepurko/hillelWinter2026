package com.hillel.cw_14.steams;

import java.util.List;

public class SkipLimitStream {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,3,4,5,6,7,8,9,10);

        ints.stream()
                .limit(15)
                .skip(1)
                .filter(i -> i % 2 == 0)
                .map(i -> i*i)
                .forEach(i -> System.out.print(i + " "));
    }
}
