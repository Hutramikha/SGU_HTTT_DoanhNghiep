package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DTO.HoaDonDTO;
import GUI.dlgCapTaiKhoan;
import Util.JDBCUtil;

public class n10_ThongKeDAO {
    Connection c = JDBCUtil.getConnection();

    ///////////////////////////////thống kê mặc định
    public int TongtienHoadonngay(Date date) {
        int tongTienTatCaHoaDon = 0; // Khởi tạo biến trả về
        date.toLocalDate();
        try {
            // Sử dụng điều kiện ngày
            String sql = "SELECT SUM(TongTienHoaDon) AS TongTienTatCaHoaDon FROM HoaDon WHERE NgayLapHoaDon = ?";
            
            // Connection c = JDBCUtil.getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setDate(1, date); // Đặt giá trị ngày vào câu truy vấn
    
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
                tongTienTatCaHoaDon = rs.getInt("TongTienTatCaHoaDon");
                // System.out.println("Tổng tiền hóa đơn trong ngày " + date + " là: " + tongTienTatCaHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return tongTienTatCaHoaDon;
    }
    public int TongtienHoadonThangHienTai() {
    int tongTienTatCaHoaDon = 0; // Khởi tạo biến trả về
    LocalDate currentDate = LocalDate.now(); // Lấy ngày hiện tại
    int currentMonth = currentDate.getMonthValue(); // Lấy tháng hiện tại
    int currentYear = currentDate.getYear(); // Lấy năm hiện tại

    try {
        // Sử dụng điều kiện tháng và năm
        String sql = "SELECT SUM(TongTienHoaDon) AS TongTienTatCaHoaDon FROM HoaDon " +
                     "WHERE MONTH(NgayLapHoaDon) = ? AND YEAR(NgayLapHoaDon) = ?";
        
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, currentMonth); // Đặt giá trị tháng vào câu truy vấn
        pstmt.setInt(2, currentYear); // Đặt giá trị năm vào câu truy vấn

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            tongTienTatCaHoaDon = rs.getInt("TongTienTatCaHoaDon");
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tongTienTatCaHoaDon;
}   
    
    public int SoluongKHmoi (){
        int SoluongKH = 0;
        try {
            String sql = "SELECT COUNT(*) AS SoLuongKhachHang FROM KhachHang";
            // Connection c = JDBCUtil.getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                SoluongKH = rs.getInt("SoLuongKhachHang");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return SoluongKH;
    }
    public int Soluongnvien (){
        int SoluongNV = 0;
        try {
            String sql = "SELECT COUNT(*) AS SoLuongNhanVien FROM NhanVien WHERE TrangThaiNhanVien=1";
            // Connection c = JDBCUtil.getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                SoluongNV = rs.getInt("SoLuongNhanVien");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return SoluongNV;
    }
    public int Soluongncc (){
        int Soluongncc = 0;
        try {
            String sql = "SELECT COUNT(*) AS SoLuongNhaCungCap FROM NhaCungCap";
            // Connection c = JDBCUtil.getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Soluongncc = rs.getInt("SoLuongNhaCungCap");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return Soluongncc;
    }
    public int SoluongNguyenlieu (){
        int SoluongNL = 0;
        try {
            String sql = "SELECT COUNT(*) AS SoLuongNL FROM NguyenLieu";
            // Connection c = JDBCUtil.getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                SoluongNL = rs.getInt("SoLuongNL");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return SoluongNL;
    }
    public int SoluongPhieuNhapTrongThangHienTai() {
        int soluongPhieuNhap = 0;
    
        // Lấy tháng và năm hiện tại
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
    
        String sql = "SELECT COUNT(*) AS SoLuongPhieuNhap " +
                     "FROM PhieuNhap " +
                     "WHERE MONTH(NgayLapPhieuNhap) = ? AND YEAR(NgayLapPhieuNhap) = ?";
    
        try  {
            // Connection c = JDBCUtil.getConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
            // Đặt giá trị cho tháng và năm hiện tại
            pstmt.setInt(1, currentMonth);
            pstmt.setInt(2, currentYear);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    soluongPhieuNhap = rs.getInt("SoLuongPhieuNhap");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return soluongPhieuNhap;
    }
    
    public int SoluongHDmoi (Date date){
        date.toLocalDate();
        int SoluongKH = 0;
        try {
            String sql = "SELECT COUNT(*) AS SoLuongHoaDon FROM HoaDon WHERE NgayLapHoaDon = ?";
            // Connection c = JDBCUtil.getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setDate(1, date);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                SoluongKH = rs.getInt("SoLuongHoaDon");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return SoluongKH;
    }
    public int Tongmondaban(Date date) {
        int SlmonTrongngay = 0; // Khởi tạo biến trả về
    
        try {
            // Sử dụng JOIN giữa ChiTietHoaDon và HoaDon để lọc theo ngày
            String sql = "SELECT SUM(ChiTietHoaDon.Soluong) AS Soluongmon " +
                         "FROM ChiTietHoaDon " +
                         "JOIN HoaDon ON ChiTietHoaDon.MaHoaDon = HoaDon.MaHoaDon " +
                         "WHERE HoaDon.NgayLapHoaDon = ?";
            
            // Connection c = JDBCUtil.getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setDate(1, date); // Đặt giá trị ngày vào câu truy vấn
    
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
                SlmonTrongngay = rs.getInt("Soluongmon");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return SlmonTrongngay;
    }
    public int[] getTongTienHoaDonTrongTuan() {

        int[] tongTienTrongTuan = new int[7];
        Arrays.fill(tongTienTrongTuan, 0); // Khởi tạo giá trị ban đầu là 0 cho mỗi ngày trong tuần

        String query = "SELECT DATEPART(WEEKDAY, NgayLapHoaDon) AS ThuTrongTuan, SUM(TongTienHoaDon) AS TongTien " +
                       "FROM HoaDon " +
                       "WHERE DATEPART(WEEK, NgayLapHoaDon) = DATEPART(WEEK, GETDATE()) " +
                       "AND DATEPART(YEAR, NgayLapHoaDon) = DATEPART(YEAR, GETDATE()) " +
                       "GROUP BY DATEPART(WEEKDAY, NgayLapHoaDon) " +
                       "ORDER BY ThuTrongTuan";

        try {
            // Connection c = JDBCUtil.getConnection();
             Statement statement = c.createStatement();
             ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int thuTrongTuan = resultSet.getInt("ThuTrongTuan");
                int tongTien = resultSet.getInt("TongTien");

                // DAYOFWEEK trả về 1 (Chủ Nhật) đến 7 (Thứ Bảy), nên cần điều chỉnh chỉ số mảng
                int index = (thuTrongTuan == 1) ? 6 : thuTrongTuan - 2; // Đưa Chủ Nhật vào cuối mảng
                tongTienTrongTuan[index] = tongTien;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tongTienTrongTuan;
    }
    ///////////////////////////mặc định
    public int[] getTongtienHoadonTheoQuy(){
        int[] tongTienTheoQuy = new int[4];
        int namHienTai = LocalDate.now().getYear();
        String sql = "SELECT " +
        "SUM(CASE WHEN MONTH(NgayLapHoaDon) BETWEEN 1 AND 3 THEN TongTienHoaDon ELSE 0 END) AS Quy1, " +
        "SUM(CASE WHEN MONTH(NgayLapHoaDon) BETWEEN 4 AND 6 THEN TongTienHoaDon ELSE 0 END) AS Quy2, " +
        "SUM(CASE WHEN MONTH(NgayLapHoaDon) BETWEEN 7 AND 9 THEN TongTienHoaDon ELSE 0 END) AS Quy3, " +
        "SUM(CASE WHEN MONTH(NgayLapHoaDon) BETWEEN 10 AND 12 THEN TongTienHoaDon ELSE 0 END) AS Quy4 " +
        "FROM HoaDon " +
        "WHERE YEAR(NgayLapHoaDon) = ?";
        try {
            // Connection c = JDBCUtil.getConnection();
        PreparedStatement statement = c.prepareStatement(sql);

            // Gán giá trị năm vào câu lệnh SQL
            statement.setInt(1, namHienTai);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    tongTienTheoQuy[0] = resultSet.getInt("Quy1");
                    tongTienTheoQuy[1] = resultSet.getInt("Quy2");
                    tongTienTheoQuy[2] = resultSet.getInt("Quy3");
                    tongTienTheoQuy[3] = resultSet.getInt("Quy4");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongTienTheoQuy;
    

    }
    // ///////////////////////lấy dthu theo tháng
    public int[] getTongTienTheoThang() {
        // Lấy năm hiện tại
        int namHienTai = LocalDate.now().getYear();

        String sql = "SELECT " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 1 THEN TongTienHoaDon ELSE 0 END) AS Thang1, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 2 THEN TongTienHoaDon ELSE 0 END) AS Thang2, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 3 THEN TongTienHoaDon ELSE 0 END) AS Thang3, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 4 THEN TongTienHoaDon ELSE 0 END) AS Thang4, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 5 THEN TongTienHoaDon ELSE 0 END) AS Thang5, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 6 THEN TongTienHoaDon ELSE 0 END) AS Thang6, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 7 THEN TongTienHoaDon ELSE 0 END) AS Thang7, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 8 THEN TongTienHoaDon ELSE 0 END) AS Thang8, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 9 THEN TongTienHoaDon ELSE 0 END) AS Thang9, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 10 THEN TongTienHoaDon ELSE 0 END) AS Thang10, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 11 THEN TongTienHoaDon ELSE 0 END) AS Thang11, " +
                     "SUM(CASE WHEN MONTH(NgayLapHoaDon) = 12 THEN TongTienHoaDon ELSE 0 END) AS Thang12 " +
                     "FROM HoaDon " +
                     "WHERE YEAR(NgayLapHoaDon) = ?";

