package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Util.*;
import DTO.ChiTietPhieuNhapDTO;

public class ChiTietPhieuNhapDAO {

    public ArrayList<Object[]> getChiTietPhieuNhap(String maPhieuNhap) {
        ArrayList<Object[]> data = new ArrayList<>();
        try (Connection c = JDBCUtil.getConnection();
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "SELECT ct.MaNguyenLieu, nl.TenNguyenLieu, ct.KhoiLuong, ct.DonGia, ct.ThanhTien " +
                                "FROM ChiTietPhieuNhap ct " +
                                "JOIN NguyenLieu nl ON ct.MaNguyenLieu = nl.MaNguyenLieu " +
                                "WHERE ct.MaPhieuNhap = '" + maPhieuNhap + "'")) {
            while (rs.next()) {
                String maNguyenLieu = rs.getString("MaNguyenLieu");
                String tenNguyenLieu = rs.getString("TenNguyenLieu");
                double khoiLuong = rs.getDouble("KhoiLuong");
                int donGia = rs.getInt("DonGia");
                int thanhTien = rs.getInt("ThanhTien");
                data.add(new Object[] { maNguyenLieu, tenNguyenLieu, khoiLuong, donGia, thanhTien });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void addChiTietPhieuNhap(String maPhieuNhap, String maNguyenLieu, double khoiLuong, int donGia,
            int thanhTien) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pstms = c.prepareStatement(
                        "insert into ChiTietPhieuNhap(MaPhieuNhap, MaNguyenLieu, KhoiLuong, DonGia, ThanhTien) values(?,?,?,?,?)")) {
            pstms.setString(1, maPhieuNhap);
            pstms.setString(2, maNguyenLieu);
            pstms.setDouble(3, khoiLuong);
            pstms.setInt(4, donGia);
            pstms.setInt(5, thanhTien);
            pstms.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
