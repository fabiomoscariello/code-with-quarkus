package org.acme.dto;

public class PreventivoDTO {

    private VehicleDTO veicolo;
    private double costo;

    public PreventivoDTO(VehicleDTO veicolo) {
        this.veicolo = veicolo;
        this.costo = 0.0;
    }
    public VehicleDTO getVeicolo() {
        return veicolo;
    }
    public double getCosto() {
        return costo;
    }

    public void setVeicolo(VehicleDTO veicolo) {
        this.veicolo = veicolo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
