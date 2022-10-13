package no.kristiania.webshop;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var cartItem = new CartItem();
        cartItem.setItemName("bread");
        cartItem.setPrice(100);

        var cartItems = List.of(cartItem);


        resp.getWriter().println("[{\"title\":\"Java Webshop\"}]");

    }
}
