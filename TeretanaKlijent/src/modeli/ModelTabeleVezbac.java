/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.OpstiDomenskiObjekat;
import domen.Vezbac;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luka.marijanovic
 */
public class ModelTabeleVezbac extends AbstractTableModel{

    List<Vezbac> listaVezbaca;
    String[] kolone = {"Vezbac ID", "Ime", "Prezime", "Visina", "Tezina", "Clanarina"};

    public ModelTabeleVezbac(List<OpstiDomenskiObjekat> lista) {
        listaVezbaca = new ArrayList<>();
        if (lista != null) {
            for (OpstiDomenskiObjekat odo : lista) {
                Vezbac kupac = (Vezbac) odo;
                listaVezbaca.add(kupac);
            }
        }
    }
    
    @Override
    public int getRowCount() {
        return listaVezbaca.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vezbac vezbac = listaVezbaca.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vezbac.getVezbacID();
            case 1:
                return vezbac.getIme();
            case 2:
                return vezbac.getPrezime();
            case 3:
                return vezbac.getVisina();
            case 4:
                return vezbac.getTezina();  
            case 5:
                return vezbac.getClanarina();
            default:
                return "N/A";

        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public Vezbac vratiVezbaca(int red) {
        return listaVezbaca.get(red);
    }
    
}
