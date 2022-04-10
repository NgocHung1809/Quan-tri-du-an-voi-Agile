/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connect.DBConnect;
import Model.ChucVu;
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
public class ChucVuService implements IService<ChucVu> {

    final String QUERY = "{Call SP_CHUCVU (?,?,?,?)}";

    List<ChucVu> _lstChucVu;

    public ChucVuService() {
        _lstChucVu = new ArrayList<>();
        getSelectData();
    }

    @Override
    public List<ChucVu> getlst() {
        return _lstChucVu;
    }

    @Override
    public void getSelectData() {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM CHUCVU");
        try {
            while (rs.next()) {
                _lstChucVu.add(new ChucVu(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getEditData(ChucVu cv, String style) {
        _lstChucVu.clear();
        if (!style.equalsIgnoreCase("SELECT")) {
            DBConnect.getEditDataFromDB(QUERY, cv.getId(), cv.getMa(), cv.getTen(), style);
            getSelectData();
            return style + " thành công";
        }
        return "False";
    }

    @Override
    public List<ChucVu> find(String ma) {
        List<ChucVu> lst = new ArrayList<>();
        for (ChucVu x : _lstChucVu) {
            if (x.getMa().contains(ma.toLowerCase())) {
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public List<ChucVu> sort(String style) {
        if (style.equalsIgnoreCase("DESC")) {
            _lstChucVu.sort(Comparator.comparing(ChucVu::getMa));
            return _lstChucVu;
        }
        _lstChucVu.sort(Comparator.comparing(ChucVu::getMa).reversed());
        return _lstChucVu;
    }
    
    public int getIdexMa(String txt){
        for (int i = 0; i < _lstChucVu.size(); i++) {
            if(_lstChucVu.get(i).getMa().equals(txt)){
                return i;
            }
        }
        return -3;
    }
}
