package org.acme;

import java.util.List;

import org.acme.beans.insurance.Insurance;
import org.acme.beans.insurance.InsuranceRepository;
import org.acme.beans.vehicles.Veicolo;
import org.acme.dto.InsuranceDTO;
import org.acme.dto.VehicleDTO;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MyAssicurazioniService {
    
    @Inject
    InsuranceRepository insuranceRepository;
    @Inject
    VeicoloService veicoloService;
    public Long createInsurance(VehicleDTO assicurabile) throws Exception{
        try {
            Veicolo veicolo = veicoloService.createVeicolo(assicurabile);
            Insurance insurance = new Insurance(veicolo);
            return insuranceRepository.createInsurance(insurance);
        } catch (Exception e) {
            Log.error(e);
            throw new Exception(e.getMessage());
        }

    }

    public void updateInsurance(InsuranceDTO insuranceDTO) throws Exception{
        try{
        VehicleDTO veicolofromInsurance = insuranceDTO.getVeicolo();
        Insurance insurance = insuranceRepository.getInsuranceById(insuranceDTO.getId());
        Veicolo veicolo = veicoloService.createVeicolo(veicolofromInsurance);
        insurance.setIdAssicurabile(veicolo);
        insuranceRepository.updateInsurance(insurance);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

        }

    public Insurance getInsurancebyTarga(String targa) throws Exception{
        try {
            return insuranceRepository.getInsuranceByTarga(targa);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Insurance> getAllInsurances() throws Exception{
        try {
            return insuranceRepository.getAllInsurance();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteInsuranceByTarga(String targa) throws Exception{
        try {
            insuranceRepository.deleteInsuranceByTarga(targa);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    
}
