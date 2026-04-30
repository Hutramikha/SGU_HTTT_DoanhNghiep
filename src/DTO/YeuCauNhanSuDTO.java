package DTO;

import java.sql.Date;

public class YeuCauNhanSuDTO {
    private String maYeuCau;
    private String maNhanVien;
    private String loaiYeuCau;
    private Date tuNgay;
    private Date denNgay;
    private String lyDo;
    private String trangThai;
    private String maQuanLyDuyet;
    private Date ngayTao;
    private Date ngayDuyet;

    public YeuCauNhanSuDTO() {
    }

    public YeuCauNhanSuDTO(String maYeuCau, String maNhanVien, String loaiYeuCau, Date tuNgay, Date denNgay,
            String lyDo, String trangThai, String maQuanLyDuyet, Date ngayTao, Date ngayDuyet) {
        this.maYeuCau = maYeuCau;
        this.maNhanVien = maNhanVien;
        this.loaiYeuCau = loaiYeuCau;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lyDo = lyDo;
        this.trangThai = trangThai;
        this.maQuanLyDuyet = maQuanLyDuyet;
        this.ngayTao = ngayTao;
        this.ngayDuyet = ngayDuyet;
    }

    public String getMaYeuCau() {
        return maYeuCau;
    }

    public void setMaYeuCau(String maYeuCau) {
        this.maYeuCau = maYeuCau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getLoaiYeuCau() {
        return loaiYeuCau;
    }

    public void setLoaiYeuCau(String loaiYeuCau) {
        this.loaiYeuCau = loaiYeuCau;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaQuanLyDuyet() {
        return maQuanLyDuyet;
    }

    public void setMaQuanLyDuyet(String maQuanLyDuyet) {
        this.maQuanLyDuyet = maQuanLyDuyet;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayDuyet() {
        return ngayDuyet;
    }

    public void setNgayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }
}
