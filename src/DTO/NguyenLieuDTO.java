package DTO;

public class NguyenLieuDTO {

    private String maNguyenLieu;
    private String tenNguyenLieu;
    private double khoiLuongNguyenLieu;
    private int donGiaNguyenLieu;
    private boolean trangThaiNguyenLieu;

    public NguyenLieuDTO(String maNguyenLieu, String tenNguyenLieu, double khoiLuongNguyenLieu, int donGiaNguyenLieu, boolean trangThaiNguyenLieu) {
        this.maNguyenLieu = maNguyenLieu;
        this.tenNguyenLieu = tenNguyenLieu;
        this.khoiLuongNguyenLieu = khoiLuongNguyenLieu;
        this.donGiaNguyenLieu = donGiaNguyenLieu;
        this.trangThaiNguyenLieu = trangThaiNguyenLieu;
    }

    public String getMaNguyenLieu() {
        return maNguyenLieu;
    }

    public void setMaNguyenLieu(String maNguyenLieu) {
        this.maNguyenLieu = maNguyenLieu;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public double getKhoiLuongNguyenLieu() {
        return khoiLuongNguyenLieu;
    }

    public void setKhoiLuongNguyenLieu(double khoiLuongNguyenLieu) {
        this.khoiLuongNguyenLieu = khoiLuongNguyenLieu;
    }

    public int getDonGiaNguyenLieu() {
        return donGiaNguyenLieu;
    }

    public void setDonGiaNguyenLieu(int donGiaNguyenLieu) {
        this.donGiaNguyenLieu = donGiaNguyenLieu;
    }

    public boolean getTrangThaiNguyenLieu() {
        return trangThaiNguyenLieu;
    }

    public void setTrangThaiNguyenLieu(boolean trangThaiNguyenLieu) {
        this.trangThaiNguyenLieu = trangThaiNguyenLieu;
    }

    @Override
    public String toString() {
        return "NguyenLieuDTO{"
                + "maNguyenLieu='" + maNguyenLieu + '\''
                + ", tenNguyenLieu='" + tenNguyenLieu + '\''
                + ", khoiLuongNguyenLieu=" + khoiLuongNguyenLieu
                + ", donGiaNguyenLieu=" + donGiaNguyenLieu
                + ", trangThaiNguyenLieu=" + trangThaiNguyenLieu
                + '}';
    }

    public static void main(String[] args) {
        NguyenLieuDTO nguyenLieu = new NguyenLieuDTO("NL001", "Cà Phê Hạt", 1.5, 50000, true);
        System.out.println(nguyenLieu.toString());
    }
}
