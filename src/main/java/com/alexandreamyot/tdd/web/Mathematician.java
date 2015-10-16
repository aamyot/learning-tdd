package com.alexandreamyot.tdd.web;

import com.alexandreamyot.tdd.Fibonacci;
import com.alexandreamyot.tdd.PrimeFactors;
import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Mathematician {

    public void fib(Request request, Response response) throws Exception {
        int number = parseInt(request.parameter("number"));
        response.body(respondsWith(number, Fibonacci.sequenceFor(number)));
    }

    public void primes(Request request, Response response) throws Exception {
        int number = parseInt(request.parameter("number"));
        response.body(respondsWith(number, PrimeFactors.decompose(number)));
    }

    private String respondsWith(int number, List<Integer> result) {
        return toJson(new Result(number, result));
    }

    private String toJson(Result result) {
        return new Gson().toJson(result);
    }


}
