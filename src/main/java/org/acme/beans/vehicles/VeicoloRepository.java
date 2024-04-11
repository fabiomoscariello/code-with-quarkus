package org.acme.beans.vehicles;

import org.acme.beans.vehicles.vehicletype.TipoVeicolo;
import org.acme.beans.vehicles.vehicletype.TipoVeicoloRepository;
import org.acme.beans.vehicles.vehicletype.TipologiaVeicolo;
import org.acme.dto.VehicleDTO;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VeicoloRepository implements PanacheRepository<Veicolo> {

  @Inject
  TipoVeicoloRepository tipologiaVeicolo;

    public Veicolo createVeicolo(VehicleDTO veicolo) throws Exception {
      try{
      String nome = veicolo.getNome();
      String modello = veicolo.getModello();
      String targa = veicolo.getTarga();
      String data = veicolo.getData();
      TipologiaVeicolo tipo = veicolo.getTipo();
      TipoVeicolo tipoVeicolo = tipologiaVeicolo.getTipoVeicoloFromTipologia(tipo) ;
      Veicolo veicoloToCreate = new Veicolo(nome,modello,targa,data,tipoVeicolo);
      persist(veicoloToCreate);
      return veicoloToCreate;
      }catch(Exception e){
        throw new Exception(e.getMessage());
      }
    }
    
      public Veicolo updateVeicolo(Veicolo veicolo) {
        persist(veicolo);
        return veicolo;
      }

      public Veicolo getVeicoloByTarga(String targa) throws Exception{
        try {
          return find("targa", targa).firstResult();

        } catch (Exception e) {
          throw new Exception("Non è presente alcun veicolo con questa targa");
        }
      }

}