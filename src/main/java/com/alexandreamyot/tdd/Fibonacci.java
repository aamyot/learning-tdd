package com.alexandreamyot.tdd;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class Fibonacci {

    public static List<Integer> sequenceFor(int number) {
        return rangeClosed(0, number)
                .mapToObj(Fibonacci::fib)
                .collect(toList());
    }

    public static Integer fib(int number) {
        if (number < 2) {
            return number;
        }

        return fib(number-1) + fib(number-2);
    }
}
