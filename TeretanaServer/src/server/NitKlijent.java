/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.OpstiDomenskiObjekat;
import domen.Trening;
import domen.Vezbac;
import domen.Vezbe;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import transfer.KlijentTransferKlasa;
import transfer.ServerTransferKlasa;
import util.Konstante;

/**
 *
 * @author Lazar
 */
public class NitKlijent extends Thread{
    Socket socket;
    boolean aktivan;
    StartovanjeServera startovanje;

    
    public NitKlijent(Socket socket, StartovanjeServera startovanje){
        this.socket = socket;
        this.aktivan = true;
        this.startovanje = startovanje;
    }
    
    @Override
    public void run(){
        while(aktivan){
            KlijentTransferKlasa ktk = primiZahtev();
            ServerTransferKlasa stk = new ServerTransferKlasa();
            switch(ktk.getOperacija()){
                case Konstante.OPERACIJA_IZMENI_TRENING:
                    try{
                         Kontroler.getInstance().izmeniTrening((Trening) ktk.getParametar());
                         stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                    }
                    catch(Exception ex){
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                        stk.setGreska(ex.getMessage());
                    };
                   break;
                case Konstante.OPERACIJA_IZMENI_VEZBACE:
                      try{
                         Kontroler.getInstance().izmeniVezbaca((Vezbac) ktk.getParametar());
                         stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                    }
                    catch(Exception ex){
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                        stk.setGreska(ex.getMessage());
                    };
                    break;
                case Konstante.OPERACIJA_IZMENI_VEZBE:
                     try{
                         Kontroler.getInstance().izmeniVezbu((Vezbe) ktk.getParametar());
                         stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                    }
                    catch(Exception ex){
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                        stk.setGreska(ex.getMessage());
                    };
                    break;
                case Konstante.OPERACIJA_SACUVAJ_TRENING:
                    try{
                         Kontroler.getInstance().kreirajTrening((Trening) ktk.getParametar());
                         for(Vezbe vezba : ((Trening) ktk.getParametar()).getListaVezbi()){
                             Kontroler.getInstance().kreirajVezbu(vezba);
                         }
                         stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                    }
                    catch(Exception ex){
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                        stk.setGreska(ex.getMessage());
                    };
                    break;
                case Konstante.OPERACIJA_SACUVAJ_VEZBACA:
                     try{
                         Kontroler.getInstance().kreirajVezbaca((Vezbac) ktk.getParametar());
                         stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                    }
                    catch(Exception ex){
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                        stk.setGreska(ex.getMessage());
                    };
                    break;
                case Konstante.OPERACIJA_SACUVAJ_VEZBU:
                     try{
                         Kontroler.getInstance().kreirajVezbu((Vezbe) ktk.getParametar());
                         stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                    }
                    catch(Exception ex){
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                        stk.setGreska(ex.getMessage());
                    };
                    break;
                case Konstante.OPERACIJA_VRATI_TRENINGE:
                    try {
                    List<OpstiDomenskiObjekat> treninzi = Kontroler.getInstance().vratiSveTreninge();
                    stk.setOdgovor(treninzi);
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                } catch (Exception ex) {
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                    stk.setGreska(ex.getMessage());
                }
                    break;
                case Konstante.OPERACIJA_VRATI_VEZBACE:
                      try {
                    List<OpstiDomenskiObjekat> vezbaci = Kontroler.getInstance().vratiSveVezbace();
                    stk.setOdgovor(vezbaci);
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                } catch (Exception ex) {
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                    stk.setGreska(ex.getMessage());
                }
                    break;
                case Konstante.OPERACIJA_VRATI_VEZBE:
                     try {
                    List<OpstiDomenskiObjekat> vezbe = Kontroler.getInstance().vratiSveVezbe();
                    stk.setOdgovor(vezbe);
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                } catch (Exception ex) {
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                    stk.setGreska(ex.getMessage());
                }
                    break;
                case Konstante.OPERACIJA_VRATI_VEZBACA_NA_TRENINGU:
                      try {
                    List<OpstiDomenskiObjekat> vezbacnatreningu = Kontroler.getInstance().vratiVezbacaNaTreningu();
                    stk.setOdgovor(vezbacnatreningu);
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                } catch (Exception ex) {
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                    stk.setGreska(ex.getMessage());
                }
                    break;
                 case Konstante.OPERACIJA_PRETRAZI_VEZBACE:
                    try {
                    List<OpstiDomenskiObjekat> lista = Kontroler.getInstance().pretraziVezbaca((String) ktk.getParametar());
                    stk.setOdgovor(lista);
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                } catch (Exception ex) {
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                    stk.setGreska(ex.getMessage());
                }               
                break;
                  case Konstante.OPERACIJA_PRETRAZI_TRENINGE:
                    try {
                    List<OpstiDomenskiObjekat> lista = Kontroler.getInstance().pretraziTrening((String) ktk.getParametar());
                    stk.setOdgovor(lista);
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                } catch (Exception ex) {
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                    stk.setGreska(ex.getMessage());
                }               
                break;
                   case Konstante.OPERACIJA_PRETRAZI_VEZBE:
                    try {
                    List<OpstiDomenskiObjekat> lista = Kontroler.getInstance().pretraziVezbu((String) ktk.getParametar());
                    stk.setOdgovor(lista);
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                } catch (Exception ex) {
                    stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                    stk.setGreska(ex.getMessage());
                }               
                break;  
                case Konstante.OPERACIJA_BRISANJE_VEZBACA:
                    try {
                        Kontroler.getInstance().obrisiVezbaca((String) ktk.getParametar());
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                    } catch (Exception ex) {
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                        stk.setGreska(ex.getMessage());
                    }                                   
                break;
                 case Konstante.OPERACIJA_BRISANJE_TRENINGA:
                    try {
                        Kontroler.getInstance().obrisiTrening((String) ktk.getParametar());
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                    } catch (Exception ex) {
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                        stk.setGreska(ex.getMessage());
                    }                                   
                break;
                case Konstante.OPERACIJA_BRISANJE_VEZBE:
                    try {
                        Kontroler.getInstance().obrisiVezbu((String) ktk.getParametar());
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_OK);
                    } catch (Exception ex) {
                        stk.setStatus(Konstante.SERVER_STATUS_OPERACIJA_NOT_OK);
                        stk.setGreska(ex.getMessage());
                    }                                   
                break;
            }
            posaljiOdgovor(stk);
        }
    }
    
    public KlijentTransferKlasa primiZahtev(){
        KlijentTransferKlasa kto = new KlijentTransferKlasa();
        try {          
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            kto = (KlijentTransferKlasa) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kto;
    }
    
    public void posaljiOdgovor(ServerTransferKlasa sto){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(sto);
        } catch (IOException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
