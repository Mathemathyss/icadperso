package icad.DAO;

import icad.model.MySQLConnection;
import icad.model.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

//    public void ajouterUtilisateur(Utilisateur utilisateur) {
//        Connection connexion = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connexion = UtilisateurDAO.getConnexion();
//            preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur VALUES ("","","","","","","","","","");";
//            preparedStatement.setString(1, utilisateur.getNOM_UTILISATEUR());
//            preparedStatement.setString(2, utilisateur.getPRENOM_UTILISATEUR());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
}
