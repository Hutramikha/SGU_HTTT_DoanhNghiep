package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import com.toedter.calendar.JDateChooser;
import Util.TableCustom;
import Util.dialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.Period;
// import javax.swing.JTable;
import BUS.NhanVienBUS;
import BUS.PhanQuyenBUS;
import BUS.TaiKhoanBUS;
import Util.XuLyFileExcel;

import BUS.KhachHangBUS;
import Util.TableCustom;

public class n2_KhachHangGUI extends javax.swing.JPanel {

    public n2_KhachHangGUI() {
        initComponents();
        loadData();
        TableCustom.apply(ScrollPane, TableCustom.TableType.MULTI_LINE); // Hàm chung của nhóm ở Package Util
        nhomNutChucNang();
    }
    // Hàm init sắp xếp vị trí components
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTong = new javax.swing.JPanel();
        PanelInput = new javax.swing.JPanel();
        PanelThongTin = new javax.swing.JPanel();
        PanelNoiDungThongTin = new javax.swing.JPanel();
        LabelTieuDe = new javax.swing.JLabel();
        PanelThuocTinh = new javax.swing.JPanel();
        LblMa = new javax.swing.JLabel();
        TextFieldMa = new javax.swing.JTextField();
        LblTen = new javax.swing.JLabel();
        TextFieldTen = new javax.swing.JTextField();
        LblSDT = new javax.swing.JLabel();
        TextFieldSDT = new javax.swing.JTextField();
        LblGioiTinh = new javax.swing.JLabel();
        ComboBoxGioiTinh = new javax.swing.JComboBox<>();
        LblNgaySinh = new javax.swing.JLabel();
        LblTongChiTieu = new javax.swing.JLabel();
        TextFeildTongChiTieu = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jDNgaySinh = new com.toedter.calendar.JDateChooser();
        PanelChuaNut = new javax.swing.JPanel();
        btn_Sua = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        LabelTenBang = new javax.swing.JLabel();
        BtnTimKiem = new javax.swing.JButton();
        btnTaiLai = new javax.swing.JButton();
        PanelTimKiem = new javax.swing.JPanel();
        TextFieldTimKiem = new javax.swing.JTextField();
        LabelAnhTimKiem = new javax.swing.JLabel();
        cmbTimKiem = new javax.swing.JComboBox<>();
        btn_XuatExcel = new javax.swing.JButton();

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setVerifyInputWhenFocusTarget(false);

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setPreferredSize(new java.awt.Dimension(1125, 658));

        PanelInput.setBackground(new java.awt.Color(255, 255, 255));

        PanelThongTin.setBackground(new java.awt.Color(219, 189, 142));
        PanelThongTin.setMaximumSize(new java.awt.Dimension(237, 362));
        PanelThongTin.setMinimumSize(new java.awt.Dimension(237, 362));
        PanelThongTin.setPreferredSize(new java.awt.Dimension(237, 362));
        PanelThongTin.setRequestFocusEnabled(false);
        PanelThongTin.setVerifyInputWhenFocusTarget(false);

        PanelNoiDungThongTin.setBackground(new java.awt.Color(255, 255, 255));
        PanelNoiDungThongTin.setMaximumSize(new java.awt.Dimension(290, 315));
        PanelNoiDungThongTin.setMinimumSize(new java.awt.Dimension(275, 315));
        PanelNoiDungThongTin.setPreferredSize(new java.awt.Dimension(290, 315));

        LabelTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelTieuDe.setText("Thông Tin Khách Hàng");

        PanelThuocTinh.setBackground(new java.awt.Color(255, 255, 255));

        LblMa.setBackground(new java.awt.Color(255, 255, 255));
        LblMa.setText("Mã KH");

