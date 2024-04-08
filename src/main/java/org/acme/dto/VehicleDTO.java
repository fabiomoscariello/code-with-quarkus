package org.acme.dto;

import javax.xml.crypto.Data;

import org.acme.beans.vehicles.Tipo;

public class VehicleDTO {

    private final String targa;
    private final String modello;
    private final String nome;
    private final Data data;
    private final Tipo tipo;
    
    // Constructor with required fields
    public VehicleDTO(String targa, String modello, String nome, Data data, Tipo tipo) {
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

    public Data getData() {
        return data;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
