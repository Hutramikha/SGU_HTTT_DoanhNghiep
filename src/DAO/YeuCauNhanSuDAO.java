package DAO;

import DTO.YeuCauNhanSuDTO;
import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class YeuCauNhanSuDAO {

    public String layMaYeuCauCuoiCung() {
        String maYC = "";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection
                        .prepareStatement("SELECT TOP 1 MaYeuCau FROM YeuCauNhanSu ORDER BY MaYeuCau DESC");
                ResultSet rs = pre.executeQuery()) {
            if (rs.next()) {
                String current = rs.getString("MaYeuCau");
                int next = Integer.parseInt(current.substring(2)) + 1;
                if (next < 10) {
                    maYC = "YC00" + next;
                } else if (next < 100) {
                    maYC = "YC0" + next;
                } else {
                    maYC = "YC" + next;
                }
            } else {
                maYC = "YC001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maYC;
    }

    public boolean themYeuCau(YeuCauNhanSuDTO yc) {
        String sql = "INSERT INTO YeuCauNhanSu(MaYeuCau, MaNhanVien, LoaiYeuCau, TuNgay, DenNgay, LyDo, TrangThai, MaQuanLyDuyet, NgayTao, NgayDuyet) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, yc.getMaYeuCau());
            pre.setString(2, yc.getMaNhanVien());
            pre.setString(3, yc.getLoaiYeuCau());
            pre.setDate(4, yc.getTuNgay());
            pre.setDate(5, yc.getDenNgay());
            pre.setString(6, yc.getLyDo());
            pre.setString(7, yc.getTrangThai());
            pre.setString(8, yc.getMaQuanLyDuyet());
            pre.setDate(9, yc.getNgayTao());
            pre.setDate(10, yc.getNgayDuyet());
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public YeuCauNhanSuDTO getById(String maYeuCau) {
        String sql = "SELECT * FROM YeuCauNhanSu WHERE MaYeuCau = ?";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, maYeuCau);
            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<YeuCauNhanSuDTO> getByMaNhanVien(String maNhanVien) {
        String sql = "SELECT * FROM YeuCauNhanSu WHERE MaNhanVien = ? ORDER BY NgayTao DESC";
        ArrayList<YeuCauNhanSuDTO> list = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, maNhanVien);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<YeuCauNhanSuDTO> getByTrangThai(String trangThai) {
        String sql = "SELECT * FROM YeuCauNhanSu WHERE TrangThai = ? ORDER BY NgayTao DESC";
        ArrayList<YeuCauNhanSuDTO> list = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, trangThai);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateTrangThai(String maYeuCau, String trangThai, String maQuanLyDuyet, Date ngayDuyet) {
        String sql = "UPDATE YeuCauNhanSu SET TrangThai = ?, MaQuanLyDuyet = ?, NgayDuyet = ? WHERE MaYeuCau = ?";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, trangThai);
            pre.setString(2, maQuanLyDuyet);
            pre.setDate(3, ngayDuyet);
            pre.setString(4, maYeuCau);
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private YeuCauNhanSuDTO mapRow(ResultSet rs) throws SQLException {
        YeuCauNhanSuDTO dto = new YeuCauNhanSuDTO();
        dto.setMaYeuCau(rs.getString("MaYeuCau"));
        dto.setMaNhanVien(rs.getString("MaNhanVien"));
        dto.setLoaiYeuCau(rs.getString("LoaiYeuCau"));
        dto.setTuNgay(rs.getDate("TuNgay"));
        dto.setDenNgay(rs.getDate("DenNgay"));
        dto.setLyDo(rs.getString("LyDo"));
        dto.setTrangThai(rs.getString("TrangThai"));
        dto.setMaQuanLyDuyet(rs.getString("MaQuanLyDuyet"));
        dto.setNgayTao(rs.getDate("NgayTao"));
        dto.setNgayDuyet(rs.getDate("NgayDuyet"));
        return dto;
    }
}
