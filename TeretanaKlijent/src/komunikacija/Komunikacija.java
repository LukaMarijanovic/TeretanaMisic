/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domen.OpstiDomenskiObjekat;
import domen.Trening;
import domen.Vezbac;
import domen.VezbacNaTreningu;
import domen.Vezbe;
import forme.FrmPretragaTreninga;
import forme.FrmPretragaVezbaca;
import forme.FrmPretragaVezbi;
import forme.FrmUnosTreninga;
import forme.FrmUnosVezbaca;
import forme.FrmUnosVezbe;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentTransferKlasa;
import transfer.ServerTransferKlasa;
import util.Konstante;

/**
 *
 * @author Lazar
 */
public class Komunikacija {
    private static Komunikacija instanca;
    Socket socket;
    
    private int aktivan_sk;
    private String kriterijumPretrage = "";
    
    private Vezbac vezbac;
    private Trening trening;
    private Vezbe vezbe;
    private VezbacNaTreningu vezbacnatreningu;
    
    private FrmUnosVezbaca frmUnosVezbaca;
    private FrmUnosTreninga frmUnosTreninga;
    private FrmUnosVezbe frmUnosVezbe;
    private FrmPretragaVezbaca frmPretragaVezbaca;
    private FrmPretragaTreninga frmPretragaTreninga;
    private FrmPretragaVezbi frmPretragaVezbi;
    
    public Komunikacija(){

    }
    
    public static Komunikacija getInstance(){
        if(instanca == null)
            instanca = new Komunikacija();
        return instanca;
    }
    
