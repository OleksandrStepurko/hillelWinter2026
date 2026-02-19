package com.hillel.cw_17;

class Beta {
}

class Alpha {
    static Beta b1;
    Beta b2;
}

public class GCTest {

    public static void main(String[] args) {
        Beta b1 = new Beta();
        Beta b2 = new Beta();

        Alpha a1 = new Alpha();
        Alpha a2 = new Alpha();

        a1.b1 = b1;   // static поле Alpha.b1 теперь указывает на первый Beta

        a1.b2 = b1;   // поле экземпляра a1.b2 тоже указывает на первый Beta
        a2.b2 = b2;   // поле экземпляра a2.b2 указывает на второй Beta

        System.out.println(a2.b1);
        System.out.println(a1.b1);

        a1 = null;
        b1 = null;
        b2 = null;

        // do stuff

        System.out.println();
    }
}
