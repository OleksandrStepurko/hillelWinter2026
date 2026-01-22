package com.hillel.cw_10.task;

import java.util.Arrays;
import java.util.Stack;

/*
Реверс слов в предложении:

Например, "Hello World" станет "World Hello".
 */
public class task3 {

    public static void main(String[] args) {
        System.out.println(reverse("Hello World")); //stack

    }

    public static String reverse(String str) {

        String[] s = str.split(" ");

        Stack<String> stack = new Stack<>();

        stack.addAll(Arrays.stream(s).toList());

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
            if (!stack.isEmpty()){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
