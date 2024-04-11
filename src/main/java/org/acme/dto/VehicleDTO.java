package org.acme.dto;

import org.acme.beans.vehicles.vehicletype.TipologiaVeicolo;

public class VehicleDTO {

    private final String id;
    public String getId() {
        return id;
    }

    private final String targa;
    private final String modello;
    private final String nome;
    private final String data;
    private final TipologiaVeicolo tipo;
    
    @Override
    public String toString() {
        return "VehicleDTO [id="+id+", targa=" + targa + ", modello=" + modello + ", nome=" + nome + ", data=" + data + ", tipo="
                + tipo + "]";
    }

    public VehicleDTO(){
        this.id = "";
        this.targa = "";
        this.modello = "";
        this.nome = "";
        this.data = "";
        this.tipo = TipologiaVeicolo.AUTO;

    }

    // Constructor with required fields
    public VehicleDTO(String id, String targa, String modello, String nome, String data, TipologiaVeicolo tipo) {
      this.id = id;
      this.targa = targa;
      this.modello = modello;
      this.nome = nome;
      this.data = data;
      this.tipo = tipo;
    }

    public String getTarga() {
        return targa;
    }

    public String getModello() {
        return modello;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public TipologiaVeicolo getTipo() {
        return tipo;
    }
}
