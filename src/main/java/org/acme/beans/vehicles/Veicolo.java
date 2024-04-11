package org.acme.beans.vehicles;

import org.acme.Assicurabile;
import org.acme.beans.vehicles.vehicletype.TipoVeicolo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="veicolo")
public class Veicolo extends PanacheEntityBase implements Assicurabile{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idVeicolo")
    @Id
    private Long id;
    @Column(name = "targa")
    private String targa;
    @Column(name = "modello")
    private String modello;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data")
    private String data;
    @OneToOne
    @JoinColumn(name="idVeicolo")
    private TipoVeicolo tipoVeicolo;
    
    public TipoVeicolo getTipoVeicolo() {
        return tipoVeicolo;
    }

    public void setTipoVeicolo(TipoVeicolo tipoVeicolo) {
        this.tipoVeicolo = tipoVeicolo;
    }

    @Override
    public String toString() {
        return "Veicolo [id="+this.id + ", targa=" + this.targa + ", modello=" + this.modello + ", nome=" + this.nome + ", data=" + this.data + "]";
    }

    public Long getId() {
        return id;
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

    public Veicolo(String nome,String modello ,String targa,String data, TipoVeicolo tipo){
        this.targa = targa;
        this.modello = modello;
        this.nome = nome;
        this.data = data;
        this.tipoVeicolo = tipo;
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
