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
import javax.swing.JOptionPane; 
import org.mindrot.jbcrypt.BCrypt;

public class UtilisateurDAO {

    private Connection connexion;

    public UtilisateurDAO() throws Exception {
        this.connexion = MySQLConnection.getConnexion();
    }

    public void create(Utilisateur utilisateur) {
        try {
            Connection con = this.connexion;
            String sql = "INSERT INTO utilisateur (ID_UTILISATEUR, EMAIL_UTILISATEUR, NO_TELEPHONE_UTILISATEUR, NOM_UTILISATEUR, PRENOM_UTILISATEUR, VILLE_UTILISATEUR, ADRESSE_UTILISATEUR, CP_UTILISATEUR, FONCTION_UTILISATEUR, MDP_HASH_UTILISATEUR) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, utilisateur.getID_UTILISATEUR());
            ps.setString(2, utilisateur.getEMAIL_UTILISATEUR());
            ps.setInt(3, utilisateur.getNO_TEL_UTILISATEUR());
            ps.setString(4, utilisateur.getNOM_UTILISATEUR());
            ps.setString(5, utilisateur.getPRENOM_UTILISATEUR());
            ps.setString(6, utilisateur.getVILLE_UTILISATEUR());
            ps.setString(7, utilisateur.getADRESSE_UTILISATEUR());
            ps.setInt(8, utilisateur.getCP_UTILISATEUR());
            ps.setString(9, utilisateur.getFONCTION_UTILISATEUR());
            ps.setString(10, hashPassword(utilisateur.getMDP_HASH_UTILISATEUR()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la création de l'utilisateur");
        }
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

    public void update(Utilisateur utilisateur) {
        try {
            System.out.println("update marche: \n" + utilisateur);
            Connection connection = this.connexion;
            String sql = "UPDATE utilisateur SET EMAIL_UTILISATEUR = ?, NO_TELEPHONE_UTILISATEUR = ?, NOM_UTILISATEUR = ?, PRENOM_UTILISATEUR = ?, VILLE_UTILISATEUR = ?, ADRESSE_UTILISATEUR = ?, CP_UTILISATEUR = ?, FONCTION_UTILISATEUR = ?, MDP_HASH_UTILISATEUR = ? WHERE ID_UTILISATEUR = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, utilisateur.getEMAIL_UTILISATEUR());
            ps.setInt(2, utilisateur.getNO_TEL_UTILISATEUR());
            ps.setString(3, utilisateur.getNOM_UTILISATEUR());
            ps.setString(4, utilisateur.getPRENOM_UTILISATEUR());
            ps.setString(5, utilisateur.getVILLE_UTILISATEUR());
            ps.setString(6, utilisateur.getADRESSE_UTILISATEUR());
            ps.setInt(7, utilisateur.getCP_UTILISATEUR());
            ps.setString(8, utilisateur.getFONCTION_UTILISATEUR());
            ps.setString(9, hashPassword(utilisateur.getMDP_HASH_UTILISATEUR()));
            ps.setInt(10, utilisateur.getID_UTILISATEUR());
            System.out.println("isPoolable : " + (ps.isPoolable() ? "OUAIIII"   : "NONNNNN"));
            int  req = ps.executeUpdate();
            System.out.println("req : " + req);
                               
//            System.out.println("Utilisateur modifié avec succès.");
        } catch (Exception e) {
            System.out.println("update caca");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la modification de l'utilisateur");
        }
    }

    public void delete(int idUtilisateur) {
        try {
            Connection connection = this.connexion;
            String sql = "DELETE FROM utilisateur where ID_UTILISATEUR = ?";
            PreparedStatement ps = connection.prepareStatement(sql);;
            ps.setInt(1, idUtilisateur);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Utilisateur supprimé avec succès.");
            } else {
                System.out.println("Aucun utilisateur n'a été supprimé (ID introuvable).");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la suppression de l'utilisateur");
        }

    }
    
    
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
}
