package com.hillel.cw_04;

public class ExampleObjectOverRun {
    public static void main(String[] args) {

        ExampleOver e1 = new ExampleOver(12);

        System.out.println(e1.getClass().getName()); // getClass()

        System.out.println(e1.hashCode());
        System.out.println(e1.toString());
        ExampleOver e2 = new ExampleOver(12);
        System.out.println(e1.equals(e2)); // true (==)


    }
}
