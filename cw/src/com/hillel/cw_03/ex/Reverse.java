package com.hillel.cw_03.ex;


import java.util.Arrays;

// reverse number 111112344 - 443211111
public class Reverse {
    public static void main(String[] args) {
        reverse("123456");

    }

    private static void reverse(String string) {
        char[] chars = string.toCharArray();
        for (int i = chars.length/2 - 1; i >= 0; i--) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(chars));
    }

}


