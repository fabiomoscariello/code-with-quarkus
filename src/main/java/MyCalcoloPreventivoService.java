
import org.acme.PreventivoService;
import org.acme.dto.PreventivoDTO;
import org.acme.dto.VehicleDTO;
import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/MyPreventivo")
@ApplicationScoped
public class MyCalcoloPreventivoService{
    @Inject
    PreventivoService service;

    @Inject
    JsonWebToken jwt;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    @Path("/GetPreventivo")
    @Transactional
    public Response getPreventivo(VehicleDTO vehicleDTO){
        try{
            PreventivoDTO preventivo= service.calcolaPreventivo(vehicleDTO);
            return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(preventivo).build();
        }catch(Exception e){
            String message = "{\"errorCode\":590,\"message\": "+"\"Errore nella generazione del preventivo\"}";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(message)
            .build();
        }
    }
   
}
