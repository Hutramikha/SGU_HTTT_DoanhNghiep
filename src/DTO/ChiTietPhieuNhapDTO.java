package DTO;

public class ChiTietPhieuNhapDTO {

    private String maPhieuNhap;
    private String maNguyenLieu;
    private int donGia;
    private int thanhTien;
    private double khoiLuong;

    public ChiTietPhieuNhapDTO() {
    }
    
    public ChiTietPhieuNhapDTO(String maPhieuNhap, String maNguyenLieu, int donGia, int thanhTien, double khoiLuong) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNguyenLieu = maNguyenLieu;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.khoiLuong = khoiLuong;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaNguyenLieu() {
        return maNguyenLieu;
    }

    public void setMaNguyenLieu(String maNguyenLieu) {
        this.maNguyenLieu = maNguyenLieu;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(float khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhapDTO{"
                + "maPhieuNhap='" + maPhieuNhap + '\''
                + ", maNguyenLieu='" + maNguyenLieu + '\''
                + ", donGia=" + donGia
                + ", thanhTien=" + thanhTien
                + ", khoiLuong=" + khoiLuong
                + '}';
    }

    public static void main(String[] args) {
        ChiTietPhieuNhapDTO chiTietPhieuNhap = new ChiTietPhieuNhapDTO("PN001", "NL001", 5000, 10000, 2.5f);
        System.out.println(chiTietPhieuNhap.toString());
    }
}
