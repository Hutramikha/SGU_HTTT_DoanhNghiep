package GUI;

import BUS.n7_KhuyenMai_UuDaiBUS;
import Util.TableCustom;
import java.awt.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class n7_UuDaiGUI extends javax.swing.JPanel {

    public n7_UuDaiGUI() {
        initComponents();
        TableCustom.apply(ScrollPane, TableCustom.TableType.MULTI_LINE);
        nhomChucNang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTong = new javax.swing.JPanel();
        PanelKhuyenMai = new javax.swing.JPanel();
        LblKhuyenMai = new javax.swing.JLabel();
        PanelUuDai = new javax.swing.JPanel();
        LblUuDai = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        PanelThongTinUuDai_Cam = new javax.swing.JPanel();
        PanelThongTinUuDai = new javax.swing.JPanel();
        LabelTieuDe = new javax.swing.JLabel();
        PanelInput = new javax.swing.JPanel();
        LblMa = new javax.swing.JLabel();
        TextFieldMa = new javax.swing.JTextField();
        LblTen = new javax.swing.JLabel();
        TextFieldTen = new javax.swing.JTextField();
        LblNgayBatDau = new javax.swing.JLabel();
        LblNgayKetThuc = new javax.swing.JLabel();
        LblPhanTram = new javax.swing.JLabel();
        TextFieldPhanTram = new javax.swing.JTextField();
        LblDieuKien = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        TextFieldDieuKien = new javax.swing.JTextField();
        NgayBatDau = new com.toedter.calendar.JDateChooser();
        NgayKetThuc = new com.toedter.calendar.JDateChooser();
        LabelTenBang = new javax.swing.JLabel();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_TaiLai = new javax.swing.JButton();
        PanelTimKiem = new javax.swing.JPanel();
        TextFieldTimKiem = new javax.swing.JTextField();
        LabelAnhTimKiem = new javax.swing.JLabel();
        btn_TimKiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        box = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1125, 667));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setPreferredSize(new java.awt.Dimension(1125, 658));

        PanelKhuyenMai.setBackground(new java.awt.Color(219, 189, 142));
        PanelKhuyenMai.setForeground(new java.awt.Color(255, 102, 102));
        PanelKhuyenMai.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelKhuyenMai.setMinimumSize(new java.awt.Dimension(195, 44));
        PanelKhuyenMai.setName(""); // NOI18N
        PanelKhuyenMai.setPreferredSize(new java.awt.Dimension(195, 44));

        LblKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LblKhuyenMai.setText("Khuyến Mãi");

        javax.swing.GroupLayout PanelKhuyenMaiLayout = new javax.swing.GroupLayout(PanelKhuyenMai);
        PanelKhuyenMai.setLayout(PanelKhuyenMaiLayout);
        PanelKhuyenMaiLayout.setHorizontalGroup(
            PanelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
            .addGroup(PanelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelKhuyenMaiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LblKhuyenMai)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelKhuyenMaiLayout.setVerticalGroup(
            PanelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
            .addGroup(PanelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelKhuyenMaiLayout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(LblKhuyenMai)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );

        PanelUuDai.setBackground(new java.awt.Color(219, 189, 142));
        PanelUuDai.setForeground(new java.awt.Color(255, 102, 102));
        PanelUuDai.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelUuDai.setMinimumSize(new java.awt.Dimension(195, 44));
        PanelUuDai.setPreferredSize(new java.awt.Dimension(195, 44));

        LblUuDai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LblUuDai.setText("Ưu Đãi");

        javax.swing.GroupLayout PanelUuDaiLayout = new javax.swing.GroupLayout(PanelUuDai);
        PanelUuDai.setLayout(PanelUuDaiLayout);
        PanelUuDaiLayout.setHorizontalGroup(
            PanelUuDaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
            .addGroup(PanelUuDaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelUuDaiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LblUuDai)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelUuDaiLayout.setVerticalGroup(
            PanelUuDaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PanelUuDaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelUuDaiLayout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(LblUuDai)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );

        // Thay đổi font chữ cho tiêu đề của bảng
        Table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên Ưu Đãi", "Ngày bắt đầu", "Ngày kết thúc", "% Ưu Đãi", "Điều kiện", "Hiệu lực"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPane.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setPreferredWidth(40);
            Table.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        PanelThongTinUuDai_Cam.setBackground(new java.awt.Color(219, 189, 142));

        PanelThongTinUuDai.setBackground(new java.awt.Color(255, 255, 255));

        LabelTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelTieuDe.setText("Thông Tin Ưu Đãi");

        PanelInput.setBackground(new java.awt.Color(255, 255, 255));
        PanelInput.setPreferredSize(new java.awt.Dimension(307, 290));

        LblMa.setBackground(new java.awt.Color(255, 255, 255));
        LblMa.setText("Mã Ưu Đãi");
        LblMa.setMaximumSize(new java.awt.Dimension(100, 20));
        LblMa.setMinimumSize(new java.awt.Dimension(100, 20));
        LblMa.setOpaque(true);
        LblMa.setPreferredSize(new java.awt.Dimension(100, 20));

        TextFieldMa.setEditable(false);
        TextFieldMa.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        TextFieldMa.setForeground(new java.awt.Color(0, 51, 255));
        TextFieldMa.setBorder(null);
        TextFieldMa.setDisabledTextColor(new java.awt.Color(0, 51, 255));
        TextFieldMa.setMaximumSize(new java.awt.Dimension(120, 20));
        TextFieldMa.setMinimumSize(new java.awt.Dimension(120, 20));
        TextFieldMa.setPreferredSize(new java.awt.Dimension(120, 20));

        LblTen.setBackground(new java.awt.Color(255, 255, 255));
        LblTen.setText("Tên Ưu Đãi");
        LblTen.setMaximumSize(new java.awt.Dimension(100, 20));
        LblTen.setMinimumSize(new java.awt.Dimension(100, 20));
        LblTen.setOpaque(true);
        LblTen.setPreferredSize(new java.awt.Dimension(100, 20));

        TextFieldTen.setBorder(null);
        TextFieldTen.setMaximumSize(new java.awt.Dimension(120, 20));
        TextFieldTen.setMinimumSize(new java.awt.Dimension(120, 20));
        TextFieldTen.setPreferredSize(new java.awt.Dimension(120, 20));

        LblNgayBatDau.setBackground(new java.awt.Color(255, 255, 255));
        LblNgayBatDau.setText("Ngày bắt đầu");
        LblNgayBatDau.setMaximumSize(new java.awt.Dimension(100, 20));
        LblNgayBatDau.setMinimumSize(new java.awt.Dimension(100, 20));
        LblNgayBatDau.setOpaque(true);
        LblNgayBatDau.setPreferredSize(new java.awt.Dimension(100, 20));

        LblNgayKetThuc.setBackground(new java.awt.Color(255, 255, 255));
        LblNgayKetThuc.setText("Ngày kết thúc");
        LblNgayKetThuc.setMaximumSize(new java.awt.Dimension(100, 20));
        LblNgayKetThuc.setMinimumSize(new java.awt.Dimension(100, 20));
        LblNgayKetThuc.setOpaque(true);
        LblNgayKetThuc.setPreferredSize(new java.awt.Dimension(100, 20));

        LblPhanTram.setBackground(new java.awt.Color(255, 255, 255));
        LblPhanTram.setText("% Ưu Đãi");
        LblPhanTram.setMaximumSize(new java.awt.Dimension(100, 20));
        LblPhanTram.setMinimumSize(new java.awt.Dimension(100, 20));
        LblPhanTram.setOpaque(true);
        LblPhanTram.setPreferredSize(new java.awt.Dimension(100, 20));

        TextFieldPhanTram.setBorder(null);
        TextFieldPhanTram.setMaximumSize(new java.awt.Dimension(120, 20));
        TextFieldPhanTram.setMinimumSize(new java.awt.Dimension(120, 20));
        TextFieldPhanTram.setPreferredSize(new java.awt.Dimension(120, 20));

        LblDieuKien.setBackground(new java.awt.Color(255, 255, 255));
        LblDieuKien.setText("Điều kiện");
        LblDieuKien.setMaximumSize(new java.awt.Dimension(100, 20));
        LblDieuKien.setMinimumSize(new java.awt.Dimension(100, 20));
        LblDieuKien.setOpaque(true);
        LblDieuKien.setPreferredSize(new java.awt.Dimension(100, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(120, 5));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setPreferredSize(new java.awt.Dimension(120, 5));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setPreferredSize(new java.awt.Dimension(120, 5));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setPreferredSize(new java.awt.Dimension(120, 5));

        TextFieldDieuKien.setBorder(null);
        TextFieldDieuKien.setMaximumSize(new java.awt.Dimension(120, 20));
        TextFieldDieuKien.setMinimumSize(new java.awt.Dimension(120, 20));
        TextFieldDieuKien.setPreferredSize(new java.awt.Dimension(120, 20));

        javax.swing.GroupLayout PanelInputLayout = new javax.swing.GroupLayout(PanelInput);
        PanelInput.setLayout(PanelInputLayout);
        PanelInputLayout.setHorizontalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LblPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LblDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addComponent(LblMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addComponent(LblTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(NgayKetThuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelInputLayout.setVerticalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addComponent(TextFieldMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addComponent(TextFieldTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addComponent(LblNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(LblNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addComponent(NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addComponent(TextFieldPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addComponent(TextFieldDieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelThongTinUuDaiLayout = new javax.swing.GroupLayout(PanelThongTinUuDai);
        PanelThongTinUuDai.setLayout(PanelThongTinUuDaiLayout);
        PanelThongTinUuDaiLayout.setHorizontalGroup(
            PanelThongTinUuDaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThongTinUuDaiLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelThongTinUuDaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTieuDe)
                .addGap(59, 59, 59))
        );
        PanelThongTinUuDaiLayout.setVerticalGroup(
            PanelThongTinUuDaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThongTinUuDaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelThongTinUuDai_Cam.add(PanelThongTinUuDai);

        LabelTenBang.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        LabelTenBang.setText("Ưu Đãi Thành Viên");

        btn_Them.setBackground(new java.awt.Color(0, 0, 0));
        btn_Them.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setText("Thêm");
        btn_Them.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_Them.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_Them.setPreferredSize(new java.awt.Dimension(100, 26));

        btn_Sua.setBackground(new java.awt.Color(0, 0, 0));
        btn_Sua.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sua.setText("Sửa");
        btn_Sua.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_Sua.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_Sua.setPreferredSize(new java.awt.Dimension(100, 26));

        btn_TaiLai.setBackground(new java.awt.Color(0, 0, 0));
        btn_TaiLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_TaiLai.setForeground(new java.awt.Color(255, 255, 255));
        btn_TaiLai.setText("Tải Lại");
        btn_TaiLai.setMaximumSize(new java.awt.Dimension(100, 24));
        btn_TaiLai.setMinimumSize(new java.awt.Dimension(100, 24));
        btn_TaiLai.setPreferredSize(new java.awt.Dimension(100, 24));

        PanelTimKiem.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem.setMaximumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setMinimumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setPreferredSize(new java.awt.Dimension(303, 32));

        TextFieldTimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        LabelAnhTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search.png"))); // NOI18N

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(TextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_TimKiem.setBackground(new java.awt.Color(0, 0, 0));
        btn_TimKiem.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btn_TimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiem.setText("Tìm Kiếm");
        btn_TimKiem.setMaximumSize(new java.awt.Dimension(100, 26));
        btn_TimKiem.setMinimumSize(new java.awt.Dimension(100, 26));
        btn_TimKiem.setPreferredSize(new java.awt.Dimension(100, 26));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "theo Mã", "theo Tên" }));
        jPanel2.add(box);

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(PanelThongTinUuDai_Cam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelTongLayout.createSequentialGroup()
                                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelTongLayout.createSequentialGroup()
                                .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_TaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(PanelKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(PanelUuDai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LabelTenBang)
                        .addGap(400, 400, 400)))
                .addGap(20, 20, 20))
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelUuDai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LabelTenBang)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btn_TaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(PanelThongTinUuDai_Cam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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
    private void check_input_Rong() {
        n7_KhuyenMai_UuDaiBUS.getInstance().check_input_Rong(TextFieldMa, TextFieldTen, NgayBatDau, NgayKetThuc, TextFieldPhanTram, TextFieldDieuKien);
    }

    private void reset() {
        TextFieldPhanTram.setEditable(true);
        setMaUuDai();
        TextFieldTen.setText("");
        TextFieldPhanTram.setText("");
        TextFieldDieuKien.setText("");
        TextFieldTimKiem.setText("");
        NgayBatDau.setDate(null);
        NgayKetThuc.setDate(null);
        n7_KhuyenMai_UuDaiBUS.getInstance().getListUuDai(Table);
    }

    private void setMaUuDai() {
        TextFieldMa.setText(n7_KhuyenMai_UuDaiBUS.getInstance().taoMaUuDai());
    }

    private void nhomChucNang() {
        reset();
        PanelUuDai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelUuDai.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelUuDai.setBackground(new Color(219, 189, 142));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelTong.removeAll();
                n7_UuDaiGUI km = new n7_UuDaiGUI();
                PanelTong.setLayout(new BorderLayout());
                PanelTong.add(km, BorderLayout.CENTER); // Adjust the layout constraint as needed
                PanelTong.revalidate();
                PanelTong.repaint();
            }
        });

        PanelKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelKhuyenMai.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelKhuyenMai.setBackground(new Color(219, 189, 142));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelTong.removeAll();
                n7_KhuyenMaiGUI km = new n7_KhuyenMaiGUI();
                PanelTong.setLayout(new BorderLayout());
                PanelTong.add(km, BorderLayout.CENTER); // Adjust the layout constraint as needed
                PanelTong.revalidate();
                PanelTong.repaint();
            }
        });

        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (n7_KhuyenMai_UuDaiBUS.getInstance().check_input_Rong(TextFieldMa, TextFieldTen, NgayBatDau,
                        NgayKetThuc, TextFieldPhanTram, TextFieldDieuKien) == true) {
                    Date start = NgayBatDau.getDate();
                    String start_str = Util.LichLam_CaLam.datechooser_cast_dangChuan(start);
                    java.sql.Date start_sql = java.sql.Date.valueOf(start_str);

                    Date end = NgayKetThuc.getDate();
                    String end_str = Util.LichLam_CaLam.datechooser_cast_dangChuan(end);
                    java.sql.Date end_sql = java.sql.Date.valueOf(end_str);
                    int tien = n7_KhuyenMai_UuDaiBUS.getInstance().set_Tien_VND_sang_int(TextFieldDieuKien.getText());

                    int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm ưu đãi không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

                    if (response == JOptionPane.YES_OPTION) {
                        boolean i = n7_KhuyenMai_UuDaiBUS.getInstance().insert_uuDai(TextFieldMa.getText(), TextFieldTen.getText(),
                                start_sql, end_sql, Float.valueOf(TextFieldPhanTram.getText()), tien);

                        if (i) {
                            reset();
                        }
                    }
                }
            }
        });

        btn_Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (TextFieldMa.getText().equals(n7_KhuyenMai_UuDaiBUS.getInstance().taoMaUuDai())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 ưu đãi trong danh sách để sửa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (n7_KhuyenMai_UuDaiBUS.getInstance().check_input_Rong(TextFieldMa, TextFieldTen, NgayBatDau,
                            NgayKetThuc, TextFieldPhanTram, TextFieldDieuKien) == true) {
                        Date start = NgayBatDau.getDate();
                        String start_str = Util.LichLam_CaLam.datechooser_cast_dangChuan(start);
                        java.sql.Date start_sql = java.sql.Date.valueOf(start_str);

                        Date end = NgayKetThuc.getDate();
                        String end_str = Util.LichLam_CaLam.datechooser_cast_dangChuan(end);
                        java.sql.Date end_sql = java.sql.Date.valueOf(end_str);
                        int tien = n7_KhuyenMai_UuDaiBUS.getInstance().set_Tien_VND_sang_int(TextFieldDieuKien.getText());

                        int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa ưu đãi không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

                        if (response == JOptionPane.YES_OPTION) {
                            int i = n7_KhuyenMai_UuDaiBUS.getInstance().update_uuDai(TextFieldMa.getText(), TextFieldTen.getText(),
                                    start_sql, end_sql, Float.valueOf(TextFieldPhanTram.getText()), tien);
                            if (i == 1 || i == 0) {
                                reset();
                            }
                        }
                    }
                }
            }
        });

        TextFieldTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    int i = box.getSelectedIndex();
                    if (i == 1) {
                        n7_KhuyenMai_UuDaiBUS.getInstance().getListUuDai_theoTen(Table, TextFieldTimKiem.getText());
                    } else if (i == 0) {
                        n7_KhuyenMai_UuDaiBUS.getInstance().getListUuDai_theoMa(Table, TextFieldTimKiem.getText());
                    }
                }
            }
        });

        LabelAnhTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = box.getSelectedIndex();
                if (i == 1) {
                    n7_KhuyenMai_UuDaiBUS.getInstance().getListUuDai_theoTen(Table, TextFieldTimKiem.getText());
                } else if (i == 0) {
                    n7_KhuyenMai_UuDaiBUS.getInstance().getListUuDai_theoMa(Table, TextFieldTimKiem.getText());
                }
            }
        });

        btn_TaiLai.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reset();
            }
        });

        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldMa.setText("");
                // Kiểm tra nếu NgayBatDau là null, nếu có thì gán ngày hiện tại
                Date start = NgayBatDau.getDate();
                if (start == null) {
                    start = java.sql.Date.valueOf("1900-01-01");
                }
                String start_str = Util.LichLam_CaLam.datechooser_cast_dangChuan(start);
                java.sql.Date start_sql = java.sql.Date.valueOf(start_str);

                // Kiểm tra nếu NgayKetThuc là null, nếu có thì gán ngày hiện tại
                Date end = NgayKetThuc.getDate();
                if (end == null) {
                    end = java.sql.Date.valueOf("1900-01-01");
                }
                String end_str = Util.LichLam_CaLam.datechooser_cast_dangChuan(end);
                java.sql.Date end_sql = java.sql.Date.valueOf(end_str);

                float phantram = -1;
                if (!TextFieldPhanTram.getText().isEmpty()) {
                    try {
                        phantram = Float.parseFloat(TextFieldPhanTram.getText());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập số vào phần trăm để tìm mã!");
                        TextFieldPhanTram.requestFocus();
                        return;
                    }
                }

                int tien = -1;
                if (!TextFieldDieuKien.getText().isEmpty()) {
                    try {
                        Double.parseDouble(TextFieldDieuKien.getText()); // Kiểm tra chuyển đổi được sang số không
                        tien = n7_KhuyenMai_UuDaiBUS.getInstance().set_Tien_VND_sang_int(TextFieldDieuKien.getText());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập số vào điều kiện để tìm mã!");
                        TextFieldDieuKien.requestFocus();
                        return;
                    }
                }
                // Thực hiện tìm kiếm với các giá trị đã xử lý
                n7_KhuyenMai_UuDaiBUS.getInstance().search(Table, "", TextFieldTen.getText(), start_sql,
                        end_sql, phantram, tien);
            }

        });

        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldPhanTram.setEditable(false);
                int count = Table.getSelectedRow();
                TableModel model = Table.getModel();

                TextFieldMa.setText(model.getValueAt(count, 0).toString());
                TextFieldTen.setText(model.getValueAt(count, 1).toString());

                String start_Str = model.getValueAt(count, 2).toString();
                String end_Str = model.getValueAt(count, 3).toString();

                Date startDate = n7_KhuyenMai_UuDaiBUS.getInstance().dd_mm_yyyy__to__yyyy_mm_dd(start_Str);
                Date endDate = n7_KhuyenMai_UuDaiBUS.getInstance().dd_mm_yyyy__to__yyyy_mm_dd(end_Str);
                NgayBatDau.setDate(startDate);
                NgayKetThuc.setDate(endDate);

                // Cập nhật các TextField còn lại
                TextFieldPhanTram.setText(model.getValueAt(count, 4).toString());
                TextFieldDieuKien.setText(model.getValueAt(count, 5).toString());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAnhTimKiem;
    private javax.swing.JLabel LabelTenBang;
    private javax.swing.JLabel LabelTieuDe;
    private javax.swing.JLabel LblDieuKien;
    private javax.swing.JLabel LblKhuyenMai;
    private javax.swing.JLabel LblMa;
    private javax.swing.JLabel LblNgayBatDau;
    private javax.swing.JLabel LblNgayKetThuc;
    private javax.swing.JLabel LblPhanTram;
    private javax.swing.JLabel LblTen;
    private javax.swing.JLabel LblUuDai;
    private com.toedter.calendar.JDateChooser NgayBatDau;
    private com.toedter.calendar.JDateChooser NgayKetThuc;
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel PanelKhuyenMai;
    private javax.swing.JPanel PanelThongTinUuDai;
    private javax.swing.JPanel PanelThongTinUuDai_Cam;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JPanel PanelUuDai;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TextFieldDieuKien;
    private javax.swing.JTextField TextFieldMa;
    private javax.swing.JTextField TextFieldPhanTram;
    private javax.swing.JTextField TextFieldTen;
    private javax.swing.JTextField TextFieldTimKiem;
    private javax.swing.JComboBox<String> box;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_TaiLai;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    // End of variables declaration//GEN-END:variables
}
