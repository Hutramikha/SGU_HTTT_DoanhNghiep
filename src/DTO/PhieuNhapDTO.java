package DTO;
import java.util.Date;


public class PhieuNhapDTO {

    private String maPhieuNhap; //string
    private Date ngayLapPhieuNhap; //String
    private int tongTienPhieuNhap;
    private String maNhanVien; //string
    private String maNhaCungCap; // string

    public PhieuNhapDTO() {
    }
    public PhieuNhapDTO(String maPhieuNhap, Date ngayLapPhieuNhap, int tongTienPhieuNhap, String maNhanVien, String maNhaCungCap) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayLapPhieuNhap = ngayLapPhieuNhap;
        this.tongTienPhieuNhap = tongTienPhieuNhap;
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Date getNgayLapPhieuNhap() {
        return ngayLapPhieuNhap;
    }

    public void setNgayLapPhieuNhap(Date ngayLapPhieuNhap) {
        this.ngayLapPhieuNhap = ngayLapPhieuNhap;
    }

    public int getTongTienPhieuNhap() {
        return tongTienPhieuNhap;
    }

    public void setTongTienPhieuNhap(int tongTienPhieuNhap) {
        this.tongTienPhieuNhap = tongTienPhieuNhap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    @Override
    public String toString() {
        return "PhieuNhapDTO{"
                + "maPhieuNhap='" + maPhieuNhap + '\''
                + ", ngayLapPhieuNhap=" + ngayLapPhieuNhap
                + ", tongTienPhieuNhap=" + tongTienPhieuNhap
                + ", maNhanVien='" + maNhanVien + '\''
                + ", maNhaCungCap='" + maNhaCungCap + '\''
                + '}';
    }
}
