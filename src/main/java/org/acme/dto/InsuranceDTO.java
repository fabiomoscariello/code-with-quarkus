package org.acme.dto;

public class InsuranceDTO {

    private final String id;
    private final VehicleDTO veicolo;
    
    @Override
    public String toString() {
        return "InsuranceDTO [id=" + id + ", veicolo=" + veicolo + "]";
    }

    public InsuranceDTO(){
        this.id = "";
        this.veicolo = new VehicleDTO();
    }

    // Constructor with required fields
    public InsuranceDTO(String id, VehicleDTO vehicle) {
        this.id = id;
        this.veicolo = vehicle;
    }

    public String getId() {
        return this.id;
    }

    public VehicleDTO getVeicolo() {
        return this.veicolo;
    }

}
