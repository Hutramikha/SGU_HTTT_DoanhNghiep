package DAO;

import Util.JDBCUtil;
import DTO.TaiKhoanDTO;

import java.beans.Statement;
//import java.lang.classfile.instruction.StoreInstruction;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

// import BUS.DangNhapBUS;

public class TaiKhoanDAO {

    public TaiKhoanDAO() {

    }

    public TaiKhoanDTO selectById(String ma, int opt) {
        TaiKhoanDTO taiKhoan = null;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from TaiKhoan where MaNhanVien=?";
            if (opt == 1) {
                sql = sql + " and TrangThaiTaiKhoan=1";
            }
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, ma);
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

                taiKhoan = new TaiKhoanDTO(maTK, tenDangNhap, matKhau, maQuyen,maNV,ngayCap,ngayNghiViec, trangThai);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taiKhoan;
    }

    public ArrayList<TaiKhoanDTO> selectByCondition(String condition) {
        ArrayList<TaiKhoanDTO> taiKhoans = new ArrayList<>();
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from TaiKhoan where " + condition;
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maTK = rs.getString("MaTaiKhoan");
                String tenDangNhap = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                String maQuyen = rs.getString("MaPhanQuyen");
                String maNV = rs.getString("MaNhanVien");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayNghiViec = rs.getDate("NgayNghiViec");
                int trangThai = rs.getInt("TrangThaiTaiKhoan");
                TaiKhoanDTO taiKhoan = new TaiKhoanDTO(maTK, tenDangNhap, matKhau, maQuyen,maNV,ngayCap ,ngayNghiViec, trangThai);
                taiKhoans.add(taiKhoan);
            }
            JDBCUtil.closeConnection(c);
            return taiKhoans;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(TaiKhoanDTO tk) {
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "insert into TaiKhoan(MaTaiKhoan, TenDangNhap, MatKhau, MaPhanQuyen,MaNhanVien, NgayCap, NgayNghiViec, TrangThaiTaiKhoan) "
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, layMaNhanVienCuoiCung());
            pst.setString(2, tk.getTenDangNhap());
            pst.setString(3, tk.getMatKhau());
            pst.setString(4, tk.getMaPhanQuyen());
            pst.setString(5, tk.getMaNhanVien());
            pst.setDate(6,tk.getNgaycap());
            pst.setDate(7, tk.getNgayNghiViec());
            pst.setInt(8, tk.getTrangThaiTaiKhoan());
            pst.executeUpdate();

            JDBCUtil.closeConnection(c);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int update(TaiKhoanDTO tk) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "update TaiKhoan set TenDangNhap=?,MatKhau=?,MaPhanQuyen=?,MaNhanVien = ?, NgayCap=?, NgayNghiViec=?,TrangThaiTaiKhoan=? where MaNhanVien=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, tk.getMaTaiKhoan());
            pst.setString(2, tk.getTenDangNhap());
            pst.setString(3, tk.getMatKhau());
            pst.setString(4, tk.getMaPhanQuyen());
            pst.setString(5, tk.getMaNhanVien());
            pst.setDate(6,tk.getNgaycap());
            pst.setDate(7, tk.getNgayNghiViec());
            pst.setInt(5, tk.getTrangThaiTaiKhoan());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int delete(TaiKhoanDTO tk) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "update TaiKhoan set TrangThaiTaiKhoan=0 where MaNhanVien=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, tk.getMaTaiKhoan());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<TaiKhoanDTO> selectAll() {
        ArrayList<TaiKhoanDTO> taiKhoans = new ArrayList<>();
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from TaiKhoan where TrangThaiTaiKhoan=1";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maTK = rs.getString("MaTaiKhoan");
                String tenDangNhap = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                String maQuyen = rs.getString("MaPhanQuyen");
                String maNV = rs.getString("MaNhanVien");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayNghiViec = rs.getDate("NgayNghiViec");
                int trangThai = rs.getInt("TrangThaiTaiKhoan");
                TaiKhoanDTO taiKhoan = new TaiKhoanDTO(maTK, tenDangNhap, matKhau, maQuyen,maNV, ngayCap,ngayNghiViec, trangThai);
                taiKhoans.add(taiKhoan);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taiKhoans;
    }

    public String getIdNV(String ma){
        String manv = "";
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select MaNhanVien from TaiKhoan where MaNhanVien = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, ma);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                manv = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manv;
    }

    public String getMkByMaNhanVien(String ma){
        String matKhau = "";
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select MatKhau from TaiKhoan where MaNhanVien = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, ma);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                matKhau = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matKhau;
    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from TaiKhoan where TenDangNhap = '" + tenDangNhap + "'";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String layTenDangNhapTheoMa(String ma) {
        try {
            String sql = "SELECT TenDangNhap FROM TaiKhoan WHERE MaNhanVien='" + ma +"'";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String layQuyenTheoMa(String ma) {
        try {
            String sql = "SELECT MaPhanQuyen FROM TaiKhoan WHERE MaNhanVien='" + ma +"'";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean datLaiMatKhau(String ma, String tenDangNhap) {
        try {
            String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaNhanVien=?";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, tenDangNhap);
            pre.setString(2, ma);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean datLaiQuyen(String ma, String quyen) {
        try {
            String sql = "UPDATE TaiKhoan SET MaPhanQuyen=? WHERE MaNhanVien=?";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, quyen);
            pre.setString(2, ma);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean khoaTaiKhoan(String ma) {
        try {
            String sql = "UPDATE TaiKhoan SET TrangThaiTaiKhoan=0, NgayNghiViec=? WHERE MaNhanVien=?";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setDate(1, getCurrentSqlDate());
            pre.setString(2, ma);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Date getCurrentSqlDate() {
        LocalDate currentDate = LocalDate.now();
        return Date.valueOf(currentDate);
    }

    public boolean moKhoaTaiKhoan(String ma) {
        try {
            String sql = "UPDATE TaiKhoan SET TrangThaiTaiKhoan=1, NgayNghiViec=? WHERE MaNhanVien=?";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setDate(1, null);
            pre.setString(2, ma);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean doiMatKhauAdmin(String matKhauMoi, String matKhauCu, String maNV) {
        try {
            String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaNhanVien=? AND MatKhau=?";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, matKhauMoi);
            pre.setString(2, maNV);
            pre.setString(3, matKhauCu);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getTrangThai(String ma) {
        int flag=0;
        try {
            String sql = "SELECT TrangThaiTaiKhoan FROM TaiKhoan WHERE MaNhanVien = ?";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1,  ma); // Truyền tham số vào câu lệnh SQL
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                flag = rs.getInt(1); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public String layMaNhanVienCuoiCung() {
        String maTK = "TK001";
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "SELECT TOP 1 MaTaiKhoan FROM TaiKhoan ORDER BY MaTaiKhoan DESC";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                maTK = String.valueOf(Integer.parseInt(rs.getString("MaTaiKhoan").substring(2)) + 1);
                
                if(Integer.parseInt(maTK)<10){
                    maTK = "TK00" + maTK;
                }else if(10 <= Integer.parseInt(maTK) && Integer.parseInt(maTK)<999){
                    maTK = "TK0" + maTK;
                }
                else
                    maTK = "TK" + maTK;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maTK;
    }
}
