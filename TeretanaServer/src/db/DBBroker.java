/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lazar
 */
public class DBBroker {
    private static DBBroker instanca;
    Connection konekcija;
    
    public DBBroker(){
        
    }
    
    public DBBroker(Connection konekcija){
        this.konekcija = konekcija;
    }
    
    public static DBBroker getInstance(){
        if(instanca == null)
            instanca = new DBBroker();
        return instanca;
    }
    
    public void ucitajDrajver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void otvoriKonekciju(){
        try {
            konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/teretana", "root", "");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zatvoriKonekciju(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void kreiraj(OpstiDomenskiObjekat odo) throws Exception{
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES(' "+vratiPoslednjiRB(odo)+"'" + odo.vratiVrednostiZaInsert() + ") ";
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }
    
    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT * FROM " + odo.vratiSve();
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.vratiListu(rs);
    }
    
    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE" + odo.vratiUslov();
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }
    
    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiUslovZaUpdate();
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }
    
     public void ubaciSve(OpstiDomenskiObjekat odo)throws Exception{
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES ( " + odo.vratiVrednostiZaInsert() + ")";
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    } 
     
       public List<OpstiDomenskiObjekat> vratiSaUslovom(OpstiDomenskiObjekat odo)throws Exception{
        String upit = "SELECT * FROM " + odo.vratiSve() + " WHERE " +odo.vratiUslov();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.vratiListu(rs);
    }
       
        public int vratiPoslednjiRB(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT MAX(" + odo.vratiKolonu() + ") AS MAX FROM " + odo.vratiNazivTabele();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        rs.next();
        return rs.getInt("MAX") +1;
    }
        
          public int vratiSlobodanID(OpstiDomenskiObjekat odo) throws Exception {
        String upit = "SELECT " +odo.vratiKolonu()+ " FROM " + odo.vratiNazivTabele() + " ORDER BY "+odo.vratiKolonu()+" ASC";
        System.out.println(upit);
        Statement sqlStatement = konekcija.createStatement();
        ResultSet rs = sqlStatement.executeQuery(upit);
        return odo.vratiSlobodanID(rs);
    }
}
