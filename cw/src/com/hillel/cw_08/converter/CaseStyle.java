package com.hillel.cw_08.converter;

public enum CaseStyle {
    DEFAULT(" "),
    CAMEL_CASE(""),
    SNAKE_CASE("_"),
    KEBAB_CASE("-");

    private String delimiter;

    CaseStyle(String delimiter) {
        this.delimiter = delimiter;
    }

    public String delimiter() {
        return delimiter;
    }
}
