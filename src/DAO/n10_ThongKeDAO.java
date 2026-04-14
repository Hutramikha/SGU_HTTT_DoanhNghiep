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
        int[] result = new int[7];
        String sql = "SELECT SUM(TongTien) FROM HOADON WHERE DATEPART(WEEK, NgayTao) = DATEPART(WEEK, GETDATE()) AND DATEPART(YEAR, NgayTao) = YEAR(GETDATE()) AND DATEPART(WEEKDAY, NgayTao) = ?";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 7; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result[i - 1] = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int[] getTongtienHoadonTheoQuy() {
        int[] result = new int[4];
        String sql = "SELECT SUM(TongTien) FROM HOADON WHERE DATEPART(QUARTER, NgayTao) = ? AND YEAR(NgayTao) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 4; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result[i - 1] = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int[] getTongTienTheoThang() {
        int[] result = new int[12];
        String sql = "SELECT SUM(TongTien) FROM HOADON WHERE MONTH(NgayTao) = ? AND YEAR(NgayTao) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 12; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result[i - 1] = rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getArrayDoanhthuTuan() {
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "SELECT SUM(TongTien) FROM HOADON WHERE DATEPART(WEEK, NgayTao) = DATEPART(WEEK, GETDATE()) AND DATEPART(YEAR, NgayTao) = YEAR(GETDATE()) AND DATEPART(WEEKDAY, NgayTao) = ?";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 7; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getArrayDoanhthunam() {
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "SELECT SUM(TongTien) FROM HOADON WHERE MONTH(NgayTao) = ? AND YEAR(NgayTao) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 12; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getArrayDoanhthuquy() {
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "SELECT SUM(TongTien) FROM HOADON WHERE DATEPART(QUARTER, NgayTao) = ? AND YEAR(NgayTao) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 4; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getArrayphieunhapnam() {
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "SELECT COUNT(MaPhieu) FROM PHIEUNHAP WHERE MONTH(NgayNhap) = ? AND YEAR(NgayNhap) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 12; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getArrayphieunhapnamtheoquy() {
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "SELECT COUNT(MaPhieu) FROM PHIEUNHAP WHERE DATEPART(QUARTER, NgayNhap) = ? AND YEAR(NgayNhap) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 4; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getArrayTongLuongnhanvientheothang() {
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "SELECT COUNT(MaNV) FROM LICHLAMVIEC WHERE MONTH(NgayLam) = ? AND YEAR(NgayLam) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 12; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getArrayTongLuongnhanvientheoquy() {
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "SELECT COUNT(MaNV) FROM LICHLAMVIEC WHERE DATEPART(QUARTER, NgayLam) = ? AND YEAR(NgayLam) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 4; i++) {
                pstmt.setInt(1, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> getArrayLuongnhanvien(String maNhanVien) {
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "SELECT COUNT(*) FROM LICHLAMVIEC WHERE MaNV = ? AND MONTH(NgayLam) = ? AND YEAR(NgayLam) = YEAR(GETDATE())";
        try (Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 12; i++) {
                pstmt.setString(1, maNhanVien);
                pstmt.setInt(2, i);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        result.add(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
