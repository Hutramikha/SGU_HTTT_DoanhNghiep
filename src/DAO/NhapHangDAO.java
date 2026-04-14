
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Util.JDBCUtil;

public class NhapHangDAO {
    public NhapHangDAO() {
    }

    public ArrayList<Object[]> getDataFromDatabase() {
        ArrayList<Object[]> data = new ArrayList<>();
        try (Connection c = JDBCUtil.getConnection();
                Statement stmt = c.createStatement();
                ResultSet rs = stmt
                        .executeQuery("select MaNguyenLieu, TenNguyenLieu, KhoiLuongNguyenLieu from NguyenLieu")) {
            while (rs.next()) {
                String maNguyenLieu = rs.getString("MaNguyenLieu");
                String tenNguyenLieu = rs.getString("TenNguyenLieu");
                double khoiLuong = rs.getDouble("KhoiLuongNguyenLieu");
                data.add(new Object[] { maNguyenLieu, tenNguyenLieu, khoiLuong });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<Object[]> searchNguyenLieuByTen(String tenNguyenLieu) {
        ArrayList<Object[]> data = new ArrayList<>();
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement ps = c.prepareStatement("SELECT MaNguyenLieu, TenNguyenLieu, KhoiLuongNguyenLieu " +
                        "FROM NguyenLieu " +
                        "WHERE TenNguyenLieu LIKE ? " +
                        "ORDER BY CAST(SUBSTRING(MaNguyenLieu, 3, LEN(MaNguyenLieu) - 2) AS INT)")) {
            ps.setString(1, "%" + tenNguyenLieu + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String maNguyenLieu = rs.getString("MaNguyenLieu");
                    String tenNguyenLieuResult = rs.getString("TenNguyenLieu");
                    double khoiLuongNguyenLieu = rs.getDouble("KhoiLuongNguyenLieu");
                    data.add(new Object[] { maNguyenLieu, tenNguyenLieuResult, khoiLuongNguyenLieu });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void updateNguyenLieu(DefaultTableModel model) throws SQLException {
        try (Connection conn = JDBCUtil.getConnection()) {
            for (int i = 0; i < model.getRowCount(); i++) {
                String maNguyenLieu = (String) model.getValueAt(i, 0);
                double khoiLuongNhap = (double) model.getValueAt(i, 2);
                int donGiaMoi = (int) model.getValueAt(i, 3);

                String sqlCheck = "SELECT KhoiLuongNguyenLieu, DonGiaNguyenLieu FROM NguyenLieu WHERE MaNguyenLieu = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sqlCheck)) {
                    pstmt.setString(1, maNguyenLieu);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            double khoiLuongHienTai = rs.getDouble("KhoiLuongNguyenLieu");
                            double khoiLuongMoi = khoiLuongHienTai + khoiLuongNhap;
                            khoiLuongMoi = Math.round(khoiLuongMoi * 100.0) / 100.0;

                            String sqlUpdate = "UPDATE NguyenLieu SET KhoiLuongNguyenLieu = ?, DonGiaNguyenLieu=? WHERE MaNguyenLieu = ?";
                            try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                                updateStmt.setDouble(1, khoiLuongMoi);
                                updateStmt.setInt(2, donGiaMoi);
                                updateStmt.setString(3, maNguyenLieu);
                                updateStmt.executeUpdate();
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
