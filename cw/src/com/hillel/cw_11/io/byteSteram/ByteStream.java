package com.hillel.cw_11.io.byteSteram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {

        try(
//                FileInputStream fis = new FileInputStream("/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/cw/src/com/hillel/cw_11/io/byteSteram/input.txt"); // -> from
//                FileOutputStream fos = new FileOutputStream("/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/cw/src/com/hillel/cw_11/io/byteSteram/output.txt"); // -> to
                FileInputStream fis = new FileInputStream("/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/cw/src/com/hillel/cw_11/io/byteSteram/plain.png"); // -> from
                FileOutputStream fos = new FileOutputStream("/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/cw/src/com/hillel/cw_11/io/byteSteram/plane_copy.png"); //-> to
                ) {

            int a;
            while ((a = fis.read()) != -1) { // -1 == end file
                fos.write(a);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