    public void posaljiZahtev(KlijentTransferKlasa kto){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(kto);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerTransferKlasa primiOdgovor(){
        ServerTransferKlasa sto = new ServerTransferKlasa();
        try {           
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            sto = (ServerTransferKlasa) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sto;
    }
    
    public void poveziNaServer(){
       try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getAktivan_sk() {
        return aktivan_sk;
    }

    public void setAktivan_sk(int aktivan_sk) {
        this.aktivan_sk = aktivan_sk;
    }

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public Vezbac getVezbac() {
        return vezbac;
    }

    public void setVezbac(Vezbac vezbac) {
        this.vezbac = vezbac;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Vezbe getVezbe() {
        return vezbe;
    }

    public void setVezbe(Vezbe vezbe) {
        this.vezbe = vezbe;
    }

    public VezbacNaTreningu getVezbacnatreningu() {
        return vezbacnatreningu;
    }

    public void setVezbacnatreningu(VezbacNaTreningu vezbacnatreningu) {
        this.vezbacnatreningu = vezbacnatreningu;
    }

    public FrmUnosVezbaca getFrmUnosVezbaca() {
        return frmUnosVezbaca;
    }

    public void setFrmUnosVezbaca(FrmUnosVezbaca frmUnosVezbaca) {
        this.frmUnosVezbaca = frmUnosVezbaca;
    }

    public FrmUnosTreninga getFrmUnosTreninga() {
        return frmUnosTreninga;
    }

    public void setFrmUnosTreninga(FrmUnosTreninga frmUnosTreninga) {
        this.frmUnosTreninga = frmUnosTreninga;
    }

    public FrmUnosVezbe getFrmUnosVezbe() {
        return frmUnosVezbe;
    }

    public void setFrmUnosVezbe(FrmUnosVezbe frmUnosVezbe) {
        this.frmUnosVezbe = frmUnosVezbe;
    }

    public FrmPretragaVezbaca getFrmPretragaVezbaca() {
        return frmPretragaVezbaca;
    }

    public void setFrmPretragaVezbaca(FrmPretragaVezbaca frmPretragaVezbaca) {
        this.frmPretragaVezbaca = frmPretragaVezbaca;
    }

    public FrmPretragaTreninga getFrmPretragaTreninga() {
        return frmPretragaTreninga;
    }

    public void setFrmPretragaTreninga(FrmPretragaTreninga frmPretragaTreninga) {
        this.frmPretragaTreninga = frmPretragaTreninga;
    }

    public FrmPretragaVezbi getFrmPretragaVezbi() {
        return frmPretragaVezbi;
    }

    public void setFrmPretragaVezbi(FrmPretragaVezbi frmPretragaVezbi) {
        this.frmPretragaVezbi = frmPretragaVezbi;
    }
    
    
    
    public List<OpstiDomenskiObjekat> vratiVezbace() throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_VRATI_VEZBACE);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) stk.getOdgovor();
    }
    
    public void sacuvajVezbaca(Vezbac vezbac) throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_SACUVAJ_VEZBACA);
        ktk.setParametar(vezbac);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
    }
    
    public void obrisiVezbaca(String kriterijumBrisanja) throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_BRISANJE_VEZBACA);
        ktk.setParametar(kriterijumBrisanja);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
    }
    
     public void izmeniVezbaca(Vezbac vezbac) throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_IZMENI_VEZBACE);
        ktk.setParametar(vezbac);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
    }
     
     public List<OpstiDomenskiObjekat> vratiTreninge() throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_VRATI_TRENINGE);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) stk.getOdgovor();
    }
     
      public void sacuvajTrening(Trening trening) throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_SACUVAJ_TRENING);
        ktk.setParametar(trening);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
    }
      
       public void obrisiTrening(String kriterijumBrisanja) throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_BRISANJE_TRENINGA);
        ktk.setParametar(kriterijumBrisanja);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
    }
       
        public void izmeniTrening(Trening trening) throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_IZMENI_TRENING);
        ktk.setParametar(trening);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
    }
        
        public List<OpstiDomenskiObjekat> vratiVezbe() throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_VRATI_VEZBE);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) stk.getOdgovor();
    }
        
        public void sacuvajVezbu(Vezbe vezbe) throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_SACUVAJ_VEZBU);
        ktk.setParametar(vezbe);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
    } 
        
        public void obrisiVezbe(String kriterijumBrisanja) throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_BRISANJE_VEZBE);
        ktk.setParametar(kriterijumBrisanja);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
    } 
        
        public void izmeniVezbu(Vezbe vezbe) throws Exception{
        KlijentTransferKlasa ktk = new KlijentTransferKlasa();
        ktk.setOperacija(Konstante.OPERACIJA_IZMENI_VEZBE);
        ktk.setParametar(vezbe);
        Komunikacija.getInstance().posaljiZahtev(ktk);
        
        ServerTransferKlasa stk = Komunikacija.getInstance().primiOdgovor();
        if(stk.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
            throw new Exception(stk.getGreska());
        }
    } 
        
            public List<OpstiDomenskiObjekat> pretraziVezbace(String kriterijum) throws Exception{
            KlijentTransferKlasa kto = new KlijentTransferKlasa();
            kto.setOperacija(Konstante.OPERACIJA_PRETRAZI_VEZBACE);
            kto.setParametar(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(kto);
            
            ServerTransferKlasa sto = Komunikacija.getInstance().primiOdgovor();
            if(sto.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
                sto.setGreska(kriterijumPretrage);
                throw new Exception(sto.getGreska());
            }
        return (List<OpstiDomenskiObjekat>) sto.getOdgovor();
    }
            
            public List<OpstiDomenskiObjekat> pretraziTreninge(String kriterijum) throws Exception{
            KlijentTransferKlasa kto = new KlijentTransferKlasa();
            kto.setOperacija(Konstante.OPERACIJA_PRETRAZI_TRENINGE);
            kto.setParametar(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(kto);
            
            ServerTransferKlasa sto = Komunikacija.getInstance().primiOdgovor();
            if(sto.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
                sto.setGreska(kriterijumPretrage);
                throw new Exception(sto.getGreska());
            }
        return (List<OpstiDomenskiObjekat>) sto.getOdgovor();
    }
            
             public List<OpstiDomenskiObjekat> pretraziVezbe(String kriterijum) throws Exception{
            KlijentTransferKlasa kto = new KlijentTransferKlasa();
            kto.setOperacija(Konstante.OPERACIJA_PRETRAZI_VEZBE);
            kto.setParametar(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(kto);
            
            ServerTransferKlasa sto = Komunikacija.getInstance().primiOdgovor();
            if(sto.getStatus() == Konstante.SERVER_STATUS_OPERACIJA_NOT_OK){
                sto.setGreska(kriterijumPretrage);
                throw new Exception(sto.getGreska());
            }
        return (List<OpstiDomenskiObjekat>) sto.getOdgovor();
    }
}
