package com.hillel.cw_03.ex;

public class ArrMaxValue {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};

        // find max value and index
        int max = arr[0];
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
        System.out.println(max);

    }
}
