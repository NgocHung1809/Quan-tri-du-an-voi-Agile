/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.DBConnect;
import Model.DongSanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.IService;

/**
 *
 * @author Ngọc Hùng
 */
public class DongSanPhamService implements IService<DongSanPham> {

    final String QUERY = "{Call SP_DongSP (?,?,?,?,?)}";
    List<DongSanPham> _lstDongSP;

    public DongSanPhamService() {
        _lstDongSP = new ArrayList<>();
        getSelectData();
    }

    @Override
    public List<DongSanPham> getlst() {
        return _lstDongSP;
    }

    @Override
    public void getSelectData() {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM DONGSANPHAM");
        try {
            while (rs.next()) {
                _lstDongSP.add(new DongSanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DongSanPhamService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getEditData(DongSanPham t, String style) {
        _lstDongSP.clear();
        if (!style.equalsIgnoreCase("SELECT")) {
            DBConnect.getEditDataFromDB(QUERY, t.getId(), t.getMa(), t.getTen(), t.getWeb(), style);
            getSelectData();
            return style + " thành công";
        }
        return "False";
    }

    @Override
    public List<DongSanPham> find(String ma) {
        List<DongSanPham> lst = new ArrayList<>();
        for (DongSanPham x : _lstDongSP) {
            if (x.getMa().contains(ma.toLowerCase())) {
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public List<DongSanPham> sort(String style) {
        if (style.equalsIgnoreCase("DESC")) {//DESC SAP XEP GIAM DAN
            _lstDongSP.sort(Comparator.comparing(DongSanPham::getMa));
            return _lstDongSP;
        }
        _lstDongSP.sort(Comparator.comparing(DongSanPham::getMa).reversed());
        return _lstDongSP;
    }
     public int getIdexMa(String txt){
        for (int i = 0; i < _lstDongSP.size(); i++) {
            if(_lstDongSP.get(i).getMa().equals(txt)){
                return i;
            }
        }
        return -3;
    }

}
