package GUI;

import BUS.n0_LoginBUS;
import DTO.TaiKhoanDTO;
import Util.IconGenerator;
import Util.UIHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;

import javax.swing.JOptionPane;

public class n0_LoginGUI extends javax.swing.JFrame {
    private n0_LoginBUS loginBUS;
    private n0_LoginGUI login;
    private JTextField TextFieldTaiKhoan;
    private JPasswordField PasswordFieldMatKhau;
    private JCheckBox checkShowPassword;

    public n0_LoginGUI() {
        login = this;
        loginBUS = new n0_LoginBUS();
        initComponents(login);
        setTitle("Cà Phê Xanh - Đăng Nhập");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        nhomNutChucNang(login);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents(n0_LoginGUI login) {
        // Create main container with simple, modern design
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Gradient background - dark green theme
                GradientPaint gp = new GradientPaint(
                        0, 0, UIHelper.LIGHTEST_GREEN,
                        0, getHeight(), UIHelper.SURFACE);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setBackground(UIHelper.LIGHTEST_GREEN);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(30, 35, 30, 35));

        // LOGO - Coffee cup with handle
        JPanel logoPanel = new JPanel(new BorderLayout());
        logoPanel.setOpaque(false);
        logoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        logoPanel.setAlignmentX(CENTER_ALIGNMENT);
        JLabel logoLabel = new JLabel(IconGenerator.generateCoffeeIconWithHandle(100, 100));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoPanel.add(logoLabel, BorderLayout.CENTER);
        mainPanel.add(logoPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        // TITLE
        JLabel titleLabel = new JLabel("ĐĂNG NHẬP");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(UIHelper.PRIMARY_GREEN);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        // Form wrapper to center inputs
        JPanel formWrapper = new JPanel();
        formWrapper.setOpaque(false);
        formWrapper.setLayout(new BoxLayout(formWrapper, BoxLayout.Y_AXIS));
        formWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        formWrapper.setAlignmentX(CENTER_ALIGNMENT);

        // USERNAME SECTION
        JPanel userSection = new JPanel();
        userSection.setOpaque(false);
        userSection.setLayout(new BoxLayout(userSection, BoxLayout.Y_AXIS));
        userSection.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        userSection.setAlignmentX(LEFT_ALIGNMENT);

        // USERNAME LABEL
        JLabel userLabel = new JLabel("Tài Khoản");
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        userLabel.setForeground(UIHelper.LIGHT_TEXT);
        userLabel.setAlignmentX(LEFT_ALIGNMENT);
        userSection.add(userLabel);
        userSection.add(Box.createVerticalStrut(5));

        // USERNAME FIELD
        TextFieldTaiKhoan = new JTextField();
        TextFieldTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        TextFieldTaiKhoan.setForeground(UIHelper.DARK_TEXT);
        TextFieldTaiKhoan.setCaretColor(UIHelper.PRIMARY_GREEN);
        TextFieldTaiKhoan.setBorder(new RoundBorder(8, UIHelper.PRIMARY_GREEN));
        TextFieldTaiKhoan.setOpaque(false);
        TextFieldTaiKhoan.setBackground(UIHelper.SURFACE_ALT);
        TextFieldTaiKhoan.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        TextFieldTaiKhoan.setAlignmentX(LEFT_ALIGNMENT);
        TextFieldTaiKhoan.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                TextFieldTaiKhoan.setBorder(new RoundBorder(8, UIHelper.ACCENT_GREEN));
                TextFieldTaiKhoan.setBackground(UIHelper.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                TextFieldTaiKhoan.setBorder(new RoundBorder(8, UIHelper.PRIMARY_GREEN));
                TextFieldTaiKhoan.setBackground(UIHelper.SURFACE_ALT);
            }
        });
        TextFieldTaiKhoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionLogin(login);
            }
        });
        userSection.add(TextFieldTaiKhoan);
        formWrapper.add(userSection);
        formWrapper.add(Box.createVerticalStrut(5));

        // PASSWORD SECTION
        JPanel passSection = new JPanel();
        passSection.setOpaque(false);
        passSection.setLayout(new BoxLayout(passSection, BoxLayout.Y_AXIS));
        passSection.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        passSection.setAlignmentX(LEFT_ALIGNMENT);

        // PASSWORD LABEL
        JLabel passLabel = new JLabel("Mật Khẩu");
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        passLabel.setForeground(UIHelper.LIGHT_TEXT);
        passLabel.setAlignmentX(LEFT_ALIGNMENT);
        passSection.add(passLabel);
        passSection.add(Box.createVerticalStrut(5));

        // PASSWORD FIELD
        PasswordFieldMatKhau = new JPasswordField();
        PasswordFieldMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        PasswordFieldMatKhau.setForeground(UIHelper.DARK_TEXT);
        PasswordFieldMatKhau.setCaretColor(UIHelper.PRIMARY_GREEN);
        PasswordFieldMatKhau.setBorder(new RoundBorder(8, UIHelper.PRIMARY_GREEN));
        PasswordFieldMatKhau.setOpaque(false);
        PasswordFieldMatKhau.setBackground(UIHelper.SURFACE_ALT);
        PasswordFieldMatKhau.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        PasswordFieldMatKhau.setAlignmentX(LEFT_ALIGNMENT);
        PasswordFieldMatKhau.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                PasswordFieldMatKhau.setBorder(new RoundBorder(8, UIHelper.ACCENT_GREEN));
                PasswordFieldMatKhau.setBackground(UIHelper.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                PasswordFieldMatKhau.setBorder(new RoundBorder(8, UIHelper.PRIMARY_GREEN));
                PasswordFieldMatKhau.setBackground(UIHelper.SURFACE_ALT);
            }
        });
        PasswordFieldMatKhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionLogin(login);
            }
        });
        passSection.add(PasswordFieldMatKhau);
        formWrapper.add(passSection);
        formWrapper.add(Box.createVerticalStrut(5));

        // CHECKBOX - Show Password
        checkShowPassword = new JCheckBox("Hiện mật khẩu");
        checkShowPassword.setOpaque(false);
        checkShowPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        checkShowPassword.setForeground(UIHelper.LIGHT_TEXT);
        checkShowPassword.setFocusPainted(false);
        checkShowPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        checkShowPassword.setAlignmentX(LEFT_ALIGNMENT);
        checkShowPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkShowPassword.isSelected()) {
                    PasswordFieldMatKhau.setEchoChar((char) 0);
                } else {
                    PasswordFieldMatKhau.setEchoChar('•');
                }
            }
        });
        formWrapper.add(checkShowPassword);
        formWrapper.add(Box.createVerticalStrut(5));

        mainPanel.add(formWrapper);

        // LOGIN BUTTON
        JButton loginBtn = new JButton("ĐĂNG NHẬP") {
            private GradientPaint gp;

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isPressed()) {
                    g2d.setColor(UIHelper.DARK_GREEN);
                } else if (getModel().isArmed()) {
                    g2d.setColor(UIHelper.PRIMARY_GREEN);
                } else {
                    gp = new GradientPaint(0, 0, UIHelper.PRIMARY_GREEN, 0, getHeight(), UIHelper.ACCENT_GREEN);
                    g2d.setPaint(gp);
                }
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                super.paintComponent(g);
            }
        };
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setBorderPainted(false);
        loginBtn.setFocusPainted(false);
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.setBackground(UIHelper.PRIMARY_GREEN);
        loginBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        loginBtn.setAlignmentX(CENTER_ALIGNMENT);
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginBtn.setBackground(UIHelper.ACCENT_GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginBtn.setBackground(UIHelper.PRIMARY_GREEN);
            }
        });
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionLogin(login);
            }
        });
        mainPanel.add(loginBtn);

        setContentPane(mainPanel);
    }// </editor-fold>//GEN-END:initComponents

    // Custom rounded border class
    private static class RoundBorder extends javax.swing.border.AbstractBorder {
        private int radius;
        private Color color;

        public RoundBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(12, 15, 12, 15);
        }
    }

    public void nhomNutChucNang(n0_LoginGUI login) {
        // Button functionality is now handled in initComponents
    }

    public void actionLogin(n0_LoginGUI login) {
        String taiKhoan = String.valueOf(TextFieldTaiKhoan.getText());
        String matKhau = String.valueOf(PasswordFieldMatKhau.getPassword());
        if (taiKhoan.equals("") && matKhau.equals("")) {
            JOptionPane.showMessageDialog(login, "Vui lòng nhập tài khoản và mật khẩu !", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (taiKhoan.equals("")) {
            JOptionPane.showMessageDialog(login, "Tài khoản không được để trống !", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (matKhau.equals("")) {
            JOptionPane.showMessageDialog(login, "Mật khẩu không được để trống !", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Show a non-modal progress dialog so the worker can actually run.
        JDialog progressDialog = new JDialog(login, "Đăng Nhập", false);
        progressDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        progressDialog.setSize(300, 100);
        progressDialog.setLocationRelativeTo(login);
        progressDialog.setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Đang xử lý đăng nhập...", JLabel.CENTER);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);

        panel.add(label, BorderLayout.CENTER);
        panel.add(progressBar, BorderLayout.SOUTH);
        panel.setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));

        progressDialog.add(panel);

        // Use SwingWorker to perform login on background thread.
        SwingWorker<TaiKhoanDTO, Void> worker = new SwingWorker<TaiKhoanDTO, Void>() {
            @Override
            protected TaiKhoanDTO doInBackground() throws Exception {
                return loginBUS.checkLogin(taiKhoan, matKhau);
            }

            @Override
            protected void done() {
                progressDialog.dispose();
                try {
                    TaiKhoanDTO userLogin = get();
                    if (userLogin != null) {
                        if (userLogin.getMaNhanVien() == null) {
                            JOptionPane.showMessageDialog(login, "Kết nối với Server thất bại !", "Thông báo",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        JOptionPane.showMessageDialog(login, "Đăng nhập thành công !", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                        login.dispose();

                        // Load main GUI on background thread to prevent UI blocking
                        SwingWorker<n0_TrangChuGUI, Void> mainGuiWorker = new SwingWorker<n0_TrangChuGUI, Void>() {
                            @Override
                            protected n0_TrangChuGUI doInBackground() throws Exception {
                                return new n0_TrangChuGUI(userLogin);
                            }

                            @Override
                            protected void done() {
                                try {
                                    n0_TrangChuGUI trang_mau = get();
                                    trang_mau.setVisible(true);
                                    trang_mau.setLocationRelativeTo(null);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Lỗi tải giao diện chính !", "Thông báo",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        };
                        mainGuiWorker.execute();
                    } else {
                        JOptionPane.showMessageDialog(login, "Sai tài khoản hoặc mật khẩu !", "Thông báo",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(login, "Lỗi đăng nhập: " + ex.getMessage(), "Thông báo",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        worker.execute();
        progressDialog.setVisible(true);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                n0_LoginGUI login = new n0_LoginGUI();
                login.nhomNutChucNang(login);
            }
        });
    }
}
