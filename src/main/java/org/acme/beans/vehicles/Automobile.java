package org.acme.beans.vehicles;

import javax.xml.crypto.Data;

public class Automobile extends Veicolo{

    public Automobile(){}

    public Automobile(String targa,String modello,String nome,Data data){
        super(targa,modello,nome,data);
    }
    
}
