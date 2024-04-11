import org.acme.VeicoloService;
import org.acme.beans.vehicles.Veicolo;
import org.acme.dto.VehicleDTO;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/MyVeicolo")

public class MyVeicoloResource {
    @Inject
    VeicoloService service;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({ "User", "Admin" }) 
    @Path("/Create")
    @Transactional
    public Response createVeicolo(VehicleDTO vehicleDTO){
        try{
            Veicolo veicolo = service.createVeicolo(vehicleDTO);
            String message = "{\"message\": "+"\"Inserimento avvenuto correttamente,\"Veicolo: \":"+veicolo+"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        }catch(Exception e){
            String message = "{\"errorCode\":5,\"message\": "+"\"Errore nell'operazione di update\"}";
            return Response.status(Response.Status.NOT_MODIFIED)
            .entity(message)
            .build();
        }
    }

    public Response updateVeicolo(VehicleDTO vehicleDTO){
        try{
            Veicolo veicolo = service.updateVeicolo(vehicleDTO);
            String message = "{\"message\": "+"\"Aggiornamento avvenuto correttamente,\"Veicolo: \":"+veicolo+"}";
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(message).build();
        }catch(Exception e){
            String message = "{\"errorCode\":5,\"message\": "+"\"Errore nell'operazione di update\"}";
            return Response.status(Response.Status.NOT_MODIFIED)
            .entity(message)
            .build();
        }
    }
}
