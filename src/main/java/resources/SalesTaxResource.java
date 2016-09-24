package resources;

import domain.Item;
import domain.SalesTaxItem;
import services.TaxCalculationService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tax")
public class SalesTaxResource {

    @Inject
    private TaxCalculationService calculationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SalesTaxItem receiveInfo(List<Item> items) {
        SalesTaxItem taxAmount = calculationService.calculateTax(items);
        items.forEach( item -> System.out.println(item));
        return  taxAmount;
    }

}
