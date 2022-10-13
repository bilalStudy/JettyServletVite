package no.kristiania.webshop;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cartItems")
public class CartItemEndpoint {
    @Path("/")
    @GET
    public Response getAllCartItems(){
        var exampleCartItem = new CartItem();
        exampleCartItem.setItemName("bread");
        exampleCartItem.setPrice(100);
        var cartItems = List.of(exampleCartItem);

        JsonArrayBuilder result = Json.createArrayBuilder();
        for(var cartItem : cartItems){
            result.add(Json.createObjectBuilder()
                    .add("cartItemName", cartItem.getItemName())
                    .add("cartItemPrice", cartItem.getPrice())
            );
        }

        return Response.ok(result.build().toString()).build();
    }
}
