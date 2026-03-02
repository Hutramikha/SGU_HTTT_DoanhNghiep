package GUI;

import BUS.BanHangBUS;
import DTO.KhachHangDTO;
import Util.TableCustom;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class n1_BanHang_ThanhToan_chonKhachHang extends javax.swing.JFrame {

    private n1_BanHang_ThanhToan thanhToanFrame;

    public n1_BanHang_ThanhToan_chonKhachHang(n1_BanHang_ThanhToan frame) {
        this.thanhToanFrame = frame;
        initComponents();
        setLocationRelativeTo(null);
        TableCustom.apply(ScrollPane, TableCustom.TableType.MULTI_LINE);
        nhomNutChucNang();
    }

    private void showData_KhachHang() {
        BanHangBUS.getInstance().showData_KhachHang(Table);
    }

    private void TaiLai() {
        showData_KhachHang();
        TimKiem.setText("");
        TextFieldTen.setText("");
        TextFieldSDT.setText("");
        jDNgaySinh.setDate(null);
        ComboBoxGioiTinh.setSelectedIndex(0);
    }

    private void nhomNutChucNang() {
        TextFieldMa.setEditable(false);
        TextFieldMa.setText(BanHangBUS.getInstance().getMa());
        showData_KhachHang();
        huyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
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

        xacNhanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = Table.getSelectedRow();
                TableModel model = Table.getModel();

                if (count == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn khách hàng trước khi xác nhận !");
                    return;
                }
                String maKhachHang = model.getValueAt(count, 0) + "";
//                System.out.println("Mã khách hàng: " + model.getValueAt(count, 0));
                thanhToanFrame.set_info_khachHang(maKhachHang);
                KhachHangDTO kh = BanHangBUS.getInstance().get_khachHang_theoMa(maKhachHang);
                thanhToanFrame.set_UuDaiThanhVien(kh.getChiTieuKhachHang());
//                System.out.println("Chi tiêu thật: " + kh.getChiTieuKhachHang());
                dispose();
            }
        });

        TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    BanHangBUS.getInstance().showData_KhachHang_theoTen(Table, TimKiem.getText());
                }
            }
        });

        TaiLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaiLai();
            }
        });

        Them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BanHangBUS.getInstance().insert_KhachHang(TextFieldMa, TextFieldTen, TextFieldSDT, ComboBoxGioiTinh, jDNgaySinh, Table);
