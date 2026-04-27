package DAO;

import java.sql.*;
import java.util.ArrayList;
import Util.JDBCUtil;

public class n10_ThongKeDAO {

    public int TongtienHoadonngay(Date date) {
        String sql = "SELECT COALESCE(SUM(TongTienHoaDon), 0) FROM HoaDon WHERE NgayLapHoaDon = ?";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, date);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int TongtienHoadonThangHienTai() {
        String sql = "SELECT COALESCE(SUM(TongTienHoaDon), 0) FROM HoaDon WHERE MONTH(NgayLapHoaDon) = MONTH(GETDATE()) AND YEAR(NgayLapHoaDon) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int SoluongKHmoi() {
        String sql = "SELECT COUNT(MaKhachHang) FROM KhachHang";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Soluongnvien() {
        String sql = "SELECT COUNT(MaNhanVien) FROM NhanVien WHERE TrangThaiNhanVien = 1";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Soluongncc() {
        String sql = "SELECT COUNT(MaNhaCungCap) FROM NhaCungCap";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int SoluongNguyenlieu() {
        String sql = "SELECT COUNT(MaNguyenLieu) FROM NguyenLieu WHERE TrangThaiNguyenLieu = 1";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int SoluongPhieuNhapTrongThangHienTai() {
        String sql = "SELECT COUNT(MaPhieuNhap) FROM PhieuNhap WHERE MONTH(NgayLapPhieuNhap) = MONTH(GETDATE()) AND YEAR(NgayLapPhieuNhap) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int SoluongHDmoi(Date date) {
        String sql = "SELECT COUNT(MaHoaDon) FROM HoaDon WHERE NgayLapHoaDon = ?";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, date);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Tongmondaban(Date date) {
        String sql = "SELECT COALESCE(SUM(SoLuong), 0) FROM ChiTietHoaDon WHERE MaHoaDon IN (SELECT MaHoaDon FROM HoaDon WHERE NgayLapHoaDon = ?)";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, date);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int[] getTongTienHoaDonTrongTuan() {
        String sql = "SELECT DATEPART(WEEKDAY, NgayLapHoaDon) AS bucket, SUM(TongTienHoaDon) AS value "
                + "FROM HoaDon "
                + "WHERE DATEPART(WEEK, NgayLapHoaDon) = DATEPART(WEEK, GETDATE()) "
                + "AND DATEPART(YEAR, NgayLapHoaDon) = YEAR(GETDATE()) "
                + "GROUP BY DATEPART(WEEKDAY, NgayLapHoaDon)";
        return queryBuckets(sql, 7);
    }

    public int[] getTongtienHoadonTheoQuy() {
        String sql = "SELECT DATEPART(QUARTER, NgayLapHoaDon) AS bucket, SUM(TongTienHoaDon) AS value "
                + "FROM HoaDon "
                + "WHERE YEAR(NgayLapHoaDon) = YEAR(GETDATE()) "
                + "GROUP BY DATEPART(QUARTER, NgayLapHoaDon)";
        return queryBuckets(sql, 4);
    }

    public int[] getTongTienTheoThang() {
        String sql = "SELECT MONTH(NgayLapHoaDon) AS bucket, SUM(TongTienHoaDon) AS value "
                + "FROM HoaDon "
                + "WHERE YEAR(NgayLapHoaDon) = YEAR(GETDATE()) "
                + "GROUP BY MONTH(NgayLapHoaDon)";
        return queryBuckets(sql, 12);
    }

    public ArrayList<Integer> getArrayDoanhthuTuan() {
        return toArrayList(getTongTienHoaDonTrongTuan());
    }

    public ArrayList<Integer> getArrayDoanhthunam() {
        return toArrayList(getTongTienTheoThang());
    }

    public ArrayList<Integer> getArrayDoanhthuquy() {
        return toArrayList(getTongtienHoadonTheoQuy());
    }

    public ArrayList<Integer> getArrayphieunhapnam() {
        String sql = "SELECT MONTH(NgayLapPhieuNhap) AS bucket, COALESCE(SUM(TongTienPhieuNhap), 0) AS value "
                + "FROM PhieuNhap "
                + "WHERE YEAR(NgayLapPhieuNhap) = YEAR(GETDATE()) "
                + "GROUP BY MONTH(NgayLapPhieuNhap)";
        return toArrayList(queryBuckets(sql, 12));
    }

    public ArrayList<Integer> getArrayphieunhapnamtheoquy() {
        String sql = "SELECT DATEPART(QUARTER, NgayLapPhieuNhap) AS bucket, COALESCE(SUM(TongTienPhieuNhap), 0) AS value "
                + "FROM PhieuNhap "
                + "WHERE YEAR(NgayLapPhieuNhap) = YEAR(GETDATE()) "
                + "GROUP BY DATEPART(QUARTER, NgayLapPhieuNhap)";
        return toArrayList(queryBuckets(sql, 4));
    }

    public ArrayList<Integer> getArrayTongLuongnhanvientheothang() {
        String sql = "SELECT x.Thang AS bucket, SUM(nv.LuongNhanVien) AS value "
                + "FROM ( "
                + "    SELECT DISTINCT MONTH(NgayLam) AS Thang, MaNhanVien "
                + "    FROM LichLam "
                + "    WHERE YEAR(NgayLam) = YEAR(GETDATE()) "
                + ") AS x "
                + "JOIN NhanVien nv ON nv.MaNhanVien = x.MaNhanVien "
                + "GROUP BY x.Thang";
        return toArrayList(queryBuckets(sql, 12));
    }

    public ArrayList<Integer> getArrayTongLuongnhanvientheoquy() {
        String sql = "SELECT ((x.Thang - 1) / 3) + 1 AS bucket, SUM(nv.LuongNhanVien) AS value "
                + "FROM ( "
                + "    SELECT DISTINCT MONTH(NgayLam) AS Thang, MaNhanVien "
                + "    FROM LichLam "
                + "    WHERE YEAR(NgayLam) = YEAR(GETDATE()) "
                + ") AS x "
                + "JOIN NhanVien nv ON nv.MaNhanVien = x.MaNhanVien "
                + "GROUP BY ((x.Thang - 1) / 3) + 1";
        return toArrayList(queryBuckets(sql, 4));
    }

    public ArrayList<Integer> getArrayLuongnhanvien(String maNhanVien) {
        String sql = "SELECT MONTH(ll.NgayLam) AS bucket, MAX(nv.LuongNhanVien) AS value "
                + "FROM LichLam ll "
                + "JOIN NhanVien nv ON ll.MaNhanVien = nv.MaNhanVien "
                + "WHERE ll.MaNhanVien = ? AND YEAR(ll.NgayLam) = YEAR(GETDATE()) "
                + "GROUP BY MONTH(ll.NgayLam)";
        return toArrayList(queryBucketsWithStringParam(sql, 12, maNhanVien));
    }

    private int[] queryBuckets(String sql, int size) {
        int[] result = new int[size];
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int bucket = rs.getInt("bucket");
                int value = rs.getInt("value");
                if (bucket >= 1 && bucket <= size) {
                    result[bucket - 1] = value;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int[] queryBucketsWithStringParam(String sql, int size, String param) {
        int[] result = new int[size];
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, param);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int bucket = rs.getInt("bucket");
                    int value = rs.getInt("value");
                    if (bucket >= 1 && bucket <= size) {
                        result[bucket - 1] = value;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private ArrayList<Integer> toArrayList(int[] values) {
        ArrayList<Integer> result = new ArrayList<>(values.length);
        for (int value : values) {
            result.add(value);
        }
        return result;
    }

    public String[][] getkhoiluongNL() {
        ArrayList<String[]> list = new ArrayList<>();
        String sql = "SELECT MaNguyenLieu, TenNguyenLieu, KhoiLuongNguyenLieu FROM NguyenLieu WHERE TrangThaiNguyenLieu = 1";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String[] row = new String[3];
                row[0] = rs.getString("MaNguyenLieu");
                row[1] = rs.getString("TenNguyenLieu");
                row[2] = String.valueOf(rs.getDouble("KhoiLuongNguyenLieu"));
                list.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.toArray(new String[0][0]);
    }

    public int getTongLuongnhanviennam() {
        String sql = "SELECT COALESCE(SUM(nv.LuongNhanVien), 0) "
                + "FROM (SELECT DISTINCT MaNhanVien FROM LichLam WHERE YEAR(NgayLam) = YEAR(GETDATE())) t "
                + "JOIN NhanVien nv ON nv.MaNhanVien = t.MaNhanVien";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTongLuongnhanvienthang() {
        String sql = "SELECT COALESCE(SUM(nv.LuongNhanVien), 0) "
                + "FROM (SELECT DISTINCT MaNhanVien FROM LichLam WHERE MONTH(NgayLam) = MONTH(GETDATE()) AND YEAR(NgayLam) = YEAR(GETDATE())) t "
                + "JOIN NhanVien nv ON nv.MaNhanVien = t.MaNhanVien";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTongDthunam() {
        String sql = "SELECT COALESCE(SUM(TongTienHoaDon), 0) FROM HoaDon WHERE YEAR(NgayLapHoaDon) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTongTienPhieunhapthang() {
        String sql = "SELECT COALESCE(SUM(TongTienPhieuNhap), 0) FROM PhieuNhap WHERE MONTH(NgayLapPhieuNhap) = MONTH(GETDATE()) AND YEAR(NgayLapPhieuNhap) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTongphieunhapnam() {
        String sql = "SELECT COALESCE(SUM(TongTienPhieuNhap), 0) FROM PhieuNhap WHERE YEAR(NgayLapPhieuNhap) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
