package com.hillel.cw_07;

public class Remover {

    public static String handleData(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (String str : strs) {
            if (str.equals("onion")) {
                continue;
            }
            count++;
            stringBuilder.append("(").append(count).append(")")
                .append(str).append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] str = {"potato", "onion", "carrot"};

        System.out.println(handleData(str));
    }

}
