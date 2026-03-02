package DTO;

public class CongThucDTO {
    private String maMon;
    private String maNguyenLieu;
    private Double khoiLuong;

    public CongThucDTO(String maMon, String maNguyenLieu, Double khoiLuong) {
        this.maMon = maMon;
        this.maNguyenLieu = maNguyenLieu;
        this.khoiLuong = khoiLuong;
    }
    public String getMaMon() {
        return maMon;
    }
    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }
    public String getMaNguyenLieu() {
        return maNguyenLieu;
    }
    public void setMaNguyenLieu(String maNguyenLieu) {
        this.maNguyenLieu = maNguyenLieu;
    }
    public Double getKhoiLuong() {
        return khoiLuong;
    }
    public void setKhoiLuong(Double khoiLuong) {
        this.khoiLuong = khoiLuong;
    }
}
