package DTO;

import java.util.Date;

public class KhuyenMaiDTO {
    private String maKhuyenMai;
    private String tenKhuyenMai;
    private Date ngayBatDauKhuyenMai;
    private Date ngayKetThucKhuyenMai;
    private float phanTramKhuyenMai;
    private int dieuKienKhuyenMai;

    public KhuyenMaiDTO(String maKhuyenMai, String tenKhuyenMai, Date ngayBatDauKhuyenMai, Date ngayKetThucKhuyenMai, float phanTramKhuyenMai, int dieuKienKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDauKhuyenMai = ngayBatDauKhuyenMai;
        this.ngayKetThucKhuyenMai = ngayKetThucKhuyenMai;
        this.phanTramKhuyenMai = phanTramKhuyenMai;
        this.dieuKienKhuyenMai = dieuKienKhuyenMai;
    }

    public KhuyenMaiDTO() {
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Date getNgayBatDauKhuyenMai() {
        return ngayBatDauKhuyenMai;
    }

    public void setNgayBatDauKhuyenMai(Date ngayBatDauKhuyenMai) {
        this.ngayBatDauKhuyenMai = ngayBatDauKhuyenMai;
    }

    public Date getNgayKetThucKhuyenMai() {
        return ngayKetThucKhuyenMai;
    }

    public void setNgayKetThucKhuyenMai(Date ngayKetThucKhuyenMai) {
        this.ngayKetThucKhuyenMai = ngayKetThucKhuyenMai;
    }

    public float getPhanTramKhuyenMai() {
        return phanTramKhuyenMai;
    }

    public void setPhanTramKhuyenMai(float phanTramKhuyenMai) {
        this.phanTramKhuyenMai = phanTramKhuyenMai;
    }

    public int getDieuKienKhuyenMai() {
        return dieuKienKhuyenMai;
    }

    public void setDieuKienKhuyenMai(int dieuKienKhuyenMai) {
        this.dieuKienKhuyenMai = dieuKienKhuyenMai;
    }

    @Override
    public String toString() {
        return "KhuyenMaiDTO{" +
                "maKhuyenMai='" + maKhuyenMai + '\'' +
                ", tenKhuyenMai='" + tenKhuyenMai + '\'' +
                ", ngayBatDauKhuyenMai=" + ngayBatDauKhuyenMai +
                ", ngayKetThucKhuyenMai=" + ngayKetThucKhuyenMai +
                ", phanTramKhuyenMai=" + phanTramKhuyenMai +
                ", dieuKienKhuyenMai=" + dieuKienKhuyenMai +
                '}';
    }

}
