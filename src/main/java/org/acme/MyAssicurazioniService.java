package org.acme;

import java.util.ArrayList;
import java.util.UUID;

import org.acme.beans.insurance.Insurance;
import org.acme.beans.vehicles.Veicolo;
import org.acme.dto.InsuranceDTO;
import org.acme.dto.VehicleDTO;
import org.acme.factory.VeicoloFactory;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyAssicurazioniService {
    private ArrayList<Insurance> listInsurance = new ArrayList<Insurance>();
    public void createInsurance(VehicleDTO assicurabile){
        String id = UUID.randomUUID().toString();
        VeicoloFactory veicoloFactory = new VeicoloFactory();
        Veicolo veicolo = veicoloFactory.createVeicolo(assicurabile);
        Insurance insurance = new Insurance(veicolo,id);
        listInsurance.add(insurance);
    }

    public void updateInsurance(InsuranceDTO insurance){
        Insurance insuranceFiltered = new Insurance();
        for (Insurance insuranceIt : listInsurance) {
            if(insuranceIt.getId() == insurance.getId()){
                insuranceFiltered = insuranceIt;
            }else{
                insuranceFiltered = null;
            }
        }
        VehicleDTO veicolofromInsurance = insurance.getVeicolo();
        VeicoloFactory veicoloFactory = new VeicoloFactory();
        Veicolo veicolo = veicoloFactory.createVeicolo(veicolofromInsurance);
        insuranceFiltered.setAssicurabile(veicolo);
        insuranceFiltered.setId(insurance.getId());
        }

    public Insurance getInsurancebyTarga(String targa) throws Exception{
        Insurance insuranceReturned = null;
        for (Insurance insuranceIt : listInsurance) {
            Assicurabile assicurabile = insuranceIt.getAssicurabile();
            System.out.println(assicurabile);
            if(assicurabile.getTarga().equalsIgnoreCase(targa)){
                insuranceReturned = insuranceIt;
            }
        }
        if(insuranceReturned != null){
            return insuranceReturned;
        }else{
            throw new Exception("Nessuna Assicurazione disponibile per quella targa");
        }
    }

    public ArrayList<Insurance> getAllInsurances() throws Exception{
        if(listInsurance.size() <= 0){
            throw new Exception("Non sono disponibili alcune assicurazioni");
        }
        return listInsurance;
    }
}
