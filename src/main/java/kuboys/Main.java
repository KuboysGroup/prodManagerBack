package kuboys;

import kuboys.models.Pedido;
import kuboys.services.PedidoService;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.inject.Inject;
import java.net.URI;

public class Main {
    @Inject
    PedidoService pedidoService;
    public static final String BASE_URI = "http://192.168.4.26:8484/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig()
                .packages("kuboys.controllers")
                .register(JacksonFeature.class);
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with endpoints available at %s\nHit CTRL+C to stop it...", BASE_URI));
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
