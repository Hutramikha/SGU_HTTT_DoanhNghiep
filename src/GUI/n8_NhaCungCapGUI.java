package GUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hslf.blip.DIB;
import org.w3c.dom.events.MouseEvent;

import BUS.NccBUS;
import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import BUS.NccBUS;
import Util.TableCustom;
import Util.XuLyFileExcel;
import Util.dialog;
import Util.InputValidator;
import Util.PlaceholderUtil;

public class n8_NhaCungCapGUI extends javax.swing.JPanel {

    NccBUS nccBUS = new NccBUS();
    NhaCungCapDTO nccDTO= new NhaCungCapDTO();
    InputValidator check = new InputValidator();
    PlaceholderUtil Phover = new PlaceholderUtil();
    public n8_NhaCungCapGUI() {
        initComponents();

        TableCustom.apply(ScrollPane, TableCustom.TableType.MULTI_LINE); // Hàm chung của nhóm ở Package Util
        taoMaNCC();
        nhomNutChucNang();

    }
    // Hàm init sắp xếp vị trí components
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents

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
        LblDiaChi = new javax.swing.JLabel();
        TextFieldDiaChi = new javax.swing.JTextField();
        LblSDT = new javax.swing.JLabel();
        TextFieldSDT = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        PanelChuaNut = new javax.swing.JPanel();
        btn_Sua = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_XuatExcel = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        LabelTenBang = new javax.swing.JLabel();
        BtnTimKiem = new javax.swing.JButton();
        Btnrefresh = new javax.swing.JButton();
        PanelTimKiem = new javax.swing.JPanel();
        TextFieldTimKiem = new javax.swing.JTextField();
        LabelAnhTimKiem = new javax.swing.JLabel();

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setPreferredSize(new java.awt.Dimension(1125, 658));

        PanelInput.setBackground(new java.awt.Color(255, 255, 255));

        PanelThongTin.setBackground(new java.awt.Color(219, 189, 142));
        PanelThongTin.setPreferredSize(new java.awt.Dimension(237, 277));

        PanelNoiDungThongTin.setBackground(new java.awt.Color(255, 255, 255));
        PanelNoiDungThongTin.setMinimumSize(new java.awt.Dimension(255, 266));
        PanelNoiDungThongTin.setPreferredSize(new java.awt.Dimension(225, 266));

        LabelTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelTieuDe.setText("Thông Tin Nhà Cung Cấp");

        PanelThuocTinh.setBackground(new java.awt.Color(255, 255, 255));

        LblMa.setBackground(new java.awt.Color(255, 255, 255));
        LblMa.setText("Mã NCC");

        TextFieldMa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        String newNCC = nccBUS.taomaNCC();
        TextFieldMa.setText(newNCC);
        TextFieldMa.setBorder(null);
        TextFieldMa.setEnabled(false);

        LblTen.setBackground(new java.awt.Color(255, 255, 255));
        LblTen.setText("Tên NCC");

        TextFieldTen.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        // TextFieldTen.setText("Cà Phê Hạt ABC");
        TextFieldTen.setBorder(null);

        LblDiaChi.setBackground(new java.awt.Color(255, 255, 255));
        LblDiaChi.setText("Địa Chỉ");

        TextFieldDiaChi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        // TextFieldDiaChi.setText("123 An Dương Vương");
        TextFieldDiaChi.setBorder(null);

        LblSDT.setBackground(new java.awt.Color(255, 255, 255));
        LblSDT.setText("Số ĐT");

