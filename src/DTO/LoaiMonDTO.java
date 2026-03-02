package DTO;

public class LoaiMonDTO {

    private String maLoaiMon;
    private String tenLoaiMon;
    private boolean trangThaiLoaiMon;

    public LoaiMonDTO(String maLoaiMon, String tenLoaiMon, boolean trangThaiLoaiMon) {
        this.maLoaiMon = maLoaiMon;
        this.tenLoaiMon = tenLoaiMon;
        this.trangThaiLoaiMon = trangThaiLoaiMon;
    }

    public String getMaLoaiMon() {
        return maLoaiMon;
    }

    public void setMaLoaiMon(String maLoaiMon) {
        this.maLoaiMon = maLoaiMon;
    }

    public String getTenLoaiMon() {
        return tenLoaiMon;
    }

    public void setTenLoaiMon(String tenLoaiMon) {
        this.tenLoaiMon = tenLoaiMon;
    }

    public boolean getTrangThaiLoaiMon() {
        return trangThaiLoaiMon;
    }

    public void setTrangThaiLoaiMon(boolean trangThaiLoaiMon) {
        this.trangThaiLoaiMon = trangThaiLoaiMon;
    }

    @Override
    public String toString() {
        return tenLoaiMon;
    }

    public static void main(String[] args) {
        LoaiMonDTO loaiMon = new LoaiMonDTO("LM001", "Cà Phê", true);
        System.out.println(loaiMon.toString());
    }
}
