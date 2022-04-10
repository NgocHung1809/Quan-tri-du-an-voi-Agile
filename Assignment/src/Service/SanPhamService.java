/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.DBConnect;
import Model.SanPham;
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
public class SanPhamService implements IService<SanPham>{

    final String QUERY = "{Call SP_SANPHAM (?,?,?,?,?,?,?,?,?,?,?)}";
    List<SanPham> _lstSP;
    
    public SanPhamService() {
        _lstSP = new ArrayList<>();
        getSelectData();
    }
    
    @Override
    public List<SanPham> getlst() {
        return _lstSP;
    }

    @Override
    public void getSelectData() {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM SANPHAM");
        try {
            while (rs.next()) {
                _lstSP.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getFloat(5),rs.getString(6),rs.getInt(7),rs.getBigDecimal(8),rs.getBigDecimal(9),rs.getInt(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DongSanPhamService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getEditData(SanPham t, String style) {
        _lstSP.clear();
        if (!style.equalsIgnoreCase("SELECT")) {
            DBConnect.getEditDataFromDB(QUERY,t.getId(),t.getMa(),t.getTen(),t.getNamBaoHanh(),t.getTrongLuongSP(),t.getMoTaSP(),t.getSLSanPhamTon(),t.getGiaNhapSP(),t.getGiaBanSP(),t.getIdDSP(), style);
            getSelectData();
            return style + " thành công";
        }
        return "False";
    }

    @Override
    public List<SanPham> find(String ma) {
        List<SanPham> lst = new ArrayList<>();
        for (SanPham x : _lstSP) {
            if (x.getMa().contains(ma.toLowerCase())) {
                lst.add(x);
            }
        }
        return lst;
    }
    public List<SanPham> findName(String ten) {
        List<SanPham> lst = new ArrayList<>();
        for (SanPham x : _lstSP) {
            if (x.getTen().toLowerCase().contains(ten.toLowerCase())) {
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public List<SanPham> sort(String style) {
        if (style.equalsIgnoreCase("DESC")) {//DESC SAP XEP GIAM DAN
            _lstSP.sort(Comparator.comparing(SanPham::getMa));
            return _lstSP;
        }
        _lstSP.sort(Comparator.comparing(SanPham::getMa).reversed());
        return _lstSP;
    }
    
     public int getIdexMa(String txt){
        for (int i = 0; i < _lstSP.size(); i++) {
            if(_lstSP.get(i).getMa().equals(txt)){
                return i;
            }
        }
        return -3;
    }
    
}
