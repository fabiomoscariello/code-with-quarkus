package org.acme.factory;


import org.acme.beans.vehicles.Automobile;
import org.acme.beans.vehicles.Motociclo;
import org.acme.beans.vehicles.Veicolo;

public class VeicoloFactory {

    public VeicoloFactory(){

    }

    public Veicolo createVeicolo(Tipo tipo){
        try {
            switch (tipo) {
                case AUTO:
                    return new Automobile();
                case MOTOCICLO:
                    return new Motociclo();
                default:
                    return new Automobile();
            }
        } catch (Exception e) {
            throw new Error("Errore nella creazione del veicolo", e);
        }

    }
    
}
