package com.alexandreamyot.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class PrimesTest {

    private final int number;
    private final List<Integer> primes;

    public PrimesTest(int number, List<Integer> primes) {
        this.number = number;
        this.primes = primes;
    }

    @Parameters(name="Primes of {0} is {1}")
    public static Iterable<Object[]> data() {
        return asList(new Object[][] {
            {1, emptyList()},
            {2, asList(2)},
            {4, asList(2, 2)},
            {3, asList(3)},
            {8, asList(2, 2, 2)},
            {9, asList(3, 3)},
            {24, asList(2, 2, 2, 3)},
            {1000, asList(2, 2, 2, 5, 5, 5)}
        });
    }

    @Test
    public void primesOf() {
        assertThat(PrimeFactors.decompose(number), equalTo(primes));
    }

}