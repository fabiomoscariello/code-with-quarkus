package org.acme.beans.insurance;

import org.acme.Assicurabile;

public class Insurance {
    
    public Assicurabile assicurabile;
    public String id;

    public Assicurabile getAssicurabile() {
        return assicurabile;
    }

    public void setAssicurabile(Assicurabile assicurabile) {
        this.assicurabile = assicurabile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Insurance(){}

    public Insurance(Assicurabile assicurabile, String id) {
        this.assicurabile = assicurabile;
        this.id = id;
    }

}
