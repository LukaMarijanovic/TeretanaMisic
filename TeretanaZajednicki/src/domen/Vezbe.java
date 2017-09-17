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
    private Trening trening;
     private int vezbeID;
    private String naziv;
    private String fokus;
    private int vremeTrajanja;
    private String kriterijumPretrage;
    
    public Vezbe(){
        
    }
    
     public Vezbe(int vezbeID, String naziv, String fokus, int vremeTrajanja){
        this.vezbeID = vezbeID;
        this.naziv = naziv;
        this.fokus = fokus;
        this.vremeTrajanja = vremeTrajanja;
    }
    
    public Vezbe(Trening trening,int vezbeID, String naziv, String fokus, int vremeTrajanja){
        this.trening = trening;
        this.vezbeID = vezbeID;
        this.naziv = naziv;
        this.fokus = fokus;
        this.vremeTrajanja = vremeTrajanja;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
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

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
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
            int treningid = rs.getInt("TreningID");
            String nazivtr = rs.getString("Naziv");
            Trening tr = new Trening(treningid, nazivtr, null);
                int id = rs.getInt("VezbaID");
                String naziv = rs.getString("Naziv");
                String fokus = rs.getString("Fokus");
                int vremeTrajanja = rs.getInt("VremeTrajanja");
                
                Vezbe vezbe = new Vezbe(tr, id, naziv, fokus, vremeTrajanja);
                lista.add(vezbe);
            }
        return lista;
    }

    @Override
    public String vratiSve() {
        return "vezbe v JOIN trening t ON v.treningid = t.treningid";
    }

    @Override
    public String vratiKolonu() {
        return "VezbaID";
    }

    @Override
    public String vratiUslov() {
           try {
                int id = Integer.parseInt(kriterijumPretrage);
                return "VezbaID = " +id;
            } catch (Exception e) {
                return "Naziv like '%" + kriterijumPretrage + "%' OR Fokus like '%"
                        + kriterijumPretrage  + "%'";
            }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "Naziv= '" + naziv + "' Fokus= '" + fokus + "Vreme trajanja='" + vremeTrajanja + "'";
    }

    @Override
    public String vratiUslovZaUpdate() {
        System.out.println(vezbeID);
        return "VezbaID = '" + vezbeID + "'";
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
