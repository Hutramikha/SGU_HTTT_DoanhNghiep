package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import Util.JDBCUtil;

////////////////////////////getlist

public class n1_HoaDonDAO {

    public static n1_HoaDonDAO getInstance() {
        return new n1_HoaDonDAO();
    }

    public ArrayList<HoaDonDTO> getListHoaDon() {
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        try (Connection c = Objects.requireNonNull(JDBCUtil.getConnection());
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM HoaDon ORDER BY MaHoaDon DESC")) {
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHoaDon(rs.getString(1));
                hd.setNgayLapHoaDon(rs.getDate(2));
                hd.setTongTienHoaDon(rs.getInt(3));
                hd.setMaNhanVien(rs.getString(4));
                hd.setMaKhachHang(rs.getString(5));
                hd.setMaUuDai(rs.getString(6));
                hd.setMaKhuyenMai(rs.getString(7));
                dshd.add(hd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return dshd;
    }

    ////////////////// thêm hóa đơn
    public boolean addHoaDon(HoaDonDTO hd) {
        boolean result = false;
        String sql = "INSERT INTO HoaDon(maHoaDon, ngayLapHoaDon, tongTienHoaDon, maNhanVien, maKhachHang, maUuDai, maKhuyenMai) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement prep = c.prepareStatement(sql)) {

            // Thiết lập các giá trị cho câu lệnh SQL
            prep.setString(1, hd.getMaHoaDon());
            prep.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime())); // Ngày hiện tại
            prep.setInt(3, hd.getTongTienHoaDon());
            prep.setString(4, hd.getMaNhanVien());
            prep.setString(5, hd.getMaKhachHang());
            prep.setString(6, hd.getMaUuDai());
            prep.setString(7, hd.getMaKhuyenMai());

            // Thực thi câu lệnh và kiểm tra kết quả
            result = prep.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace(); // In lỗi để debug nếu cần
            result = false;
        }

