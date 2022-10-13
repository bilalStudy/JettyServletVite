package no.kristiania.webshop;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.MalformedURLException;
import java.net.URL;

public class WebshopServer {

    private final Server server;

    public WebshopServer(int port){
        this.server = new Server(port);

        WebAppContext webContext = new WebAppContext();
        webContext.setContextPath("/");
        webContext.setBaseResource(Resource.newClassPathResource("/webapp"));
        server.setHandler(webContext);

    }

    public URL getURL() throws MalformedURLException {
        return server.getURI().toURL();
    }

    public void start() throws Exception {
        server.start();
    }
}
