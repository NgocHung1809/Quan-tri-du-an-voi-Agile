/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ngọc Hùng
 */
public class DBConnect {

    public static String acc = "NgocHung";
    public static String pass = "ngochung1809";
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbConnect = "jdbc:sqlserver://localhost:1433;databaseName=FINAL_ASSIGNMENT_JAVA3_DUNGNA29";
    
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection openConnect() {
        try {
            return DriverManager.getConnection(dbConnect, acc, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("false");
            return null;
        }
    }

    public static CallableStatement getQuery(String query, Object... args) {
        try {
            CallableStatement st = openConnect().prepareCall(query);
            for (int i = 0; i < args.length; i++) {
                st.setObject(i + 1, args[i]);
            }
            return st;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("false");
            return null;
        }
    }

    public static int getEditDataFromDB(String query, Object... args) {
        try {
            CallableStatement st = getQuery(query, args);
            return st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("false");
            return 0;
        }
    }

    public static ResultSet getSelectDataFromDB(String query, Object... args) {
        try {
            CallableStatement st = getQuery(query, args);
           
            return st.executeQuery();
        } catch (SQLException ex) {
            System.out.println("false");
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
