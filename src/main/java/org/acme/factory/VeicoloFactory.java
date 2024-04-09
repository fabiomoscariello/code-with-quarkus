package org.acme.factory;

import org.acme.beans.vehicles.Automobile;
import org.acme.beans.vehicles.Motociclo;
import org.acme.beans.vehicles.Tipo;
import org.acme.beans.vehicles.Veicolo;
import org.acme.dto.VehicleDTO;

public class VeicoloFactory {

    public VeicoloFactory(){

    }

    public Veicolo createVeicolo(VehicleDTO vehicleDTO){
        try {
            String nome = vehicleDTO.getNome();
            String modello = vehicleDTO.getModello();
            String targa = vehicleDTO.getTarga();
            String data = vehicleDTO.getData();
            Tipo tipo = vehicleDTO.getTipo();
            switch (tipo) {
                case AUTO:
                    return new Automobile(targa,modello,nome,data);
                case MOTOCICLO:
                    return new Motociclo(targa,modello,nome,data);
                default:
                    return new Automobile(targa,modello,nome,data);
            }
        } catch (Exception e) {
            throw new Error("Errore nella creazione del veicolo", e);
        }

    }
    
}
