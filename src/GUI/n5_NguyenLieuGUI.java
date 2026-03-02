package GUI;

import Util.TableCustom;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.n5_NguyenLieuBUS;
import DTO.NguyenLieuDTO;
public class n5_NguyenLieuGUI extends javax.swing.JPanel {
    private String regex = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?~].*";
    private n5_NguyenLieuBUS nguyenLieuBUS;
    public n5_NguyenLieuGUI() {
        this.nguyenLieuBUS = new n5_NguyenLieuBUS();
        initComponents();
        TableCustom.apply(scrollpane, TableCustom.TableType.MULTI_LINE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTong = new javax.swing.JPanel();
        lb_QuanLyNL = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lb_MaNL = new java.awt.Label();
        lb_TenNL = new java.awt.Label();
        lb_DonGia = new java.awt.Label();
        lb_KhoiLuong = new java.awt.Label();
        lb_ThongTinNguyenLieu = new javax.swing.JLabel();
        tf_MaNL = new javax.swing.JTextField();
        tf_TenNL = new javax.swing.JTextField();
        tf_KhoiLuong = new javax.swing.JTextField();
        tf_DonGia = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        PanelTimKiem = new javax.swing.JPanel();
        TextFieldTimKiem = new javax.swing.JTextField();
        LabelAnhTimKiem = new javax.swing.JLabel();
        comboboxTrangThai = new javax.swing.JComboBox<>();
        btn_TimKiem = new javax.swing.JButton();
        btn_TaiLai = new javax.swing.JButton();
        PanelChuaNut = new javax.swing.JPanel();
        btn_Sua = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_XuatExcel = new javax.swing.JButton();
        scrollpane = new javax.swing.JScrollPane();
        tb_DanhSachNL = new javax.swing.JTable();

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1125, 667));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setPreferredSize(new java.awt.Dimension(1125, 658));

        lb_QuanLyNL.setAlignment(java.awt.Label.CENTER);
        lb_QuanLyNL.setBackground(new java.awt.Color(219, 189, 142));
        lb_QuanLyNL.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lb_QuanLyNL.setMaximumSize(new java.awt.Dimension(206, 42));
        lb_QuanLyNL.setMinimumSize(new java.awt.Dimension(206, 42));
        lb_QuanLyNL.setText("QUẢN LÝ NGUYÊN LIỆU");

        jPanel2.setBackground(new java.awt.Color(219, 189, 142));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(500, 300));
        jPanel3.setMinimumSize(new java.awt.Dimension(500, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(260, 280));

        lb_MaNL.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lb_MaNL.setText("Mã NL");

        lb_TenNL.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lb_TenNL.setText("Tên NL");

        lb_DonGia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lb_DonGia.setText("Đơn Giá");

        lb_KhoiLuong.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lb_KhoiLuong.setText("Khối Lượng");

        lb_ThongTinNguyenLieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_ThongTinNguyenLieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ThongTinNguyenLieu.setText("Thông Tin Nguyên Liệu");
        lb_ThongTinNguyenLieu.setAlignmentX(0.5F);

        tf_MaNL.setBorder(null);
        tf_MaNL.setMaximumSize(new java.awt.Dimension(150, 25));
        tf_MaNL.setMinimumSize(new java.awt.Dimension(150, 25));
        tf_MaNL.setPreferredSize(new java.awt.Dimension(150, 25));
        tf_MaNL.setEditable(false);
        tf_MaNL.setEnabled(false);
        tf_MaNL.setBackground(Color.WHITE);
        tf_MaNL.setDisabledTextColor(Color.BLUE);

        tf_TenNL.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0), null));
        tf_TenNL.setMaximumSize(new java.awt.Dimension(150, 25));
        tf_TenNL.setMinimumSize(new java.awt.Dimension(150, 25));
        tf_TenNL.setPreferredSize(new java.awt.Dimension(150, 25));

        tf_KhoiLuong.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tf_KhoiLuong.setMaximumSize(new java.awt.Dimension(150, 25));
        tf_KhoiLuong.setMinimumSize(new java.awt.Dimension(150, 25));
        tf_KhoiLuong.setPreferredSize(new java.awt.Dimension(150, 25));
        tf_KhoiLuong.setEditable(false);
        tf_KhoiLuong.setEnabled(false);
        tf_KhoiLuong.setForeground(Color.BLACK);
        tf_KhoiLuong.setBackground(Color.LIGHT_GRAY);
        tf_KhoiLuong.setDisabledTextColor(Color.BLACK);

        tf_DonGia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tf_DonGia.setMaximumSize(new java.awt.Dimension(150, 25));
        tf_DonGia.setMinimumSize(new java.awt.Dimension(150, 25));
        tf_DonGia.setPreferredSize(new java.awt.Dimension(150, 25));
        tf_DonGia.setEditable(false);
        tf_DonGia.setEnabled(false);
        tf_DonGia.setForeground(Color.BLACK);
        tf_DonGia.setBackground(Color.LIGHT_GRAY);
        tf_DonGia.setDisabledTextColor(Color.BLACK);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_TenNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_MaNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tf_TenNL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf_MaNL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lb_KhoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator3)
                                        .addComponent(tf_KhoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(245, 245, 245))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_ThongTinNguyenLieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_DonGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lb_ThongTinNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_MaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_MaNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_TenNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_TenNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_KhoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_KhoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_DonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_DonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);

        PanelTimKiem.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem.setMaximumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setMinimumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setPreferredSize(new java.awt.Dimension(270, 32));

        TextFieldTimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TextFieldTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiem();
            }
        });

        LabelAnhTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelAnhTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search.png"))); // NOI18N

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(TextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelAnhTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelAnhTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldTimKiem))
                .addGap(4, 4, 4))
        );

        comboboxTrangThai.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        comboboxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Nguyên Liệu", "Tên Nguyên Liệu" }));
        comboboxTrangThai.setBorder(null);
        comboboxTrangThai.setMaximumSize(new java.awt.Dimension(130, 24));
        comboboxTrangThai.setMinimumSize(new java.awt.Dimension(130, 24));
        comboboxTrangThai.setPreferredSize(new java.awt.Dimension(130, 24));

        btn_TimKiem.setBackground(new java.awt.Color(0, 0, 0));
        btn_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_TimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiem.setLabel("Tìm Kiếm");
        btn_TimKiem.setMaximumSize(new java.awt.Dimension(100, 24));
        btn_TimKiem.setMinimumSize(new java.awt.Dimension(100, 24));
        btn_TimKiem.setPreferredSize(new java.awt.Dimension(100, 24));
        btn_TimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiem();
            }
        });

        btn_TaiLai.setBackground(new java.awt.Color(0, 0, 0));
        btn_TaiLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_TaiLai.setForeground(new java.awt.Color(255, 255, 255));
        btn_TaiLai.setText("Tải Lại");
        btn_TaiLai.setMaximumSize(new java.awt.Dimension(100, 24));
        btn_TaiLai.setMinimumSize(new java.awt.Dimension(100, 24));
        btn_TaiLai.setPreferredSize(new java.awt.Dimension(100, 24));
        btn_TaiLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadData();
            }
        });

        PanelChuaNut.setBackground(new java.awt.Color(255, 255, 255));

        btn_Sua.setBackground(new java.awt.Color(0, 0, 0));
        btn_Sua.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sua.setText("Sửa");
        btn_Sua.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_Sua.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_Sua.setPreferredSize(new java.awt.Dimension(100, 26));
        btn_Sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_SuaAction();
            }
        });

        btn_Them.setBackground(new java.awt.Color(0, 0, 0));
        btn_Them.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setText("Thêm");
        btn_Them.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_Them.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_Them.setPreferredSize(new java.awt.Dimension(100, 26));
        
        btn_Them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_ThemAction();
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(0, 0, 0));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setText("Xóa");
        btn_Xoa.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_Xoa.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_Xoa.setPreferredSize(new java.awt.Dimension(100, 26));
        btn_Xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_XoaAction();
            }
        });

        btn_XuatExcel.setBackground(new java.awt.Color(0, 0, 0));
        btn_XuatExcel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_XuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_XuatExcel.setText("Xuất Excel");
        btn_XuatExcel.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_XuatExcel.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_XuatExcel.setPreferredSize(new java.awt.Dimension(100, 26));
        btn_XuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn_XuatExcelAction();
            }
        });

        javax.swing.GroupLayout PanelChuaNutLayout = new javax.swing.GroupLayout(PanelChuaNut);
        PanelChuaNut.setLayout(PanelChuaNutLayout);
        PanelChuaNutLayout.setHorizontalGroup(
            PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChuaNutLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelChuaNutLayout.createSequentialGroup()
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChuaNutLayout.createSequentialGroup()
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        PanelChuaNutLayout.setVerticalGroup(
            PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChuaNutLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        fillTable();
        
        // Thêm ListSelectionListener vào JTable để xử lý sự kiện chọn hàng
        tb_DanhSachNL.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Kiểm tra xem có hàng nào đang được chọn không
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tb_DanhSachNL.getSelectedRow();
                    if (selectedRow != -1) {
                        // Lấy dữ liệu của hàng được chọn
                        String ma = String.valueOf(tb_DanhSachNL.getValueAt(selectedRow, 0));
                        String ten =  String.valueOf(tb_DanhSachNL.getValueAt(selectedRow, 1));
                        String khoiLuong =  String.valueOf(tb_DanhSachNL.getValueAt(selectedRow, 2));
                        String donGia =  String.valueOf(tb_DanhSachNL.getValueAt(selectedRow, 3));
                        tf_MaNL.setText(ma);
                        tf_TenNL.setText(ten);
                        tf_KhoiLuong.setText(khoiLuong);
                        tf_DonGia.setText(String.valueOf(convertCurrencyToInt(donGia)));
                    }
                }
            }
        });
        scrollpane.setViewportView(tb_DanhSachNL);

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_QuanLyNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelTongLayout.createSequentialGroup()
                                .addComponent(PanelChuaNut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(53, 53, 53)
                                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelTongLayout.createSequentialGroup()
                                .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboboxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btn_TaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addComponent(lb_QuanLyNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboboxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_TaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(PanelChuaNut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public String toCurrency(int giaTien) {
        // Sử dụng NumberFormat để định dạng tiền tệ
       NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("vi-VN"));
       String formattedNumber = numberFormat.format(giaTien);
       // Thêm ký hiệu tiền tệ "đ"
       return formattedNumber + "đ";
   }
   public int convertCurrencyToInt(String currency) {
       // Loại bỏ ký hiệu tiền tệ và dấu chấm
       String cleanString = currency.replaceAll("[\\.đ]", "").trim();
       
       // Chuyển đổi chuỗi sang số nguyên
       return Integer.parseInt(cleanString); // Trả về giá trị kiểu int
   }
   public void reloadData() {
       tf_MaNL.setText("");
       tf_TenNL.setText("");
       tf_KhoiLuong.setText("");
       tf_DonGia.setText("");
       TextFieldTimKiem.setText("");
       fillTable();
   }
   public void fillTable() {
       DefaultTableModel modelTable = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            // Không cho phép chỉnh sửa bất kỳ ô nào
            return false;
        }
    };
       modelTable.addColumn("Mã Nguyên Liệu");
       modelTable.addColumn("Tên Nguyên Liệu");
       modelTable.addColumn("Khối Lượng");
       modelTable.addColumn("Đơn Giá");
       
       ArrayList<NguyenLieuDTO> list = nguyenLieuBUS.getAll();
       for(int i = 0; i < list.size(); i++) {
           modelTable.addRow(new Object[] {
               list.get(i).getMaNguyenLieu(),
               list.get(i).getTenNguyenLieu(),
               list.get(i).getKhoiLuongNguyenLieu(),
               toCurrency(list.get(i).getDonGiaNguyenLieu()),
           });
       }
       
       tb_DanhSachNL.setModel(modelTable);
   }
   public boolean checkMoneyMount(String moneyMount) {
       try {
           int amount = Integer.parseInt(moneyMount);
           //? Kiểm tra số tiền phải lớn hơn hoặc bằng 0
           if (amount < 0) {
               return false;
           }
           //? Kiểm tra chuỗi không chỉ chứa ký tự số và dấu thập phân hợp lệ (không có ký tự không hợp lệ)
           String regex = "^[0-9]+(\\.[0-9]{1,2})?$";
           return moneyMount.matches(regex);
       } catch (NumberFormatException e) {
           return false;
       }
   }
    public void timKiem() {
        ArrayList<NguyenLieuDTO> dsTimDuoc = new ArrayList<>();
        ArrayList<NguyenLieuDTO> dsNL = nguyenLieuBUS.getAll();
        String input = String.valueOf(TextFieldTimKiem.getText()).toLowerCase().trim();
        if(input.length() ==  0) {
            JOptionPane.showMessageDialog(null, "Tìm kiếm không được để trống !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            reloadData();
            return;
        }
        if(input.length() > 50) {
            JOptionPane.showMessageDialog(null, "Tìm kiếm không được vượt quá 50 ký tự !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(comboboxTrangThai.getSelectedItem().toString().equals("Mã Nguyên Liệu")) {
            for (int i = 0; i < dsNL.size(); i++) {
                if(dsNL.get(i).getMaNguyenLieu().toLowerCase().contains(input)) {
                    dsTimDuoc.add(dsNL.get(i));
                }
            }
        } else if(comboboxTrangThai.getSelectedItem().toString().equals("Tên Nguyên Liệu")){
            for (int i = 0; i < dsNL.size(); i++) {
                if(dsNL.get(i).getTenNguyenLieu().toLowerCase().contains(input)) {
                    dsTimDuoc.add(dsNL.get(i));
                }
            }
        }
        if(dsTimDuoc.size() == 0) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy nguyên liệu phù hợp !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Mã Nguyên Liệu");
        modelTable.addColumn("Tên Nguyên Liệu");
        modelTable.addColumn("Khối Lượng");
        modelTable.addColumn("Đơn Giá");
        for(int i = 0; i < dsTimDuoc.size(); i++) {
            modelTable.addRow(new Object[] {
                dsTimDuoc.get(i).getMaNguyenLieu(),
                dsTimDuoc.get(i).getTenNguyenLieu(),
                dsTimDuoc.get(i).getKhoiLuongNguyenLieu(),
                toCurrency(dsTimDuoc.get(i).getDonGiaNguyenLieu()),
            });
        }
        
        tb_DanhSachNL.setModel(modelTable);
    }
    public void btn_SuaAction(){
        int selectedRow = tb_DanhSachNL.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(null,"Bạn có muốn sửa nguyên liệu này?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                String ma = String.valueOf(tf_MaNL.getText());
                String ten = String.valueOf(tf_TenNL.getText());
                if(ten.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Tên nguyên liệu không được vượt quá 50 ký tự !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(ten.matches(regex)) {
                    JOptionPane.showMessageDialog(null, "Tên nguyên liệu không được chứa ký tự đặc biệt !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //? Không cập nhật khối lượng và đơn giá
                NguyenLieuDTO nguyenLieu = new NguyenLieuDTO(ma, ten, 0, 0, true);
                if(nguyenLieuBUS.updateNguyenLieu(nguyenLieu)){
                    JOptionPane.showMessageDialog(null, "Sửa nguyên liệu thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    reloadData();
                }
                else 
                    JOptionPane.showMessageDialog(null, "Sửa nguyên liệu thất bại !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sản phẩm để sửa !", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void btn_ThemAction() {
        if(!tf_MaNL.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nguyên liệu đã tồn tại !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null,"Bạn có muốn thêm nguyên liệu này?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    String ten = String.valueOf(tf_TenNL.getText());
                    if(ten.length() == 0) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nguyên liệu !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(ten.length() > 50) {
                        JOptionPane.showMessageDialog(null, "Tên nguyên liệu không được vượt quá 50 ký tự !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(ten.matches(regex)) {
                        JOptionPane.showMessageDialog(null, "Tên nguyên liệu không được chứa ký tự đặc biệt !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // Khóa khối lượng và đơn giá
                    NguyenLieuDTO nguyenLieu = new NguyenLieuDTO(null, ten, 0, 0, true);
                    for (NguyenLieuDTO a : nguyenLieuBUS.getAll()) {
                        if(nguyenLieu.getTenNguyenLieu().toLowerCase().trim().equals(a.getTenNguyenLieu().toLowerCase().trim())) {
                            JOptionPane.showMessageDialog(null, "Tên nguyên liệu đã tồn tại !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return;
                        }
                    }
                    if(nguyenLieuBUS.addNguyenLieu(nguyenLieu)){
                        JOptionPane.showMessageDialog(null, "Thêm nguyên liệu thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        reloadData();
                    }
                    else 
                        JOptionPane.showMessageDialog(null, "Thêm nguyên liệu thất bại !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
    }
    public void btn_XuatExcelAction() {
        String fileName = "listNguyenLieu.xlsx";
                String filePath = "src\\EXCEL\\"+fileName;
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Sheet1");

                // Lấy mô hình dữ liệu từ JTable
                TableModel model = tb_DanhSachNL.getModel();
                // Tạo hàng tiêu đề (header)
                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(model.getColumnName(col));
                }

                // Ghi dữ liệu từ JTable vào tệp Excel
                for (int row = 0; row < model.getRowCount(); row++) {
                    Row excelRow = sheet.createRow(row + 1);
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Cell cell = excelRow.createCell(col);
                        cell.setCellValue(model.getValueAt(row, col).toString());
                    }
                }
                // Ghi workbook vào tệp và mở tệp sau khi lưu
                try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                    workbook.write(outputStream);
                    workbook.close();
                    System.out.println("Xuất file Excel thành công!");

                    // Mở tệp ngay sau khi lưu
                    File file = new File(filePath);
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(file);
                    } else {
                        System.out.println("Mở tệp không được hỗ trợ trên hệ thống này.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }   
    }
    public void btn_XoaAction() {
        int selectedRow = tb_DanhSachNL.getSelectedRow();
        if (selectedRow != -1) {
            if(nguyenLieuBUS.getNguyenLieuById(String.valueOf(tf_MaNL.getText())).getKhoiLuongNguyenLieu() != 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng sử dụng hết nguyên liệu trước khi xóa !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa nguyên liệu này?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                String ma = String.valueOf(tf_MaNL.getText());
                if(nguyenLieuBUS.deleteNguyenLieu(ma)) {
                    JOptionPane.showMessageDialog(null, "Xóa nguyên liệu thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    reloadData();
                }
                else 
                JOptionPane.showMessageDialog(null, "Xóa nguyên liệu thất bại !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sản phẩm để xóa !", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAnhTimKiem;
    private javax.swing.JPanel PanelChuaNut;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JTextField TextFieldTimKiem;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_TaiLai;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XuatExcel;
    private javax.swing.JComboBox<String> comboboxTrangThai;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private java.awt.Label lb_DonGia;
    private java.awt.Label lb_KhoiLuong;
    private java.awt.Label lb_MaNL;
    private java.awt.Label lb_QuanLyNL;
    private java.awt.Label lb_TenNL;
    private javax.swing.JLabel lb_ThongTinNguyenLieu;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable tb_DanhSachNL;
    private javax.swing.JTextField tf_DonGia;
    private javax.swing.JTextField tf_KhoiLuong;
    private javax.swing.JTextField tf_MaNL;
    private javax.swing.JTextField tf_TenNL;
    // End of variables declaration//GEN-END:variables
}
