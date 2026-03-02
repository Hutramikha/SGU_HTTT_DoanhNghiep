package DAO;

import DTO.CaLamDTO;
import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import DTO.MonDTO;
import DTO.UuDaiThanhVienDTO;
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
//            ex.printStackTrace();
//            System.out.println("Tạo mã off thất bại (DAO)");
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
//                System.out.println("tên ca: " + oldTenCaLam + " " + calam.getTenCaLam());
//                System.out.println("giờ vào: " + oldThoiGianVaoCaLam.substring(0, 5) + " " + calam.getThoiGianVaoCaLam());
//                System.out.println("giờ ra: " + oldThoiGianRaCaLam.substring(0, 5) + " " + calam.getThoiGianRaCaLam());

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

    public void suaChiTieuKhachHang(int tien, String Ma) {
        String sql = "UPDATE KhachHang "
                + "SET ChiTieuKhachHang = ChiTieuKhachHang + ? "
                + "WHERE MaKhachHang = ?";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);

            st.setInt(1, tien);
            st.setString(2, Ma);

            int kq = st.executeUpdate();

//            if (kq > 0) {
//                System.out.println("Cập nhật thành công! Số dòng bị ảnh hưởng: " + kq);
//            } else {
//                System.out.println("Không tìm thấy khách hàng với mã: " + Ma);
//            }
            st.close();
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật chi tiêu khách hàng:");
            e.printStackTrace(); // In chi tiết lỗi
        }
    }

    public ArrayList<CaLamDTO> search(String MaCaLam, String TenCaLam, String ThoiGianVaoCaLam, String ThoiGianRaCaLam) {
        ArrayList<CaLamDTO> list = new ArrayList<>();
        String sql = "select * from CaLam where MaCaLam like ? and TenCaLam like ? and "
                + "(ThoiGianVaoCaLam like ? OR ThoiGianRaCaLam like ?) and TrangThaiCaLam = 1 and MaCaLam != 'CL000'";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, "%" + MaCaLam + "%");
            st.setString(2, "%" + TenCaLam + "%");
            st.setString(3, "%" + ThoiGianVaoCaLam + "%");
            st.setString(4, "%" + ThoiGianRaCaLam + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CaLamDTO calamDTO = new CaLamDTO(rs.getString("MaCaLam"), rs.getString("TenCaLam"),
                        rs.getString("ThoiGianVaoCaLam"), rs.getString("ThoiGianRaCaLam"), true);
                list.add(calamDTO);
            }
        } catch (Exception e) {
            System.out.println("Không lấy được dữ liệu cần tìm của ca làm (DAO)");
            System.out.println(e);
        }

        return list;
    }

//    /////////////////////////////////////////////////////////// Khuyến Mãi - Ưu Đãi
    public ArrayList<KhuyenMaiDTO> getAll_KhuyenMai(int tongTien, Date date) {
        ArrayList<KhuyenMaiDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM [KhuyenMai] WHERE DieuKienKhuyenMai <= ? AND NgayBatDauKhuyenMai <= ? AND NgayKetThucKhuyenMai >= ?";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setInt(1, tongTien);
            st.setDate(2, date);
            st.setDate(3, date);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                KhuyenMaiDTO dto = new KhuyenMaiDTO(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5), rs.getInt(6));
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Không lấy được dữ liệu cần tìm của khuyến mãi (DAO)");
            System.out.println(e);
        }
        return list;
    }

    public KhuyenMaiDTO getBestKhuyenMai(int tongTien, Date date) {
        KhuyenMaiDTO bestKhuyenMai = null;
        String sql = "SELECT TOP 1 * FROM [KhuyenMai] "
                + "WHERE DieuKienKhuyenMai <= ? AND NgayBatDauKhuyenMai <= ? AND NgayKetThucKhuyenMai >= ? "
                + "ORDER BY PhanTramKhuyenMai DESC";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setInt(1, tongTien); // Điều kiện tổng tiền đủ áp dụng
            st.setDate(2, date);    // Ngày bắt đầu <= ngày hiện tại
            st.setDate(3, date);    // Ngày kết thúc >= ngày hiện tại

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                bestKhuyenMai = new KhuyenMaiDTO(
                        rs.getString(1), // Mã khuyến mãi
                        rs.getString(2), // Tên khuyến mãi
                        rs.getDate(3), // Ngày bắt đầu
                        rs.getDate(4), // Ngày kết thúc
                        rs.getFloat(5), // Phần trăm khuyến mãi
                        rs.getInt(6) // Điều kiện khuyến mãi
                );
            }
            rs.close();
            st.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Không lấy được khuyến mãi tối ưu (DAO)");
            System.out.println(e);
        }
        return bestKhuyenMai;
    }

    public KhuyenMaiDTO get_KhuyenMai_theoTen(int tongTien, Date date, String ten) {
        KhuyenMaiDTO dto = new KhuyenMaiDTO();
        String sql = "SELECT * FROM [KhuyenMai] WHERE DieuKienKhuyenMai <= ? AND NgayBatDauKhuyenMai <= ? AND NgayKetThucKhuyenMai >= ? and TenKhuyenMai = ?";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setInt(1, tongTien);
            st.setDate(2, date);
            st.setDate(3, date);
            st.setString(4, ten);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                dto = new KhuyenMaiDTO(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5), rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("Không lấy được dữ liệu cần tìm của khuyến mãi (DAO)");
            System.out.println(e);
        }
        return dto;
    }

    public UuDaiThanhVienDTO get_UuDai_theoChiTieu(int chiTieu, Date date) {
        UuDaiThanhVienDTO dto = new UuDaiThanhVienDTO();
        String sql = "SELECT TOP 1 *\n"
                + "FROM UuDaiThanhVien\n"
                + "WHERE NgayKetThucUuDai >= ?\n"
                + "	AND NgayBatDauUuDai <= ?\n"
                + "    AND DieuKienUuDai <= ?\n"
                + "ORDER BY DieuKienUuDai DESC;";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setDate(1, date);
            st.setDate(2, date);
            st.setInt(3, chiTieu);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                dto = new UuDaiThanhVienDTO(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5), rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("Không lấy được dữ liệu cần tìm của ưu đãi (DAO)");
            System.out.println(e);
        }
        return dto;
    }

    public UuDaiThanhVienDTO get_UuDai_theoMa(String ma) {
        UuDaiThanhVienDTO dto = new UuDaiThanhVienDTO();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "select * from [UuDaiThanhVien] where MaUuDai = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, ma);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                dto = new UuDaiThanhVienDTO(rs.getString(1), rs.getString(2), rs.getDate(3),
                        rs.getDate(4), rs.getFloat(5), rs.getInt(6));
            }
            return dto;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    /////////////////////////////////////////////////////////// Khuyến Mãi - Ưu Đãi
