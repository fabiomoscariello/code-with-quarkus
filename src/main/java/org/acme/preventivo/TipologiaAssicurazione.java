package org.acme.preventivo;


public enum TipologiaAssicurazione{
        AUTO(1.5),
        MOTOCICLO(2.3),
        DEFAULT(1.0);
    
        private double value;
        public double getValue() {
            return value;
        }
        public void setValue(double value) {
            this.value = value;
        }
        private TipologiaAssicurazione(double value){
            this.value = value;
        }  
    };