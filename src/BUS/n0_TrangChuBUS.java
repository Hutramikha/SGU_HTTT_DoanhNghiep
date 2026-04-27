package BUS;

import DAO.n0_TrangChuDAO;
import DTO.NhanVienDTO;
import DTO.PhanQuyenDTO;
import java.awt.Color;
import javax.swing.JLabel;

public class n0_TrangChuBUS {

    private n0_TrangChuDAO trangChuDAO;
    private static final Color DISABLED_COLOR = new Color(150, 150, 150);
    private static final Color DISABLED_BG = new Color(240, 240, 240);

    public n0_TrangChuBUS() {
        this.trangChuDAO = new n0_TrangChuDAO();
    }

    public NhanVienDTO getById(String maNhanVien) {
        return trangChuDAO.getById(maNhanVien);
    }

    private void applyPermissionStyle(JLabel label, boolean hasPermission) {
        if (!hasPermission) {
            label.setForeground(DISABLED_COLOR);
            label.setOpaque(true);
            label.setBackground(DISABLED_BG);
            // Store as tag that this label is disabled
            label.putClientProperty("disabled", true);
        } else {
            label.setForeground(Color.WHITE);
            label.putClientProperty("disabled", false);
        }
    }

    public PhanQuyenDTO getPhanQuyen(String maNhanVien, JLabel LabelBanHang, JLabel LabelKhachHang,
            JLabel LabelNhapHang, JLabel LabelMon,
            JLabel LabelNguyenLieu, JLabel lLichLam, JLabel LabelKhuyenMai, JLabel LabelNhaCungCap,
            JLabel LabelNhanVien, JLabel LabelThongKe) {
        n0_TrangChuDAO dao = new n0_TrangChuDAO();
        PhanQuyenDTO dto = dao.getPhanQuyen(maNhanVien);
        if (dto == null) {
            dto = new PhanQuyenDTO("", "", false, false, false, false, false, false, false, false, false, false,
                    false);
        }

        // Kiểm tra quyền và thay đổi màu chữ
        applyPermissionStyle(LabelBanHang, dto.getQuyenBanHang());
        applyPermissionStyle(LabelKhachHang, dto.getQuyenKhachHang());
        applyPermissionStyle(LabelNhapHang, dto.getQuyenNhapHang());
        applyPermissionStyle(LabelMon, dto.getQuyenMon());
        applyPermissionStyle(LabelNguyenLieu, dto.getQuyenNguyenLieu());
        applyPermissionStyle(lLichLam, dto.getQuyenLichLam());
        applyPermissionStyle(LabelKhuyenMai, dto.getQuyenKhuyenMaiUuDai());
        applyPermissionStyle(LabelNhaCungCap, dto.getQuyenNhaCungCap());
        applyPermissionStyle(LabelNhanVien, dto.getQuyenNhanVien());
        applyPermissionStyle(LabelThongKe, dto.getQuyenThongKe());

        return dto;
    }

}
