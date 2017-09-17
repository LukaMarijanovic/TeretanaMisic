/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Trening;
import domen.Vezbe;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luka.marijanovic
 */
public class ModelTabeleVezba extends AbstractTableModel{
    Trening trening;
    List<Vezbe> vezbe;
    String[] kolone = {"ID", "Naziv", "Fokus", "Vreme trajanja"};
    
    public ModelTabeleVezba(){
        vezbe = trening.getListaVezbi();
    }
    
    public ModelTabeleVezba(Trening trening){
        this.trening = trening;
    }
    

    public List<Vezbe> getVezbe() {
        return vezbe;
    }

    public void setVezbe(List<Vezbe> vezbe) {
        this.vezbe = vezbe;
    }


    @Override
    public int getRowCount() {
        return vezbe.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vezbe vezba = trening.getListaVezbi().get(rowIndex);
        switch(columnIndex){
            case 0:
                return vezba.getVezbeID();
            case 1:
                return vezba.getNaziv();
            case 2:
                return vezba.getFokus();
            case 3:
                return vezba.getVremeTrajanja();
            default:
                return "";
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Vezbe vezba = trening.getListaVezbi().get(rowIndex);
        switch(columnIndex){
            case 0:
                vezba.setVezbeID(Integer.parseInt((String) aValue));
                break;
            case 1:
                vezba.setNaziv((String) aValue);
                break;
            case 2:
                vezba.setFokus((String) aValue);
                break;
            case 3:
                vezba.setVremeTrajanja(Integer.parseInt((String) aValue));
                break;
        }
    }
    
    @Override
    public String getColumnName(int column){
        return kolone[column];
    }
    
    public void dodajVezbu(){
        Vezbe vezbe = new Vezbe();
        vezbe.setTrening(trening);
        trening.getListaVezbi().add(vezbe);
        fireTableDataChanged();
    }
    
    public void obrisiVezbu(int red){
        trening.getListaVezbi().remove(red);
        fireTableDataChanged();
    }
}
