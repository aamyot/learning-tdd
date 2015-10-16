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

public class ServerStatusTest {

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
    public void serverRespondsOKToAStatusRequest() throws IOException {
        HttpResponse response = request.get("/status");

        assertThat(response.statusCode(), equalTo(200));
    }

    @Test
    public void serverRespondsNotFoundToAnUnknownRequest() throws IOException {
        HttpResponse response = request.get("/unknown");

        assertThat(response.statusCode(), equalTo(404));
    }

}
