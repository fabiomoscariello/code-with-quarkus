package org.acme.beans.vehicles;

import org.acme.Assicurabile;


public class Veicolo implements Assicurabile{

    private String targa;
    private String modello;
    private String nome;
    private String data;
    
    @Override
    public String toString() {
        return "Veicolo [targa=" + this.targa + ", modello=" + this.modello + ", nome=" + this.nome + ", data=" + this.data + "]";
    }

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
        this.targa = targa;
        this.modello = modello;
        this.nome = nome;
        this.data = data;
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