//                showData_KhachHang();
//                TaiLai();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelKhung = new javax.swing.JPanel();
        PanelNoiDung = new javax.swing.JPanel();
        PanelTool = new javax.swing.JPanel();
        PanelTimKiem = new javax.swing.JPanel();
        TimKiem = new javax.swing.JTextField();
        LabelAnhTimKiem = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        xacNhanBtn = new javax.swing.JButton();
        huyBtn = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        PanelThongTin = new javax.swing.JPanel();
        PanelNoiDungThongTin = new javax.swing.JPanel();
        LabelTieuDe = new javax.swing.JLabel();
        PanelThuocTinh = new javax.swing.JPanel();
        LblMa = new javax.swing.JLabel();
        TextFieldMa = new javax.swing.JTextField();
        LblTen = new javax.swing.JLabel();
        TextFieldTen = new javax.swing.JTextField();
        LblSDT = new javax.swing.JLabel();
        TextFieldSDT = new javax.swing.JTextField();
        LblGioiTinh = new javax.swing.JLabel();
        ComboBoxGioiTinh = new javax.swing.JComboBox<>();
        LblNgaySinh = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jDNgaySinh = new com.toedter.calendar.JDateChooser();
        Them = new javax.swing.JButton();
        TaiLai = new javax.swing.JButton();
        huyBtn1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        PanelKhung.setBackground(new java.awt.Color(122, 74, 74));
        PanelKhung.setMaximumSize(new java.awt.Dimension(870, 490));
        PanelKhung.setMinimumSize(new java.awt.Dimension(870, 490));
        PanelKhung.setPreferredSize(new java.awt.Dimension(870, 490));

        PanelNoiDung.setBackground(new java.awt.Color(255, 255, 255));
        PanelNoiDung.setMaximumSize(new java.awt.Dimension(858, 478));
        PanelNoiDung.setMinimumSize(new java.awt.Dimension(858, 478));
        PanelNoiDung.setPreferredSize(new java.awt.Dimension(858, 478));

        PanelTool.setBackground(new java.awt.Color(255, 255, 255));
        PanelTool.setMaximumSize(new java.awt.Dimension(50, 50));
        PanelTool.setMinimumSize(new java.awt.Dimension(50, 50));
        PanelTool.setPreferredSize(new java.awt.Dimension(50, 50));

        PanelTimKiem.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem.setMaximumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setMinimumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setPreferredSize(new java.awt.Dimension(270, 32));

        TimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        LabelAnhTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelAnhTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search.png"))); // NOI18N

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(LabelAnhTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelAnhTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TimKiem))
                .addGap(4, 4, 4))
        );

        PanelTool.add(PanelTimKiem);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Danh sách khách hàng");

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

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Số điện thoại", "Ngày sinh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPane.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        PanelThongTin.setBackground(new java.awt.Color(219, 189, 142));
        PanelThongTin.setMaximumSize(new java.awt.Dimension(296, 312));
        PanelThongTin.setMinimumSize(new java.awt.Dimension(296, 312));
        PanelThongTin.setPreferredSize(new java.awt.Dimension(296, 312));

        PanelNoiDungThongTin.setBackground(new java.awt.Color(255, 255, 255));
        PanelNoiDungThongTin.setMaximumSize(new java.awt.Dimension(284, 300));
        PanelNoiDungThongTin.setMinimumSize(new java.awt.Dimension(284, 300));
        PanelNoiDungThongTin.setPreferredSize(new java.awt.Dimension(284, 300));

        LabelTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelTieuDe.setText("Thông Tin Khách Hàng");

        PanelThuocTinh.setBackground(new java.awt.Color(255, 255, 255));

        LblMa.setBackground(new java.awt.Color(255, 255, 255));
        LblMa.setText("Mã KH");

        TextFieldMa.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        TextFieldMa.setForeground(new java.awt.Color(51, 0, 255));
        TextFieldMa.setBorder(null);
        TextFieldMa.setPreferredSize(new java.awt.Dimension(150, 16));

        LblTen.setBackground(new java.awt.Color(255, 255, 255));
        LblTen.setText("Tên KH");

        TextFieldTen.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TextFieldTen.setBorder(null);

        LblSDT.setBackground(new java.awt.Color(255, 255, 255));
        LblSDT.setText("Số Điện Thoại");

        TextFieldSDT.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TextFieldSDT.setBorder(null);

        LblGioiTinh.setBackground(new java.awt.Color(255, 255, 255));
        LblGioiTinh.setText("Giới Tính");

        ComboBoxGioiTinh.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        ComboBoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn giới tính", "Nam", "Nữ" }));
        ComboBoxGioiTinh.setBorder(null);
        ComboBoxGioiTinh.setPreferredSize(new java.awt.Dimension(93, 25));

        LblNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        LblNgaySinh.setText("Ngày Sinh");

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator1.setMaximumSize(new java.awt.Dimension(93, 5));
        jSeparator1.setMinimumSize(new java.awt.Dimension(93, 5));
        jSeparator1.setPreferredSize(new java.awt.Dimension(93, 5));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setMaximumSize(new java.awt.Dimension(93, 5));
        jSeparator2.setMinimumSize(new java.awt.Dimension(93, 5));
        jSeparator2.setPreferredSize(new java.awt.Dimension(93, 5));

        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator3.setMaximumSize(new java.awt.Dimension(93, 5));
        jSeparator3.setMinimumSize(new java.awt.Dimension(93, 5));
        jSeparator3.setPreferredSize(new java.awt.Dimension(93, 5));

        javax.swing.GroupLayout PanelThuocTinhLayout = new javax.swing.GroupLayout(PanelThuocTinh);
        PanelThuocTinh.setLayout(PanelThuocTinhLayout);
        PanelThuocTinhLayout.setHorizontalGroup(
            PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                        .addComponent(LblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                        .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblMa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldTen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TextFieldMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldSDT)
                                    .addComponent(ComboBoxGioiTinh, 0, 150, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelThuocTinhLayout.setVerticalGroup(
            PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextFieldMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                        .addComponent(TextFieldSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LblSDT))
                .addGap(20, 20, 20)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblGioiTinh))
                .addGap(20, 20, 20)
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblNgaySinh)
                    .addComponent(jDNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout PanelNoiDungThongTinLayout = new javax.swing.GroupLayout(PanelNoiDungThongTin);
        PanelNoiDungThongTin.setLayout(PanelNoiDungThongTinLayout);
        PanelNoiDungThongTinLayout.setHorizontalGroup(
            PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(PanelThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNoiDungThongTinLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTieuDe)
                .addGap(52, 52, 52))
        );
        PanelNoiDungThongTinLayout.setVerticalGroup(
            PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(LabelTieuDe)
                .addGap(18, 18, 18)
                .addComponent(PanelThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout PanelThongTinLayout = new javax.swing.GroupLayout(PanelThongTin);
        PanelThongTin.setLayout(PanelThongTinLayout);
        PanelThongTinLayout.setHorizontalGroup(
            PanelThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThongTinLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(PanelNoiDungThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        PanelThongTinLayout.setVerticalGroup(
            PanelThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThongTinLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(PanelNoiDungThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        Them.setBackground(new java.awt.Color(51, 51, 51));
        Them.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        Them.setForeground(new java.awt.Color(255, 255, 255));
        Them.setText("Thêm Khách");
        Them.setMaximumSize(new java.awt.Dimension(90, 25));
        Them.setMinimumSize(new java.awt.Dimension(90, 25));
        Them.setPreferredSize(new java.awt.Dimension(90, 25));

        TaiLai.setBackground(new java.awt.Color(51, 102, 255));
        TaiLai.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TaiLai.setForeground(new java.awt.Color(255, 255, 255));
        TaiLai.setText("Tải Lại");
        TaiLai.setMaximumSize(new java.awt.Dimension(90, 25));
        TaiLai.setMinimumSize(new java.awt.Dimension(90, 25));
        TaiLai.setPreferredSize(new java.awt.Dimension(90, 25));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNoiDungLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(349, 349, 349)
                .addComponent(huyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PanelNoiDungLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(xacNhanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(huyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(TaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(PanelNoiDungLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(PanelTool, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        PanelNoiDungLayout.setVerticalGroup(
            PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungLayout.createSequentialGroup()
                .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNoiDungLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Title)
                        .addGap(360, 360, 360)
                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNoiDungLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelNoiDungLayout.createSequentialGroup()
                                .addComponent(PanelTool, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xacNhanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(huyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(huyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        PanelKhung.add(PanelNoiDung);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelKhung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelKhung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxGioiTinh;
    private javax.swing.JLabel LabelAnhTimKiem;
    private javax.swing.JLabel LabelTieuDe;
    private javax.swing.JLabel LblGioiTinh;
    private javax.swing.JLabel LblMa;
    private javax.swing.JLabel LblNgaySinh;
    private javax.swing.JLabel LblSDT;
    private javax.swing.JLabel LblTen;
    private javax.swing.JPanel PanelKhung;
    private javax.swing.JPanel PanelNoiDung;
    private javax.swing.JPanel PanelNoiDungThongTin;
    private javax.swing.JPanel PanelThongTin;
    private javax.swing.JPanel PanelThuocTinh;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JPanel PanelTool;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table;
    private javax.swing.JButton TaiLai;
    private javax.swing.JTextField TextFieldMa;
    private javax.swing.JTextField TextFieldSDT;
    private javax.swing.JTextField TextFieldTen;
    private javax.swing.JButton Them;
    private javax.swing.JTextField TimKiem;
    private javax.swing.JLabel Title;
    private javax.swing.JButton huyBtn;
    private javax.swing.JPanel huyBtn1;
    private com.toedter.calendar.JDateChooser jDNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton xacNhanBtn;
    // End of variables declaration//GEN-END:variables
}
