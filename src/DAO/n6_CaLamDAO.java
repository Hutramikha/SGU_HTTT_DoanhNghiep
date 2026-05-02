package DAO;

import DTO.CaLamDTO;

import java.sql.PreparedStatement;
import java.sql.*;
import Util.JDBCUtil;
import java.util.ArrayList;

public class n6_CaLamDAO {

    public static n6_CaLamDAO getInstance() {
        return new n6_CaLamDAO();
    }

    public void taoMaCaLam_off() {
        String sql = "IF NOT EXISTS (\n"
                + "    SELECT MaCaLam\n"
                + "    FROM CaLam\n"
                + "    WHERE MaCaLam = 'CL000'\n"
                + "    GROUP BY MaCaLam\n"
                + "    HAVING COUNT(*) = 0\n"
                + ")\n"
                + "BEGIN\n"
                + "    INSERT INTO CaLam (MaCaLam, TenCaLam, ThoiGianVaoCaLam, ThoiGianRaCaLam, TrangThaiCaLam)\n"
                + "    VALUES ('CL000', 'off', '00:00', '00:00', 1);\n"
                + "END";
        try {
            Connection c = JDBCUtil.getConnection();
            Statement st = c.createStatement();
            int rowsAffected = st.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Đã tạo mã ca off (DAO) ");
            } else {
                System.out.println("Mã ca off đã tồn tại (DAO)");
            }

            JDBCUtil.closeConnection(c);
        } catch (SQLException ex) {
            // ex.printStackTrace();
            // System.out.println("Tạo mã off thất bại (DAO)");
        }
    }

    public String taoMaCaLam() {
        String MaCaLam = "";
        try {
            Connection c = JDBCUtil.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT COUNT(*) AS total FROM CaLam where MaCaLam != 'CL000'";
            ResultSet rs = st.executeQuery(sql);

            int num = 0;
            if (rs.next()) {
                if (rs.getInt("total") == 0) {
                    taoMaCaLam_off();
                }
                num = rs.getInt("total") + 1;
            }

            if (num < 10 && num > 0) {
                MaCaLam = "CL00" + num;
            } else if (num < 100 && num > 9) {
                MaCaLam = "CL0" + num;
            } else if (num >= 100) {
                MaCaLam = "CL" + num;
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Tạo mã thất bại (DAO)");
        }
        return MaCaLam;
    }

    public boolean insert(CaLamDTO calam) {
        String sql = "INSERT INTO CaLam\n"
                + "           (MaCaLam\n"
                + "           ,TenCaLam\n"
                + "           ,ThoiGianVaoCaLam\n"
                + "           ,ThoiGianRaCalam\n"
                + "           ,TrangThaiCaLam)\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, calam.getMaCaLam());
            st.setString(2, calam.getTenCaLam());
            st.setString(3, calam.getThoiGianVaoCaLam());
            st.setString(4, calam.getThoiGianRaCaLam());
            st.setBoolean(5, calam.getTrangThaiCaLam());

            st.executeUpdate();
            System.out.println("Tạo ca làm thành công (DAO)");
            JDBCUtil.closeConnection(c);
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Trùng mã ca làm (DAO) !");
            return false;
        }
        return true;
    }

    public int update(CaLamDTO calam) {
        String sqlUpdate = "UPDATE CaLam "
                + "SET TenCaLam = ?, "
                + "    ThoiGianVaoCaLam = ?, "
                + "    ThoiGianRaCaLam = ? "
                + "WHERE MaCaLam = ?";

        String sqlSelect = "SELECT TenCaLam, ThoiGianVaoCaLam, ThoiGianRaCaLam "
                + "FROM CaLam WHERE MaCaLam = ?";

        try {
            Connection c = JDBCUtil.getConnection();

            // Truy vấn dữ liệu cũ
            PreparedStatement stSelect = c.prepareStatement(sqlSelect);
            stSelect.setString(1, calam.getMaCaLam());
            ResultSet rs = stSelect.executeQuery();

            if (rs.next()) {
                String oldTenCaLam = rs.getString("TenCaLam");
                String oldThoiGianVaoCaLam = rs.getString("ThoiGianVaoCaLam");
                oldThoiGianVaoCaLam = oldThoiGianVaoCaLam.substring(0, 5);
                String oldThoiGianRaCaLam = rs.getString("ThoiGianRaCaLam");
                oldThoiGianRaCaLam = oldThoiGianRaCaLam.substring(0, 5);
                // System.out.println("tên ca: " + oldTenCaLam + " " + calam.getTenCaLam());
                // System.out.println("giờ vào: " + oldThoiGianVaoCaLam.substring(0, 5) + " " +
                // calam.getThoiGianVaoCaLam());
                // System.out.println("giờ ra: " + oldThoiGianRaCaLam.substring(0, 5) + " " +
                // calam.getThoiGianRaCaLam());

                // So sánh dữ liệu
                if (oldTenCaLam.equals(calam.getTenCaLam())
                        && oldThoiGianVaoCaLam.equals(calam.getThoiGianVaoCaLam())
                        && oldThoiGianRaCaLam.equals(calam.getThoiGianRaCaLam())) {
                    JDBCUtil.closeConnection(c);
                    return 2; // Trùng dữ liệu
                }
            } else {
                JDBCUtil.closeConnection(c);
                return 0; // Không tìm thấy mã CaLam
            }

            // Thực hiện cập nhật
            PreparedStatement stUpdate = c.prepareStatement(sqlUpdate);
            stUpdate.setString(1, calam.getTenCaLam());
            stUpdate.setString(2, calam.getThoiGianVaoCaLam());
            stUpdate.setString(3, calam.getThoiGianRaCaLam());
            stUpdate.setString(4, calam.getMaCaLam());

            int kq = stUpdate.executeUpdate();
            JDBCUtil.closeConnection(c);

            if (kq > 0) {
                return 1; // Thành công
            } else {
                return 0; // Thất bại
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi sửa ca làm: " + e.getMessage());
            return 0; // Thất bại
        }
    }

    public boolean delete(String ma) {
        String sql = "UPDATE CaLam\n"
                + "   SET TrangThaiCaLam = ?\n"
                + " WHERE MaCaLam = ?";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, "0");
            st.setString(2, ma);
            int kq = st.executeUpdate();
            JDBCUtil.closeConnection(c);
            if (kq == 0) {
                System.out.println("Xóa thất bại ca làm, mã ca không tồn tại (DAO)");
                return false;

            } else {
                System.out.println("Xóa thành công ca làm (DAO) !");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Xóa thất bại ca làm, mã ca không tồn tại (DAO) !");
            return false;
        }
    }

    public ArrayList<CaLamDTO> showAll() {
        ArrayList<CaLamDTO> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "  FROM CaLam where TrangThaiCaLam = 1 and MaCaLam != 'CL000'";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CaLamDTO calamDTO = new CaLamDTO(rs.getString("MaCaLam"), rs.getString("TenCaLam"),
                        rs.getString("ThoiGianVaoCaLam"), rs.getString("ThoiGianRaCaLam"),
                        rs.getBoolean("TrangThaiCaLam"));
                list.add(calamDTO);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Không lấy được dữ liệu tất các ca làm (DAO)");
        }
        return list;
    }

    public ArrayList<CaLamDTO> search(String MaCaLam, String TenCaLam, String ThoiGianVaoCaLam,
            String ThoiGianRaCaLam) {
        ArrayList<CaLamDTO> list = new ArrayList<>();
        String sql = "select * from CaLam where MaCaLam like ? and TenCaLam like ? and "
                + "(ThoiGianVaoCaLam like ? OR ThoiGianRaCaLam like ?) and TrangThaiCaLam = 1 and MaCaLam != 'CL000'";
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement st = c.prepareStatement(sql)) {
            st.setString(1, "%" + MaCaLam + "%");
            st.setString(2, "%" + TenCaLam + "%");
            st.setString(3, "%" + ThoiGianVaoCaLam + "%");
            st.setString(4, "%" + ThoiGianRaCaLam + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    CaLamDTO calamDTO = new CaLamDTO(rs.getString("MaCaLam"), rs.getString("TenCaLam"),
                            rs.getString("ThoiGianVaoCaLam"), rs.getString("ThoiGianRaCaLam"), true);
                    list.add(calamDTO);
                }
            }
        } catch (Exception e) {
            System.out.println("Không lấy được dữ liệu cần tìm của ca làm (DAO)");
            System.out.println(e);
        }

        return list;
    }


    public CaLamDTO getById(String ma) {
        String sql = "SELECT * FROM CaLam WHERE MaCaLam = ?";
        try (Connection c = JDBCUtil.getConnection(); PreparedStatement st = c.prepareStatement(sql)) {
            st.setString(1, ma);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new CaLamDTO(rs.getString("MaCaLam"), rs.getString("TenCaLam"),
                        rs.getString("ThoiGianVaoCaLam"), rs.getString("ThoiGianRaCaLam"),
                        rs.getBoolean("TrangThaiCaLam"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {
        // Test
    }

}
