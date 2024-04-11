package org.acme.beans.vehicles.vehicletype;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipoVeicolo")
public class TipoVeicolo {
    @Column(name = "idTipo")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTipo;
    @Column(name="tipologia")
    private String tipologia;

    public TipoVeicolo() {
    }

    public TipoVeicolo(Long idTipo, String tipologia) {
        this.idTipo = idTipo;
        this.tipologia = tipologia;
    }
  
    public Long getIdTipo() {
        return idTipo;
    }
    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }
    public String getTipologia() {
        return tipologia;
    }
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}

