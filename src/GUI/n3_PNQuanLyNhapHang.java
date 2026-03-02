/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

/**
 *
 * @author as
 */
public class n3_PNQuanLyNhapHang extends javax.swing.JPanel {

    /**
     * Creates new form n3_PNQuanLyNhapHang
     *
     */
    private javax.swing.JLabel selectedLabel; // Biến để theo dõi JLabel nào được chọn

    public n3_PNQuanLyNhapHang(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
        System.out.println("Mã nhân viên lấy được: " + MaNhanVien);
        initComponents();
        nhomNutChucNang();
        jP_NoiDung.removeAll();
        n3_PNNhapHang nhaphang = new n3_PNNhapHang(MaNhanVien);
        jP_NoiDung.setLayout(new BorderLayout());
        jP_NoiDung.add(nhaphang, BorderLayout.CENTER); // Adjust the layout constraint as needed
        jP_NoiDung.revalidate();
        jP_NoiDung.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_NhapHang = new javax.swing.JPanel();
        jP_NhapHang_PhieuNhap = new javax.swing.JPanel();
        jL_NhapHang = new javax.swing.JLabel();
        jL_PhieuNhap = new javax.swing.JLabel();
        jP_NoiDung = new javax.swing.JPanel();

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1125, 667));

        jP_NhapHang.setBackground(new java.awt.Color(255, 255, 255));
        jP_NhapHang.setMaximumSize(new java.awt.Dimension(1125, 658));
        jP_NhapHang.setMinimumSize(new java.awt.Dimension(1125, 658));
        jP_NhapHang.setPreferredSize(new java.awt.Dimension(1125, 658));

        jP_NhapHang_PhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        jP_NhapHang_PhieuNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jP_NhapHang_PhieuNhap.setMaximumSize(new java.awt.Dimension(1100, 28));
        jP_NhapHang_PhieuNhap.setMinimumSize(new java.awt.Dimension(1100, 28));
        jP_NhapHang_PhieuNhap.setName("0"); // NOI18N
        jP_NhapHang_PhieuNhap.setPreferredSize(new java.awt.Dimension(1100, 28));
        jP_NhapHang_PhieuNhap.setLayout(new java.awt.GridLayout(1, 0));

        jL_NhapHang.setBackground(new java.awt.Color(219, 189, 142));
        jL_NhapHang.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jL_NhapHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_NhapHang.setText("Nhập Hàng");
        jL_NhapHang.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jL_NhapHang.setOpaque(true);
        jP_NhapHang_PhieuNhap.add(jL_NhapHang);

        jL_PhieuNhap.setBackground(new java.awt.Color(245, 245, 245));
        jL_PhieuNhap.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jL_PhieuNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_PhieuNhap.setText("Phiếu Nhập");
        jL_PhieuNhap.setOpaque(true);
        jP_NhapHang_PhieuNhap.add(jL_PhieuNhap);

        jP_NoiDung.setMaximumSize(new java.awt.Dimension(1100, 600));
        jP_NoiDung.setMinimumSize(new java.awt.Dimension(1100, 600));
        jP_NoiDung.setPreferredSize(new java.awt.Dimension(1100, 600));

        javax.swing.GroupLayout jP_NoiDungLayout = new javax.swing.GroupLayout(jP_NoiDung);
        jP_NoiDung.setLayout(jP_NoiDungLayout);
        jP_NoiDungLayout.setHorizontalGroup(
            jP_NoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jP_NoiDungLayout.setVerticalGroup(
            jP_NoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jP_NhapHangLayout = new javax.swing.GroupLayout(jP_NhapHang);
        jP_NhapHang.setLayout(jP_NhapHangLayout);
        jP_NhapHangLayout.setHorizontalGroup(
            jP_NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_NhapHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_NhapHang_PhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
                    .addComponent(jP_NoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE))
                .addContainerGap())
        );
        jP_NhapHangLayout.setVerticalGroup(
            jP_NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_NhapHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jP_NhapHang_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_NoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_NhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jP_NhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nhomNutChucNang() {
        selectedLabel = jL_NhapHang; // Mặc định chọn jL_NhapHang

        jL_NhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedLabel != jL_NhapHang) {
                    jL_NhapHang.setOpaque(true);
                    jL_NhapHang.setBackground(new Color(237, 237, 237)); // Màu khi rê chuột vào
                } else {
                    jL_NhapHang.setOpaque(true);
//                jL_NhapHang.setBackground(Color.white); // Màu khi rê chuột vào JLabel đã chọn
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedLabel != jL_NhapHang) {
                    jL_NhapHang.setBackground(Color.white); // Màu mặc định khi kéo chuột ra
                } else {
                    jL_NhapHang.setBackground(new Color(219, 189, 142)); // Màu của JLabel đã chọn
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedLabel = jL_NhapHang;
                jL_NhapHang.setBackground(new Color(219, 189, 142)); // Đặt màu cho JLabel được chọn
                jL_PhieuNhap.setBackground(Color.WHITE); // Đặt lại màu cho JLabel khác

                jP_NoiDung.removeAll();
                n3_PNNhapHang nhaphang = new n3_PNNhapHang(MaNhanVien);
                jP_NoiDung.setLayout(new BorderLayout());
                jP_NoiDung.add(nhaphang, BorderLayout.CENTER);
                jP_NoiDung.revalidate();
                jP_NoiDung.repaint();
            }
        });

        jL_PhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedLabel != jL_PhieuNhap) {
                    jL_PhieuNhap.setOpaque(true);
                    jL_PhieuNhap.setBackground(new Color(237, 237, 237)); // Màu khi rê chuột vào
                } else {
                    jL_PhieuNhap.setOpaque(true);
//                jL_PhieuNhap.setBackground(Color.white); // Màu khi rê chuột vào JLabel đã chọn
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedLabel != jL_PhieuNhap) {
                    jL_PhieuNhap.setBackground(Color.white); // Màu mặc định khi kéo chuột ra
                } else {
                    jL_PhieuNhap.setBackground(new Color(219, 189, 142)); // Màu của JLabel đã chọn
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedLabel = jL_PhieuNhap;
                jL_PhieuNhap.setBackground(new Color(219, 189, 142)); // Đặt màu cho JLabel được chọn
                jL_NhapHang.setBackground(Color.WHITE); // Đặt lại màu cho JLabel khác

                jP_NoiDung.removeAll();
                n3_PNPhieuNhap phieunhap = new n3_PNPhieuNhap();
                jP_NoiDung.setLayout(new BorderLayout());
                jP_NoiDung.add(phieunhap, BorderLayout.CENTER);
                jP_NoiDung.revalidate();
                jP_NoiDung.repaint();
            }
        });
    }
    String MaNhanVien = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jL_NhapHang;
    private javax.swing.JLabel jL_PhieuNhap;
    private javax.swing.JPanel jP_NhapHang;
    private javax.swing.JPanel jP_NhapHang_PhieuNhap;
    private javax.swing.JPanel jP_NoiDung;
    // End of variables declaration//GEN-END:variables
}
