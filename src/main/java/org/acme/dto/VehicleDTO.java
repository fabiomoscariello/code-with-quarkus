package org.acme.dto;

import org.acme.beans.vehicles.Tipo;

public class VehicleDTO {

    private final String targa;
    private final String modello;
    private final String nome;
    private final String data;
    private final Tipo tipo;
    
    @Override
    public String toString() {
        return "VehicleDTO [targa=" + targa + ", modello=" + modello + ", nome=" + nome + ", data=" + data + ", tipo="
                + tipo + "]";
    }

    public VehicleDTO(){
        this.targa = "";
        this.modello = "";
        this.nome = "";
        this.data = "";
        this.tipo = Tipo.AUTO;

    }

    // Constructor with required fields
    public VehicleDTO(String targa, String modello, String nome, String data, Tipo tipo) {
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

    public Tipo getTipo() {
        return tipo;
    }
}
