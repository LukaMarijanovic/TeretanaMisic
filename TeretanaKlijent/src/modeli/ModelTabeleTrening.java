/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.OpstiDomenskiObjekat;
import domen.Trening;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luka.marijanovic
 */
public class ModelTabeleTrening extends AbstractTableModel{
    List<Trening> listaTreninga;
    String[] kolone = {"Naziv", "Vrsta"};
    
    public ModelTabeleTrening(){
        
    }
    
     public ModelTabeleTrening(List<OpstiDomenskiObjekat> lista){
         listaTreninga = new ArrayList<>();
        for (OpstiDomenskiObjekat odo : lista) {
            Trening tr = (Trening) odo;
            listaTreninga.add(tr);
        }
    }

    @Override
    public int getRowCount() {
        return listaTreninga.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trening trening = listaTreninga.get(rowIndex);
        switch(columnIndex){
            case 0:
                return trening.getNaziv();
            case 1:
                return trening.getVrsta();
            default:
                return "";
        }
    }
     
    @Override
     public String getColumnName(int column){
         return kolone[column];
     }
     
     public Trening vratiTrening(int red){
         return listaTreninga.get(red);
     }
}
