import java.util.ArrayList;

import org.acme.MyAssicurazioniService;
import org.acme.beans.insurance.Insurance;
import org.acme.dto.InsuranceDTO;
import org.acme.dto.VehicleDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Update")
    public Response updateInsurance(InsuranceDTO insurance){
        try {
            service.updateInsurance(insurance);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(200, e.getMessage()).build();
        }
           
    }
    @GET
    @Path("/GetInsuranceByTarga")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsuranceByTarga(@QueryParam("targa") String targa){
        try {
            ArrayList<Insurance> insuranceList;
            Insurance insurance;
            if(targa != null){
                insurance = service.getInsurancebyTarga(targa);
                return Response.ok(insurance).build();

            }else{
                insuranceList= service.getAllInsurances();
                return Response.ok(insuranceList).build();

            }
        } catch (Exception e) {
            return Response.status(200, e.getMessage()).build();
        }
           
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/GetAllInsurance")
    public Response getAllInsurance(){
        try {
            ArrayList<Insurance> insuranceList= service.getAllInsurances();
            return Response.ok(insuranceList).build();
        } catch (Exception e) {
            return Response.status(200, e.getMessage()).build();
        }
           
    }
}
