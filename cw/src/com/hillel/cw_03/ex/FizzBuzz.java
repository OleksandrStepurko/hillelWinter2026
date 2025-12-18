package com.hillel.cw_03.ex;


/*
Write a program that prints the numbers from 1 to 100.
    For multiples of 3, print "Fizz" instead of the number
    For multiples of 5, print "Buzz" instead of the number
    For numbers which are multiples of both 3 and 5, print "FizzBuzz"
    Otherwise, print the number itself
 */
public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            }
            else if (i % 3 == 0) {
                System.out.print("Fizz ");
            }
            else if (i % 5 == 0) {
                System.out.print("Buzz" );
            }
            else {
                System.out.print(i + " ");
            }
        }
    }

}
