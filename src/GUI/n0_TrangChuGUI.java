package GUI;

import BUS.BanHangBUS;
import BUS.TrangChuBUS;
import BUS.n0_LoginBUS;
import BUS.n0_TrangChuBUS;
import DTO.NhanVienDTO;
import DTO.PhanQuyenDTO;
import DTO.TaiKhoanDTO;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class n0_TrangChuGUI extends javax.swing.JFrame {

    public n0_TrangChuGUI(TaiKhoanDTO userLogin) {
        this.userLogin = userLogin;
        MaNhanVien = userLogin.getMaNhanVien();
        initComponents();
        PanelNoiDung.removeAll();
        banhang = new n1_BanHangKeoTha(userLogin.getMaNhanVien());
        list = banhang.listCart;
        PanelNoiDung.setLayout(new BorderLayout());
        PanelNoiDung.add(banhang, BorderLayout.CENTER); // Adjust the layout constraint as needed
        PanelNoiDung.revalidate();
        PanelNoiDung.repaint();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        PanelTong = new javax.swing.JPanel();
        PanelLogo = new Util.PanelRound();
        LabelCaPheSGU = new javax.swing.JLabel();
        LabelXinChao = new javax.swing.JLabel();
        LabelIcon = new javax.swing.JLabel();
        PanelCalendar = new Util.PanelRound();
        LabelCalendarIcon = new javax.swing.JLabel();
        LabelDate = new javax.swing.JLabel();
        PanelDangXuat = new Util.PanelRound();
        PanelTen = new javax.swing.JLabel();
        ButtonDangXuat = new javax.swing.JButton();
        PanelThongTin = new Util.PanelRound();
        LabelChucVu = new javax.swing.JLabel();
        LabelTen = new javax.swing.JLabel();
        LabelTitle = new javax.swing.JLabel();
        LabelThongTinIcon = new javax.swing.JLabel();
        PanelChucNang = new Util.PanelRound();
        LabelBanHang = new javax.swing.JLabel();
        LabelKhachHang = new javax.swing.JLabel();
        LabelNhapHang = new javax.swing.JLabel();
        LabelMon = new javax.swing.JLabel();
        LabelNguyenLieu = new javax.swing.JLabel();
        LabelLichLam = new javax.swing.JLabel();
        LabelKhuyenMai = new javax.swing.JLabel();
        LabelNhaCungCap = new javax.swing.JLabel();
        LabelNhanVien = new javax.swing.JLabel();
        LabelThongKe = new javax.swing.JLabel();
        PanelNoiDung = new Util.PanelRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PanelTong.setBackground(new java.awt.Color(122, 74, 74));
        PanelTong.setPreferredSize(new java.awt.Dimension(1361, 763));

        PanelLogo.setBackground(new java.awt.Color(219, 189, 142));
        PanelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelLogo.setPreferredSize(new java.awt.Dimension(253, 65));
        PanelLogo.setRoundBottomRight(20);
        PanelLogo.setRoundTopLeft(20);
        PanelLogo.setRoundTopRight(20);
        PanelLogo.setRoundBottomLeft(20);

        LabelCaPheSGU.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LabelCaPheSGU.setText("Cà Phê SGU");

        LabelXinChao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        LabelXinChao.setText("xin chào");

        LabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/Logo.png"))); // NOI18N
        LabelIcon.setText("jLabel3");

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
                PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLogoLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(LabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLogoLayout.createSequentialGroup()
                                                .addComponent(LabelXinChao)
                                                .addGap(52, 52, 52))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLogoLayout.createSequentialGroup()
                                                .addComponent(LabelCaPheSGU)
                                                .addGap(23, 23, 23))))
        );
        PanelLogoLayout.setVerticalGroup(
                PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLogoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelCaPheSGU, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelXinChao)
                                .addContainerGap())
                        .addGroup(PanelLogoLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(LabelIcon)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCalendar.setBackground(new java.awt.Color(219, 189, 142));
        PanelCalendar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelCalendar.setPreferredSize(new java.awt.Dimension(309, 52));
        PanelCalendar.setRoundBottomRight(20);
        PanelCalendar.setRoundTopLeft(20);
        PanelCalendar.setRoundTopRight(20);
        PanelCalendar.setRoundBottomLeft(20);

        LabelCalendarIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/Calendar.png"))); // NOI18N
        LabelCalendarIcon.setText("jLabel2");

        LabelDate.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        LabelDate.setText("Thứ Tư, 25 tháng 09 năm 2024");

        javax.swing.GroupLayout PanelCalendarLayout = new javax.swing.GroupLayout(PanelCalendar);
        PanelCalendar.setLayout(PanelCalendarLayout);
        PanelCalendarLayout.setHorizontalGroup(
                PanelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelCalendarLayout.createSequentialGroup()
                                .addContainerGap(5, Short.MAX_VALUE) // Giảm khoảng cách cạnh trái của PanelCalendar
                                .addComponent(LabelCalendarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10) // Điều chỉnh khoảng cách giữa LabelCalendarIcon và LabelDate
                                .addComponent(LabelDate)
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        PanelCalendarLayout.setVerticalGroup(
                PanelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelCalendarLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(PanelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LabelDate)
                                        .addComponent(LabelCalendarIcon))
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        PanelDangXuat.setBackground(new java.awt.Color(219, 189, 142));
        PanelDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelDangXuat.setPreferredSize(new java.awt.Dimension(390, 54));
        PanelDangXuat.setRoundBottomRight(20);
        PanelDangXuat.setRoundTopLeft(20);
        PanelDangXuat.setRoundTopRight(20);
        PanelDangXuat.setRoundBottomLeft(20);

        PanelTen.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        PanelTen.setText("DƯƠNG VĂN PHƯỚC");

        ButtonDangXuat.setBackground(new java.awt.Color(239, 219, 203));
        ButtonDangXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ButtonDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/DangXuat.png"))); // NOI18N
        ButtonDangXuat.setText(" Đăng Xuất");
        ButtonDangXuat.setAlignmentY(0.0F);
        ButtonDangXuat.setBorder(null);
        ButtonDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ButtonDangXuat.setIconTextGap(10);
        ButtonDangXuat.setPreferredSize(new java.awt.Dimension(138, 28));

        javax.swing.GroupLayout PanelDangXuatLayout = new javax.swing.GroupLayout(PanelDangXuat);
        PanelDangXuat.setLayout(PanelDangXuatLayout);
        PanelDangXuatLayout.setHorizontalGroup(
                PanelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDangXuatLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(PanelTen, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        PanelDangXuatLayout.setVerticalGroup(
                PanelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDangXuatLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(PanelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PanelTen)
                                        .addComponent(ButtonDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        PanelThongTin.setBackground(new java.awt.Color(255, 255, 255));
        PanelThongTin.setPreferredSize(new java.awt.Dimension(172, 159));
        PanelThongTin.setRoundBottomRight(20);
        PanelThongTin.setRoundTopLeft(20);
        PanelThongTin.setRoundTopRight(20);
        PanelThongTin.setRoundBottomLeft(20);

        LabelChucVu.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        LabelChucVu.setText("Quản Lý");

        LabelTen.setText("Dương Văn Phước ");

        LabelTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 13)); // NOI18N
        LabelTitle.setText("Thông tin người dùng");

        LabelThongTinIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/NguoiDung.png"))); // NOI18N

        javax.swing.GroupLayout PanelThongTinLayout = new javax.swing.GroupLayout(PanelThongTin);
        PanelThongTin.setLayout(PanelThongTinLayout);
        PanelThongTinLayout.setHorizontalGroup(
                PanelThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelThongTinLayout.createSequentialGroup()
                                .addGap(20, 20, 20) // Padding bên trái để đẩy các thành phần sang phải
                                .addGroup(PanelThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(LabelTitle)
                                        .addComponent(LabelThongTinIcon)
                                        .addComponent(LabelTen)
                                        .addComponent(LabelChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) // Padding bên phải tự động
        );
        PanelThongTinLayout.setVerticalGroup(
                PanelThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelThongTinLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(LabelTitle)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(LabelThongTinIcon)
                                .addGap(8, 8, 8)
                                .addComponent(LabelTen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelChucVu)
                                .addGap(10, 10, 10))
        );

        PanelChucNang.setBackground(new java.awt.Color(255, 255, 255));
        PanelChucNang.setPreferredSize(new java.awt.Dimension(173, 463));
        PanelChucNang.setRoundBottomRight(20);
        PanelChucNang.setRoundTopLeft(20);
        PanelChucNang.setRoundTopRight(20);
        PanelChucNang.setRoundBottomLeft(20);

        LabelBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/Cart.png"))); // NOI18N
        LabelBanHang.setText("Bán Hàng");
        LabelBanHang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelBanHang.setIconTextGap(15);

        LabelKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/KhachHang.png"))); // NOI18N
        LabelKhachHang.setText("Khách Hàng");
        LabelKhachHang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelKhachHang.setIconTextGap(15);

        LabelNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/NhapHang.png"))); // NOI18N
        LabelNhapHang.setText("Nhập Hàng");
        LabelNhapHang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelNhapHang.setIconTextGap(15);

        LabelMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/CoffeeMug.png"))); // NOI18N
        LabelMon.setText("Món");
        LabelMon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelMon.setIconTextGap(15);

        LabelNguyenLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/NguyenLieu.png"))); // NOI18N
        LabelNguyenLieu.setText("Nguyên Liệu");
        LabelNguyenLieu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelNguyenLieu.setIconTextGap(15);

        LabelLichLam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/LichLam.png"))); // NOI18N
        LabelLichLam.setText("Lịch Làm");
        LabelLichLam.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelLichLam.setIconTextGap(15);

        LabelKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/GiamGia.png"))); // NOI18N
        LabelKhuyenMai.setText("Khuyến Mãi-Ưu Đãi");
        LabelKhuyenMai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelKhuyenMai.setIconTextGap(15);

        LabelNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/NhaCungCap.png"))); // NOI18N
        LabelNhaCungCap.setText("Nhà Cung Cấp");
        LabelNhaCungCap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelNhaCungCap.setIconTextGap(15);

        LabelNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/NhanVien.png"))); // NOI18N
        LabelNhanVien.setText("Nhân Viên");
        LabelNhanVien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelNhanVien.setIconTextGap(15);

        LabelThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/ThongKe.png"))); // NOI18N
        LabelThongKe.setText("Thống Kê");
        LabelThongKe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        LabelThongKe.setIconTextGap(15);

        javax.swing.GroupLayout PanelChucNangLayout = new javax.swing.GroupLayout(PanelChucNang);
        PanelChucNang.setLayout(PanelChucNangLayout);
        PanelChucNangLayout.setHorizontalGroup(
                PanelChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelMon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelLichLam, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        PanelChucNangLayout.setVerticalGroup(
                PanelChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelChucNangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelMon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelLichLam, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(LabelThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addContainerGap())
        );

        PanelNoiDung.setBackground(new java.awt.Color(255, 255, 255));
        PanelNoiDung.setPreferredSize(new java.awt.Dimension(1125, 657));
        PanelNoiDung.setRoundBottomRight(20);
        PanelNoiDung.setRoundTopLeft(20);
        PanelNoiDung.setRoundTopRight(20);
        PanelNoiDung.setRoundBottomLeft(20);

        javax.swing.GroupLayout PanelNoiDungLayout = new javax.swing.GroupLayout(PanelNoiDung);
        PanelNoiDung.setLayout(PanelNoiDungLayout);
        PanelNoiDungLayout.setHorizontalGroup(
                PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1125, Short.MAX_VALUE)
        );
        PanelNoiDungLayout.setVerticalGroup(
                PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 651, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
                PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTongLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelTongLayout.createSequentialGroup()
                                                .addComponent(PanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addComponent(PanelCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                                                .addComponent(PanelDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(25, 25, 25))
                                        .addGroup(PanelTongLayout.createSequentialGroup()
                                                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(PanelChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(PanelNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelTongLayout.setVerticalGroup(
                PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTongLayout.createSequentialGroup()
                                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelTongLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(PanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelTongLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(PanelDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(PanelCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelTongLayout.createSequentialGroup()
                                                .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(PanelChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(PanelNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        nhomNutChucNang();
        pack();
    }

    public void set_ngay() {
        TrangChuBUS.getInstance().hienThi_NgayHienTai(LabelDate);
    }

    public void set_NhanVien(String Ma) {
        NhanVienDTO nv = TrangChuBUS.getInstance().get_NhanVien(Ma);
        LabelTen.setText(nv.getTenNhanVien());
        LabelChucVu.setText(nv.getChucVuNhanVien());
        PanelTen.setText(nv.getTenNhanVien().toUpperCase());
    }

    public void setQuyen() {
        n0_TrangChuBUS bus = new n0_TrangChuBUS();
        phanQuyen = bus.getPhanQuyen(userLogin.getMaNhanVien(), LabelBanHang, LabelKhachHang, LabelNhapHang, LabelMon, LabelNguyenLieu, LabelLichLam, LabelKhuyenMai, LabelNhaCungCap, LabelNhanVien, LabelThongKe);
    }

    private void nhomNutChucNang() {
        set_ngay();
        set_NhanVien(userLogin.getMaNhanVien());
        setQuyen();
        set_NhanVien(userLogin.getMaNhanVien());

        LabelBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenBanHang()) {

                    LabelBanHang.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelBanHang.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenBanHang()) {
                    LabelBanHang.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelBanHang.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenBanHang()) {
                    PanelNoiDung.removeAll();
                    System.out.println(MaNhanVien);
                    n1_BanHangKeoTha banhang = new n1_BanHangKeoTha(MaNhanVien);
                    banhang.listCart = list;
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(banhang, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        });
        LabelKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenKhachHang()) {
                    LabelKhachHang.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelKhachHang.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenKhachHang()) {
                    LabelKhachHang.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelKhachHang.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                if (phanQuyen.getQuyenKhachHang()) {
                    PanelNoiDung.removeAll();
                    n2_KhachHangGUI kh = new n2_KhachHangGUI();
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(kh, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        });
        LabelNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenNhapHang()) {
                    LabelNhapHang.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelNhapHang.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenNhapHang()) {
                    LabelNhapHang.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelNhapHang.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                if (phanQuyen.getQuyenNhapHang()) {
                    PanelNoiDung.removeAll();
                    n3_PNQuanLyNhapHang nhaphang = new n3_PNQuanLyNhapHang(userLogin.getMaNhanVien());
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(nhaphang, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        });
        LabelMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenMon()) {
                    LabelMon.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelMon.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenMon()) {
                    LabelMon.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelMon.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                if (phanQuyen.getQuyenMon()) {
                    PanelNoiDung.removeAll();
                    n4_MonGUI mon = new n4_MonGUI();
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(mon, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        });
        LabelNguyenLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenNguyenLieu()) {
                    LabelNguyenLieu.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelNguyenLieu.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenNguyenLieu()) {
                    LabelNguyenLieu.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelNguyenLieu.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                if (phanQuyen.getQuyenNguyenLieu()) {
                    PanelNoiDung.removeAll();
                    n5_NguyenLieuGUI nl = new n5_NguyenLieuGUI();
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(nl, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        });
        LabelLichLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenLichLam()) {
                    LabelLichLam.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelLichLam.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenLichLam()) {
                    LabelLichLam.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelLichLam.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                if (phanQuyen.getQuyenLichLam()) {
                    PanelNoiDung.removeAll();
                    n6_LichLamGUI lich = new n6_LichLamGUI();
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(lich, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        });
        LabelKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenKhuyenMaiUuDai()) {
                    LabelKhuyenMai.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelKhuyenMai.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenKhuyenMaiUuDai()) {
                    LabelKhuyenMai.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelKhuyenMai.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                if (phanQuyen.getQuyenKhuyenMaiUuDai()) {
                    PanelNoiDung.removeAll();
                    n7_KhuyenMaiGUI km = new n7_KhuyenMaiGUI();
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(km, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        });
        LabelNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenNhaCungCap()) {
                    LabelNhaCungCap.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelNhaCungCap.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenNhaCungCap()) {
                    LabelNhaCungCap.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelNhaCungCap.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                if (phanQuyen.getQuyenNhaCungCap()) {
                    PanelNoiDung.removeAll();
                    n8_NhaCungCapGUI lich = new n8_NhaCungCapGUI();
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(lich, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        }
        );
        LabelNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenNhanVien()) {
                    LabelNhanVien.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelNhanVien.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenNhanVien()) {
                    LabelNhanVien.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelNhanVien.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                if (phanQuyen.getQuyenNhanVien()) {
                    PanelNoiDung.removeAll();
                    n9_NhanVienKeoTha lich = new n9_NhanVienKeoTha();
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(lich, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        }
        );
        LabelThongKe.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenThongKe()) {
                    LabelThongKe.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelThongKe.setBackground(new Color(237, 237, 237));
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (phanQuyen.getQuyenThongKe()) {
                    LabelThongKe.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
                    LabelThongKe.setBackground(Color.white);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                if (phanQuyen.getQuyenThongKe()) {
                    PanelNoiDung.removeAll();
                    n10_ThongkePanel lich = new n10_ThongkePanel();
                    PanelNoiDung.setLayout(new BorderLayout());
                    PanelNoiDung.add(lich, BorderLayout.CENTER); // Adjust the layout constraint as needed
                    PanelNoiDung.revalidate();
                    PanelNoiDung.repaint();
                }
            }
        }
        );

        ButtonDangXuat.addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list = banhang.returnSoLuong(list);

                n0_LoginGUI login = new n0_LoginGUI();
                login.nhomNutChucNang(login);
                dispose();
            }
        }
        );

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        null, "Bạn có chắc chắn muốn thoát?",
                        "Xác nhận thoát", JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    list = banhang.returnSoLuong(list);
                    System.exit(0);
                }
            }
        });

    }

    // Khai báo                    
    private javax.swing.JButton ButtonDangXuat;
    private javax.swing.JLabel LabelBanHang;
    private javax.swing.JLabel LabelCaPheSGU;
    private javax.swing.JLabel LabelCalendarIcon;
    private javax.swing.JLabel LabelChucVu;
    private javax.swing.JLabel LabelDate;
    private javax.swing.JLabel LabelIcon;
    private javax.swing.JLabel LabelKhachHang;
    private javax.swing.JLabel LabelKhuyenMai;
    private javax.swing.JLabel LabelLichLam;
    private javax.swing.JLabel LabelMon;
    private javax.swing.JLabel LabelNguyenLieu;
    private javax.swing.JLabel LabelNhaCungCap;
    private javax.swing.JLabel LabelNhanVien;
    private javax.swing.JLabel LabelNhapHang;
    private javax.swing.JLabel LabelTen;
    private javax.swing.JLabel LabelThongKe;
    private javax.swing.JLabel LabelThongTinIcon;
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JLabel LabelXinChao;
    private Util.PanelRound PanelCalendar;
    private Util.PanelRound PanelChucNang;
    private Util.PanelRound PanelDangXuat;
    private Util.PanelRound PanelLogo;
    private Util.PanelRound PanelNoiDung;
    private javax.swing.JLabel PanelTen;
    private Util.PanelRound PanelThongTin;
    private javax.swing.JPanel PanelTong;
    public String MaNhanVien;
    private PhanQuyenDTO phanQuyen;
    private TaiKhoanDTO userLogin;
    private n1_BanHangKeoTha banhang;
    public ArrayList<Object[]> list = new ArrayList<>();
}
