package DTO;

public class NhaCungCapDTO {

    private String maNhaCungCap;
    private String tenNhaCungCap;
    private String diaChiNhaCungCap;
    private String soDienThoaiNhaCungCap;
    private boolean trangThaiNhaCungCap;
    public NhaCungCapDTO(){
        
    }
    public NhaCungCapDTO(String maNhaCungCap, String tenNhaCungCap, String diaChiNhaCungCap, String soDienThoaiNhaCungCap, boolean trangThaiNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChiNhaCungCap = diaChiNhaCungCap;
        this.soDienThoaiNhaCungCap = soDienThoaiNhaCungCap;
        this.trangThaiNhaCungCap = trangThaiNhaCungCap;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getDiaChiNhaCungCap() {
        return diaChiNhaCungCap;
    }

    public void setDiaChiNhaCungCap(String diaChiNhaCungCap) {
        this.diaChiNhaCungCap = diaChiNhaCungCap;
    }

    public String getSoDienThoaiNhaCungCap() {
        return soDienThoaiNhaCungCap;
    }

    public void setSoDienThoaiNhaCungCap(String soDienThoaiNhaCungCap) {
        this.soDienThoaiNhaCungCap = soDienThoaiNhaCungCap;
    }

    public boolean isTrangThaiNhaCungCap() {
        return trangThaiNhaCungCap;
    }

    public void setTrangThaiNhaCungCap(boolean trangThaiNhaCungCap) {
        this.trangThaiNhaCungCap = trangThaiNhaCungCap;
    }

    @Override
    public String toString() {
        return "NhaCungCapDTO{"
                + "maNhaCungCap='" + maNhaCungCap + '\''
                + ", tenNhaCungCap='" + tenNhaCungCap + '\''
                + ", diaChiNhaCungCap='" + diaChiNhaCungCap + '\''
                + ", soDienThoaiNhaCungCap='" + soDienThoaiNhaCungCap + '\''
                + ", trangThaiNhaCungCap=" + trangThaiNhaCungCap
                + '}';
    }

    public static void main(String[] args) {
        NhaCungCapDTO nhaCungCap = new NhaCungCapDTO("NCC001", "ABC Company", "123 ABC Street", "0123456789", true);
        System.out.println(nhaCungCap.toString());
    }
}
