package DTO;
import java.sql.*;

public class NhanVienDTO {

    private String MaNhanVien;
    private String TenNhanVien;
    private String GioiTinhNhanVien;
    private String SoDienThoaiNhanVien;
    private Date NgaySinhNhanVien;
    private String ChucVuNhanVien;
    private String DiaChi;
    private int LuongNhanVien;
    private int TrangThaiNhanVien;

    public NhanVienDTO(){

    }
    
    public NhanVienDTO(String maNhanVien, String tenNhanVien, String gioiTinhNhanVien, String soDienThoaiNhanVien,
    Date ngaySinhNhanVien, String chucVuNhanVien, String diaChi, int luongNhanVien, int trangThaiNhanVien) {

        this.MaNhanVien = maNhanVien;
        this.TenNhanVien = tenNhanVien;
        this.GioiTinhNhanVien = gioiTinhNhanVien;
        this.SoDienThoaiNhanVien = soDienThoaiNhanVien;
        this.NgaySinhNhanVien = ngaySinhNhanVien;
        this.ChucVuNhanVien = chucVuNhanVien;
        this.DiaChi = diaChi;
        this.LuongNhanVien = luongNhanVien;
        this.TrangThaiNhanVien = trangThaiNhanVien;
    }
    public String getMaNhanVien() {
        return MaNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.MaNhanVien = maNhanVien;
    }
    public String getTenNhanVien() {
        return TenNhanVien;
    }
    public void setTenNhanVien(String tenNhanVien) {
        this.TenNhanVien = tenNhanVien;
    }
    public String getGioiTinhNhanVien() {
        return GioiTinhNhanVien;
    }
    public void setGioiTinhNhanVien(String gioiTinhNhanVien) {
        this.GioiTinhNhanVien = gioiTinhNhanVien;
    }
    public String getSoDienThoaiNhanVien() {
        return SoDienThoaiNhanVien;
    }
    public void setSoDienThoaiNhanVien(String soDienThoaiNhanVien) {
        this.SoDienThoaiNhanVien = soDienThoaiNhanVien;
    }
    public Date getNgaySinhNhanVien() {
        return NgaySinhNhanVien;
    }
    public void setNgaySinhNhanVien(Date ngaySinhNhanVien) {
        this.NgaySinhNhanVien = ngaySinhNhanVien;
    }
    public String getChucVuNhanVien() {
        return ChucVuNhanVien;
    }
    public void setChucVuNhanVien(String chucVuNhanVien) {
        this.ChucVuNhanVien = chucVuNhanVien;
    }
    public String getDiaChi() {
        return DiaChi;
    }
    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
    }
    public int getLuongNhanVien() {
        return LuongNhanVien;
    }
    public void setLuongNhanVien(int luongNhanVien) {
        this.LuongNhanVien = luongNhanVien;
    }
    public int getTrangThaiNhanVien() {
        return TrangThaiNhanVien;
    }
    public void setTrangThaiNhanVien(int trangThaiNhanVien) {
        this.TrangThaiNhanVien = trangThaiNhanVien;
    }

}
