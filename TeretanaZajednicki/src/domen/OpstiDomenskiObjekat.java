/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lazar
 */
public abstract class OpstiDomenskiObjekat {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int vratiVrednostPrimarnogKljuca() {
        return id;
    }
    
    public abstract String vratiNazivTabele();
    
    public abstract String vratiVrednostiZaInsert();
    
    public abstract List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException;
    
    public abstract String vratiSve();
    
    public abstract String vratiKolonu();
    
    public abstract String vratiUslov();
    
    public abstract String vratiVrednostiZaUpdate();
    
    public abstract String vratiUslovZaUpdate();
    
    public abstract String vratiUslovZaID();
    
    public abstract int vratiID(ResultSet rs);
    
     public int vratiSlobodanID(ResultSet rs) throws SQLException {
        int slobodanID = 0;
        List<Integer> listaID = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            listaID.add(id);
        }

        if (listaID.size() == 0) {
            return 1;
        }
        for (int i = 0; i < listaID.size(); i++) {
            if ((i + 1) == listaID.size()) {
                return listaID.get(i) + 1;
            } else if ((listaID.get(i) + 1) < listaID.get(i + 1)) {
                return listaID.get(i) + 1;
            }
        }
        return slobodanID;
    }
}
