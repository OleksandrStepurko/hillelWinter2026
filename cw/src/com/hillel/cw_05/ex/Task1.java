package com.hillel.cw_05.ex;

public class Task1 {
    public static void main(String[] args) {
        int a = 3;
        int b = a++ + ++a;
        System.out.println("a: " + a); // 5
        System.out.println("b: " + b); // 8
    }
}
