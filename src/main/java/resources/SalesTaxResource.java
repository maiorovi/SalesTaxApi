package resources;

import domain.Item;
import domain.SalesTaxItem;
import services.TaxCalculationService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/calculatetax")
public class SalesTaxResource {

    @Inject
    private TaxCalculationService calculationService;

    //handle exception there. something could go wrong and produce error response
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SalesTaxItem calculateTax(List<Item> items) {
        SalesTaxItem taxAmount = calculationService.calculateTax(items);
        return  taxAmount;
    }

}
