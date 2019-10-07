/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseClasses.databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdelhalim
 */
public class DBConnection {
    
    //private static DBConnection DBConn;
    private static Connection connection;
    
    /**
     * setter and getter method to deal with Connection Object
     */
    public static void setConnection(Connection connection) {
        DBConnection.connection = connection;
    }

    public static Connection getConnection() {
        return connection;
    }
    
    public DBConnection() {
    }

    // open connection through database
    public static void openConnection() {

        if (connection == null) {
            try {
                String driverName = "com.mysql.jdbc.Driver";
                Class.forName(driverName);
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/timelineschedulersystem","root","root");
            } catch (Exception ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("connection = " + connection.toString());
                System.out.println("Exception = " + ex.getMessage());
            }
        }
    }

    // close database connection
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
