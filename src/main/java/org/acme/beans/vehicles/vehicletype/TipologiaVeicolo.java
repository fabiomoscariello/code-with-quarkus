package org.acme.beans.vehicles.vehicletype;
 
public enum TipologiaVeicolo{
        AUTO(1),
        MOTOCICLO(2),
        MOTO500(3);
    
        private int value;
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        private TipologiaVeicolo(int value){
            this.value = value;
        }  
    };