package icad.DAO;

import icad.model.MySQLConnection;
import icad.model.Utilisateur;
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

public Utilisateur create (Utilisateur utilisateur){
        return utilisateur;
}
//
//public Utilisateur get(Interger ID_UTILISATEUR) {
//    
//}
//    public static UtilisateurDAO getInstance() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//
//        }
//        UtilisateurDAO instance = new UtilisateurDAO (
//                "jdbc:mysql://localhost:3306/javaee", "root", "");
//        return instance;
//    }
//
//    public Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(url, username, password);
//    }
//
//    // Récupération du Dao
//    public UtilisateurDAO getUtilisateurDao() {
//        return new UtilisateurDaoImpl(this);
//    }
}
