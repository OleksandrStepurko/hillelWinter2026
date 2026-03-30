package com.hillel.cw_27.ex;

public class Ex2 {
    public static void main(String[] args) {
        int arr[] = {11, 22, 33};
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        int arrr[] = new int[3];
        int arrrr[] = {11, 22, 33}; // new array with values : 11 22 33

        int a[] = arrrr;
        for (int i = 0; i < arrr.length; i++)
            System.out.print(arrrr[i] + " ");
    }
}
