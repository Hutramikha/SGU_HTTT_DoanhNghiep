package DAO;

import DTO.NhaCungCapDTO;
import Util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO {

    public List<NhaCungCapDTO> getDanhSachNhaCungCap() {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM NhaCungCap")) {
            ResultSet rs = stmt.executeQuery();
            List<NhaCungCapDTO> listNCC = new ArrayList<>();
            while (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO(
                        rs.getString("MaNhaCungCap"),
                        rs.getString("TenNhaCungCap"),
                        rs.getString("DiaChiNhaCungCap"),
                        rs.getString("SoDienThoaiNhaCungCap"),
                        rs.getBoolean("TrangThaiNhaCungCap")
                );
                listNCC.add(ncc);
            }
            return listNCC;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean themNhaCungCap(NhaCungCapDTO ncc) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "INSERT INTO NhaCungCap (MaNhaCungCap, TenNhaCungCap, DiaChiNhaCungCap, SoDienThoaiNhaCungCap, TrangThaiNhaCungCap) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, ncc.getMaNhaCungCap());
            stmt.setString(2, ncc.getTenNhaCungCap());
            stmt.setString(3, ncc.getDiaChiNhaCungCap());
            stmt.setString(4, ncc.getSoDienThoaiNhaCungCap());
            stmt.setBoolean(5, ncc.isTrangThaiNhaCungCap());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateInfoNhaCungCap(NhaCungCapDTO ncc) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "UPDATE NhaCungCap SET TenNhaCungCap = ?, DiaChiNhaCungCap = ?, SoDienThoaiNhaCungCap = ?, TrangThaiNhaCungCap = ? WHERE MaNhaCungCap = ?")) {
            stmt.setString(1, ncc.getTenNhaCungCap());
            stmt.setString(2, ncc.getDiaChiNhaCungCap());
            stmt.setString(3, ncc.getSoDienThoaiNhaCungCap());
            stmt.setBoolean(4, ncc.isTrangThaiNhaCungCap());
            stmt.setString(5, ncc.getMaNhaCungCap());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNhaCungCap(String maNCC) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM NhaCungCap WHERE MaNhaCungCap = ?")) {
            stmt.setString(1, maNCC);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public NhaCungCapDTO getNhaCungCapByMaNCC(String maNCC) {
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM NhaCungCap WHERE MaNhaCungCap = ?")) {
            stmt.setString(1, maNCC);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO(
                        rs.getString("MaNhaCungCap"),
                        rs.getString("TenNhaCungCap"),
                        rs.getString("DiaChiNhaCungCap"),
                        rs.getString("SoDienThoaiNhaCungCap"),
                        rs.getBoolean("TrangThaiNhaCungCap")
                );
                return ncc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public String layMaNhaCungCapCuoiCung() {
//        String maNCC = "";
//        try (Connection connection = JDBCUtil.getConnection();
//             PreparedStatement stmt = connection.prepareStatement("SELECT TOP 1 MaNhaCungCap FROM NhaCungCap ORDER BY MaNhaCungCap DESC")) {
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                maNCC = rs.getString("MaNhaCungCap");
//                int maNCCInt = Integer.parseInt(maNCC.substring(3)) + 1;
//                if (maNCCInt < 10) {
//                    maNCC = "NCC00" + maNCCInt;
//                } else if (10 <= maNCCInt && maNCCInt < 100) {
//                    maNCC = "NCC0" + maNCCInt;
//                } else {
//                    maNCC = "NCC" + maNCCInt;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return maNCC;
//    }
}
