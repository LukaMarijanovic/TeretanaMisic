/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forme.FrmServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lazar
 */
public class StartovanjeServera extends Thread{

    private boolean kraj;
    private FrmServer forma;
    
    public StartovanjeServera(FrmServer forma){
        kraj = false;
        this.forma = forma;
    }
    
    public void pokreniServer() throws IOException{
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Server se pokrenuo");
        while(!kraj){
            Socket socket = ss.accept();
            System.out.println("Klijent se povezao");
            NitKlijent nk = new NitKlijent(socket, this);
            nk.start();
        }
    }
    
    @Override
    public void run(){
        try {
            pokreniServer();
        } catch (IOException ex) {
            Logger.getLogger(StartovanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
