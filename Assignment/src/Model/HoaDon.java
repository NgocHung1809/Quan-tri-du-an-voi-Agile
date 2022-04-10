/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Ngọc Hùng
 */
public class HoaDon {

    private int Id;
    private String Ma;
    private Date NgayTaoHoaDon;
    private int TinhTrangHoaDon;
    private int IdNV;

    public HoaDon() {
    }

    public HoaDon(int Id, String Ma, Date NgayTaoHoaDon, int TinhTrangHoaDon, int IdNV) {
        this.Id = Id;
        this.Ma = Ma;
        this.NgayTaoHoaDon = NgayTaoHoaDon;
        this.TinhTrangHoaDon = TinhTrangHoaDon;
        this.IdNV = IdNV;
    }

    public HoaDon(int i, String text, Date date, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public Date getNgayTaoHoaDon() {
        return NgayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(Date NgayTaoHoaDon) {
        this.NgayTaoHoaDon = NgayTaoHoaDon;
    }

    public int getTinhTrangHoaDon() {
        return TinhTrangHoaDon;
    }

    public void setTinhTrangHoaDon(int TinhTrangHoaDon) {
        this.TinhTrangHoaDon = TinhTrangHoaDon;
    }

    public int getIdNV() {
        return IdNV;
    }

    public void setIdNV(int IdNV) {
        this.IdNV = IdNV;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "Id=" + Id + ", Ma=" + Ma + ", NgayTaoHoaDon=" + NgayTaoHoaDon + ", TinhTrangHoaDon=" + TinhTrangHoaDon + ", IdNV=" + IdNV + '}';
    }
    
    
}
