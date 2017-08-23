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
public class Teretana extends OpstiDomenskiObjekat implements Serializable{
     private int teretanaID;
    private String naziv;
    private String lokacija;
    
    public Teretana(){
        
    }
    
    public Teretana(int teretanaID, String naziv, String lokacija){
        this.teretanaID = teretanaID;
        this.naziv = naziv;
        this.lokacija = lokacija;
    }

    public int getTeretanaID() {
        return teretanaID;
    }

    public void setTeretanaID(int teretanaID) {
        this.teretanaID = teretanaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }
    
     @Override
    public String toString(){
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "teretana";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return ", '" + naziv + "' , '" + lokacija + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("ID");
                String naziv = rs.getString("Naziv");
                String lokacija = rs.getString("Lokacija");
                
                Teretana teretana = new Teretana(id, naziv, lokacija);
                lista.add(teretana);
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
