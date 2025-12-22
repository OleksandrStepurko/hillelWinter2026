package com.hillel.cw_04;

public class ExampleOver {
    int a;

    public ExampleOver() {
    }

    public ExampleOver(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExampleOver that = (ExampleOver) o;
        return a == that.a;
    }

    @Override
    public int hashCode() {
        return a;
    }

    @Override
    public String toString() {
        return "ExampleOver{" +
            "a=" + a +
            '}';
    }
}
