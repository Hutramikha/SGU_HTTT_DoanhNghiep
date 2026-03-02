package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.LoaiMonDTO;
import Util.JDBCUtil;

public class n4_LoaiMonDAO {
      public ArrayList<LoaiMonDTO> getAll() {
            ArrayList<LoaiMonDTO> listLoaiMon = new ArrayList<>();
            try {
                  String sql = "SELECT * FROM LoaiMon WHERE TrangThaiLoaiMon = 1";
                  Connection c = JDBCUtil.getConnection();
                  PreparedStatement pre = c.prepareStatement(sql);
                  ResultSet rs = pre.executeQuery();
                  while (rs.next()) {

                        String maMon = rs.getString(1);
                        String tenLoaiMon = rs.getString(2);
                        boolean trangThaiMon = rs.getBoolean(3);

                        LoaiMonDTO loaiMon = new LoaiMonDTO(maMon, tenLoaiMon, trangThaiMon);
                        listLoaiMon.add(loaiMon);
                  }
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return listLoaiMon;
      }

      public LoaiMonDTO getLoaiMonById(String maLoaiMon) {
            LoaiMonDTO loaiMon = null;
            try {
                  String sql = "SELECT * FROM LoaiMon WHERE MaLoaiMon = ?";
                  Connection c = JDBCUtil.getConnection();
                  PreparedStatement pre = c.prepareStatement(sql);
                  pre.setString(1, maLoaiMon);
                  ResultSet rs = pre.executeQuery();
                  if (rs.next()) {

                        String ma = rs.getString(1);
                        String ten = rs.getString(2);
                        boolean trangThai = rs.getBoolean(3);

                        loaiMon = new LoaiMonDTO(ma, ten, trangThai);
                  }
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return loaiMon;
      }

      public boolean addLoaiMon(LoaiMonDTO loaiMon) {
            boolean result = false;
            try {
                  Connection c = JDBCUtil.getConnection();
                  String sql = "INSERT INTO LoaiMon VALUES(?,?,?)";
                  PreparedStatement prep = c.prepareStatement(sql);
                  prep.setString(1, getNewId());
                  prep.setString(2, loaiMon.getTenLoaiMon());
                  prep.setBoolean(3, loaiMon.getTrangThaiLoaiMon());

                  if(prep.executeUpdate() > 0) {
                        result = true;
                  }
                  JDBCUtil.closeConnection(c);
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return result;
      }

      public boolean deleteLoaiMon(String maLoaiMon) {
            boolean result = false;
            try {
                  Connection c = JDBCUtil.getConnection();
                  String sql = "UPDATE LoaiMon SET trangThaiLoaiMon=0 WHERE MaLoaiMon= ? ";
                  PreparedStatement prep = c.prepareStatement(sql);
                  prep.setString(1, maLoaiMon);
                  if (prep.executeUpdate() > 0) {
                        result = true;
                  }
                  JDBCUtil.closeConnection(c);
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return result;
      }

      public boolean updateLoaiMon(LoaiMonDTO loaiMon) {
            boolean result = false;
            try {
                  Connection c = JDBCUtil.getConnection();
                  String sql = "UPDATE LoaiMon SET TenLoaiMon=?, TrangThaiLoaiMon=? WHERE MaLoaiMon=?";
                  PreparedStatement prep = c.prepareStatement(sql);
                  prep.setString(1, loaiMon.getTenLoaiMon());
                  prep.setBoolean(2, loaiMon.getTrangThaiLoaiMon());
                  prep.setString(3, loaiMon.getMaLoaiMon());
                  if (prep.executeUpdate() > 0) {
                        result = true;
                  }
                  JDBCUtil.closeConnection(c);
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return result;
      }
      public String getNewId() {
            String maMon = "LM001"; // Giá trị mặc định khi không có món trong CSDL
            try {
                Connection c = JDBCUtil.getConnection();
                String sql = "SELECT MAX(MaLoaiMon) AS MaLoaiMon FROM LoaiMon"; // Câu truy vấn để lấy mã món lớn nhất
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                if (rs.next()) {
                    String lastMaLM = rs.getString("MaLoaiMon");
                    if (lastMaLM != null) {
                        // Tách phần số ra khỏi mã món (VD: từ "LM005" -> "005")
                        String numberPart = lastMaLM.substring(2); // Lấy phần số từ vị trí thứ 3
                        int number = Integer.parseInt(numberPart); // Chuyển đổi thành số nguyên
                        number++; // Tăng giá trị số lên 1
                        
                        // Đảm bảo mã mới có định dạng LM + 3 chữ số
                        maMon = String.format("LM%03d", number); // Định dạng lại thành LMXXX
                    }
                }
                JDBCUtil.closeConnection(c);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return maMon; // Trả về mã món mới
      }
}
