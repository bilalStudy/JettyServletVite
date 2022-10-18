package no.kristiania.webshop;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        var exampleCartItem = new CartItem();
        exampleCartItem.setItemName("bread");
        exampleCartItem.setPrice("100");

        var cartItems = List.of(exampleCartItem);

        JsonArrayBuilder result = Json.createArrayBuilder();
        for (CartItem cartItem : cartItems) {

            result.add(Json.createObjectBuilder()
                    .add("itemName", cartItem.getItemName())
                    .add("itemPrice", cartItem.getPrice())
            );


        }
        resp.getWriter().write(result.build().toString());

    }
}
