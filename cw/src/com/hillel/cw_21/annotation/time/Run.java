package com.hillel.cw_21.annotation.time;

import lombok.SneakyThrows;

public class Run {

    @SneakyThrows
    public static void main(String[] args) {
        SampleClass obj = new SampleClass();

        MethodTimer.invokeAnnotatedMethods(obj);
    }
}
