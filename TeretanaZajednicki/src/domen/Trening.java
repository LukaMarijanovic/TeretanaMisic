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
public class Trening extends OpstiDomenskiObjekat implements Serializable{
     private int treningID;
    private String naziv;
    private String vrsta;
    private List<Vezbe> listaVezbi;
    private String kriterijumPretrage;
    
    public Trening(){
        
    }
    
    public Trening(int treningID, String naziv, String vrsta){
        this.treningID = treningID;
        this.naziv = naziv;
        this.vrsta = vrsta;
    }
    
     public Trening(int treningID, String naziv, String vrsta, List<Vezbe> listaVezbi){
        this.treningID = treningID;
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.listaVezbi = listaVezbi;
    }

    public int getTreningID() {
        return treningID;
    }

    public void setTreningID(int treningID) {
        this.treningID = treningID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public List<Vezbe> getListaVezbi() {
        return listaVezbi;
    }

    public void setListaVezbi(List<Vezbe> listaVezbi) {
        this.listaVezbi = listaVezbi;
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
        return "trening";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return ", '" + naziv + "' , '" + vrsta + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
         while(rs.next()){
                int id = rs.getInt("ID");
                String naziv = rs.getString("Naziv");
                String vrsta = rs.getString("Vrsta");
                
                Trening trening = new Trening(id, naziv, vrsta);
                lista.add(trening);
            }
         return lista;
    }

    @Override
    public String vratiSve() {
        return "trening t";
    }

    @Override
    public String vratiKolonu() {
        return "TreningID";
    }

    @Override
    public String vratiUslov() {
           try {
                int id = Integer.parseInt(kriterijumPretrage);
                return "TreningID = " +id;
            } catch (Exception e) {
                return "Naziv like '%" + kriterijumPretrage + "%' OR Vrsta like '%"
                        + kriterijumPretrage  + "%'";
            }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
       return "Naziv= '" + naziv + "' , Vrsta= '" + vrsta + "'";
    }

    @Override
    public String vratiUslovZaUpdate() {
        System.out.println(treningID);
        return "TreningID = '" + treningID + "'";
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
