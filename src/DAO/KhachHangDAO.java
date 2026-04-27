package DAO;

import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import Util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    public ArrayList<KhachHangDTO> getDanhSachKhachHang() {
        ArrayList<KhachHangDTO> listKH = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                KhachHangDTO kh = new KhachHangDTO(
                        rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getDate("NgaySinhKhachHang"),
                        rs.getString("GioiTinhKhachHang"),
                        rs.getString("SoDienThoaiKhachHang"),
                        rs.getInt("ChiTieuKhachHang"));
                listKH.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public boolean updateInfoKhachHang(KhachHangDTO kh) {
        boolean kq = false;
        String sql = "UPDATE KhachHang SET TenKhachHang = ?, NgaySinhKhachHang = ?, GioiTinhKhachHang = ?, SoDienThoaiKhachHang = ?, ChiTieuKhachHang = ? WHERE MaKhachHang = ?";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, kh.getTenKhachHang());
            stmt.setDate(2, new java.sql.Date(kh.getNgaySinhKhachHang().getTime()));
            stmt.setString(3, kh.getGioiTinhKhachHang());
            stmt.setString(4, kh.getSoDienThoaiKhachHang());
            stmt.setInt(5, kh.getChiTieuKhachHang());
            stmt.setString(6, kh.getMaKhachHang());
            kq = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public boolean deleteKhachHang(String maKH) {
        String sql = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, maKH);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public KhachHangDTO getKhachHangByMaKH(String maKH) {
        String sql = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, maKH);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    KhachHangDTO kh = new KhachHangDTO(
                            rs.getString("MaKhachHang"),
                            rs.getString("TenKhachHang"),
                            rs.getDate("NgaySinhKhachHang"),
                            rs.getString("GioiTinhKhachHang"),
                            rs.getString("SoDienThoaiKhachHang"),
                            rs.getInt("ChiTieuKhachHang"));
                    return kh;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean themKhachHang(KhachHangDTO kh) {
        boolean ketqua = false;
        String sql = "insert into KhachHang(MaKhachHang, TenKhachHang, NgaySinhKhachHang, GioiTinhKhachHang, SoDienThoaiKhachHang, ChiTieuKhachHang) values(?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, layMaKhachHangCuoiCung());
            pre.setString(2, kh.getTenKhachHang());
            pre.setDate(3, kh.getNgaySinhKhachHang());
            pre.setString(4, kh.getGioiTinhKhachHang());
            pre.setString(5, kh.getSoDienThoaiKhachHang());
            pre.setInt(6, kh.getChiTieuKhachHang());
            ketqua = pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public String layMaKhachHangCuoiCung() {
        String maKH = "KH001";
        String sql = "SELECT TOP 1 MaKhachHang FROM KhachHang ORDER BY MaKhachHang DESC";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                maKH = rs.getString("MaKhachHang");
                int maKHInt = Integer.parseInt(maKH.substring(2)) + 1;
                if (maKHInt < 10) {
                    maKH = "KH00" + maKHInt;
                } else if (10 <= maKHInt && maKHInt < 100) {
                    maKH = "KH0" + maKHInt;
                } else {
                    maKH = "KH" + maKHInt;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maKH;
    }

    public ArrayList<KhachHangDTO> getData_KhachHang() {
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "  FROM KhachHang order by MaKhachHang desc";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                KhachHangDTO dto = new KhachHangDTO(rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getDate("NgaySinhKhachHang"),
                        rs.getString("GioiTinhKhachHang"),
                        rs.getString("SoDienThoaiKhachHang"),
                        rs.getInt("ChiTieuKhachHang"));
                list.add(dto);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Không lấy được dữ liệu tất các khách hàng (DAO)");
        }
        return list;
    }

    public ArrayList<KhachHangDTO> getData_KhachHang_theoTen(String ten) {
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        String sql = "select *\n"
                + "from KhachHang\n"
                + "where TenKhachHang like ? order by MaKhachHang desc";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, "%" + ten + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                KhachHangDTO dto = new KhachHangDTO(rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getDate("NgaySinhKhachHang"),
                        rs.getString("GioiTinhKhachHang"),
                        rs.getString("SoDienThoaiKhachHang"),
                        rs.getInt("ChiTieuKhachHang"));
                list.add(dto);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Không lấy được dữ liệu tất các khách hàng (DAO)");
        }
        return list;
    }

    public KhachHangDTO get_khachHang_theoMa(String ma) {
        KhachHangDTO dto = new KhachHangDTO();
        String sql = "select * from KhachHang where MaKhachHang = ?";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, ma);
            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    dto = new KhachHangDTO(rs.getString(1), rs.getString(2), rs.getDate(3),
                            rs.getString(4), rs.getString(5), rs.getInt(6));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public void suaChiTieuKhachHang(int tien, String Ma) {
        String sql = "UPDATE KhachHang "
                + "SET ChiTieuKhachHang = ChiTieuKhachHang + ? "
                + "WHERE MaKhachHang = ?";
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement st = c.prepareStatement(sql)) {
            st.setInt(1, tien);
            st.setString(2, Ma);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật chi tiêu khách hàng:");
            e.printStackTrace();
        }
    }
}
