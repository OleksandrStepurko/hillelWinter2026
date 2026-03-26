package com.hillel.cw_26.ex;

import java.util.List;

public class ex3 {
    public static void main(String[] args) {
        var list = List.of(
                new String[]{"A", "BB", "CCC"}, // 3
                new String[]{"DD", "E"}         // 2
        );
        list.forEach(x ->
                System.out.print(x.length));
    }
}
