package GUI;

import Util.InputValidator;
import Util.TableCustom;
import Util.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.events.MouseEvent;
import com.toedter.calendar.JDateChooser;
import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.TrangChuBUS;
import DTO.HoaDonDTO;

public class n1_HoaDonGUI extends javax.swing.JPanel {

    public n1_HoaDonGUI(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
        initComponents();
        loadData();
        TableCustom.apply(ScrollPane, TableCustom.TableType.MULTI_LINE);
        nhomNutChucNang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTong = new javax.swing.JPanel();
        PanelHoaDon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelBanHang = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PanelThongTinHoaDon = new javax.swing.JPanel();
        LblTieuDe = new javax.swing.JLabel();
        PanelTimKiemTheoMa = new javax.swing.JPanel();
        LblTimKiemTheoMa = new javax.swing.JLabel();
        LblMaHoaDon = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btn_TaiLai = new javax.swing.JButton();
        btn_TimKiemMa = new javax.swing.JButton();
        PanelTimKiemHoaDon = new javax.swing.JPanel();
        LblTimKiemHoaDon = new javax.swing.JLabel();
        txtGiaTu = new javax.swing.JTextField();
        txtDenGia = new javax.swing.JTextField();
        LblTuNgay = new javax.swing.JLabel();
        LblDenNgay = new javax.swing.JLabel();
        LblGiaTu = new javax.swing.JLabel();
        LblDenGia = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        JDTuNgay = new com.toedter.calendar.JDateChooser();
        JDDenNgay = new com.toedter.calendar.JDateChooser();
        btn_TimKiemNgayTien = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        TblHoaDon = new javax.swing.JTable();
        
        JDTuNgay.setDateFormatString("dd-MM-yyyy");
        JTextField dateEditor = ((JTextField) JDTuNgay.getDateEditor().getUiComponent());
        dateEditor.setBackground(new java.awt.Color(211, 211, 211)); // Nền trắng
        dateEditor.setForeground(new java.awt.Color(0, 0, 0)); // Chữ đen
        dateEditor.setEditable(false);
        dateEditor.setFocusable(false);
        JDTuNgay.setBackground(new java.awt.Color(211, 211, 211));
        
        JDDenNgay.setDateFormatString("dd-MM-yyyy");
        JTextField dateEditor2 = ((JTextField) JDDenNgay.getDateEditor().getUiComponent());
        dateEditor2.setBackground(new java.awt.Color(211, 211, 211)); // Nền trắng
        dateEditor2.setForeground(new java.awt.Color(0, 0, 0)); // Chữ đen
        dateEditor2.setEditable(false);
        dateEditor2.setFocusable(false);
        JDDenNgay.setBackground(new java.awt.Color(211, 211, 211));

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1125, 667));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setPreferredSize(new java.awt.Dimension(1125, 658));

        PanelHoaDon.setBackground(new java.awt.Color(219, 189, 142));
        PanelHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PanelHoaDon.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelHoaDon.setMinimumSize(new java.awt.Dimension(195, 44));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Hóa Đơn");

        javax.swing.GroupLayout PanelHoaDonLayout = new javax.swing.GroupLayout(PanelHoaDon);
        PanelHoaDon.setLayout(PanelHoaDonLayout);
        PanelHoaDonLayout.setHorizontalGroup(
            PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHoaDonLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(61, 61, 61))
        );
        PanelHoaDonLayout.setVerticalGroup(
            PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        PanelBanHang.setBackground(new java.awt.Color(219, 189, 142));
        PanelBanHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PanelBanHang.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelBanHang.setMinimumSize(new java.awt.Dimension(195, 44));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Bán Hàng");

        javax.swing.GroupLayout PanelBanHangLayout = new javax.swing.GroupLayout(PanelBanHang);
        PanelBanHang.setLayout(PanelBanHangLayout);
        PanelBanHangLayout.setHorizontalGroup(
            PanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBanHangLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(55, 55, 55))
        );
        PanelBanHangLayout.setVerticalGroup(
            PanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        PanelThongTinHoaDon.setBackground(new java.awt.Color(219, 189, 142));
        PanelThongTinHoaDon.setEnabled(false);
        PanelThongTinHoaDon.setMaximumSize(new java.awt.Dimension(1113, 553));
        PanelThongTinHoaDon.setMinimumSize(new java.awt.Dimension(1113, 553));

        LblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        LblTieuDe.setText("Thông tin hóa đơn");

        PanelTimKiemTheoMa.setBackground(new java.awt.Color(255, 255, 255));

        LblTimKiemTheoMa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LblTimKiemTheoMa.setForeground(new java.awt.Color(153, 102, 0));
        LblTimKiemTheoMa.setText("Tìm kiếm theo mã");

        LblMaHoaDon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        LblMaHoaDon.setForeground(new java.awt.Color(153, 102, 0));
        LblMaHoaDon.setText("Mã hóa đơn:");

        txtMaHoaDon.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btn_TaiLai.setBackground(new java.awt.Color(0, 0, 0));
        btn_TaiLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_TaiLai.setForeground(new java.awt.Color(255, 255, 255));
        btn_TaiLai.setText("Tải Lại");
        btn_TaiLai.setMaximumSize(new java.awt.Dimension(100, 24));
        btn_TaiLai.setMinimumSize(new java.awt.Dimension(100, 24));
        btn_TaiLai.setPreferredSize(new java.awt.Dimension(100, 24));

        btn_TimKiemMa.setBackground(new java.awt.Color(0, 0, 0));
        btn_TimKiemMa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_TimKiemMa.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiemMa.setLabel("Tìm Kiếm");
        btn_TimKiemMa.setMaximumSize(new java.awt.Dimension(100, 24));
        btn_TimKiemMa.setMinimumSize(new java.awt.Dimension(100, 24));
        btn_TimKiemMa.setPreferredSize(new java.awt.Dimension(100, 24));

        javax.swing.GroupLayout PanelTimKiemTheoMaLayout = new javax.swing.GroupLayout(PanelTimKiemTheoMa);
        PanelTimKiemTheoMa.setLayout(PanelTimKiemTheoMaLayout);
        PanelTimKiemTheoMaLayout.setHorizontalGroup(
            PanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemTheoMaLayout.createSequentialGroup()
                .addGroup(PanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTimKiemTheoMaLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(LblTimKiemTheoMa))
                    .addGroup(PanelTimKiemTheoMaLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(PanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelTimKiemTheoMaLayout.createSequentialGroup()
                                .addComponent(LblMaHoaDon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelTimKiemTheoMaLayout.createSequentialGroup()
                                .addComponent(btn_TimKiemMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btn_TaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        PanelTimKiemTheoMaLayout.setVerticalGroup(
            PanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemTheoMaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblTimKiemTheoMa)
                .addGap(36, 36, 36)
                .addGroup(PanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblMaHoaDon))
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_TimKiemMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        PanelTimKiemHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        LblTimKiemHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LblTimKiemHoaDon.setForeground(new java.awt.Color(153, 102, 0));
        LblTimKiemHoaDon.setText("Tìm kiếm hóa đơn");

        txtGiaTu.setBorder(null);
        txtGiaTu.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        txtGiaTu.setMinimumSize(new java.awt.Dimension(64, 24));
        txtGiaTu.setPreferredSize(new java.awt.Dimension(64, 24));

        txtDenGia.setBorder(null);
        txtDenGia.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        txtDenGia.setMinimumSize(new java.awt.Dimension(64, 24));
        txtDenGia.setPreferredSize(new java.awt.Dimension(64, 24));

        LblTuNgay.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        LblTuNgay.setForeground(new java.awt.Color(153, 102, 0));
        LblTuNgay.setText("Từ ngày:");

        LblDenNgay.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        LblDenNgay.setForeground(new java.awt.Color(153, 102, 0));
        LblDenNgay.setText("Đến ngày:");

        LblGiaTu.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        LblGiaTu.setForeground(new java.awt.Color(153, 102, 0));
        LblGiaTu.setText("Giá từ:");

        LblDenGia.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        LblDenGia.setForeground(new java.awt.Color(153, 102, 0));
        LblDenGia.setText("Đến giá:");

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        btn_TimKiemNgayTien.setBackground(new java.awt.Color(0, 0, 0));
        btn_TimKiemNgayTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_TimKiemNgayTien.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiemNgayTien.setLabel("Tìm Kiếm");
        btn_TimKiemNgayTien.setMaximumSize(new java.awt.Dimension(100, 24));
        btn_TimKiemNgayTien.setMinimumSize(new java.awt.Dimension(100, 24));
        btn_TimKiemNgayTien.setPreferredSize(new java.awt.Dimension(100, 24));
        

        javax.swing.GroupLayout PanelTimKiemHoaDonLayout = new javax.swing.GroupLayout(PanelTimKiemHoaDon);
        PanelTimKiemHoaDon.setLayout(PanelTimKiemHoaDonLayout);
        PanelTimKiemHoaDonLayout.setHorizontalGroup(
            PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemHoaDonLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(LblTimKiemHoaDon)
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(PanelTimKiemHoaDonLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblTuNgay)
                    .addComponent(LblDenNgay)
                    .addComponent(LblGiaTu)
                    .addComponent(LblDenGia))
                .addGap(50, 50, 50)
                .addGroup(PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGiaTu, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(txtDenGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator6)
                    .addComponent(jSeparator4)
                    .addComponent(JDDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JDTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_TimKiemNgayTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTimKiemHoaDonLayout.createSequentialGroup()
                    .addGap(0, 261, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 261, Short.MAX_VALUE)))
        );
        PanelTimKiemHoaDonLayout.setVerticalGroup(
            PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblTimKiemHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemHoaDonLayout.createSequentialGroup()
                        .addGroup(PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JDTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblTuNgay))
                        .addGap(10, 10, 10)
                        .addGroup(PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LblDenNgay, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JDDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_TimKiemNgayTien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LblGiaTu, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(9, 9, 9)
                .addGroup(PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDenGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblDenGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(PanelTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTimKiemHoaDonLayout.createSequentialGroup()
                    .addGap(0, 103, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 104, Short.MAX_VALUE)))
        );

        TblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày lập", "Mã nhân viên", "Mã khuyến mãi", "Mã khách hàng", "Mã ưu đãi", "Tổng tiền"
            }
        ));
        ScrollPane.setViewportView(TblHoaDon);

        javax.swing.GroupLayout PanelThongTinHoaDonLayout = new javax.swing.GroupLayout(PanelThongTinHoaDon);
        PanelThongTinHoaDon.setLayout(PanelThongTinHoaDonLayout);
        PanelThongTinHoaDonLayout.setHorizontalGroup(
            PanelThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelThongTinHoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblTieuDe)
                .addGap(448, 448, 448))
            .addGroup(PanelThongTinHoaDonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollPane)
                    .addGroup(PanelThongTinHoaDonLayout.createSequentialGroup()
                        .addComponent(PanelTimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelTimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelThongTinHoaDonLayout.setVerticalGroup(
            PanelThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThongTinHoaDonLayout.createSequentialGroup()
                .addComponent(LblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelTimKiemTheoMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTimKiemHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(PanelThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(PanelBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(PanelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nhomNutChucNang() {
        PanelBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBanHang.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBanHang.setBackground(new Color(219, 189, 142));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelTong.removeAll();
                n1_BanHangKeoTha bh = new n1_BanHangKeoTha(MaNhanVien);
                PanelTong.setLayout(new BorderLayout());
                PanelTong.add(bh, BorderLayout.CENTER); 
                PanelTong.revalidate();
                PanelTong.repaint();
            }
        });

        btn_TimKiemMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taiLaiGia_Ngay();
                if(validateFields2())
                    TimTheoMa();
            }
        });

        btn_TimKiemNgayTien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(validateFields())
                    TimKiemTheoGiaTien_Date();
            }
        });

        btn_TaiLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taiLai();
                loadData();
            }
        });

        TblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = (int) TblHoaDon.getSelectedRow();
                String MHD = TblHoaDon.getValueAt(TblHoaDon.getSelectedRow(), 0).toString();;
                if (row != -1) {
                    ChiTietHoaDonGUI CTHDGUI = new ChiTietHoaDonGUI(MHD);
                    CTHDGUI.setVisible(true);
                }
            }
        });
    }

    private void taiLaiGia_Ngay(){
        txtDenGia.setText("");
        txtGiaTu.setText("");
        JDDenNgay.setDate(null);
        JDTuNgay.setDate(null);
    }

    private void taiLai(){
        txtDenGia.setText("");
        txtGiaTu.setText("");
        txtMaHoaDon.setText("");
        JDDenNgay.setDate(null);
        JDTuNgay.setDate(null);
    }

    private void TimTheoMa(){
        HDBUS.TimHoaDonTheoMa(TblHoaDon,txtMaHoaDon.getText());
    }
    
    private void TimKiemTheoGiaTien_Date() {
        HDBUS.TimKiemHoaDonTheoNgay_TongTien(JDTuNgay, JDDenNgay,txtGiaTu,txtDenGia,TblHoaDon);
    }

    public boolean validateFields2(){
        String maHoaDon = txtMaHoaDon.getText().trim();

        if (maHoaDon.trim().isEmpty()){
            new dialog("Mã hóa đơn đang để trống, không thể tìm", 1);
            return false;
    }
        if (!maHoaDon.matches("^[a-zA-Z0-9 ]+$")) {
            JOptionPane.showMessageDialog(null, "Mã hóa đơn không được chứa ký tự đặc biệt!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaHoaDon.requestFocus();
            return false;
        }
        return true;
    }

    public boolean validateFields() {
        
        String giaTu = txtGiaTu.getText().trim();
        String denGia = txtDenGia.getText().trim();

        if (!txtGiaTu.getText().equals("") && giaTu.matches("-?\\d+")) {
            int giaTuValue = Integer.parseInt(giaTu);
            if(giaTuValue < 0 ){
                JOptionPane.showMessageDialog(null, "Trường giá từ phải là số lớn hơn hoặc bằng 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if( !giaTu.equals("") && !denGia.equals("")) { 
            if((Integer.parseInt(giaTu)>Integer.parseInt(denGia)) ){
                JOptionPane.showMessageDialog(null, "Trường giá từ phải nhỏ hơn trường giá đến\nVui lòng chọn lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (!txtDenGia.getText().equals("") && giaTu.matches("-?\\d+")) {
            int denGiaValue = Integer.parseInt(denGia);
            if(denGiaValue < 0){
                JOptionPane.showMessageDialog(null, "Trường đến phải là số lớn hơn hoặc bằng 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (JDTuNgay.getDate() != null && JDDenNgay.getDate() != null) {
            if (JDTuNgay.getDate().after(JDDenNgay.getDate())) {
                JOptionPane.showMessageDialog(null, "Từ ngày phải nhỏ hơn hoặc bằng trường Đến ngày\nVui lòng chọn lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (JDTuNgay.getDate() != null ) {
            if (JDTuNgay.getDate().after(new Date())) {
                JOptionPane.showMessageDialog(null, "Ngày được chọn phải nhỏ hơn hoặc bằng ngày hiện tại\nVui lòng chọn lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (JDDenNgay.getDate() != null ) {
            if (JDDenNgay.getDate().after(new Date())) {
                JOptionPane.showMessageDialog(null, "Ngày được chọn phải nhỏ hơn hoặc bằng ngày hiện tại\nVui lòng chọn lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    
    private void loadData(){
        HDBUS.loadData(TblHoaDon);
    }
    private HoaDonBUS HDBUS = new HoaDonBUS();
    private CTHoaDonBUS CTBUS = new CTHoaDonBUS();

    public String MaNhanVien;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDDenNgay;
    private com.toedter.calendar.JDateChooser JDTuNgay;
    private javax.swing.JLabel LblDenGia;
    private javax.swing.JLabel LblDenNgay;
    private javax.swing.JLabel LblGiaTu;
    private javax.swing.JLabel LblMaHoaDon;
    private javax.swing.JLabel LblTieuDe;
    private javax.swing.JLabel LblTimKiemHoaDon;
    private javax.swing.JLabel LblTimKiemTheoMa;
    private javax.swing.JLabel LblTuNgay;
    private javax.swing.JPanel PanelBanHang;
    private javax.swing.JPanel PanelHoaDon;
    private javax.swing.JPanel PanelThongTinHoaDon;
    private javax.swing.JPanel PanelTimKiemHoaDon;
    private javax.swing.JPanel PanelTimKiemTheoMa;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable TblHoaDon;
    private javax.swing.JButton btn_TaiLai;
    private javax.swing.JButton btn_TimKiemMa;
    private javax.swing.JButton btn_TimKiemNgayTien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField txtDenGia;
    private javax.swing.JTextField txtGiaTu;
    private javax.swing.JTextField txtMaHoaDon;
    // End of variables declaration//GEN-END:variables
}
