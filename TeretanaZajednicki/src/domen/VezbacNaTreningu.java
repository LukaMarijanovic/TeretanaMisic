/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Lazar
 */
public class VezbacNaTreningu implements Serializable{
    private Vezbac vezbacID;
    private Trening treningID;
    private Teretana teretanaID;
    
    public VezbacNaTreningu(Vezbac vezbacID, Trening treningID, Teretana teretanaID){
        this.vezbacID = vezbacID;
        this.treningID = treningID;
        this.teretanaID = teretanaID;
    }

    public Vezbac getVezbacID() {
        return vezbacID;
    }

    public void setVezbacID(Vezbac vezbacID) {
        this.vezbacID = vezbacID;
    }

    public Trening getTreningID() {
        return treningID;
    }

    public void setTreningID(Trening treningID) {
        this.treningID = treningID;
    }

    public Teretana getTeretanaID() {
        return teretanaID;
    }

    public void setTeretanaID(Teretana teretanaID) {
        this.teretanaID = teretanaID;
    }
    
    
}
