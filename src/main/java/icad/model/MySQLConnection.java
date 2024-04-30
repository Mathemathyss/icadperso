package icad.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import java.util.logging.Level;


public class MySQLConnection {
    
    private static final String url = "jdbc:mysql://172.28.36.16:3306/icad";
    private static final String user = "icad";
    private static final String pass = "Btssio82300";
    
    private static Connection con = null;
    
    public static Connection getConnexion() {
        if (con == null) {
            try {
                //Class.forName("com.mysq.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
