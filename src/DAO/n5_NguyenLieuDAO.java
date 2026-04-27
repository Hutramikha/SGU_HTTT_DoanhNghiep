package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.NguyenLieuDTO;
import Util.JDBCUtil;

public class n5_NguyenLieuDAO {
    public static n5_NguyenLieuDAO getInstance() {
        return new n5_NguyenLieuDAO();
    }

      public ArrayList<NguyenLieuDTO> getAll() {
            ArrayList<NguyenLieuDTO> listNguyenLieu = new ArrayList<>();
            try {
                  String sql = "SELECT * FROM NguyenLieu Where NguyenLieu.TrangThaiNguyenLieu = 1";
                  Connection c = JDBCUtil.getConnection();
                  PreparedStatement pre = c.prepareStatement(sql);
                  ResultSet rs = pre.executeQuery();
                  while (rs.next()) {

                        String maNguyenLieu = rs.getString(1);
                        String tenNguyenLieu = rs.getString(2);
                        Double khoiLuongNguyenLieu = rs.getDouble(3);
                        int donGiaNguyenLieu = rs.getInt(4);
                        boolean trangThaiNguyenLieu = rs.getBoolean(5);

                        NguyenLieuDTO nguyenLieu = new NguyenLieuDTO(maNguyenLieu, tenNguyenLieu, khoiLuongNguyenLieu, donGiaNguyenLieu, trangThaiNguyenLieu);
                        listNguyenLieu.add(nguyenLieu);
                  }
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return listNguyenLieu;
      }

      public NguyenLieuDTO getNguyenLieuById(String maNguyenLieu) {
            NguyenLieuDTO nguyenLieu = null;
            try {
                  String sql = "SELECT * FROM NguyenLieu WHERE MaNguyenLieu = ?";
                  Connection c = JDBCUtil.getConnection();
                  PreparedStatement pre = c.prepareStatement(sql);
                  pre.setString(1, maNguyenLieu);
                  ResultSet rs = pre.executeQuery();
                  if (rs.next()) {

                        String tenNguyenLieu = rs.getString(2);
                        Double khoiLuongNguyenLieu = rs.getDouble(3);
                        int donGiaNguyenLieu = rs.getInt(4);
                        boolean trangThaiNguyenLieu = rs.getBoolean(5);

                        nguyenLieu = new NguyenLieuDTO(maNguyenLieu, tenNguyenLieu, khoiLuongNguyenLieu, donGiaNguyenLieu, trangThaiNguyenLieu);
                  }
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return nguyenLieu;
      }

      public boolean addNguyenLieu(NguyenLieuDTO nguyenLieu) {
            boolean result = false;
            try {
                  Connection c = JDBCUtil.getConnection();
                  String sql = "INSERT INTO NguyenLieu VALUES(?,?,?,?,1)";
                  PreparedStatement prep = c.prepareStatement(sql);
                  prep.setString(1, this.getNewId());
                  prep.setString(2, nguyenLieu.getTenNguyenLieu());
                  prep.setDouble(3, 0);//Khoi luong
                  prep.setInt(4, 0);//Don gia

                  if(prep.executeUpdate() > 0) {
                        return true;
                  }
                  JDBCUtil.closeConnection(c);
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return result;
      }

      public boolean deleteNguyenLieu(String maNguyenLieu) {
            boolean result = false;
            try {
                  Connection c = JDBCUtil.getConnection();
                  String sql = "UPDATE NguyenLieu SET TrangThaiNguyenLieu = 0 WHERE MaNguyenLieu= ? ";
                  PreparedStatement prep = c.prepareStatement(sql);
                  prep.setString(1, maNguyenLieu);

                  if (prep.executeUpdate() > 0) {
                        result = true;
                  }
                  JDBCUtil.closeConnection(c);
            } catch (SQLException ex) {
                  System.err.println(ex.getMessage());
            }
            return result;
      }

      public boolean updateNguyenLieu(NguyenLieuDTO nguyenLieu) {
            boolean result = false;
            try {
                  Connection c = JDBCUtil.getConnection();
                  // String sql = "UPDATE NguyenLieu SET TenNguyenLieu=?, KhoiLuongNguyenLieu=?, DonGiaNguyenLieu=?, TrangThaiNguyenLieu=? WHERE MaNguyenLieu=?";
                  String sql = "UPDATE NguyenLieu SET TenNguyenLieu=? WHERE MaNguyenLieu=?";
                  PreparedStatement prep = c.prepareStatement(sql);
                  prep.setString(1, nguyenLieu.getTenNguyenLieu());
                  prep.setString(2, nguyenLieu.getMaNguyenLieu());
                  
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
            String maNguyenLieu = "NL001"; // Giá trị mặc định khi không có món trong CSDL
            try {
                Connection c = JDBCUtil.getConnection();
                String sql = "SELECT MAX(MaNguyenLieu) AS MaNguyenLieu FROM NguyenLieu"; // Câu truy vấn để lấy mã món lớn nhất
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                if (rs.next()) {
                    String lastMaHD = rs.getString("MaNguyenLieu");
                    if (lastMaHD != null) {
                        // Tách phần số ra khỏi mã món (VD: từ "HD005" -> "005")
                        String numberPart = lastMaHD.substring(2); // Lấy phần số từ vị trí thứ 3
                        int number = Integer.parseInt(numberPart); // Chuyển đổi thành số nguyên
                        number++; // Tăng giá trị số lên 1
                        
                        // Đảm bảo mã mới có định dạng HD + 3 chữ số
                        maNguyenLieu = String.format("NL%03d", number); // Định dạng lại thành HDXXX
                    }
                }
                JDBCUtil.closeConnection(c);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return maNguyenLieu; // Trả về mã món mới
      }

    public void update_reload_NguyenLieu(ArrayList<Object[]> cart) {
        String sql = "UPDATE b\n"
                + "SET b.KhoiLuongNguyenLieu = round(b.KhoiLuongNguyenLieu + (a.KhoiLuong * ?), 2)\n"
                + "FROM NguyenLieu b\n"
                + "JOIN CongThuc a ON a.MaNguyenLieu = b.MaNguyenLieu\n"
                + "WHERE a.MaMon = ?;";

        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);

            for (Object[] item : cart) {
                st.setInt(1, (int) item[3]); // Giả định sl ở vị trí thứ 4 trong mảng `item`
                st.setString(2, (String) item[0]); // Giả định id ở vị trí đầu tiên trong mảng `item`
                st.addBatch(); // Thêm câu lệnh vào batch
            }

            int[] results = st.executeBatch(); // Thực thi tất cả lệnh trong batch cùng một lúc
            System.out.println("Số lượng bản ghi được cập nhật: " + results.length);

            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Reload nguyên liệu DAO thất bại!");
        }
    }

    public void update_Tru_NguyenLieu(Object[] item) {
        String sql = "UPDATE b\n"
                + "SET b.KhoiLuongNguyenLieu = round( b.KhoiLuongNguyenLieu - (a.KhoiLuong * ?),2)\n"
                + "FROM NguyenLieu b\n"
                + "JOIN CongThuc a ON a.MaNguyenLieu = b.MaNguyenLieu\n"
                + "WHERE a.MaMon = ?;";

        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);

            st.setInt(1, (int) item[3]); // Giả định sl ở vị trí thứ 4 trong mảng `item`
            st.setString(2, (String) item[0]); // Giả định id ở vị trí đầu tiên trong mảng `item`

            st.executeUpdate();

            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Trừ nguyên liệu DAO thất bại!");
        }
    }

    public void update_Cong_NguyenLieu(Object[] item) {
        String sql = "UPDATE b\n"
                + "SET b.KhoiLuongNguyenLieu = round(b.KhoiLuongNguyenLieu + (a.KhoiLuong * ?),2)\n"
                + "FROM NguyenLieu b\n"
                + "JOIN CongThuc a ON a.MaNguyenLieu = b.MaNguyenLieu\n"
                + "WHERE a.MaMon = ?;";

        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);

            st.setInt(1, (int) item[3]); // Giả định sl ở vị trí thứ 4 trong mảng `item`
            st.setString(2, (String) item[0]); // Giả định id ở vị trí đầu tiên trong mảng `item`

            st.executeUpdate();

            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Cộng nguyên liệu DAO thất bại!");
        }
    }
}
