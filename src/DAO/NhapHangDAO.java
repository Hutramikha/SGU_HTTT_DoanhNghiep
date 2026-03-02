
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
        try (Connection c = JDBCUtil.getConnection()) {
            Statement stmt = c.createStatement();
            String loadDataTable_KhoHang = "select MaNguyenLieu, TenNguyenLieu, KhoiLuongNguyenLieu from NguyenLieu";
            ResultSet rs = stmt.executeQuery(loadDataTable_KhoHang);

            while (rs.next()) {
                String maNguyenLieu = rs.getString("MaNguyenLieu");
                String tenNguyenLieu = rs.getString("TenNguyenLieu");
                double khoiLuong = rs.getDouble("KhoiLuongNguyenLieu");
                data.add(new Object[]{maNguyenLieu, tenNguyenLieu, khoiLuong});
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
   
    public ArrayList<Object[]> searchNguyenLieuByTen(String tenNguyenLieu) {
        ArrayList<Object[]> data = new ArrayList<>();
        try (Connection c = JDBCUtil.getConnection()) {
            String sql = "SELECT MaNguyenLieu, TenNguyenLieu, KhoiLuongNguyenLieu " +
                        "FROM NguyenLieu " +
                        "WHERE TenNguyenLieu LIKE ? " +
                        "ORDER BY CAST(SUBSTRING(MaNguyenLieu, 3, LEN(MaNguyenLieu) - 2) AS INT)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "%" + tenNguyenLieu + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maNguyenLieu = rs.getString("MaNguyenLieu");
                String tenNguyenLieuResult = rs.getString("TenNguyenLieu");
                double khoiLuongNguyenLieu = rs.getDouble("KhoiLuongNguyenLieu");
                data.add(new Object[]{maNguyenLieu, tenNguyenLieuResult, khoiLuongNguyenLieu});
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    public void updateNguyenLieu(DefaultTableModel model) throws SQLException {
        try (Connection conn = JDBCUtil.getConnection()) {
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            for (int i = 0; i < model.getRowCount(); i++) {
                String maNguyenLieu = (String) model.getValueAt(i, 0);
                double khoiLuongNhap = (double) model.getValueAt(i, 2);
                int donGiaMoi = (int) model.getValueAt(i, 3);

                // Kiểm tra xem nguyên liệu đã tồn tại trong cơ sở dữ liệu hay chưa
                String sqlCheck = "SELECT KhoiLuongNguyenLieu, DonGiaNguyenLieu FROM NguyenLieu WHERE MaNguyenLieu = ?";
                pstmt = conn.prepareStatement(sqlCheck);
                pstmt.setString(1, maNguyenLieu);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    // Nguyên liệu đã tồn tại, cập nhật khối lượng
                    double khoiLuongHienTai = rs.getDouble("KhoiLuongNguyenLieu");
                    double khoiLuongMoi = khoiLuongHienTai + khoiLuongNhap;
                    khoiLuongMoi = Math.round(khoiLuongMoi * 100.0) / 100.0;

                    String sqlUpdate = "UPDATE NguyenLieu SET KhoiLuongNguyenLieu = ?, DonGiaNguyenLieu=? WHERE MaNguyenLieu = ?";
                    pstmt = conn.prepareStatement(sqlUpdate);
                    pstmt.setDouble(1, khoiLuongMoi);
                    pstmt.setInt(2, donGiaMoi);
                    pstmt.setString(3, maNguyenLieu);
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
          
}
