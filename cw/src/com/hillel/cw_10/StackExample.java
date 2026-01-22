package com.hillel.cw_10;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("stack size : " + stack.size());
        stack.push(1);
        stack.push(2);
        System.out.println("stack size : " + stack.size());

        System.out.println("peek value : " + stack.peek());
        System.out.println("stack size : " + stack.size());

        System.out.println("pop value : " + stack.pop());
        System.out.println("stack size : " + stack.size());
    }

}
