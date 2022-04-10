/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.DBConnect;
import Interface.IService;
import Model.HoaDon;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ngọc Hùng
 */
public class HoaDonService implements IService<HoaDon> {
    
    List<HoaDon> _lst;
    final String QUERY = "{Call SP_HoaDon (?,?,?,?,?,?)}";
    
    public HoaDonService() {
        _lst = new ArrayList<>();
        getSelectData();
    }
    
    @Override
    public List<HoaDon> getlst() {
        return _lst;
    }
    
    @Override
    public void getSelectData() {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM HOADON");
        try {
            while (rs.next()) {
                _lst.add(new HoaDon(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getEditData(HoaDon t, String style) {
        _lst.clear();
        if (style!= "SELECT") {
            DBConnect.getEditDataFromDB(QUERY,t.getId(),t.getMa(),t.getNgayTaoHoaDon(),t.getTinhTrangHoaDon(),t.getIdNV(), style);
            getSelectData();
            return style + " thành công";
        }
        return style + " thất bại";
    }
    
    @Override
    public List<HoaDon> find(String tinhTrang) {
        List<HoaDon> find = new ArrayList<>();
        for (HoaDon x : _lst) {
//            System.out.println(x.getTinhTrangHoaDon())
            if (Integer.parseInt(tinhTrang)==x.getTinhTrangHoaDon()) {
                System.out.println(x.getTinhTrangHoaDon());
                find.add(x);
            }
        }
        return find;
    }
    
    @Override
    public List<HoaDon> sort(String style) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getMaxID(List<HoaDon> lst){
        if (lst.isEmpty()) {
            return 1;
        }
        int x = lst.get(0).getId();
        for (HoaDon y : lst) {
            System.out.println(y.getId());
            if (y.getId() > x) {
                x = y.getId();
            }
        }
        return x + 1;
    }
    
}
