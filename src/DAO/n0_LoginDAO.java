package DAO;

import Util.JDBCUtil;
import DTO.TaiKhoanDTO;

import java.sql.*;

public class n0_LoginDAO {

    public TaiKhoanDTO checkLogin(String username, String password) {
        TaiKhoanDTO account = null;
        System.out.println("[DEBUG] 🔍 Login: Attempting to authenticate user: " + username);
        long startTime = System.currentTimeMillis();

        try {
            System.out.println("[DEBUG] ⏳ Getting connection from pool...");
            long connStart = System.currentTimeMillis();
            Connection con = JDBCUtil.getConnection();
            System.out.println("[DEBUG] ✓ Connection acquired in " + (System.currentTimeMillis() - connStart) + "ms");

            if (con == null) {
                System.out.println("[DEBUG] ❌ Connection is NULL!");
                return new TaiKhoanDTO();
            }

            System.out.println("[DEBUG] ⏳ Preparing statement...");
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT * from TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ? and TrangThaiTaiKhoan = 1")) {
                pst.setString(1, username);
                pst.setString(2, password);

                System.out.println("[DEBUG] ⏳ Executing query...");
                long queryStart = System.currentTimeMillis();
                try (ResultSet rs = pst.executeQuery()) {
                    System.out
                            .println("[DEBUG] ✓ Query executed in " + (System.currentTimeMillis() - queryStart) + "ms");

                    if (rs.next()) {
                        String maTK = rs.getString("MaTaiKhoan");
                        String tenDangNhap = rs.getString("TenDangNhap");
                        String matKhau = rs.getString("MatKhau");
                        String maQuyen = rs.getString("MaPhanQuyen");
                        String maNV = rs.getString("MaNhanVien");
                        Date ngayCap = rs.getDate("NgayCap");
                        Date ngayNghiViec = rs.getDate("NgayNghiViec");
                        int trangThai = rs.getInt("TrangThaiTaiKhoan");
                        account = new TaiKhoanDTO(maTK, tenDangNhap, matKhau, maQuyen, maNV, ngayCap, ngayNghiViec,
                                trangThai);
                        System.out.println("[DEBUG] ✓ Login successful for user: " + tenDangNhap + " (Total time: "
                                + (System.currentTimeMillis() - startTime) + "ms)");
                    } else {
                        System.out.println("[DEBUG] ❌ No user found with credentials");
                    }
                }
            } finally {
                JDBCUtil.returnConnection(con);
            }
        } catch (Exception e) {
            System.out.println("[DEBUG] ❌ Login error: " + e.getMessage());
            e.printStackTrace();
            return new TaiKhoanDTO();
        }
        return account;
    }
}
