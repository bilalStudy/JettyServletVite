package no.kristiania.webshop;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Path("/cartItems")
public class CartItemEndpoint {


    private static final List<CartItem> cartItems = new ArrayList<>();


    static {
        var exampleCartItem = new CartItem();
        exampleCartItem.setItemName("bread");
        exampleCartItem.setPrice(100);
        cartItems.add(exampleCartItem);

    }
        @Path("/")
        @GET
        public Response getAllCartItems(){

        var result = Json.createArrayBuilder();
        for(var cartItem : cartItems){
            result.add(Json.createObjectBuilder()
                    .add("itemName", cartItem.getItemName())
                    .add("itemPrice", cartItem.getPrice())
            );
        }

        return Response.ok(result.build().toString()).build();
    }

    @Path("/")
    @POST
    public Response addBook(String body) {
        JsonObject jsonBook = Json.createReader(new StringReader(body)).readObject();
        var exampleCartItem = new CartItem();
        exampleCartItem.setItemName("bread");
        exampleCartItem.setPrice(100);
        cartItems.add(exampleCartItem);

        return Response.ok().build();
    }
}
