package com.alexandreamyot.tdd;

import com.alexandreamyot.tdd.web.Mathematician;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.routing.DynamicRoutes;


import java.io.IOException;

import static com.vtence.molecule.http.HttpStatus.OK;

public class Learning {

    private final WebServer server;

    public Learning(int port) {
        server = WebServer.create(port);
    }

    public void start() throws IOException {
        Mathematician mathematician = new Mathematician();

        server.start(new DynamicRoutes() {{
            get("/status").to((request, response) -> response.status(OK));
            get("/fib").to(mathematician::fib);
            get("/primes").to(mathematician::primes);
        }});
    }

    public void stop() throws IOException {
        server.stop();
    }
}
