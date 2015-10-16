package com.alexandreamyot.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FibonacciSequenceTest {

    final int number;
    final List<Integer> sequence;

    public FibonacciSequenceTest(int number, List<Integer> sequence) {
        this.number = number;
        this.sequence = sequence;
    }

    @Parameterized.Parameters(name="First {0} Fibonacci numbers are {1}")
    public static Iterable<Object[]> data() {
        return asList(new Object[][] {
                {0, asList(0)},
                {1, asList(0, 1)},
                {2, asList(0, 1, 1)},
                {11, asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)}
        });
    }

    @Test
    public void fib() {
        assertThat(Fibonacci.sequenceFor(number), equalTo(sequence));
    }
}
