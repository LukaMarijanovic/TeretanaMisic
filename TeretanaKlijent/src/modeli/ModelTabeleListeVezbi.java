/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.OpstiDomenskiObjekat;
import domen.Trening;
import domen.Vezbe;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luka.marijanovic
 */
public class ModelTabeleListeVezbi extends AbstractTableModel{
     List<Vezbe> listaVezbi;
    String[] kolone = {"Naziv", "Fokus", "Vreme trajanja"};
    
    public ModelTabeleListeVezbi(){
        
    }
    
     public ModelTabeleListeVezbi(List<OpstiDomenskiObjekat> lista){
         listaVezbi = new ArrayList<>();
        for (OpstiDomenskiObjekat odo : lista) {
            Vezbe vez = (Vezbe) odo;
            listaVezbi.add(vez);
        }
    }

    @Override
    public int getRowCount() {
        return listaVezbi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vezbe vezbe = listaVezbi.get(rowIndex);
        switch(columnIndex){
            case 0:
                return vezbe.getNaziv();
            case 1:
                return vezbe.getFokus();
            case 2:
                return vezbe.getVremeTrajanja();
            default:
                return "";
        }
    }
     
    @Override
     public String getColumnName(int column){
         return kolone[column];
     }
     
     public Vezbe vratiVezbu(int red){
         return listaVezbi.get(red);
     }
}
