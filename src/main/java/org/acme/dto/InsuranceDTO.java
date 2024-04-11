package org.acme.dto;

import java.util.Random;

public class InsuranceDTO {

    private final VehicleDTO veicolo;
    private final Long id;
    @Override
    public String toString() {
        return "InsuranceDTO [veicolo=" + veicolo + "]";
    }

    public InsuranceDTO(){
        this.id = Math.abs(new Random().nextLong());
        this.veicolo = new VehicleDTO();
    }

    // Constructor with required fields
    public InsuranceDTO(Long id,VehicleDTO vehicle) {
        this.id = id;
        this.veicolo = vehicle;
    }
    public Long getId(){
        return this.id;
    }

    public VehicleDTO getVeicolo() {
        return this.veicolo;
    }

}
