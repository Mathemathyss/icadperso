package icad.DAO;

import icad.model.MySQLConnection;
import icad.model.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UtilisateurDAO {

    private Connection connexion;

    public UtilisateurDAO() throws Exception {
        this.connexion = MySQLConnection.getConnexion();
    }

    public Utilisateur create(Utilisateur utilisateur) {
        return utilisateur;
    }

    public static Connection getConnexion() {
        return getConnexion();
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = UtilisateurDAO.getConnexion();
            preparedStatement = connexion.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
            preparedStatement.setString(1, utilisateur.getNOM_UTILISATEUR());
            preparedStatement.setString(2, utilisateur.getPRENOM_UTILISATEUR());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Utilisateur> lister() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = UtilisateurDAO.getConnexion();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT nom, prenom FROM noms;");

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");

//                Utilisateur utilisateur = new Utilisateur();
//                utilisateur.setNOM_UTILISATEUR(nom);
//                utilisateur.setPRENOM_UTILISATEUR(prenom);

//                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

//    public Utilisateur get(int ID_UTILISATEUR) {
//    return instance ;
//    }
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
}
