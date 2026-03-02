package DTO;

import java.util.Date;

public class UuDaiThanhVienDTO {

    private String maUuDai;
    private String tenUuDai;
    private Date ngayBatDauUuDai;
    private Date ngayKetThucUuDai;
    private float phanTramUuDai;
    private int dieuKienUuDai;

    public UuDaiThanhVienDTO(String maUuDai, String tenUuDai, Date ngayBatDauUuDai, Date ngayKetThucUuDai, float phanTramUuDai, int dieuKienUuDai) {
        this.maUuDai = maUuDai;
        this.tenUuDai = tenUuDai;
        this.ngayBatDauUuDai = ngayBatDauUuDai;
        this.ngayKetThucUuDai = ngayKetThucUuDai;
        this.phanTramUuDai = phanTramUuDai;
        this.dieuKienUuDai = dieuKienUuDai;
    }

    public UuDaiThanhVienDTO() {
         // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMaUuDai() {
        return maUuDai;
    }

    public void setMaUuDai(String maUuDai) {
        this.maUuDai = maUuDai;
    }

    public String getTenUuDai() {
        return tenUuDai;
    }

    public void setTenUuDai(String tenUuDai) {
        this.tenUuDai = tenUuDai;
    }

    public Date getNgayBatDauUuDai() {
        return ngayBatDauUuDai;
    }

    public void setNgayBatDauUuDai(Date ngayBatDauUuDai) {
        this.ngayBatDauUuDai = ngayBatDauUuDai;
    }

    public Date getNgayKetThucUuDai() {
        return ngayKetThucUuDai;
    }

    public void setNgayKetThucUuDai(Date ngayKetThucUuDai) {
        this.ngayKetThucUuDai = ngayKetThucUuDai;
    }

    public float getPhanTramUuDai() {
        return phanTramUuDai;
    }

    public void setPhanTramUuDai(float phanTramUuDai) {
        this.phanTramUuDai = phanTramUuDai;
    }

    public int getDieuKienUuDai() {
        return dieuKienUuDai;
    }

    public void setDieuKienUuDai(int dieuKienUuDai) {
        this.dieuKienUuDai = dieuKienUuDai;
    }

    @Override
    public String toString() {
        return "UuDaiThanhVienDTO{" +
                "maUuDai='" + maUuDai + '\'' +
                ", tenUuDai='" + tenUuDai + '\'' +
                ", ngayBatDauUuDai=" + ngayBatDauUuDai +
                ", ngayKetThucUuDai=" + ngayKetThucUuDai +
                ", phanTramUuDai=" + phanTramUuDai +
                ", dieuKienUuDai=" + dieuKienUuDai +
                '}';
    }

    public static void main(String[] args) {
        // Khởi tạo với ngày và phần trăm ưu đãi phù hợp kiểu dữ liệu mới
        UuDaiThanhVienDTO uuDai = new UuDaiThanhVienDTO("UD001", "Uu Dai 1", new Date(), new Date(), 15.5f, 500000);
        System.out.println(uuDai.toString());
    }
}
