/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.OpstiDomenskiObjekat;
import domen.Trening;
import domen.Vezbac;
import domen.VezbacNaTreningu;
import domen.Vezbe;
import forme.FrmServer;
import java.util.List;
import server.StartovanjeServera;
import so.OpstaSO;
import so.SOIzmeni;
import so.SOObrisi;
import so.SOPretrazi;
import so.SOVratiListuSvih;
import so.SOZapamti;

/**
 *
 * @author Lazar
 */
public class Kontroler {
    private static Kontroler instance;
    private FrmServer forma;
    
     public Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public FrmServer getForma() {
        return forma;
    }

    public void setForma(FrmServer forma) {
        this.forma = forma;
    }
    
    public void pokreniServer(FrmServer forma){
        StartovanjeServera ss = new StartovanjeServera(forma);
        ss.start();
    }
    
    public void kreirajVezbaca(Vezbac vezbac){
        OpstaSO so = new SOZapamti();
        so.izvrsi(vezbac);
    }
    
    public List<OpstiDomenskiObjekat> vratiSveVezbace(){
        OpstaSO so = new SOVratiListuSvih();
        so.izvrsi(new Vezbac());
        return ((SOVratiListuSvih) so).getLista();
    }
    
    public List<OpstiDomenskiObjekat> pretraziVezbaca(String kriterijum) throws Exception{
        OpstaSO so = new SOPretrazi();
        Vezbac k = new Vezbac();
        k.setKriterijumPretrage(kriterijum);
        so.izvrsi(k);
        return ((SOPretrazi)so).getLista();
    }
    
    public void obrisiVezbaca(String kriterijumBrisanja){
        Vezbac vezbac = new Vezbac();
        vezbac.setKriterijumPretrage(kriterijumBrisanja);
        OpstaSO so = new SOObrisi();
        so.izvrsi(vezbac);
    }
    
    public void izmeniVezbaca(Vezbac vezbac){
        OpstaSO so = new SOIzmeni();
        so.izvrsi(vezbac);
    }
    
    public List<OpstiDomenskiObjekat> vratiVezbacaNaTreningu(){
        OpstaSO so = new SOVratiListuSvih();
        so.izvrsi(new VezbacNaTreningu());
        return ((SOVratiListuSvih) so).getLista();
    }
    
     public List<OpstiDomenskiObjekat> pretraziVezbu(String kriterijum) throws Exception{
        OpstaSO so = new SOPretrazi();
        Vezbe vez = new Vezbe();
        vez.setKriterijumPretrage(kriterijum);
        so.izvrsi(vez);
        return ((SOPretrazi)so).getLista();
    }
     
    public void kreirajVezbu(Vezbe vezba){
        OpstaSO so = new SOZapamti();
        so.izvrsi(vezba);
    }
    
    public List<OpstiDomenskiObjekat> vratiSveVezbe(){
        OpstaSO so = new SOVratiListuSvih();
        so.izvrsi(new Vezbe());
        return ((SOVratiListuSvih) so).getLista();
    }
    
    public void obrisiVezbu(String kriterijumBrisanja){
        Vezbe vezba = new Vezbe();
        OpstaSO so = new SOObrisi();
        so.izvrsi(vezba);
    }
    
    public void izmeniVezbu(Vezbe vezba){
        OpstaSO so = new SOIzmeni();
        so.izvrsi(vezba);
    }
    
     public List<OpstiDomenskiObjekat> pretraziTrening(String kriterijum) throws Exception{
        OpstaSO so = new SOPretrazi();
        Trening tr = new Trening();
        tr.setKriterijumPretrage(kriterijum);
        so.izvrsi(tr);
        return ((SOPretrazi)so).getLista();
    }
    
    public void kreirajTrening(Trening trening){
        OpstaSO so = new SOZapamti();
        so.izvrsi(trening);
    }
    
    public List<OpstiDomenskiObjekat> vratiSveTreninge(){
        OpstaSO so = new SOVratiListuSvih();
        so.izvrsi(new Trening());
        return ((SOVratiListuSvih) so).getLista();
    }
    
    public void obrisiTrening(String kriterijumBrisanja){
        Trening trening = new Trening();
        OpstaSO so = new SOObrisi();
        so.izvrsi(trening);
    }
    
    public void izmeniTrening(Trening trening){
        OpstaSO so = new SOIzmeni();
        so.izvrsi(trening);
    }
}
