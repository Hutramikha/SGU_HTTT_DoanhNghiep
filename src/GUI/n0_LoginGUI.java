package GUI;

import BUS.n0_LoginBUS;
import DTO.TaiKhoanDTO;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.JOptionPane;

public class n0_LoginGUI extends javax.swing.JFrame {
    private n0_LoginBUS loginBUS;
    private n0_LoginGUI login;

    public n0_LoginGUI() {
        login = this;
        loginBUS = new n0_LoginBUS();
        initComponents(login);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(n0_LoginGUI login) {

        PanelTong = new javax.swing.JPanel();
        PanelRight = new javax.swing.JPanel();
        PanelLogo = new javax.swing.JPanel();
        LblLogo1 = new javax.swing.JLabel();
        LblLogo2 = new javax.swing.JLabel();
        PanelInput = new javax.swing.JPanel();
        LblTieuDe = new javax.swing.JLabel();
        LblTaiKhoan = new javax.swing.JLabel();
        LblDangNhap = new javax.swing.JLabel();
        TextFieldTaiKhoan = new javax.swing.JTextField();
        PasswordFieldMatKhau = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        PanelNutDangNhap = new javax.swing.JPanel();
        LabelNutDangNhap = new javax.swing.JLabel();
        PanelLeft = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1361, 763));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1361, 763));
        PanelTong.setMinimumSize(new java.awt.Dimension(1361, 763));
        PanelTong.setPreferredSize(new java.awt.Dimension(1361, 763));

        PanelRight.setBackground(new java.awt.Color(255, 255, 255));
        PanelRight.setMaximumSize(new java.awt.Dimension(616, 32767));
        PanelRight.setMinimumSize(new java.awt.Dimension(616, 100));
        PanelRight.setPreferredSize(new java.awt.Dimension(616, 763));

        PanelLogo.setBackground(new java.awt.Color(255, 255, 255));

        LblLogo1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        LblLogo1.setText("CÀ PHÊ SGU");

        LblLogo2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        LblLogo2.setText("XIN CHÀO");

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addComponent(LblLogo1)
                .addGap(0, 50, Short.MAX_VALUE))
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addComponent(LblLogo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addComponent(LblLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LblLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelInput.setBackground(new java.awt.Color(255, 255, 255));
        PanelInput.setForeground(new java.awt.Color(102, 102, 102));

        LblTieuDe.setFont(new java.awt.Font("Segoe UI Semibold", 0, 28)); // NOI18N
        LblTieuDe.setText("ĐĂNG NHẬP");
        LblTieuDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        LblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        LblTaiKhoan.setText("Tài Khoản");

        LblDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        LblDangNhap.setText("Mật Khẩu");

        TextFieldTaiKhoan.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TextFieldTaiKhoan.setForeground(new java.awt.Color(102, 102, 102));
        TextFieldTaiKhoan.setBorder(null);
        TextFieldTaiKhoan.setMaximumSize(new java.awt.Dimension(280, 25));
        TextFieldTaiKhoan.setMinimumSize(new java.awt.Dimension(280, 25));
        TextFieldTaiKhoan.setPreferredSize(new java.awt.Dimension(280, 25));
        // Thêm ActionListener để xử lý sự kiện khi nhấn Enter
        TextFieldTaiKhoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionLogin(login);
            }
        });
        // Thêm ActionListener để xử lý sự kiện khi nhấn Enter
        PasswordFieldMatKhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionLogin(login);
            }
        });

        PasswordFieldMatKhau.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        PasswordFieldMatKhau.setForeground(new java.awt.Color(102, 102, 102));
        PasswordFieldMatKhau.setBorder(null);
        PasswordFieldMatKhau.setMaximumSize(new java.awt.Dimension(280, 25));
        PasswordFieldMatKhau.setMinimumSize(new java.awt.Dimension(280, 25));
        PasswordFieldMatKhau.setPreferredSize(new java.awt.Dimension(280, 25));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        PanelNutDangNhap.setBackground(new java.awt.Color(0, 0, 0));
        PanelNutDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        PanelNutDangNhap.setPreferredSize(new java.awt.Dimension(360, 50));

        LabelNutDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        LabelNutDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelNutDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        LabelNutDangNhap.setText("ĐĂNG NHẬP");

        javax.swing.GroupLayout PanelNutDangNhapLayout = new javax.swing.GroupLayout(PanelNutDangNhap);
        PanelNutDangNhap.setLayout(PanelNutDangNhapLayout);
        PanelNutDangNhapLayout.setHorizontalGroup(
            PanelNutDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNutDangNhapLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(LabelNutDangNhap)
                .addGap(126, 126, 126))
        );
        PanelNutDangNhapLayout.setVerticalGroup(
            PanelNutDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelNutDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelInputLayout = new javax.swing.GroupLayout(PanelInput);
        PanelInput.setLayout(PanelInputLayout);
        PanelInputLayout.setHorizontalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(PanelNutDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelInputLayout.createSequentialGroup()
                                .addComponent(LblTaiKhoan)
                                .addGap(52, 52, 52)
                                .addComponent(LblTieuDe))
                            .addComponent(LblDangNhap)
                            .addComponent(TextFieldTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(PasswordFieldMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        PanelInputLayout.setVerticalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                        .addComponent(LblTieuDe)
                        .addGap(78, 78, 78))
                    .addComponent(LblTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15)
                .addComponent(TextFieldTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(LblDangNhap)
                .addGap(15, 15, 15)
                .addComponent(PasswordFieldMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(PanelNutDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout PanelRightLayout = new javax.swing.GroupLayout(PanelRight);
        PanelRight.setLayout(PanelRightLayout);
        PanelRightLayout.setHorizontalGroup(
            PanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRightLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(PanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelRightLayout.setVerticalGroup(
            PanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRightLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(PanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        PanelLeft.setBackground(new java.awt.Color(122, 74, 74));
        PanelLeft.setMaximumSize(new java.awt.Dimension(739, 763));
        PanelLeft.setMinimumSize(new java.awt.Dimension(739, 763));
        PanelLeft.setPreferredSize(new java.awt.Dimension(739, 763));
        setResizable(false);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/Logo2.png"))); // NOI18N

        javax.swing.GroupLayout PanelLeftLayout = new javax.swing.GroupLayout(PanelLeft);
        PanelLeft.setLayout(PanelLeftLayout);
        PanelLeftLayout.setHorizontalGroup(
            PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLeftLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        PanelLeftLayout.setVerticalGroup(
            PanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelLeft, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void nhomNutChucNang(n0_LoginGUI login) {
        PanelNutDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelNutDangNhap.setBackground(new Color(106, 105, 105));
                LabelNutDangNhap.setOpaque(true);
                LabelNutDangNhap.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelNutDangNhap.setBackground(new Color(0, 0, 0));
                LabelNutDangNhap.setOpaque(true);
                LabelNutDangNhap.setBackground(new Color(0, 0, 0));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionLogin(login);
            }
        });
    }
    public void actionLogin(n0_LoginGUI login) {
        String taiKhoan = String.valueOf(TextFieldTaiKhoan.getText());
        String matKhau = String.valueOf(PasswordFieldMatKhau.getPassword());
        if(taiKhoan.equals("") && matKhau.equals("")) {
            JOptionPane.showMessageDialog(login, "Vui lòng nhập tài khoản và mật khẩu !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(taiKhoan.equals("")) {
            JOptionPane.showMessageDialog(login, "Tài khoản không được để trống !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(matKhau.equals("")) {
            JOptionPane.showMessageDialog(login, "Mật khẩu không được để trống !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        TaiKhoanDTO userLogin = loginBUS.checkLogin(taiKhoan, matKhau);
        //? Check Login ở đây
        if(userLogin != null) {
            if(userLogin.getMaNhanVien() == null) {
                JOptionPane.showMessageDialog(login, "Kết nối với Server thất bại !", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(login, "Đăng nhập thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            login.dispose();
            n0_TrangChuGUI trang_mau = new n0_TrangChuGUI(userLogin);
            trang_mau.setVisible(true);
            trang_mau.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(login, "Sai tài khoản hoặc mật khẩu !", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                n0_LoginGUI login = new n0_LoginGUI();
                login.nhomNutChucNang(login);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNutDangNhap;
    private javax.swing.JLabel LblDangNhap;
    private javax.swing.JLabel LblLogo1;
    private javax.swing.JLabel LblLogo2;
    private javax.swing.JLabel LblTaiKhoan;
    private javax.swing.JLabel LblTieuDe;
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel PanelLeft;
    private javax.swing.JPanel PanelLogo;
    private javax.swing.JPanel PanelNutDangNhap;
    private javax.swing.JPanel PanelRight;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JPasswordField PasswordFieldMatKhau;
    private javax.swing.JTextField TextFieldTaiKhoan;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
