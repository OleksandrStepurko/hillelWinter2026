package com.hillel.cw_10.task;

/*
Поиск пересечения двух массивов:

Напишите программу, которая находит пересечение двух массивов целых чисел, используя HashSet. Ваша
программа должна вернуть новый массив с элементами, которые присутствуют в обоих массивах.

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class task4 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr1 = {6,7,8,9,11,12,12};

        System.out.println(Arrays.toString(peresech(arr, arr1)));
    }

    public static Integer[] peresech(int[] a, int[] b){
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int i : a){
            set.add(i);
        }

        for (int i : b){
            if (set.contains(i)){
                result.add(i);
            }
        }

        Integer[] rez = new Integer[result.size()];
        int index = 0;
        for (int num : result){
            rez[index++] = num;
        }

        return rez;
    }

}