        return result;
    }

    public HoaDonDTO getHoaDonTheoMHD(String maHD) {
        HoaDonDTO hd = new HoaDonDTO();
        try {
            String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
            try (Connection c = JDBCUtil.getConnection();
                    PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setString(1, maHD);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        hd.setMaHoaDon(rs.getString(1));
                        hd.setNgayLapHoaDon(rs.getDate(2));
                        hd.setTongTienHoaDon(rs.getInt(3));
                        hd.setMaNhanVien(rs.getString(4));
                        hd.setMaKhachHang(rs.getString(5));
                        hd.setMaUuDai(rs.getString(6));
                        hd.setMaKhuyenMai(rs.getString(7));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hd;
    }

    public ArrayList<HoaDonDTO> getlistHD() {
        return getListHoaDon();
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateVaTongTien(Date dateMin, Date dateMax, int tongtienMin,
            int tongtienMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE (NgayLapHoaDon BETWEEN ? AND ?) AND (tongTienHoaDon BETWEEN ? AND ?) ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMin);
            pre.setDate(2, dateMax);
            pre.setInt(3, tongtienMin);
            pre.setInt(4, tongtienMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateVaGiaMin(Date dateMin, Date dateMax, int tongtienMin) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE (NgayLapHoaDon BETWEEN ? AND ?) AND TongTienHoaDon >= ? ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMin);
            pre.setDate(2, dateMax);
            pre.setInt(3, tongtienMin);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateVaGiaMax(Date dateMin, Date dateMax, int tongtienMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE (NgayLapHoaDon BETWEEN ? AND ?) AND TongTienHoaDon <= ? ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMin);
            pre.setDate(2, dateMax);
            pre.setInt(3, tongtienMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateMinVaTongTien(Date dateMin, int tongtienMin, int tongtienMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE NgayLapHoaDon >= ? AND (TongTienHoaDon BETWEEN ? AND ?) ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMin);
            pre.setInt(2, tongtienMin);
            pre.setInt(3, tongtienMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateBang(Date dateMin) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement("SELECT * FROM HoaDon WHERE NgayLapHoaDon = ?")) {
            pre.setDate(1, dateMin);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateMaxVaTongTien(Date dateMax, int tongtienMin, int tongtienMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE NgayLapHoaDon <= ? AND (tongTienHoaDon BETWEEN ? AND ?) ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMax);
            pre.setInt(2, tongtienMin);
            pre.setInt(3, tongtienMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoGiaMinandMax(int GiaMin, int GiaMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE(tongTienHoaDon BETWEEN ? AND ?) ORDER BY MaHoaDon DESC")) {
            pre.setInt(1, GiaMin);
            pre.setInt(2, GiaMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoGia(int Gia) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement("SELECT * FROM HoaDon WHERE TongTienHoaDon = ?")) {
            pre.setInt(1, Gia);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoGiaMin(int GiaMin) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c
                        .prepareStatement("SELECT * FROM HoaDon WHERE TongTienHoaDon >= ? ORDER BY MaHoaDon DESC")) {
            pre.setInt(1, GiaMin);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoGiaMax(int GiaMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c
                        .prepareStatement("SELECT * FROM HoaDon WHERE TongTienHoaDon <= ? ORDER BY MaHoaDon DESC")) {
            pre.setInt(1, GiaMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDate(Date dateMin, Date dateMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE (NgayLapHoaDon BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)) ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMin);
            pre.setDate(2, dateMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateMax(Date dateMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c
                        .prepareStatement("SELECT * FROM HoaDon WHERE NgayLapHoaDon <= ? ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateMin(Date dateMin) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c
                        .prepareStatement("SELECT * FROM HoaDon WHERE NgayLapHoaDon >= ? ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMin);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getNewId() {
        String maHD = "HD001";
        try (Connection c = JDBCUtil.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("SELECT MAX(maHoaDon) AS maHD FROM HoaDon")) {
            if (rs.next()) {
                String lastMaHD = rs.getString("maHD");
                if (lastMaHD != null) {
                    String numberPart = lastMaHD.substring(2);
                    int number = Integer.parseInt(numberPart);
                    number++;
                    maHD = String.format("HD%03d", number);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maHD;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateMinAndGiaMin(Date dateMin, int giaMin) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE NgayLapHoaDon >= ? AND TongTienHoaDon >=? ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMin);
            pre.setInt(2, giaMin);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateMinAndGiaMax(Date dateMin, int giaMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE NgayLapHoaDon >= ? AND TongTienHoaDon <=? ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMin);
            pre.setInt(2, giaMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateMaxAndGiaMax(Date dateMax, int giaMax) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE NgayLapHoaDon <= ? AND TongTienHoaDon <= ? ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMax);
            pre.setInt(2, giaMax);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getListHoaDonTheoDateMaxAndGiaMin(Date dateMax, int giaMin) {
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(
                        "SELECT * FROM HoaDon WHERE NgayLapHoaDon <= ? AND TongTienHoaDon >= ? ORDER BY MaHoaDon DESC")) {
            pre.setDate(1, dateMax);
            pre.setInt(2, giaMin);
            try (ResultSet rs = pre.executeQuery()) {
                ArrayList<HoaDonDTO> dshd = new ArrayList<>();
                while (rs.next()) {
                    HoaDonDTO hd = new HoaDonDTO();
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setNgayLapHoaDon(rs.getDate(2));
                    hd.setTongTienHoaDon(rs.getInt(3));
                    hd.setMaNhanVien(rs.getString(4));
                    hd.setMaKhachHang(rs.getString(5));
                    hd.setMaUuDai(rs.getString(6));
                    hd.setMaKhuyenMai(rs.getString(7));
                    dshd.add(hd);
                }
                return dshd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getMaxTongTien() {
        try (Connection c = JDBCUtil.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("select max(TongTienHoaDon) as Max from HoaDon")) {
            if (rs.next()) {
                return rs.getInt("Max");
            } else {
                System.out.println("No records found in HoaDon table.");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }

}
