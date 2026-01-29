package com.hillel.java.pro;

public class Main {

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1);
        book.setTitle("Star Wars 1");
        book.setAuthor("Star Wars 2");
        book.setIsbn("isbdn 2");
        System.out.println(book);
    }
}
