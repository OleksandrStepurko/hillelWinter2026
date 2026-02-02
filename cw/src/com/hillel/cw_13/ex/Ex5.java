package com.hillel.cw_13.ex;

public class Ex5 {
    public static void main(String[] args) {
        boolean b = true;
        if (b = false == true != funct()) {
//        if (b = false ) {
            System.out.println("JAVA");
        } else {
            System.out.println("DEVELOPER");
        }
    }


    private static boolean funct(){
        return false;
    }
}
