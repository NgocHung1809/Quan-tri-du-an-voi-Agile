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
public class NhanVien {

    private int Id;
    private String Ma;
    private String TenHo;
    private String TenDem;
    private String Ten;
    private String GioiTinh;
    private Date NgaySinh;
    private int IdCV;
    private int IdNguoiBaoCao;

    public NhanVien() {
    }

    public NhanVien(int Id, String Ma, String TenHo, String TenDem, String Ten, String GioiTinh, Date NgaySinh, int IdCV, int IdNguoiBaoCao) {
        this.Id = Id;
        this.Ma = Ma;
        this.TenHo = TenHo;
        this.TenDem = TenDem;
        this.Ten = Ten;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.IdCV = IdCV;
        this.IdNguoiBaoCao = IdNguoiBaoCao;
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

    public String getTenHo() {
        return TenHo;
    }

    public void setTenHo(String TenHo) {
        this.TenHo = TenHo;
    }

    public String getTenDem() {
        return TenDem;
    }

    public void setTenDem(String TenDem) {
        this.TenDem = TenDem;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getIdCV() {
        return IdCV;
    }

    public void setIdCV(int IdCV) {
        this.IdCV = IdCV;
    }

    public int getIdNguoiBaoCao() {
        return IdNguoiBaoCao;
    }

    public void setIdNguoiBaoCao(int IdNguoiBaoCao) {
        this.IdNguoiBaoCao = IdNguoiBaoCao;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "Id=" + Id + ", Ma=" + Ma + ", TenHo=" + TenHo + ", TenDem=" + TenDem + ", Ten=" + Ten + ", GioiTinh=" + GioiTinh + ", NgaySinh=" + NgaySinh + ", IdCV=" + IdCV + ", IdNguoiBaoCao=" + IdNguoiBaoCao + '}';
    }
    
    
    
}
