/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Ngọc Hùng
 */
public class DongSanPham {

    int Id;
    String Ma;
    String Ten;
    String Web;

    public DongSanPham() {
    }

    public DongSanPham(int Id, String Ma, String Ten, String Web) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.Web = Web;
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

    public String getWeb() {
        return Web;
    }

    public void setWeb(String Web) {
        this.Web = Web;
    }

    @Override
    public String toString() {
        return "DongSanPham{" + "Id=" + Id + ", Ma=" + Ma + ", Ten=" + Ten + ", Web=" + Web + '}';
    }
    
    
}