        int[] tongTienTheoThang = new int[12];

        try {
            // Connection c = JDBCUtil.getConnection();
        PreparedStatement statement = c.prepareStatement(sql);
        

            // Gán giá trị năm vào câu lệnh SQL
            statement.setInt(1, namHienTai);;
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    for (int i = 0; i < 12; i++) {
                        tongTienTheoThang[i] = resultSet.getInt("Thang" + (i + 1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongTienTheoThang;
    }
    
    public int[] getTongtienPhieunhap(){
        int namHienTai = LocalDate.now().getYear();

        String sql = "SELECT " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 1 THEN TongTienPhieuNhap ELSE 0 END) AS Thang1, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 2 THEN TongTienPhieuNhap ELSE 0 END) AS Thang2, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 3 THEN TongTienPhieuNhap ELSE 0 END) AS Thang3, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 4 THEN TongTienPhieuNhap ELSE 0 END) AS Thang4, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 5 THEN TongTienPhieuNhap ELSE 0 END) AS Thang5, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 6 THEN TongTienPhieuNhap ELSE 0 END) AS Thang6, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 7 THEN TongTienPhieuNhap ELSE 0 END) AS Thang7, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 8 THEN TongTienPhieuNhap ELSE 0 END) AS Thang8, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 9 THEN TongTienPhieuNhap ELSE 0 END) AS Thang9, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 10 THEN TongTienPhieuNhap ELSE 0 END) AS Thang10, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 11 THEN TongTienPhieuNhap ELSE 0 END) AS Thang11, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) = 12 THEN TongTienPhieuNhap ELSE 0 END) AS Thang12 " +
                     "FROM PhieuNhap " +
                     "WHERE YEAR(NgayLapPhieuNhap) = ?";

        int[] tongTienTheoThang = new int[12];

        try {
            // Connection c = JDBCUtil.getConnection();
        PreparedStatement statement = c.prepareStatement(sql);
         

            // Gán giá trị năm vào câu lệnh SQL
            statement.setInt(1, namHienTai);;
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    for (int i = 0; i < 12; i++) {
                        tongTienTheoThang[i] = resultSet.getInt("Thang" + (i + 1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongTienTheoThang;
    }
    public int[] getTongTienPhieuNhapTheoQuy() {
        int namHienTai = LocalDate.now().getYear();
    
        String sql = "SELECT " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) BETWEEN 1 AND 3 THEN TongTienPhieuNhap ELSE 0 END) AS Quy1, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) BETWEEN 4 AND 6 THEN TongTienPhieuNhap ELSE 0 END) AS Quy2, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) BETWEEN 7 AND 9 THEN TongTienPhieuNhap ELSE 0 END) AS Quy3, " +
                     "SUM(CASE WHEN MONTH(NgayLapPhieuNhap) BETWEEN 10 AND 12 THEN TongTienPhieuNhap ELSE 0 END) AS Quy4 " +
                     "FROM PhieuNhap " +
                     "WHERE YEAR(NgayLapPhieuNhap) = ?";
    
        int[] tongTienTheoQuy = new int[4];
    
        try {
            // Connection c = JDBCUtil.getConnection();
             PreparedStatement statement = c.prepareStatement(sql); 
    
            // Gán giá trị năm vào câu lệnh SQL
            statement.setInt(1, namHienTai);
    
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    for (int i = 0; i < 4; i++) {
                        tongTienTheoQuy[i] = resultSet.getInt("Quy" + (i + 1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return tongTienTheoQuy;
    }
    
    ///////////////
    public int TongtienPhieuNhapThangHienTai() {
        int tongTienTatCaPhieuNhap = 0; // Khởi tạo biến trả về
        LocalDate currentDate = LocalDate.now(); // Lấy ngày hiện tại
        int currentMonth = currentDate.getMonthValue(); // Lấy tháng hiện tại
        int currentYear = currentDate.getYear(); // Lấy năm hiện tại
    
        try {
            // Sử dụng điều kiện tháng và năm
            String sql = "SELECT SUM(TongTienPhieuNhap) AS TongTienTatCaPhieuNhap FROM PhieuNhap " +
                         "WHERE MONTH(NgayLapPhieuNhap) = ? AND YEAR(NgayLapPhieuNhap) = ?";
            
            // Connection c = JDBCUtil.getConnection();
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setInt(1, currentMonth); // Đặt giá trị tháng vào câu truy vấn
            pstmt.setInt(2, currentYear); // Đặt giá trị năm vào câu truy vấn
    
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
                tongTienTatCaPhieuNhap = rs.getInt("TongTienTatCaPhieuNhap");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return tongTienTatCaPhieuNhap;
    }
    public int[] getLuongTheoThang(String maNhanVien) {
        int[] luongTheoThang = new int[12];
        Arrays.fill(luongTheoThang, 0);  // Initialize array with 0 for each month
    
        int namHienTai = Year.now().getValue();  // Get current year
        int thangHienTai = LocalDate.now().getMonthValue();  // Get current month
    
        String sql = "SELECT e.LuongNhanVien, a.NgayCap, a.NgayNghiViec " +
                     "FROM TaiKhoan a JOIN NhanVien e ON a.MaNhanVien = e.MaNhanVien " +
                     "WHERE a.MaNhanVien = ?";
    
        try { 
            // Connection c = JDBCUtil.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql); 
    
            stmt.setString(1, maNhanVien);
    
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int luong = rs.getInt("LuongNhanVien");
                    Date ngayCap = rs.getDate("NgayCap");
                    Date ngayNghiViec = rs.getDate("NgayNghiViec");
    
                    int namBatDau = ngayCap.toLocalDate().getYear();
                    int thangBatDau = ngayCap.toLocalDate().getMonthValue();
                    int namKetThuc, thangKetThuc;
    
                    // If the employee has not terminated, calculate salary until the current month
                    if (ngayNghiViec == null) {
                        namKetThuc = namHienTai;
                        thangKetThuc = thangHienTai;
                    } else {  // If there is a termination date, only calculate until that month
                        namKetThuc = ngayNghiViec.toLocalDate().getYear();
                        thangKetThuc = ngayNghiViec.toLocalDate().getMonthValue();
                    }
    
                    // Calculate salary from start month to end month
                    if (namBatDau == namKetThuc) {
                        // If start and end dates are in the same year
                        for (int i = thangBatDau - 1; i < thangKetThuc; i++) {
                            luongTheoThang[i] = luong;
                        }
                    } else if (namBatDau < namKetThuc) {
                        // If the employee worked across multiple years
                        // Fill remaining months of the start year
                        for (int i = thangBatDau - 1; i < 12; i++) {
                            luongTheoThang[i] = luong;
                        }
                        // Fill months of the end year up to the termination month
                        for (int i = 0; i < thangKetThuc; i++) {
                            luongTheoThang[i] = luong;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return luongTheoThang;
    }
    public int getTongLuongNhanVienThangHienTai() {
        int tongLuongThangHienTai = 0;
        int thangHienTai = LocalDate.now().getMonthValue(); // Current month
        int namHienTai = LocalDate.now().getYear(); // Current year
    
        // Update SQL query to join the Account and Employee tables
        String sql = "SELECT e.LuongNhanVien, a.NgayCap, a.NgayNghiViec " +
                     "FROM TaiKhoan a JOIN NhanVien e ON a.MaNhanVien = e.MaNhanVien";
    
        try {
            // Connection c = JDBCUtil.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery(); 
    
            while (rs.next()) {
                int luong = rs.getInt("LuongNhanVien");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayNghiViec = rs.getDate("NgayNghiViec");
    
                LocalDate ngayCapLocal = ngayCap.toLocalDate();
                int namBatDau = ngayCapLocal.getYear();
                int thangBatDau = ngayCapLocal.getMonthValue();
    
                // Determine the end year and month based on the termination date
                int namKetThuc, thangKetThuc;
                if (ngayNghiViec == null) {
                    namKetThuc = namHienTai;
                    thangKetThuc = thangHienTai;
                } else {
                    LocalDate ngayNghiViecLocal = ngayNghiViec.toLocalDate();
                    namKetThuc = ngayNghiViecLocal.getYear();
                    thangKetThuc = ngayNghiViecLocal.getMonthValue();
                }
    
                // Check if the current month is within the employment period of the employee
                if ((namBatDau < namHienTai || (namBatDau == namHienTai && thangBatDau <= thangHienTai)) &&
                    (namKetThuc > namHienTai || (namKetThuc == namHienTai && thangKetThuc >= thangHienTai))) {
                    // Add the employee's salary to the total salary for the current month
                    tongLuongThangHienTai += luong;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return tongLuongThangHienTai;
    }
    public int[] getTongLuongTheoThangTrongNamHienTai() {
        int[] tongLuongTheoThang = new int[12];
        Arrays.fill(tongLuongTheoThang, 0); // Initialize the array with 0 for each month
    
        int namHienTai = LocalDate.now().getYear(); // Current year
        int thangHienTai = LocalDate.now().getMonthValue(); // Current month
    
        // Update SQL query to join the Account and Employee tables
        String sql = "SELECT e.LuongNhanVien, a.NgayCap, a.NgayNghiViec " +
                     "FROM TaiKhoan a JOIN NhanVien e ON a.MaNhanVien = e.MaNhanVien";
    
        try {
            // Connection c = JDBCUtil.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery(); 
    
            while (rs.next()) {
                int luong = rs.getInt("LuongNhanVien");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayNghiViec = rs.getDate("NgayNghiViec");
    
                LocalDate ngayCapLocal = ngayCap.toLocalDate();
                int namBatDau = ngayCapLocal.getYear();
                int thangBatDau = ngayCapLocal.getMonthValue();
    
                // Determine the end year and month based on the termination date or current month
                int namKetThuc, thangKetThuc;
                if (ngayNghiViec == null) {
                    namKetThuc = namHienTai;
                    thangKetThuc = thangHienTai; // If not terminated, calculate until the current month
                } else {
                    LocalDate ngayNghiViecLocal = ngayNghiViec.toLocalDate();
                    namKetThuc = ngayNghiViecLocal.getYear();
                    thangKetThuc = ngayNghiViecLocal.getMonthValue();
                    // Ensure we don't count beyond the current month
                    if (namKetThuc == namHienTai && thangKetThuc > thangHienTai) {
                        thangKetThuc = thangHienTai;
                    }
                }
    
                // Only calculate the months for the current year if the employee is working or has left this year
                if (namBatDau <= namHienTai && namKetThuc >= namHienTai) {
                    int thangBatDauHienTai = (namBatDau == namHienTai) ? thangBatDau : 1;
                    int thangKetThucHienTai = (namKetThuc == namHienTai) ? thangKetThuc : thangHienTai;
    
                    // Add salary to each month worked from thangBatDauHienTai to thangKetThucHienTai
                    for (int i = thangBatDauHienTai - 1; i < thangKetThucHienTai; i++) {
                        tongLuongTheoThang[i] += luong;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return tongLuongTheoThang;
    }
    
    public int[] getTongLuongTheoQuyTrongNamHienTai() {
        int[] tongLuongTheoQuy = new int[4];
        Arrays.fill(tongLuongTheoQuy, 0); // Initialize the array with 0 for each quarter
    
        int namHienTai = LocalDate.now().getYear(); // Current year
    
        // Update SQL query to join the Account and Employee tables
        String sql = "SELECT e.LuongNhanVien, a.NgayCap, a.NgayNghiViec " +
                     "FROM TaiKhoan a JOIN NhanVien e ON a.MaNhanVien = e.MaNhanVien";
    
        try {
            // Connection c = JDBCUtil.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery(); 
    
            while (rs.next()) {
                int luong = rs.getInt("LuongNhanVien");
                Date ngayCap = rs.getDate("NgayCap");
                Date ngayNghiViec = rs.getDate("NgayNghiViec");
    
                LocalDate ngayCapLocal = ngayCap.toLocalDate();
                int namBatDau = ngayCapLocal.getYear();
                int thangBatDau = ngayCapLocal.getMonthValue();
    
                // Determine the end year and month based on the termination date
                int namKetThuc, thangKetThuc;
                if (ngayNghiViec == null) {
                    namKetThuc = namHienTai;
                    thangKetThuc = 12; // If not terminated, calculate until December of the current year
                } else {
                    LocalDate ngayNghiViecLocal = ngayNghiViec.toLocalDate();
                    namKetThuc = ngayNghiViecLocal.getYear();
                    thangKetThuc = ngayNghiViecLocal.getMonthValue();
                }
    
                // Only calculate the months for the current year if the employee is working or has left this year
                if (namBatDau <= namHienTai && namKetThuc >= namHienTai) {
                    int thangBatDauHienTai = (namBatDau == namHienTai) ? thangBatDau : 1;
                    int thangKetThucHienTai = (namKetThuc == namHienTai) ? thangKetThuc : 12;
    
                    // Add salary to the corresponding quarters
                    for (int i = thangBatDauHienTai; i <= thangKetThucHienTai; i++) {
                        if (i >= 1 && i <= 3) {
                            tongLuongTheoQuy[0] += luong; // Quarter 1
                        } else if (i >= 4 && i <= 6) {
                            tongLuongTheoQuy[1] += luong; // Quarter 2
                        } else if (i >= 7 && i <= 9) {
                            tongLuongTheoQuy[2] += luong; // Quarter 3
                        } else if (i >= 10 && i <= 12) {
                            tongLuongTheoQuy[3] += luong; // Quarter 4
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return tongLuongTheoQuy;
    }
    public String[][] getKhoiLuongTungNguyenLieu() {
        ArrayList<String[]> resultList = new ArrayList<>();
        String sql = "SELECT TenNguyenLieu, KhoiLuongNguyenLieu FROM NguyenLieu"; // Sửa tên bảng và cột nếu cần

        try { 
            // Connection conn = JDBCUtil.getConnection(); // Kết nối DB
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String maNguyenLieu = rs.getString("TenNguyenLieu");
                int khoiLuong = rs.getInt("KhoiLuongNguyenLieu");

                // Thêm dữ liệu vào ArrayList dưới dạng String[] (mảng một chiều)
                resultList.add(new String[]{maNguyenLieu, String.valueOf(khoiLuong)});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Chuyển từ ArrayList sang mảng 2 chiều
        String[][] resultArray = new String[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
    public static void main(String[] args) {
        n10_ThongKeDAO list= new n10_ThongKeDAO();
        Date date = Date.valueOf("2024-10-03");
        int[] weeknow = list.getTongTienHoaDonTrongTuan();
        int [] quy = list.getTongtienHoadonTheoQuy();
        int [] luong = list.getLuongTheoThang("NV001");

        int listq = list.TongtienHoadonngay(date);
        int ds = list.Tongmondaban(date);
        int[] tongthang  = list.getTongLuongTheoThangTrongNamHienTai();
        
        for (int i = 0; i < 7; i++) {
            System.out.println(weeknow[i]+"");
        }
        for(int i= 0; i<4;i++){
            System.out.println(quy[i]+", ");
        }
        int sum=0;
        for(int i= 0; i<12;i++){
            System.out.println("tháng "+i+":"+tongthang[i]+",");
            
            sum = sum+tongthang[i];
            System.out.println(sum);
        }
    }
        
    
    
    
    
    

    
    
}
