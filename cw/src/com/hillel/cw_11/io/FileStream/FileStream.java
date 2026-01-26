package com.hillel.cw_11.io.FileStream;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileStream {
    public static void main(String[] args) throws IOException {
//        InputStream inputStream =
//                new FileInputStream("/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/cw/src/com/hillel/cw_11/io/FileStream/input.txt");
//
//        int size = inputStream.available();
//        System.out.println("file size : " + size);
//
//        for (int i = 0; i < size; i++){
//            System.out.print((char) inputStream.read());
//        }
//        inputStream.close();

        // Output stream
        OutputStream outputStream =
                new FileOutputStream("/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/cw/src/com/hillel/cw_11/io/FileStream/out.txt",
        false);

        String str = "Олександр Степурко";

        outputStream.write(str.getBytes(StandardCharsets.UTF_8));

        outputStream.close();
    }
}
