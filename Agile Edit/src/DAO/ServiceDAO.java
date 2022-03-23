/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ngọc Hùng
 */
public class ServiceDAO {
    final String INSERT_SQL = "INSERT dbo.[Users] VALUES(?,?)";
    final String SELECT_SQL = "SELECT * FROM dbo.[Users]";
    List<User> _lstUser;

    public ServiceDAO() {
        _lstUser = new ArrayList<>();
    }
    
    
    public String insert(User obj){
        DBConnect.Excute(INSERT_SQL, obj.getTaiKhoan(),obj.getMatKhau());
        return "Insert thành công!";
    }
    
    public List<User> selectAll() {
        return getSelectSQL(SELECT_SQL);
    }

    public List<User> getSelectSQL(String sql, Object... args) {
        try {
            ResultSet rs = DBConnect.getDataFromQuery(sql, args);
            while (rs.next()) {
                _lstUser.add(new User(rs.getString("TaiKhoan"), rs.getString("MatKhau")));
            }
            return _lstUser;
        } catch (SQLException ex) {
            System.out.println("Sai");
            throw new RuntimeException();
        }
    }
}
