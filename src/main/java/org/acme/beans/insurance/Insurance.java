package org.acme.beans.insurance;

import org.acme.Assicurabile;

public class Insurance {
    
    public Assicurabile assicurabile;
    public String id;

    public Insurance(){}

    public Insurance(Assicurabile assicurabile, String id) {
        this.assicurabile = assicurabile;
        this.id = id;
    }

}
