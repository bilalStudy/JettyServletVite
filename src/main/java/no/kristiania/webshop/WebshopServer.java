package no.kristiania.webshop;

import org.eclipse.jetty.server.Server;

import java.net.MalformedURLException;
import java.net.URL;

public class WebshopServer {

    private final Server server;

    public WebshopServer(int port){
        this.server = new Server(port);

    }

    public URL getURL() throws MalformedURLException {
        return server.getURI().toURL();
    }

    public void start() throws Exception {
        server.start();
    }
}
