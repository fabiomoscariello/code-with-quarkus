package org.acme.beans.vehicles;

import javax.xml.crypto.Data;

public class Motociclo extends Veicolo{

    public Motociclo(){}

    public Motociclo(String targa,String modello,String nome,Data data){
        super(targa, modello, nome, data);
    }
    
}
