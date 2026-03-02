package GUI;

import BUS.LichLamBUS;
import DAO.n6_LichLamDAO;
import Util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JTable;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class n6_LichLamGUI extends javax.swing.JPanel {

    public n6_LichLamGUI() {
        initComponents();
        nhomNutChucNang();
        TableCustom.apply(ScrollPane, TableCustom.TableType.MULTI_LINE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTong = new javax.swing.JPanel();
        PanelLichLam = new javax.swing.JPanel();
        LichLam = new javax.swing.JLabel();
        PanelCaLam = new javax.swing.JPanel();
        CaLam = new javax.swing.JLabel();
        PanelInput = new javax.swing.JPanel();
        PanelSua = new javax.swing.JPanel();
        Sua = new javax.swing.JLabel();
        PanelTao = new javax.swing.JPanel();
        Tao = new javax.swing.JLabel();
        PanelXoa = new javax.swing.JPanel();
        Xoa = new javax.swing.JLabel();
        PanelThongTin = new javax.swing.JPanel();
        PanelNoiDungThongTin = new javax.swing.JPanel();
        LabelTieuDe = new javax.swing.JLabel();
        PanelThuocTinh = new javax.swing.JPanel();
        comboboxCaLam = new javax.swing.JComboBox<>();
        LabelNhanVien = new javax.swing.JLabel();
        comboboxNhanVien = new javax.swing.JComboBox<>();
        LabelNgayLam = new javax.swing.JLabel();
        LabelCaLam = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        PanelTaiLai = new javax.swing.JPanel();
        TaiLai = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        PanelThoiGian = new javax.swing.JPanel();
        LabelNgay = new javax.swing.JLabel();
        LabelTenBang = new javax.swing.JLabel();
        PanelTimKiem = new javax.swing.JPanel();
        TextFieldTimKiem = new javax.swing.JTextField();
        datechooserTimKiem = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1125, 667));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setPreferredSize(new java.awt.Dimension(1125, 658));

        PanelLichLam.setBackground(new java.awt.Color(219, 189, 142));
        PanelLichLam.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelLichLam.setMinimumSize(new java.awt.Dimension(195, 44));
        PanelLichLam.setPreferredSize(new java.awt.Dimension(195, 44));
        PanelLichLam.setLayout(new java.awt.GridBagLayout());

        LichLam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LichLam.setText("LỊCH LÀM");
        PanelLichLam.add(LichLam, new java.awt.GridBagConstraints());

        PanelCaLam.setBackground(new java.awt.Color(219, 189, 142));
        PanelCaLam.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        PanelCaLam.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelCaLam.setMinimumSize(new java.awt.Dimension(195, 44));
        PanelCaLam.setPreferredSize(new java.awt.Dimension(195, 44));
        PanelCaLam.setLayout(new java.awt.GridBagLayout());

        CaLam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CaLam.setText("CA LÀM");
        PanelCaLam.add(CaLam, new java.awt.GridBagConstraints());

        PanelInput.setBackground(new java.awt.Color(255, 255, 255));

        PanelSua.setBackground(new java.awt.Color(0, 0, 0));
        PanelSua.setPreferredSize(new java.awt.Dimension(100, 30));

        Sua.setBackground(new java.awt.Color(0, 0, 0));
        Sua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Sua.setForeground(new java.awt.Color(255, 255, 255));
        Sua.setText("Điều Chỉnh");
        Sua.setOpaque(true);

        javax.swing.GroupLayout PanelSuaLayout = new javax.swing.GroupLayout(PanelSua);
        PanelSua.setLayout(PanelSuaLayout);
        PanelSuaLayout.setHorizontalGroup(
            PanelSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSuaLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(Sua)
                .addGap(18, 18, 18))
        );
        PanelSuaLayout.setVerticalGroup(
            PanelSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Sua, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        PanelTao.setBackground(new java.awt.Color(0, 0, 0));
        PanelTao.setPreferredSize(new java.awt.Dimension(237, 30));

        Tao.setBackground(new java.awt.Color(0, 0, 0));
        Tao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Tao.setForeground(new java.awt.Color(255, 255, 255));
        Tao.setText("Tạo Tuần Làm");
        Tao.setOpaque(true);

        javax.swing.GroupLayout PanelTaoLayout = new javax.swing.GroupLayout(PanelTao);
        PanelTao.setLayout(PanelTaoLayout);
        PanelTaoLayout.setHorizontalGroup(
            PanelTaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTaoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Tao))
        );
        PanelTaoLayout.setVerticalGroup(
            PanelTaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTaoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Tao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelXoa.setBackground(new java.awt.Color(0, 0, 0));
        PanelXoa.setPreferredSize(new java.awt.Dimension(100, 30));

        Xoa.setBackground(new java.awt.Color(0, 0, 0));
        Xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Xoa.setForeground(new java.awt.Color(255, 255, 255));
        Xoa.setText("Hủy ca làm");
        Xoa.setOpaque(true);

        javax.swing.GroupLayout PanelXoaLayout = new javax.swing.GroupLayout(PanelXoa);
        PanelXoa.setLayout(PanelXoaLayout);
        PanelXoaLayout.setHorizontalGroup(
            PanelXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelXoaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Xoa))
        );
        PanelXoaLayout.setVerticalGroup(
            PanelXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelXoaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelThongTin.setBackground(new java.awt.Color(219, 189, 142));
        PanelThongTin.setPreferredSize(new java.awt.Dimension(237, 277));

        PanelNoiDungThongTin.setBackground(new java.awt.Color(255, 255, 255));
        PanelNoiDungThongTin.setMinimumSize(new java.awt.Dimension(255, 266));
        PanelNoiDungThongTin.setPreferredSize(new java.awt.Dimension(225, 266));

        LabelTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelTieuDe.setText("Thông Tin Lịch Làm");

        PanelThuocTinh.setBackground(new java.awt.Color(255, 255, 255));

        comboboxCaLam.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        comboboxCaLam.setBorder(null);
        comboboxCaLam.setPreferredSize(new java.awt.Dimension(93, 25));

        LabelNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        LabelNhanVien.setText("Nhân Viên");

        comboboxNhanVien.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        comboboxNhanVien.setBorder(null);
        comboboxNhanVien.setPreferredSize(new java.awt.Dimension(93, 25));

        LabelNgayLam.setBackground(new java.awt.Color(255, 255, 255));
        LabelNgayLam.setText("Ngày");

        LabelCaLam.setBackground(new java.awt.Color(255, 255, 255));
        LabelCaLam.setText("Ca Làm");

        javax.swing.GroupLayout PanelThuocTinhLayout = new javax.swing.GroupLayout(PanelThuocTinh);
        PanelThuocTinh.setLayout(PanelThuocTinhLayout);
        PanelThuocTinhLayout.setHorizontalGroup(
            PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelThuocTinhLayout.createSequentialGroup()
                        .addComponent(LabelNgayLam, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                        .addComponent(LabelNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                        .addComponent(LabelCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelThuocTinhLayout.setVerticalGroup(
            PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCaLam)
                    .addComponent(comboboxCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNhanVien)
                    .addComponent(comboboxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelNgayLam)
                    .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout PanelNoiDungThongTinLayout = new javax.swing.GroupLayout(PanelNoiDungThongTin);
        PanelNoiDungThongTin.setLayout(PanelNoiDungThongTinLayout);
        PanelNoiDungThongTinLayout.setHorizontalGroup(
            PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(LabelTieuDe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91))
        );
        PanelNoiDungThongTinLayout.setVerticalGroup(
            PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LabelTieuDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(PanelThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        PanelThongTin.add(PanelNoiDungThongTin);

        PanelTaiLai.setBackground(new java.awt.Color(0, 0, 0));
        PanelTaiLai.setPreferredSize(new java.awt.Dimension(100, 30));

        TaiLai.setBackground(new java.awt.Color(0, 0, 0));
        TaiLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TaiLai.setForeground(new java.awt.Color(255, 255, 255));
        TaiLai.setText("Tải Lại");
        TaiLai.setOpaque(true);

        javax.swing.GroupLayout PanelTaiLaiLayout = new javax.swing.GroupLayout(PanelTaiLai);
        PanelTaiLai.setLayout(PanelTaiLaiLayout);
        PanelTaiLaiLayout.setHorizontalGroup(
            PanelTaiLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTaiLaiLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(TaiLai)
                .addGap(31, 31, 31))
        );
        PanelTaiLaiLayout.setVerticalGroup(
            PanelTaiLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TaiLai, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelInputLayout = new javax.swing.GroupLayout(PanelInput);
        PanelInput.setLayout(PanelInputLayout);
        PanelInputLayout.setHorizontalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PanelTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(PanelXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelTaiLai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PanelInputLayout.setVerticalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        ScrollPane.setPreferredSize(new java.awt.Dimension(800, 440));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nhân Viên", "T2 (28/11)", "T3 (29/11)", "T4 (30/11)", "T5 (31/11)", "T6 (10/12)", "T7 (10/12)", "CN (10/12)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setRowHeight(50);
        ScrollPane.setViewportView(Table);

        PanelThoiGian.setBackground(new java.awt.Color(239, 219, 203));
        PanelThoiGian.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        LabelNgay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        LabelNgay.setText("10/10/2024 - 17/10/2024");

        javax.swing.GroupLayout PanelThoiGianLayout = new javax.swing.GroupLayout(PanelThoiGian);
        PanelThoiGian.setLayout(PanelThoiGianLayout);
        PanelThoiGianLayout.setHorizontalGroup(
            PanelThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelThoiGianLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(LabelNgay)
                .addGap(57, 57, 57))
        );
        PanelThoiGianLayout.setVerticalGroup(
            PanelThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThoiGianLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelNgay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LabelTenBang.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        LabelTenBang.setText("LỊCH LÀM");

        PanelTimKiem.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem.setMaximumSize(new java.awt.Dimension(161, 32));
        PanelTimKiem.setMinimumSize(new java.awt.Dimension(161, 32));
        PanelTimKiem.setPreferredSize(new java.awt.Dimension(161, 32));

        TextFieldTimKiem.setBackground(new java.awt.Color(241, 240, 240));
        TextFieldTimKiem.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        TextFieldTimKiem.setText("Tìm tuần theo ngày");
        TextFieldTimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TextFieldTimKiem.setDisabledTextColor(new java.awt.Color(0, 102, 0));
        TextFieldTimKiem.setEnabled(false);
        TextFieldTimKiem.setMaximumSize(new java.awt.Dimension(130, 18));
        TextFieldTimKiem.setMinimumSize(new java.awt.Dimension(130, 18));
        TextFieldTimKiem.setPreferredSize(new java.awt.Dimension(130, 18));

        datechooserTimKiem.setPreferredSize(new java.awt.Dimension(20, 22));

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(TextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(datechooserTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datechooserTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(PanelLichLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(PanelCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                                .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PanelThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelTenBang)
                .addGap(469, 469, 469))
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelLichLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(LabelTenBang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelThoiGian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
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
    private void combobox_TenCaLam() {

        ArrayList<String> list = n6_LichLamDAO.getInstance().combobox_TenCaLam();
        for (String ca : list) {
            comboboxCaLam.addItem(ca);
        }
    }

    private void combobox_TenNhanVien() {

        ArrayList<String> list = n6_LichLamDAO.getInstance().combobox_TenNhanVien();
        for (String nv : list) {
            comboboxNhanVien.addItem(nv);
        }
    }

    public void setHeader(JTable table, String date) {
        List<String> headers = Util.LichLam_CaLam.getWeekHeaders(date);
        String[] columnNames = headers.toArray(new String[0]);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(columnNames);
    }

    public void getData(JTable table, String date) {
        setHeader(table, date);
        java.sql.Date Date = java.sql.Date.valueOf(date);
        String thu2 = Util.LichLam_CaLam.thu2(Date);
        LichLamBUS.getInstance().data(table, thu2);
        LichLamBUS.getInstance().hienThi_NgayHienTai(LabelNgay);
    }

    public void nhomNutChucNang() {
        getData(Table, now);

        combobox_TenCaLam();
        combobox_TenNhanVien();
        PanelCaLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelCaLam.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelCaLam.setBackground(new Color(219, 189, 142));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelTong.removeAll();
                n6_CaLamKeoTha ca = new n6_CaLamKeoTha();
                PanelTong.setLayout(new BorderLayout());
                PanelTong.add(ca, BorderLayout.CENTER); // Adjust the layout constraint as needed
                PanelTong.revalidate();
                PanelTong.repaint();
            }
        });
        PanelLichLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelLichLam.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelLichLam.setBackground(new Color(219, 189, 142));
            }
        });

        PanelTao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelTao.setBackground(new Color(106, 105, 105));
                Tao.setOpaque(true);
                Tao.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelTao.setBackground(new Color(0, 0, 0));
                Tao.setOpaque(true);
                Tao.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (datechooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bất kỳ trong tuần làm để tạo tuần làm !", "FAIL", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Date selectedDate = datechooser.getDate();
                String Ngay_formatted = Util.LichLam_CaLam.datechooser_cast_dangChuan(selectedDate);
                String Ngay_TimKiem = Util.LichLam_CaLam.yyyy_mm_dd__to__dd_mm_yyyy(Ngay_formatted);
                Date currentDate = new Date();

                if (selectedDate.before(currentDate)) {
                    JOptionPane.showMessageDialog(null, "Không thể tạo lịch làm cho ngày trong quá khứ!", "FAIL", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn tạo lich làm tuần không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    boolean i = LichLamBUS.getInstance().Khoi_tao_ngay_lam(Ngay_formatted);
                    if (i) {
                        getData(Table, Ngay_formatted);
                        LabelNgay.setText(LichLamBUS.getInstance().TimKiem(Ngay_TimKiem));
                    }
                }
            }
        });
        PanelSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelSua.setBackground(new Color(106, 105, 105));
                Sua.setOpaque(true);
                Sua.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelSua.setBackground(new Color(0, 0, 0));
                Sua.setOpaque(true);
                Sua.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Date selectedDate = datechooser.getDate();
                if (datechooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày để điều chỉnh lịch làm !", "FAIL", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Date currentDate = new Date();

                if (selectedDate.before(currentDate)) {
                    JOptionPane.showMessageDialog(null, "Không thể điều chỉnh lịch làm cho ngày trong quá khứ!", "FAIL", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String Ngay_formatted = Util.LichLam_CaLam.datechooser_cast_dangChuan(selectedDate);

                String TenCa = (String) comboboxCaLam.getSelectedItem();

                String TenNhanVien = (String) comboboxNhanVien.getSelectedItem();

                String Ngay_TimKiem = Util.LichLam_CaLam.yyyy_mm_dd__to__dd_mm_yyyy(Ngay_formatted);

                LichLamBUS.getInstance().Dieu_chinh(TenCa, TenNhanVien, Ngay_formatted);

                getData(Table, Ngay_formatted);
                LabelNgay.setText(LichLamBUS.getInstance().TimKiem(Ngay_TimKiem));
            }
        });

        PanelXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelXoa.setBackground(new Color(106, 105, 105));
                Xoa.setOpaque(true);
                Xoa.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelXoa.setBackground(new Color(0, 0, 0));
                Xoa.setOpaque(true);
                Xoa.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Date selectedDate = datechooser.getDate();
                if (datechooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày để tắt ca làm !", "FAIL", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Date currentDate = new Date();

                if (selectedDate.before(currentDate)) {
                    JOptionPane.showMessageDialog(null, "Không thể sửa ca làm cho ngày trong quá khứ!", "FAIL", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String Ngay_formatted = Util.LichLam_CaLam.datechooser_cast_dangChuan(selectedDate);

                String TenNhanVien = (String) comboboxNhanVien.getSelectedItem();

                String Ngay_TimKiem = Util.LichLam_CaLam.yyyy_mm_dd__to__dd_mm_yyyy(Ngay_formatted);

                LichLamBUS.getInstance().Xoa(TenNhanVien, Ngay_formatted);
                getData(Table, Ngay_formatted);
                LabelNgay.setText(LichLamBUS.getInstance().TimKiem(Ngay_TimKiem));
            }
        });

        TextFieldTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    String Ngay_String = TextFieldTimKiem.getText();
                    String period = LichLamBUS.getInstance().TimKiem(Ngay_String);
                    String ngay = Util.LichLam_CaLam.dd_mm_yyyy__to__yyyy_mm_dd(Ngay_String);
                    getData(Table, ngay);
                    LabelNgay.setText(period);
                }
            }
        });

        datechooserTimKiem.getDateEditor().addPropertyChangeListener("date", evt -> {
            if (datechooserTimKiem.getDate() != null) {
                String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(datechooserTimKiem.getDate());
                TextFieldTimKiem.setText(formattedDate);
//                String Ngay_String = TextFieldTimKiem.getText();
                String period = LichLamBUS.getInstance().TimKiem(formattedDate);
                String ngay = Util.LichLam_CaLam.dd_mm_yyyy__to__yyyy_mm_dd(formattedDate);
                getData(Table, ngay);
                LabelNgay.setText(period);
            }
        });

        PanelTaiLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelTaiLai.setBackground(new Color(106, 105, 105));
                TaiLai.setOpaque(true);
                TaiLai.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelTaiLai.setBackground(new Color(0, 0, 0));
                TaiLai.setOpaque(true);
                TaiLai.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldTimKiem.setText("");
                datechooser.setDate(null);
