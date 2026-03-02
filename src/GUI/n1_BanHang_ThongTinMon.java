package GUI;

import BUS.BanHangBUS;
import DTO.MonDTO;
import java.awt.Color;

public class n1_BanHang_ThongTinMon extends javax.swing.JFrame {

    private n1_BanHangKeoTha banHangFrame;

    public n1_BanHang_ThongTinMon(MonDTO mon, n1_BanHangKeoTha banHangFrame) {
        initComponents();
        this.banHangFrame = banHangFrame;
        Mon = mon;
        set_info(mon);
        nhomNutChucNang();
        setLocationRelativeTo(null);
    }

    private void set_info(MonDTO mon) {
        Ma.setText(mon.getMaMon());
        TenMon.setText(mon.getTenMon());
        String tenLoaiMon = BanHangBUS.getInstance().getTenLoaiMon_theo_MaLoaiMon(mon.getMaLoaiMon());
        Loai.setText(tenLoaiMon);
        Gia.setText(Util.BanHang.set_Tien_VND(mon.getDonGiaMon()));
        int sl = BanHangBUS.getInstance().tinh_SoLuong_MonCon(mon.getMaMon());
        SoLuong.setText(sl + "");

    }

    private void xacNhanHandler() {
        String ma = Ma.getText();
        String ten = TenMon.getText();
        int donGia = Mon.getDonGiaMon();
        String soLuong = SL.getText();
        String soLuong_kho = SoLuong.getText();
        int i = BanHangBUS.getInstance().check_Sl(soLuong, soLuong_kho);
        if (i == 1) {
            int thanhTien = Mon.getDonGiaMon() * Integer.parseInt(soLuong);
            banHangFrame.TongTien += thanhTien;
            int soLuongInt = Integer.parseInt(soLuong);

            Object[] cthd = new Object[]{ma, ten, donGia, soLuongInt, thanhTien};
            banHangFrame.addCart(cthd);

            BanHangBUS.getInstance().update_tru_NguyenLieu(cthd);

            dispose();
        } else if (i == 2) {
            SL.requestFocus();
            SL.setText(soLuong_kho);
        } else if (i == 0 || i == 3) {
            SL.setText("");
            SL.requestFocus();
        }
    }

