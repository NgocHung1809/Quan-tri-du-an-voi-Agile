/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Connect.DBConnect;
import Model.NhanVien;
import Service.ChucVuService;
import Service.NhanVienService;
import Utilites.Utilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ngọc Hùng
 */
public class NhanVienPanel extends javax.swing.JPanel {
    JPopupMenu menu = new JPopupMenu("Popup");
    NhanVienService _nvs;
    DefaultTableModel _DefaultTableModel;
    SimpleDateFormat sdf;
    ChucVuService _cvservice = new ChucVuService();
    Utilites.Utilities _Utilites = new Utilities();

    /**
     * Creates new form NhanVienPanel
     */
    public NhanVienPanel() {
        initComponents();
        cbx_GioiTinh();
        cbx_MaChucVu();
        cbx_MaNguoiBaoCao();
        _nvs = new NhanVienService();
        _DefaultTableModel = new DefaultTableModel();
//        sdf = new SimpleDateFormat("yyyy-mm-dd");
//        String date = sdf.format(jdc_NgaySinh.getDate());
        btg_Sort();
        loadData(_nvs.getlst());
    }

    public void Test() {
        menu.removeAll();

        JMenuItem item = new JMenuItem("Lọc Khu");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cbb = JOptionPane.showInputDialog("NHập khu đi ku:");
//                dao.fillTableIDArea(tbl_NhanVien, cbb);

            }
        });

        menu.add(item);
    }
    
    void btg_Sort() {
        ButtonGroup btg = new ButtonGroup();
        btg.add(rdo_ASC);
        btg.add(rdo_DESC);
        rdo_ASC.setSelected(true);
    }

    void cbx_GioiTinh() {
        String[] gender = {"Nam", "Nữ"};
        cbx_GioiTinh.setModel(new DefaultComboBoxModel<>(gender));
    }

    void cbx_MaChucVu() {
        DefaultComboBoxModel _DefaultComboBoxModel = new DefaultComboBoxModel();
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM CHUCVU");
        try {
            while (rs.next()) {
                _DefaultComboBoxModel.addElement(rs.getString(2));
            }
            cbx_MaCV.setModel(_DefaultComboBoxModel);
        } catch (SQLException ex) {
//            Logger.getLogger(DongSanPhamService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void cbx_MaNguoiBaoCao() {
        DefaultComboBoxModel _DefaultComboBoxModel = new DefaultComboBoxModel();
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM NHANVIEN");
        try {
            while (rs.next()) {
                _DefaultComboBoxModel.addElement(rs.getString(2));
            }
            cbx_MaNguoiBaoCao.setModel(_DefaultComboBoxModel);
        } catch (SQLException ex) {
//            Logger.getLogger(DongSanPhamService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String getMaCV(int id) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM CHUCVU");
        try {
            while (rs.next()) {
                if (id == rs.getInt(1)) {
                    return rs.getString(2);
                }
            }
        } catch (SQLException ex) {
        }
        return "NULL";
    }

    int getIDCV(String ma) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM CHUCVU");
        try {
            while (rs.next()) {
                if (ma.equalsIgnoreCase(rs.getString(2))) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
        }
        return -1;
    }

    int getIDNV(String ma) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM NHANVIEN");
        try {
            while (rs.next()) {
                if (ma.equalsIgnoreCase(rs.getString(2))) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
        }
        return -1;
    }

    void loadData(List<NhanVien> data) {
        _DefaultTableModel = (DefaultTableModel) tbl_NhanVien.getModel();
        _DefaultTableModel.setColumnIdentifiers(new Object[]{"STT", "Mã", "Tên họ", "Tên đệm", "Tên", "Giới tính", "Ngày sinh", "Mã chức vụ", "Mã người báo cáo"});
        if (data.isEmpty()) {
            _DefaultTableModel.setRowCount(0);
            return;
        }
        _DefaultTableModel.setRowCount(0);
        int stt = 0;
        for (NhanVien x : data) {
            _DefaultTableModel.addRow(new Object[]{++stt, x.getMa(), x.getTenHo(), x.getTenDem(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), getMaCV(x.getIdNguoiBaoCao()), getMaNV(x.getIdCV())});
        }
    }

    NhanVien getDataGUI() {
        System.out.println(jdc_NgaySinh.getDate());
        //int Id, String Ma, String TenHo, String TenDem, String Ten, String GioiTinh, Date NgaySinh, int IdCV, int IdNguoiBaoCao) {
        return new NhanVien(-1, txt_Ma.getText(), txt_TenHo.getText(), txt_TenDem.getText(), txt_Ten.getText(), String.valueOf(cbx_GioiTinh.getSelectedItem()), jdc_NgaySinh.getDate(), getIDCV((String) cbx_MaCV.getSelectedItem()), getIDNV((String) cbx_MaNguoiBaoCao.getSelectedItem()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbx_GioiTinh = new javax.swing.JComboBox<>();
        jdc_NgaySinh = new com.toedter.calendar.JDateChooser();
        txt_Ten = new javax.swing.JTextField();
        txt_Ma = new javax.swing.JTextField();
        txt_TenHo = new javax.swing.JTextField();
        txt_TenDem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_SapXep = new javax.swing.JButton();
        btn_TimKiem = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        txt_TimKiem = new javax.swing.JTextField();
        rdo_ASC = new javax.swing.JRadioButton();
        rdo_DESC = new javax.swing.JRadioButton();
        cbx_MaCV = new javax.swing.JComboBox<>();
        cbx_MaNguoiBaoCao = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setText("Mã");

        jLabel2.setText("Tên họ");

        jLabel3.setText("Tên đệm");

        jLabel4.setText("Tên");

        jLabel5.setText("Giới tính");

        jLabel6.setText("Ngày sinh");

        cbx_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NhanVien);

        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_SapXep.setText("Sắp xếp");
        btn_SapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SapXepActionPerformed(evt);
            }
        });

        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        rdo_ASC.setText("ASC");

        rdo_DESC.setText("DESC");

        cbx_MaCV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbx_MaNguoiBaoCao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Mã chức vụ");

        jLabel8.setText("Mã người báo cáo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Ten, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(txt_TenHo)
                            .addComponent(txt_TenDem))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 71, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbx_MaNguoiBaoCao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbx_GioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdc_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(cbx_MaCV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_SapXep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_TimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(rdo_DESC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdo_ASC, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbx_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txt_TenHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jdc_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_TenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_MaCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them)
                            .addComponent(btn_TimKiem)
                            .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Sua)
                            .addComponent(btn_SapXep)
                            .addComponent(rdo_ASC))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Xoa)
                            .addComponent(rdo_DESC))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_MaNguoiBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        int count = 0;
        if (txt_Ten.getText().isEmpty() || txt_TenDem.getText().isEmpty() || txt_TenHo.getText().isEmpty() || txt_Ma.getText().isEmpty() || _Utilites.checkSo(txt_Ten.getText()) || _Utilites.checkSo(txt_TenDem.getText()) || _Utilites.checkSo(txt_TenHo.getText())) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không được null, là kí tự và mã không được trùng");
            count++;
            return;
        }
        if (count == 0) {

            int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?", "Sửa", JOptionPane.YES_NO_OPTION);
            if (choose != 0) {
                return;
            }
            JOptionPane.showMessageDialog(this, _nvs.getEditData(getDataGUI(), "UPDATE"));
            loadData(_nvs.getlst());
        }
    }//GEN-LAST:event_btn_SuaActionPerformed
    String getMaNV(int id) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM NHANVIEN");
        try {
            while (rs.next()) {
                if (id == rs.getInt(1)) {
                    System.out.println("co");
                    return rs.getString(2);
                }
            }
        } catch (SQLException ex) {
        }
        return "NULL";
    }
    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
        System.out.println(choose);
        if (choose != 0) {
            return;
        }
        for (int i = 0; i < _nvs.getlst().size(); i++) {
            if (txt_Ma.getText().equalsIgnoreCase(getMaNV(_nvs.getlst().get(i).getId()))) {
                JOptionPane.showMessageDialog(this, "Bạn phải xóa những sản phẩm có mã sản phẩm là " + getMaCV(_nvs.getlst().get(i).getId()));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, _nvs.getEditData(getDataGUI(), "DELETE"));
        loadData(_nvs.getlst());
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_SapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SapXepActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sắp xếp không?", "Săp xếp", JOptionPane.YES_NO_OPTION);
        System.out.println(choose);
        if (choose != 0) {
            return;
        }
        if (rdo_ASC.isSelected()) {
            loadData(_nvs.sort("DESC"));
            return;
        }
        loadData(_nvs.sort("ASC"));
    }//GEN-LAST:event_btn_SapXepActionPerformed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        loadData(_nvs.find(txt_TimKiem.getText()));
    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        int count = 0;
        if (txt_Ten.getText().isEmpty() || txt_TenDem.getText().isEmpty() || txt_TenHo.getText().isEmpty() || txt_Ma.getText().isEmpty() || _Utilites.checkSo(txt_Ten.getText()) || _Utilites.checkSo(txt_TenDem.getText()) || _Utilites.checkSo(txt_TenHo.getText()) || _nvs.getIdexMa(txt_Ma.getText()) != -3) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không được null, là kí tự và mã không được trùng");
            count++;
            return;
        }
        if (count == 0) {
            int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?", "Thêm", JOptionPane.YES_NO_OPTION);
            System.out.println(choose);
            if (choose != 0) {
                return;
            }
            JOptionPane.showMessageDialog(this, _nvs.getEditData(getDataGUI(), "INSERT"));
            loadData(_nvs.getlst());
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void tbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseClicked
        // TODO add your handling code here:
        int index = tbl_NhanVien.getSelectedRow();
        if (index < 0) {
            return;
        }
        txt_Ma.setText(tbl_NhanVien.getModel().getValueAt(index, 1).toString());
        txt_TenHo.setText(tbl_NhanVien.getModel().getValueAt(index, 2).toString());
        txt_TenDem.setText(tbl_NhanVien.getModel().getValueAt(index, 3).toString());
        txt_Ten.setText(tbl_NhanVien.getModel().getValueAt(index, 4).toString());
        cbx_GioiTinh.setSelectedItem(tbl_NhanVien.getModel().getValueAt(index, 5).toString());
        try {
            jdc_NgaySinh.setDate(new SimpleDateFormat("yyyy-mm-dd").parse(tbl_NhanVien.getModel().getValueAt(index, 6).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbx_MaCV.setSelectedItem(tbl_NhanVien.getModel().getValueAt(index, 7).toString());
        cbx_MaNguoiBaoCao.setSelectedItem(tbl_NhanVien.getModel().getValueAt(index, 8).toString());
        Test();
    }//GEN-LAST:event_tbl_NhanVienMouseClicked

    private void tbl_NhanVienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbl_NhanVienMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SapXep;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbx_GioiTinh;
    private javax.swing.JComboBox<String> cbx_MaCV;
    private javax.swing.JComboBox<String> cbx_MaNguoiBaoCao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdc_NgaySinh;
    private javax.swing.JRadioButton rdo_ASC;
    private javax.swing.JRadioButton rdo_DESC;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_Ten;
    private javax.swing.JTextField txt_TenDem;
    private javax.swing.JTextField txt_TenHo;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
