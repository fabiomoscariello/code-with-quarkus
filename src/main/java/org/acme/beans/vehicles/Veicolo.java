package org.acme.beans.vehicles;
import javax.xml.crypto.Data;

import org.acme.Assicurabile;


public class Veicolo implements Assicurabile{

    private String targa;
    private String modello;
    private String nome;
    private String data;
    
    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Veicolo(){}

    public Veicolo(String targa,String modello ,String nome,String data){
        
    }

    @Override
    public void setTarga(String targa) {
        this.targa = targa;
    }

    @Override
    public String getTarga() {
        return this.targa;
    }
}
