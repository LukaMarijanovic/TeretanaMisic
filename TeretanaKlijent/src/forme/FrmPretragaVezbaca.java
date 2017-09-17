/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.OpstiDomenskiObjekat;
import domen.Vezbac;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import modeli.ModelTabeleVezbac;
import util.Konstante;

/**
 *
 * @author luka.marijanovic
 */
public class FrmPretragaVezbaca extends javax.swing.JFrame {

    /**
     * Creates new form FrmPretragaVezbaca
     */
    public FrmPretragaVezbaca() {
        initComponents();
        Komunikacija.getInstance().setFrmPretragaVezbaca(this);
        popuniTabeluVezbaci();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPretraga = new javax.swing.JTextField();
        jButtonPretrazi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVezbac = new javax.swing.JTable();
        jButtonDetalji = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ptretraga vezbaca"));

        jLabel1.setText("Pretraga:");

        jButtonPretrazi.setText("Pretrazi");
        jButtonPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPretraziActionPerformed(evt);
            }
        });

        jLabel2.setText("ID/Ime/Prezime");

        jTableVezbac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableVezbac);

        jButtonDetalji.setText("Detalji");
        jButtonDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetaljiActionPerformed(evt);
            }
        });

        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        jButtonObrisi.setText("Obrisi");
        jButtonObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButtonPretrazi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonDetalji)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonIzmeni)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonObrisi)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPretrazi))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDetalji)
                    .addComponent(jButtonIzmeni)
                    .addComponent(jButtonObrisi)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiActionPerformed
        // TODO add your handling code here:
         int red = jTableVezbac.getSelectedRow();
        if(red != -1){
        try {
            
                Vezbac vezbac = ((ModelTabeleVezbac)jTableVezbac.getModel()).vratiVezbaca(red);
                Komunikacija.getInstance().obrisiVezbaca(vezbac.getVezbacID()+"");
                prikaziPorukuObavestenja("Sistem je uspešno obrisao vezbaca");
                osvezi();
            
        } catch (Exception e) {
            e.printStackTrace();
            prikaziPorukuGreske("Sistem ne može da obriše vezbaca");
        }
      }
    }//GEN-LAST:event_jButtonObrisiActionPerformed

    private void jButtonPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPretraziActionPerformed
        // TODO add your handling code here:
         try {
            String kriterijum = jTextFieldPretraga.getText().trim();
            Komunikacija.getInstance().setKriterijumPretrage(kriterijum);
            if(kriterijum.isEmpty()){
                popuniTabeluVezbaci();
            }else{
                List<OpstiDomenskiObjekat> lista = Komunikacija.getInstance().pretraziVezbace(kriterijum);
                if(!lista.isEmpty()){
                    postaviModelTabele(lista);
                    prikaziPorukuObavestenja("Sistem je pronašao vezbace po zadatoj vrednosti");
                }else{
                    postaviModelTabele(new ArrayList<OpstiDomenskiObjekat>());
                    prikaziPorukuGreske("Sistem ne može da pronađe vezbace po zadatoj vrednosti");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonPretraziActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        // TODO add your handling code here:
        preuzmiSelektovanogVezbaca(Konstante.SK_IZMENA);
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetaljiActionPerformed
        // TODO add your handling code here:
        preuzmiSelektovanogVezbaca(Konstante.SK_PRIKAZ);
    }//GEN-LAST:event_jButtonDetaljiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPretragaVezbaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPretragaVezbaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPretragaVezbaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPretragaVezbaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPretragaVezbaca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetalji;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVezbac;
    private javax.swing.JTextField jTextFieldPretraga;
    // End of variables declaration//GEN-END:variables

 private void popuniTabeluVezbaci() {
        try {
            List<OpstiDomenskiObjekat> lista = Komunikacija.getInstance().vratiVezbace();
            postaviModelTabele(lista);
        } catch (Exception ex) {
            prikaziPorukuGreske("Problem pri ucitavanju vezbaca");
        }
    }

    private void postaviModelTabele(List<OpstiDomenskiObjekat> lista) {
        jTableVezbac.setModel(new ModelTabeleVezbac(lista));
    }

    private void prikaziPorukuGreske(String poruka) {
        JOptionPane.showMessageDialog(this, poruka, "Greška!", JOptionPane.ERROR_MESSAGE);
    }

    private void prikaziPorukuObavestenja(String poruka) {
        JOptionPane.showMessageDialog(this, poruka, "Obavestenje!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void osvezi() {
        try {
            String kriterijum = Komunikacija.getInstance().getKriterijumPretrage();
            if (kriterijum.isEmpty()) {
                popuniTabeluVezbaci();
            } else {
                List<OpstiDomenskiObjekat> lista = Komunikacija.getInstance().pretraziVezbace(kriterijum);
                if (!lista.isEmpty()) {
                    postaviModelTabele(lista);
                } else {
                    postaviModelTabele(new ArrayList<OpstiDomenskiObjekat>());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preuzmiSelektovanogVezbaca(int sk) {
        int red = jTableVezbac.getSelectedRow();
        
        if(red != -1){
            try {
                Vezbac izabraniVezbac = ((ModelTabeleVezbac) jTableVezbac.getModel()).vratiVezbaca(red);
                List<OpstiDomenskiObjekat> lista = Komunikacija.getInstance().pretraziVezbace(izabraniVezbac.getVezbacID()+"");
                
                if(!lista.isEmpty()){
                    prikaziPorukuObavestenja("Sistem je uspešno učitao podatke o vezbacu");
                    Vezbac vezbac = (Vezbac) lista.get(0);
                    Komunikacija.getInstance().setVezbac(vezbac);
                    Komunikacija.getInstance().setAktivan_sk(sk);
                    new FrmUnosVezbaca(vezbac).setVisible(true);
                }else{
                    prikaziPorukuGreske("Sistem ne može da učita podatke o vezbacu");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            prikaziPorukuGreske("Niste selektovali vezbaca");
        }
    }
}
