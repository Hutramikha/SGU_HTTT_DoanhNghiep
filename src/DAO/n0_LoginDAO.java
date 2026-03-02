package DAO;

import Util.JDBCUtil;
import DTO.TaiKhoanDTO;

import java.sql.*;

public class n0_LoginDAO {

    public TaiKhoanDTO checkLogin(String username, String password) {
        TaiKhoanDTO account = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * from TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ? and TrangThaiTaiKhoan = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String maTK = rs.getString("MaTaiKhoan");
                String tenDangNhap = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                String maQuyen = rs.getString("MaPhanQuyen");
                String maNV = rs.getString("MaNhanVien");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayNghiViec = rs.getDate("NgayNghiViec");
                int trangThai = rs.getInt("TrangThaiTaiKhoan");
                account = new TaiKhoanDTO(maTK, tenDangNhap, matKhau, maQuyen,maNV, ngayCap,ngayNghiViec, trangThai);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new TaiKhoanDTO();
        }
        return account;
    }
}
