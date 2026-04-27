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
        String sql = "SELECT * from NhanVien WHERE MaNhanVien = ? and TrangThaiNhanVien = 1";
        try (Connection con = JDBCUtil.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maNhanVien);
            try (ResultSet rs = pst.executeQuery()) {
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
                    account = new NhanVienDTO(MaNhanVien, TenNhanVien, GioiTinhNhanVien, SoDienThoaiNhanVien,
                            NgaySinhNhanVien, ChucVuNhanVien, DiaChi, LuongNhanVien, TrangThaiNhanVien);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public PhanQuyenDTO getPhanQuyen(String maNhanVien) {
        PhanQuyenDTO dto = null;
        String sql = "SELECT pq.* "
            + "FROM TaiKhoan tk "
            + "JOIN PhanQuyen pq ON pq.MaPhanQuyen = tk.MaPhanQuyen "
            + "WHERE tk.MaNhanVien = ? AND tk.TrangThaiTaiKhoan = 1 AND pq.TrangThaiPhanQuyen = 1";
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement st = c.prepareStatement(sql)) {
            st.setString(1, maNhanVien);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
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
                            trangThaiPhanQuyen);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return dto; // Trả về danh sách quyền
    }

}
