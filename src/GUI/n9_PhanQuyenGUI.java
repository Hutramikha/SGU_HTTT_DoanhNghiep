package GUI;
import Util.TableCustom;
import Util.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import org.apache.poi.ss.formula.functions.Na;

import BUS.NhanVienBUS;
import BUS.PhanQuyenBUS;
import DTO.PhanQuyenDTO;

/**
 *
 * @author phuoc
 */
public class n9_PhanQuyenGUI extends javax.swing.JPanel {

    /**
     * Creates new form PhanQuyenGUI
     */
    public n9_PhanQuyenGUI() {
        initComponents();
        TableCustom.apply(JScrollThongTinQuyen, TableCustom.TableType.MULTI_LINE);
        loadData();
        nhomNutChucNang();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PanelTong = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelPhanQuyen = new javax.swing.JPanel();
        lblPhanQuyen = new javax.swing.JLabel();
        cbPhanQuyen = new javax.swing.JComboBox<>();
        JScrollThongTinQuyen = new javax.swing.JScrollPane();
        TableThongTinQuyen = new javax.swing.JTable();
        BtnQLNhanVien = new javax.swing.JPanel();
        LbNhanVien = new javax.swing.JLabel();
        BtnQLPhanQuyen = new javax.swing.JPanel();
        LbPhanQuyen = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BtnThem = new javax.swing.JPanel();
        LblThem = new javax.swing.JLabel();
        BtnSua = new javax.swing.JPanel();
        LblSua = new javax.swing.JLabel();
        PanelChuaCheckBox = new javax.swing.JPanel();
        ChBoxKhachHang1 = new javax.swing.JCheckBox();
        CHBoxBanHang1 = new javax.swing.JCheckBox();
        CHBoxNhapHang = new javax.swing.JCheckBox();
        CHBoxMon = new javax.swing.JCheckBox();
        CHBoxNguyenLieu1 = new javax.swing.JCheckBox();
        CHBoxLichLam1 = new javax.swing.JCheckBox();
        CHBoxKM_UD1 = new javax.swing.JCheckBox();
        CHBoxNCC1 = new javax.swing.JCheckBox();
        ChBoxNhanVien1 = new javax.swing.JCheckBox();
        CHBoxThongKe1 = new javax.swing.JCheckBox();

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setMaximumSize(new java.awt.Dimension(1125, 667));
        jPanel16.setMinimumSize(new java.awt.Dimension(1125, 667));

        jPanel17.setBackground(new java.awt.Color(219, 189, 142));
        jPanel17.setPreferredSize(new java.awt.Dimension(130, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Nhân viên");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(219, 189, 142));
        jPanel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel18.setPreferredSize(new java.awt.Dimension(130, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Phân quyền");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setMaximumSize(new java.awt.Dimension(1125, 667));
        jPanel19.setMinimumSize(new java.awt.Dimension(1125, 667));
        jPanel19.setPreferredSize(new java.awt.Dimension(1125, 667));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setText("Phân Quyền");

        jPanel20.setBackground(new java.awt.Color(219, 189, 142));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Chọn quyền: ");

        jComboBox3.setBackground(new java.awt.Color(219, 189, 142));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(29, 29, 29)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(219, 189, 142));

        jLabel24.setText("Thêm quyền");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel24)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(465, 465, 465)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(499, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1125, 667));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 667));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 667));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(1125, 658));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(1125, 658));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1125, 658));

        PanelPhanQuyen.setBackground(new java.awt.Color(255, 255, 255));
        PanelPhanQuyen.setMaximumSize(new java.awt.Dimension(1125, 667));
        PanelPhanQuyen.setMinimumSize(new java.awt.Dimension(1125, 667));

        lblPhanQuyen.setBackground(new java.awt.Color(255, 255, 255));
        lblPhanQuyen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhanQuyen.setText("Phân Quyền:");

        cbPhanQuyen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbPhanQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Quản lý" }));

        TableThongTinQuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Nhân Viên", "Khách Hàng", "Bán Hàng", "Nhập Hàng", "Món", "Nguyên Liệu", "Lịch Làm", "Khuyến Mãi", "NCC", "Thống Kê"
            }
        ));
        TableThongTinQuyen.getTableHeader().setReorderingAllowed(false);
        JScrollThongTinQuyen.setViewportView(TableThongTinQuyen);
        if (TableThongTinQuyen.getColumnModel().getColumnCount() > 0) {
            TableThongTinQuyen.getColumnModel().getColumn(0).setPreferredWidth(30);
            TableThongTinQuyen.getColumnModel().getColumn(1).setPreferredWidth(60);
            TableThongTinQuyen.getColumnModel().getColumn(2).setPreferredWidth(70);
            TableThongTinQuyen.getColumnModel().getColumn(4).setPreferredWidth(50);
            TableThongTinQuyen.getColumnModel().getColumn(6).setPreferredWidth(20);
            TableThongTinQuyen.getColumnModel().getColumn(8).setResizable(false);
            TableThongTinQuyen.getColumnModel().getColumn(8).setPreferredWidth(50);
            TableThongTinQuyen.getColumnModel().getColumn(10).setPreferredWidth(20);
            TableThongTinQuyen.getColumnModel().getColumn(11).setPreferredWidth(50);
        }

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BtnThem.setBackground(new java.awt.Color(51, 51, 51));
        BtnThem.setForeground(new java.awt.Color(255, 255, 255));
        BtnThem.setMaximumSize(new java.awt.Dimension(100, 35));
        BtnThem.setMinimumSize(new java.awt.Dimension(100, 35));
        BtnThem.setPreferredSize(new java.awt.Dimension(100, 35));

        LblThem.setBackground(new java.awt.Color(0, 0, 0));
        LblThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LblThem.setForeground(new java.awt.Color(255, 255, 255));
        LblThem.setText("Thêm quyền");

        javax.swing.GroupLayout BtnThemLayout = new javax.swing.GroupLayout(BtnThem);
        BtnThem.setLayout(BtnThemLayout);
        BtnThemLayout.setHorizontalGroup(
            BtnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnThemLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LblThem)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        BtnThemLayout.setVerticalGroup(
            BtnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BtnSua.setBackground(new java.awt.Color(51, 51, 51));
        BtnSua.setForeground(new java.awt.Color(255, 255, 255));
        BtnSua.setMaximumSize(new java.awt.Dimension(100, 35));
        BtnSua.setMinimumSize(new java.awt.Dimension(100, 35));
        BtnSua.setPreferredSize(new java.awt.Dimension(100, 35));

        LblSua.setBackground(new java.awt.Color(0, 0, 0));
        LblSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LblSua.setForeground(new java.awt.Color(255, 255, 255));
        LblSua.setText("Sửa");

        javax.swing.GroupLayout BtnSuaLayout = new javax.swing.GroupLayout(BtnSua);
        BtnSua.setLayout(BtnSuaLayout);
        BtnSuaLayout.setHorizontalGroup(
            BtnSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnSuaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(LblSua)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        BtnSuaLayout.setVerticalGroup(
            BtnSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnSuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblSua, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(BtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(BtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BtnSua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        PanelChuaCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        PanelChuaCheckBox.setLayout(new java.awt.GridLayout(4, 3, 50, 50));

        ChBoxKhachHang1.setBackground(new java.awt.Color(255, 255, 255));
        ChBoxKhachHang1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ChBoxKhachHang1.setText("Quản lý khách hàng");
        PanelChuaCheckBox.add(ChBoxKhachHang1);

        CHBoxBanHang1.setBackground(new java.awt.Color(255, 255, 255));
        CHBoxBanHang1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CHBoxBanHang1.setText("Quản lý bán hàng");
        PanelChuaCheckBox.add(CHBoxBanHang1);

        CHBoxNhapHang.setBackground(new java.awt.Color(255, 255, 255));
        CHBoxNhapHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CHBoxNhapHang.setText("Quản lý nhập hàng");
        PanelChuaCheckBox.add(CHBoxNhapHang);

        CHBoxMon.setBackground(new java.awt.Color(255, 255, 255));
        CHBoxMon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CHBoxMon.setText("Quản lý món");
        PanelChuaCheckBox.add(CHBoxMon);

        CHBoxNguyenLieu1.setBackground(new java.awt.Color(255, 255, 255));
        CHBoxNguyenLieu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CHBoxNguyenLieu1.setText("Quản lý nguyên liệu");
        PanelChuaCheckBox.add(CHBoxNguyenLieu1);

        CHBoxLichLam1.setBackground(new java.awt.Color(255, 255, 255));
        CHBoxLichLam1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CHBoxLichLam1.setText("Quản lý lịch làm");
        PanelChuaCheckBox.add(CHBoxLichLam1);

        CHBoxKM_UD1.setBackground(new java.awt.Color(255, 255, 255));
        CHBoxKM_UD1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CHBoxKM_UD1.setText("Quản lý KM-Ưu đãi");
        PanelChuaCheckBox.add(CHBoxKM_UD1);

        CHBoxNCC1.setBackground(new java.awt.Color(255, 255, 255));
        CHBoxNCC1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CHBoxNCC1.setText("Quản lý nhà cung cấp");
        PanelChuaCheckBox.add(CHBoxNCC1);

        ChBoxNhanVien1.setBackground(new java.awt.Color(255, 255, 255));
        ChBoxNhanVien1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ChBoxNhanVien1.setText("Quản lý nhân viên");
        PanelChuaCheckBox.add(ChBoxNhanVien1);
        ChBoxNhanVien1.setEnabled(false);

        CHBoxThongKe1.setBackground(new java.awt.Color(255, 255, 255));
        CHBoxThongKe1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CHBoxThongKe1.setText("Quản lý thống kê");
        PanelChuaCheckBox.add(CHBoxThongKe1);
        listckb = new ArrayList<>();
        listckb.add(ChBoxKhachHang1);
        listckb.add(CHBoxBanHang1); 
        listckb.add(CHBoxNhapHang);
        listckb.add(CHBoxMon);
        listckb.add(CHBoxNguyenLieu1);
        listckb.add(CHBoxLichLam1); 
        listckb.add(CHBoxKM_UD1);
        listckb.add(CHBoxNCC1);
        listckb.add(ChBoxNhanVien1);
        listckb.add(CHBoxThongKe1);

        javax.swing.GroupLayout PanelPhanQuyenLayout = new javax.swing.GroupLayout(PanelPhanQuyen);
        PanelPhanQuyen.setLayout(PanelPhanQuyenLayout);
        PanelPhanQuyenLayout.setHorizontalGroup(
            PanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPhanQuyenLayout.createSequentialGroup()
                .addGroup(PanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPhanQuyenLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(BtnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(BtnQLPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPhanQuyenLayout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(lblPhanQuyen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPhanQuyenLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPhanQuyenLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(PanelChuaCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JScrollThongTinQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        PanelPhanQuyenLayout.setVerticalGroup(
            PanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPhanQuyenLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnQLPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(PanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(PanelChuaCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(JScrollThongTinQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(PanelPhanQuyen);

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 694, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnQLNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnQLNhanVienMouseClicked                                         
        PanelTong.removeAll();
        n9_NhanVienKeoTha nvPanel = new n9_NhanVienKeoTha();
        PanelTong.setLayout(new java.awt.BorderLayout());
        PanelTong.add(nvPanel, java.awt.BorderLayout.CENTER); // Adjust the layout constraint as needed
        PanelTong.revalidate();
        PanelTong.repaint();
    }//GEN-LAST:event_BtnQLNhanVienMouseClicked                                         

    public void nhomNutChucNang() {
        BtnQLNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnQLNhanVien.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnQLNhanVien.setBackground(new Color(219, 189, 142));
            }
            
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelTong.removeAll();
                n9_NhanVienKeoTha lich = new n9_NhanVienKeoTha();
                PanelTong.setLayout(new BorderLayout());
                PanelTong.add(lich, BorderLayout.CENTER); // Adjust the layout constraint as needed
                PanelTong.revalidate();
                PanelTong.repaint();
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

            public void mouseClicked(MouseEvent e){
                ThemPhanQuyen();
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

            public void mouseClicked(MouseEvent e){
                SuaPhanQuyen();
            }
        });

        cbPhanQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadChecbox();
            }

        });

    }

    public void xoaPhanQuyen(){
        String tenQuyen = cbPhanQuyen.getSelectedItem() + "";

        String ma =  PQBUS.layMaTheoTenQuyen(tenQuyen);
        if(cbPhanQuyen.getSelectedItem().equals("Quản Trị Viên")){
            JOptionPane.showMessageDialog(null, "Không thể xóa quyền của quản trị viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;            
        }
        else if (ma.equals("")) {
            new dialog("Vui lòng chọn quyền", dialog.ERROR_DIALOG);
            return;
        }
        else if(PQBUS.Delete(ma)){
            loadData();
        }
    }

    private void SuaPhanQuyen(){
        if(cbPhanQuyen.getSelectedItem().equals("Quản Trị Viên")){
            JOptionPane.showMessageDialog(null, "Không thể thay đổi quyền của quản trị viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return ;            
        }

        String tenQuyen = cbPhanQuyen.getSelectedItem() + "";
        String ma =  PQBUS.layMaTheoTenQuyen(tenQuyen);
        boolean cbbKhacHang= ChBoxKhachHang1.isSelected() ? true: false;
        boolean cbbMon = CHBoxMon.isSelected() ? true: false;
        boolean cbbNhanVien = ChBoxNhanVien1.isSelected() ? true: false;
        boolean cbbNhapHang = CHBoxNhapHang.isSelected() ? true: false;
        boolean cbbLichLam = CHBoxLichLam1.isSelected() ? true: false;
        boolean cbbThongKe = CHBoxThongKe1.isSelected() ? true: false;
        boolean cbbKM_UD = CHBoxKM_UD1.isSelected() ? true: false;
        boolean cbbBanHang = CHBoxBanHang1.isSelected() ? true: false;
        boolean cbbNguyenLieu = CHBoxNguyenLieu1.isSelected() ? true: false;
        boolean cbbNCC = CHBoxNCC1.isSelected() ? true: false;
        if (PQBUS.Update(new PhanQuyenDTO(ma, null, cbbKhacHang, cbbBanHang, cbbNhapHang, cbbMon,cbbNguyenLieu,cbbLichLam, cbbKM_UD, cbbNCC, cbbNhanVien, cbbThongKe,true))) {
            loadData();
        }
    }

    private void ThemPhanQuyen(){
        String tenQuyen = JOptionPane.showInputDialog("Nhập tên quyền");
            if (tenQuyen == null) {
                return;
            }
            if (PQBUS.Insert(tenQuyen)) {
                System.out.print(tenQuyen);
                loadData();
            }
    }

    private void loadChecbox(){
        String SelectedQuyen = cbPhanQuyen.getSelectedItem() + "";
        PQBUS.loadChecbox(listckb, SelectedQuyen);
    }

    private void loadData() {
        PQBUS.loadData(TableThongTinQuyen);
        ArrayList<String> danhSachQuyen = PQBUS.getListTenPhanQuyen();
        String[] quyenArray = danhSachQuyen.toArray(new String[0]);     
        cbPhanQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(quyenArray));
        
        loadChecbox();
    }

    //khai báo đối tượng cần dùng
    PhanQuyenBUS PQBUS = new PhanQuyenBUS();
    NhanVienBUS NVBUS = new NhanVienBUS();
    ArrayList<JCheckBox> listckb;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnQLNhanVien;
    private javax.swing.JPanel BtnQLPhanQuyen;
    private javax.swing.JPanel BtnSua;
    private javax.swing.JPanel BtnThem;
    private javax.swing.JCheckBox CHBoxBanHang1;
    private javax.swing.JCheckBox CHBoxKM_UD1;
    private javax.swing.JCheckBox CHBoxLichLam1;
    private javax.swing.JCheckBox CHBoxMon;
    private javax.swing.JCheckBox CHBoxNCC1;
    private javax.swing.JCheckBox CHBoxNguyenLieu1;
    private javax.swing.JCheckBox CHBoxNhapHang;
    private javax.swing.JCheckBox CHBoxThongKe1;
    private javax.swing.JCheckBox ChBoxKhachHang1;
    private javax.swing.JCheckBox ChBoxNhanVien1;
    private javax.swing.JScrollPane JScrollThongTinQuyen;
    private javax.swing.JLabel LbNhanVien;
    private javax.swing.JLabel LbPhanQuyen;
    private javax.swing.JLabel LblSua;
    private javax.swing.JLabel LblThem;
    private javax.swing.JPanel PanelChuaCheckBox;
    private javax.swing.JPanel PanelPhanQuyen;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JTable TableThongTinQuyen;
    private javax.swing.JComboBox<String> cbPhanQuyen;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblPhanQuyen;
    // End of variables declaration//GEN-END:variables
}
