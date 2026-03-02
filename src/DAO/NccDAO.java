package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.NhaCungCapDTO;
import Util.JDBCUtil;

public class NccDAO {
  public List<NhaCungCapDTO> getDanhSachNhaCungCap() {
    List<NhaCungCapDTO> danhSach = new ArrayList<>();
    String query = "SELECT MaNhaCungCap, TenNhaCungCap, DiaChiNhaCungCap, SoDienThoaiNhaCungCap FROM NhaCungCap";

    try (Connection c = JDBCUtil.getConnection();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(query)) {

      while (rs.next()) {
        NhaCungCapDTO ncc = new NhaCungCapDTO();
        ncc.setMaNhaCungCap(rs.getString(1));
        ncc.setTenNhaCungCap(rs.getString(2));
        ncc.setDiaChiNhaCungCap(rs.getString(3));
        ncc.setSoDienThoaiNhaCungCap(rs.getString(4));
        danhSach.add(ncc);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return danhSach;
  }

  public NhaCungCapDTO getNhaCungCapByMa(String maNhaCungCap) {
    NhaCungCapDTO ncc = new NhaCungCapDTO(); // Khởi tạo đối tượng nhà cung cấp rỗng
    String query = "SELECT MaNhaCungCap, TenNhaCungCap, DiaChiNhaCungCap, SoDienThoaiNhaCungCap FROM NhaCungCap WHERE MaNhaCungCap = ?";

    try (Connection c = JDBCUtil.getConnection();
        PreparedStatement pstmt = c.prepareStatement(query)) {
      pstmt.setString(1, maNhaCungCap); // Gán giá trị tham số mã nhà cung cấp
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        ncc.setMaNhaCungCap(rs.getString(1));
        ncc.setTenNhaCungCap(rs.getString(2));
        ncc.setDiaChiNhaCungCap(rs.getString(3));
        ncc.setSoDienThoaiNhaCungCap(rs.getString(4));

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return ncc;
  }

  public List<NhaCungCapDTO> timKiemTheoTen(String tenNhaCungCap) {
    List<NhaCungCapDTO> danhSachNhaCungCap = new ArrayList<>();
    String sql = "SELECT * FROM NhaCungCap WHERE tenNhaCungCap LIKE ?";

    try (Connection c = JDBCUtil.getConnection();
        PreparedStatement pstmt = c.prepareStatement(sql)) {

      // Thực hiện truy vấn với tham số tìm kiếm
      pstmt.setString(1, "%" + tenNhaCungCap + "%");
      ResultSet rs = pstmt.executeQuery(); // Không cần truyền `sql` vào đây

      while (rs.next()) {
        NhaCungCapDTO ncc = new NhaCungCapDTO();
        ncc.setMaNhaCungCap(rs.getString("maNhaCungCap"));
        ncc.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
        ncc.setDiaChiNhaCungCap(rs.getString("diaChiNhaCungCap"));
        ncc.setSoDienThoaiNhaCungCap(rs.getString("soDienThoaiNhaCungCap"));
        danhSachNhaCungCap.add(ncc);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return danhSachNhaCungCap;
  }

  public boolean themNhaCungCap(NhaCungCapDTO nccDTO) {
    String sql = "INSERT INTO NhaCungCap (MaNhaCungCap, tenNhaCungCap, diaChiNhaCungCap, soDienThoaiNhaCungCap) VALUES (?,?, ?, ?)";

    try (Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

      // Gán các giá trị vào câu lệnh SQL
      pstmt.setString(1, nccDTO.getMaNhaCungCap());
      pstmt.setString(2, nccDTO.getTenNhaCungCap());
      pstmt.setString(3, nccDTO.getDiaChiNhaCungCap());
      pstmt.setString(4, nccDTO.getSoDienThoaiNhaCungCap());

      int result = pstmt.executeUpdate();

      // Nếu câu lệnh INSERT thực thi thành công, trả về true
      return result > 0;

    } catch (SQLException e) {
      e.printStackTrace();
      return false; // Trả về false nếu có lỗi
    }
  }

  public boolean capNhat(NhaCungCapDTO nccDTO) {
    String selectSql = "SELECT tenNhaCungCap, diaChiNhaCungCap, soDienThoaiNhaCungCap FROM NhaCungCap WHERE maNhaCungCap = ?";
    String updateSql = "UPDATE NhaCungCap SET tenNhaCungCap = ?, diaChiNhaCungCap = ?, soDienThoaiNhaCungCap = ? WHERE maNhaCungCap = ?";

    try (Connection c = JDBCUtil.getConnection()) {
      try (PreparedStatement selectStmt = c.prepareStatement(selectSql)) {
        selectStmt.setString(1, nccDTO.getMaNhaCungCap());
        ResultSet rs = selectStmt.executeQuery();

        if (rs.next()) {
          String currentTen = rs.getString("tenNhaCungCap");
          String currentDiaChi = rs.getString("diaChiNhaCungCap");
          String currentSoDienThoai = rs.getString("soDienThoaiNhaCungCap");

          // Kiểm tra nếu không có thay đổi
          if (currentTen.equals(nccDTO.getTenNhaCungCap()) &&
              currentDiaChi.equals(nccDTO.getDiaChiNhaCungCap()) &&
              currentSoDienThoai.equals(nccDTO.getSoDienThoaiNhaCungCap())) {
            return false;
          }
        }
      }

      try (PreparedStatement updateStmt = c.prepareStatement(updateSql)) {
        updateStmt.setString(1, nccDTO.getTenNhaCungCap());
        updateStmt.setString(2, nccDTO.getDiaChiNhaCungCap());
        updateStmt.setString(3, nccDTO.getSoDienThoaiNhaCungCap());
        updateStmt.setString(4, nccDTO.getMaNhaCungCap());

        int rowsAffected = updateStmt.executeUpdate();

        if (rowsAffected > 0) {
          return true;
        } else {
          return false;
        }
      }

    } catch (SQLException e) {
      // Log lỗi rõ ràng
      System.err.println("Lỗi khi sửa nhà cung cấp (DAO): " + e.getMessage());
      e.printStackTrace();
      return false;
    }
  }

  public String taoMaNCC() {
    String Ma = "";
    try {
      // Kết nối cơ sở dữ liệu
      Connection c = JDBCUtil.getConnection();
      Statement st = c.createStatement();
      String sql = "SELECT COUNT(*) AS total FROM NhaCungCap";
      ResultSet rs = st.executeQuery(sql);

      int num = 0;
      if (rs.next()) {
        num = rs.getInt("total") + 1; // Tăng số thứ tự
      }

      // Sử dụng String.format để đảm bảo định dạng mã có 6 ký tự
      Ma = String.format("NCC%03d", num);

      // Đóng kết nối
      JDBCUtil.closeConnection(c);
    } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Tạo mã nhà cung cấp thất bại (DAO)");
    }
    return Ma;
  }

  public static void main(String[] args) {
    NccDAO ncc = new NccDAO();
    List nhacc = ncc.timKiemTheoTen("công ty");
    NhaCungCapDTO ncc1 = new NhaCungCapDTO("NCC009", " ", " ", " ", true);
    ncc.themNhaCungCap(ncc1);
    System.out.println(ncc.getNhaCungCapByMa("NCC001"));
    for (int i = 0; i < nhacc.size(); i++) {
      System.out.println(nhacc.get(i));
    }

  }
}
