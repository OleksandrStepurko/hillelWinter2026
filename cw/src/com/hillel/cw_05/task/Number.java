package com.hillel.cw_05.task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number {
    /*
       Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
     */
    public static void main(String[] args) {
        int[] mass = {1123, 4526, 7789, 112, 334, 9876, 10203, 111, 909, 321};
        for (int e : mass){
            if (hisUniqueSet(e)){
                System.out.println(e);
                break;
            }
        }
    }

    private static boolean hisUnique(int number) {
        boolean[] isUnique = new boolean[10]; // 0 .. 9
        while (number > 0) {
            int remainder = number % 10;
            if (isUnique[remainder]) {
                return false;
            }
            isUnique[remainder] = true;
            number /= 10;
        }
        return true;
    }

    private static boolean hisUniqueSet(int number) {
        String str = Integer.toString(number);
        List digits = Arrays.stream(str.split("")).toList();
        System.out.println(digits);
        Set result = new HashSet(digits); // only unique
        return digits.size() == result.size();

    }
}
