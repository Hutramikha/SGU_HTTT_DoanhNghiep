package BUS;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.n1_HoaDonDAO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DAO.n10_ThongKeDAO;

public class ThongkeBUS {
    n10_ThongKeDAO TK = new n10_ThongKeDAO();

    public ThongkeBUS() {
    }

    ///////////////////////////// mặc định
    public int getTongTienHoaDonngay(Date date) {
        int Tong = 0;
        Tong = TK.TongtienHoadonngay(date);
        return Tong;
    }

    public int getTongTienHoaDonthang() {
        int Tong = 0;
        Tong = TK.TongtienHoadonThangHienTai();
        return Tong;
    }

    public int getTongTienPhieunhapthang() {
        int Tong = 0;
        Tong = TK.getTongTienPhieunhapthang();
        return Tong;
    }

    public int getTongTienLuongthang() {
        int Tong = 0;
        Tong = TK.getTongLuongnhanvienthang();
        return Tong;
    }

    public int getsoluongKH() {
        int Soluong = 0;
        Soluong = TK.SoluongKHmoi();
        return Soluong;
    }

    public int getsoluongNV() {
        int Soluong = 0;
        Soluong = TK.Soluongnvien();
        return Soluong;
    }

    public int getsoluongPN() {
        int Soluong = 0;
        Soluong = TK.SoluongPhieuNhapTrongThangHienTai();
        return Soluong;
    }

    public int getsluongNL() {
        int Soluong = 0;
        Soluong = TK.SoluongNguyenlieu();
        return Soluong;
    }

    public int getsluongNCC() {
        int Soluong = 0;
        Soluong = TK.Soluongncc();
        return Soluong;
    }

    public int getsoluongHD(Date date) {
        int Soluong = 0;
        Soluong = TK.SoluongHDmoi(date);
        return Soluong;
    }

    public int getSoluongMon(Date date) {
        int Soluong = 0;
        Soluong = TK.Tongmondaban(date);
        return Soluong;
    }

    public ArrayList<Integer> getArrayDoanhthuTuan() {
        ArrayList<Integer> Dthutuan = new ArrayList<>();
        int[] a = TK.getTongTienHoaDonTrongTuan();
        for (int d : a) {
            Dthutuan.add(d);
        }
        return Dthutuan;
    }

    //////////////////// mặc định loaddata ///////////lấy hóa đơn theo quý
    public ArrayList<Integer> getArrayDoanhthuquy() {
        ArrayList<Integer> Dthuquy = new ArrayList<>();
        int[] a = TK.getTongtienHoadonTheoQuy();
        for (int d : a) {
            Dthuquy.add(d);
        }
        return Dthuquy;
    }

    ///////////////// lấy hóa đơn quý hiện tại
    public int getTongDoanhthuQuyHientai() {
        ArrayList<Integer> doanhThuQuy = getArrayDoanhthuquy();
        int quyHientai = (java.time.LocalDate.now().getMonthValue() + 2) / 3; // Tính quý hiện tại
        if (quyHientai > 0 && quyHientai <= doanhThuQuy.size()) {
            return doanhThuQuy.get(quyHientai - 1); // Lấy doanh thu của quý hiện tại
        }
        return 0;
    }

    /////////// lấy doanh thu theo tháng
    public ArrayList<Integer> getArrayDoanhthunam() {
        ArrayList<Integer> Dthunam = new ArrayList<>();
        int[] a = TK.getTongTienTheoThang();
        for (int d : a) {
            Dthunam.add(d);
        }
        return Dthunam;
    }

    public int getTongDthunam() {
        int tongtien = 0;
        int[] a = TK.getTongTienTheoThang();
        for (int i = 0; i < 12; i++) {
            tongtien = tongtien + a[i];
        }
        return tongtien;
    }

    ////////////// lấy giá trị phiếu nhập theo tháng trong năm hiện tại
    public ArrayList<Integer> getArrayphieunhapnam() {
        return TK.getArrayphieunhapnam();
    }

    public ArrayList<Integer> getArrayphieunhapnamtheoquy() {
        return TK.getArrayphieunhapnamtheoquy();
    }

    /////////// lấy giá trị lương nhân viên theo tháng
    public ArrayList<Integer> getArrayLuongnhanvien(String MaNV) {
        return TK.getArrayLuongnhanvien(MaNV);
    }

    public ArrayList<Integer> getArrayTongLuongnhanvientheothang() {
        return TK.getArrayTongLuongnhanvientheothang();
    }

    public int getTongLuongnhanviennam() {
        return TK.getTongLuongnhanviennam();
    }

    public int getTongphieunhapnam() {
        return TK.getTongphieunhapnam();
    }

    public ArrayList<Integer> getArrayTongLuongnhanvientheoquy() {
        return TK.getArrayTongLuongnhanvientheoquy();
    }

    public int[] tinhLuongTheoQuy(int[] luongTheoThang) {
        int[] luongTheoQuy = new int[4];

        // Tính tổng lương cho từng quý
        luongTheoQuy[0] = luongTheoThang[0] + luongTheoThang[1] + luongTheoThang[2]; // Quý 1
        luongTheoQuy[1] = luongTheoThang[3] + luongTheoThang[4] + luongTheoThang[5]; // Quý 2
        luongTheoQuy[2] = luongTheoThang[6] + luongTheoThang[7] + luongTheoThang[8]; // Quý 3
        luongTheoQuy[3] = luongTheoThang[9] + luongTheoThang[10] + luongTheoThang[11]; // Quý 4

        return luongTheoQuy;
    }

    public String[][] getkhoiluongNL() {
        return TK.getkhoiluongNL();
    }
}
