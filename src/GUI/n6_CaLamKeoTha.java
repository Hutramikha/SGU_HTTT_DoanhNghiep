package GUI;

import BUS.CaLamBUS;
import Util.LichLam_CaLam;
import Util.TableCustom;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class n6_CaLamKeoTha extends javax.swing.JPanel {

    public n6_CaLamKeoTha() {
        initComponents();
        TableCustom.apply(ScrollPane, TableCustom.TableType.MULTI_LINE);
        nhomNutChucNang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTong = new javax.swing.JPanel();
        PanelLichLam = new javax.swing.JPanel();
        LichLam = new javax.swing.JLabel();
        PanelCaLam = new javax.swing.JPanel();
        CaLam = new javax.swing.JLabel();
        PanelInput = new javax.swing.JPanel();
        PanelThongTin = new javax.swing.JPanel();
        PanelNoiDungThongTin = new javax.swing.JPanel();
        LabelTieuDe = new javax.swing.JLabel();
        PanelThuocTinh = new javax.swing.JPanel();
        MaCa = new javax.swing.JLabel();
        TenCa = new javax.swing.JLabel();
        ThoiGianVao = new javax.swing.JLabel();
        ThoiGianRa = new javax.swing.JLabel();
        PanelCacText = new javax.swing.JPanel();
        TextMaCa = new javax.swing.JTextField();
        TextTenCa = new javax.swing.JTextField();
        TextThoiGianRa = new javax.swing.JTextField();
        TextThoiGianVaoCa = new javax.swing.JTextField();
        line1 = new javax.swing.JSeparator();
        line2 = new javax.swing.JSeparator();
        line3 = new javax.swing.JSeparator();
        line4 = new javax.swing.JSeparator();
        PanelSua = new javax.swing.JPanel();
        Sua = new javax.swing.JLabel();
        PanelTao = new javax.swing.JPanel();
        Tao = new javax.swing.JLabel();
        PanelXoa = new javax.swing.JPanel();
        Xoa = new javax.swing.JLabel();
        PanelTimKiem = new javax.swing.JPanel();
        LabelTimKiem = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        LabelTenBang = new javax.swing.JLabel();
        PanelTimKiem1 = new javax.swing.JPanel();
        TextFieldTimKiem = new javax.swing.JTextField();
        LabelAnhTimKiem = new javax.swing.JLabel();
        PanelTaiLai = new javax.swing.JPanel();
        LabelTaiLai = new javax.swing.JLabel();

        setBackground(new java.awt.Color(122, 74, 74));
        setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1125, 667));

        PanelTong.setBackground(new java.awt.Color(255, 255, 255));
        PanelTong.setMaximumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setMinimumSize(new java.awt.Dimension(1125, 658));
        PanelTong.setPreferredSize(new java.awt.Dimension(1125, 658));

        PanelLichLam.setBackground(new java.awt.Color(219, 189, 142));
        PanelLichLam.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelLichLam.setMinimumSize(new java.awt.Dimension(195, 44));
        PanelLichLam.setPreferredSize(new java.awt.Dimension(195, 44));
        PanelLichLam.setLayout(new java.awt.GridBagLayout());

        LichLam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LichLam.setText("LỊCH LÀM");
        PanelLichLam.add(LichLam, new java.awt.GridBagConstraints());

        PanelCaLam.setBackground(new java.awt.Color(219, 189, 142));
        PanelCaLam.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        PanelCaLam.setMaximumSize(new java.awt.Dimension(195, 44));
        PanelCaLam.setMinimumSize(new java.awt.Dimension(195, 44));
        PanelCaLam.setPreferredSize(new java.awt.Dimension(195, 44));
        PanelCaLam.setLayout(new java.awt.GridBagLayout());

        CaLam.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CaLam.setText("CA LÀM");
        PanelCaLam.add(CaLam, new java.awt.GridBagConstraints());

        PanelInput.setBackground(new java.awt.Color(255, 255, 255));

        PanelThongTin.setBackground(new java.awt.Color(219, 189, 142));
        PanelThongTin.setPreferredSize(new java.awt.Dimension(237, 277));

        PanelNoiDungThongTin.setBackground(new java.awt.Color(255, 255, 255));
        PanelNoiDungThongTin.setMinimumSize(new java.awt.Dimension(255, 266));
        PanelNoiDungThongTin.setPreferredSize(new java.awt.Dimension(225, 266));

        LabelTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelTieuDe.setText("Thông Tin Ca Làm");

        PanelThuocTinh.setBackground(new java.awt.Color(255, 255, 255));

        MaCa.setBackground(new java.awt.Color(255, 255, 255));
        MaCa.setText("Mã Ca");

        TenCa.setBackground(new java.awt.Color(255, 255, 255));
        TenCa.setText("Tên Ca");

        ThoiGianVao.setBackground(new java.awt.Color(255, 255, 255));
        ThoiGianVao.setText("Thời Gian Vào");

        ThoiGianRa.setBackground(new java.awt.Color(255, 255, 255));
        ThoiGianRa.setText("Thời Gian Ra");

        javax.swing.GroupLayout PanelThuocTinhLayout = new javax.swing.GroupLayout(PanelThuocTinh);
        PanelThuocTinh.setLayout(PanelThuocTinhLayout);
        PanelThuocTinhLayout.setHorizontalGroup(
            PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ThoiGianRa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                .addGroup(PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TenCa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThoiGianVao))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelThuocTinhLayout.setVerticalGroup(
            PanelThuocTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThuocTinhLayout.createSequentialGroup()
                .addComponent(MaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TenCa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ThoiGianVao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ThoiGianRa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        PanelCacText.setBackground(new java.awt.Color(255, 255, 255));

        TextMaCa.setBackground(new java.awt.Color(242, 242, 242));
        TextMaCa.setFont(new java.awt.Font("Segoe UI Semibold", 3, 12)); // NOI18N
        TextMaCa.setForeground(new java.awt.Color(0, 51, 255));
        TextMaCa.setText("C001");
        TextMaCa.setBorder(null);
        TextMaCa.setDisabledTextColor(new java.awt.Color(0, 0, 255));
        TextMaCa.setEnabled(false);

        TextTenCa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TextTenCa.setBorder(null);

        TextThoiGianRa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TextThoiGianRa.setText("14:00");
        TextThoiGianRa.setBorder(null);

        TextThoiGianVaoCa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        TextThoiGianVaoCa.setBorder(null);

        line1.setForeground(new java.awt.Color(0, 0, 0));

        line2.setForeground(new java.awt.Color(0, 0, 0));

        line3.setForeground(new java.awt.Color(0, 0, 0));

        line4.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout PanelCacTextLayout = new javax.swing.GroupLayout(PanelCacText);
        PanelCacText.setLayout(PanelCacTextLayout);
        PanelCacTextLayout.setHorizontalGroup(
            PanelCacTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCacTextLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCacTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextTenCa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextThoiGianVaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextThoiGianRa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(line3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(line4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCacTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TextMaCa, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(line1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))))
        );
        PanelCacTextLayout.setVerticalGroup(
            PanelCacTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCacTextLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(TextMaCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(TextTenCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(TextThoiGianVaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(line3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(TextThoiGianRa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(line4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelNoiDungThongTinLayout = new javax.swing.GroupLayout(PanelNoiDungThongTin);
        PanelNoiDungThongTin.setLayout(PanelNoiDungThongTinLayout);
        PanelNoiDungThongTinLayout.setHorizontalGroup(
            PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PanelCacText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(LabelTieuDe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelNoiDungThongTinLayout.setVerticalGroup(
            PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoiDungThongTinLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LabelTieuDe)
                .addGap(29, 29, 29)
                .addGroup(PanelNoiDungThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelCacText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        PanelThongTin.add(PanelNoiDungThongTin);

        PanelSua.setBackground(new java.awt.Color(0, 0, 0));
        PanelSua.setPreferredSize(new java.awt.Dimension(100, 30));

        Sua.setBackground(new java.awt.Color(0, 0, 0));
        Sua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Sua.setForeground(new java.awt.Color(255, 255, 255));
        Sua.setText("Sửa");
        Sua.setOpaque(true);

        javax.swing.GroupLayout PanelSuaLayout = new javax.swing.GroupLayout(PanelSua);
        PanelSua.setLayout(PanelSuaLayout);
        PanelSuaLayout.setHorizontalGroup(
            PanelSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Sua))
        );
        PanelSuaLayout.setVerticalGroup(
            PanelSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        PanelTao.setBackground(new java.awt.Color(0, 0, 0));
        PanelTao.setPreferredSize(new java.awt.Dimension(100, 30));

        Tao.setBackground(new java.awt.Color(0, 0, 0));
        Tao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Tao.setForeground(new java.awt.Color(255, 255, 255));
        Tao.setText("Tạo");
        Tao.setOpaque(true);

        javax.swing.GroupLayout PanelTaoLayout = new javax.swing.GroupLayout(PanelTao);
        PanelTao.setLayout(PanelTaoLayout);
        PanelTaoLayout.setHorizontalGroup(
            PanelTaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTaoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Tao))
        );
        PanelTaoLayout.setVerticalGroup(
            PanelTaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        PanelXoa.setBackground(new java.awt.Color(0, 0, 0));
        PanelXoa.setPreferredSize(new java.awt.Dimension(100, 30));

        Xoa.setBackground(new java.awt.Color(0, 0, 0));
        Xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Xoa.setForeground(new java.awt.Color(255, 255, 255));
        Xoa.setText("Xóa");
        Xoa.setOpaque(true);

        javax.swing.GroupLayout PanelXoaLayout = new javax.swing.GroupLayout(PanelXoa);
        PanelXoa.setLayout(PanelXoaLayout);
        PanelXoaLayout.setHorizontalGroup(
            PanelXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelXoaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Xoa))
        );
        PanelXoaLayout.setVerticalGroup(
            PanelXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Xoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        PanelTimKiem.setBackground(new java.awt.Color(0, 0, 0));
        PanelTimKiem.setPreferredSize(new java.awt.Dimension(100, 30));

        LabelTimKiem.setBackground(new java.awt.Color(0, 0, 0));
        LabelTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        LabelTimKiem.setText("Tìm Kiếm");
        LabelTimKiem.setOpaque(true);

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LabelTimKiem))
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelInputLayout = new javax.swing.GroupLayout(PanelInput);
        PanelInput.setLayout(PanelInputLayout);
        PanelInputLayout.setHorizontalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInputLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInputLayout.createSequentialGroup()
                        .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInputLayout.createSequentialGroup()
                                .addComponent(PanelTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                                .addComponent(PanelSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)))
                        .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PanelXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );
        PanelInputLayout.setVerticalGroup(
            PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInputLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(PanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        ScrollPane.setPreferredSize(new java.awt.Dimension(800, 440));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Ca", "Tên Ca", "Giờ Vào Ca", "Giờ Ra Ca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPane.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setMinWidth(40);
            Table.getColumnModel().getColumn(0).setPreferredWidth(50);
            Table.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        LabelTenBang.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        LabelTenBang.setText("BẢNG CA");

        PanelTimKiem1.setBackground(new java.awt.Color(219, 189, 142));
        PanelTimKiem1.setMaximumSize(new java.awt.Dimension(306, 32));
        PanelTimKiem1.setMinimumSize(new java.awt.Dimension(306, 32));
        PanelTimKiem1.setPreferredSize(new java.awt.Dimension(156, 32));

        TextFieldTimKiem.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        TextFieldTimKiem.setForeground(new java.awt.Color(0, 102, 0));
        TextFieldTimKiem.setText("Tìm theo mã");
        TextFieldTimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TextFieldTimKiem.setMaximumSize(new java.awt.Dimension(120, 18));
        TextFieldTimKiem.setMinimumSize(new java.awt.Dimension(120, 18));
        TextFieldTimKiem.setPreferredSize(new java.awt.Dimension(120, 18));

        LabelAnhTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search.png"))); // NOI18N

        javax.swing.GroupLayout PanelTimKiem1Layout = new javax.swing.GroupLayout(PanelTimKiem1);
        PanelTimKiem1.setLayout(PanelTimKiem1Layout);
        PanelTimKiem1Layout.setHorizontalGroup(
            PanelTimKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiem1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(TextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(LabelAnhTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTimKiem1Layout.setVerticalGroup(
            PanelTimKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiem1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PanelTimKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelAnhTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTaiLai.setBackground(new java.awt.Color(0, 0, 0));
        PanelTaiLai.setPreferredSize(new java.awt.Dimension(100, 30));

        LabelTaiLai.setBackground(new java.awt.Color(0, 0, 0));
        LabelTaiLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTaiLai.setForeground(new java.awt.Color(255, 255, 255));
        LabelTaiLai.setText("Tải Lại");
        LabelTaiLai.setOpaque(true);

        javax.swing.GroupLayout PanelTaiLaiLayout = new javax.swing.GroupLayout(PanelTaiLai);
        PanelTaiLai.setLayout(PanelTaiLaiLayout);
        PanelTaiLaiLayout.setHorizontalGroup(
            PanelTaiLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTaiLaiLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(LabelTaiLai))
        );
        PanelTaiLaiLayout.setVerticalGroup(
            PanelTaiLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTaiLaiLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(LabelTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout PanelTongLayout = new javax.swing.GroupLayout(PanelTong);
        PanelTong.setLayout(PanelTongLayout);
        PanelTongLayout.setHorizontalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTongLayout.createSequentialGroup()
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(PanelLichLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(PanelCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTongLayout.createSequentialGroup()
                        .addComponent(PanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                                .addComponent(PanelTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PanelTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelTenBang)
                .addGap(483, 483, 483))
        );
        PanelTongLayout.setVerticalGroup(
            PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTongLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelLichLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LabelTenBang)
                .addGap(23, 23, 23)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(PanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void data(JTable table) {
        CaLamBUS.getInstance().data(table);
    }

    public void TaiLaiTrang() {
        data(Table);
        TextMaCa.setText(CaLamBUS.getInstance().MaTuDong());
        TextTenCa.setText("");
        TextThoiGianRa.setText("");
        TextThoiGianVaoCa.setText("");
        TextFieldTimKiem.setText("Tìm theo mã");
    }

    public void TimKiem() {
        String ma = TextMaCa.getText();
        String ten = TextTenCa.getText();
        String in = TextThoiGianVaoCa.getText();
        String out = TextThoiGianRa.getText();

        CaLamBUS.getInstance().TimKiem(Table, "", ten, in, out);
    }

    public void insert() {
        String ma = TextMaCa.getText();
        String ten = TextTenCa.getText();
        String in = TextThoiGianVaoCa.getText();
        String out = TextThoiGianRa.getText();

        if (ten.equals("")) {
            TextTenCa.requestFocus();
            JOptionPane.showMessageDialog(null, "Không bỏ trống ô Tên Ca Làm");
            return;
        }

        if (in.equals("")) {
            TextThoiGianVaoCa.requestFocus();
            JOptionPane.showMessageDialog(null, "Không bỏ trống ô Thời Gian Vào Ca Làm");
            return;
        }

        if (!LichLam_CaLam.check_time_CaLam(in).equals("")) {
            JOptionPane.showMessageDialog(null, LichLam_CaLam.check_time_CaLam(in), "Sai định dạng (hh:mm)", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (out.equals("")) {
            TextThoiGianRa.requestFocus();
            JOptionPane.showMessageDialog(null, "Không bỏ trống ô Thời Gian Ra Ca Làm");
            return;
        }

        if (out.equals(in)) {
            TextThoiGianRa.requestFocus();
            JOptionPane.showMessageDialog(null, "Giờ vào và giờ ra trùng nhau");
            return;
        }

        if (!LichLam_CaLam.check_time_CaLam(out).equals("")) {
            JOptionPane.showMessageDialog(null, LichLam_CaLam.check_time_CaLam(in), "Sai định dạng (hh:mm)", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm ca làm không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            boolean i = CaLamBUS.getInstance().insert(ma, ten, in, out);
            if (i) {
                TaiLaiTrang();
            }
        }
    }

    public void update() {

        String ma = TextMaCa.getText();
        String ten = TextTenCa.getText();
        String in = TextThoiGianVaoCa.getText();
        String out = TextThoiGianRa.getText();
        if (ma.equals(CaLamBUS.getInstance().MaTuDong())) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 ca làm trong danh sách để sửa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (ten.equals("")) {
                TextTenCa.requestFocus();
                JOptionPane.showMessageDialog(null, "Không bỏ trống ô Tên Ca Làm");
                return;
            }

            if (in.equals("")) {
                TextThoiGianVaoCa.requestFocus();
                JOptionPane.showMessageDialog(null, "Không bỏ trống ô Thời Gian Vào Ca Làm");
                return;
            }

            if (!LichLam_CaLam.check_time_CaLam(in).equals("")) {
                JOptionPane.showMessageDialog(null, LichLam_CaLam.check_time_CaLam(in), "Sai định dạng (hh:mm)", JOptionPane.WARNING_MESSAGE);
                TextThoiGianVaoCa.requestFocus();
                return;
            }

            if (out.equals("")) {
                TextThoiGianRa.requestFocus();
                JOptionPane.showMessageDialog(null, "Không bỏ trống ô Thời Gian Ra Ca Làm");
                return;
            }

            if (out.equals(in)) {
                TextThoiGianRa.requestFocus();
                JOptionPane.showMessageDialog(null, "Giờ vào và giờ ra trùng nhau");
                return;
            }

            if (!LichLam_CaLam.check_time_CaLam(out).equals("")) {
                JOptionPane.showMessageDialog(null, LichLam_CaLam.check_time_CaLam(out), "Sai định dạng (hh:mm)", JOptionPane.WARNING_MESSAGE);
                TextThoiGianRa.requestFocus();
                return;
            }

            int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa ca làm không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                int i = CaLamBUS.getInstance().update(ma, ten, in, out);
                if ((i == 1) || (i == 0)) {
                    TaiLaiTrang();
                }
            }
        }
    }

    public void delete() {
        String ma = TextMaCa.getText();

        if (ma.equals(CaLamBUS.getInstance().MaTuDong())) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 ca làm trong danh sách để xóa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (ma.equals("")) {
                TextTenCa.requestFocus();
                JOptionPane.showMessageDialog(null, "Không bỏ trống ô Mã Ca Làm");
                return;
            }

            int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa ca làm không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                CaLamBUS.getInstance().delete(ma);
                TaiLaiTrang();
            }
        }
    }

    public void nhomNutChucNang() {
        data(Table);
        TaiLaiTrang();
        PanelCaLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelCaLam.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelCaLam.setBackground(new Color(219, 189, 142));
            }
        });
        PanelLichLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelLichLam.setBackground(new Color(199, 159, 95));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelLichLam.setBackground(new Color(219, 189, 142));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelTong.removeAll();
                n6_LichLamGUI lich = new n6_LichLamGUI();
                PanelTong.setLayout(new BorderLayout());
                PanelTong.add(lich, BorderLayout.CENTER); // Adjust the layout constraint as needed
                PanelTong.revalidate();
                PanelTong.repaint();
            }
        });

        PanelTao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelTao.setBackground(new Color(106, 105, 105));
                Tao.setOpaque(true);
                Tao.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelTao.setBackground(new Color(0, 0, 0));
                Tao.setOpaque(true);
                Tao.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insert();
                data(Table);
            }
        });
        PanelSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelSua.setBackground(new Color(106, 105, 105));
                Sua.setOpaque(true);
                Sua.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelSua.setBackground(new Color(0, 0, 0));
                Sua.setOpaque(true);
                Sua.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update();
                data(Table);
            }
        });

        PanelXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelXoa.setBackground(new Color(106, 105, 105));
                Xoa.setOpaque(true);
                Xoa.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelXoa.setBackground(new Color(0, 0, 0));
                Xoa.setOpaque(true);
                Xoa.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete();
                data(Table);
            }
        });

        PanelTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelTimKiem.setBackground(new Color(106, 105, 105));
                LabelTimKiem.setOpaque(true);
                LabelTimKiem.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelTimKiem.setBackground(new Color(0, 0, 0));
                LabelTimKiem.setOpaque(true);
                LabelTimKiem.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimKiem();
            }
        });

        TextFieldTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    CaLamBUS.getInstance().TimKiem(Table, TextFieldTimKiem.getText(), "", "", "");
                }
            }
        });

        TextFieldTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldTimKiem.setText("");
            }
        });

        PanelTaiLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelTaiLai.setBackground(new Color(106, 105, 105));
                LabelTaiLai.setOpaque(true);
                LabelTaiLai.setBackground(new Color(106, 105, 105));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelTaiLai.setBackground(new Color(0, 0, 0));
                LabelTaiLai.setOpaque(true);
                LabelTaiLai.setBackground(new Color(0, 0, 0));
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TaiLaiTrang();
            }
        });

        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int count = Table.getSelectedRow();
                TableModel model = Table.getModel();
                TextMaCa.setText(model.getValueAt(count, 1).toString());
                TextTenCa.setText(model.getValueAt(count, 2).toString());
                TextThoiGianVaoCa.setText(Util.LichLam_CaLam.time_sql_sang_hhmm(model.getValueAt(count, 3).toString()));
                TextThoiGianRa.setText(Util.LichLam_CaLam.time_sql_sang_hhmm(model.getValueAt(count, 4).toString()));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CaLam;
    private javax.swing.JLabel LabelAnhTimKiem;
    private javax.swing.JLabel LabelTaiLai;
    private javax.swing.JLabel LabelTenBang;
    private javax.swing.JLabel LabelTieuDe;
    private javax.swing.JLabel LabelTimKiem;
    private javax.swing.JLabel LichLam;
    private javax.swing.JLabel MaCa;
    private javax.swing.JPanel PanelCaLam;
    private javax.swing.JPanel PanelCacText;
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel PanelLichLam;
    private javax.swing.JPanel PanelNoiDungThongTin;
    private javax.swing.JPanel PanelSua;
    private javax.swing.JPanel PanelTaiLai;
    private javax.swing.JPanel PanelTao;
    private javax.swing.JPanel PanelThongTin;
    private javax.swing.JPanel PanelThuocTinh;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JPanel PanelTimKiem1;
    private javax.swing.JPanel PanelTong;
    private javax.swing.JPanel PanelXoa;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JLabel Sua;
    private javax.swing.JTable Table;
    private javax.swing.JLabel Tao;
    private javax.swing.JLabel TenCa;
    private javax.swing.JTextField TextFieldTimKiem;
    private javax.swing.JTextField TextMaCa;
    private javax.swing.JTextField TextTenCa;
    private javax.swing.JTextField TextThoiGianRa;
    private javax.swing.JTextField TextThoiGianVaoCa;
    private javax.swing.JLabel ThoiGianRa;
    private javax.swing.JLabel ThoiGianVao;
    private javax.swing.JLabel Xoa;
    private javax.swing.JSeparator line1;
    private javax.swing.JSeparator line2;
    private javax.swing.JSeparator line3;
    private javax.swing.JSeparator line4;
    // End of variables declaration//GEN-END:variables
}
