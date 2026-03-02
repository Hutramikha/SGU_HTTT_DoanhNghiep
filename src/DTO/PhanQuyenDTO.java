package DTO;

public class PhanQuyenDTO {

    private String maPhanQuyen;
    private String tenQuyen;
    private boolean quyenKhachHang;
    private boolean quyenBanHang;
    private boolean quyenNhapHang;
    private boolean quyenMon;
    private boolean quyenNguyenLieu;
    private boolean quyenLichLam;
    private boolean quyenKhuyenMaiUuDai;
    private boolean quyenNhaCungCap;
    private boolean quyenNhanVien;
    private boolean quyenThongKe;
    private boolean trangThaiPhanQuyen;

 
    public PhanQuyenDTO(String maPhanQuyen, String tenQuyen, boolean quyenKhachHang, boolean quyenBanHang,
            boolean quyenNhapHang, boolean quyenMon, boolean quyenNguyenLieu, boolean quyenLichLam,
            boolean quyenKhuyenMaiUuDai, boolean quyenNhaCungCap, boolean quyenNhanVien, boolean quyenThongKe,
            boolean trangThaiPhanQuyen) {
        this.maPhanQuyen = maPhanQuyen;
        this.tenQuyen = tenQuyen;
        this.quyenKhachHang = quyenKhachHang;
        this.quyenBanHang = quyenBanHang;
        this.quyenNhapHang = quyenNhapHang;
        this.quyenMon = quyenMon;
        this.quyenNguyenLieu = quyenNguyenLieu;
        this.quyenLichLam = quyenLichLam;
        this.quyenKhuyenMaiUuDai = quyenKhuyenMaiUuDai;
        this.quyenNhaCungCap = quyenNhaCungCap;
        this.quyenNhanVien = quyenNhanVien;
        this.quyenThongKe = quyenThongKe;
        this.trangThaiPhanQuyen = trangThaiPhanQuyen;
    }

    public PhanQuyenDTO() {

    }

    public String getMaPhanQuyen() {
        return maPhanQuyen;
    }

    public void setMaPhanQuyen(String maPhanQuyen) {
        this.maPhanQuyen = maPhanQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public boolean getQuyenKhachHang() {
        return quyenKhachHang;
    }

    public void setQuyenKhachHang(boolean quyenKhachHang) {
        this.quyenKhachHang = quyenKhachHang;
    }

    public boolean getQuyenBanHang() {
        return quyenBanHang;
    }

    public void setQuyenBanHang(boolean quyenBanHang) {
        this.quyenBanHang = quyenBanHang;
    }

    public boolean getQuyenNhapHang() {
        return quyenNhapHang;
    }

    public void setQuyenNhapHang(boolean quyenNhapHang) {
        this.quyenNhapHang = quyenNhapHang;
    }

    public boolean getQuyenMon() {
        return quyenMon;
    }

    public void setQuyenMon(boolean quyenMon) {
        this.quyenMon = quyenMon;
    }

    public boolean getQuyenNguyenLieu() {
        return quyenNguyenLieu;
    }

    public void setQuyenNguyenLieu(boolean quyenNguyenLieu) {
        this.quyenNguyenLieu = quyenNguyenLieu;
    }

    public boolean getQuyenLichLam() {
        return quyenLichLam;
    }

    public void setQuyenLichLam(boolean quyenLichLam) {
        this.quyenLichLam = quyenLichLam;
    }

    public boolean getQuyenKhuyenMaiUuDai() {
        return quyenKhuyenMaiUuDai;
    }

    public void setQuyenKhuyenMaiUuDai(boolean quyenKhuyenMaiUuDai) {
        this.quyenKhuyenMaiUuDai = quyenKhuyenMaiUuDai;
    }

    public boolean getQuyenNhaCungCap() {
        return quyenNhaCungCap;
    }

    public void setQuyenNhaCungCap(boolean quyenNhaCungCap) {
        this.quyenNhaCungCap = quyenNhaCungCap;
    }

    public boolean getQuyenNhanVien() {
        return quyenNhanVien;
    }

    public void setQuyenNhanVien(boolean quyenNhanVien) {
        this.quyenNhanVien = quyenNhanVien;
    }

    public boolean getQuyenThongKe() {
        return quyenThongKe;
    }

    public void setQuyenThongKe(boolean quyenThongKe) {
        this.quyenThongKe = quyenThongKe;
    }

    public boolean getTrangThaiPhanQuyen() {
        return trangThaiPhanQuyen;
    }

    public void setTrangThaiPhanQuyen(boolean trangThaiPhanQuyen) {
        this.trangThaiPhanQuyen = trangThaiPhanQuyen;
    }

    @Override
    public String toString() {
        return "PhanQuyenDTO{"
                + "maPhanQuyen='" + maPhanQuyen + '\''
                + ", tenQuyen='" + tenQuyen + '\''
                + ", quyenKhachHang=" + quyenKhachHang
                + ", quyenBanHang=" + quyenBanHang
                + ", quyenNhapHang=" + quyenNhapHang
                + ", quyenMon=" + quyenMon
                + ", quyenNguyenLieu=" + quyenNguyenLieu
                + ", quyenLichLam=" + quyenLichLam
                + ", quyenKhuyenMaiUuDai=" + quyenKhuyenMaiUuDai
                + ", quyenNhaCungCap=" + quyenNhaCungCap
                + ", quyenNhanVien=" + quyenNhanVien
                + ", quyenThongKe=" + quyenThongKe
                + ", trangThaiPhanQuyen=" + trangThaiPhanQuyen
                + '}';
    }

    public static void main(String[] args) {
        PhanQuyenDTO phanQuyen = new PhanQuyenDTO("PQ001", "Quản Lý", true, false, true, true, false, true, false, true, false, true, true);
        System.out.println(phanQuyen.toString());
    }
}
