package org.acme.beans.insurance;

import org.acme.beans.vehicles.Veicolo;

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
@Table(name="insurance")
public class Insurance extends PanacheEntityBase {
    @OneToOne
    @JoinColumn(name="idAssicurabile")
    private Veicolo idAssicurabile;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    public Long getId() {
        return this.id;
    }

    public Insurance(){
    }

    public Insurance(Veicolo idAssicurabile) {
        this.idAssicurabile = idAssicurabile;
    }

    
    public Veicolo getIdAssicurabile() {
        return idAssicurabile;
    }

    public void setIdAssicurabile(Veicolo idAssicurabile) {
        this.idAssicurabile = idAssicurabile;
    }

    @Override
    public String toString() {
        return "Insurance [assicurabile=" + idAssicurabile + ", id=" + id + "]";
    }

    

}
