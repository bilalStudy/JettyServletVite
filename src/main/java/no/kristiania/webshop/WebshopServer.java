package no.kristiania.webshop;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class WebshopServer {

    private final Server server;

    public static final Logger logger = LoggerFactory.getLogger(WebshopServer.class);

    public WebshopServer(int port){
        this.server = new Server(port);

        WebAppContext webContext = new WebAppContext();
        webContext.setContextPath("/");
        webContext.setBaseResource(Resource.newClassPathResource("/webapp"));
        webContext.addServlet(new ServletHolder(new ListCartServlet()),"api/cart");
        server.setHandler(webContext);

    }

    public URL getURL() throws MalformedURLException {
        return server.getURI().toURL();
    }

    public void start() throws Exception {
        server.start();
    }

    public static void main(String[] args) throws Exception {
        var server = new WebshopServer(8080);
        server.start();
        logger.warn("server starting at {}", server.getURL());
    }
}
