package com.hillel.cw_11;

import java.io.File;
import java.net.CookieHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FolderStructureTest {

    private static final String FILE = "[F] : ";
    private static final String DIR = "[D] : ";
    private static final String PREF = "--";


    public static void main(String[] args) {

        String rootDir = "/Users/oleksandrstepurko/IdeaProjects/hillelWinter2026/cw";
        File rootFile = new File(rootDir);
            getFileStructure(rootFile, "");
    }

    private static void getFileStructure(File file, String prefix){
        if (file.isFile()){
            System.out.println(prefix.concat(FILE).concat(file.getName()));
        } else {
            System.out.println(prefix.concat(DIR).concat(file.getName()));
            List<File> files = Arrays.asList(file.listFiles());
            Collections.sort(files, Comparator.comparing(File::isDirectory)
                .thenComparing(File::getName));
            for (File f : files){
                getFileStructure(f, prefix + PREF);
            }
        }

    }
}
