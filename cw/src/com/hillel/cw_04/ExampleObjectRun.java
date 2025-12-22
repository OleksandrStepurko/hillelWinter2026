package com.hillel.cw_04;

public class ExampleObjectRun {
    public static void main(String[] args) {

        Example e1 = new Example(12);

        System.out.println(e1.getClass().getName()); // getClass()

        System.out.println(e1.hashCode());
        System.out.println(e1.toString());
        Example e2 = new Example();
        System.out.println(e1.equals(e2)); // false (==)

        Example e3 = e1;
        System.out.println(e1.equals(e3)); // true
        System.out.println(e3.hashCode());
        System.out.println(e3.toString());

    }
}
