package DTO;

public class CaLamDTO {

    private String maCaLam;
    private String tenCaLam;
    private String thoiGianVaoCaLam;
    private String thoiGianRaCaLam;
    private boolean trangThaiCaLam;

    public CaLamDTO(String maCaLam, String tenCaLam, String thoiGianVaoCaLam, String thoiGianRaCaLam, boolean trangThaiCaLam) {
        this.maCaLam = maCaLam;
        this.tenCaLam = tenCaLam;
        this.thoiGianVaoCaLam = thoiGianVaoCaLam;
        this.thoiGianRaCaLam = thoiGianRaCaLam;
        this.trangThaiCaLam = trangThaiCaLam;
    }

    public String getMaCaLam() {
        return maCaLam;
    }

    public void setMaCaLam(String maCaLam) {
        this.maCaLam = maCaLam;
    }

    public String getTenCaLam() {
        return tenCaLam;
    }

    public void setTenCaLam(String tenCaLam) {
        this.tenCaLam = tenCaLam;
    }

    public String getThoiGianVaoCaLam() {
        return thoiGianVaoCaLam;
    }

    public void setThoiGianVaoCaLam(String thoiGianVaoCaLam) {
        this.thoiGianVaoCaLam = thoiGianVaoCaLam;
    }

    public String getThoiGianRaCaLam() {
        return thoiGianRaCaLam;
    }

    public void setThoiGianRaCaLam(String thoiGianRaCaLam) {
        this.thoiGianRaCaLam = thoiGianRaCaLam;
    }

    public boolean getTrangThaiCaLam() {
        return trangThaiCaLam;
    }

    public void setTrangThaiCaLam(boolean trangThaiCaLam) {
        this.trangThaiCaLam = trangThaiCaLam;
    }

    @Override
    public String toString() {
        return "CaLamDTO{"
                + "maCaLam='" + maCaLam + '\''
                + ", tenCaLam='" + tenCaLam + '\''
                + ", thoiGianVaoCaLam=" + thoiGianVaoCaLam
                + ", thoiGianRaCaLam=" + thoiGianRaCaLam
                + ", trangThaiCaLam=" + trangThaiCaLam
                + '}';
    }

    public static void main(String[] args) {
        CaLamDTO caLam = new CaLamDTO("CL001", "Ca sang", "06:00", "14:00", true);
        System.out.println(caLam.toString());
    }
}
