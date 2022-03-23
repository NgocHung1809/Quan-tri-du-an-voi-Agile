/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import View.HoSoPanel;
import View.HoaDonJPanel;
import View.KhachHangPanel;
import View.NhanVienPanel;
import View.SanPhamPanel;
import javax.swing.JPanel;

/**
 *
 * @author Ngọc Hùng
 */
public class TrangChu extends javax.swing.JFrame {
    
    JPanel child;
    
    /**
     * Creates new form TrangChu
     */
    public TrangChu() {
        initComponents();
        setTitle("Quản lý bán giày");
        setSize(1100, 700);
    }

    void showControl(JPanel panel){
        child = panel;
        jpn_Control.removeAll();
        jpn_Control.add(child);
        jpn_Control.validate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpn_Menu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_SanPham1 = new javax.swing.JButton();
        btn_KhachHang1 = new javax.swing.JButton();
        btn_HoaDon1 = new javax.swing.JButton();
        btn_NhanVien1 = new javax.swing.JButton();
        btn_Thoat1 = new javax.swing.JButton();
        btn_HoSo1 = new javax.swing.JButton();
        jpn_LogoTrangChu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpn_Control = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpn_Menu.setBackground(new java.awt.Color(255, 255, 255));
        jpn_Menu.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(250, 248, 248));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        btn_SanPham1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_SanPham1.setIcon(new javax.swing.ImageIcon("E:\\Warehouse material\\Quan ly du an voi phan mem Agile\\Agile Edit\\Images\\SanPham.png")); // NOI18N
        btn_SanPham1.setText("      SẢN PHẨM");
        btn_SanPham1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SanPhamActionPerformed(evt);
            }
        });

        btn_KhachHang1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_KhachHang1.setIcon(new javax.swing.ImageIcon("E:\\Warehouse material\\Quan ly du an voi phan mem Agile\\Agile Edit\\Images\\KhachHang.png")); // NOI18N
        btn_KhachHang1.setText("  KHÁCH HÀNG");
        btn_KhachHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KhachHangActionPerformed(evt);
            }
        });

        btn_HoaDon1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_HoaDon1.setIcon(new javax.swing.ImageIcon("E:\\Warehouse material\\Quan ly du an voi phan mem Agile\\Agile Edit\\Images\\HoaDon.png")); // NOI18N
        btn_HoaDon1.setText("       HÓA ĐƠN");
        btn_HoaDon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HoaDonActionPerformed(evt);
            }
        });

        btn_NhanVien1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_NhanVien1.setIcon(new javax.swing.ImageIcon("E:\\Warehouse material\\Quan ly du an voi phan mem Agile\\Agile Edit\\Images\\NhanVien.png")); // NOI18N
        btn_NhanVien1.setText("       NHÂN VIÊN");
        btn_NhanVien1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhanVienActionPerformed(evt);
            }
        });

        btn_Thoat1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Thoat1.setIcon(new javax.swing.ImageIcon("E:\\Warehouse material\\Quan ly du an voi phan mem Agile\\Agile Edit\\Images\\Thoat.png")); // NOI18N
        btn_Thoat1.setText("          THOÁT");

        btn_HoSo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_HoSo1.setIcon(new javax.swing.ImageIcon("E:\\Warehouse material\\Quan ly du an voi phan mem Agile\\Agile Edit\\Images\\HoSo.png")); // NOI18N
        btn_HoSo1.setText("            HỒ SƠ");
        btn_HoSo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HoSoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_SanPham1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_KhachHang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_HoaDon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_NhanVien1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Thoat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_HoSo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_SanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_KhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_NhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_HoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_HoSo1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Thoat1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jpn_LogoTrangChu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\Warehouse material\\Quan ly du an voi phan mem Agile\\Agile Edit\\Images\\Logo_TrangChu.jpg")); // NOI18N
        jLabel1.setAlignmentY(0.0F);

        javax.swing.GroupLayout jpn_MenuLayout = new javax.swing.GroupLayout(jpn_Menu);
        jpn_Menu.setLayout(jpn_MenuLayout);
        jpn_MenuLayout.setHorizontalGroup(
            jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpn_MenuLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jpn_LogoTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpn_MenuLayout.setVerticalGroup(
            jpn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_MenuLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpn_LogoTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpn_Control.setBackground(new java.awt.Color(255, 255, 255));
        jpn_Control.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpn_Control, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpn_Control, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpn_Menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HoSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HoSoActionPerformed
        // TODO add your handling code here:
        showControl(new HoSoPanel());
    }//GEN-LAST:event_btn_HoSoActionPerformed

    private void btn_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhanVienActionPerformed
        // TODO add your handling code here:
        showControl(new NhanVienPanel());
    }//GEN-LAST:event_btn_NhanVienActionPerformed

    private void btn_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HoaDonActionPerformed
        // TODO add your handling code here:
        showControl(new HoaDonJPanel());
    }//GEN-LAST:event_btn_HoaDonActionPerformed

    private void btn_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KhachHangActionPerformed
        // TODO add your handling code here:
        showControl(new KhachHangPanel());
    }//GEN-LAST:event_btn_KhachHangActionPerformed

    private void btn_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SanPhamActionPerformed
        // TODO add your handling code here:
        showControl(new SanPhamPanel());
    }//GEN-LAST:event_btn_SanPhamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_HoSo1;
    private javax.swing.JButton btn_HoaDon1;
    private javax.swing.JButton btn_KhachHang1;
    private javax.swing.JButton btn_NhanVien1;
    private javax.swing.JButton btn_SanPham1;
    private javax.swing.JButton btn_Thoat1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jpn_Control;
    private javax.swing.JPanel jpn_LogoTrangChu;
    private javax.swing.JPanel jpn_Menu;
    // End of variables declaration//GEN-END:variables
}
