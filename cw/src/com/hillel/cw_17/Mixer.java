package com.hillel.cw_17;

public class Mixer {
    Mixer m1;
    Mixer() {
    }
    Mixer(Mixer m) {
        m1 = m;
    }

    public static void main(String[] args) {
        Mixer m2 = new Mixer(); // 1st object
        Mixer m3 = new Mixer(m2); // 2nd object

        m3.go(); // mixer --> mixer
        Mixer m4 = m3.m1; // mixer
        m4.go();
        Mixer m5 = m2.m1; // null
        m5.go(); // --> NullPointerException
    }

    void go() {
        System.out.print("hi ");
    }
}

