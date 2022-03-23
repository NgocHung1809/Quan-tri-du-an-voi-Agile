/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ngọc Hùng
 */
public class DBConnect {

    private static String host = "localhost";
    private static String username = "NgocHung";
    private static String password = "ngochung1809";
    private static String dbName = "DUANANHOM5";
    private static String connectionSQL = "jdbc:sqlserver://" + host + ":1433" + ";databaseName=" + dbName;
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection conn;
    static{
        try {
            Class.forName(driver);
            System.out.println("Connect thành công DB");
        } catch (Exception ex) {
            System.out.println("Lỗi connectDB");
            ex.printStackTrace();
        }
    }
    //Mở kết nói
    static Connection openDBConnection(){
        try {
            System.out.println("Mở kết nối thành công");
            return DriverManager.getConnection(connectionSQL, username, password);
        } catch (Exception ex) {
            System.out.println("Mở kết nối thất bại thành công");
            ex.printStackTrace();
            return null;
        }
    }
    
    //Thực thi 
    static int Excute(String sql, Object... args) {
        PreparedStatement pstm = getStatement(sql, args);
        try {
            try {
                return pstm.executeUpdate();
            } finally {
                pstm.close();
            }
        } catch (Exception ex) {
//            ex.printStackTrace();
            return 0;
        }
    }
    
    //Câu lệnh truy vấn CSDL
    static PreparedStatement getStatement(String sql,Object... args){
        conn = openDBConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);//Dùng để triển khai các câu lệnh truy vấn thường
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //Tập đối tượng truy vấn từ SQL
    static ResultSet getDataFromQuery(String sql,Object... args) throws SQLException{
        PreparedStatement pstm = getStatement(sql, args);
        return pstm.executeQuery();
    }
}
