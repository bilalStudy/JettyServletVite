package no.kristiania.webshop;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/cartItems")
public class CartItemEndpoint {


    private List<CartItem> cartItems = new ArrayList<>();


    {
        var exampleCartItem = new CartItem();
        exampleCartItem.setItemName("bread");
        exampleCartItem.setPrice(100);
        cartItems.add(exampleCartItem);

    }
        @Path("/")
        @GET
        public Response getAllCartItems(){

        JsonArrayBuilder result = Json.createArrayBuilder();
        for(var cartItem : cartItems){
            result.add(Json.createObjectBuilder()
                    .add("itemName", cartItem.getItemName())
                    .add("itemPrice", cartItem.getPrice())
            );
        }

        return Response.ok(result.build().toString()).build();
    }
}
