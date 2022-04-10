/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Ngọc Hùng
 */
public class HoaDonChiTiet {

    private int IdHoaDon;
    private int IdSanPham;
    private int SoLuong;
    private float DonGia;
    private int STT;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int IdHoaDon, int IdSanPham, int SoLuong, float DonGia, int STT) {
        this.IdHoaDon = IdHoaDon;
        this.IdSanPham = IdSanPham;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.STT = STT;
    }

    public int getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(int IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }

    public int getIdSanPham() {
        return IdSanPham;
    }

    public void setIdSanPham(int IdSanPham) {
        this.IdSanPham = IdSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    
}
