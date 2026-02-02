package com.hillel.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calc calc;

    @BeforeEach
    void initClass() {
        calc = new Calc();
    }

    @AfterEach
    void destrClass() {
        calc = null;
    }


    @Test
    void add() {
        assertEquals(10, calc.add(5, 5));
    }

    @Test
    void div() {
        assertEquals(1, calc.div(5, 5));
    }


    @Test
    @Disabled
    void div_by_ZERO() {
        assertEquals(1, calc.div(5, 0));
    }


    @Test
    void sub() {
        assertEquals(0, calc.sub(5, 5));
    }
}
