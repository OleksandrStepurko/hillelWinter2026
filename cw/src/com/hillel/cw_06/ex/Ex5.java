package com.hillel.cw_06.ex;

public class Ex5 {
    public static void main(String[] args) {
        int m = 9, n = 1, x = 0;
        while (m > n) {
            int a = 0; // new object
            Integer b = 10; // new object
            m--; // m = m - 1;
            n += 2; // n = n + 2;
            x += m + n; // x = x + m + n;

            System.out.println("m = " + m + ", n = " +n + ", x = " +x);
        }
        System.out.println(x);
    }
}
