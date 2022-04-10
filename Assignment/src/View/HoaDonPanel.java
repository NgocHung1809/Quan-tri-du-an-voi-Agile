/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Connect.DBConnect;
import Model.HoaDon;
import Model.HoaDonChiTiet;
import java.sql.*;
import Model.SanPham;
import Service.HoaDonChiTietService;
import Service.HoaDonService;
import Service.SanPhamService;
import Utilites.Utilities;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ngọc Hùng
 */
public class HoaDonPanel extends javax.swing.JPanel {

    DefaultTableModel _DefaultTableModelSanPham;
    DefaultTableModel _DefaultTableModelHDCT;
    DefaultTableModel _DefaultTableModelHD;
    SanPhamService _sps;
    JPopupMenu _jpm_SanPham;
    JPopupMenu _jpm_HoaDonChiTiet;
    String _inputSoLuong;
    Utilites.Utilities _utilites;
    HoaDonService _hds;
    HoaDonChiTietService _hdctsv;

    /**
     * Creates new form HoaDonPanel
     */
    public HoaDonPanel() {
        initComponents();
        _jpm_SanPham = new JPopupMenu();
        _jpm_HoaDonChiTiet = new JPopupMenu();
        _utilites = new Utilities();
        _hds = new HoaDonService();
        _hdctsv = new HoaDonChiTietService();
        _DefaultTableModelSanPham = new DefaultTableModel();
        _DefaultTableModelHDCT = new DefaultTableModel();
        _DefaultTableModelHD = new DefaultTableModel();
        _sps = new SanPhamService();
        loadDataTableSanPham(_sps.getlst());
        txt_MaHD.setEnabled(false);
        txt_TongTien.setEnabled(false);
        txt_TienDu.setEnabled(false);
        cbx_TinhTrangHD.setEnabled(false);
        jdc_NgayTao.setEnabled(false);
        cbx_FindTinhTrang();
        cbx_TinhTrang();
        cbx_NhanVien();
        try {
            jdc_NgayTao.setDate(new java.util.Date());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadDataTableHoaDon(_hds.getlst());
        btg_Select();
        loadDataTableHoaDon(_hds.find(String.valueOf(cbx_FindTinhTrang.getSelectedItem().equals("Chờ thanh toán") ? 0 : cbx_FindTinhTrang.getSelectedItem().equals("Đã thanh toán") ? 1 : 3)));

    }

    void cbx_TinhTrang() {
        String[] tt = {"Chờ thanh toán", "Đã thanh toán", "Hủy"};
        cbx_TinhTrangHD.setModel(new DefaultComboBoxModel<>(tt));
        cbx_TinhTrangHD.setSelectedItem("Chờ thanh toán");
    }

    void btg_Select() {
        ButtonGroup x = new ButtonGroup();
        x.add(chx_SelectAll);
        x.add(chx_SelectNone);
    }

    void cbx_NhanVien() {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM NHANVIEN");
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        try {
            while (rs.next()) {
                defaultComboBoxModel.addElement(rs.getString(2));
            }
            cbx_NhanVien.setModel(defaultComboBoxModel);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean getTrangThai() {
        int select = tbl_HoaDon.getSelectedRow();
        if (!tbl_HoaDon.getModel().getValueAt(select, 3).toString().equalsIgnoreCase("Chờ thanh toán")) {
            return true;
        }
        return false;
    }

    void MenuSP() {
        _jpm_SanPham.removeAll();
        JMenuItem item = new JMenuItem("Thêm");
        if (getTrangThai()) {
            item.setVisible(false);
            return;
        }
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txt_MaHD.getText().isBlank()) {
                    return;
                }
                int index = tbl_SanPham.getSelectedRow();
                _inputSoLuong = JOptionPane.showInputDialog("Mời bạn nhập số lượng");
                for (HoaDonChiTiet x : _hdctsv.find(getIDHoaDon(txt_MaHD.getText()))) {
                    if (x.getIdSanPham() == getIDSanPham(tbl_SanPham.getModel().getValueAt(index, 1).toString())) {
                        JOptionPane.showMessageDialog(_jpm_SanPham, "Sản phẩm đã có trong giỏ hàng");
                        return;
                    }
                }
                if (_inputSoLuong.isBlank() || !_inputSoLuong.matches("\\d+")) {
                    JOptionPane.showMessageDialog(_jpm_SanPham, "Số lượng nhập vào không hợp lệ!");
                } else if (Integer.parseInt(_inputSoLuong) > Integer.parseInt(tbl_SanPham.getModel().getValueAt(index, 3).toString())) {
                    JOptionPane.showMessageDialog(_jpm_SanPham, "Số lượng nhập vào lớn hơn số lượng tồn trong kho");
                } else {
//                    _DefaultTableModelHDCT = (DefaultTableModel) tbl_HoaDonChiTiet.getModel();
//                    _DefaultTableModelHDCT.setRowCount(0);
//                    int stt = 0;
//                    _DefaultTableModelHDCT.addRow(new Object[]{++stt, tbl_SanPham.getModel().getValueAt(tbl_SanPham.getSelectedRow(), 1), _inputSoLuong, tbl_SanPham.getModel().getValueAt(tbl_SanPham.getSelectedRow(), 4), false});

//                    int IdHoaDon, int IdSanPham, int SoLuong, String DonGia, int STT
                    _hdctsv.getEditData(new HoaDonChiTiet(getIDHoaDon(txt_MaHD.getText()), getIDSanPham(tbl_SanPham.getModel().getValueAt(index, 1).toString()), Integer.parseInt(_inputSoLuong), Float.parseFloat(_inputSoLuong) * Float.parseFloat(tbl_SanPham.getModel().getValueAt(index, 4).toString()), _hdctsv.getMaxID(_hdctsv.getlst())), "INSERT");
                    loadDataHDCT(_hdctsv.find(getIDHoaDon(txt_MaHD.getText())));
//                    int Id, String Ma, String Ten, int NamBaoHanh, float TrongLuongSP, String MoTaSP, int SLSanPhamTon, BigDecimal GiaNhapSP, BigDecimal GiaBanSP, int IdDSP
                    _sps.getEditData(new SanPham(_sps.getlst().get(index).getId(),
                            _sps.getlst().get(index).getMa(),
                            _sps.getlst().get(index).getTen(),
                            _sps.getlst().get(index).getNamBaoHanh(),
                            _sps.getlst().get(index).getTrongLuongSP(),
                            _sps.getlst().get(index).getMoTaSP(),
                            _sps.getlst().get(index).getSLSanPhamTon() - Integer.parseInt(_inputSoLuong),
                            _sps.getlst().get(index).getGiaNhapSP(),
                            _sps.getlst().get(index).getGiaBanSP(), _sps.getlst().get(index).getIdDSP()), "UPDATE");
                }
                loadDataTableSanPham(_sps.getlst());
                sum();
            }
        });
        _jpm_SanPham.add(item);
    }

    void MenuHDCT() {
        _jpm_HoaDonChiTiet.removeAll();
        JMenuItem item = new JMenuItem("Sửa số lượng");
        if (getTrangThai()) {
            item.setVisible(false);
            return;
        }
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tbl_HoaDonChiTiet.getSelectedRow();
                _inputSoLuong = JOptionPane.showInputDialog("Mời bạn nhập số lượng");
                if (_inputSoLuong.isBlank() || !_inputSoLuong.matches("\\d+")) {
                    JOptionPane.showMessageDialog(_jpm_SanPham, "Số lượng nhập vào không hợp lệ!");
                    return;
                } else if (Integer.parseInt(_inputSoLuong) > Integer.parseInt(tbl_SanPham.getModel().getValueAt(index, 3).toString())) {
                    JOptionPane.showMessageDialog(_jpm_HoaDonChiTiet, "Số lượng nhập vào lớn hơn số lượng tồn trong kho");
                    return;
                } else {
//                    int IdHoaDon, int IdSanPham, int SoLuong, float DonGia, int STT
                    int soLuong = Integer.parseInt(tbl_HoaDonChiTiet.getModel().getValueAt(index, 2).toString());
                    _hdctsv.getEditData(new HoaDonChiTiet(
                            getIDHoaDon(txt_MaHD.getText()),
                            getIDSanPham(tbl_HoaDonChiTiet.getModel().getValueAt(index, 1).toString()),
                            Integer.parseInt(_inputSoLuong),
                            (Float.parseFloat(tbl_HoaDonChiTiet.getModel().getValueAt(index, 3).toString()) / Float.parseFloat(tbl_HoaDonChiTiet.getModel().getValueAt(index, 2).toString())) * Float.parseFloat(_inputSoLuong),
                            1),
                            "UPDATE");
                    System.out.println("done");
                    loadDataHDCT(_hdctsv.find(getIDHoaDon(txt_MaHD.getText())));
//                    int Id, String Ma, String Ten, int NamBaoHanh, float TrongLuongSP, String MoTaSP, int SLSanPhamTon, BigDecimal GiaNhapSP, BigDecimal GiaBanSP, int IdDSP
                    for (SanPham x : _sps.getlst()) {
                        if (x.getTen().equalsIgnoreCase(tbl_HoaDonChiTiet.getModel().getValueAt(index, 1).toString())) {
                            _sps.getEditData(new SanPham(
                                    -1,
                                    x.getMa(),
                                    x.getTen(),
                                    x.getNamBaoHanh(),
                                    x.getTrongLuongSP(),
                                    x.getMoTaSP(),
                                    x.getSLSanPhamTon() + soLuong - Integer.parseInt(_inputSoLuong),
                                    x.getGiaNhapSP(),
                                    x.getGiaBanSP(),
                                    x.getIdDSP()),
                                    "UPDATE");
                            break;
                        }
                    }
                    loadDataTableSanPham(_sps.getlst());
                    sum();
                }
            }
        });
        _jpm_HoaDonChiTiet.add(item);

    }

    void sum() {
        float sum = 0;
        for (HoaDonChiTiet x : _hdctsv.find(getIDHoaDon(txt_MaHD.getText()))) {
            sum += x.getDonGia();
        }
        txt_TongTien.setText(String.valueOf(sum));
    }

    int getIDSanPham(String ten) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM SANPHAM");

        try {
            while (rs.next()) {
                if (ten.equalsIgnoreCase(rs.getString(3))) {
                    System.out.println(rs.getInt(1));
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    int getIDHoaDon(String ma) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM HOADON");
        try {
            while (rs.next()) {
                if (ma.equalsIgnoreCase(rs.getString(2))) {
                    System.out.println(rs.getInt(1));
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    void loadDataHDCT(List<HoaDonChiTiet> data) {
        _DefaultTableModelHDCT = (DefaultTableModel) tbl_HoaDonChiTiet.getModel();
        _DefaultTableModelHDCT.setRowCount(0);
        int stt = 0;
        for (HoaDonChiTiet x : data) {
            _DefaultTableModelHDCT.addRow(new Object[]{++stt, getTenSPFromDB(x.getIdSanPham()), x.getSoLuong(), x.getDonGia()});
        }
    }

    String getTenSPFromDB(int idSP) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM SANPHAM");
        try {
            while (rs.next()) {
                if (idSP == rs.getInt(1)) {
                    return rs.getString(3);
                }
            }
        } catch (SQLException ex) {

        }
        return "NULL";
    }

    String getTenSPFromDB(String MaSP) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM SANPHAM");
        try {
            while (rs.next()) {
                if (MaSP.equalsIgnoreCase(rs.getString(2))) {
                    return rs.getString(3);
                }
            }
        } catch (SQLException ex) {

        }
        return "NULL";
    }

    void loadDataTableSanPham(List<SanPham> data) {
        _DefaultTableModelSanPham = (DefaultTableModel) tbl_SanPham.getModel();
        if (data == null) {
            _DefaultTableModelSanPham.setRowCount(0);
            return;
        }
        _DefaultTableModelSanPham.setRowCount(0);
        int stt = 0;
        for (SanPham x : data) {
            _DefaultTableModelSanPham.addRow(new Object[]{++stt, x.getTen(), getTenSPFromDB(x.getIdDSP()), x.getSLSanPhamTon(), x.getGiaBanSP()});
        }
    }

    String getMaNV(int id) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM NHANVIEN");
        try {
            while (rs.next()) {
                if (id == rs.getInt(1)) {
                    return rs.getString(2);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "NULL";
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
            Logger.getLogger(HoaDonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    void loadDataTableHoaDon(List<HoaDon> data) {
        _DefaultTableModelHD = (DefaultTableModel) tbl_HoaDon.getModel();
        if (data == null) {
            _DefaultTableModelHD.setRowCount(0);
        }
        _DefaultTableModelHD.setRowCount(0);
        int stt = 0;
        for (HoaDon x : data) {
            _DefaultTableModelHD.addRow(new Object[]{++stt, x.getMa(), x.getNgayTaoHoaDon(), x.getTinhTrangHoaDon() == 0 ? "Chờ thanh toán" : x.getTinhTrangHoaDon() == 1 ? "Đã thanh toán" : "Hủy", getMaNV(x.getIdNV())});
        }
    }

    HoaDon getDataGUIHoaDon() {
        return new HoaDon(-1, "HD" + _hds.getMaxID(_hds.getlst()), jdc_NgayTao.getDate(), 0, getIDNV((String) cbx_NhanVien.getSelectedItem()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpn_HoaDon = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_HoaDon = new javax.swing.JTable();
        cbx_FindTinhTrang = new javax.swing.JComboBox<>();
        jpn_HoaDonChiTiet = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_HoaDonChiTiet = new javax.swing.JTable();
        chx_SelectAll = new javax.swing.JCheckBox();
        chx_SelectNone = new javax.swing.JCheckBox();
        btn_Xoa = new javax.swing.JButton();
        jpn_ThongTinHoaDon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_MaHD = new javax.swing.JTextField();
        jdc_NgayTao = new com.toedter.calendar.JDateChooser();
        cbx_TinhTrangHD = new javax.swing.JComboBox<>();
        cbx_NhanVien = new javax.swing.JComboBox<>();
        txt_TongTien = new javax.swing.JTextField();
        txt_TienTra = new javax.swing.JTextField();
        txt_TienDu = new javax.swing.JTextField();
        btn_TaoDon = new javax.swing.JButton();
        btn_ThanhToan = new javax.swing.JButton();
        btn_HuyDon = new javax.swing.JButton();
        btn_InHoaDon = new javax.swing.JButton();
        jpn_SanPham = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_SanPham = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        jpn_HoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn"));

        tbl_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Ngày tạo", "Tình trạng", "Mã NV"
            }
        ));
        tbl_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_HoaDon);

        cbx_FindTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_FindTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_FindTinhTrangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpn_HoaDonLayout = new javax.swing.GroupLayout(jpn_HoaDon);
        jpn_HoaDon.setLayout(jpn_HoaDonLayout);
        jpn_HoaDonLayout.setHorizontalGroup(
            jpn_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_HoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jpn_HoaDonLayout.createSequentialGroup()
                        .addComponent(cbx_FindTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpn_HoaDonLayout.setVerticalGroup(
            jpn_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_HoaDonLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(cbx_FindTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpn_HoaDonChiTiet.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chi tiết"));

        tbl_HoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên SP", "Số lượng", "Đơn giá", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_HoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_HoaDonChiTietMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_HoaDonChiTietMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_HoaDonChiTiet);

        chx_SelectAll.setText("Select all");
        chx_SelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chx_SelectAllActionPerformed(evt);
            }
        });

        chx_SelectNone.setText("Select none");
        chx_SelectNone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chx_SelectNoneActionPerformed(evt);
            }
        });

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpn_HoaDonChiTietLayout = new javax.swing.GroupLayout(jpn_HoaDonChiTiet);
        jpn_HoaDonChiTiet.setLayout(jpn_HoaDonChiTietLayout);
        jpn_HoaDonChiTietLayout.setHorizontalGroup(
            jpn_HoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_HoaDonChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_HoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpn_HoaDonChiTietLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Xoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chx_SelectNone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chx_SelectAll))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpn_HoaDonChiTietLayout.setVerticalGroup(
            jpn_HoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_HoaDonChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpn_HoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chx_SelectAll)
                    .addComponent(chx_SelectNone)
                    .addComponent(btn_Xoa))
                .addGap(24, 24, 24))
        );

        jpn_ThongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        jLabel1.setText("Mã HĐ");

        jLabel2.setText("Ngày tạo");

        jLabel3.setText("Tình trạng");

        jLabel4.setText("Nhân viên");

        jLabel5.setText("Tổng tiền");

        jLabel6.setText("Tiền trả");

        jLabel7.setText("Tiền dư");

        cbx_TinhTrangHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbx_NhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_TienTra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_TienTraCaretUpdate(evt);
            }
        });

        btn_TaoDon.setText("Tạo đơn");
        btn_TaoDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoDonActionPerformed(evt);
            }
        });

        btn_ThanhToan.setText("Thanh toán");
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        btn_HuyDon.setText("Hủy đơn");
        btn_HuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HuyDonActionPerformed(evt);
            }
        });

        btn_InHoaDon.setText("In hóa đơn");

        javax.swing.GroupLayout jpn_ThongTinHoaDonLayout = new javax.swing.GroupLayout(jpn_ThongTinHoaDon);
        jpn_ThongTinHoaDon.setLayout(jpn_ThongTinHoaDonLayout);
        jpn_ThongTinHoaDonLayout.setHorizontalGroup(
            jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_ThongTinHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_ThongTinHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpn_ThongTinHoaDonLayout.createSequentialGroup()
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbx_TinhTrangHD, 0, 130, Short.MAX_VALUE)
                            .addComponent(jdc_NgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpn_ThongTinHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpn_ThongTinHoaDonLayout.createSequentialGroup()
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_TienTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(txt_TongTien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TienDu))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_ThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_TaoDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_HuyDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_InHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        jpn_ThongTinHoaDonLayout.setVerticalGroup(
            jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_ThongTinHoaDonLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_ThongTinHoaDonLayout.createSequentialGroup()
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_TinhTrangHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdc_NgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbx_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_TienTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpn_ThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_TienDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpn_ThongTinHoaDonLayout.createSequentialGroup()
                        .addComponent(btn_TaoDon)
                        .addGap(13, 13, 13)
                        .addComponent(btn_ThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_HuyDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_InHoaDon)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpn_SanPham.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tbl_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên SP", "Dòng SP", "Số lượng", "GIá bán"
            }
        ));
        tbl_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SanPhamMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_SanPhamMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_SanPham);

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jpn_SanPhamLayout = new javax.swing.GroupLayout(jpn_SanPham);
        jpn_SanPham.setLayout(jpn_SanPhamLayout);
        jpn_SanPhamLayout.setHorizontalGroup(
            jpn_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_SanPhamLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jpn_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        jpn_SanPhamLayout.setVerticalGroup(
            jpn_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_SanPhamLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpn_HoaDonChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpn_SanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpn_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpn_ThongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpn_ThongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpn_HoaDonChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpn_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpn_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_SanPhamMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            _jpm_SanPham.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbl_SanPhamMouseReleased

    private void tbl_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseClicked
        // TODO add your handling code here:
        if (txt_MaHD.getText().isBlank()) {
            return;
        }
        MenuSP();
    }//GEN-LAST:event_tbl_SanPhamMouseClicked

    private void btn_TaoDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoDonActionPerformed
        // TODO add your handling code here:
//        cbx_TinhTrangHD.setSelectedItem("Chờ thanh toán");
        JOptionPane.showMessageDialog(this, _hds.getEditData(getDataGUIHoaDon(), "INSERT"));
        loadDataTableHoaDon(_hds.getlst());

    }//GEN-LAST:event_btn_TaoDonActionPerformed

    private void tbl_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonMouseClicked
        // TODO add your handling code here:
        int index = tbl_HoaDon.getSelectedRow();
        txt_MaHD.setText(tbl_HoaDon.getModel().getValueAt(index, 1).toString());
        cbx_TinhTrangHD.setSelectedItem(tbl_HoaDon.getModel().getValueAt(index, 3).toString());
        try {
            jdc_NgayTao.setDate(new SimpleDateFormat("yyyy-mm-dd").parse(tbl_HoaDon.getModel().getValueAt(index, 2).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(HoaDonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbx_NhanVien.setSelectedItem(tbl_HoaDon.getModel().getValueAt(index, 4).toString());

        loadDataHDCT(_hdctsv.find(getIDHoaDon(tbl_HoaDon.getModel().getValueAt(index, 1).toString())));
        sum();

        if (!tbl_HoaDon.getModel().getValueAt(index, 3).toString().equalsIgnoreCase("Chờ thanh toán")) {
            btn_HuyDon.setEnabled(false);
            btn_ThanhToan.setEnabled(false);
            btn_Xoa.setEnabled(false);
        } else {
            btn_HuyDon.setEnabled(true);
            btn_ThanhToan.setEnabled(true);
            btn_Xoa.setEnabled(true);
        }
    }//GEN-LAST:event_tbl_HoaDonMouseClicked

    private void tbl_HoaDonChiTietMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonChiTietMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            _jpm_HoaDonChiTiet.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbl_HoaDonChiTietMouseReleased

    private void tbl_HoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonChiTietMouseClicked
        // TODO add your handling code here:
        MenuHDCT();
    }//GEN-LAST:event_tbl_HoaDonChiTietMouseClicked

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed

        for (int i = 0; i < tbl_HoaDonChiTiet.getRowCount(); i++) {
            if (tbl_HoaDonChiTiet.getValueAt(i, 4) == null || tbl_HoaDonChiTiet.getValueAt(i, 4).toString() != "true") {
                continue;
            }
            int soLuong = Integer.parseInt(tbl_HoaDonChiTiet.getModel().getValueAt(i, 2).toString());
//int Id, String Ma, String Ten, int NamBaoHanh, float TrongLuongSP, String MoTaSP, int SLSanPhamTon, BigDecimal GiaNhapSP, BigDecimal GiaBanSP, int IdDSP
            for (SanPham x : _sps.getlst()) {
                if (x.getTen().equalsIgnoreCase(tbl_HoaDonChiTiet.getModel().getValueAt(i, 1).toString())) {
                    _sps.getEditData(new SanPham(
                            -1,
                            x.getMa(),
                            x.getTen(),
                            x.getNamBaoHanh(),
                            x.getTrongLuongSP(),
                            x.getMoTaSP(),
                            x.getSLSanPhamTon() + soLuong,
                            x.getGiaNhapSP(),
                            x.getGiaBanSP(),
                            x.getIdDSP()),
                            "UPDATE");
                    break;
                }
            }
//            for (HoaDonChiTiet x : _hdctsv.find(txt_MaHD.getText())) {
//                    System.out.println(x);
            System.out.println(tbl_HoaDonChiTiet.getValueAt(i, 1).toString());
            _hdctsv.getEditData(new HoaDonChiTiet(
                    getIDHoaDon(txt_MaHD.getText()),
                    getIDSanPham(tbl_HoaDonChiTiet.getValueAt(i, 1).toString()),
                    1,
                    222,
                    5), "DELETE");
//            }
        }
        loadDataTableSanPham(_sps.getlst());
        loadDataHDCT(_hdctsv.find(getIDHoaDon(txt_MaHD.getText())));
    }//GEN-LAST:event_btn_XoaActionPerformed

    void cbx_FindTinhTrang() {
        String[] tt = {"Chờ thanh toán", "Đã thanh toán", "Hủy"};
        cbx_FindTinhTrang.setModel(new DefaultComboBoxModel<>(tt));
    }

    void getIDHDFromDBHDCT(int id) {
        ResultSet rs = DBConnect.getSelectDataFromDB("SELECT * FROM HOADONCHITIET");
        try {
            while (rs.next()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        // TODO add your handling code here:
        if (txt_TienTra.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Bạn phải có tiền mới mua đc nhé! See you again hihi!");
            return;
        }
        if (!txt_TienTra.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
            return;
        }
        if (Float.parseFloat(txt_TienTra.getText()) < Float.parseFloat(txt_TongTien.getText())) {
            JOptionPane.showMessageDialog(this, "Số tiền bạn hoàn trả không đủ!");
            return;
        }
        if (Float.parseFloat(txt_TienTra.getText()) > Float.parseFloat(txt_TongTien.getText())) {
            int select = tbl_HoaDon.getSelectedRow();
            _hds.getEditData(new HoaDon(getIDHoaDon(txt_MaHD.getText()), txt_MaHD.getText(), new java.util.Date(), 1, getIDNV(String.valueOf(cbx_NhanVien.getSelectedItem()))), "UPDATE");
            loadDataTableHoaDon(_hds.getlst());
        }

    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void chx_SelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chx_SelectAllActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < tbl_HoaDonChiTiet.getRowCount(); i++) {
            tbl_HoaDonChiTiet.getModel().setValueAt(true, i, 4);
        }
    }//GEN-LAST:event_chx_SelectAllActionPerformed

    private void chx_SelectNoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chx_SelectNoneActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < tbl_HoaDonChiTiet.getRowCount(); i++) {
            tbl_HoaDonChiTiet.getModel().setValueAt(false, i, 4);
        }
    }//GEN-LAST:event_chx_SelectNoneActionPerformed

    private void btn_HuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyDonActionPerformed
        // TODO add your handling code here:
        _hds.getEditData(new HoaDon(1, txt_MaHD.getText(), jdc_NgayTao.getDate(), 3, getIDNV((String) cbx_NhanVien.getSelectedItem())), "UPDATE");
        loadDataTableHoaDon(_hds.getlst());
        for (int i = 0; i < tbl_HoaDonChiTiet.getRowCount(); i++) {
            int soLuong = Integer.parseInt(tbl_HoaDonChiTiet.getModel().getValueAt(i, 2).toString());
//int Id, String Ma, String Ten, int NamBaoHanh, float TrongLuongSP, String MoTaSP, int SLSanPhamTon, BigDecimal GiaNhapSP, BigDecimal GiaBanSP, int IdDSP
            for (SanPham x : _sps.getlst()) {
                if (x.getTen().equalsIgnoreCase(tbl_HoaDonChiTiet.getModel().getValueAt(i, 1).toString())) {
                    _sps.getEditData(new SanPham(
                            -1,
                            x.getMa(),
                            x.getTen(),
                            x.getNamBaoHanh(),
                            x.getTrongLuongSP(),
                            x.getMoTaSP(),
                            x.getSLSanPhamTon() + soLuong,
                            x.getGiaNhapSP(),
                            x.getGiaBanSP(),
                            x.getIdDSP()),
                            "UPDATE");
                    break;
                }
            }
        }
        loadDataTableSanPham(_sps.getlst());
    }//GEN-LAST:event_btn_HuyDonActionPerformed

    private void cbx_FindTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_FindTinhTrangActionPerformed
        // TODO add your handling code here:
        loadDataTableHoaDon(_hds.find(String.valueOf(cbx_FindTinhTrang.getSelectedItem().equals("Chờ thanh toán") ? 0 : cbx_FindTinhTrang.getSelectedItem().equals("Đã thanh toán") ? 1 : 3)));

    }//GEN-LAST:event_cbx_FindTinhTrangActionPerformed

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        // TODO add your handling code here:
        loadDataTableSanPham(_sps.findName(jTextField1.getText()));
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void txt_TienTraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_TienTraCaretUpdate
        // TODO add your handling code here:
        if (txt_TienTra.getText().isBlank()) {
            return;
        }
        if (!txt_TienTra.getText().matches("\\d+")) {
            return;
        }
        txt_TienDu.setText(String.valueOf(Float.parseFloat(txt_TienTra.getText()) - Float.parseFloat(txt_TongTien.getText())));
