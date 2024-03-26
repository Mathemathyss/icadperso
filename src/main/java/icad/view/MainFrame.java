/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package icad.view;

import icad.DAO.UtilisateurDAO;
import icad.model.Utilisateur;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author m.votte
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        DefaultTableModel tblUserModel = new DefaultTableModel(
                null,
                new String[]{
                    "Nom", "Prénom", "Tel", "Email", "Adresse", "Ville", "Code Postal", "Fonction"
                }
        );
        this.tabListUser.setModel(tblUserModel);
//        tabListUser.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null}
//            },
//            new String [] {
//                "Nom", "Prénom", "Tel", "Email", "Adresse", "Ville", "Code Postal", "Fonction"
//            }
//        ));

        this.updateUI();
    }

    public void updateUI() {
        try {

            // on récupère le mondèle du Jtable
            DefaultTableModel tblUserModel = (DefaultTableModel) this.tabListUser.getModel();
            // On récupère la liste des utilsateurs
            UtilisateurDAO utilisateurDao = new UtilisateurDAO();
            List<Utilisateur> utilisateurs = utilisateurDao.getAll();
            // On vide le model 
            tblUserModel.setRowCount(0);
            // on repeuple le model à partir de la liste des utilsateurs
            for (Utilisateur utilisateur : utilisateurs) {
                tblUserModel.addRow(new Object[]{utilisateur.getNOM_UTILISATEUR(),
                    utilisateur.getPRENOM_UTILISATEUR(),
                    utilisateur.getEMAIL_UTILISATEUR(),
                    utilisateur.getNO_TEL_UTILISATEUR(),
                    utilisateur.getADRESSE_UTILISATEUR(),
                    utilisateur.getVILLE_UTILISATEUR(),
                    utilisateur.getCP_UTILISATEUR(),
                    utilisateur.getFONCTION_UTILISATEUR()});
            }
        } catch (Exception e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabListUser = new javax.swing.JTable();
        btnModifUser = new javax.swing.JButton();
        btnDelUser = new javax.swing.JButton();
        labListUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Page Principale");

        btnAddUser.setText("Ajouter un Utilisateur");
        btnAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddUserMouseExited(evt);
            }
        });
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        tabListUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabListUser);

        btnModifUser.setText("Modifier un Utilisateur");
        btnModifUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModifUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModifUserMouseExited(evt);
            }
        });
        btnModifUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifUserActionPerformed(evt);
            }
        });

        btnDelUser.setText("Supprimer un Utilisateur");
        btnDelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDelUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDelUserMouseExited(evt);
            }
        });

        labListUser.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        labListUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labListUser.setText("Liste des Utilisateurs");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(btnModifUser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(btnDelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labListUser)
                        .addGap(225, 225, 225))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(labListUser)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifUser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModifUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifUserActionPerformed
        // TODO add your handling code here:
        String[] options = {"Valider", "Annuler"};
                ActionUser actionUser = new ActionUser();
                actionUser.setTitre("Modifier un utilisateur");

        int result = JOptionPane.showOptionDialog(null,
                actionUser,
                "Modifier un utilisateur",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, //no custom icon
                options, //button titles
                options[0] //default button
        );
    }//GEN-LAST:event_btnModifUserActionPerformed

    private void btnAddUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddUserMouseEntered
        // TODO add your handling code here:        
        btnAddUser.setBackground(new Color(151, 151, 151));
    }//GEN-LAST:event_btnAddUserMouseEntered

    private void btnAddUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddUserMouseExited
        // TODO add your handling code here:
        btnAddUser.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_btnAddUserMouseExited

    private void btnModifUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModifUserMouseEntered
        // TODO add your handling code here:
        btnModifUser.setBackground(new Color(151, 151, 151));
    }//GEN-LAST:event_btnModifUserMouseEntered

    private void btnModifUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModifUserMouseExited
        // TODO add your handling code here:
        btnModifUser.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_btnModifUserMouseExited

    private void btnDelUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelUserMouseEntered
        // TODO add your handling code here:
        btnDelUser.setBackground(new Color(151, 151, 151));
    }//GEN-LAST:event_btnDelUserMouseEntered

    private void btnDelUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelUserMouseExited
        // TODO add your handling code here:
        btnDelUser.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_btnDelUserMouseExited

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // TODO add your handling code here:
                String[] options = {"Valider", "Annuler"};
                ActionUser actionUser = new ActionUser();
                actionUser.setTitre("Créer un utilisateur");

        int result = JOptionPane.showOptionDialog(null,
                actionUser,
                "Ajouter un utilisateur",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, //no custom icon
                options, //button titles
                options[0] //default button
        );
    }//GEN-LAST:event_btnAddUserActionPerformed



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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDelUser;
    private javax.swing.JButton btnModifUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labListUser;
    private javax.swing.JTable tabListUser;
    // End of variables declaration//GEN-END:variables
}
