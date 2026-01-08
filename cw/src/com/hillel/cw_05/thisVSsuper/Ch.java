package com.hillel.cw_05.thisVSsuper;

public class Ch extends Par{

    @Override
    public void print() {
        System.out.println("ch");;
    }

    public void printPar() {
        super.print();
    }

    public void printCh() {
        this.print();
    }
}


class Check {

    public static void main(String[] args) {
        Ch ch = new Ch();

        ch.printCh();
        ch.printPar();

    }
    }
