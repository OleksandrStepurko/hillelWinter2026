package com.hillel.cw_08.converter;


public class Main {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c"};

        TextConverter tc = new TextConverter();

        tc.convertNaming("intup_text_frr_text", CaseStyle.SNAKE_CASE, CaseStyle.CAMEL_CASE);

    }

}
