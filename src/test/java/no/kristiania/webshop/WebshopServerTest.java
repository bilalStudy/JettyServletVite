package no.kristiania.webshop;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class WebshopServerTest {

    @Test
    void shouldServeHomePage() throws IOException {
        var server = new WebshopServer(0);
        var connection = (HttpURLConnection) server.getURL().openConnection();

        assertThat(connection.getResponseCode())
                .as(connection.getResponseMessage() + " for " + connection.getURL())
                .isEqualTo(200);
        assertThat(connection.getInputStream())
                .asString(StandardCharsets.UTF_8)
                .contains("<h1>Kristiania Webshop</h1>");
    }

}
