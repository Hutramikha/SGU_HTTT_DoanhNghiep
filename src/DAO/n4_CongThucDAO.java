package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CongThucDTO;
import Util.JDBCUtil;

public class n4_CongThucDAO {
      public ArrayList<CongThucDTO> getAll() {
            ArrayList<CongThucDTO> listCongThuc = new ArrayList<>();
            try {
                  String sql = "SELECT * FROM CongThuc";
                  Connection c = JDBCUtil.getConnection();
                  PreparedStatement pre = c.prepareStatement(sql);
                  ResultSet rs = pre.executeQuery();
                  while (rs.next()) {

                        String maMon = rs.getString(1);
                        String maNguyenLieu = rs.getString(2);
                        Double khoiLuong = rs.getDouble(3);

                        CongThucDTO congThuc = new CongThucDTO(maMon, maNguyenLieu, khoiLuong);
                        listCongThuc.add(congThuc);
                  }
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return listCongThuc;
      }
      public ArrayList<CongThucDTO> getCongThucByMaMon(String maMon) {
            ArrayList<CongThucDTO> listCongThuc = new ArrayList<>();
            try {
                  String sql = "SELECT * FROM CongThuc WHERE MaMon = ?" ;
                  Connection c = JDBCUtil.getConnection();
                  PreparedStatement pre = c.prepareStatement(sql);
                  pre.setString(1, maMon);
                  ResultSet rs = pre.executeQuery();
                  while (rs.next()) {

                        String ma = rs.getString(1);
                        String maNguyenLieu = rs.getString(2);
                        Double khoiLuong = rs.getDouble(3);

                        CongThucDTO congThuc = new CongThucDTO(ma, maNguyenLieu, khoiLuong);
                        listCongThuc.add(congThuc);
                  }
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return listCongThuc;
      }
      
      public boolean addCongThuc(CongThucDTO congThuc) {
            boolean result = false;
            try {
                  Connection c = JDBCUtil.getConnection();
                  String sql = "INSERT INTO CongThuc(MaMon, MaNguyenLieu, KhoiLuong) VALUES(?,?,?)";
                  PreparedStatement prep = c.prepareStatement(sql);
                  prep.setString(1, congThuc.getMaMon());
                  prep.setString(2, congThuc.getMaNguyenLieu());
                  prep.setDouble(3, congThuc.getKhoiLuong());

                  if(prep.executeUpdate() > 0) {
                        result = true;
                  }
                  JDBCUtil.closeConnection(c);
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return result;
      }

      public boolean deleteCongThuc(CongThucDTO congThuc) {
            boolean result = false;
            String sql = "DELETE FROM CongThuc WHERE MaMon = ? AND MaNguyenLieu = ?";
            
            try (Connection c = JDBCUtil.getConnection();
                  PreparedStatement prep = c.prepareStatement(sql)) {
                  
                  prep.setString(1, congThuc.getMaMon());
                  prep.setString(2, congThuc.getMaNguyenLieu());
                  
                  result = prep.executeUpdate() > 0; // Cập nhật kết quả trực tiếp
                  
            } catch (SQLException ex) {
                  System.err.println("Lỗi khi xóa công thức: " + ex.getMessage());
            }
            
            return result; // Đảm bảo trả về đúng kết quả
      }

      public boolean updateCongThuc(CongThucDTO congThuc) {
            boolean result = false;
            try {
                  Connection c = JDBCUtil.getConnection();
                  String sql = "UPDATE CongThuc SET KhoiLuong=? WHERE MaMon=? AND MaNguyenLieu = ?";
                  PreparedStatement prep = c.prepareStatement(sql);
                  prep.setDouble(1, congThuc.getKhoiLuong());
                  prep.setString(2, congThuc.getMaMon());
                  prep.setString(3, congThuc.getMaNguyenLieu());
                  if (prep.executeUpdate() > 0) {
                        result = true;
                  }
                  JDBCUtil.closeConnection(c);
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return result;
      }
      public CongThucDTO getCongThucByMaMonVaMaNguyenLieu(CongThucDTO congThuc) {
            try {
                  String sql = "SELECT * FROM CongThuc WHERE MaMon = ? AND MaNguyenLieu = ?";
                  Connection c = JDBCUtil.getConnection();
                  PreparedStatement pre = c.prepareStatement(sql);
                  pre.setString(1, congThuc.getMaMon());
                  pre.setString(2, congThuc.getMaNguyenLieu());
                  ResultSet rs = pre.executeQuery();
                  if (rs.next()) {

                        String maMon = rs.getString(1);
                        String maNguyenLieu = rs.getString(2);
                        Double khoiLuong = rs.getDouble(3);

                        CongThucDTO temp = new CongThucDTO(maMon, maNguyenLieu, khoiLuong);
                        return temp;
                  }
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return null;
      }
}
