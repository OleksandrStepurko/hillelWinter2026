package com.hillel.cw_04;

public class Konstr {
    int a; // 0
    int b; // 0
    boolean c;
    Boolean d;

    public Konstr() {
        System.out.println("default constructor");
    }

    public Konstr(int a) {
        System.out.println("konstr : a");
        this.a = a;
    }

    public Konstr(int a, int b) {
//        this(a);
        System.out.println("konstr : a, b ");
        this.b = b;
        this.a = a;
    }

    void printParam(){
        System.out.println("a = " + a + "; b = " + b);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public Boolean getD() {
        return d;
    }

    public void setD(Boolean d) {
        this.d = d;
    }
}
