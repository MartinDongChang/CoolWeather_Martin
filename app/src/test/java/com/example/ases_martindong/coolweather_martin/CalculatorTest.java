package com.example.ases_martindong.coolweather_martin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator mCalculator;
    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sum() {
        assertEquals(6d, mCalculator.sum(1d, 5d), 0);
    }

    @Test
    public void substract() {
    }

    @Test
    public void divide() {
    }

    @Test
    public void multiply() {
    }
}