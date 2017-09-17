/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lazar
 */
public class VezbacNaTreningu extends OpstiDomenskiObjekat implements Serializable{
    private Vezbac vezbacID;
    private Trening treningID;
    private Teretana teretanaID;
    
    public VezbacNaTreningu(){
        
    }
    
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

    @Override
    public String vratiNazivTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKolonu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiID(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
