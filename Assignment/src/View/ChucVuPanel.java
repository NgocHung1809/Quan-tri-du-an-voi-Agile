/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Connect.DBConnect;
import java.sql.*;
import Model.ChucVu;
import Service.ChucVuService;
import Service.NhanVienService;
import Utilites.Utilities;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ngọc Hùng
 */
public class ChucVuPanel extends javax.swing.JPanel {

    DefaultTableModel _DefaultTableModel;
    ChucVuService _cvs;
    NhanVienService _nvs;
    Utilites.Utilities _utUtilities = new Utilities();
    /**
     * Creates new form ChucVuPanel
     */
    public ChucVuPanel() {
        initComponents();
        _nvs = new NhanVienService();
        btg_Sort();
        _DefaultTableModel = new DefaultTableModel();
        _cvs = new ChucVuService();
        loadData(_cvs.getlst());

    }

    void btg_Sort() {
        ButtonGroup sort = new ButtonGroup();
        sort.add(rdo_ASC);
        sort.add(rdo_DESC);
        rdo_ASC.setSelected(true);
    }

    void loadData(List<ChucVu> data) {
        _DefaultTableModel = (DefaultTableModel) tbl_ChucVu.getModel();
        if (data.isEmpty()) {
            _DefaultTableModel.setRowCount(0);
            return;
        }
        _DefaultTableModel.setColumnIdentifiers(new Object[]{"STT", "Mã", "Tên"});
        _DefaultTableModel.setRowCount(0);
        int stt = 0;
        for (ChucVu x : data) {
            _DefaultTableModel.addRow(new Object[]{++stt, x.getMa(), x.getTen()});
        }
    }

    ChucVu getDataGUI() {
        return new ChucVu(-1, txt_Ma.getText(), txt_Ten.getText());
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
        txt_Ten = new javax.swing.JTextField();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_SapXep = new javax.swing.JButton();
        btn_TimKiem = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        txt_TimKiem = new javax.swing.JTextField();
        rdo_ASC = new javax.swing.JRadioButton();
        rdo_DESC = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ChucVu = new javax.swing.JTable();

        jLabel1.setText("Mã");

        jLabel2.setText("Tên");

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

        tbl_ChucVu.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_ChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ChucVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ChucVu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_SapXep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_TimKiem))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_TimKiem)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rdo_DESC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdo_ASC, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
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
                    .addComponent(btn_Xoa)
                    .addComponent(rdo_DESC))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        
        int count =0;
        if(txt_Ten.getText().isEmpty() || _utUtilities.checkSo(txt_Ten.getText()) || _cvs.getIdexMa(txt_Ma.getText())!= -3){
            JOptionPane.showMessageDialog(this, "Tên không được null, tên là kí tự");
            count++;
            return;
        }
        if(count ==0){
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?", "Săp xếp", JOptionPane.YES_NO_OPTION);
        System.out.println(choose);
        if (choose != 0) {
            return;
        }
        JOptionPane.showMessageDialog(this, _cvs.getEditData(getDataGUI(), "INSERT"));
        loadData(_cvs.getlst());
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void tbl_ChucVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ChucVuMouseClicked
    
        int index = tbl_ChucVu.getSelectedRow();
        if (index < 0) {
            return;
        }
        txt_Ma.setText(tbl_ChucVu.getModel().getValueAt(index, 1).toString());
        txt_Ten.setText(tbl_ChucVu.getModel().getValueAt(index, 2).toString());
    }//GEN-LAST:event_tbl_ChucVuMouseClicked

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        int count =0;
        if(txt_Ten.getText().isEmpty() || _utUtilities.checkSo(txt_Ten.getText()) ){
            JOptionPane.showMessageDialog(this, "Tên không được null, tên là kí tự");
            count++;
            return;
        }
        if(count ==0){
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?", "Sửa", JOptionPane.YES_NO_OPTION);
        System.out.println(choose);
        if (choose != 0) {
            return;
        }
        JOptionPane.showMessageDialog(this, _cvs.getEditData(getDataGUI(), "UPDATE"));
        loadData(_cvs.getlst());
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

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
        return null;
    }
    
    

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
//         TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
        System.out.println(choose);
        if (choose != 0) {
            return;
        }
        for (int i = 0; i < _cvs.getlst().size(); i++) {
            if (txt_Ma.getText().equalsIgnoreCase(getMaCV(_cvs.getlst().get(i).getId()))) {
                JOptionPane.showMessageDialog(this, "Bạn phải xóa những sản phẩm có mã sản phẩm là " + getMaCV(_cvs.getlst().get(i).getId()));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, _cvs.getEditData(getDataGUI(), "DELETE"));
        loadData(_cvs.getlst());
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_SapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SapXepActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sắp xếp không?", "Săp xếp", JOptionPane.YES_NO_OPTION);
        System.out.println(choose);
        if (choose != 0) {
            return;
        }
        if (rdo_ASC.isSelected()) {
            loadData(_cvs.sort("DESC"));
            return;
        }
        loadData(_cvs.sort("ASC"));
    }//GEN-LAST:event_btn_SapXepActionPerformed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        loadData(_cvs.find(txt_TimKiem.getText()));
    }//GEN-LAST:event_btn_TimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SapXep;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_ASC;
    private javax.swing.JRadioButton rdo_DESC;
    private javax.swing.JTable tbl_ChucVu;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_Ten;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
