package BUS;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import DAO.PhieuNhapDAO;

public class PhieuNhapBUS {

    private PhieuNhapDAO phieuNhapDAO;
    private SimpleDateFormat ngayThangNam = new SimpleDateFormat("dd-MM-yyyy");
    private Locale locale = new Locale.Builder().setLanguage("vi").setRegion("VN").build();
    private NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

    public PhieuNhapBUS() {
        phieuNhapDAO = new PhieuNhapDAO();
    }

    public void loadDataToTable_PhieuNhap(JTable table) {
        if (table == null) {
            throw new IllegalArgumentException("Table is null");
        }

        ArrayList<Object[]> data = phieuNhapDAO.getDataFromDatabase();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data

        for (Object[] row : data) {
            String maPhieuNhap = (String) row[0];
            Date ngayLapPhieuNhap = (Date) row[1];
            String ngayLapPhieuNhapStr = ngayThangNam.format(ngayLapPhieuNhap);
            int tongTien = (int) row[2];
            String tongTienStr = numberFormat.format(tongTien) + "đ"; // Format number with separator
            String maNhanVien = (String) row[3];
            String maNhaCungCap = (String) row[4];

            model.addRow(new Object[]{maPhieuNhap, ngayLapPhieuNhapStr, tongTienStr, maNhanVien, maNhaCungCap});
        }
    }

    public static class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Make all cells non-editable
        }
    }

    public String getMaxMaPhieuNhap() throws SQLException {
        return phieuNhapDAO.getMaxMaPhieuNhap();
    }

    public String taoMaPhieuNhapNew() throws SQLException {
        String maxMaPhieuNhap = getMaxMaPhieuNhap();
        if (maxMaPhieuNhap == null) {
            return "PN001";
        }

        int number = Integer.parseInt(maxMaPhieuNhap.substring(2)) + 1;
        return "PN" + String.format("%03d", number);
    }

    public String addPhieuNhap(String ngayLapPhieuNhap, int tongTienPhieuNhap, String maNhaCungCap, String maNhanVien) throws SQLException {
        String maPhieuNhap = taoMaPhieuNhapNew();
        maNhanVien = getMaNhanVien(maNhanVien);
        maNhaCungCap = getMaNhaCungCap(maNhaCungCap);
        return phieuNhapDAO.addPhieuNhap(maPhieuNhap, ngayLapPhieuNhap, tongTienPhieuNhap, maNhaCungCap, maNhanVien);
    }

    public boolean isMaNhanVienExists(String maNhanVien) throws SQLException {
        return phieuNhapDAO.isMaNhanVienExists(maNhanVien);
    }

    public String getMaNhanVien(String maNhanVien) throws SQLException {
        return phieuNhapDAO.getMaNhanVien(maNhanVien);
    }

    public String getMaNhaCungCap(String tenNhaCungCap) throws SQLException {
        return phieuNhapDAO.getMaNhaCungCap(tenNhaCungCap);
    }

    public void searchPhieuNhapByMa(JTable table, String maPhieuNhap) {
        if (table == null) {
            throw new IllegalArgumentException("Table is null");
        }

        ArrayList<Object[]> data = phieuNhapDAO.searchPhieuNhapByMa(maPhieuNhap);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data

        for (Object[] row : data) {
            String maPhieuNhapResult = (String) row[0];
            Date ngayLapPhieuNhap = (Date) row[1];
            String ngayLapPhieuNhapStr = ngayThangNam.format(ngayLapPhieuNhap);
            int tongTien = (int) row[2];
            String tongTienStr = numberFormat.format(tongTien) + "đ";
            String maNhanVien = (String) row[3];
            String maNhaCungCap = (String) row[4];

            model.addRow(new Object[]{maPhieuNhapResult, ngayLapPhieuNhapStr, tongTienStr, maNhanVien, maNhaCungCap});
        }
    }

    public void searchPhieuNhap(JTable table, Date tuNgay, Date denNgay, Integer giaTu, Integer giaDen) {
        if (table == null) {
            throw new IllegalArgumentException("Table is null");
        }

        ArrayList<Object[]> data = phieuNhapDAO.searchPhieuNhap(tuNgay, denNgay, giaTu, giaDen);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data

        for (Object[] row : data) {
            model.addRow(row);
        }
    }
}
