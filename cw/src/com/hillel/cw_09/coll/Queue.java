package com.hillel.cw_09.coll;

import java.util.ArrayDeque;

public class Queue {

    public static void main(String[] args) {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        arrayDeque.add("1");
        arrayDeque.add("2");
        arrayDeque.add("3");
        arrayDeque.add("4");

        System.out.println(arrayDeque);

        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque);

    }

}
