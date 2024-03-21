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
import java.util.logging.Level;
import java.util.logging.Logger;


public class UtilisateurDAO {

    private Connection connexion;

    public UtilisateurDAO() throws Exception {
        this.connexion = MySQLConnection.getConnexion();
    }

    public Utilisateur create(Utilisateur utilisateur) {
        return utilisateur;
    }
    
    public List<Utilisateur> getAll() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        String query = "SELECT * FROM UTILISATEUR";
        Statement statement;
        try {
            statement = this.connexion.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                int id = Integer.parseInt(result.getString("ID_UTILISATEUR"));
                String nom = result.getString("NOM_UTILISATEUR");
                String prenom = result.getString("PRENOM_UTILISATEUR");
                String email = result.getString("EMAIL_UTILISATEUR");
                int telephone = Integer.parseInt(result.getString("NO_TELEPHONE_UTILISATEUR"));
                String adresse = result.getString("ADRESSE_UTILISATEUR");
                String ville = result.getString("VILLE_UTILISATEUR");
                int cp = Integer.parseInt(result.getString("CP_UTILISATEUR"));
                String fonction = result.getString("FONCTION_UTILISATEUR");
                String mdp = result.getString("MDP_HASH_UTILISATEUR");
                Utilisateur utilisateur = new Utilisateur(id, email, telephone, nom, prenom, ville, adresse, cp, fonction, mdp);
                utilisateurs.add(utilisateur);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return utilisateurs;
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
