package org.acme.beans.insurance;

import org.acme.beans.vehicles.Veicolo;
import org.acme.beans.vehicles.VeicoloRepository;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InsuranceRepository implements PanacheRepository<Insurance> {
    @Inject 
    VeicoloRepository veicoloRepository;
    public Long createInsurance(Insurance insurance) {
        persist(insurance);
        return insurance.getId();
      }
    
      public Insurance updateInsurance(Insurance insurance) {
        persist(insurance);
        return insurance;
      }

      public Insurance getInsuranceByTarga(String targa) throws Exception {
        try {
          Veicolo veicolo = veicoloRepository.getVeicoloByTarga(targa);
          return find("idAssicurabile", veicolo).firstResult();
        } catch (Exception e) {
          throw new Exception(e.getMessage());
        }

      }

      public List<Insurance> getAllInsurance() throws Exception {
        try {
          List<Insurance> list =  listAll();
          if(list.size() <= 0){
            throw new Exception("Non sono disponibili alcune assicurazioni");
          }else{
            return list;
          }
        } catch (Exception e) {
          throw new Exception(e.getMessage());
        }
      }

        public Insurance getInsuranceById(Long id) throws Exception {
          try {
            Insurance insurance = find("id", id).firstResult();
            if(insurance == null){
              throw new Exception("Non è stato trovato alcuna assicurazione con questo id");
            }else{
              return insurance;
            }
          } catch (Exception e) {
            throw new Exception(e.getMessage());
          }

      }

      public void deleteInsuranceByTarga(String targa) throws Exception {
        try {
          Veicolo foundedVeicolo = veicoloRepository.getVeicoloByTarga(targa);
          Insurance insurance = find("idAssicurabile", foundedVeicolo).firstResult();
          delete(insurance);
        } catch (Exception e) {
          throw new Exception(e.getMessage());
        }

      }

}