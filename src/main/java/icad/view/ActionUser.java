package icad.view;

import icad.DAO.UtilisateurDAO;
import icad.model.Utilisateur;
import javax.swing.JTextField;


public class ActionUser extends javax.swing.JPanel {
    private int idUser;

    public ActionUser() {
        initComponents();
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    

    public void setTitre(String Titre) {
        this.JLTitre.setText(Titre);
    }

    public void setAdresseUser(String tfAdresseUser) {
        this.tfAdresseUser.setText(tfAdresseUser);
    }

    public void setCPUser(String tfCPUser) {
        this.tfCPUser.setText(tfCPUser);
    }

    public void setEmailUser(String tfEmailUser) {
        this.tfEmailUser.setText(tfEmailUser);
    }

    public void setMDPUser(String tfMDPUser) {
        this.tfMDPUser.setText(tfMDPUser);
    }

    public void setNomUser(String tfNomUser) {
        this.tfNomUser.setText(tfNomUser);
    }

    public void setPrenomUser(String tfPrenomUser) {
        this.tfPrenomUser.setText(tfPrenomUser);
    }

    public void setProfessionUser(String tfProfessionUser) {
        this.tfProfessionUser.setText(tfProfessionUser);
    }

    public void setTelUser(String tfTelUser) {
        this.tfTelUser.setText(tfTelUser);
    }

    public void setVilleUser(String tfVilleUser) {
        this.tfVilleUser.setText(tfVilleUser);
    }
    
    
    public String getAdresseUser() {
        return tfAdresseUser.getText();
    }

    public int getCPUser() {
        int codePostal = Integer.parseInt(tfCPUser.getText());
        return codePostal;        
    }

    public String getEmailUser() {
        return tfEmailUser.getText();
    }

    public String getMDPUser() {
        return tfMDPUser.getText();
    }

    public String getNomUser() {
        return tfNomUser.getText();
    }

    public String getPrenomUser() {
        return tfPrenomUser.getText();
    }

    public String getProfessionUser() {
        return tfProfessionUser.getText();
    }

    public int getTelUser() {
        int telephone = Integer.parseInt(tfTelUser.getText());
        return telephone;
    }

    public String getVilleUser() {
        return tfVilleUser.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        JLTitre = new javax.swing.JLabel();
        tfMDPUser = new javax.swing.JTextField();
        tfEmailUser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfTelUser = new javax.swing.JTextField();
        tfProfessionUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfVilleUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfAdresseUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNomUser = new javax.swing.JTextField();
        tfCPUser = new javax.swing.JTextField();
        tfPrenomUser = new javax.swing.JTextField();

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel5.setText("Ville :");

        JLTitre.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        JLTitre.setText("Créer un utilisateur");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel6.setText("Adresse :");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel10.setText("Profession : ");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel7.setText("Code Postal :");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setText("Nom :");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel8.setText("Mot de passe :");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel3.setText("Prénom :");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel9.setText("Téléphone :");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel4.setText("Email :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfProfessionUser, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCPUser, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNomUser, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                .addComponent(tfPrenomUser, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                .addComponent(tfEmailUser, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                .addComponent(tfVilleUser, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                .addComponent(tfAdresseUser, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                            .addComponent(tfMDPUser))
                        .addGap(181, 181, 181))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfTelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(JLTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPrenomUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmailUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVilleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAdresseUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCPUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMDPUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfProfessionUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(141, 141, 141))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLTitre;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tfAdresseUser;
    private javax.swing.JTextField tfCPUser;
    private javax.swing.JTextField tfEmailUser;
    private javax.swing.JTextField tfMDPUser;
    private javax.swing.JTextField tfNomUser;
    private javax.swing.JTextField tfPrenomUser;
    private javax.swing.JTextField tfProfessionUser;
    private javax.swing.JTextField tfTelUser;
    private javax.swing.JTextField tfVilleUser;
    // End of variables declaration//GEN-END:variables
}
