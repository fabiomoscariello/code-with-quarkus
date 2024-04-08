import org.acme.Assicurabile;
import org.acme.MyAssicurazioniService;
import org.acme.beans.insurance.Insurance;
import org.acme.beans.vehicles.Tipo;
import org.acme.beans.vehicles.Veicolo;
import org.acme.dto.VehicleDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/assicurazioni")
public class MyAssicurazioniResource {
    @Inject
    MyAssicurazioniService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/MyAssicurazioniService/Create")
    public void createInsurance(VehicleDTO vehicleDTO){
           service.createInsurance(vehicleDTO);
    }
}
