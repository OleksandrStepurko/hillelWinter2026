package com.hillel.cw_02;

public class InitVar {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);

        double d;

//
//        byte b = (byte) valueCalculate();
//
//        System.out.println(a);
//        System.out.println(b);
//
//        a = 35;
//        System.out.println(a);

        d = 3;

        System.out.println(d);

        int d1 = (int) d; // double -->  int

        System.out.println(d1);

        long l = 10L;
        Long lng = 20L;
        Double dbl = 10d;
        var f = 10_000_000_000L; // var == double

        // var --> Double

//        System.out.println(f instanceof Long);

     }

    static int valueCalculate(){
        return 130;
    }
}
