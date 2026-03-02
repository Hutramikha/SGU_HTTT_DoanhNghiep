package BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.ChiTietPhieuNhapDAO;

import Util.JDBCUtil;

public class ChiTietPhieuNhapBUS {

    private ChiTietPhieuNhapDAO chiTietPhieuNhapDAO;
    Locale locale = new Locale.Builder().setLanguage("vi").setRegion("VN").build();
    NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

    public ChiTietPhieuNhapBUS() {
        chiTietPhieuNhapDAO = new ChiTietPhieuNhapDAO();
    }

    public void loadChiTietPhieuNhapToTable(JTable table, String maPhieuNhap) {
        if (table == null) {
            throw new IllegalArgumentException("Table is null");
        }
        ArrayList<Object[]> data = chiTietPhieuNhapDAO.getChiTietPhieuNhap(maPhieuNhap);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            String maNguyenLieu = (String) row[0];
            String tenNguyenLieu = (String) row[1];
            double khoiLuong = (double) row[2];
            int donGia = (int) row[3];
            String donGiaStr = numberFormat.format(donGia) + "đ";
            int thanhTien = (int) row[4];
            String thanhTienStr = numberFormat.format(thanhTien) + "đ";

            model.addRow(new Object[]{maNguyenLieu, tenNguyenLieu, khoiLuong, donGiaStr, thanhTienStr});
        }
    }
    public void addChiTietPhieuNhap(String maPhieuNhap, String maNguyenLieu, double khoiLuong, int donGia, int thanhTien) {
    chiTietPhieuNhapDAO.addChiTietPhieuNhap(maPhieuNhap, maNguyenLieu, khoiLuong, donGia, thanhTien);
  }
}