//                LichLamBUS.getInstance().data(Table, now);
                TextFieldTimKiem.setText("Tìm tuần theo ngày");
                getData(Table, now);
            }
        });

    }

    private String now = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CaLam;
    private javax.swing.JLabel LabelCaLam;
    private javax.swing.JLabel LabelNgay;
    private javax.swing.JLabel LabelNgayLam;
    private javax.swing.JLabel LabelNhanVien;
    private javax.swing.JLabel LabelTenBang;
    private javax.swing.JLabel LabelTieuDe;
    private javax.swing.JLabel LichLam;
    private javax.swing.JPanel PanelCaLam;
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel PanelLichLam;
    private javax.swing.JPanel PanelNoiDungThongTin;
    private javax.swing.JPanel PanelSua;
    private javax.swing.JPanel PanelTaiLai;
    private javax.swing.JPanel PanelTao;
    private javax.swing.JPanel PanelThoiGian;
    private javax.swing.JPanel PanelThongTin;
    private javax.swing.JPanel PanelThuocTinh;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JPanel PanelXoa;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JLabel Sua;
    private javax.swing.JTable Table;
    private javax.swing.JLabel TaiLai;
    private javax.swing.JLabel Tao;
    private javax.swing.JTextField TextFieldTimKiem;
    private javax.swing.JLabel Xoa;
    private javax.swing.JComboBox<String> comboboxCaLam;
    private javax.swing.JComboBox<String> comboboxNhanVien;
    private com.toedter.calendar.JDateChooser datechooser;
    private com.toedter.calendar.JDateChooser datechooserTimKiem;
    // End of variables declaration//GEN-END:variables
}
