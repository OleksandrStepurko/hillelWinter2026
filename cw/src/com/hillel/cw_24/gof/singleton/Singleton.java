package com.hillel.cw_24.gof.singleton;

public final class Singleton {
    private Singleton() {
        System.out.println("run constructor...");
    }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    public void doWork() {
        System.out.println("Singleton is working!");
    }

    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a == b); // true
        a.doWork();
        System.out.println("-------");
        print();
    }

    public static void print(){
        Singleton a = Singleton.getInstance();
        a.doWork();
    }
}

