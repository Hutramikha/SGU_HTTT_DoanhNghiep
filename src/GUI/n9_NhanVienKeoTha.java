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
import java.awt.Component;
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
// import TaiKhoanBUS

/**
 *
 * @author phuoc
 */
public class n9_NhanVienKeoTha extends javax.swing.JPanel {

    public n9_NhanVienKeoTha() {
        initComponents();
        loadDataCmbQuyen();
        loadDataTblNhanVien();
        nhomNutChucNang();
        TableCustom.apply(ScrTable, TableCustom.TableType.MULTI_LINE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTong = new javax.swing.JPanel();
        JScrNhanVien = new javax.swing.JScrollPane();
        PanelNhanVien = new javax.swing.JPanel();
        BtnQLNhanVien = new javax.swing.JPanel();
        LbNhanVien = new javax.swing.JLabel();
        BtnQLPhanQuyen = new javax.swing.JPanel();
        LbPhanQuyen = new javax.swing.JLabel();
        PanelChuaNut = new javax.swing.JPanel();
        BtnThongTinTK = new javax.swing.JPanel();
        LblThongTinTK = new javax.swing.JLabel();
        BtnThem = new javax.swing.JPanel();
        LblThem = new javax.swing.JLabel();
        BtnSua = new javax.swing.JPanel();
        LblSua = new javax.swing.JLabel();
        BtnKhoaTK = new javax.swing.JPanel();
        LblKhoaTK = new javax.swing.JLabel();
        BtnXuat = new javax.swing.JPanel();
        LblXuat = new javax.swing.JLabel();
        PanelInput = new javax.swing.JPanel();
        LblTieuDe = new javax.swing.JLabel();
        BtnRefresh = new javax.swing.JPanel();
        LblRefresh = new javax.swing.JLabel();
        PanelTruongThongTin = new javax.swing.JPanel();
        LbeMa = new javax.swing.JLabel();
        LblTen = new javax.swing.JLabel();
        LbeGioiTinh = new javax.swing.JLabel();
        LbeSDT = new javax.swing.JLabel();
        LbeNgaySinh = new javax.swing.JLabel();
        LbeDiaChi = new javax.swing.JLabel();
        LbeChucVu = new javax.swing.JLabel();
        LbeLuong = new javax.swing.JLabel();
        LbeTimKiem = new javax.swing.JLabel();
        PanelChuaTextField = new javax.swing.JPanel();
        PanelTimKiem = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        BoxGioiTinh = new javax.swing.JComboBox<>();
        BoxChucVu = new javax.swing.JComboBox<>();
        Line1 = new javax.swing.JSeparator();
        Line2 = new javax.swing.JSeparator();
        Line3 = new javax.swing.JSeparator();
        Line5 = new javax.swing.JSeparator();
        Line6 = new javax.swing.JSeparator();
        cmbTimKiemNV = new javax.swing.JComboBox<>();
        JDNgaySinh = new com.toedter.calendar.JDateChooser();
        BtnThemTaiKhoan = new javax.swing.JPanel();
        LblThemTK = new javax.swing.JLabel();
        ScrTable = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1125, 667));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setPreferredSize(new java.awt.Dimension(1125, 658));

        JScrNhanVien.setBorder(null);
        JScrNhanVien.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JScrNhanVien.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JScrNhanVien.setMaximumSize(new java.awt.Dimension(1113, 646));
        JScrNhanVien.setMinimumSize(new java.awt.Dimension(1113, 646));
        JScrNhanVien.setPreferredSize(new java.awt.Dimension(1113, 646));

        PanelNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        PanelNhanVien.setMaximumSize(new java.awt.Dimension(1114, 1100));
        PanelNhanVien.setMinimumSize(new java.awt.Dimension(1114, 1100));

        BtnQLNhanVien.setBackground(new java.awt.Color(219, 189, 142));
        BtnQLNhanVien.setMaximumSize(new java.awt.Dimension(195, 44));
        BtnQLNhanVien.setMinimumSize(new java.awt.Dimension(195, 44));

        LbNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LbNhanVien.setText("Nhân viên");

