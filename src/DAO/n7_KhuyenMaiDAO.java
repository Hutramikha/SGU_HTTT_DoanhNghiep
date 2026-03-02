package DAO;

import DTO.KhuyenMaiDTO;
import Util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Khoi
 */
public class n7_KhuyenMaiDAO {

    public static n7_KhuyenMaiDAO getInstance() {
        return new n7_KhuyenMaiDAO();
    }

    public ArrayList<KhuyenMaiDTO> getListKhuyenMai() {
        ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
        try {
            String sql = "SELECT * FROM KhuyenMai ORDER BY MaKhuyenMai DESC";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getFloat(5),
                        rs.getInt(6));
                dskm.add(km);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dskm;
    }

    public KhuyenMaiDTO getKhuyenMaiById(String maKM) {
        KhuyenMaiDTO km = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM KhuyenMai WHERE MaKhuyenMai = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, maKM);

            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                km = new KhuyenMaiDTO(); // Khởi tạo đối tượng khi có kết quả
                km.setMaKhuyenMai(rs.getString("MaKhuyenMai"));
                km.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
                km.setNgayBatDauKhuyenMai(rs.getDate("NgayBatDauKhuyenMai"));
                km.setNgayKetThucKhuyenMai(rs.getDate("NgayKetThucKhuyenMai"));
                km.setPhanTramKhuyenMai(rs.getFloat("PhanTramKhuyenMai"));
                km.setDieuKienKhuyenMai(rs.getInt("DieuKienKhuyenMai"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi để dễ dàng kiểm tra
        }
        return km;
    }

    public ArrayList<KhuyenMaiDTO> getListKhuyenMai_theoTen(String ten) {
        ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
        try {
            String sql = "SELECT * FROM KhuyenMai where TenKhuyenMai like ? ORDER BY MaKhuyenMai DESC";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, "%" + ten + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getFloat(5),
                        rs.getInt(6));
                dskm.add(km);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dskm;
    }

    public ArrayList<KhuyenMaiDTO> getListKhuyenMai_theoMa(String ten) {
        ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
        try {
            String sql = "SELECT * FROM KhuyenMai where MaKhuyenMai like ? ORDER BY MaKhuyenMai DESC";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, "%" + ten + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getFloat(5),
                        rs.getInt(6));
                dskm.add(km);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dskm;
    }