        TextFieldSDT.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        // TextFieldSDT.setText("0825 143 790");
        TextFieldSDT.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 5));

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout PanelThuocTinhLayout = new javax.swing.GroupLayout(PanelThuocTinh);
        PanelThuocTinh.setLayout(PanelThuocTinhLayout);
        PanelThuocTinhLayout.setHorizontalGroup(
                PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelThuocTinhLayout
                                .createSequentialGroup()
                                .addGroup(PanelThuocTinhLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelThuocTinhLayout
                                                .createSequentialGroup()
                                                .addGroup(PanelThuocTinhLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                                                                .addComponent(LblMa,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addGroup(PanelThuocTinhLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(TextFieldMa,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                132, Short.MAX_VALUE)
                                                                        .addComponent(jSeparator1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)))
                                                        .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                                                                .addComponent(LblTen,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addGroup(PanelThuocTinhLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(TextFieldTen,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                132, Short.MAX_VALUE)
                                                                        .addComponent(jSeparator2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)))
                                                        .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                                                                .addComponent(LblSDT,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addGroup(PanelThuocTinhLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(TextFieldSDT,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                132, Short.MAX_VALUE)
                                                                        .addComponent(jSeparator4,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                                                .addComponent(LblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(PanelThuocTinhLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(TextFieldDiaChi,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 132,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap()));
        PanelThuocTinhLayout.setVerticalGroup(
                PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(PanelThuocTinhLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LblMa)
                                        .addComponent(TextFieldMa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(PanelThuocTinhLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LblTen, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldTen))
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(PanelThuocTinhLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LblDiaChi)
                                        .addComponent(TextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(PanelThuocTinhLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LblSDT, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldSDT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE)));

        javax.swing.GroupLayout PanelNoiDungThongTinLayout = new javax.swing.GroupLayout(PanelNoiDungThongTin);
        PanelNoiDungThongTin.setLayout(PanelNoiDungThongTinLayout);
        PanelNoiDungThongTinLayout.setHorizontalGroup(
                PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelNoiDungThongTinLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PanelThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(LabelTieuDe)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        PanelNoiDungThongTinLayout.setVerticalGroup(
                PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelTieuDe)
                                .addGap(18, 18, 18)
                                .addComponent(PanelThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout PanelThongTinLayout = new javax.swing.GroupLayout(PanelThongTin);
        PanelThongTin.setLayout(PanelThongTinLayout);
        PanelThongTinLayout.setHorizontalGroup(
                PanelThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelThongTinLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(PanelNoiDungThongTin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        PanelThongTinLayout.setVerticalGroup(
                PanelThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelThongTinLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(PanelNoiDungThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 229,
                                        Short.MAX_VALUE)
                                .addContainerGap()));

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

        btn_XuatExcel.setBackground(new java.awt.Color(0, 0, 0));
        btn_XuatExcel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_XuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_XuatExcel.setText("Xuất Excel");
        btn_XuatExcel.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_XuatExcel.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_XuatExcel.setPreferredSize(new java.awt.Dimension(100, 26));

        btn_XuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XuLyFileExcel ex = new XuLyFileExcel();
                ex.xuatExcel(Table);
            }
        });

        javax.swing.GroupLayout PanelChuaNutLayout = new javax.swing.GroupLayout(PanelChuaNut);
        PanelChuaNut.setLayout(PanelChuaNutLayout);
        PanelChuaNutLayout.setHorizontalGroup(
                PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelChuaNutLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(PanelChuaNutLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32,
                                        Short.MAX_VALUE)
                                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)));
        PanelChuaNutLayout.setVerticalGroup(
                PanelChuaNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelChuaNutLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PanelChuaNutLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        javax.swing.GroupLayout PanelInputLayout = new javax.swing.GroupLayout(PanelInput);
        PanelInput.setLayout(PanelInputLayout);
        PanelInputLayout.setHorizontalGroup(
                PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                                .addGap(0, 21, Short.MAX_VALUE)
                                .addComponent(PanelChuaNut, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)));
        PanelInputLayout.setVerticalGroup(
                PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 240,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67,
                                        Short.MAX_VALUE)
                                .addComponent(PanelChuaNut, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)));

        ScrollPane.setPreferredSize(new java.awt.Dimension(800, 440));
        ///////////// bảng
        Table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã NCC", "Tên NCC", "Địa Chỉ", "Số Điện Thoại"
                }) {
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa ô
            }
        });

        Table.setRowHeight(50);
        Table.setFocusable(false);
        Table.isEditing();
        ScrollPane.setViewportView(Table);
        NccBUS nccbus = new NccBUS();
        nccbus.loadDataToTable_NhaCungCap(Table);

        LabelTenBang.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        LabelTenBang.setText("Nhà Cung Cấp");

        BtnTimKiem.setBackground(new java.awt.Color(0, 0, 0));
        BtnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        BtnTimKiem.setText("Tìm Kiếm");
        BtnTimKiem.setMaximumSize(new java.awt.Dimension(100, 24));
        BtnTimKiem.setMinimumSize(new java.awt.Dimension(100, 24));
        BtnTimKiem.setPreferredSize(new java.awt.Dimension(100, 24));

        Btnrefresh.setBackground(new java.awt.Color(0, 0, 0));
        Btnrefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Btnrefresh.setForeground(new java.awt.Color(255, 255, 255));
        Btnrefresh.setText("Tải Lại");
        Btnrefresh.setMaximumSize(new java.awt.Dimension(100, 24));
        Btnrefresh.setMinimumSize(new java.awt.Dimension(100, 24));
        Btnrefresh.setPreferredSize(new java.awt.Dimension(100, 24));

        PanelTimKiem.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem.setMaximumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setMinimumSize(new java.awt.Dimension(314, 32));

        TextFieldTimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Phover.addPlaceholder(TextFieldTimKiem,"tìm kiếm tên nhà cung cấp");

        LabelAnhTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search.png"))); // NOI18N

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
                PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTimKiemLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(TextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 272,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelAnhTimKiem)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        PanelTimKiemLayout.setVerticalGroup(
                PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(PanelTimKiemLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LabelAnhTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldTimKiem))
                                .addGap(4, 4, 4)));

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
                PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTongLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(PanelTongLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(PanelTongLayout.createSequentialGroup()
                                                .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BtnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(Btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 748,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 23, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelTenBang)
                                .addGap(417, 417, 417)));
        PanelTongLayout.setVerticalGroup(
                PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(LabelTenBang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25,
                                        Short.MAX_VALUE)
                                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout
                                                .createSequentialGroup()
                                                .addGroup(PanelTongLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(BtnTimKiem,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Btnrefresh,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(14, 14, 14))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout
                                                .createSequentialGroup()
                                                .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelTongLayout.createSequentialGroup()
                                                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 494,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout
                                                .createSequentialGroup()
                                                .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63)))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 9, Short.MAX_VALUE)));

    }// </editor-fold>//GEN-END:initComponents

    private void reset() {
        TextFieldTen.setText("");
        taoMaNCC();
        TextFieldDiaChi.setText("");
        // TextFieldTimKiem.setText("");
        TextFieldSDT.setText("");
        nccBUS.loadDataToTable_NhaCungCap(Table);
        btn_Them.setEnabled(true);
    }

    private void taoMaNCC() {
        String maNCCnew = nccBUS.taomaNCC();
        TextFieldMa.setText(maNCCnew);
    }

    private void nhomNutChucNang() {
        BtnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(TextFieldTimKiem.getText().equals("tìm kiếm tên nhà cung cấp")){
                        JOptionPane.showMessageDialog(null,"vui lòng nhập tên nhà cung cấp bạn muốn tìm","thông báo",dialog.CANCEL_OPTION);
                        nccBUS.loadDataToTable_NhaCungCap(Table);
                        return;
                }else{
                        nccBUS.timKiem(Table, TextFieldTimKiem.getText());

                }
            }
        });
        Btnrefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reset();

            }
        });
        btn_Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int maxLength = 255;
                List<NhaCungCapDTO> ncclist = nccBUS.getlistncc();

                String maNCC = TextFieldMa.getText();
                String tenNCC = TextFieldTen.getText();
                String diachiNCC = TextFieldDiaChi.getText();
                String sdtNCC = TextFieldSDT.getText();
                NhaCungCapDTO a = nccBUS.getNcc(maNCC);
                int temp=0;
                for(int i= 0;i<ncclist.size();i++){
                        if(ncclist.get(i).getMaNhaCungCap().equals(maNCC)){
                                temp = temp+1;    
                        }
                }
                if (check.IsEmpty(maNCC) || check.IsEmpty(tenNCC) || check.IsEmpty(diachiNCC)
                        || check.IsEmpty(sdtNCC)) {
                    JOptionPane.showMessageDialog(null, "bạn chưa chọn nhà cung cấp", "lỗi",
                            dialog.ERROR_DIALOG);
                    return;
                }
                
                if (diachiNCC.length() > 255) {
                    JOptionPane.showMessageDialog(null,
                            "Địa chỉ nhà cung cấp vượt quá độ dài cho phép: " + maxLength + " ký tự.",
                            "Lỗi",
                            dialog.ERROR_DIALOG);
                    return;
                }
                if (check.isValidPhoneNumber(sdtNCC) != true) {
                    JOptionPane.showMessageDialog(null, "vui lòng nhập đúng số điện thoại bắt đầu bằng 0 và có 10 số", "lỗi", dialog.ERROR_DIALOG);
                    return;
                }
                System.out.println(temp);
                if(temp==0){
                        JOptionPane.showMessageDialog(null, "nhà cung cấp chưa tồn tại, vui lòng chọn thêm nhà cung cấp", "lỗi", dialog.ERROR_DIALOG);
                        return;
                        
                }
                else{
                        if(a.getMaNhaCungCap().equals(maNCC)&& a.getTenNhaCungCap().equals(tenNCC) && a.getDiaChiNhaCungCap().equals(diachiNCC) && a.getSoDienThoaiNhaCungCap().equals(sdtNCC)){
                        JOptionPane.showMessageDialog(null,
                    "bạn chưa thay đổi dữ liệu nhà cung cấp",
                    "Lỗi",
                        dialog.ERROR_DIALOG);
                        return;
                        }
                        int choice = JOptionPane.showConfirmDialog( null, "Bạn có muốn cập nhật thông tin mới ? ",   "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                        if(choice == JOptionPane.YES_OPTION)
                        {if(nccBUS.capNhatNhaCungCap(maNCC, tenNCC, diachiNCC, sdtNCC)){
                                reset();
                        };
                         }
                        else if(choice == JOptionPane.NO_OPTION){
                        return;
                }
                        
                }
                
                
                
            }

        });
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InputValidator check = new InputValidator();
                int maxLength = 255;
                String maNCCnew = nccBUS.taomaNCC();
                List<NhaCungCapDTO> a = nccBUS.getlistncc();
                String maNCC = TextFieldMa.getText();
                String tenNCC = TextFieldTen.getText();
                String diachiNCC = TextFieldDiaChi.getText();
                String sdtNCC = TextFieldSDT.getText();
                if(btn_Them.isEnabled()== false){
                        return;
                }
                if (check.IsEmpty(tenNCC) || check.IsEmpty(diachiNCC)
                        || check.IsEmpty(sdtNCC)) {
                    JOptionPane.showMessageDialog(null, "bạn chưa nhập thông tin nhà cung cấp mới", "lỗi",
                            dialog.ERROR_DIALOG);
                    return;
                }
               
                if (diachiNCC.length() > 255) {
                    JOptionPane.showMessageDialog(null,
                            "Địa chỉ nhà cung cấp vượt quá độ dài cho phép: " + maxLength + " ký tự.",
                            "Lỗi",
                            dialog.ERROR_DIALOG);
                    return;
                }
                
                if (check.isValidPhoneNumber(sdtNCC) != true) {
                    JOptionPane.showMessageDialog(null, "vui lòng nhập đúng số điện thoại bắt đầu bằng 0 và có 10 số", "lỗi", dialog.ERROR_DIALOG);
                    return;
                }
                for(int i= 0;i<a.size();i++){
                        if(a.get(i).getMaNhaCungCap().equals(maNCC)){
                                JOptionPane.showMessageDialog(null, "Mã nhà cung cấp đã tồn tại, hệ thống sẽ cập nhật mã mới", "lỗi", dialog.ERROR_DIALOG);
                                TextFieldMa.setText(maNCCnew);
                                return;
                        }
                        
                }
                for(int i= 0;i<a.size();i++){
                        if(a.get(i).getSoDienThoaiNhaCungCap().equals(sdtNCC)){
                                JOptionPane.showMessageDialog(null, "số điện thoại đã tồn tại", "lỗi", dialog.ERROR_DIALOG);
                                TextFieldMa.setText(maNCCnew);
                                return;
                        }
                        
                }
                int choice = JOptionPane.showConfirmDialog( null, "Bạn có muốn thêm nhà cung cấp mới?",   "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if(choice == JOptionPane.YES_OPTION)
                {nccBUS.themNhaCungCap(tenNCC, diachiNCC, sdtNCC);
                reset();}
                else if(choice == JOptionPane.NO_OPTION){
                        return;
                }
        }
            

        });
        Table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Only trigger when the selection has finished
                int Row = Table.getSelectedRow();
                TableModel model = Table.getModel();
                if (Row >= 0) {
                    TextFieldMa.setText(model.getValueAt(Row, 0).toString());
                    TextFieldTen.setText(model.getValueAt(Row, 1).toString());
                    TextFieldDiaChi.setText(model.getValueAt(Row, 2).toString());
                    TextFieldSDT.setText(model.getValueAt(Row, 3).toString());
                }
                btn_Them.setEnabled(false);
                
            }

        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Thống Kê");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đặt hành động khi đóng cửa sổ
                frame.setSize(1150, 690); // Thiết lập kích thước cho JFrame

                n8_NhaCungCapGUI n10 = new n8_NhaCungCapGUI();
                n10.initComponents(); // Khởi tạo các thành phần trong JPanel
                // n10.addControl();
                // n10.initUI();
                n10.nhomNutChucNang();
                n10.setVisible(true);

                frame.add(n10); // Thêm JPanel vào JFrame
                frame.setVisible(true); // Hiển thị JFrame
            }
        });
    }

    // Khai Báo Biến
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTimKiem;
    private javax.swing.JButton Btnrefresh;
    private javax.swing.JLabel LabelAnhTimKiem;
    private javax.swing.JLabel LabelTenBang;
    private javax.swing.JLabel LabelTieuDe;
    private javax.swing.JLabel LblDiaChi;
    private javax.swing.JLabel LblMa;
    private javax.swing.JLabel LblSDT;
    private javax.swing.JLabel LblTen;
    private javax.swing.JPanel PanelChuaNut;
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel PanelNoiDungThongTin;
    private javax.swing.JPanel PanelThongTin;
    private javax.swing.JPanel PanelThuocTinh;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TextFieldDiaChi;
    private javax.swing.JTextField TextFieldMa;
    private javax.swing.JTextField TextFieldSDT;
    private javax.swing.JTextField TextFieldTen;
    private javax.swing.JTextField TextFieldTimKiem;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_XuatExcel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
    // Kết Thúc Khai Báo Biến
}
