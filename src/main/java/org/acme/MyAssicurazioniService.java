package org.acme;

import java.util.ArrayList;
import java.util.UUID;

import org.acme.beans.insurance.Insurance;
import org.acme.beans.vehicles.Veicolo;
import org.acme.dto.VehicleDTO;
import org.acme.factory.VeicoloFactory;

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
}
