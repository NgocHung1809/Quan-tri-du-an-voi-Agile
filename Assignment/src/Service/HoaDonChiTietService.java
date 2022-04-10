/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.DBConnect;
import Interface.IService;
import Model.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ngọc Hùng
 */
public class HoaDonChiTietService implements IService<HoaDonChiTiet>{
    List<HoaDonChiTiet> _lst;
    final String QUERY = "{Call SP_HOADONCT (?,?,?,?,?,?)}";

    public HoaDonChiTietService() {
        _lst = new ArrayList<>();
        getSelectData();
    }

    @Override
    public List<HoaDonChiTiet> getlst() {
        return _lst;
    }

    @Override
    public void getSelectData() {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM HoaDonChiTiet");
        try {
            while (rs.next()) {
                _lst.add(new HoaDonChiTiet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public  String getEditData(HoaDonChiTiet t, String style) {
        _lst.clear();
        if (!style.equalsIgnoreCase("SELECT")) {
            DBConnect.getEditDataFromDB(QUERY, t.getIdHoaDon(),t.getIdSanPham(),t.getSoLuong(),t.getDonGia(),t.getSTT(),style);
            getSelectData();
            return style + " thành công";
        }
        return style + " thất bại";
    }

    @Override
    public List<HoaDonChiTiet> find(String id) {
        List<HoaDonChiTiet> find = new ArrayList<>();
        for (HoaDonChiTiet x : find) {
            if (Integer.parseInt(id)==x.getIdHoaDon()) {
                find.add(x);
            }
        }
        return find;
    }
    public List<HoaDonChiTiet> find(int id) {
        List<HoaDonChiTiet> find = new ArrayList<>();
        for (HoaDonChiTiet x : _lst) {
            if (id==x.getIdHoaDon()) {
                find.add(x);
            }
        }
        return find;
    }

    @Override
    public List<HoaDonChiTiet> sort(String style) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getMaxID(List<HoaDonChiTiet> lst){
        if (lst.isEmpty()) {
            return 1;
        }
        int x = lst.get(0).getIdHoaDon();
        for (HoaDonChiTiet y : lst) {
            System.out.println(y.getIdHoaDon());
            if (y.getIdHoaDon() > x) {
                x = y.getIdHoaDon();
            }
        }
        return x + 1;
    }
}
