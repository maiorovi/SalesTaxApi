package resources;

import domain.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class SalesTaxResource {

    //TODO: remove this method. was used as starting point to play with Jersey
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say: " + msg;

        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiveInfo(List<Item> items) {
//        System.out.println(json);
        items.forEach( item -> System.out.println(item));
        return  Response.status(200).entity("Thats nice").build();
    }

}
