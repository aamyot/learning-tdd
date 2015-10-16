package com.alexandreamyot.tdd.features;

import com.alexandreamyot.tdd.Learning;
import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PrimesDecompositionTest {

    HttpRequest request = new HttpRequest(9897);
    Learning server;

    @Before
    public void startServer() throws IOException {
        server = new Learning(9897);
        server.start();
    }

    @After
    public void stopServer() throws IOException {
        server.stop();
    }

    @Test
    public void decomposesANumberIntoPrimeFactors() throws IOException {
        HttpResponse response = request.get("/primes?number=16");

        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.bodyText(), equalTo("{\"number\":16,\"result\":[2,2,2,2]}"));
    }

}