    private void nhomNutChucNang() {
        huyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // Đóng JFrame hiện tại
            }
        });

        huyBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                huyBtn1.setBackground(new Color(255, 102, 102));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                huyBtn1.setBackground(new Color(255, 51, 51));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // Đóng JFrame hiện tại
            }
        });

        xacNhanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xacNhanHandler();
            }
        });

        SL.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacNhanHandler();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelKhung = new javax.swing.JPanel();
        PanelNoiDung = new javax.swing.JPanel();
        PanelTenDauVao = new javax.swing.JPanel();
        LabelMa = new javax.swing.JLabel();
        LabelLoaiMon = new javax.swing.JLabel();
        LabelTen = new javax.swing.JLabel();
        LabelDonGia = new javax.swing.JLabel();
        LabelSoLuong = new javax.swing.JLabel();
        LabelSoLuong1 = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        PanelDauVao = new javax.swing.JPanel();
        Ma = new javax.swing.JLabel();
        Loai = new javax.swing.JLabel();
        TenMon = new javax.swing.JLabel();
        Gia = new javax.swing.JLabel();
        SoLuong = new javax.swing.JLabel();
        SL = new javax.swing.JTextField();
        line = new javax.swing.JSeparator();
        xacNhanBtn = new javax.swing.JButton();
        huyBtn = new javax.swing.JButton();
        huyBtn1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(219, 195, 165));
        setMaximumSize(new java.awt.Dimension(352, 490));
        setMinimumSize(new java.awt.Dimension(352, 490));
        setUndecorated(true);
        setResizable(false);

        PanelKhung.setBackground(new java.awt.Color(122, 74, 74));
        PanelKhung.setMaximumSize(new java.awt.Dimension(352, 392));
        PanelKhung.setMinimumSize(new java.awt.Dimension(352, 392));
        PanelKhung.setPreferredSize(new java.awt.Dimension(352, 490));

        PanelNoiDung.setBackground(new java.awt.Color(255, 255, 255));
        PanelNoiDung.setMaximumSize(new java.awt.Dimension(340, 478));
        PanelNoiDung.setMinimumSize(new java.awt.Dimension(340, 478));
        PanelNoiDung.setPreferredSize(new java.awt.Dimension(340, 478));

        PanelTenDauVao.setBackground(new java.awt.Color(255, 255, 255));
        PanelTenDauVao.setLayout(new java.awt.GridLayout(6, 0, 0, 30));

        LabelMa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        LabelMa.setText("Mã");
        PanelTenDauVao.add(LabelMa);

        LabelLoaiMon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        LabelLoaiMon.setText("Loại Món");
        PanelTenDauVao.add(LabelLoaiMon);

        LabelTen.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        LabelTen.setText("Tên Món");
        PanelTenDauVao.add(LabelTen);

        LabelDonGia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        LabelDonGia.setText("Đơn Giá");
        PanelTenDauVao.add(LabelDonGia);

        LabelSoLuong.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        LabelSoLuong.setText("Số Lượng Còn");
        PanelTenDauVao.add(LabelSoLuong);

        LabelSoLuong1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        LabelSoLuong1.setText("Nhập Số Lượng");
        PanelTenDauVao.add(LabelSoLuong1);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setText("THÔNG TIN MÓN ĂN");

        PanelDauVao.setBackground(new java.awt.Color(255, 255, 255));
        PanelDauVao.setLayout(new java.awt.GridLayout(6, 0, 0, 30));

        Ma.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Ma.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Ma.setText("Mã");
        PanelDauVao.add(Ma);

        Loai.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Loai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Loai.setText("Tên");
        PanelDauVao.add(Loai);

        TenMon.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TenMon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TenMon.setText("Số Lượng");
        PanelDauVao.add(TenMon);

        Gia.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Gia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Gia.setText("Đơn Giá");
        PanelDauVao.add(Gia);

        SoLuong.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        SoLuong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        SoLuong.setText("20");
        PanelDauVao.add(SoLuong);

        SL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        SL.setBorder(null);
        PanelDauVao.add(SL);

        line.setForeground(new java.awt.Color(0, 0, 0));

        xacNhanBtn.setBackground(new java.awt.Color(51, 51, 51));
        xacNhanBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        xacNhanBtn.setForeground(new java.awt.Color(255, 255, 255));
        xacNhanBtn.setText("Xác Nhận");
        xacNhanBtn.setMaximumSize(new java.awt.Dimension(90, 25));
        xacNhanBtn.setMinimumSize(new java.awt.Dimension(90, 25));
        xacNhanBtn.setPreferredSize(new java.awt.Dimension(90, 25));

        huyBtn.setBackground(new java.awt.Color(255, 51, 51));
        huyBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        huyBtn.setForeground(new java.awt.Color(255, 255, 255));
        huyBtn.setText("Hủy");
        huyBtn.setMaximumSize(new java.awt.Dimension(90, 25));
        huyBtn.setMinimumSize(new java.awt.Dimension(90, 25));
        huyBtn.setPreferredSize(new java.awt.Dimension(90, 25));

        huyBtn1.setBackground(new java.awt.Color(255, 51, 51));
        huyBtn1.setMaximumSize(new java.awt.Dimension(28, 28));
        huyBtn1.setPreferredSize(new java.awt.Dimension(28, 28));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("x");
        jLabel1.setPreferredSize(new java.awt.Dimension(8, 14));
        huyBtn1.add(jLabel1);

        javax.swing.GroupLayout PanelNoiDungLayout = new javax.swing.GroupLayout(PanelNoiDung);
        PanelNoiDung.setLayout(PanelNoiDungLayout);
        PanelNoiDungLayout.setHorizontalGroup(
            PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungLayout.createSequentialGroup()
                .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNoiDungLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Title)
                            .addGroup(PanelNoiDungLayout.createSequentialGroup()
                                .addComponent(PanelTenDauVao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PanelDauVao, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(line, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelNoiDungLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(xacNhanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(huyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNoiDungLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(huyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelNoiDungLayout.setVerticalGroup(
            PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungLayout.createSequentialGroup()
                .addComponent(huyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Title)
                .addGap(40, 40, 40)
                .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelTenDauVao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelDauVao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xacNhanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(huyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        PanelKhung.add(PanelNoiDung);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelKhung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelKhung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private MonDTO Mon;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Gia;
    private javax.swing.JLabel LabelDonGia;
    private javax.swing.JLabel LabelLoaiMon;
    private javax.swing.JLabel LabelMa;
    private javax.swing.JLabel LabelSoLuong;
    private javax.swing.JLabel LabelSoLuong1;
    private javax.swing.JLabel LabelTen;
    private javax.swing.JLabel Loai;
    private javax.swing.JLabel Ma;
    private javax.swing.JPanel PanelDauVao;
    private javax.swing.JPanel PanelKhung;
    private javax.swing.JPanel PanelNoiDung;
    private javax.swing.JPanel PanelTenDauVao;
    private javax.swing.JTextField SL;
    private javax.swing.JLabel SoLuong;
    private javax.swing.JLabel TenMon;
    private javax.swing.JLabel Title;
    private javax.swing.JButton huyBtn;
    private javax.swing.JPanel huyBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator line;
    private javax.swing.JButton xacNhanBtn;
    // End of variables declaration//GEN-END:variables
}
