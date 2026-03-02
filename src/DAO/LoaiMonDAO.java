package DAO;

import DTO.LoaiMonDTO;
import DTO.MonDTO;
import Util.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;

public class LoaiMonDAO {

    public static LoaiMonDAO getInstance() {
        return new LoaiMonDAO();
    }

    public String getMaLoaiMon_theo_TenLoaiMon(String tenLoaiMon) {
        String maLoaiMon = "";
        try {
            String sql = "SELECT MaLoaiMon FROM LoaiMon WHERE TenLoaiMon = ? and TrangThaiLoaiMon = 1";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, tenLoaiMon);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                maLoaiMon = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return maLoaiMon;
    }
    
    public String getTenLoaiMon_theo_MaLoaiMon(String maLoaiMon) {
        String TenLoaiMon = "";
        try {
            String sql = "SELECT TenLoaiMon FROM LoaiMon WHERE MaLoaiMon = ? and TrangThaiLoaiMon = 1";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, maLoaiMon);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                TenLoaiMon = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return TenLoaiMon;
    }

    public ArrayList<String> get_All_TenLoaiMon() {
        ArrayList<String> listLoai = new ArrayList<>();
        String sql = "select TenLoaiMon from LoaiMon where TrangThaiLoaiMon = 1";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String ten = rs.getString(1);
                listLoai.add(ten);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listLoai;
    }

    public static void main(String[] args) {
        String id = LoaiMonDAO.getInstance().getMaLoaiMon_theo_TenLoaiMon("Cà Phê");
        System.out.println(id);
    }
}
