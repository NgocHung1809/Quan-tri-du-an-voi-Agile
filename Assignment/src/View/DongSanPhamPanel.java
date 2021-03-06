/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Connect.DBConnect;
import Model.DongSanPham;
import Model.SanPham;
import Service.ChucVuService;
import Service.DongSanPhamService;
import Service.SanPhamService;
import Utilites.Utilities;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ngọc Hùng
 */
public class DongSanPhamPanel extends javax.swing.JPanel {

    DefaultTableModel _DefaultTableModel;
    DongSanPhamService _dsp;
    SanPhamService _sv;
    Utilites.Utilities _utUtilities = new Utilities();
    /**
     * Creates new form DongSanPhamPanel
     */
    public DongSanPhamPanel() {
        initComponents();
        btg_Sort();
        _dsp = new DongSanPhamService();
        _sv = new SanPhamService();
        _DefaultTableModel = new DefaultTableModel();
        loadData(_dsp.getlst());
    }

    void btg_Sort() {
        ButtonGroup sort = new ButtonGroup();
        sort.add(rdo_ASC);
        sort.add(rdo_DESC);
        rdo_ASC.setSelected(true);
    }

    void loadData(List<DongSanPham> data) {
        _DefaultTableModel = (DefaultTableModel) tbl_DongSanPham.getModel();
        if (data.isEmpty()) {
            _DefaultTableModel.setRowCount(0);
            return;
        }
        _DefaultTableModel.setColumnIdentifiers(new Object[]{"STT", "Mã", "Tên", "WEB"});
        _DefaultTableModel.setRowCount(0);
        int stt = 0;
        for (DongSanPham x : data) {
            _DefaultTableModel.addRow(new Object[]{++stt, x.getMa(), x.getTen(), x.getWeb()});
        }
    }

    DongSanPham getDataGUI() {
        return new DongSanPham(-1, txt_Ma.getText(), txt_Ten.getText(), txt_Web.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Ma = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Ten = new javax.swing.JTextField();
        txt_Web = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DongSanPham = new javax.swing.JTable();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_TimKiem = new javax.swing.JButton();
        btn_SapXep = new javax.swing.JButton();
        txt_TimKiem = new javax.swing.JTextField();
        rdo_ASC = new javax.swing.JRadioButton();
        rdo_DESC = new javax.swing.JRadioButton();

        jLabel1.setText("Mã");

        jLabel2.setText("Tên");

        jLabel3.setText("Web");

        tbl_DongSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_DongSanPham.setName(""); // NOI18N
        tbl_DongSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DongSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DongSanPham);

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

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

        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });

        btn_SapXep.setText("Sắp xếp");
        btn_SapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SapXepActionPerformed(evt);
            }
        });

        rdo_ASC.setText("ASC");

        rdo_DESC.setText("DESC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Web, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_SapXep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_TimKiem)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rdo_DESC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdo_ASC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btn_Them)
                    .addComponent(btn_TimKiem)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua)
                    .addComponent(btn_SapXep)
                    .addComponent(rdo_ASC))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_Web, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Xoa)
                    .addComponent(rdo_DESC))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        int count =0;
        if(txt_Ten.getText().isEmpty() ||txt_Web.getText().isEmpty()|| _utUtilities.checkSo(txt_Ten.getText()) ||_utUtilities.checkSo(txt_Web.getText())|| _dsp.getIdexMa(txt_Ma.getText())!= -3){
            JOptionPane.showMessageDialog(this, "Dữ liệu không được null, là kí tự và mã không được trùng");
            count++;
            return;
        }
        if(count ==0){
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?", "Thêm", JOptionPane.YES_NO_OPTION);
        if (choose != 0) {
            return;
        }
        JOptionPane.showMessageDialog(this, _dsp.getEditData(getDataGUI(), "INSERT"));
        loadData(_dsp.getlst());
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void tbl_DongSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DongSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tbl_DongSanPham.getSelectedRow();
        if (index < 0) {
            return;
        }
        txt_Ma.setText(tbl_DongSanPham.getModel().getValueAt(index, 1).toString());
        txt_Ten.setText(tbl_DongSanPham.getModel().getValueAt(index, 2).toString());
        txt_Web.setText(tbl_DongSanPham.getModel().getValueAt(index, 3).toString());
    }//GEN-LAST:event_tbl_DongSanPhamMouseClicked

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        int count =0;
        if(txt_Ten.getText().isEmpty() ||txt_Web.getText().isEmpty()|| _utUtilities.checkSo(txt_Ten.getText()) ||_utUtilities.checkSo(txt_Web.getText())){
            JOptionPane.showMessageDialog(this, "Dữ liệu không được null, là kí tự và mã không được trùng");
            count++;
            return;
        }
        if(count ==0){
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?", "Sửa", JOptionPane.YES_NO_OPTION);
        if (choose != 0) {
            return;
        }
        JOptionPane.showMessageDialog(this, _dsp.getEditData(getDataGUI(), "UPDATE"));
        loadData(_dsp.getlst());
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    String getMaDSP(int id) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM DONGSANPHAM");
        try {
            while (rs.next()) {
                if (id == rs.getInt(1)) {
                    return rs.getString(2);
                }
            }
        } catch (SQLException ex) {
        }
        return "false";
    }
    
    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
        if (choose != 0) {
            return;
        }
        for (int i = 0; i < _sv.getlst().size(); i++) {
            if (txt_Ma.getText().equalsIgnoreCase(getMaDSP(_sv.getlst().get(i).getIdDSP()))) {
                JOptionPane.showMessageDialog(this, "Bạn phải xóa những sản phẩm có mã sản phẩm là " + getMaDSP(_sv.getlst().get(i).getIdDSP()));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, _dsp.getEditData(getDataGUI(), "DELETE"));
        loadData(_dsp.getlst());
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        // TODO add your handling code here:
        loadData(_dsp.find(txt_TimKiem.getText()));
    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void btn_SapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SapXepActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sắp xếp không?", "Săp xếp", JOptionPane.YES_NO_OPTION);
        System.out.println(choose);
        if (choose != 0) {
            return;
        }
        if (rdo_ASC.isSelected()) {
            loadData(_dsp.sort("DESC"));
            return;
        }
        loadData(_dsp.sort("ASC"));
    }//GEN-LAST:event_btn_SapXepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SapXep;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_ASC;
    private javax.swing.JRadioButton rdo_DESC;
    private javax.swing.JTable tbl_DongSanPham;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_Ten;
    private javax.swing.JTextField txt_TimKiem;
    private javax.swing.JTextField txt_Web;
    // End of variables declaration//GEN-END:variables
}
