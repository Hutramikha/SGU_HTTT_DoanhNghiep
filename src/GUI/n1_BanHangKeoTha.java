package GUI;

import BUS.BanHangBUS;
import DTO.MonDTO;
import Util.TableCustom;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class n1_BanHangKeoTha extends javax.swing.JPanel {

    public String MaNhanVien = "";

    public n1_BanHangKeoTha(String user) {
        initComponents();
        this.MaNhanVien = user;
        nhomNutChucNang();
        TableCustom.apply(scrollPaneTable, TableCustom.TableType.MULTI_LINE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTong = new javax.swing.JPanel();
        PanelHoaDon = new javax.swing.JPanel();
        LabelHoaDon = new javax.swing.JLabel();
        PanelBanHang = new javax.swing.JPanel();
        LabelBanHang = new javax.swing.JLabel();
        PanelNoiDung = new javax.swing.JPanel();
        LabelMenu = new javax.swing.JLabel();
        LabelLoaiSP = new javax.swing.JLabel();
        ComboBoxLoaiSP = new javax.swing.JComboBox<>();
        PanelProduct = new javax.swing.JPanel();
        PanelGioHang = new javax.swing.JPanel();
        scrollPaneTable = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        LabelGioHang = new javax.swing.JLabel();
        PanelTaiLai = new javax.swing.JPanel();
        LabelTaiLai = new javax.swing.JLabel();
        BtnThanhToan = new javax.swing.JButton();
        BtnXoa = new javax.swing.JButton();
        BtnSua = new javax.swing.JButton();
        PanelTimKiem = new javax.swing.JPanel();
        TimKiem = new javax.swing.JTextField();
        LabelAnhTimKiem = new javax.swing.JLabel();

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1125, 667));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setPreferredSize(new java.awt.Dimension(1125, 658));

        PanelHoaDon.setBackground(new java.awt.Color(219, 189, 142));
        PanelHoaDon.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelHoaDon.setMinimumSize(new java.awt.Dimension(195, 44));
        PanelHoaDon.setPreferredSize(new java.awt.Dimension(195, 44));
        PanelHoaDon.setLayout(new java.awt.GridBagLayout());

        LabelHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelHoaDon.setText("HÓA ĐƠN");
        PanelHoaDon.add(LabelHoaDon, new java.awt.GridBagConstraints());

        PanelBanHang.setBackground(new java.awt.Color(219, 189, 142));
        PanelBanHang.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelBanHang.setMinimumSize(new java.awt.Dimension(195, 44));
        PanelBanHang.setPreferredSize(new java.awt.Dimension(195, 44));
        PanelBanHang.setLayout(new java.awt.GridBagLayout());

        LabelBanHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelBanHang.setText("BÁN HÀNG");
        PanelBanHang.add(LabelBanHang, new java.awt.GridBagConstraints());

        PanelNoiDung.setBackground(new java.awt.Color(255, 255, 255));

        LabelMenu.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        LabelMenu.setText("Thực đơn");

        LabelLoaiSP.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        LabelLoaiSP.setText("Loại Sản Phẩm");

        PanelProduct.setBackground(new java.awt.Color(219, 189, 142));
        PanelProduct.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        PanelProduct.setMaximumSize(new java.awt.Dimension(689, 426));
        PanelProduct.setMinimumSize(new java.awt.Dimension(689, 426));
        PanelProduct.setPreferredSize(new java.awt.Dimension(689, 426));

        javax.swing.GroupLayout PanelProductLayout = new javax.swing.GroupLayout(PanelProduct);
        PanelProduct.setLayout(PanelProductLayout);
        PanelProductLayout.setHorizontalGroup(
            PanelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelProductLayout.setVerticalGroup(
            PanelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PanelGioHang.setBackground(new java.awt.Color(255, 255, 255));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "Đơn Giá", "SL", "Thành Tiền"
            }
        ));
        scrollPaneTable.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setPreferredWidth(20);
            Table.getColumnModel().getColumn(3).setPreferredWidth(25);
        }

        LabelGioHang.setBackground(new java.awt.Color(255, 255, 255));
        LabelGioHang.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        LabelGioHang.setText("Giỏ hàng");
        LabelGioHang.setOpaque(true);

        PanelTaiLai.setBackground(new java.awt.Color(0, 0, 0));
        PanelTaiLai.setMaximumSize(new java.awt.Dimension(34, 34));
        PanelTaiLai.setPreferredSize(new java.awt.Dimension(34, 34));

        LabelTaiLai.setBackground(new java.awt.Color(0, 0, 0));
        LabelTaiLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTaiLai.setForeground(new java.awt.Color(255, 255, 255));
        LabelTaiLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/reload.png"))); // NOI18N
        LabelTaiLai.setOpaque(true);
        PanelTaiLai.add(LabelTaiLai);

        BtnThanhToan.setBackground(new java.awt.Color(51, 51, 51));
        BtnThanhToan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        BtnThanhToan.setText("Thanh Toán");
        BtnThanhToan.setPreferredSize(new java.awt.Dimension(100, 30));

        BtnXoa.setBackground(new java.awt.Color(51, 51, 51));
        BtnXoa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnXoa.setForeground(new java.awt.Color(255, 255, 255));
        BtnXoa.setText("Xóa");
        BtnXoa.setPreferredSize(new java.awt.Dimension(100, 30));

        BtnSua.setBackground(new java.awt.Color(51, 51, 51));
        BtnSua.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnSua.setForeground(new java.awt.Color(255, 255, 255));
        BtnSua.setText("Sửa");
        BtnSua.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout PanelGioHangLayout = new javax.swing.GroupLayout(PanelGioHang);
        PanelGioHang.setLayout(PanelGioHangLayout);
        PanelGioHangLayout.setHorizontalGroup(
            PanelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGioHangLayout.createSequentialGroup()
                .addGroup(PanelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelGioHangLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(BtnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(BtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(BtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PanelGioHangLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(LabelGioHang)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollPaneTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        PanelGioHangLayout.setVerticalGroup(
            PanelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelGioHangLayout.createSequentialGroup()
                        .addComponent(LabelGioHang)
                        .addGap(27, 27, 27))
                    .addComponent(PanelTaiLai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(PanelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        PanelTimKiem.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem.setMaximumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setMinimumSize(new java.awt.Dimension(314, 32));
        PanelTimKiem.setPreferredSize(new java.awt.Dimension(270, 32));

        TimKiem.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        TimKiem.setForeground(new java.awt.Color(0, 102, 0));
        TimKiem.setText("Tìm tên món");
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

        javax.swing.GroupLayout PanelNoiDungLayout = new javax.swing.GroupLayout(PanelNoiDung);
        PanelNoiDung.setLayout(PanelNoiDungLayout);
        PanelNoiDungLayout.setHorizontalGroup(
            PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNoiDungLayout.createSequentialGroup()
                        .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(LabelLoaiSP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNoiDungLayout.createSequentialGroup()
                        .addComponent(LabelMenu)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelNoiDungLayout.setVerticalGroup(
            PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNoiDungLayout.createSequentialGroup()
                .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelGioHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelNoiDungLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelMenu)
                        .addGap(32, 32, 32)
                        .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LabelLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboBoxLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(PanelBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(PanelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelNoiDung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PanelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        /*
        PanelBanHang.setRoundBottomRight(40);
        PanelBanHang.setRoundTopLeft(40);

        PanelHoaDon.setRoundBottomRight(40);
        PanelHoaDon.setRoundTopLeft(40);

        PanelTimKiem.setRoundBottomRight(20);
        PanelTimKiem.setRoundTopLeft(20);
        PanelTimKiem.setRoundTopRight(20);
        PanelTimKiem.setRoundBottomLeft(20);

        PanelProduct.setRoundBottomRight(20);
        PanelProduct.setRoundTopLeft(20);
        PanelProduct.setRoundTopRight(20);
        PanelProduct.setRoundBottomLeft(20);

        PanelThanhToan.setRoundBottomRight(20);
        PanelThanhToan.setRoundTopLeft(20);
        PanelThanhToan.setRoundTopRight(20);
        PanelThanhToan.setRoundBottomLeft(20);

        PanelXoa.setRoundBottomRight(20);
        PanelXoa.setRoundTopLeft(20);
        PanelXoa.setRoundTopRight(20);
        PanelXoa.setRoundBottomLeft(20);

        PanelSua.setRoundBottomRight(20);
        PanelSua.setRoundTopLeft(20);
        PanelSua.setRoundTopRight(20);
        PanelSua.setRoundBottomLeft(20);
        */
    }// </editor-fold>//GEN-END:initComponents

    private void comboBox_LoaiMon() {
        BanHangBUS.getInstance().get_All_TenLoaiMon(ComboBoxLoaiSP);
    }

    private void listSanPham(ArrayList<MonDTO> listDefault) {
        PanelProduct.removeAll();
        n1_BanHang_ListSanPham listSP = new n1_BanHang_ListSanPham(listDefault, this);
        PanelProduct.setLayout(new BorderLayout());
        PanelProduct.add(listSP, BorderLayout.CENTER); // Adjust the layout constraint as needed
        PanelProduct.revalidate();
        PanelProduct.repaint();
    }

    public void addCart(Object[] cthd) {
        listCart.add(cthd);
        displayCart();
    }
    
    public void setGioHangRong(){
        listCart.clear();
    }

    public void displayCart() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        // làm sạch bảng 
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        int i = 1;

        for (Object cthdObj : listCart) {
            Object[] cthd = (Object[]) cthdObj;
//            System.out.println(cthd[1].toString());
            model.addRow(new Object[]{
                i,
                //                cthd[0],
                cthd[1],
                Util.BanHang.set_Tien_VND((int) cthd[2]),
                cthd[3],
                Util.BanHang.set_Tien_VND((int) cthd[4])
            });
            i++;
        }
    }

    public void xoaSanPhamTheoTen(String tenCanXoa) {
        Iterator<Object[]> iterator = listCart.iterator();

        while (iterator.hasNext()) {
            Object[] sp = iterator.next();

            if (sp[1] instanceof String && ((String) sp[1]).equalsIgnoreCase(tenCanXoa)) {
                BanHangBUS.getInstance().update_cong_NguyenLieu(sp);
                iterator.remove(); // Xóa dòng khỏi ArrayList
                TongTien = TongTien - (int) sp[4];
//                System.out.println("Đã xóa sản phẩm: " + tenCanXoa);
                return;
            }
        }

//        System.out.println("Không tìm thấy sản phẩm có tên: " + tenCanXoa);
    }

    public String timMaMon_bang_TenMon(String tenMon) {
        String MaMon = "";
        Iterator<Object[]> iterator = listCart.iterator();
        while (iterator.hasNext()) {
            Object[] sp = iterator.next();

            if (sp[1] instanceof String && ((String) sp[1]).equalsIgnoreCase(tenMon)) {
                MaMon = (String) sp[0];
                return MaMon;
            }
        }
        return null;
    }

    public void reload() {
        BanHangBUS.getInstance().update_reload_NguyenLieu(listCart);
        ArrayList<MonDTO> listDefault = BanHangBUS.getInstance().listMon();
        listSanPham(listDefault);
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        // làm sạch bảng 
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        listCart = new ArrayList<>();
        TimKiem.setText("");
        TongTien = 0;
    }

    public ArrayList<Object[]> returnSoLuong(ArrayList<Object[]> list) {
        BanHangBUS.getInstance().update_reload_NguyenLieu(list);
        listCart = new ArrayList<>();
        return listCart;
    }

    public void reload_TaoHoaDon() {
        ArrayList<MonDTO> listDefault = BanHangBUS.getInstance().listMon();
        listSanPham(listDefault);
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        // làm sạch bảng 
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        listCart = new ArrayList<>();
        TimKiem.setText("");
        TongTien = 0;
    }

    private void nhomNutChucNang() {
        ArrayList<MonDTO> listDefault = BanHangBUS.getInstance().listMon();
        listSanPham(listDefault);
        comboBox_LoaiMon();

        ArrayList<Object[]> ds_Cthd = new ArrayList<>();

        ComboBoxLoaiSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    String tenLoaiMon = (String) ComboBoxLoaiSP.getSelectedItem();
                    ArrayList<MonDTO> listMon = BanHangBUS.getInstance().list_Mon_TenLoaiMon(tenLoaiMon);
                    listSanPham(listMon);
                }
            }
        });

        TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    ArrayList<MonDTO> listMon = BanHangBUS.getInstance().getAll_theo_TimKiem(TimKiem.getText());
                    listSanPham(listMon);
                }
            }
        });

        LabelAnhTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArrayList<MonDTO> listMon = BanHangBUS.getInstance().getAll_theo_TimKiem(TimKiem.getText());
                listSanPham(listMon);
            }
        });
        
        TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimKiem.setText("");
            }
        });

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
                PanelTong.add(bh, BorderLayout.CENTER); // Adjust the layout constraint as needed
                PanelTong.revalidate();
                PanelTong.repaint();
            }
        });
        PanelHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelHoaDon.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelHoaDon.setBackground(new Color(219, 189, 142));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reload();
                PanelTong.removeAll();
                n1_HoaDonGUI bh = new n1_HoaDonGUI(MaNhanVien);
                PanelTong.setLayout(new BorderLayout());
                PanelTong.add(bh, BorderLayout.CENTER); // Adjust the layout constraint as needed
                PanelTong.revalidate();
                PanelTong.repaint();
            }
        });

        BtnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                if (listCart.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Giỏ hàng rỗng !");
                    return;
                }

