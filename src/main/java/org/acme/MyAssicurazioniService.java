package org.acme;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Log.info("Veicolo Created" + veicolo);

        Insurance insurance = new Insurance(veicolo,id);
        Log.info("Insurance Created" + insurance);
        listInsurance.add(insurance);
        Log.info("ListInsurance" + listInsurance);

    }

    public void updateInsurance(InsuranceDTO insurance){
        Insurance insuranceFiltered = new Insurance();
        // listInsurance.stream().forEach(x -> Log.info(x.getId()));
        // List<Insurance> insuranceFiltered = listInsurance.stream()
        // .filter(x -> x.getId() == insurance.getId()).collect(Collectors.toList());
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
        Log.info("Insurance Updated" + insuranceFiltered);

        }

}
