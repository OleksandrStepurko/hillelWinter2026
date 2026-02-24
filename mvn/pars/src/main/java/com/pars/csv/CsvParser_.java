package com.pars.csv;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvParser_ {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/mvn/pars/src/main/resources/username_1.csv";

        long start = System.currentTimeMillis();

        List<UEmail_> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(UEmail_.class)
                .withSeparator(',')
                .build()
                .parse();


        long finish = System.currentTimeMillis();

        long duration = finish - start;
        System.out.println("duration : " + duration);

        System.out.println(beans.size());


    }
}