//    /////////////////////////////////////////////////////////// Khách Hàng
    public ArrayList<KhachHangDTO> getData_KhachHang() {
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "  FROM KhachHang order by MaKhachHang desc";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                KhachHangDTO dto = new KhachHangDTO(rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getDate("NgaySinhKhachHang"),
                        rs.getString("GioiTinhKhachHang"),
                        rs.getString("SoDienThoaiKhachHang"),
                        rs.getInt("ChiTieuKhachHang"));
                list.add(dto);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Không lấy được dữ liệu tất các khách hàng (DAO)");
        }
        return list;
    }

    public ArrayList<KhachHangDTO> getData_KhachHang_theoTen(String ten) {
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        String sql = "select *\n"
                + "from KhachHang\n"
                + "where TenKhachHang like ? order by MaKhachHang desc";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement st = c.prepareStatement(sql);
            st.setString(1, "%" + ten + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                KhachHangDTO dto = new KhachHangDTO(rs.getString("MaKhachHang"),
                        rs.getString("TenKhachHang"),
                        rs.getDate("NgaySinhKhachHang"),
                        rs.getString("GioiTinhKhachHang"),
                        rs.getString("SoDienThoaiKhachHang"),
                        rs.getInt("ChiTieuKhachHang"));
                list.add(dto);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Không lấy được dữ liệu tất các khách hàng (DAO)");
        }
        return list;
    }

    public KhachHangDTO get_khachHang_theoMa(String ma) {
        KhachHangDTO dto = new KhachHangDTO();
        try {
            Connection connection = JDBCUtil.getConnection();

            String sql = "select * from KhachHang where MaKhachHang = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, ma);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                dto = new KhachHangDTO(rs.getString(1), rs.getString(2), rs.getDate(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6));
            }
            return dto;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    /////////////////////////////////////////////////////////// Khách HÀNG
    ////////////////////////////////////////////////////////////////////////  Sơn Vũ Xài
    public ArrayList<MonDTO> getAll_theo_LoaiMon(String MaLoaiMon) {
        ArrayList<MonDTO> listMon = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Mon WHERE TrangThaiMon = 1 and MaLoaiMon = ?";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, MaLoaiMon);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                String maMon = rs.getString(1);
                String maLoaiMon = rs.getString(2);
                String tenMon = rs.getString(3);
                String hinhAnh = rs.getString(4);
                int donGiaMon = rs.getInt(5);
                boolean trangThaiMon = rs.getBoolean(6);

                MonDTO mon = new MonDTO(maMon, maLoaiMon, tenMon, hinhAnh, donGiaMon, trangThaiMon);
                listMon.add(mon);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listMon;
    }

    public ArrayList<MonDTO> getAll_theo_TimKiem(String ten) {
        ArrayList<MonDTO> listMon = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Mon WHERE TrangThaiMon = 1 and TenMon like ?";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, "%" + ten + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                String maMon = rs.getString(1);
                String maLoaiMon = rs.getString(2);
                String tenMon = rs.getString(3);
                String hinhAnh = rs.getString(4);
                int donGiaMon = rs.getInt(5);
                boolean trangThaiMon = rs.getBoolean(6);

                MonDTO mon = new MonDTO(maMon, maLoaiMon, tenMon, hinhAnh, donGiaMon, trangThaiMon);
                listMon.add(mon);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listMon;
    }

    public int tinh_SoLuong_MonCon(String MaMon_input) {
        ArrayList<Object[]> ds = new ArrayList<>();
        String sql = "SELECT t1.MaMon, t1.MaNguyenLieu, t2.TenNguyenLieu, t1.KhoiLuong, t2.KhoiLuongNguyenLieu\n"
                + "from\n"
                + "(\n"
                + "select *\n"
                + "from CongThuc \n"
                + "where MaMon = ?\n"
                + ") as t1\n"
                + "\n"
                + "join \n"
                + "(\n"
                + "select * \n"
                + "from NguyenLieu\n"
                + "where TrangThaiNguyenLieu = 1\n"
                + ") as t2\n"
                + "on t1.MaNguyenLieu = t2.MaNguyenLieu";
        try {
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, MaMon_input);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                String MaMon = rs.getString(1);
                String MaNguyenLieu = rs.getString(2);
                String TenNguyenLieu = rs.getString(3);
                float KhoiLuong = rs.getFloat(4);
                float KhoiLuongNguyenLieu = rs.getFloat(5);
                int SoLy = (int) (KhoiLuongNguyenLieu / KhoiLuong);

                ds.add(new Object[]{MaMon, MaNguyenLieu, TenNguyenLieu, KhoiLuong, KhoiLuongNguyenLieu, SoLy});
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        int min = 1000000000;
        for (Object[] row : ds) {
            if (min > (int) row[5]) {
//                System.out.println("MaMon: " + row[0] + "; MaNguyenLieu: " + row[1]
//                        + "; TenNguyenLieu: " + row[2] + "; KhoiLuong: " + row[3] + "; KhoiLuongNguyenLieu: " + row[4] + "; Số Ly: " + row[5]);
                min = (int) row[5];
            }
        }
        return min;
    }

    public ArrayList<MonDTO> getAll_theo_TimKiem_Mon(String ten) {
        ArrayList<MonDTO> listMon = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Mon WHERE TrangThaiMon = 1 and TenMon like ?";
            Connection c = JDBCUtil.getConnection();
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, "%" + ten + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                String maMon = rs.getString(1);
                String maLoaiMon = rs.getString(2);
                String tenMon = rs.getString(3);
                String hinhAnh = rs.getString(4);
                int donGiaMon = rs.getInt(5);
                boolean trangThaiMon = rs.getBoolean(6);

                MonDTO mon = new MonDTO(maMon, maLoaiMon, tenMon, hinhAnh, donGiaMon, trangThaiMon);
                listMon.add(mon);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listMon;
    }

//////////////////////////////////////////////////////////////////////  Sơn Vũ Xài
//    /////////////////////////////////////////////////////////// Nguyên Liệu
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
                st.setInt(1, (int) item[3]);    // Giả định sl ở vị trí thứ 4 trong mảng `item`
                st.setString(2, (String) item[0]); // Giả định id ở vị trí đầu tiên trong mảng `item`
                st.addBatch(); // Thêm câu lệnh vào batch
            }

            int[] results = st.executeBatch();  // Thực thi tất cả lệnh trong batch cùng một lúc
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

            st.setInt(1, (int) item[3]);    // Giả định sl ở vị trí thứ 4 trong mảng `item`
            st.setString(2, (String) item[0]); // Giả định id ở vị trí đầu tiên trong mảng `item`

            int results = st.executeUpdate();  // Thực thi tất cả lệnh trong batch cùng một lúc

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

            st.setInt(1, (int) item[3]);    // Giả định sl ở vị trí thứ 4 trong mảng `item`
            st.setString(2, (String) item[0]); // Giả định id ở vị trí đầu tiên trong mảng `item`

            int results = st.executeUpdate();  // Thực thi tất cả lệnh trong batch cùng một lúc

            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Cộng nguyên liệu DAO thất bại!");
        }
    }

//    /////////////////////////////////////////////////////////// Nguyên Liệu
    public static void main(String args[]) {
        UuDaiThanhVienDTO dto = n6_CaLamDAO.getInstance().get_UuDai_theoChiTieu(500000, Date.valueOf("2024-12-11"));
        System.out.println(dto);
    }

}
