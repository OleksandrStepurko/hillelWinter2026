package com.hillel.cw_04;

public class Clazz {
    // fields
    static private int index = 15; //
    private static final Integer DESTINATION_1 = 145; // constanta
    int value; //

    // constructor
    public Clazz() {
    }

    public Clazz(int value) {
        this.value = value;
    }

    // methods
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        Clazz.index = index;
    }

    public int getValue() {
        return value;
    }

    public int calc(){
        return index + value;
    }

}
