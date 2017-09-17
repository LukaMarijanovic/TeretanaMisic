/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lazar
 */
public abstract class OpstaSO {
    public void izvrsi(OpstiDomenskiObjekat odo){
        try {
            izvrsiKonkretnuOperaciju(odo);
            potvrdi();
        } catch (Exception ex) {
            ponisti();
            Logger.getLogger(OpstaSO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected abstract void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception;
    
    private void potvrdi(){
        DBBroker.getInstance().commit();
    }
    
    private void ponisti(){
        DBBroker.getInstance().rollback();
    }
}
