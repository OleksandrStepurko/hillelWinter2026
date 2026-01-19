package com.hillel.cw_09.ex;

public class Bonus1 {

    static int i;
    static int j;

    static Integer a;
    static Integer b;

    public static void main(String[] args) {
        i = 3;
        j = 6;
        a = 3;
        b = 6;
        run(i++, --j);
        System.out.println("---------------");
        runInteger(a++, --b);
    }

    private static void run(int x, int y) {
        System.out.println("i =  " + i); // 4
        System.out.println("j =  " + j); // 5
        System.out.println("x =  " + x); // 3
        System.out.println("y =  " + y); // 5
    }

    private static void runInteger(Integer x, Integer y) {
        System.out.println("i =  " + a); // 4
        System.out.println("j =  " + b); // 5
        System.out.println("x =  " + x); // 3
        System.out.println("y =  " + y); // 5
    }
}
