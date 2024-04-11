package org.acme;
import org.acme.beans.vehicles.Veicolo;
import org.acme.beans.vehicles.VeicoloRepository;
import org.acme.dto.VehicleDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class VeicoloService {
    @Inject
    VeicoloRepository veicoloRepository;
    public Veicolo createVeicolo(VehicleDTO vehicleDTO) throws Exception{
        try{
            Veicolo veicolo = veicoloRepository.createVeicolo(vehicleDTO);
            return veicolo;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

        }
        
        public Veicolo updateVeicolo(VehicleDTO vehicleDTO) throws Exception{
            try{
                String targa = vehicleDTO.getTarga();
                Veicolo foundedVeicolo = veicoloRepository.getVeicoloByTarga(targa);
                Veicolo veicoloUpdated = veicoloRepository.updateVeicolo(foundedVeicolo);
                return veicoloUpdated;
            }catch(Exception e){
                throw new Exception(e.getMessage());
            }
    
            }
}
