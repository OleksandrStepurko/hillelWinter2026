package com.hillel.cw_08.ex;

public class Ex5 {
    private final static String RESULT ="2cfalse"; // Heap.stringPool
    public static void main(String[] args) {
        String a = "";
        a += 2;     // new String -> Heap
        System.out.println(a);
        a += 'c';   // new String -> Heap
        System.out.println(a);
        a += false; // new String -> Heap
        System.out.println(a); // Heap
        a = a.intern(); // Heap --> Heap.stringPool

        System.out.println();
        if (a == RESULT) System.out.println("=="); // print
        if (a.equals(RESULT)) System.out.println("equals"); // print
    }
}
