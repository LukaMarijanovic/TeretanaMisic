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
public class Vezbac extends OpstiDomenskiObjekat implements Serializable{
     private int vezbacID;
    private String ime;
    private String prezime;
    private double visina;
    private double tezina;
    private int clanarina;
    
    public Vezbac(){
        
    }
    
    public Vezbac(int vezbacID, String ime, String prezime, double visina, double tezina, int clanarina){
        this.vezbacID = vezbacID;
        this.ime = ime;
        this.prezime = prezime;
        this.visina = visina;
        this.tezina = tezina;
        this.clanarina = clanarina;
    }

    public int getVezbacID() {
        return vezbacID;
    }

    public void setVezbacID(int vezbacID) {
        this.vezbacID = vezbacID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public double getVisina() {
        return visina;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public int getClanarina() {
        return clanarina;
    }

    public void setClanarina(int clanarina) {
        this.clanarina = clanarina;
    }
    
    @Override
    public String toString(){
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "vezbac";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return ", '" + ime + "' , '" + prezime + "','" + visina + "','" + tezina + "','" + clanarina + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
                int id = rs.getInt("ID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                double visina = rs.getDouble("Visina");
                double tezina = rs.getDouble("Tezina");
                int clanarina = rs.getInt("Clanarina");
                
                Vezbac vezbac = new Vezbac(id, ime, prezime, visina, tezina, clanarina);
                lista.add(vezbac);
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
