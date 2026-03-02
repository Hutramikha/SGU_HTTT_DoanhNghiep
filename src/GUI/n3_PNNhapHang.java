package GUI;

import java.util.Date;
import Util.TableCustom;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JDialog;


import BUS.NhapHangBUS;
import BUS.PhieuNhapBUS;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BUS.NhapHangBUS.NonEditableTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class n3_PNNhapHang extends javax.swing.JPanel {
    boolean isNccSelected = false;
    private NhapHangBUS nhapHangBUS;
    // private n3_PNQuanLyNhapHang truyenMaNhanVien;
    private String maNhanVien;


    public n3_PNNhapHang(String MaNhanVien) {
        this.maNhanVien = MaNhanVien;
        initComponents();
        TableCustom.apply(ScrollPane1, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(ScrollPane2, TableCustom.TableType.MULTI_LINE);
        nhapHangBUS = new NhapHangBUS();
        nhapHangBUS.loadDataToTable_KhoHang(jTable_KhoHang);
        jBtn_XacNhan.setEnabled(false); 
        jT_DonGia.setEnabled(false);
        jT_SoLuongNhap.setEnabled(false);
        jT_NhanVien.setEditable(false);
        // String maNhanVien = "hahaha";
        jT_NhanVien.setText(maNhanVien);
        PhieuNhapBUS phieuNhapBUS = new PhieuNhapBUS();

        // try {
        //     String maNhanVien = "hahaha";
        //     jT_NhanVien.setText(maNhanVien);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
       
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_NhapHang = new javax.swing.JPanel();
        jP_KhoHang = new javax.swing.JPanel();
        jP_KhoHang_Top = new javax.swing.JPanel();
        jL_KhoHang1 = new javax.swing.JLabel();
        PanelTimKiem = new javax.swing.JPanel();
        JTFTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ScrollPane1 = new javax.swing.JScrollPane();
        jTable_KhoHang = new javax.swing.JTable();
        jP_ChoNhap = new javax.swing.JPanel();
        jL_ChoNhap = new javax.swing.JLabel();
        ScrollPane2 = new javax.swing.JScrollPane();
        jTable_ChoNhap = new javax.swing.JTable();
        jP_ThongTinNhap = new javax.swing.JPanel();
        jL_ThongTinNhap = new javax.swing.JLabel();
        jP_NhapThongTin = new javax.swing.JPanel();
        jP_DonGia = new javax.swing.JPanel();
        jL_DonGiaNhap = new javax.swing.JLabel();
        jT_DonGia = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
       
        jSeparator2 = new javax.swing.JSeparator();
        jP_SoLuongNhap = new javax.swing.JPanel();
        jL_SoLuongNhap = new javax.swing.JLabel();
        jT_SoLuongNhap = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jP_btn_Re_XacNhan = new javax.swing.JPanel();
        jBtn_XacNhan = new javax.swing.JButton();
        jP_Ncc = new javax.swing.JPanel();
        jL_Ncc = new javax.swing.JLabel();
        jL_NhanVien = new javax.swing.JLabel();
        jT_NhanVien = new javax.swing.JTextField();
        jP_XacNhanNhapHang = new javax.swing.JPanel();
        jBnt_Xoa = new javax.swing.JButton();
        jBtn_Refresh1 = new javax.swing.JButton();
        jBtn_Nhap = new javax.swing.JButton();
        jP_ChonNcc = new javax.swing.JPanel();
        jT_ChonNcc = new javax.swing.JTextField();
        jBtn_ChonNcc = new javax.swing.JButton();

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1100, 600));
        setMinimumSize(new java.awt.Dimension(1100, 600));
        setPreferredSize(new java.awt.Dimension(1100, 600));

        jP_NhapHang.setBackground(new java.awt.Color(219, 189, 142));
        jP_NhapHang.setMaximumSize(new java.awt.Dimension(1100, 600));
        jP_NhapHang.setMinimumSize(new java.awt.Dimension(1100, 600));
        jP_NhapHang.setName(""); // NOI18N
        jP_NhapHang.setPreferredSize(new java.awt.Dimension(1100, 600));

        jP_KhoHang.setBackground(new java.awt.Color(255, 255, 255));
        jP_KhoHang.setMaximumSize(new java.awt.Dimension(620, 290));
        jP_KhoHang.setMinimumSize(new java.awt.Dimension(620, 290));
        jP_KhoHang.setPreferredSize(new java.awt.Dimension(620, 290));

        jP_KhoHang_Top.setBackground(new java.awt.Color(255, 255, 255));

        jL_KhoHang1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jL_KhoHang1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_KhoHang1.setText("Kho Hàng");

        PanelTimKiem.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem.setMaximumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setMinimumSize(new java.awt.Dimension(314, 32));

        JTFTimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        JTFTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleSearch();
            }

            private void handleSearch() {
                String maNguyenLieu = JTFTimKiem.getText().trim();
                if (maNguyenLieu.isEmpty()) {
                    // Nếu ô tìm kiếm trống, tải lại toàn bộ dữ liệu nguyên liệu trong kho hàng
                    nhapHangBUS.loadDataToTable_KhoHang(jTable_KhoHang);
                } 
            }
        });
        JTFTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFTimKiemKeyPressed(evt);
            }
        });
        
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });
        
        

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(JTFTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTFTimKiem))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jP_KhoHang_TopLayout = new javax.swing.GroupLayout(jP_KhoHang_Top);
        jP_KhoHang_Top.setLayout(jP_KhoHang_TopLayout);
        jP_KhoHang_TopLayout.setHorizontalGroup(
            jP_KhoHang_TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jL_KhoHang1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addGroup(jP_KhoHang_TopLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_KhoHang_TopLayout.setVerticalGroup(
            jP_KhoHang_TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_KhoHang_TopLayout.createSequentialGroup()
                .addComponent(jL_KhoHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jTable_KhoHang.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        /// bảng kho hàng /////////////////////////////////////////////////////////////////////
        jTable_KhoHang.setModel(new NonEditableTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Mã Nguyên Liệu", "Tên Nguyên Liệu", "Khối Lượng", "Trạng Thái "
            }
        ));
        ScrollPane1.setViewportView(jTable_KhoHang);

        javax.swing.GroupLayout jP_KhoHangLayout = new javax.swing.GroupLayout(jP_KhoHang);
        jP_KhoHang.setLayout(jP_KhoHangLayout);
        jP_KhoHangLayout.setHorizontalGroup(
            jP_KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_KhoHang_Top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jP_KhoHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane1)
                .addContainerGap())
        );
        jP_KhoHangLayout.setVerticalGroup(
            jP_KhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_KhoHangLayout.createSequentialGroup()
                .addComponent(jP_KhoHang_Top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable_KhoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable_KhoHang.getSelectedRow();
                if (row != -1) {
                    String maNguyenLieu = (String) jTable_KhoHang.getValueAt(row, 0);
                    String tenNguyenLieu = (String) jTable_KhoHang.getValueAt(row, 1);
                    NhapHangBUS nhapHangBUS = new NhapHangBUS();
                    if (nhapHangBUS.isNguyenLieuInChoNhap(jTable_ChoNhap, maNguyenLieu)) {
                        JOptionPane.showMessageDialog(null, "Nguyên liệu này đang tồn tại ở phần chờ nhập. Vui lòng xóa thông tin của nguyên liệu ở phần chờ nhập để nhập lại.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn nhập nguyên liệu " + tenNguyenLieu + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            jT_DonGia.setEnabled(true);
                            jT_SoLuongNhap.setEnabled(true);
                            jBtn_XacNhan.setEnabled(true);
                        }
                    }
                }
            }
        });
      

        jP_ChoNhap.setBackground(new java.awt.Color(255, 255, 255));
        jP_ChoNhap.setMaximumSize(new java.awt.Dimension(620, 240));
        jP_ChoNhap.setMinimumSize(new java.awt.Dimension(620, 240));
        jP_ChoNhap.setPreferredSize(new java.awt.Dimension(620, 240));

        jL_ChoNhap.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jL_ChoNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_ChoNhap.setText("Chờ Nhập");

        // bảng chờ nhập ///////////////////////////////////////////////////////////////////////
        jTable_ChoNhap.setModel(new NonEditableTableModel(
            new Object [][] {
               
            },
            new String [] {
                "Mã NL", "Tên NL", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        jTable_ChoNhap.setMaximumSize(new java.awt.Dimension(635, 215));
        jTable_ChoNhap.setMinimumSize(new java.awt.Dimension(635, 215));
        ScrollPane2.setViewportView(jTable_ChoNhap);

        javax.swing.GroupLayout jP_ChoNhapLayout = new javax.swing.GroupLayout(jP_ChoNhap);
        jP_ChoNhap.setLayout(jP_ChoNhapLayout);
        jP_ChoNhapLayout.setHorizontalGroup(
            jP_ChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jL_ChoNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ChoNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane2)
                .addContainerGap())
        );
        jP_ChoNhapLayout.setVerticalGroup(
            jP_ChoNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ChoNhapLayout.createSequentialGroup()
                .addComponent(jL_ChoNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jTable_ChoNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable_ChoNhap.getSelectedRow();
                if (row != -1) {
                    String maNguyenLieu = (String) jTable_ChoNhap.getValueAt(row, 0);
                    String tenNguyenLieu = (String) jTable_ChoNhap.getValueAt(row, 1);
                    double soLuong = (double) jTable_ChoNhap.getValueAt(row, 2);
                    int donGia = (int) jTable_ChoNhap.getValueAt(row, 3);
                    jBtn_XacNhan.setEnabled(false);
                }
            }
        });

        jP_ThongTinNhap.setBackground(new java.awt.Color(255, 255, 255));
        jP_ThongTinNhap.setMaximumSize(new java.awt.Dimension(435, 340));
        jP_ThongTinNhap.setMinimumSize(new java.awt.Dimension(435, 340));
        jP_ThongTinNhap.setPreferredSize(new java.awt.Dimension(435, 340));

        jL_ThongTinNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jL_ThongTinNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_ThongTinNhap.setText("Thông Tin Nhập");

        jP_NhapThongTin.setBackground(new java.awt.Color(255, 255, 255));

        jP_DonGia.setBackground(new java.awt.Color(255, 255, 255));
        jP_DonGia.setPreferredSize(new java.awt.Dimension(390, 30));

        jL_DonGiaNhap.setBackground(new java.awt.Color(255, 255, 255));
        jL_DonGiaNhap.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jL_DonGiaNhap.setText("Đơn Giá Nhập");
        jL_DonGiaNhap.setOpaque(true);

        jT_DonGia.setBorder(null);
        jT_DonGia.setMaximumSize(new java.awt.Dimension(200, 20));
        jT_DonGia.setMinimumSize(new java.awt.Dimension(200, 20));
        jT_DonGia.setPreferredSize(new java.awt.Dimension(200, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setMaximumSize(new java.awt.Dimension(200, 3));
        jSeparator1.setMinimumSize(new java.awt.Dimension(200, 3));
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 3));

        javax.swing.GroupLayout jP_DonGiaLayout = new javax.swing.GroupLayout(jP_DonGia);
        jP_DonGia.setLayout(jP_DonGiaLayout);
        jP_DonGiaLayout.setHorizontalGroup(
            jP_DonGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_DonGiaLayout.createSequentialGroup()
                .addComponent(jL_DonGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_DonGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jT_DonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jP_DonGiaLayout.setVerticalGroup(
            jP_DonGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jL_DonGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jP_DonGiaLayout.createSequentialGroup()
                .addComponent(jT_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setMaximumSize(new java.awt.Dimension(200, 3));
        jSeparator2.setMinimumSize(new java.awt.Dimension(200, 3));
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 3));

        jP_SoLuongNhap.setBackground(new java.awt.Color(255, 255, 255));
        jP_SoLuongNhap.setPreferredSize(new java.awt.Dimension(390, 30));

        jL_SoLuongNhap.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jL_SoLuongNhap.setText("Số Lượng Nhập");

        jT_SoLuongNhap.setBorder(null);
        jT_SoLuongNhap.setMaximumSize(new java.awt.Dimension(200, 20));
        jT_SoLuongNhap.setMinimumSize(new java.awt.Dimension(200, 20));
        jT_SoLuongNhap.setPreferredSize(new java.awt.Dimension(200, 20));
        jT_SoLuongNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_SoLuongNhapActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setMaximumSize(new java.awt.Dimension(200, 3));
        jSeparator3.setMinimumSize(new java.awt.Dimension(200, 3));
        jSeparator3.setPreferredSize(new java.awt.Dimension(200, 3));

        javax.swing.GroupLayout jP_SoLuongNhapLayout = new javax.swing.GroupLayout(jP_SoLuongNhap);
        jP_SoLuongNhap.setLayout(jP_SoLuongNhapLayout);
        jP_SoLuongNhapLayout.setHorizontalGroup(
            jP_SoLuongNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_SoLuongNhapLayout.createSequentialGroup()
                .addComponent(jL_SoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_SoLuongNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jT_SoLuongNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jP_SoLuongNhapLayout.setVerticalGroup(
            jP_SoLuongNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jL_SoLuongNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jP_SoLuongNhapLayout.createSequentialGroup()
                .addComponent(jT_SoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

    
        javax.swing.GroupLayout jP_NhapThongTinLayout = new javax.swing.GroupLayout(jP_NhapThongTin);
        jP_NhapThongTin.setLayout(jP_NhapThongTinLayout);
        jP_NhapThongTinLayout.setHorizontalGroup(
            jP_NhapThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_NhapThongTinLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jP_NhapThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_SoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jP_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jP_NhapThongTinLayout.setVerticalGroup(
            jP_NhapThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_NhapThongTinLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jP_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jP_SoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        jP_btn_Re_XacNhan.setBackground(new java.awt.Color(255, 255, 255));



        jBtn_XacNhan.setBackground(new java.awt.Color(0, 0, 0));
        jBtn_XacNhan.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_XacNhan.setText("Xác Nhận");
        jBtn_XacNhan.setMaximumSize(new java.awt.Dimension(100, 24));
        jBtn_XacNhan.setMinimumSize(new java.awt.Dimension(100, 24));
        jBtn_XacNhan.setPreferredSize(new java.awt.Dimension(100, 24));
        jBtn_XacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtn_XacNhanMouseClicked(evt);
            }
        });

        
        javax.swing.GroupLayout jP_btn_Re_XacNhanLayout = new javax.swing.GroupLayout(jP_btn_Re_XacNhan);
        jP_btn_Re_XacNhan.setLayout(jP_btn_Re_XacNhanLayout);
        jP_btn_Re_XacNhanLayout.setHorizontalGroup(
            jP_btn_Re_XacNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_btn_Re_XacNhanLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jBtn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jP_btn_Re_XacNhanLayout.setVerticalGroup(
            jP_btn_Re_XacNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_btn_Re_XacNhanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBtn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );


        javax.swing.GroupLayout jP_ThongTinNhapLayout = new javax.swing.GroupLayout(jP_ThongTinNhap);
        jP_ThongTinNhap.setLayout(jP_ThongTinNhapLayout);
        jP_ThongTinNhapLayout.setHorizontalGroup(
            jP_ThongTinNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jL_ThongTinNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jP_NhapThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jP_ThongTinNhapLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jP_btn_Re_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_ThongTinNhapLayout.setVerticalGroup(
            jP_ThongTinNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ThongTinNhapLayout.createSequentialGroup()
                .addComponent(jL_ThongTinNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_NhapThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jP_btn_Re_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_Ncc.setBackground(new java.awt.Color(255, 255, 255));
        jP_Ncc.setMaximumSize(new java.awt.Dimension(450, 190));
        jP_Ncc.setMinimumSize(new java.awt.Dimension(450, 190));
        jP_Ncc.setPreferredSize(new java.awt.Dimension(450, 190));

        jL_Ncc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jL_Ncc.setText("Nhà Cung Cấp:");

        jL_NhanVien.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jL_NhanVien.setText("Nhân Viên:");

        jT_NhanVien.setBackground(new java.awt.Color(245, 245, 245));
        jT_NhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_NhanVienActionPerformed(evt);
            }
        });

        jP_XacNhanNhapHang.setBackground(new java.awt.Color(255, 255, 255));

        jBnt_Xoa.setBackground(new java.awt.Color(0, 0, 0));
        jBnt_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        jBnt_Xoa.setText("Xóa");
        jBnt_Xoa.setMaximumSize(new java.awt.Dimension(100, 24));
        jBnt_Xoa.setMinimumSize(new java.awt.Dimension(100, 24));
        jBnt_Xoa.setPreferredSize(new java.awt.Dimension(100, 24));
        jBnt_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBnt_XoaMouseClicked(evt);
            }
        });

        jBtn_Refresh1.setBackground(new java.awt.Color(0, 0, 0));
        jBtn_Refresh1.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_Refresh1.setText("Refresh");
        jBtn_Refresh1.setMaximumSize(new java.awt.Dimension(100, 24));
        jBtn_Refresh1.setMinimumSize(new java.awt.Dimension(100, 24));
        jBtn_Refresh1.setPreferredSize(new java.awt.Dimension(100, 24));
        jBtn_Refresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtn_Refresh1MouseClicked(evt);
            }
        });

        jBtn_Nhap.setBackground(new java.awt.Color(0, 0, 0));
        jBtn_Nhap.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_Nhap.setText("Nhập");
        jBtn_Nhap.setEnabled(false);
        jBtn_Nhap.setMaximumSize(new java.awt.Dimension(100, 24));
        jBtn_Nhap.setMinimumSize(new java.awt.Dimension(100, 24));
        jBtn_Nhap.setPreferredSize(new java.awt.Dimension(100, 24));
        jBtn_Nhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtn_NhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_XacNhanNhapHangLayout = new javax.swing.GroupLayout(jP_XacNhanNhapHang);
        jP_XacNhanNhapHang.setLayout(jP_XacNhanNhapHangLayout);
        jP_XacNhanNhapHangLayout.setHorizontalGroup(
            jP_XacNhanNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_XacNhanNhapHangLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jBnt_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jBtn_Refresh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBtn_Nhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jP_XacNhanNhapHangLayout.setVerticalGroup(
            jP_XacNhanNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_XacNhanNhapHangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jP_XacNhanNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBnt_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_Refresh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_Nhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jP_ChonNcc.setBackground(new java.awt.Color(255, 255, 255));
        jP_ChonNcc.setPreferredSize(new java.awt.Dimension(433, 30));

        jBtn_ChonNcc.setBackground(new java.awt.Color(254, 255, 255));
        jBtn_ChonNcc.setText("...");
        jBtn_ChonNcc.setOpaque(true);
        jBtn_ChonNcc.setEnabled(false);
        jT_ChonNcc.setEnabled(false);
        jBtn_ChonNcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtn_ChonNccMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_ChonNccLayout = new javax.swing.GroupLayout(jP_ChonNcc);
        jP_ChonNcc.setLayout(jP_ChonNccLayout);
        jP_ChonNccLayout.setHorizontalGroup(
            jP_ChonNccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ChonNccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jT_ChonNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtn_ChonNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );
        jP_ChonNccLayout.setVerticalGroup(
            jP_ChonNccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ChonNccLayout.createSequentialGroup()
                .addGroup(jP_ChonNccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtn_ChonNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jT_ChonNcc))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jP_NccLayout = new javax.swing.GroupLayout(jP_Ncc);
        jP_Ncc.setLayout(jP_NccLayout);
        jP_NccLayout.setHorizontalGroup(
            jP_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_NccLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jL_Ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jP_NccLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_ChonNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addGroup(jP_NccLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jP_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jT_NhanVien, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jP_NccLayout.createSequentialGroup()
                                .addComponent(jL_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_NccLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jP_XacNhanNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jP_NccLayout.setVerticalGroup(
            jP_NccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_NccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_Ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_ChonNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jL_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jT_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jP_XacNhanNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jP_NhapHangLayout = new javax.swing.GroupLayout(jP_NhapHang);
        jP_NhapHang.setLayout(jP_NhapHangLayout);
        jP_NhapHangLayout.setHorizontalGroup(
            jP_NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_NhapHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jP_ChoNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP_KhoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jP_Ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jP_ThongTinNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jP_NhapHangLayout.setVerticalGroup(
            jP_NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_NhapHangLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jP_NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jP_NhapHangLayout.createSequentialGroup()
                        .addComponent(jP_ThongTinNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP_Ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                    .addGroup(jP_NhapHangLayout.createSequentialGroup()
                        .addComponent(jP_KhoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP_ChoNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_NhapHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jP_NhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jT_NhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_NhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_NhanVienActionPerformed

    private void jBtn_ChonNccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_ChonNccMouseClicked
        // TODO add your handling code here:
        if (!jBtn_ChonNcc.isEnabled()) {
            return; // Nếu nút không được kích hoạt, không thực hiện hành động
        }
        JDialog jD_ChonNCC = new JDialog();
        n3_PNChonNCC chonNCC = new n3_PNChonNCC(jT_ChonNcc, jBtn_Nhap);
        jD_ChonNCC.setLayout(new BorderLayout());
        jD_ChonNCC.add(chonNCC, BorderLayout.CENTER);
        jD_ChonNCC.pack();
//        jD_ChonNCC.setSize(chonNCC.getPreferredSize());
        jD_ChonNCC.setLocationRelativeTo(null);
        jD_ChonNCC.setTitle("Chọn nhà cung cấp"); // Tiêu đề của cửa sổ
        jD_ChonNCC.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jD_ChonNCC.setVisible(true);


    }//GEN-LAST:event_jBtn_ChonNccMouseClicked

    private void jT_SoLuongNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_SoLuongNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_SoLuongNhapActionPerformed

    // nút nhập/////////////////////////////////////////////////////////////////////////////////////
    private void jBtn_NhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_NhapMouseClicked
        if (!jBtn_Nhap.isEnabled()) {
            return;
        }
        String maNhanVien = jT_NhanVien.getText();
        // String maNhaCungCap = "";
        String nhaCungCap = jT_ChonNcc.getText();
        String ngayLap = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        JDialog jD_ThongTinPN = new JDialog();
        n3_PNThongTinPhieuNhap thongTinPN = new n3_PNThongTinPhieuNhap(this, jTable_ChoNhap, jTable_KhoHang, maNhanVien, nhaCungCap, ngayLap,jT_ChonNcc, jBtn_ChonNcc, jBtn_Nhap);
        jD_ThongTinPN.setLayout(new BorderLayout());
        jD_ThongTinPN.add(thongTinPN, BorderLayout.CENTER);
        jD_ThongTinPN.pack();
        jD_ThongTinPN.setLocationRelativeTo(null);
        jD_ThongTinPN.setTitle("Thông Tin Phiếu Nhập"); // Tiêu đề của cửa sổ
        jD_ThongTinPN.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jD_ThongTinPN.setVisible(true);

    }//GEN-LAST:event_jBtn_NhapMouseClicked

    public void refresh_BangChoNhap() {
        DefaultTableModel model = (DefaultTableModel) jTable_ChoNhap.getModel();
        int rowCount = model.getRowCount();

        model.setRowCount(0); // Xóa tất cả các hàng trong bảng
    }

    private void jBtn_XacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtn_XacNhanMouseClicked
        if (!jBtn_XacNhan.isEnabled()) {
            return;
        }

        if (jT_DonGia.getText().isEmpty() && jT_SoLuongNhap.getText().isEmpty()) { // có thể dùng equals(""). So sánh chuỗi có rỗng hay không
            JOptionPane.showMessageDialog(null, "Bạn đang để trống đơn giá và số lượng nhập.Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (jT_DonGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn đang để trống đơn giá. Vui lòng nhập.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (jT_SoLuongNhap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn đang để trống số lượng. Vui lòng nhập.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int donGia = Integer.parseInt(jT_DonGia.getText());
            double soLuong = Double.parseDouble(jT_SoLuongNhap.getText());
            if (donGia <= 0 && soLuong <= 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng và đơn giá lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (donGia <= 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đơn giá lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            soLuong = Math.round(soLuong * 100.0) / 100.0;
            int row = jTable_KhoHang.getSelectedRow();
            if (row != -1) {
                String maNguyenLieu = (String) jTable_KhoHang.getValueAt(row, 0);
                String tenNguyenLieu = (String) jTable_KhoHang.getValueAt(row, 1);

                int thanhTien = (int) (donGia * soLuong);

                DefaultTableModel model = (DefaultTableModel) jTable_ChoNhap.getModel();
                model.addRow(new Object[]{maNguyenLieu, tenNguyenLieu, soLuong, donGia, thanhTien});

                jT_DonGia.setText("");
                jT_SoLuongNhap.setText("");
                jT_DonGia.setEnabled(false);
                jT_SoLuongNhap.setEnabled(false);
                jBtn_XacNhan.setEnabled(false);
                jBtn_ChonNcc.setEnabled(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng và đơn giá là số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtn_XacNhanMouseClicked

    private void jBtn_Refresh1MouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable_ChoNhap.getModel();
        int rowCount = model.getRowCount();

        if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "Phần chờ nhập đang trống.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tất cả nguyên liệu khỏi phần chờ nhập?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            model.setRowCount(0); // Xóa tất cả các hàng trong bảng

            // Reset các trường nhập liệu
            jT_DonGia.setText("");
            jT_SoLuongNhap.setText("");
            jT_DonGia.setEnabled(false);
            jT_SoLuongNhap.setEnabled(false);
            jBtn_XacNhan.setEnabled(false);
            updateComponentsState();
        }
    }

    private void jBnt_XoaMouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable_ChoNhap.getModel();
        int rowCount = model.getRowCount();

        // Kiểm tra xem bảng có thực sự trống hay không
        boolean isEmpty = true;
        for (int i = 0; i < rowCount; i++) {
            if (model.getValueAt(i, 0) != null && !model.getValueAt(i, 0).toString().trim().isEmpty()) {
                isEmpty = false;
                break;
            }
        }

        if (isEmpty) {
            JOptionPane.showMessageDialog(null, "Phần chờ nhập đang trống.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int row = jTable_ChoNhap.getSelectedRow();
        if (row != -1) {
            int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nguyên liệu này khỏi phần chờ nhập?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                model.removeRow(row);

                // Reset các trường nhập liệu
                jT_DonGia.setText("");
                jT_SoLuongNhap.setText("");
                jT_DonGia.setEnabled(false);
                jT_SoLuongNhap.setEnabled(false);
                jBtn_XacNhan.setEnabled(false);
                updateComponentsState();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một nguyên liệu ở phần chờ nhập để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        // updateNhapButtonState();
    }

    public void setNccSelected(boolean isSelected) {
        this.isNccSelected = isSelected;
        jBtn_Nhap.setEnabled(isSelected);
    }

    private void updateComponentsState() { // hàm kiểm tra số lượng hàng trong bảng
        DefaultTableModel model = (DefaultTableModel) jTable_ChoNhap.getModel();
        if (model.getRowCount() == 0) {
            jBtn_Nhap.setEnabled(false);
            jT_ChonNcc.setText("");
            jBtn_ChonNcc.setEnabled(false);
        } else {
            jBtn_Nhap.setEnabled(true);
        }
    }

  
    private void btn_TimKiemActionPerformed(java.awt.event.MouseEvent evt) { 
        String tenNguyenLieu = JTFTimKiem.getText().trim(); 
        if (tenNguyenLieu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn đang để trống, vui lòng nhập để tìm kiếm.", "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!tenNguyenLieu.matches("[a-zA-ZÀ-ỹ\\s]+")) { 
            JOptionPane.showMessageDialog(this, "Tên nguyên liệu chỉ được chứa chữ cái và khoảng trắng, không chứa số hoặc ký tự đặc biệt.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE); 
            return;
        }
            nhapHangBUS.searchNguyenLieuByTen(jTable_KhoHang, tenNguyenLieu); 
    }
    private void JTFTimKiemKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btn_TimKiemActionPerformed(null);
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTFTimKiem;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JScrollPane ScrollPane1;
    private javax.swing.JScrollPane ScrollPane2;
    private javax.swing.JButton jBnt_Xoa;
    private javax.swing.JButton jBtn_ChonNcc;
    private javax.swing.JButton jBtn_Nhap;
    private javax.swing.JButton jBtn_Refresh1;
    private javax.swing.JButton jBtn_XacNhan;
    private javax.swing.JLabel jL_ChoNhap;
    private javax.swing.JLabel jL_DonGiaNhap;
    private javax.swing.JLabel jL_KhoHang1;
    private javax.swing.JLabel jL_Ncc;
    private javax.swing.JLabel jL_NhanVien;
    private javax.swing.JLabel jL_SoLuongNhap;
    private javax.swing.JLabel jL_ThongTinNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jP_ChoNhap;
    private javax.swing.JPanel jP_ChonNcc;
    private javax.swing.JPanel jP_DonGia;
    private javax.swing.JPanel jP_KhoHang;
    private javax.swing.JPanel jP_KhoHang_Top;
    private javax.swing.JPanel jP_Ncc;
    private javax.swing.JPanel jP_NhapHang;
    private javax.swing.JPanel jP_NhapThongTin;
    private javax.swing.JPanel jP_SoLuongNhap;
    private javax.swing.JPanel jP_ThongTinNhap;
    private javax.swing.JPanel jP_XacNhanNhapHang;
    private javax.swing.JPanel jP_btn_Re_XacNhan;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jT_ChonNcc;
    private javax.swing.JTextField jT_DonGia;
    private javax.swing.JTextField jT_NhanVien;
    private javax.swing.JTextField jT_SoLuongNhap;
    private javax.swing.JTable jTable_ChoNhap;
    private javax.swing.JTable jTable_KhoHang;

    // End of variables declaration//GEN-END:variables
}
