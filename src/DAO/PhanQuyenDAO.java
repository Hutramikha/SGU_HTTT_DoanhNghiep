
package DAO;

import Util.JDBCUtil;
import DTO.PhanQuyenDTO;
import GUI.n0_TrangChuGUI;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhanQuyenDAO {

    public PhanQuyenDAO() {
    }

    public int insert(PhanQuyenDTO t) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "insert into PhanQuyen(MaPhanQuyen,TenQuyen,QuyenKhachHang,QuyenBanHang,QuyenNhapHang,QuyenMon,QuyenNguyenLieu,QuyenLichLam,QuyenKhuyenMaiUuDai,QuyenNhaCungCap,QuyenNhanVien,QuyenThongKe,TrangThaiPhanQuyen) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaPhanQuyen());
            pst.setString(2, "" + t.getTenQuyen());
            pst.setBoolean(3, t.getQuyenKhachHang());
            pst.setBoolean(4, t.getQuyenBanHang());
            pst.setBoolean(5, t.getQuyenNhapHang());
            pst.setBoolean(6, t.getQuyenMon());
            pst.setBoolean(7, t.getQuyenNguyenLieu());
            pst.setBoolean(8, t.getQuyenLichLam());
            pst.setBoolean(9, t.getQuyenKhuyenMaiUuDai());
            pst.setBoolean(10, t.getQuyenNhaCungCap());
            pst.setBoolean(11, t.getQuyenNhanVien());
            pst.setBoolean(12, t.getQuyenThongKe());
            pst.setBoolean(13, t.getTrangThaiPhanQuyen());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int update(PhanQuyenDTO t) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "update PhanQuyen set QuyenKhachHang=?,QuyenBanHang=?,QuyenNhapHang=?,QuyenMon=?,QuyenNguyenLieu=?,QuyenLichLam=?,QuyenKhuyenMaiUuDai=?,QuyenNhaCungCap=?,QuyenNhanVien=?,QuyenThongKe=? where MaPhanQuyen=? ";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setBoolean(1, t.getQuyenKhachHang());
            pst.setBoolean(2, t.getQuyenBanHang());
            pst.setBoolean(3 ,t.getQuyenNhapHang());
            pst.setBoolean(4, t.getQuyenMon());
            pst.setBoolean(5, t.getQuyenNguyenLieu());
            pst.setBoolean(6, t.getQuyenLichLam());
            pst.setBoolean(7, t.getQuyenKhuyenMaiUuDai());
            pst.setBoolean(8, t.getQuyenNhaCungCap());
            pst.setBoolean(9, t.getQuyenNhanVien());
            pst.setBoolean(10,t.getQuyenThongKe());
            pst.setString(11, t.getMaPhanQuyen());

            ketQua = pst.executeUpdate();

            JDBCUtil.closeConnection(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int delete(String ma) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "update PhanQuyen set TrangThaiPhanQuyen=0 where MaPhanQuyen = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, ma);

            ketQua = pst.executeUpdate();

            JDBCUtil.closeConnection(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<PhanQuyenDTO> selectAll() {
        ArrayList<PhanQuyenDTO> phanQuyens = new ArrayList<>();
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from PhanQuyen where TrangThaiPhanQuyen=1";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maQuyen = rs.getString("MaPhanQuyen");
                String tenQuyen = rs.getString("TenQuyen");
                boolean khachhang = rs.getBoolean("QuyenKhachHang");
                boolean banhang = rs.getBoolean("QuyenBanHang");
                boolean nhaphang = rs.getBoolean("QuyenNhapHang");
                boolean mon = rs.getBoolean("QuyenMon");
                boolean nguyenlieu = rs.getBoolean("QuyenNguyenLieu");
                boolean lichlam = rs.getBoolean("QuyenLichLam");
                boolean kmud = rs.getBoolean("QuyenKhuyenMaiUuDai");
                boolean nhacc = rs.getBoolean("QuyenNhaCungCap");
                boolean nhanvien = rs.getBoolean("QuyenNhanVien");
                boolean thongke = rs.getBoolean("QuyenThongKe");
                boolean trangThai = rs.getBoolean("TrangThaiPhanQuyen");
                PhanQuyenDTO phanQuyen = new PhanQuyenDTO(maQuyen, tenQuyen, khachhang, banhang, nhaphang, mon, nguyenlieu, lichlam, kmud, nhacc, nhanvien, thongke, trangThai);
                phanQuyens.add(phanQuyen);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanQuyens;
    }

    public PhanQuyenDTO selectById(PhanQuyenDTO id) {
        PhanQuyenDTO phanQuyen = null;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from PhanQuyen where MaPhanQuyen=? and TrangThaiPhanQuyen=1";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, id.getMaPhanQuyen());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maQuyen = rs.getString("MaPhanQuyen");
                String tenQuyen = rs.getString("TenQuyen");
                boolean khachhang = rs.getBoolean("QuyenKhachHang");
                boolean banhang = rs.getBoolean("QuyenBanHang");
                boolean nhaphang = rs.getBoolean("QuyenNhapHang");
                boolean mon = rs.getBoolean("QuyenMon");
                boolean nguyenlieu = rs.getBoolean("QuyenNguyenLieu");
                boolean lichlam = rs.getBoolean("QuyenLichLam");
                boolean kmud = rs.getBoolean("QuyenKhuyenMaiUuDai");
                boolean nhacc = rs.getBoolean("QuyenNhaCungCap");
                boolean nhanvien = rs.getBoolean("QuyenNhanVien");
                boolean thongke = rs.getBoolean("QuyenThongKe");
                boolean trangThai = rs.getBoolean("TrangThaiPhanQuyen");
                phanQuyen = new PhanQuyenDTO(maQuyen, tenQuyen, khachhang, banhang, 
                                            nhaphang, mon, nguyenlieu, lichlam, kmud, nhacc, nhanvien, thongke, trangThai);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanQuyen;
    }

    public PhanQuyenDTO selectByName(String tQ) {
        PhanQuyenDTO phanQuyen = null;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from PhanQuyen where TenQuyen=? and TrangThaiPhanQuyen=1";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, tQ);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maQuyen = rs.getString("MaPhanQuyen");
                String tenQuyen = rs.getString("TenQuyen");
                boolean khachhang = rs.getBoolean("QuyenKhachHang");
                boolean banhang = rs.getBoolean("QuyenBanHang");
                boolean nhaphang = rs.getBoolean("QuyenNhapHang");
                boolean mon = rs.getBoolean("QuyenMon");
                boolean nguyenlieu = rs.getBoolean("QuyenNguyenLieu");
                boolean lichlam = rs.getBoolean("QuyenLichLam");
                boolean kmud = rs.getBoolean("QuyenKhuyenMaiUuDai");
                boolean nhacc = rs.getBoolean("QuyenNhaCungCap");
                boolean nhanvien = rs.getBoolean("QuyenNhanVien");
                boolean thongke = rs.getBoolean("QuyenThongKe");
                boolean trangThai = rs.getBoolean("TrangThaiPhanQuyen");
                phanQuyen = new PhanQuyenDTO(maQuyen, tenQuyen, khachhang, banhang, 
                                            nhaphang, mon, nguyenlieu, lichlam, kmud, nhacc, nhanvien, thongke, trangThai);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanQuyen;
    }

    public ArrayList<PhanQuyenDTO> selectByCondition(String condition) {
        ArrayList<PhanQuyenDTO> phanQuyens = new ArrayList<>();
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from PhanQuyen where " + condition;
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maQuyen = rs.getString("MaPhanQuyen");
                String tenQuyen = rs.getString("TenQuyen");
                boolean khachhang = rs.getBoolean("QuyenKhachHang");
                boolean banhang = rs.getBoolean("QuyenBanHang");
                boolean nhaphang = rs.getBoolean("QuyenNhapHang");
                boolean mon = rs.getBoolean("QuyenMon");
                boolean nguyenlieu = rs.getBoolean("QuyenNguyenLieu");
                boolean lichlam = rs.getBoolean("QuyenLichLam");
                boolean kmud = rs.getBoolean("QuyenKhuyenMaiUuDai");
                boolean nhacc = rs.getBoolean("QuyenNhaCungCap");
                boolean nhanvien = rs.getBoolean("QuyenNhanVien");
                boolean thongke = rs.getBoolean("QuyenThongKe");
                boolean trangThai = rs.getBoolean("TrangThaiPhanQuyen");
                PhanQuyenDTO phanQuyen = new PhanQuyenDTO(maQuyen, tenQuyen, khachhang, banhang, 
                                            nhaphang, mon, nguyenlieu, lichlam, kmud, nhacc, nhanvien, thongke, trangThai);
                phanQuyens.add(phanQuyen);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanQuyens;
    }

    public String LayMaPhanQuyenCuoiCung() {
        String ma = "";
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select TOP 1 MaPhanQuyen FROM PhanQuyen ORDER BY MaPhanQuyen DESC";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                ma = String.valueOf(Integer.parseInt(rs.getString("MaPhanQuyen").substring(2)) + 1);
                if(Integer.parseInt(ma)<10){
                    ma = "PQ00" + ma;
                }else if(10<=Integer.parseInt(ma) &&Integer.parseInt(ma)<999){
                    ma = "PQ0" + ma;
                }
                else
                    ma = "PQ" + ma;
            }
            JDBCUtil.closeConnection(c);
            return ma;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ma;
    }

    public String getIdByName(String name) {
        String ma = "";
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from PhanQuyen where TenQuyen = ? and TrangThaiPhanQuyen = 1";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ma = rs.getString("MaPhanQuyen");
            }
            JDBCUtil.closeConnection(c);
            return ma;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ma;
    }

}
