
package BUS;
import javax.swing.table.DefaultTableModel;


import DAO.NhapHangDAO;

import javax.swing.JTable;
import java.util.ArrayList;


public class NhapHangBUS {
    private NhapHangDAO nhapHangDAO;

    public NhapHangBUS() {
        nhapHangDAO = new NhapHangDAO();
    }

    public void loadDataToTable_KhoHang(JTable table) {
        if (table == null) {
            throw new IllegalArgumentException("Table cannot be null");
        }

        ArrayList<Object[]> data = nhapHangDAO.getDataFromDatabase();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data

        for (Object[] row : data) {
            String maNguyenLieu = (String) row[0];
            String tenNguyenLieu = (String) row[1];
            double khoiLuong = (double) row[2];
            String trangThai;

            if (khoiLuong >= 1) {
                trangThai = "Còn hàng";
            } else if (khoiLuong > 0.1) {
                trangThai = "Sắp hết";
            } else {
                trangThai = "Hết hàng";
            }

            model.addRow(new Object[]{maNguyenLieu, tenNguyenLieu, khoiLuong, trangThai});
        }
    }

    public static class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Tất cả các ô đều không thể chỉnh sửa
        }
    }
    public boolean isNguyenLieuInChoNhap(JTable table, String maNguyenLieu) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Object value = model.getValueAt(i, 0);
            if (value != null && value.equals(maNguyenLieu)) {
                return true;
            }
        }
        return false;
    }
    
    public void searchNguyenLieuByTen(JTable table, String tenNguyenLieu) {
        if (table == null) {
            throw new IllegalArgumentException("Table is null");
        }
        ArrayList<Object[]> data = nhapHangDAO.searchNguyenLieuByTen(tenNguyenLieu);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            String maNguyenLieuResult = (String) row[0];
            String tenNguyenLieuResult = (String) row[1];
            double khoiLuong = (double) row[2];
            String trangThai = khoiLuong >= 1 ? "Còn hàng" : khoiLuong > 0.1 ? "Sắp hết" : "Hết hàng";
            model.addRow(new Object[]{maNguyenLieuResult, tenNguyenLieuResult, khoiLuong, trangThai});
        }
    }
    public void updateNguyenLieu(DefaultTableModel model) {
        try {
            nhapHangDAO.updateNguyenLieu(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
