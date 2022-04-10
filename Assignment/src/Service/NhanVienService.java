/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.DBConnect;
import Model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.IService;
import java.util.Comparator;

/**
 *
 * @author Ngọc Hùng
 */
public class NhanVienService implements IService<NhanVien> {

    final String QUERY = "{Call SP_NHANVIEN (?,?,?,?,?,?,?,?,?,?)}";
    List<NhanVien> _lstNV;

    public NhanVienService() {
        _lstNV = new ArrayList<>();
        getSelectData();
    }

    @Override
    public List<NhanVien> getlst() {
        return _lstNV;
    }

    @Override
    public void getSelectData() {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM NHANVIEN");
        try {
            while (rs.next()) {
                _lstNV.add(new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DongSanPhamService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getEditData(NhanVien t, String style) {
        _lstNV.clear();
        if (!style.equalsIgnoreCase("SELECT")) {
            DBConnect.getEditDataFromDB(QUERY, t.getId(), t.getMa(), t.getTenHo(), t.getTenDem(), t.getTen(), t.getGioiTinh(), t.getNgaySinh(), t.getIdCV(), t.getIdNguoiBaoCao(), style);
            getSelectData();
            return style + " thành công";
        }
        return "False";
    }

    @Override
    public List<NhanVien> find(String ma) {
        List<NhanVien> lst = new ArrayList<>();
        for (NhanVien x : _lstNV) {
            if (x.getMa().contains(ma.toLowerCase())) {
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public List<NhanVien> sort(String style) {
        if (style.equalsIgnoreCase("DESC")) {//DESC SAP XEP GIAM DAN
            _lstNV.sort(Comparator.comparing(NhanVien::getMa));
            return _lstNV;
        }
        _lstNV.sort(Comparator.comparing(NhanVien::getMa).reversed());
        return _lstNV;
    }
 public int getIdexMa(String txt){
        for (int i = 0; i < _lstNV.size(); i++) {
            if(_lstNV.get(i).getMa().equals(txt)){
                return i;
            }
        }
        return -3;
    }
}
