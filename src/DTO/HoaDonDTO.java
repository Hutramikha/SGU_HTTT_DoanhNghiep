package DTO;

import java.util.Date;

public class HoaDonDTO {
    private String maHoaDon;
    private Date ngayLapHoaDon;
    private int tongTienHoaDon;
    private String maNhanVien;
    private String maKhachHang;
    private String maUuDai;
    private String maKhuyenMai;
    public HoaDonDTO() {
    }

    public HoaDonDTO(String maHoaDon, Date ngayLapHoaDon, int tongTienHoaDon, String maNhanVien, String maKhachHang, String maUuDai, String maKhuyenMai) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTienHoaDon = tongTienHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.maUuDai = maUuDai;
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public int getTongTienHoaDon() {
        return tongTienHoaDon;
    }

    public void setTongTienHoaDon(int tongTienHoaDon) {
        this.tongTienHoaDon = tongTienHoaDon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaUuDai() {
        return maUuDai;
    }

    public void setMaUuDai(String maUuDai) {
        this.maUuDai = maUuDai;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    @Override
    public String toString() {
        return "HoaDonDTO{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", ngayLapHoaDon=" + ngayLapHoaDon +
                ", tongTienHoaDon=" + tongTienHoaDon +
                ", maNhanVien='" + maNhanVien + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", maUuDai='" + maUuDai + '\'' +
                ", maKhuyenMai='" + maKhuyenMai + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Date date = new Date();
        date.getTime();
        HoaDonDTO hoaDon = new HoaDonDTO("HD001", date, 500000, "NV001", "KH001", "UD001", "KM001");
        System.out.println(hoaDon.toString());
    }
}
