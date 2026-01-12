package com.hillel.cw_07.task;

public class TextToCamelCase {

    public static void main(String[] args) {
        System.out.println(toCamelCase("to camel case"));
        System.out.println(toCamelCase("to caMel case"));
        System.out.println(toCamelCase("tO cAmel caSe"));

    }

    public static String toCamelCase(String input){
        String[] str = input.trim().toString().split(" ");
        StringBuilder result = new StringBuilder(str[0].toLowerCase());
        for (int i = 1; i < str.length; i++){
            String w = str[i];
            if (!w.isEmpty()){
                result
                    .append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1).toLowerCase());
            }
        }


        return result.toString();
    }

}
