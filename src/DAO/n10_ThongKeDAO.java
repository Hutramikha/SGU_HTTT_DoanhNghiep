package DAO;

import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import DTO.HoaDonDTO;
import Util.JDBCUtil;

public class n10_ThongKeDAO {

    public int TongtienHoadonngay(Date date) {
        String sql = "SELECT SUM(TongTien) FROM HOADON WHERE CAST(NgayTao AS DATE) = ?";
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
        String sql = "SELECT SUM(TongTien) FROM HOADON WHERE MONTH(NgayTao) = MONTH(GETDATE()) AND YEAR(NgayTao) = YEAR(GETDATE())";
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
        String sql = "SELECT COUNT(MaKH) FROM KHACHHANG WHERE MONTH(NgayDangKy) = MONTH(GETDATE()) AND YEAR(NgayDangKy) = YEAR(GETDATE())";
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
        String sql = "SELECT COUNT(MaNV) FROM NHANVIEN";
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
        String sql = "SELECT COUNT(MaNCC) FROM NHACUNGCAP";
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
        String sql = "SELECT COUNT(MaNL) FROM NGUYENLIEU";
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
        String sql = "SELECT COUNT(MaPhieu) FROM PHIEUNHAP WHERE MONTH(NgayNhap) = MONTH(GETDATE()) AND YEAR(NgayNhap) = YEAR(GETDATE())";
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
        String sql = "SELECT COUNT(MaHD) FROM HOADON WHERE CAST(NgayTao AS DATE) = ?";
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
        String sql = "SELECT SUM(SoLuong) FROM CTHOADON WHERE MaHD IN (SELECT MaHD FROM HOADON WHERE CAST(NgayTao AS DATE) = ?)";
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
        String sql = "SELECT DATEPART(WEEKDAY, NgayTao) AS bucket, SUM(TongTien) AS value "
                + "FROM HOADON "
                + "WHERE DATEPART(WEEK, NgayTao) = DATEPART(WEEK, GETDATE()) "
                + "AND DATEPART(YEAR, NgayTao) = YEAR(GETDATE()) "
                + "GROUP BY DATEPART(WEEKDAY, NgayTao)";
        return queryBuckets(sql, 7);
    }

    public int[] getTongtienHoadonTheoQuy() {
        String sql = "SELECT DATEPART(QUARTER, NgayTao) AS bucket, SUM(TongTien) AS value "
                + "FROM HOADON "
                + "WHERE YEAR(NgayTao) = YEAR(GETDATE()) "
                + "GROUP BY DATEPART(QUARTER, NgayTao)";
        return queryBuckets(sql, 4);
    }

    public int[] getTongTienTheoThang() {
        String sql = "SELECT MONTH(NgayTao) AS bucket, SUM(TongTien) AS value "
                + "FROM HOADON "
                + "WHERE YEAR(NgayTao) = YEAR(GETDATE()) "
                + "GROUP BY MONTH(NgayTao)";
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
        String sql = "SELECT MONTH(NgayNhap) AS bucket, COUNT(MaPhieu) AS value "
                + "FROM PHIEUNHAP "
                + "WHERE YEAR(NgayNhap) = YEAR(GETDATE()) "
                + "GROUP BY MONTH(NgayNhap)";
        return toArrayList(queryBuckets(sql, 12));
    }

    public ArrayList<Integer> getArrayphieunhapnamtheoquy() {
        String sql = "SELECT DATEPART(QUARTER, NgayNhap) AS bucket, COUNT(MaPhieu) AS value "
                + "FROM PHIEUNHAP "
                + "WHERE YEAR(NgayNhap) = YEAR(GETDATE()) "
                + "GROUP BY DATEPART(QUARTER, NgayNhap)";
        return toArrayList(queryBuckets(sql, 4));
    }

    public ArrayList<Integer> getArrayTongLuongnhanvientheothang() {
        String sql = "SELECT MONTH(NgayLam) AS bucket, COUNT(MaNV) AS value "
                + "FROM LICHLAMVIEC "
                + "WHERE YEAR(NgayLam) = YEAR(GETDATE()) "
                + "GROUP BY MONTH(NgayLam)";
        return toArrayList(queryBuckets(sql, 12));
    }

    public ArrayList<Integer> getArrayTongLuongnhanvientheoquy() {
        String sql = "SELECT DATEPART(QUARTER, NgayLam) AS bucket, COUNT(MaNV) AS value "
                + "FROM LICHLAMVIEC "
                + "WHERE YEAR(NgayLam) = YEAR(GETDATE()) "
                + "GROUP BY DATEPART(QUARTER, NgayLam)";
        return toArrayList(queryBuckets(sql, 4));
    }

    public ArrayList<Integer> getArrayLuongnhanvien(String maNhanVien) {
        String sql = "SELECT MONTH(NgayLam) AS bucket, COUNT(*) AS value "
                + "FROM LICHLAMVIEC "
                + "WHERE MaNV = ? AND YEAR(NgayLam) = YEAR(GETDATE()) "
                + "GROUP BY MONTH(NgayLam)";
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
        String sql = "SELECT MaNL, TenNL, SoLuong FROM NGUYENLIEU";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String[] row = new String[3];
                row[0] = rs.getString("MaNL");
                row[1] = rs.getString("TenNL");
                row[2] = String.valueOf(rs.getInt("SoLuong"));
                list.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.toArray(new String[0][0]);
    }

    public int getTongLuongnhanviennam() {
        String sql = "SELECT COUNT(DISTINCT MaNV) FROM LICHLAMVIEC WHERE YEAR(NgayLam) = YEAR(GETDATE())";
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
        String sql = "SELECT COUNT(DISTINCT MaNV) FROM LICHLAMVIEC WHERE MONTH(NgayLam) = MONTH(GETDATE()) AND YEAR(NgayLam) = YEAR(GETDATE())";
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
        String sql = "SELECT SUM(TongTien) FROM HOADON WHERE YEAR(NgayTao) = YEAR(GETDATE())";
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
        String sql = "SELECT SUM(TongTien) FROM PHIEUNHAP WHERE MONTH(NgayNhap) = MONTH(GETDATE()) AND YEAR(NgayNhap) = YEAR(GETDATE())";
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
        String sql = "SELECT SUM(TongTien) FROM PHIEUNHAP WHERE YEAR(NgayNhap) = YEAR(GETDATE())";
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
