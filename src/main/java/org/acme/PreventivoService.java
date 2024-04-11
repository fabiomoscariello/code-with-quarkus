package org.acme;
import org.acme.beans.vehicles.vehicletype.TipologiaVeicolo;
import org.acme.dto.PreventivoDTO;
import org.acme.dto.VehicleDTO;
import org.acme.preventivo.TipologiaAssicurazione;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PreventivoService {
    
    public PreventivoDTO calcolaPreventivo(VehicleDTO assicurabile) throws Exception{
        PreventivoDTO preventivo = calcolaPreventivoByTipo(assicurabile);
        return preventivo;
    }

    private PreventivoDTO calcolaPreventivoByTipo(VehicleDTO assicurabile){
        double valore = assicurabile.getValore();
        TipologiaVeicolo tipoVeicolo = assicurabile.getTipo();
        PreventivoDTO preventivo = new PreventivoDTO(assicurabile);
        double costo;
        switch (tipoVeicolo) {
            case AUTO:
                costo = valore * TipologiaAssicurazione.AUTO.getValue();
                break;
            case MOTOCICLO:
                costo = valore * TipologiaAssicurazione.MOTOCICLO.getValue();
                break;
             default:
                costo = valore * TipologiaAssicurazione.DEFAULT.getValue();
                break;
        }
        preventivo.setCosto(costo);
        return preventivo;
    }
}
