/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icad.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author j.loirot
 */
public class MySQLConnection {
    
    private static final String url = "jdbc:mysql://localhost:3306/icad";
    private static final String user = "root";
    private static final String pass = "localroot";
    
    private static Connection con = null;
    
    public static Connection getConnexion() {
        if (con == null) {
            try {
                Class.forName("com.mysq.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
