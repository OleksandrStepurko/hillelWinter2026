package com.hillel.cw_05.task;

import java.util.Arrays;

//Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива
//(пропусков быть не должно). 1 2 3 4 5 6 4 5 4 - (4) -> 1 2 3 5 6 5
public class NumberRemover {
    public static void main(String[] args) {

        int[] mass = {1, 2, 3, 4, 5, 6, 4, 5, 4};
        int value = 4;
        int write = 0;
        System.out.println(Arrays.toString(mass));
        for (int a : mass){
            if (a != value){
                mass[write++] = a;
            }
        }

        System.out.println(Arrays.toString(mass));
        mass = Arrays.copyOf(mass, write);
        System.out.println(Arrays.toString(mass));
    }
}
