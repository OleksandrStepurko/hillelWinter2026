package com.hillel.cw_17;

class Person {
    static int pid; // class
    int age;        // object
    String name;    // object

    Person(String s, int i) {
        ++pid;
        name = s;
        age = i;
    }
}

class Test {
    public static void main(String[] args) {
        Person p1 = new Person("John", 22);

        Test te = new Test();
        Person p2 = te.change(p1); // --> heap (person)
        Person p3 = te.change(p1); // --> heap (person)

        System.out.println(p2.pid + " " + p2.name + " " + p2.age); // 1
        System.out.println(p1.pid + " " + p1.name + " " + p1.age); // 1
        System.out.println(p3.pid + " " + p3.name + " " + p3.age); // 1

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());

        System.out.println(p1 == p2);
        System.out.println(p3 == p2);
    }

    private Person change(Object o) { // not create new object, only cast and update field value
        Person p2 = (Person) o;
        p2.age = 25;
        return p2;
    }
}
