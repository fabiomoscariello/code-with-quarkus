import org.acme.MyAssicurazioniService;
import org.acme.dto.VehicleDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/MyAssicurazioniService")
public class MyAssicurazioniResource {
    @Inject
    MyAssicurazioniService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Create")
    public Response createInsurance(VehicleDTO vehicleDTO){
            service.createInsurance(vehicleDTO);
            return Response.ok().build();
    }
}
