package DAO;

import DTO.NhanVienDTO;
import Util.JDBCUtil;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVienDAO {

    public ArrayList<NhanVienDTO> getDanhSachNhanVien() {
        try (Connection connection = JDBCUtil.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from NhanVien")) {
            ArrayList<NhanVienDTO> listNV = new ArrayList<>();
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNhanVien(rs.getString(1));
                nv.setTenNhanVien(rs.getString(2));
                nv.setGioiTinhNhanVien(rs.getString(3));
                nv.setSoDienThoaiNhanVien(rs.getString(4));
                nv.setNgaySinhNhanVien(rs.getDate(5));
                nv.setChucVuNhanVien(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setLuongNhanVien(rs.getInt(8));
                nv.setTrangThaiNhanVien(rs.getInt(9));
                listNV.add(nv);
            }
            return listNV;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateInfoNhanVien(NhanVienDTO nv, String ma) {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(
                        "update NhanVien set TenNhanVien=?, GioiTinhNhanVien=?, SoDienThoaiNhanVien=?, NgaySinhNhanVien=?, ChucVuNhanVien=?, DiaChi=?, LuongNhanVien=? where MaNhanVien=?")) {
            pre.setString(1, nv.getTenNhanVien());
            pre.setString(2, nv.getGioiTinhNhanVien());
            pre.setString(3, nv.getSoDienThoaiNhanVien());
            pre.setDate(4, nv.getNgaySinhNhanVien());
            pre.setString(5, nv.getChucVuNhanVien());
            pre.setString(6, nv.getDiaChi());
            pre.setInt(7, nv.getLuongNhanVien());
            pre.setString(8, ma);
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean capNhatChucVu(NhanVienDTO nv) {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection
                        .prepareStatement("update NhanVien set ChucVuNhanVien=? where MaNhanVien=?")) {
            pre.setString(1, nv.getChucVuNhanVien());
            pre.setString(2, nv.getMaNhanVien());
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getTrangThai(String ma) {
        System.out.println(ma);
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c
                        .prepareStatement("SELECT TrangThaiNhanVien FROM NhanVien WHERE MaNhanVien = ?")) {
            pre.setString(1, ma);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getChucVuTheoMa(String ma) {
        System.out.println(ma);
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c
                        .prepareStatement("SELECT ChucVuNhanVien FROM NhanVien WHERE MaNhanVien = ?")) {
            pre.setString(1, ma);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    return rs.getString(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean moKhoaNhanVien(String ma) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c
                        .prepareStatement("UPDATE NhanVien SET TrangThaiNhanVien= 1 WHERE MaNhanVien=?")) {
            pre.setString(1, ma);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNhanVien(String MaNV) {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("update NhanVien set TrangThaiNhanVien = 0 where MaNhanVien = ?")) {
            preparedStatement.setString(1, MaNV);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTrangThaiNhanVien(String maNhanVien, int trangThai) {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("update NhanVien set TrangThaiNhanVien = ? where MaNhanVien = ?")) {
            preparedStatement.setInt(1, trangThai);
            preparedStatement.setString(2, maNhanVien);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String layMaNhanVienCuoiCung() {
        String maNV = "";
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection
                        .prepareStatement("SELECT TOP 1 MaNhanVien FROM NhanVien ORDER BY MaNhanVien DESC");
                ResultSet rs = pre.executeQuery()) {
            if (rs.next()) {
                maNV = String.valueOf(Integer.parseInt(rs.getString("MaNhanVien").substring(2)) + 1);
                if (Integer.parseInt(maNV) < 10) {
                    maNV = "NV00" + maNV;
                } else if (10 <= Integer.parseInt(maNV) && Integer.parseInt(maNV) < 999) {
                    maNV = "NV0" + maNV;
                } else
                    maNV = "NV" + maNV;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maNV;
    }

    public boolean themNhanVien(NhanVienDTO nv) {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(
                        "insert into NhanVien(MaNhanvien, TenNhanVien, GioiTinhNhanVien, SoDienThoaiNhanVien, NgaySinhNhanVien, ChucVuNhanVien, DiaChi, LuongNhanVien, TrangThaiNhanVien)  values(?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            pre.setString(1, layMaNhanVienCuoiCung());
            pre.setString(2, nv.getTenNhanVien());
            pre.setString(3, nv.getGioiTinhNhanVien());
            pre.setString(4, nv.getSoDienThoaiNhanVien());
            pre.setDate(5, nv.getNgaySinhNhanVien());
            pre.setString(6, nv.getChucVuNhanVien());
            pre.setString(7, nv.getDiaChi());
            pre.setInt(8, nv.getLuongNhanVien());
            pre.setInt(9, nv.getTrangThaiNhanVien());
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public NhanVienDTO getNhanVien(String maNV) {
        NhanVienDTO nv = null;
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement("select * from NhanVien where MaNhanVien = ?")) {
            pre.setString(1, maNV);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    nv = new NhanVienDTO();
                    nv.setMaNhanVien(maNV);
                    nv.setTenNhanVien(rs.getString(2));
                    nv.setGioiTinhNhanVien(rs.getString(3));
                    nv.setSoDienThoaiNhanVien(rs.getString(4));
                    nv.setNgaySinhNhanVien(rs.getDate(5));
                    nv.setChucVuNhanVien(rs.getString(6));
                    nv.setDiaChi(rs.getString(7));
                    nv.setLuongNhanVien(rs.getInt(8));
                }
            }
            return nv;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public NhanVienDTO getNhanVienTheoTen(String tenNV) {
        NhanVienDTO nv = null;
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement("select * from NhanVien where TenNhanVien = ?")) {
            pre.setString(1, tenNV);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    nv = new NhanVienDTO();
                    nv.setMaNhanVien(rs.getString(1));
                    nv.setTenNhanVien(rs.getString(2));
                    nv.setGioiTinhNhanVien(rs.getString(3));
                    nv.setSoDienThoaiNhanVien(rs.getString(4));
                    nv.setNgaySinhNhanVien(rs.getDate(5));
                    nv.setChucVuNhanVien(rs.getString(6));
                    nv.setDiaChi(rs.getString(7));
                    nv.setLuongNhanVien(rs.getInt(8));
                }
            }
            return nv;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deletaFKHoandon_PhieuNhap() {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection
                        .prepareStatement("ALTER TABLE HoaDon DROP CONSTRAINT FK_MaNhanVien_HoaDon;"
                                + "ALTER TABLE PhieuNhap DROP CONSTRAINT FK_MaNhanVien_PhieuNhap;")) {
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateFKHoandon_PhieuNhap() {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(
                        "ALTER TABLE HoaDon ADD CONSTRAINT FK_MaNhanVien_HoaDon FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien);"
                                + "ALTER TABLE PhieuNhap ADD CONSTRAINT FK_MaNhanVien_PhieuNhap FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien);")) {
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean xoaAllInfor() {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement("delete from NhanVien;")) {
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean importNhanVienFromExcel(NhanVienDTO nv) {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection.prepareStatement(
                        "INSERT INTO NhanVien(MaNhanVien, TenNhanVien, GioiTinhNhanVien, SoDienThoaiNhanVien, NgaySinhNhanVien, ChucVuNhanVien, DiaChi, LuongNhanVien, TrangThaiNhanVien) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);")) {
            pre.setString(1, nv.getMaNhanVien());
            pre.setString(2, nv.getTenNhanVien());
            pre.setString(3, nv.getGioiTinhNhanVien());
            pre.setString(4, nv.getSoDienThoaiNhanVien());
            pre.setDate(5, nv.getNgaySinhNhanVien());
            pre.setString(6, nv.getChucVuNhanVien());
            pre.setString(7, nv.getDiaChi());
            pre.setInt(8, nv.getLuongNhanVien());
            pre.setInt(9, nv.getTrangThaiNhanVien());
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public String layMaNhanVien(String maNV) {
        try (Connection connection = JDBCUtil.getConnection();
                PreparedStatement pre = connection
                        .prepareStatement("select MaNhanVien from NhanVien where MaNhanVien=?")) {
            pre.setString(1, maNV);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    return rs.getString(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {

        NhanVienDAO trang_mau = new NhanVienDAO();
        System.out.println(trang_mau.getTrangThai("NV001"));

    }
}
