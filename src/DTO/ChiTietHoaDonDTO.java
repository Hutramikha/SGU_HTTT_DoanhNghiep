package DTO;

public class ChiTietHoaDonDTO {

    private String maHoaDon;
    private String maMon;
    private int donGia;
    private int thanhTien;
    private int soLuong;
    
    public ChiTietHoaDonDTO(){
        
    }

    public ChiTietHoaDonDTO(String maHoaDon, String maMon, int donGia, int thanhTien, int soLuong) {
        this.maHoaDon = maHoaDon;
        this.maMon = maMon;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.soLuong = soLuong;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonDTO{"
                + "maHoaDon='" + maHoaDon + '\''
                + ", maMon='" + maMon + '\''
                + ", donGia=" + donGia
                + ", thanhTien=" + thanhTien
                + ", soLuong=" + soLuong
                + '}';
    }

    public static void main(String[] args) {
        ChiTietHoaDonDTO chiTietHoaDon = new ChiTietHoaDonDTO("HD001", "M001", 50000, 100000, 2);
        System.out.println(chiTietHoaDon.toString());
    }
}
