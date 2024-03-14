package icad.DAO;

import icad.model.MySQLConnection;
import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jb.loirot
 */
public class UtilisateurDAO {

    private Connection connexion;

    public UtilisateurDAO() throws Exception {
        this.connexion = MySQLConnection.getConnexion();
    }

//public Utilisateur create (Utilisateur utilisateur){
//    
//}
//
//public Utilisateur get(Interger ID_UTILISATEUR) {
//    
//}
}