//                System.out.println(TongTien);
                n1_BanHang_ThanhToan a = new n1_BanHang_ThanhToan(n1_BanHangKeoTha.this, MaNhanVien);
                a.setVisible(true);
            }
        });

        PanelTaiLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelTaiLai.setBackground(new Color(106, 105, 105));
                LabelTaiLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/reload_hover.png")));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelTaiLai.setBackground(new Color(0, 0, 0));
                LabelTaiLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/reload.png")));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reload();
                TimKiem.setText("Tìm tên món");
            }
        });

        BtnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int count = Table.getSelectedRow();
                TableModel model = Table.getModel();

                if (listCart.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Giỏ hàng rỗng !");
                    return;
                }
                if (count == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn sản phẩm trong giỏ hàng !");
                    return;
                }

                xoaSanPhamTheoTen(model.getValueAt(count, 1).toString());

//                System.out.println("\nDanh sách sản phẩm");
//                for (Object[] item : listCart) {
//                    for (Object attribute : item) {
//                        System.out.println(attribute);
//                    }
//                    System.out.println("\n\n");
//                }
                displayCart();

            }
        });

        BtnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int count = Table.getSelectedRow();
                TableModel model = Table.getModel();
                if (listCart.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Giỏ hàng rỗng !");
                    return;
                }
                if (count == -1) {
                    JOptionPane.showMessageDialog(null, "Hãy chọn sản phẩm trong giỏ hàng !");
                    return;
                }

                String MaMon = timMaMon_bang_TenMon(model.getValueAt(count, 1).toString());
                MonDTO mon = BanHangBUS.getInstance().getMon_theo_MaMon(MaMon);
                xoaSanPhamTheoTen(model.getValueAt(count, 1).toString());

                n1_BanHang_ThongTinMon thongTinMon = new n1_BanHang_ThongTinMon(mon, n1_BanHangKeoTha.this);
                thongTinMon.setVisible(true);
            }
        });

    }

    public int TongTien = 0;
    public ArrayList<Object[]> listCart = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSua;
    private javax.swing.JButton BtnThanhToan;
    private javax.swing.JButton BtnXoa;
    private javax.swing.JComboBox<String> ComboBoxLoaiSP;
    private javax.swing.JLabel LabelAnhTimKiem;
    private javax.swing.JLabel LabelBanHang;
    private javax.swing.JLabel LabelGioHang;
    private javax.swing.JLabel LabelHoaDon;
    private javax.swing.JLabel LabelLoaiSP;
    private javax.swing.JLabel LabelMenu;
    private javax.swing.JLabel LabelTaiLai;
    private javax.swing.JPanel PanelBanHang;
    private javax.swing.JPanel PanelGioHang;
    private javax.swing.JPanel PanelHoaDon;
    private javax.swing.JPanel PanelNoiDung;
    private javax.swing.JPanel PanelProduct;
    private javax.swing.JPanel PanelTaiLai;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TimKiem;
    private javax.swing.JScrollPane scrollPaneTable;
    // End of variables declaration//GEN-END:variables
}
