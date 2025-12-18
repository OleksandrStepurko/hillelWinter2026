package com.hillel.cw_03.ex;

// count sum of odd numbers 12235 - 1 + 3 + 5 = 9
public class ChetNumber {

    public static void main(String[] args) {
        int number = 12235;
        System.out.println(calculate(number));
    }

    private static int calculate(int value){
        int sum = 0;

        while (value > 0) {
            int digit = value % 10;

            if (digit % 2 != 0){
                sum += digit;
            }
            value /= 10;
        }

        return sum;
    }


}