        javax.swing.GroupLayout BtnQLNhanVienLayout = new javax.swing.GroupLayout(BtnQLNhanVien);
        BtnQLNhanVien.setLayout(BtnQLNhanVienLayout);
        BtnQLNhanVienLayout.setHorizontalGroup(
            BtnQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnQLNhanVienLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(LbNhanVien)
                .addGap(56, 56, 56))
        );
        BtnQLNhanVienLayout.setVerticalGroup(
            BtnQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        BtnQLPhanQuyen.setBackground(new java.awt.Color(219, 189, 142));
        BtnQLPhanQuyen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        BtnQLPhanQuyen.setMaximumSize(new java.awt.Dimension(195, 44));
        BtnQLPhanQuyen.setMinimumSize(new java.awt.Dimension(195, 44));

        LbPhanQuyen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LbPhanQuyen.setText("Phân quyền");

        javax.swing.GroupLayout BtnQLPhanQuyenLayout = new javax.swing.GroupLayout(BtnQLPhanQuyen);
        BtnQLPhanQuyen.setLayout(BtnQLPhanQuyenLayout);
        BtnQLPhanQuyenLayout.setHorizontalGroup(
            BtnQLPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnQLPhanQuyenLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(LbPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        BtnQLPhanQuyenLayout.setVerticalGroup(
            BtnQLPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbPhanQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        PanelChuaNut.setBackground(new java.awt.Color(255, 255, 255));

        BtnThongTinTK.setBackground(new java.awt.Color(0, 0, 0));
        BtnThongTinTK.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnThongTinTK.setPreferredSize(new java.awt.Dimension(130, 35));

        LblThongTinTK.setBackground(new java.awt.Color(255, 255, 255));
        LblThongTinTK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LblThongTinTK.setForeground(new java.awt.Color(255, 255, 255));
        LblThongTinTK.setText("Thông tin TK");
        BtnThongTinTK.add(LblThongTinTK);

        BtnThem.setBackground(new java.awt.Color(0, 0, 0));
        BtnThem.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnThem.setPreferredSize(new java.awt.Dimension(100, 35));

        LblThem.setBackground(new java.awt.Color(255, 255, 255));
        LblThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LblThem.setForeground(new java.awt.Color(255, 255, 255));
        LblThem.setText("Thêm");
        BtnThem.add(LblThem);

        BtnSua.setBackground(new java.awt.Color(0, 0, 0));
        BtnSua.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnSua.setPreferredSize(new java.awt.Dimension(100, 35));

        LblSua.setBackground(new java.awt.Color(255, 255, 255));
        LblSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LblSua.setForeground(new java.awt.Color(255, 255, 255));
        LblSua.setText("Sửa");
        BtnSua.add(LblSua);

        BtnKhoaTK.setBackground(new java.awt.Color(0, 0, 0));
        BtnKhoaTK.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnKhoaTK.setPreferredSize(new java.awt.Dimension(100, 35));

        LblKhoaTK.setBackground(new java.awt.Color(255, 255, 255));
        LblKhoaTK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LblKhoaTK.setForeground(new java.awt.Color(255, 255, 255));
        LblKhoaTK.setText("Khóa/Mở TK");
        BtnKhoaTK.add(LblKhoaTK);

        BtnXuat.setBackground(new java.awt.Color(0, 0, 0));
        BtnXuat.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnXuat.setPreferredSize(new java.awt.Dimension(100, 35));

        LblXuat.setBackground(new java.awt.Color(255, 255, 255));
        LblXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LblXuat.setForeground(new java.awt.Color(255, 255, 255));
        LblXuat.setText("Xuất");
        BtnXuat.add(LblXuat);

        javax.swing.GroupLayout PanelChuaNutLayout = new javax.swing.GroupLayout(PanelChuaNut);
        PanelChuaNut.setLayout(PanelChuaNutLayout);
        PanelChuaNutLayout.setHorizontalGroup(
            PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChuaNutLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnThongTinTK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelChuaNutLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(BtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(BtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(BtnKhoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(BtnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        PanelChuaNutLayout.setVerticalGroup(
            PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChuaNutLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnKhoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnThongTinTK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        PanelInput.setBackground(new java.awt.Color(255, 255, 255));

        LblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        LblTieuDe.setText("Quản Lí Nhân Viên ");

        BtnRefresh.setBackground(new java.awt.Color(0, 0, 0));
        BtnRefresh.setMaximumSize(new java.awt.Dimension(34, 34));
        BtnRefresh.setMinimumSize(new java.awt.Dimension(34, 34));
        BtnRefresh.setPreferredSize(new java.awt.Dimension(34, 34));

        LblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/reload.png"))); // NOI18N
        BtnRefresh.add(LblRefresh);

        PanelTruongThongTin.setBackground(new java.awt.Color(255, 255, 255));

        LbeMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbeMa.setText("Mã NV");

        LblTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LblTen.setText("Tên NV");

        LbeGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbeGioiTinh.setText("Giới tính");

        LbeSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbeSDT.setText("Số điện thoại");

        LbeNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbeNgaySinh.setText("Ngày sinh");

        LbeDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbeDiaChi.setText("Địa chỉ");

        LbeChucVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbeChucVu.setText("Chức vụ");

        LbeLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbeLuong.setText("Lương");

        LbeTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LbeTimKiem.setText("Tìm Kiếm");

        javax.swing.GroupLayout PanelTruongThongTinLayout = new javax.swing.GroupLayout(PanelTruongThongTin);
        PanelTruongThongTin.setLayout(PanelTruongThongTinLayout);
        PanelTruongThongTinLayout.setHorizontalGroup(
            PanelTruongThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbeMa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LbeGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LbeSDT)
            .addComponent(LbeNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LbeDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LbeChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LbeLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LbeTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        PanelTruongThongTinLayout.setVerticalGroup(
            PanelTruongThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTruongThongTinLayout.createSequentialGroup()
                .addComponent(LbeMa)
                .addGap(25, 25, 25)
                .addComponent(LblTen)
                .addGap(25, 25, 25)
                .addComponent(LbeGioiTinh)
                .addGap(25, 25, 25)
                .addComponent(LbeSDT)
                .addGap(25, 25, 25)
                .addComponent(LbeNgaySinh)
                .addGap(25, 25, 25)
                .addComponent(LbeDiaChi)
                .addGap(25, 25, 25)
                .addComponent(LbeChucVu)
                .addGap(25, 25, 25)
                .addComponent(LbeLuong)
                .addGap(25, 25, 25)
                .addComponent(LbeTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelChuaTextField.setBackground(new java.awt.Color(255, 255, 255));

        PanelTimKiem.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem.setMaximumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setMinimumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setPreferredSize(new java.awt.Dimension(314, 32));

        txtTimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search.png"))); // NOI18N

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem))
                .addContainerGap())
        );

        txtMa.setEditable(false);
        txtMa.setBackground(new java.awt.Color(255, 255, 255));
        txtMa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMa.setMaximumSize(new java.awt.Dimension(359, 20));
        txtMa.setMinimumSize(new java.awt.Dimension(359, 20));
        txtMa.setPreferredSize(new java.awt.Dimension(359, 20));
        txtMa.setEnabled(false);

        txtTen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtTen.setMaximumSize(new java.awt.Dimension(359, 20));
        txtTen.setMinimumSize(new java.awt.Dimension(359, 20));
        txtTen.setPreferredSize(new java.awt.Dimension(359, 20));

        txtSDT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtSDT.setMaximumSize(new java.awt.Dimension(359, 20));
        txtSDT.setMinimumSize(new java.awt.Dimension(359, 20));
        txtSDT.setPreferredSize(new java.awt.Dimension(359, 20));

        txtDiaChi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtDiaChi.setMaximumSize(new java.awt.Dimension(359, 20));
        txtDiaChi.setMinimumSize(new java.awt.Dimension(359, 20));
        txtDiaChi.setPreferredSize(new java.awt.Dimension(359, 20));

        txtLuong.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtLuong.setMaximumSize(new java.awt.Dimension(359, 20));
        txtLuong.setMinimumSize(new java.awt.Dimension(359, 20));
        txtLuong.setPreferredSize(new java.awt.Dimension(359, 20));

        BoxGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn giới tính", "Nam", "Nữ" }));
        BoxGioiTinh.setMaximumSize(new java.awt.Dimension(90, 20));
        BoxGioiTinh.setMinimumSize(new java.awt.Dimension(90, 20));
        BoxGioiTinh.setPreferredSize(new java.awt.Dimension(90, 20));

        BoxChucVu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BoxChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));
        BoxChucVu.setMaximumSize(new java.awt.Dimension(90, 20));
        BoxChucVu.setMinimumSize(new java.awt.Dimension(90, 20));
        BoxChucVu.setPreferredSize(new java.awt.Dimension(90, 20));

        Line1.setForeground(new java.awt.Color(0, 0, 0));
        Line1.setMaximumSize(new java.awt.Dimension(359, 5));
        Line1.setMinimumSize(new java.awt.Dimension(359, 5));
        Line1.setPreferredSize(new java.awt.Dimension(359, 5));

        Line2.setForeground(new java.awt.Color(0, 0, 0));
        Line2.setMaximumSize(new java.awt.Dimension(359, 5));
        Line2.setMinimumSize(new java.awt.Dimension(359, 5));
        Line2.setPreferredSize(new java.awt.Dimension(359, 5));

        Line3.setForeground(new java.awt.Color(0, 0, 0));
        Line3.setMaximumSize(new java.awt.Dimension(359, 5));
        Line3.setMinimumSize(new java.awt.Dimension(359, 5));
        Line3.setPreferredSize(new java.awt.Dimension(359, 5));

        Line5.setForeground(new java.awt.Color(0, 0, 0));
        Line5.setMaximumSize(new java.awt.Dimension(359, 5));
        Line5.setMinimumSize(new java.awt.Dimension(359, 5));
        Line5.setPreferredSize(new java.awt.Dimension(359, 5));

        Line6.setForeground(new java.awt.Color(0, 0, 0));
        Line6.setMaximumSize(new java.awt.Dimension(359, 5));
        Line6.setMinimumSize(new java.awt.Dimension(359, 5));
        Line6.setPreferredSize(new java.awt.Dimension(359, 5));

        cmbTimKiemNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm theo Mã NV", "Tìm theo Tên NV" }));
        cmbTimKiemNV.setMinimumSize(new java.awt.Dimension(72, 32));
        cmbTimKiemNV.setPreferredSize(new java.awt.Dimension(72, 32));

        JDNgaySinh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        JDNgaySinh.setDateFormatString("dd-MM-yyyy");
        JTextField dateEditor = ((JTextField) JDNgaySinh.getDateEditor().getUiComponent());
        dateEditor.setBackground(new java.awt.Color(211, 211, 211)); // Nền trắng
        dateEditor.setForeground(new java.awt.Color(0, 0, 0)); // Chữ đen
        dateEditor.setEditable(false);
        dateEditor.setFocusable(false);
        JDNgaySinh.setBackground(new java.awt.Color(211, 211, 211));

        javax.swing.GroupLayout PanelChuaTextFieldLayout = new javax.swing.GroupLayout(PanelChuaTextField);
        PanelChuaTextField.setLayout(PanelChuaTextFieldLayout);
        PanelChuaTextFieldLayout.setHorizontalGroup(
            PanelChuaTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChuaTextFieldLayout.createSequentialGroup()
                .addGroup(PanelChuaTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelChuaTextFieldLayout.createSequentialGroup()
                        .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTimKiemNV, 0, 128, Short.MAX_VALUE))
                    .addGroup(PanelChuaTextFieldLayout.createSequentialGroup()
                        .addGroup(PanelChuaTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Line1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Line2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Line3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Line5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Line6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BoxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        PanelChuaTextFieldLayout.setVerticalGroup(
            PanelChuaTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChuaTextFieldLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(Line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(Line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(BoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(Line3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(Line5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(BoxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(txtLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(Line6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(PanelChuaTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        BtnThemTaiKhoan.setBackground(new java.awt.Color(219, 189, 142));
        BtnThemTaiKhoan.setForeground(new java.awt.Color(51, 51, 51));
        BtnThemTaiKhoan.setPreferredSize(new java.awt.Dimension(130, 35));

        LblThemTK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LblThemTK.setText("Thêm tài khoản");

        javax.swing.GroupLayout BtnThemTaiKhoanLayout = new javax.swing.GroupLayout(BtnThemTaiKhoan);
        BtnThemTaiKhoan.setLayout(BtnThemTaiKhoanLayout);
        BtnThemTaiKhoanLayout.setHorizontalGroup(
            BtnThemTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnThemTaiKhoanLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LblThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        BtnThemTaiKhoanLayout.setVerticalGroup(
            BtnThemTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblThemTK, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelInputLayout = new javax.swing.GroupLayout(PanelInput);
        PanelInput.setLayout(PanelInputLayout);
        PanelInputLayout.setHorizontalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addGap(466, 466, 466)
                .addComponent(LblTieuDe)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addComponent(PanelTruongThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(PanelChuaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnThemTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(189, 189, 189))
        );
        PanelInputLayout.setVerticalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(LblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTruongThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelChuaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(BtnThemTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Table.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "Giới tính", "Số điện thoại", "Ngày sinh", "Địa chỉ", "Chức vụ", "Lương", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrTable.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(0).setPreferredWidth(40);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(2).setResizable(false);
            Table.getColumnModel().getColumn(3).setResizable(false);
            Table.getColumnModel().getColumn(3).setPreferredWidth(70);
            Table.getColumnModel().getColumn(4).setResizable(false);
            Table.getColumnModel().getColumn(5).setResizable(false);
            Table.getColumnModel().getColumn(6).setResizable(false);
            Table.getColumnModel().getColumn(6).setPreferredWidth(30);
            Table.getColumnModel().getColumn(7).setResizable(false);
            Table.getColumnModel().getColumn(8).setResizable(false);
            Table.getColumnModel().getColumn(8).setPreferredWidth(30);
        }

        javax.swing.GroupLayout PanelNhanVienLayout = new javax.swing.GroupLayout(PanelNhanVien);
        PanelNhanVien.setLayout(PanelNhanVienLayout);
        PanelNhanVienLayout.setHorizontalGroup(
            PanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelNhanVienLayout.createSequentialGroup()
                .addGroup(PanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNhanVienLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(BtnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(BtnQLPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNhanVienLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(PanelChuaNut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNhanVienLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(ScrTable, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        PanelNhanVienLayout.setVerticalGroup(
            PanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNhanVienLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnQLPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelChuaNut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrTable, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        JScrNhanVien.setViewportView(PanelNhanVien);

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JScrNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JScrNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    public void nhomNutChucNang() {
        BtnQLNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnQLNhanVien.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnQLNhanVien.setBackground(new Color(219, 189, 142));
            }
        });
        BtnQLPhanQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnQLPhanQuyen.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnQLPhanQuyen.setBackground(new Color(219, 189, 142));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelTong.removeAll();
                n9_PhanQuyenGUI lich = new n9_PhanQuyenGUI();
                PanelTong.setLayout(new BorderLayout());
                PanelTong.add(lich, BorderLayout.CENTER); // Adjust the layout constraint as needed
                PanelTong.revalidate();
                PanelTong.repaint();
            }
        });

        btnTimKiem.addMouseListener((new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (cmbTimKiemNV.getSelectedItem().equals("Tìm theo Mã NV")) {
                    xuLyTimKiemNhanVienTheoma();
                } else {
                    xuLyTimKiemNhanVienTheoTen();
                }
            }
        }));

        btnTimKiem.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "pressEnter");
        btnTimKiem.getActionMap().put("pressEnter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbTimKiemNV.getSelectedItem().equals("Tìm theo Mã NV")) {
                    xuLyTimKiemNhanVienTheoma();
                } else {
                    xuLyTimKiemNhanVienTheoTen();
                }
            }
        });

        BtnThongTinTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnThongTinTK.setBackground(new Color(106, 105, 105));
                LblThongTinTK.setOpaque(true);
                LblThongTinTK.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnThongTinTK.setBackground(new Color(0, 0, 0));
                LblThongTinTK.setOpaque(true);
                LblThongTinTK.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(MouseEvent e) {
                ThongTinTK();
            }
        });
        BtnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnThem.setBackground(new Color(106, 105, 105));
                LblThem.setOpaque(true);
                LblThem.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnThem.setBackground(new Color(0, 0, 0));
                LblThem.setOpaque(true);
                LblThem.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(MouseEvent e) {
                if (validateFields()) {
                    xuLyThemNhanVien();
                    refresh();
                    loadDataTblNhanVien();
                }
            }
        });

        BtnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnSua.setBackground(new Color(106, 105, 105));
                LblSua.setOpaque(true);
                LblSua.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnSua.setBackground(new Color(0, 0, 0));
                LblSua.setOpaque(true);
                LblSua.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(MouseEvent e) {
                if (validateFieldsSua()) {
                    xuLySuaNhanVien();
                    refresh();
                    loadDataTblNhanVien();
                }
            }
        });

        BtnXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnXuat.setBackground(new Color(106, 105, 105));
                LblXuat.setOpaque(true);
                LblXuat.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnXuat.setBackground(new Color(0, 0, 0));
                LblXuat.setOpaque(true);
                LblXuat.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(MouseEvent e) {
                xuLyXuatExcel();
            }

        });

        BtnKhoaTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnKhoaTK.setBackground(new Color(106, 105, 105));
                LblKhoaTK.setOpaque(true);
                LblKhoaTK.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnKhoaTK.setBackground(new Color(0, 0, 0));
                LblKhoaTK.setOpaque(true);
                LblKhoaTK.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(MouseEvent e) {
                xuLyKhoaTaiKhoan();
                loadDataTblNhanVien();
            }
        });

        BtnThemTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnThemTaiKhoan.setBackground(new Color(199, 159, 95));
                LblThemTK.setOpaque(true);
                LblThemTK.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnThemTaiKhoan.setBackground(new Color(219, 189, 142));
                LblThemTK.setOpaque(true);
                LblThemTK.setBackground(new Color(219, 189, 142));
            }

            public void mouseClicked(MouseEvent e) {
                xuLyCapTaiKhoan();
                loadDataTblNhanVien();
            }
        });

        BtnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnRefresh.setBackground(new Color(106, 105, 105));
                LblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/reload_hover.png")));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnRefresh.setBackground(new Color(0, 0, 0));
                LblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/reload.png")));
            }

            public void mouseClicked(MouseEvent e) {
                refresh();
            }
        });

        Table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                xuLyClickTblNhanVien();
            }
        });
    }

    public boolean validateFields() {
        // Biểu thức chính quy để kiểm tra không chứa ký tự đặc biệt (chỉ chứa ký tự và số)
        String regexNoSpecialChars = "^[0-9]{1,3}(?:[,.]\\d{3})*VNĐ$";
        String regexNoSpecialChars2 = "^[a-zA-Z0-9]*$";  // Không chứa ký tự đặc biệt
        // Kiểm tra txtTen (Tên người dùng)
        if (txtTen.getText().equals("")) {
            new dialog("Tên không được để trống!", dialog.ERROR_DIALOG);
            return false;
        } else if (txtTen.getText().length() > 50) {
            new dialog("Tên không được quá 50 ký tự!", dialog.ERROR_DIALOG);
            return false;
        } else if ((txtTen.getText().matches(".*[!@#$%^&*()_+=\\[\\]{};':\"\\\\|,.<>/?`~].*") || txtTen.getText().matches(".*\\d.*"))) {
            new dialog("Tên không được chứa số hoặc ký tự đặc biệt!", dialog.ERROR_DIALOG);
            return false;
        }

        if (BoxGioiTinh.getSelectedItem().toString().equals("Chọn giới tính")) {
            new dialog("Bạn phải chọn giới tính!", dialog.ERROR_DIALOG);
            return false;
        } // Kiểm tra txtSDT (Số điện thoại)
        else if (txtSDT.getText().equals("")) {
            new dialog("Số điện thoại không được để trống!", dialog.ERROR_DIALOG);
            return false;
        } else if (!txtSDT.getText().matches("0\\d{9}")) { // Số điện thoại phải có 10 chữ số, bắt đầu với số 0
            new dialog("Số điện thoại phải bắt đầu bằng số 0 và có 10 số !", dialog.ERROR_DIALOG);
            return false;
        } else if (txtSDT.getText().contains(" ")) { // Không có khoảng trắng giữa các số
            new dialog("Số điện thoại không được chứa khoảng trắng!", dialog.ERROR_DIALOG);
            return false;
        } else if (!NVBUS.checkSDT(txtSDT.getText())) { // Không có khoảng trắng giữa các số
            new dialog("Số điện thoại đã tồn tại!", dialog.ERROR_DIALOG);
            return false;
        }
        // Kiểm tra txtDiaChi (địa chỉ)
        if (txtDiaChi.getText().equals("")) {
            new dialog("Địa chỉ không được để trống!", dialog.ERROR_DIALOG);
            return false;
        }

        // Kiểm tra JDNgaySinh (Ngày sinh)
        if (JDNgaySinh.getDate() == null) {
            new dialog("Ngày sinh không được để trống!", dialog.ERROR_DIALOG);
            return false;
        } else {
            // Lấy ngày hiện tại
            LocalDate currentDate = LocalDate.now();

            // Lấy ngày sinh từ JDateChooser
            LocalDate birthDate = JDNgaySinh.getDate().toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();

            // Tính toán khoảng cách tuổi giữa ngày sinh và ngày hiện tại
            Period period = Period.between(birthDate, currentDate);

            // Kiểm tra nếu tuổi nhỏ hơn 18
            if (period.getYears() < 18) {
                new dialog("Bạn phải đủ 18 tuổi để sử dụng hệ thống!", dialog.ERROR_DIALOG);
                return false;
            }
        }

        // Kiểm tra txtLuong (Lương)
        if (txtLuong.getText().equals("")) {
            new dialog("Lương không được để trống!", dialog.ERROR_DIALOG);
            return false;
        } else if (!txtLuong.getText().matches(regexNoSpecialChars) && !txtLuong.getText().matches(regexNoSpecialChars2)) {

            return false;
        }

        for (int i = 0; i < BoxChucVu.getItemCount(); i++) {
            if ((BoxChucVu.getSelectedItem().toString().equals("Quản Trị Viên") && NVBUS.checkExistAdmin())) {
                JOptionPane.showMessageDialog(null, "Chỉ được tồn tại 1 nhân viên có quyền Admin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public boolean validateFieldsSua() {
        // Biểu thức chính quy để kiểm tra không chứa ký tự đặc biệt (chỉ chứa ký tự và số)
        String regexNoSpecialChars = "^[0-9]{1,3}(?:,\\d{3})*VNĐ$";
        String regexNoSpecialChars1 = "^[0-9]{1,3}(?:.\\d{3})*VNĐ$";

        String regexNoSpecialChars2 = "^[a-zA-Z0-9]*$";
        // Kiểm tra txtTen (Tên người dùng)
        if (txtMa.getText().equals("")) {
            new dialog("Bạn chưa chọn nhân viên", dialog.ERROR_DIALOG);
            return false;
        }

        if (txtTen.getText().equals("")) {
            new dialog("Tên không được để trống!", dialog.ERROR_DIALOG);
            return false;
        } else if (txtTen.getText().length() > 50) {
            new dialog("Tên không được quá 50 ký tự!", dialog.ERROR_DIALOG);
            return false;
        } else if ((txtTen.getText().matches(".*[!@#$%^&*()_+=\\[\\]{};':\"\\\\|,.<>/?`~].*") || txtTen.getText().matches(".*\\d.*"))) {
            new dialog("Tên không được chứa số hoặc ký tự đặc biệt!", dialog.ERROR_DIALOG);
            return false;
        }

        if (BoxGioiTinh.getSelectedItem().toString().equals("Chọn giới tính")) {
            new dialog("Bạn phải chọn giới tính!", dialog.ERROR_DIALOG);
            return false;
        } // Kiểm tra txtSDT (Số điện thoại)
        else if (txtSDT.getText().equals("")) {
            new dialog("Số điện thoại không được để trống!", dialog.ERROR_DIALOG);
            return false;
        } else if (!txtSDT.getText().matches("0\\d{9}")) { // Số điện thoại phải có 10 chữ số, bắt đầu với số 0
            new dialog("Số điện thoại phải bắt đầu bằng số 0 và có 10 số !", dialog.ERROR_DIALOG);
            return false;
        } else if (txtSDT.getText().contains(" ")) { // Không có khoảng trắng giữa các số
            new dialog("Số điện thoại không được chứa khoảng trắng!", dialog.ERROR_DIALOG);
            return false;
        } else if (!NVBUS.checkSDTBanThan(txtSDT.getText(), txtMa.getText())) { // Không có khoảng trắng giữa các số
            new dialog("Số điện thoại đã tồn tại!", dialog.ERROR_DIALOG);
            return false;
        }
        // Kiểm tra txtDiaChi (địa chỉ)
        if (txtDiaChi.getText().equals("")) {
            new dialog("Địa chỉ không được để trống!", dialog.ERROR_DIALOG);
            return false;
        }

        // Kiểm tra JDNgaySinh (Ngày sinh)
        if (JDNgaySinh.getDate() == null) {
            new dialog("Ngày sinh không được để trống!", dialog.ERROR_DIALOG);
            return false;
        } else {
            LocalDate currentDate = LocalDate.now();

            LocalDate birthDate = JDNgaySinh.getDate().toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();

            Period period = Period.between(birthDate, currentDate);

            if (period.getYears() < 18) {
                new dialog("Chưa đủ 18 tuổi để làm nhân viên!", dialog.ERROR_DIALOG);
                return false;
            }
        }

        // Kiểm tra txtLuong (Lương)
        if (txtLuong.getText().equals("")) {
            new dialog("Lương không được để trống!", dialog.ERROR_DIALOG);
            return false;
        } else if (!txtLuong.getText().matches(regexNoSpecialChars) && !txtLuong.getText().matches(regexNoSpecialChars2) && !txtLuong.getText().matches(regexNoSpecialChars1)) {
            new dialog("Nhập sai định dạng(### hoặc #,###VNĐ)!", dialog.ERROR_DIALOG);
            System.out.println(txtLuong.getText());
            return false;
        }

        if (!txtMa.getText().equals("") && NVBUS.getChucVuNhanVienTheoMa(txtMa.getText()).equals("Quản Trị Viên") && NVBUS.checkExistAdmin()) {
            JOptionPane.showMessageDialog(null, "Quản trị viên không thể tự thay đổi thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void xuLyKhoaTaiKhoan() {

        String tenDangNhap = TKBUS.getTenDangNhapTheoMa(txtMa.getText());
        if (tenDangNhap.equals("")) {
            new dialog("Nhân viên này chưa có tài khoản!", dialog.ERROR_DIALOG);
            return;
        }
        dialog dlg = new dialog("Có chắc muốn khóa tài khoản này!", dialog.WARNING_DIALOG);
        if (dlg.getAction() != dialog.OK_OPTION) {
            return;
        }
        TKBUS.khoaTaiKhoan(txtMa.getText());
    }

    private void ThongTinTK() {
        String maNV = txtMa.getText();
        if (maNV.trim().equals("")) {
            new dialog("Bạn chưa chọn nhân viên!", dialog.ERROR_DIALOG);
            return;
        }
        JDialog dialog = new JDialog();
        dialog.setTitle("Thông tin tài khoản");
        dialog.setModal(true);
        dialog.setSize(450, 350);
        dialog.setLocationRelativeTo(null);
        dlgInforAcc_QuyenNV pnTTTK = new dlgInforAcc_QuyenNV(maNV);
        dialog.add(pnTTTK);
        boolean cf = pnTTTK.loadData();
        if (cf) {
            dialog.setVisible(true);
            loadDataTblNhanVien();
        } else {
            dialog.setVisible(false);
            loadDataTblNhanVien();
        }

    }

    private void xuLyCapTaiKhoan() {
        if (txtMa.getText().trim().equals("")) {
            new dialog("Bạn chưa chọn nhân viên!", dialog.ERROR_DIALOG);
            return;
        }
        if (TKBUS.hasAccount(txtMa.getText())) { // kiểm tra nhân viên đã có tài khoản chưa
            return;
        }
        JDialog dialogCTK = new JDialog();
        dialogCTK.setTitle("Cấp Tài Khoản");
        dialogCTK.setModal(true);
        dialogCTK.setSize(450, 350);
        dialogCTK.setLocationRelativeTo(null);
        dlgCapTaiKhoan pnCapTaiKhoan = new dlgCapTaiKhoan(txtMa.getText());
        dialogCTK.add(pnCapTaiKhoan);
        dialogCTK.setVisible(true);

    }

    private void xuLyXuatExcel() {
        XuLyFileExcel xuatExcel = new XuLyFileExcel();
        xuatExcel.xuatExcel(Table);
    }

    private void xuLySuaNhanVien() {

        if (BoxGioiTinh.getSelectedIndex() == 0) {
            new dialog("Bạn chưa chọn giới tính!", dialog.ERROR_DIALOG);
            return;
        }
        //? check Admin không được sửa thông tin
        if (NVBUS.getById(txtMa.getText()).getChucVuNhanVien().equals("Quản trị")) {
            new dialog("Bạn là Quản Trị Viên,\n không thể sủa thông tin của chính mình", dialog.ERROR_DIALOG);
            return;
        }
        String ten = txtTen.getText();
        String gioiTinh = BoxGioiTinh.getSelectedItem() + "";
        String sdt = txtSDT.getText();
        // Khai báo biến ngaysinh
        java.sql.Date ngaysinh = null; // Khởi tạo với null

        java.util.Date utilDate = JDNgaySinh.getDate();
        // Kiểm tra nếu ngày không phải là null
        if (utilDate != null) {
            ngaysinh = new java.sql.Date(utilDate.getTime());
        } else {
        }
        String diachi = txtDiaChi.getText();
        String chucvu = BoxChucVu.getSelectedItem() + "";
        System.out.println(txtLuong.getText());

        int luong = parseCurrency(txtLuong.getText());
        if (NVBUS.updateNhanVien(txtMa.getText(), ten, gioiTinh, sdt, ngaysinh, chucvu, diachi, luong, 1)) {
            refresh();
            NVBUS.docDanhSach();
        }
    }

    public int parseCurrency(String currencyStr) {
        String cleanedStr = currencyStr.replace(",", "").replace(".", "").replace("VNĐ", "").trim();
        return Integer.parseInt(cleanedStr);
    }

    private void xuLyThemNhanVien() {
        if (BoxGioiTinh.getSelectedIndex() == 0) {
            new dialog("Bạn chưa chọn giới tính!", dialog.ERROR_DIALOG);
            return;
        }
        String ho = txtTen.getText();
        String gioiTinh = BoxGioiTinh.getSelectedItem() + "";
        String dienthoai = txtSDT.getText();
        // Khai báo biến ngaysinh
        java.sql.Date ngaysinh = null;

        java.util.Date utilDate = JDNgaySinh.getDate();
        if (utilDate != null) {
            ngaysinh = new java.sql.Date(utilDate.getTime());
        } else {
        }

        String diachi = txtDiaChi.getText();
        String chucvu = BoxChucVu.getSelectedItem() + "";
        int luong = parseCurrency(txtLuong.getText());

        if (ngaysinh == null) {
            new dialog("Ngày sinh không được để trống", dialog.ERROR_DIALOG);
        }
        boolean check;
        check = NVBUS.themNhanVien(ho, gioiTinh, dienthoai, ngaysinh, chucvu, diachi, luong, 1);
        if (check) {
            refresh();
            NVBUS.docDanhSach();
            loadDataCmbQuyen();
        }
    }

    private void refresh() {
        txtDiaChi.setText("");
        txtMa.setText("");
        txtLuong.setText("");
        BoxGioiTinh.setSelectedIndex(0);
        JDNgaySinh.setDate(null);
        txtTen.setText("");
        txtSDT.setText("");
        txtTimKiem.setText("");
        loadDataTblNhanVien();
    }

    private void xuLyTimKiemNhanVienTheoTen() {
        NVBUS.timNhanVienTheoTen(txtTimKiem.getText(), Table);
    }

    private void xuLyTimKiemNhanVienTheoma() {
        NVBUS.timNhanVienMa(txtTimKiem.getText(), Table);
    }

    private void xuLyClickTblNhanVien() {
        JPanel overlay = new JPanel();
        overlay.setOpaque(false);
        overlay.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
        });
        int row = Table.getSelectedRow();
        String currentQuyen;
        if (row > -1) {
            txtMa.setText(Table.getValueAt(row, 0) + "");
            txtTen.setText(Table.getValueAt(row, 1) + "");
            txtSDT.setText(Table.getValueAt(row, 3) + "");
            Object ngaySinhObj = Table.getValueAt(row, 4);
            if (ngaySinhObj instanceof String) {

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    java.util.Date utilDate = sdf.parse((String) ngaySinhObj);
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    JDNgaySinh.setDate(sqlDate);
                    JDNgaySinh.setDateFormatString("dd-MM-yyyy");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (ngaySinhObj instanceof java.sql.Date) {

                JDNgaySinh.setDate((java.sql.Date) ngaySinhObj);
                JDNgaySinh.setDateFormatString("dd-MM-yyyy");
            }
            txtDiaChi.setText(Table.getValueAt(row, 6) + "");
            txtLuong.setText(Table.getValueAt(row, 7) + "");

            if ((Table.getValueAt(row, 2) + "").equals("Nam")) {
                BoxGioiTinh.setSelectedIndex(1);
            } else {
                BoxGioiTinh.setSelectedIndex(2);
            }
            currentQuyen = NVBUS.LayQuyenTheoMa(txtMa.getText());
            if (currentQuyen == null) {
                return;
            } else {
                boolean found = false;
                for (int i = 0; i < BoxChucVu.getItemCount(); i++) {
                    if (BoxChucVu.getItemAt(i).toString().trim().equals(currentQuyen.trim())) {
                        BoxChucVu.setSelectedIndex(i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                }
            }
        }
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

    private void loadDataCmbQuyen() {
        List<String> danhSachQuyen = PQBUS.getListTenPhanQuyen();
        String[] quyenArray = danhSachQuyen.toArray(new String[0]);
        BoxChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(quyenArray));
    }

    private void loadDataTblNhanVien() {
        NVBUS.loadDataTblNhanVien(Table);
        loadDataCmbQuyen();
    }
    //khai báo đối tượng cần dùng
    TaiKhoanBUS TKBUS = new TaiKhoanBUS();
    NhanVienBUS NVBUS = new NhanVienBUS();
    PhanQuyenBUS PQBUS = new PhanQuyenBUS();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxChucVu;
    private javax.swing.JComboBox<String> BoxGioiTinh;
    private javax.swing.JPanel BtnKhoaTK;
    private javax.swing.JPanel BtnQLNhanVien;
    private javax.swing.JPanel BtnQLPhanQuyen;
    private javax.swing.JPanel BtnRefresh;
    private javax.swing.JPanel BtnSua;
    private javax.swing.JPanel BtnThem;
    private javax.swing.JPanel BtnThemTaiKhoan;
    private javax.swing.JPanel BtnThongTinTK;
    private javax.swing.JPanel BtnXuat;
    private com.toedter.calendar.JDateChooser JDNgaySinh;
    private javax.swing.JScrollPane JScrNhanVien;
    private javax.swing.JLabel LbNhanVien;
    private javax.swing.JLabel LbPhanQuyen;
    private javax.swing.JLabel LbeChucVu;
    private javax.swing.JLabel LbeDiaChi;
    private javax.swing.JLabel LbeGioiTinh;
    private javax.swing.JLabel LbeLuong;
    private javax.swing.JLabel LbeMa;
    private javax.swing.JLabel LbeNgaySinh;
    private javax.swing.JLabel LbeSDT;
    private javax.swing.JLabel LbeTimKiem;
    private javax.swing.JLabel LblKhoaTK;
    private javax.swing.JLabel LblRefresh;
    private javax.swing.JLabel LblSua;
    private javax.swing.JLabel LblTen;
    private javax.swing.JLabel LblThem;
    private javax.swing.JLabel LblThemTK;
    private javax.swing.JLabel LblThongTinTK;
    private javax.swing.JLabel LblTieuDe;
    private javax.swing.JLabel LblXuat;
    private javax.swing.JSeparator Line1;
    private javax.swing.JSeparator Line2;
    private javax.swing.JSeparator Line3;
    private javax.swing.JSeparator Line5;
    private javax.swing.JSeparator Line6;
    private javax.swing.JPanel PanelChuaNut;
    private javax.swing.JPanel PanelChuaTextField;
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel PanelNhanVien;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JPanel PanelTruongThongTin;
    private javax.swing.JScrollPane ScrTable;
    private javax.swing.JTable Table;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.JComboBox<String> cmbTimKiemNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
