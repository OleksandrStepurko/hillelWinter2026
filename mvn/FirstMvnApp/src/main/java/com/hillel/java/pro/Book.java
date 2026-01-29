package com.hillel.java.pro;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
