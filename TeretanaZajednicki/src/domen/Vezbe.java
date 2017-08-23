/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lazar
 */
public class Vezbe extends OpstiDomenskiObjekat implements Serializable{
     private int vezbeID;
    private String naziv;
    private String fokus;
    private int vremeTrajanja;
    
    public Vezbe(){
        
    }
    
    public Vezbe(int vezbeID, String naziv, String fokus, int vremeTrajanja){
        this.vezbeID = vezbeID;
        this.naziv = naziv;
        this.fokus = fokus;
        this.vremeTrajanja = vremeTrajanja;
    }

    public int getVezbeID() {
        return vezbeID;
    }

    public void setVezbeID(int vezbeID) {
        this.vezbeID = vezbeID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getFokus() {
        return fokus;
    }

    public void setFokus(String fokus) {
        this.fokus = fokus;
    }

    public int getVremeTrajanja() {
        return vremeTrajanja;
    }

    public void setVremeTrajanja(int vremeTrajanja) {
        this.vremeTrajanja = vremeTrajanja;
    }
    
    @Override
    public String toString(){
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "vezbe";
    }

    @Override
    public String vratiVrednostiZaInsert() {
      return ", '" + naziv + "' , '" + fokus + "','" + vremeTrajanja + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
                int id = rs.getInt("ID");
                String naziv = rs.getString("Naziv");
                String fokus = rs.getString("Fokus");
                int vremeTrajanja = rs.getInt("VremeTrajanja");
                
                Vezbe vezbe = new Vezbe(id, naziv, fokus, vremeTrajanja);
                lista.add(vezbe);
            }
        return lista;
    }

    @Override
    public String vratiSve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKolonu() {
        return "ID";
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
