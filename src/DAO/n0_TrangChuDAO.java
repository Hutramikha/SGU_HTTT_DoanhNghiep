package DAO;

import java.sql.Date;
import java.sql.*;
import java.util.*;

import DTO.NhanVienDTO;
import DTO.PhanQuyenDTO;
import Util.JDBCUtil;

public class n0_TrangChuDAO {

    public NhanVienDTO getById(String maNhanVien) {
        NhanVienDTO account = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * from NhanVien WHERE MaNhanVien = ? and TrangThaiNhanVien = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maNhanVien);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String MaNhanVien = rs.getString("MaNhanVien");
                String TenNhanVien = rs.getString("TenNhanVien");
                String GioiTinhNhanVien = rs.getString("GioiTinhNhanVien");
                String SoDienThoaiNhanVien = rs.getString("SoDienThoaiNhanVien");
                Date NgaySinhNhanVien = rs.getDate("NgaySinhNhanVien");
                String ChucVuNhanVien = rs.getString("ChucVuNhanVien");
                String DiaChi = rs.getString("DiaChi");
                int LuongNhanVien = rs.getInt("LuongNhanVien");
                int TrangThaiNhanVien = rs.getInt("TrangThaiNhanVien");
                account = new NhanVienDTO(MaNhanVien, TenNhanVien, GioiTinhNhanVien, SoDienThoaiNhanVien, NgaySinhNhanVien, ChucVuNhanVien, DiaChi, LuongNhanVien, TrangThaiNhanVien);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public PhanQuyenDTO getPhanQuyen(String maNhanVien) {
        PhanQuyenDTO dto = null;
        try {
            // SQL để lấy thông tin quyền từ bảng PhanQuyen
            String sql = "select * from PhanQuyen "
                    + "where MaPhanQuyen = "
                    + "(select MaPhanQuyen from TaiKhoan where MaNhanVien = ?)";

            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, maNhanVien);  // sửa lại chỉ số tham số từ 0 -> 1
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                // Đọc dữ liệu từ ResultSet và tạo đối tượng PhanQuyenDTO
                String maPhanQuyen = rs.getString("MaPhanQuyen");
                String tenQuyen = rs.getString("TenQuyen");
                boolean quyenKhachHang = rs.getBoolean("QuyenKhachHang");
                boolean quyenBanHang = rs.getBoolean("QuyenBanHang");
                boolean quyenNhapHang = rs.getBoolean("QuyenNhapHang");
                boolean quyenMon = rs.getBoolean("QuyenMon");
                boolean quyenNguyenLieu = rs.getBoolean("QuyenNguyenLieu");
                boolean quyenLichLam = rs.getBoolean("QuyenLichLam");
                boolean quyenKhuyenMaiUuDai = rs.getBoolean("QuyenKhuyenMaiUuDai");
                boolean quyenNhaCungCap = rs.getBoolean("QuyenNhaCungCap");
                boolean quyenNhanVien = rs.getBoolean("QuyenNhanVien");
                boolean quyenThongKe = rs.getBoolean("QuyenThongKe");
                boolean trangThaiPhanQuyen = rs.getBoolean("TrangThaiPhanQuyen");

                // Tạo đối tượng PhanQuyenDTO và thêm vào danh sách
                dto = new PhanQuyenDTO(
                        maPhanQuyen,
                        tenQuyen,
                        quyenKhachHang,
                        quyenBanHang,
                        quyenNhapHang,
                        quyenMon,
                        quyenNguyenLieu,
                        quyenLichLam,
                        quyenKhuyenMaiUuDai,
                        quyenNhaCungCap,
                        quyenNhanVien,
                        quyenThongKe,
                        trangThaiPhanQuyen
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;  // Trả về null nếu có lỗi
        }
        return dto;  // Trả về danh sách quyền
    }

}
