package no.kristiania.webshop;

import org.eclipse.jetty.server.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class WebshopServerTest {

    @BeforeEach
    void setUp() throws Exception {
        var server = new WebshopServer(0);
        server.start();
    }

    @Test
    void shouldServeHomePage() throws Exception {
       var connection = openConnection("/");

        assertThat(connection.getResponseCode())
                .as(connection.getResponseMessage() + " for " + connection.getURL())
                .isEqualTo(200);
        assertThat(connection.getInputStream())
                .asString(StandardCharsets.UTF_8)
                .contains("<h1>Kristiania Webshop</h1>");
    }

    @Test
    void shouldListCart() throws IOException {
        var connection = openConnection("/api/cart");
        assertThat(connection.getResponseCode())
                .as(connection.getResponseMessage() + " for " + connection.getURL())
                .isEqualTo(200);
        assertThat(connection.getInputStream())
                .asString(StandardCharsets.UTF_8)
                .contains("{\"title\":\"Java Webshop\"");
    }

    //cannot resolve server for some reason
    private HttpURLConnection openConnection(String spec) throws IOException{
        return (HttpURLConnection) new URL(server.getURL(), spec).openConnection();
    }
}
