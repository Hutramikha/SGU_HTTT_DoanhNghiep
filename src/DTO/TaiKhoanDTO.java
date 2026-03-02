package DTO;

import java.sql.Date;

public class TaiKhoanDTO {

    private String maTaiKhoan;
    private String tenDangNhap;
    private String matKhau;
    private String maPhanQuyen;
    private String maNhanVien;
    private Date ngayCap;
    private Date ngayNghiViec;
    private int trangThaiTaiKhoan;

    public TaiKhoanDTO() {
        this.maNhanVien = null;
    }

    public TaiKhoanDTO(String maTaiKhoan, String tenDangNhap, String matKhau, String maPhanQuyen, String maNhanVien,
            Date ngayCap, Date ngayNghiViec, int trangThaiTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maPhanQuyen = maPhanQuyen;
        this.maNhanVien = maNhanVien;
        this.ngayCap = ngayCap;
        this.ngayNghiViec = ngayNghiViec;
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgaycap() {
        return ngayCap;
    }

    public void setNgaycap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public Date getNgayNghiViec() {
        return ngayNghiViec;
    }

    public void setNgayNghiViec(Date ngayNghiViec) {
        this.ngayNghiViec = ngayNghiViec;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaPhanQuyen() {
        return maPhanQuyen;
    }

    public void setMaPhanQuyen(String maPhanQuyen) {
        this.maPhanQuyen = maPhanQuyen;
    }

    public int isTrangThaiTaiKhoan() {
        return trangThaiTaiKhoan;
    }

    public void setTrangThaiTaiKhoan(int trangThaiTaiKhoan) {
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }

    public int getTrangThaiTaiKhoan() {
        return trangThaiTaiKhoan;
    }

    @Override
    public String toString() {
        return "TaiKhoanDTO{"
                + "maTaiKhoan='" + maTaiKhoan + '\''
                + ", tenDangNhap='" + tenDangNhap + '\''
                + ", matKhau='" + matKhau + '\''
                + ", maPhanQuyen='" + maPhanQuyen + '\''
                + ", ngayCap='" + matKhau + '\''
                + ", ngayCap='" + ngayCap + '\''
                + ", ngayNghiViec='" + ngayNghiViec + '\''
                + ", trangThaiTaiKhoan=" + trangThaiTaiKhoan
                + '}';
    }

    // public static void main(String[] args) {
    //     TaiKhoanDTO taiKhoan = new TaiKhoanDTO("NV001", "user1", "password123", "PQ001",  1);
    //     System.out.println(taiKhoan.toString());
    // }
}