    public ArrayList<KhuyenMaiDTO> search(KhuyenMaiDTO dto) {
        ArrayList<KhuyenMaiDTO> dskm = new ArrayList<>();
        try {
            // Câu SQL cơ bản
            String sql = "SELECT * FROM KhuyenMai WHERE MaKhuyenMai LIKE ? AND TenKhuyenMai LIKE ?";

            // Danh sách tham số cho PreparedStatement
            ArrayList<Object> params = new ArrayList<>();
            params.add("%" + dto.getMaKhuyenMai() + "%");
            params.add("%" + dto.getTenKhuyenMai() + "%");

            // Xử lý ngày bắt đầu
            if (dto.getNgayBatDauKhuyenMai() != null) {
                if (!dto.getNgayBatDauKhuyenMai().toString().equals("1900-01-01")) {
                    sql += " AND NgayBatDauKhuyenMai >= ?";
                    params.add(dto.getNgayBatDauKhuyenMai());
                } else {
                    // Nếu ngày bắt đầu là 1900-01-01, lấy từ ngày nhỏ nhất trong hệ thống
                    sql += " AND NgayBatDauKhuyenMai >= (SELECT MIN(NgayBatDauKhuyenMai) FROM KhuyenMai)";
                }
            }

            // Xử lý ngày kết thúc
            if (dto.getNgayKetThucKhuyenMai() != null) {
                if (!dto.getNgayKetThucKhuyenMai().toString().equals("1900-01-01")) {
                    sql += " AND NgayKetThucKhuyenMai <= ?";
                    params.add(dto.getNgayKetThucKhuyenMai());
                } else {
                    // Nếu ngày kết thúc là 1900-01-01, lấy đến ngày lớn nhất trong hệ thống
                    sql += " AND NgayKetThucKhuyenMai <= (SELECT MAX(NgayKetThucKhuyenMai) FROM KhuyenMai)";
                }
            }

            if (dto.getPhanTramKhuyenMai() != -1) {
                sql += " AND PhanTramKhuyenMai = ?";
                params.add(dto.getPhanTramKhuyenMai());
            }

            if (dto.getDieuKienKhuyenMai() != -1) {
                sql += " AND DieuKienKhuyenMai = ?";
                params.add(dto.getDieuKienKhuyenMai());
            }

            sql += " ORDER BY MaKhuyenMai DESC";

            // Kết nối và thực thi
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);

            // Gán tham số
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i) instanceof java.util.Date) {
                    pre.setDate(i + 1, new java.sql.Date(((java.util.Date) params.get(i)).getTime()));
                } else {
                    pre.setObject(i + 1, params.get(i));
                }
            }

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getFloat(5),
                        rs.getInt(6));
                dskm.add(km);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return dskm;
    }

    public String taoMaKhuyenMai() {
        String Ma = "";
        try {
            Connection c = JDBCUtil.getConnection();
            Statement st = c.createStatement();
            String sql = "SELECT COUNT(*) AS total FROM KhuyenMai";
            ResultSet rs = st.executeQuery(sql);

            int num = 0;
            if (rs.next()) {
                num = rs.getInt("total") + 1;
            }

            if (num < 10 && num > 0) {
                Ma = "KM00" + num;
            } else if (num < 100 && num > 9) {
                Ma = "KM0" + num;
            } else if (num >= 100) {
                Ma = "KM" + num;
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Tạo mã khuyến mãi thất bại (DAO)");
        }
        return Ma;
    }

    public boolean insert_khuyenMai(KhuyenMaiDTO dto) {
        String sql = "INSERT INTO KhuyenMai\n"
                + "           (MaKhuyenMai\n"
                + "           ,TenKhuyenMai\n"
                + "           ,NgayBatDauKhuyenMai\n"
                + "           ,NgayKetThucKhuyenMai\n"
                + "           ,PhanTramKhuyenMai\n"
                + "           ,DieuKienKhuyenMai)\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, dto.getMaKhuyenMai());
            st.setString(2, dto.getTenKhuyenMai());
            st.setDate(3, (Date) dto.getNgayBatDauKhuyenMai());
            st.setDate(4, (Date) dto.getNgayKetThucKhuyenMai());
            st.setFloat(5, dto.getPhanTramKhuyenMai());
            st.setInt(6, dto.getDieuKienKhuyenMai());

            st.executeUpdate();
            System.out.println("Tạo khuyến mãi thành công (DAO)");
            JDBCUtil.closeConnection(c);
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Trùng mã khuyến mãi (DAO) !");
            return false;
        }
        return true;
    }

    public int update_khuyenMai(KhuyenMaiDTO dto) {
        String sqlSelect = "SELECT TenKhuyenMai, NgayBatDauKhuyenMai, NgayKetThucKhuyenMai, PhanTramKhuyenMai, DieuKienKhuyenMai "
                + "FROM KhuyenMai WHERE MaKhuyenMai = ?";
        String sqlUpdate = "UPDATE KhuyenMai "
                + "SET TenKhuyenMai = ?, "
                + "    NgayBatDauKhuyenMai = ?, "
                + "    NgayKetThucKhuyenMai = ?, "
                + "    PhanTramKhuyenMai = ?, "
                + "    DieuKienKhuyenMai = ? "
                + "WHERE MaKhuyenMai = ?";

        try {
            Connection c = JDBCUtil.getConnection();

            // Truy vấn dữ liệu cũ
            PreparedStatement stSelect = c.prepareStatement(sqlSelect);
            stSelect.setString(1, dto.getMaKhuyenMai());
            ResultSet rs = stSelect.executeQuery();

            if (rs.next()) {
                String oldTenKhuyenMai = rs.getString("TenKhuyenMai");
                Date oldNgayBatDauKhuyenMai = rs.getDate("NgayBatDauKhuyenMai");
                Date oldNgayKetThucKhuyenMai = rs.getDate("NgayKetThucKhuyenMai");
                float oldPhanTramKhuyenMai = rs.getFloat("PhanTramKhuyenMai");
                int oldDieuKienKhuyenMai = rs.getInt("DieuKienKhuyenMai");

                // So sánh dữ liệu
                if (oldTenKhuyenMai.equals(dto.getTenKhuyenMai())
                        && oldNgayBatDauKhuyenMai.equals(dto.getNgayBatDauKhuyenMai())
                        && oldNgayKetThucKhuyenMai.equals(dto.getNgayKetThucKhuyenMai())
                        && oldPhanTramKhuyenMai == dto.getPhanTramKhuyenMai()
                        && oldDieuKienKhuyenMai == dto.getDieuKienKhuyenMai()) {

                    JDBCUtil.closeConnection(c);
                    return 2; // Trùng dữ liệu, không có thay đổi
                }
            } else {
                JDBCUtil.closeConnection(c);
                return 0; // Không tìm thấy mã khuyến mãi
            }

            // Thực hiện cập nhật nếu có thay đổi
            PreparedStatement stUpdate = c.prepareStatement(sqlUpdate);
            stUpdate.setString(1, dto.getTenKhuyenMai());
            stUpdate.setDate(2, (Date) dto.getNgayBatDauKhuyenMai());
            stUpdate.setDate(3, (Date) dto.getNgayKetThucKhuyenMai());
            stUpdate.setFloat(4, dto.getPhanTramKhuyenMai());
            stUpdate.setInt(5, dto.getDieuKienKhuyenMai());
            stUpdate.setString(6, dto.getMaKhuyenMai());

            int kq = stUpdate.executeUpdate();
            JDBCUtil.closeConnection(c);

            if (kq > 0) {
                return 1; // Thành công
            } else {
                return 0; // Thất bại
            }

        } catch (SQLException e) {
            System.out.println("Lỗi khi sửa khuyến mãi: " + e.getMessage());
            return 0; // Thất bại
        }
    }

    public static void main(String[] args) {
//        Date ngay = Date.valueOf("2024-11-19");
//        Date end = Date.valueOf("2025-11-19");

        ArrayList<KhuyenMaiDTO> list = n7_KhuyenMaiDAO.getInstance().getListKhuyenMai_theoTen("u");
        for (KhuyenMaiDTO a : list) {
            System.out.println(a.toString());
        }
        //        System.out.println(n7_KhuyenMaiDAO.getInstance().taoMaKhuyenMai());
//        KhuyenMaiDTO dto = new KhuyenMaiDTO("KM007", "KM kết thúc năm", ngay, end, 50, 5000000);
//        n7_KhuyenMaiDAO.getInstance().insert(dto);
//        n7_KhuyenMaiDAO.getInstance().update(dto);
//        System.out.println(new java.sql.Date((new java.util.Date()).getTime()));

    }
}
