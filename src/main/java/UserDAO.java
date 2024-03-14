
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
public class UserDAO {
    private Connection connexion;
    
   
public UserDAO() throws Exception {
    this.connexion = MySQLConnection.getConnexion();
}    


//public User create (User unuser){
//    
//}
//
//public User get(Interger id_utilisateur) {
//    
//}
}