//        if (Float.parseFloat(String.valueOf(Float.parseFloat(txt_TienTra.getText()) - Float.parseFloat(txt_TongTien.getText()))) < 0) {
//            txt_TienDu.setForeground(Color.red);
//            return;
//        }
//        txt_TienDu.setForeground(Color.white);

    }//GEN-LAST:event_txt_TienTraCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_HuyDon;
    private javax.swing.JButton btn_InHoaDon;
    private javax.swing.JButton btn_TaoDon;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbx_FindTinhTrang;
    private javax.swing.JComboBox<String> cbx_NhanVien;
    private javax.swing.JComboBox<String> cbx_TinhTrangHD;
    private javax.swing.JCheckBox chx_SelectAll;
    private javax.swing.JCheckBox chx_SelectNone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JDateChooser jdc_NgayTao;
    private javax.swing.JPanel jpn_HoaDon;
    private javax.swing.JPanel jpn_HoaDonChiTiet;
    private javax.swing.JPanel jpn_SanPham;
    private javax.swing.JPanel jpn_ThongTinHoaDon;
    private javax.swing.JTable tbl_HoaDon;
    private javax.swing.JTable tbl_HoaDonChiTiet;
    private javax.swing.JTable tbl_SanPham;
    private javax.swing.JTextField txt_MaHD;
    private javax.swing.JTextField txt_TienDu;
    private javax.swing.JTextField txt_TienTra;
    private javax.swing.JTextField txt_TongTien;
    // End of variables declaration//GEN-END:variables
}
