package com.alexandreamyot.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FibonacciTest {

    final int number;
    final int value;

    public FibonacciTest(int number, int value) {
        this.number = number;
        this.value = value;
    }

    @Parameters(name="{0}th Fibonacci number is {1}")
    public static Iterable<Object[]> data() {
        return asList(new Object[][] {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {11, 89}
        });
    }

    @Test
    public void fib() {
        assertThat(Fibonacci.fib(number), equalTo(value));
    }
}
