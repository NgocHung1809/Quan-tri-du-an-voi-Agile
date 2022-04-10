/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author Ngọc Hùng
 */
public class SanPham {

    private int Id;
    private String Ma;
    private String Ten;
    private int NamBaoHanh;
    private float TrongLuongSP;
    private String MoTaSP;
    private int SLSanPhamTon;
    private BigDecimal GiaNhapSP;
    private BigDecimal GiaBanSP;
    private int IdDSP;

    public SanPham() {
    }

    public SanPham(int Id, String Ma, String Ten, int NamBaoHanh, float TrongLuongSP, String MoTaSP, int SLSanPhamTon, BigDecimal GiaNhapSP, BigDecimal GiaBanSP, int IdDSP) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.NamBaoHanh = NamBaoHanh;
        this.TrongLuongSP = TrongLuongSP;
        this.MoTaSP = MoTaSP;
        this.SLSanPhamTon = SLSanPhamTon;
        this.GiaNhapSP = GiaNhapSP;
        this.GiaBanSP = GiaBanSP;
        this.IdDSP = IdDSP;
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

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getNamBaoHanh() {
        return NamBaoHanh;
    }

    public void setNamBaoHanh(int NamBaoHanh) {
        this.NamBaoHanh = NamBaoHanh;
    }

    public float getTrongLuongSP() {
        return TrongLuongSP;
    }

    public void setTrongLuongSP(float TrongLuongSP) {
        this.TrongLuongSP = TrongLuongSP;
    }

    public String getMoTaSP() {
        return MoTaSP;
    }

    public void setMoTaSP(String MoTaSP) {
        this.MoTaSP = MoTaSP;
    }

    public int getSLSanPhamTon() {
        return SLSanPhamTon;
    }

    public void setSLSanPhamTon(int SLSanPhamTon) {
        this.SLSanPhamTon = SLSanPhamTon;
    }

    public BigDecimal getGiaNhapSP() {
        return GiaNhapSP;
    }

    public void setGiaNhapSP(BigDecimal GiaNhapSP) {
        this.GiaNhapSP = GiaNhapSP;
    }

    public BigDecimal getGiaBanSP() {
        return GiaBanSP;
    }

    public void setGiaBanSP(BigDecimal GiaBanSP) {
        this.GiaBanSP = GiaBanSP;
    }

    public int getIdDSP() {
        return IdDSP;
    }

    public void setIdDSP(int IdDSP) {
        this.IdDSP = IdDSP;
    }

    
}
