package GUI;

import BUS.BanHangBUS;
import DTO.MonDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class n1_BanHang_ListSanPham extends javax.swing.JPanel {

    private JLabel labelAnh;
    private n1_BanHangKeoTha banHangFrame;

    public n1_BanHang_ListSanPham(ArrayList<MonDTO> ds, n1_BanHangKeoTha banHangFrame) {
        initComponents();
        this.banHangFrame = banHangFrame;
        addSanPham(ds);
    }

    public void check_mon_TrongCart(MonDTO mon) {
        for (int i = 0; i < banHangFrame.listCart.size(); i++) {
            Object[] a = banHangFrame.listCart.get(i);

            if (mon.getMaMon().equals((String) a[0])) {
//                System.out.println(mon.getMaMon());
//                System.out.println((String) a[0] + "");
//                System.out.println("Trùng");
                BanHangBUS.getInstance().update_cong_NguyenLieu(a);
                banHangFrame.TongTien = banHangFrame.TongTien - (int) a[4];
                banHangFrame.listCart.remove(i);
                banHangFrame.displayCart();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        PanelTong = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(689, 426));
        setMinimumSize(new java.awt.Dimension(689, 426));
        setPreferredSize(new java.awt.Dimension(689, 426));

        ScrollPane.setBorder(null);
        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        PanelTong.setBackground(new java.awt.Color(219, 189, 142));
        PanelTong.setMaximumSize(new java.awt.Dimension(687, 32767));
        PanelTong.setMinimumSize(new java.awt.Dimension(687, 100));
        PanelTong.setPreferredSize(new java.awt.Dimension(687, 640));
        PanelTong.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        ScrollPane.setViewportView(PanelTong);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addSanPham(ArrayList<MonDTO> ds) {
        int height_expected = (ds.size() / 4 + 1) * 213;
        PanelTong.setPreferredSize(new Dimension(687, height_expected));

        for (MonDTO mon : ds) {
            String TenMon = mon.getTenMon();
            String DonGiaMon = Util.BanHang.set_Tien_VND(mon.getDonGiaMon());

            // Chỉnh sửa đường dẫn ảnh
            // String basePath = new File("").getAbsolutePath();
            // String Path = basePath + "/src/IMAGE/SanPham/" + mon.getHinhAnh();
            JPanel panelSanPham = new JPanel(new BorderLayout());
            panelSanPham.setBackground(Color.white);
            panelSanPham.setPreferredSize(new Dimension(152, 200));
            panelSanPham.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.GRAY),
                    new EmptyBorder(15, 0, 15, 0) // Padding trên 10px, dưới 10px
            ));

            labelAnh = new JLabel();
            hienThiAnhMon(mon.getHinhAnh());
            // Tải ảnh và thiết lập icon
            // BufferedImage img = Util.BanHang.testLoadImage(Path);
            // if (img != null) {
            //     labelAnh.setIcon(new javax.swing.ImageIcon(img));
            // } else {
            //     labelAnh.setIcon(null);  // Hoặc có thể thêm ảnh mặc định thay thế
            // }
            labelAnh.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel tenMon = new JLabel(TenMon, SwingConstants.CENTER);
            tenMon.setFont(new Font("Arial", Font.BOLD, 15));

            JLabel giaTien = new JLabel(DonGiaMon, SwingConstants.CENTER);
            giaTien.setForeground(new Color(0, 102, 0));

            panelSanPham.add(labelAnh, BorderLayout.NORTH);
            panelSanPham.add(tenMon, BorderLayout.CENTER);
            panelSanPham.add(giaTien, BorderLayout.SOUTH);

            panelSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    check_mon_TrongCart(mon);
                    n1_BanHang_ThongTinMon thongTinMon = new n1_BanHang_ThongTinMon(mon, banHangFrame);
                    thongTinMon.setVisible(true);
                }
            });

            PanelTong.add(panelSanPham);
        }

        PanelTong.revalidate();
        PanelTong.repaint();
    }

    public void hienThiAnhMon(String tenAnh) {
        // Đường dẫn tới hình ảnh
        String linkHinhAnh;
        java.net.URL imgURL;
        ImageIcon imageIcon = null;

        try {
            if (tenAnh == null || tenAnh.isEmpty()) {
                linkHinhAnh = "/IMAGE/Logo2.png"; // Ảnh mặc định
                imgURL = getClass().getResource(linkHinhAnh);
            } else {
                linkHinhAnh = "/IMAGE/SanPham/" + tenAnh;
                imgURL = getClass().getResource(linkHinhAnh);
            }

            if (imgURL != null) {
                imageIcon = new ImageIcon(imgURL);
            } else {
                imageIcon = null; // Đường dẫn ảnh không hợp lệ
            }
        } catch (Exception e) {
            imageIcon = null; // Đặt null nếu có lỗi xảy ra
        }

        if (imageIcon != null) {
            // Kích thước cố định của JLabel
            int labelWidth = 130;
            int labelHeight = 200;

            // Kích thước gốc của ảnh
            int imageWidth = imageIcon.getIconWidth();
            int imageHeight = imageIcon.getIconHeight();

            // Tính toán tỷ lệ thu phóng để giữ nguyên tỷ lệ ảnh
            double widthRatio = (double) labelWidth / imageWidth;
            double heightRatio = (double) labelHeight / imageHeight;
            double scaleFactor = Math.min(widthRatio, heightRatio); // Chọn tỷ lệ nhỏ hơn để ảnh không bị cắt

            int newWidth = (int) (imageWidth * scaleFactor);
            int newHeight = (int) (imageHeight * scaleFactor);

            // Điều chỉnh kích thước ảnh theo tỷ lệ đã tính toán
            Image scaledImage = imageIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);

            // Đặt ImageIcon vào JLabel
            labelAnh.setIcon(imageIcon);
        } else {
            // Nếu không tìm thấy ảnh, đặt JLabel không hiển thị ảnh
            labelAnh.setIcon(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTong;
    private javax.swing.JScrollPane ScrollPane;
    // End of variables declaration//GEN-END:variables
}
