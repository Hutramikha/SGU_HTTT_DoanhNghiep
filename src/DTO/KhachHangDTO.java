package DTO;

import java.sql.*;

public class KhachHangDTO {
    private String maKhachHang;
    private String tenKhachHang;
    private Date ngaySinhKhachHang;
    private String gioiTinhKhachHang;
    private String soDienThoaiKhachHang;
    private int chiTieuKhachHang;

    public KhachHangDTO(){}

    public KhachHangDTO(String maKhachHang, String tenKhachHang, Date ngaySinhKhachHang, String gioiTinhKhachHang, String soDienThoaiKhachHang, int chiTieuKhachHang) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinhKhachHang = ngaySinhKhachHang;
        this.gioiTinhKhachHang = gioiTinhKhachHang;
        this.soDienThoaiKhachHang = soDienThoaiKhachHang;
        this.chiTieuKhachHang = chiTieuKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgaySinhKhachHang() {
        return ngaySinhKhachHang;
    }

    public void setNgaySinhKhachHang(Date ngaySinhKhachHang) {
        this.ngaySinhKhachHang = ngaySinhKhachHang;
    }

    public String getGioiTinhKhachHang() {
        return gioiTinhKhachHang;
    }

    public void setGioiTinhKhachHang(String gioiTinhKhachHang) {
        this.gioiTinhKhachHang = gioiTinhKhachHang;
    }

    public String getSoDienThoaiKhachHang() {
        return soDienThoaiKhachHang;
    }

    public void setSoDienThoaiKhachHang(String soDienThoaiKhachHang) {
        this.soDienThoaiKhachHang = soDienThoaiKhachHang;
    }

    public int getChiTieuKhachHang() {
        return chiTieuKhachHang;
    }

    public void setChiTieuKhachHang(int chiTieuKhachHang) {
        this.chiTieuKhachHang = chiTieuKhachHang;
    }



    @Override
    public String toString() {
        return "KhachHangDTO{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", ngaySinhKhachHang=" + ngaySinhKhachHang +
                ", gioiTinhKhachHang='" + gioiTinhKhachHang + '\'' +
                ", soDienThoaiKhachHang='" + soDienThoaiKhachHang + '\'' +
                ", chiTieuKhachHang=" + chiTieuKhachHang +
                '}';
    }

    public static void main(String[] args) {
        KhachHangDTO khachHang = new KhachHangDTO("KH001", "Nguyễn Văn A", Date.valueOf("28/01/2004"), "Nam", "123456789", 1000000);
        System.out.println(khachHang.toString());
    }
}
