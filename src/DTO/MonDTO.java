package DTO;

public class MonDTO {
    private String maMon;
    private String maLoaiMon;
    private String tenMon;
    private String hinhAnh;
    private int donGiaMon;
    private boolean trangThaiMon;


    public MonDTO(String maMon, String maLoaiMon, String tenMon, String hinhAnh, int donGiaMon, boolean trangThaiMon) {
        this.maMon = maMon;
        this.maLoaiMon = maLoaiMon;
        this.tenMon = tenMon;
        this.hinhAnh = hinhAnh;
        this.donGiaMon = donGiaMon;
        this.trangThaiMon = trangThaiMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMaLoaiMon() {
        return maLoaiMon;
    }

    public void setMaLoaiMon(String maLoaiMon) {
        this.maLoaiMon = maLoaiMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getDonGiaMon() {
        return donGiaMon;
    }

    public void setDonGiaMon(int donGiaMon) {
        this.donGiaMon = donGiaMon;
    }

    public boolean getTrangThaiMon() {
        return trangThaiMon;
    }

    public void setTrangThaiMon(boolean trangThaiMon) {
        this.trangThaiMon = trangThaiMon;
    }

    @Override
    public String toString() {
        return "MonDTO{" +
                "maMon='" + maMon + '\'' +
                ", maLoaiMon='" + maLoaiMon + '\'' +
                ", tenMon='" + tenMon + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", donGiaMon=" + donGiaMon +
                ", trangThaiMon=" + trangThaiMon +
                '}';
    }

    public static void main(String[] args) {
        MonDTO mon = new MonDTO("M001", "LM001", "Cà Phê Muối", "Anh1", 50000, true);
        System.out.println(mon.toString());
    }
}
