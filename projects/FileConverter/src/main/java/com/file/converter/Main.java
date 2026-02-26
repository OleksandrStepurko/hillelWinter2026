package com.file.converter;

import com.file.converter.service.FileProcessor;
import com.file.converter.service.impl.FileProcessorImpl;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("File converter v 0.0.1");

        FileProcessor fp = new FileProcessorImpl();
        fp.folderFileChecker(
            "/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/projects/checkFolder",
            "/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/projects/checkOutputFolder");

    }
}
