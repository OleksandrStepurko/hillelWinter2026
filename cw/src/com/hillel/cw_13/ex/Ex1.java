package com.hillel.cw_13.ex;

/*
Ключові правила Java тут:
Перевантаження вирішується на етапі компіляції, а не під час виконання.
null підходить для будь-якого reference-типу.
Якщо є кілька підходящих методів, Java обирає найбільш специфічний тип.

String vs Object
Object — базовий клас для всіх обʼєктів
String — підклас Object, тобто більш специфічний
 */
public class Ex1 {

    public static void main(String[] args) {
        method(null);
    }

    public static void method(Object o) {
        System.out.println("Object Method");
    }

    public static void method(String s) {
        System.out.println("String Method");
    }

//    public static void method(Integer i) {
//        System.out.println("Integer Method");
//    }
}
