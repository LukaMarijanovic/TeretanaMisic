/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Lazar
 */
public class ServerTransferKlasa implements Serializable{
    private int status;
    private Object odgovor;
    private String greska;

    public ServerTransferKlasa() {
    }

    public ServerTransferKlasa(int status, Object odgovor, String greska) {
        this.status = status;
        this.odgovor = odgovor;
        this.greska = greska;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getGreska() {
        return greska;
    }

    public void setGreska(String greska) {
        this.greska = greska;
    }
    
    
}
