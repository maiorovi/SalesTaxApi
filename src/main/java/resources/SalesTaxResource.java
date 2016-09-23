package resources;

import domain.Item;
import org.springframework.stereotype.Component;
import services.TaxCalculationService;
import services.TestService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Path("/hello")
public class SalesTaxResource {

//    @Inject
//    private TestService testService;
    @Inject
    private TaxCalculationService calculationService;

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
//        testService.doJob();
        double price = calculationService.calculateTax(items);
        items.forEach( item -> System.out.println(item));
        return  Response.status(200).entity("Tax Amount is: " + price ).build();
    }

}