        TextFieldMa.setEditable(false);
        TextFieldMa.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldMa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TextFieldMa.setBorder(null);
        TextFieldMa.setMaximumSize(new java.awt.Dimension(160, 28));
        TextFieldMa.setMinimumSize(new java.awt.Dimension(160, 28));
        TextFieldMa.setPreferredSize(new java.awt.Dimension(160, 28));
        TextFieldMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldMaActionPerformed(evt);
            }
        });

        LblTen.setBackground(new java.awt.Color(255, 255, 255));
        LblTen.setText("Tên KH");

        TextFieldTen.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TextFieldTen.setBorder(null);
        TextFieldTen.setMaximumSize(new java.awt.Dimension(160, 28));
        TextFieldTen.setMinimumSize(new java.awt.Dimension(160, 28));
        TextFieldTen.setPreferredSize(new java.awt.Dimension(160, 28));
        // TextFieldTen.setRequestFocusEnabled(false);
        TextFieldTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldTenActionPerformed(evt);
            }
        });

        LblSDT.setBackground(new java.awt.Color(255, 255, 255));
        LblSDT.setText("Số Điện Thoại");

        TextFieldSDT.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TextFieldSDT.setBorder(null);
        TextFieldSDT.setMaximumSize(new java.awt.Dimension(160, 28));
        TextFieldSDT.setMinimumSize(new java.awt.Dimension(160, 28));
        TextFieldSDT.setPreferredSize(new java.awt.Dimension(160, 28));
        TextFieldSDT.setVerifyInputWhenFocusTarget(false);
        TextFieldSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldSDTActionPerformed(evt);
            }
        });

        LblGioiTinh.setBackground(new java.awt.Color(255, 255, 255));
        LblGioiTinh.setText("Giới Tính");

        ComboBoxGioiTinh.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        ComboBoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn giới tính", "Nam", "Nữ" }));
        ComboBoxGioiTinh.setBorder(null);
        ComboBoxGioiTinh.setPreferredSize(new java.awt.Dimension(93, 25));

        LblNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        LblNgaySinh.setText("Ngày Sinh");

        LblTongChiTieu.setBackground(new java.awt.Color(255, 255, 255));
        LblTongChiTieu.setText("Tổng Chi Tiêu");

        TextFeildTongChiTieu.setEditable(false);
        TextFeildTongChiTieu.setBackground(new java.awt.Color(255, 255, 255));
        TextFeildTongChiTieu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TextFeildTongChiTieu.setBorder(null);
        TextFeildTongChiTieu.setMaximumSize(new java.awt.Dimension(160, 28));
        TextFeildTongChiTieu.setMinimumSize(new java.awt.Dimension(160, 28));
        TextFeildTongChiTieu.setPreferredSize(new java.awt.Dimension(160, 28));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setMaximumSize(new java.awt.Dimension(93, 5));
        jSeparator1.setMinimumSize(new java.awt.Dimension(93, 5));
        jSeparator1.setPreferredSize(new java.awt.Dimension(93, 5));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setMaximumSize(new java.awt.Dimension(93, 5));
        jSeparator2.setMinimumSize(new java.awt.Dimension(93, 5));
        jSeparator2.setPreferredSize(new java.awt.Dimension(93, 5));

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator3.setMaximumSize(new java.awt.Dimension(93, 5));
        jSeparator3.setMinimumSize(new java.awt.Dimension(93, 5));
        jSeparator3.setPreferredSize(new java.awt.Dimension(93, 5));

        jSeparator5.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator5.setMaximumSize(new java.awt.Dimension(93, 5));
        jSeparator5.setMinimumSize(new java.awt.Dimension(93, 5));
        jSeparator5.setPreferredSize(new java.awt.Dimension(93, 5));

        jDNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        jDNgaySinh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jDNgaySinh.setDateFormatString("dd-MM-yyyy");
        JTextField dateEditor = ((JTextField) jDNgaySinh.getDateEditor().getUiComponent());
        dateEditor.setBackground(new java.awt.Color(211, 211, 211)); // Nền trắng
        dateEditor.setForeground(new java.awt.Color(0, 0, 0)); // Chữ đen
        dateEditor.setEditable(false);
        dateEditor.setFocusable(false);
        jDNgaySinh.setBackground(new java.awt.Color(211, 211, 211));

        javax.swing.GroupLayout PanelThuocTinhLayout = new javax.swing.GroupLayout(PanelThuocTinh);
        PanelThuocTinh.setLayout(PanelThuocTinhLayout);
        PanelThuocTinhLayout.setHorizontalGroup(
            PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelThuocTinhLayout.createSequentialGroup()
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelThuocTinhLayout.createSequentialGroup()
                        .addComponent(LblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelThuocTinhLayout.createSequentialGroup()
                        .addComponent(LblTongChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFeildTongChiTieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelThuocTinhLayout.createSequentialGroup()
                        .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextFieldMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelThuocTinhLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelThuocTinhLayout.createSequentialGroup()
                        .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextFieldSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBoxGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        PanelThuocTinhLayout.setVerticalGroup(
            PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblMa)
                    .addComponent(TextFieldMa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(LblSDT))
                    .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblGioiTinh))
                .addGap(14, 14, 14)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblNgaySinh)
                    .addComponent(jDNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LblTongChiTieu))
                    .addComponent(TextFeildTongChiTieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelNoiDungThongTinLayout = new javax.swing.GroupLayout(PanelNoiDungThongTin);
        PanelNoiDungThongTin.setLayout(PanelNoiDungThongTinLayout);
        PanelNoiDungThongTinLayout.setHorizontalGroup(
            PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LabelTieuDe)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNoiDungThongTinLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
        );
        PanelNoiDungThongTinLayout.setVerticalGroup(
            PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(LabelTieuDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelThongTinLayout = new javax.swing.GroupLayout(PanelThongTin);
        PanelThongTin.setLayout(PanelThongTinLayout);
        PanelThongTinLayout.setHorizontalGroup(
            PanelThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThongTinLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(PanelNoiDungThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        PanelThongTinLayout.setVerticalGroup(
            PanelThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThongTinLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(PanelNoiDungThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelNoiDungThongTin.getAccessibleContext().setAccessibleName("");

        PanelChuaNut.setBackground(new java.awt.Color(255, 255, 255));

        btn_Sua.setBackground(new java.awt.Color(0, 0, 0));
        btn_Sua.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sua.setText("Sửa");
        btn_Sua.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_Sua.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_Sua.setPreferredSize(new java.awt.Dimension(100, 26));

        btn_Them.setBackground(new java.awt.Color(0, 0, 0));
        btn_Them.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setText("Thêm");
        btn_Them.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_Them.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_Them.setPreferredSize(new java.awt.Dimension(100, 26));
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelChuaNutLayout = new javax.swing.GroupLayout(PanelChuaNut);
        PanelChuaNut.setLayout(PanelChuaNutLayout);
        PanelChuaNutLayout.setHorizontalGroup(
            PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChuaNutLayout.createSequentialGroup()
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelChuaNutLayout.setVerticalGroup(
            PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChuaNutLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelInputLayout = new javax.swing.GroupLayout(PanelInput);
        PanelInput.setLayout(PanelInputLayout);
        PanelInputLayout.setHorizontalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelChuaNut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelInputLayout.setVerticalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelChuaNut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        ScrollPane.setMaximumSize(new java.awt.Dimension(800, 440));
        ScrollPane.setMinimumSize(new java.awt.Dimension(800, 440));
        ScrollPane.setPreferredSize(new java.awt.Dimension(800, 440));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Số Điện Thoại", "Giới Tính", "Ngày Sinh", "Trạng Thái"
            }
        ));
        Table.setRowHeight(50);
        ScrollPane.setViewportView(Table);

        LabelTenBang.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        LabelTenBang.setText("Khách Hàng");

        BtnTimKiem.setBackground(new java.awt.Color(0, 0, 0));
        BtnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        BtnTimKiem.setText("Tìm Kiếm");
        BtnTimKiem.setMaximumSize(new java.awt.Dimension(100, 24));
        BtnTimKiem.setMinimumSize(new java.awt.Dimension(100, 24));
        BtnTimKiem.setPreferredSize(new java.awt.Dimension(100, 24));

        btnTaiLai.setBackground(new java.awt.Color(0, 0, 0));
        btnTaiLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaiLai.setForeground(new java.awt.Color(255, 255, 255));
        btnTaiLai.setText("Tải Lại");
        btnTaiLai.setMaximumSize(new java.awt.Dimension(100, 24));
        btnTaiLai.setMinimumSize(new java.awt.Dimension(100, 24));
        btnTaiLai.setPreferredSize(new java.awt.Dimension(100, 24));

        PanelTimKiem.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem.setMaximumSize(new java.awt.Dimension(306, 32));
        PanelTimKiem.setMinimumSize(new java.awt.Dimension(306, 32));

        TextFieldTimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TextFieldTimKiem.setMaximumSize(new java.awt.Dimension(64, 18));

        LabelAnhTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search.png"))); // NOI18N

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelAnhTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelAnhTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        cmbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm theo mã", "Tìm theo tên" }));

        btn_XuatExcel.setBackground(new java.awt.Color(0, 0, 0));
        btn_XuatExcel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_XuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_XuatExcel.setText("Xuất Excel");
        btn_XuatExcel.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_XuatExcel.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_XuatExcel.setPreferredSize(new java.awt.Dimension(100, 26));

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(BtnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addContainerGap(483, Short.MAX_VALUE)
                .addComponent(LabelTenBang)
                .addGap(482, 482, 482))
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(LabelTenBang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PanelTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTimKiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
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
            .addComponent(PanelTong, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldTenActionPerformed

    private void TextFieldMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldMaActionPerformed

    private void TextFieldSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldSDTActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ThemActionPerformed


    public void nhomNutChucNang() {

        Table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                xuLyClickTblKhachHang();
            }
        });
        
        btnTaiLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refresh();
            }
        });
        
        btn_Them.addActionListener(e -> {
                if(validateFields())
                    xuLyThemKhachHang();
        });

        btn_Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(validateFieldsSua())
                    suaThongTinKhacHang();
            }
        });

        BtnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(cmbTimKiem.getSelectedItem().equals("Tìm theo mã"))
                    xuLyTimKiemKhachHangTheoma();
                else
                    xuLyTimKiemKhachHangTheoTen();
            }
        });

        BtnTimKiem.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "pressEnter");
        BtnTimKiem.getActionMap().put("pressEnter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cmbTimKiem.getSelectedItem().equals("Tìm theo mã"))
                    xuLyTimKiemKhachHangTheoma();
                else
                    xuLyTimKiemKhachHangTheoTen();
            }
        });

        btn_XuatExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                xuLyXuatExcel();
            }
        });
    }

    public boolean validateFields() {
        //Kiểm tra trường tên
        String ten = TextFieldTen.getText().trim();
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (ten.length() > 50) {
            JOptionPane.showMessageDialog(null, "Độ dài tên không quá 50 ký tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if ((ten.matches(".*[!@#$%^&*()_+=\\[\\]{};':\"\\\\|,.<>/?`~].*")||ten.matches(".*\\d.*"))) {
            new dialog( "Tên không được chứa số hoặc ký tự đặc biệt!", dialog.ERROR_DIALOG);
            return false;
        }
    
        // Kiểm tra TextFieldSDT
        String sdt = TextFieldSDT.getText().trim();
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!sdt.matches("^0\\d{9}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải bắt đầu bằng số 0 và chứa đúng 10 chữ số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(!KHBUS.checkSDT(sdt)){
            JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (ComboBoxGioiTinh.getSelectedIndex() == 0) {
            new dialog("Bạn chưa chọn giới tính!", dialog.ERROR_DIALOG);
            return false;
        }
    
        return true;
    }
    
    public boolean validateFieldsSua() {
        //Kiểm tra trường tên
        String ten = TextFieldTen.getText().trim();

        if(TextFieldMa.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn khách hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (ten.length() > 50) {
            JOptionPane.showMessageDialog(null, "Độ dài tên không quá 50 ký tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if ((ten.matches(".*[!@#$%^&*()_+=\\[\\]{};':\"\\\\|,.<>/?`~].*")||ten.matches(".*\\d.*"))) {
            new dialog( "Tên không được chứa số hoặc ký tự đặc biệt!", dialog.ERROR_DIALOG);
            return false;
        }
    
        // Kiểm tra TextFieldSDT
        String sdt = TextFieldSDT.getText().trim();
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!sdt.matches("^0\\d{9}$")) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải bắt đầu bằng số 0 và chứa đúng 10 chữ số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (ComboBoxGioiTinh.getSelectedIndex() == 0) {
            new dialog("Bạn chưa chọn giới tính!", dialog.ERROR_DIALOG);
            return false;
        }
    
        return true;
    }

    private void xuLyXuatExcel() {
        XuLyFileExcel xuatExcel = new XuLyFileExcel();
        xuatExcel.xuatExcel(Table);
    }

    private void xuLyTimKiemKhachHangTheoTen() {
        KHBUS.timKhachHangTheoTen(TextFieldTimKiem.getText(),Table);
    }

    private void xuLyTimKiemKhachHangTheoma() {
        KHBUS.timKhachHangTheoMa(TextFieldTimKiem.getText(),Table);
    }

    private void suaThongTinKhacHang(){
        
        String ten = TextFieldTen.getText();
        String gioiTinh = ComboBoxGioiTinh.getSelectedItem() + "";
        String sdt = TextFieldSDT.getText();

        java.sql.Date ngaysinh = null; 
        java.util.Date utilDate = jDNgaySinh.getDate(); 
        if (utilDate != null) {
            ngaysinh = new java.sql.Date(utilDate.getTime()); 
        } else {
        }
        int tongCT;
        if(TextFeildTongChiTieu.getText().equals(""))
            tongCT=0;
        else
            tongCT = parseCurrency(TextFeildTongChiTieu.getText());;
        if (KHBUS.capNhatThongTinKhachHang(TextFieldMa.getText(), ten, sdt, gioiTinh,ngaysinh,tongCT)) {
            refresh();
            KHBUS.docDanhSach();
            loadData();
        }
    }

    private void xuLyThemKhachHang() {
        if (ComboBoxGioiTinh.getSelectedIndex() == 0) {
            new dialog("Bạn chưa chọn giới tính!", dialog.ERROR_DIALOG);
            return;
        }
    
        String ten = TextFieldTen.getText();
        String gioiTinh = ComboBoxGioiTinh.getSelectedItem() + "";
        String dienthoai = TextFieldSDT.getText();

        java.sql.Date ngaysinh = null;
        java.util.Date utilDate = jDNgaySinh.getDate(); 
    
        if (utilDate != null) {
            ngaysinh = new java.sql.Date(utilDate.getTime()); 
        } else {
        }
    
        boolean check = KHBUS.themKhachHang(ten,ngaysinh, gioiTinh, dienthoai, 0);
        if(check) {
            refresh();
            KHBUS.docDanhSach();
            loadData();
        }
        
    }

    private void refresh(){
        btn_Them.setEnabled(true);
        TextFeildTongChiTieu.setText("");
        TextFieldMa.setText("");
        TextFieldTen.setText("");
        TextFieldSDT.setText("");
        ComboBoxGioiTinh.setSelectedIndex(0);
        jDNgaySinh.setDate(null);
        loadData();
    }

    private void xuLyClickTblKhachHang() {
        int row = Table.getSelectedRow();
        btn_Them.setEnabled(false);
        if (row > -1) {
            TextFieldMa.setText(Table.getValueAt(row, 0) + "");
            TextFieldTen.setText(Table.getValueAt(row, 1) + "");
            TextFieldSDT.setText(Table.getValueAt(row, 3) + "");
            TextFeildTongChiTieu.setText(Table.getValueAt(row, 5) + "");
        
            Object ngaySinhObj = Table.getValueAt(row, 4);
            if (ngaySinhObj instanceof Date) {
                // Nếu là java.sql.Date, gán trực tiếp
                jDNgaySinh.setDate((java.sql.Date) ngaySinhObj);
            }
            jDNgaySinh.setDateFormatString("dd-MM-yyyy");
    
            if ((Table.getValueAt(row, 2) + "").equals("Nam")) {
                ComboBoxGioiTinh.setSelectedIndex(1);
            } else if((Table.getValueAt(row, 2) + "").equals("Nữ")) {
                ComboBoxGioiTinh.setSelectedIndex(2);
            } else {
                ComboBoxGioiTinh.setSelectedIndex(0);
            }
        }
    }

    public int parseCurrency(String currencyStr) {
        String cleanedStr = currencyStr.replace(",", "").replace(".", "").replace("VNĐ", "").trim();
        return Integer.parseInt(cleanedStr);
    }
    

    public String formatCurrency(String amountStr) {
        try {
            double amount = Double.parseDouble(amountStr);
            DecimalFormat formatter = new DecimalFormat("#,###");
            String formatted = formatter.format(amount);
            return formatted + "VNĐ";
        } catch (NumberFormatException e) {
            return "Số không hợp lệ";
        }
    }

    public void loadData(){
        KHBUS.loadDataTblNhanVien(Table);
    }
    
    KhachHangBUS KHBUS = new KhachHangBUS();
    
    // Khai Báo Biến
    // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTimKiem;
    private javax.swing.JComboBox<String> ComboBoxGioiTinh;
    private javax.swing.JLabel LabelAnhTimKiem;
    private javax.swing.JLabel LabelTenBang;
    private javax.swing.JLabel LabelTieuDe;
    private javax.swing.JLabel LblGioiTinh;
    private javax.swing.JLabel LblMa;
    private javax.swing.JLabel LblNgaySinh;
    private javax.swing.JLabel LblSDT;
    private javax.swing.JLabel LblTen;
    private javax.swing.JLabel LblTongChiTieu;
    private javax.swing.JPanel PanelChuaNut;
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel PanelNoiDungThongTin;
    private javax.swing.JPanel PanelThongTin;
    private javax.swing.JPanel PanelThuocTinh;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TextFeildTongChiTieu;
    private javax.swing.JTextField TextFieldMa;
    private javax.swing.JTextField TextFieldSDT;
    private javax.swing.JTextField TextFieldTen;
    private javax.swing.JTextField TextFieldTimKiem;
    private javax.swing.JButton btnTaiLai;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_XuatExcel;
    private javax.swing.JComboBox<String> cmbTimKiem;
    private com.toedter.calendar.JDateChooser jDNgaySinh;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
    // Kết Thúc Khai Báo Biến

}

