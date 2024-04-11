package org.acme.beans.vehicles.vehicletype;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoVeicoloRepository implements PanacheRepository<TipoVeicolo> {

      public TipoVeicolo getTipoVeicoloFromTipologia(TipologiaVeicolo tipologiaVeicolo) throws Exception{
        try {
          return find("idTipo", tipologiaVeicolo.getValue()).firstResult();

        } catch (Exception e) {
          throw new Exception("Non è presente alcun veicolo con questa targa");
        }
      }

}