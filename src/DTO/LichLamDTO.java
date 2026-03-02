package DTO;

import java.sql.Date;

public class LichLamDTO {

    private String maCaLam;
    private String maNhanVien;
    private Date ngayLam;

    public LichLamDTO(String maCaLam, String maNhanVien, Date ngayLam) {
        this.maCaLam = maCaLam;
        this.maNhanVien = maNhanVien;
        this.ngayLam = ngayLam;
    }

    public String getMaCaLam() {
        return maCaLam;
    }

    public void setMaCaLam(String maCaLam) {
        this.maCaLam = maCaLam;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(Date ngayLam) {
        this.ngayLam = ngayLam;
    }

    @Override
    public String toString() {
        return "LichLamDTO{" +
                "maCaLam='" + maCaLam + '\'' +
                ", maNhanVien='" + maNhanVien + '\'' +
                ", ngayLam=" + ngayLam +
                '}';
    }

    public static void main(String[] args) {
        Date ngayLam = Date.valueOf("2024-10-21"); 

        LichLamDTO lichLamDTO = new LichLamDTO("CL001", "NV001", ngayLam);
        System.out.println(lichLamDTO.toString());
    }
}
