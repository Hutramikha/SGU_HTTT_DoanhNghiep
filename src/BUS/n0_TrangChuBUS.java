package BUS;

import DAO.n0_TrangChuDAO;
import DTO.NhanVienDTO;
import DTO.PhanQuyenDTO;
import java.awt.Color;
import javax.swing.JLabel;

public class n0_TrangChuBUS {

    private n0_TrangChuDAO trangChuDAO;

    public n0_TrangChuBUS() {
        this.trangChuDAO = new n0_TrangChuDAO();
    }

    public NhanVienDTO getById(String maNhanVien) {
        return trangChuDAO.getById(maNhanVien);
    }

    public PhanQuyenDTO getPhanQuyen(String maNhanVien, JLabel LabelBanHang, JLabel LabelKhachHang, JLabel LabelNhapHang, JLabel LabelMon,
            JLabel LabelNguyenLieu, JLabel lLichLam, JLabel LabelKhuyenMai, JLabel LabelNhaCungCap, JLabel LabelNhanVien, JLabel LabelThongKe) {
        n0_TrangChuDAO dao = new n0_TrangChuDAO();
        PhanQuyenDTO dto = dao.getPhanQuyen(maNhanVien);

        // Kiểm tra quyền và thay đổi màu chữ
        if (!dto.getQuyenBanHang()) {
            LabelBanHang.setForeground(new Color(150, 150, 150));
            LabelBanHang.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            LabelBanHang.setBackground(new Color(240, 240, 240));
        } else {
            LabelBanHang.setForeground(Color.BLACK);  // Hoặc màu mặc định
        }

        if (!dto.getQuyenKhachHang()) {
            LabelKhachHang.setForeground(new Color(150, 150, 150));
            LabelKhachHang.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            LabelKhachHang.setBackground(new Color(240, 240, 240));
        } else {
            LabelKhachHang.setForeground(Color.BLACK);
        }

        if (!dto.getQuyenNhapHang()) {
            LabelNhapHang.setForeground(new Color(150, 150, 150));
            LabelNhapHang.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            LabelNhapHang.setBackground(new Color(240, 240, 240));
        } else {
            LabelNhapHang.setForeground(Color.BLACK);
        }

        if (!dto.getQuyenMon()) {
            LabelMon.setForeground(new Color(150, 150, 150));
            LabelMon.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            LabelMon.setBackground(new Color(240, 240, 240));
        } else {
            LabelMon.setForeground(Color.BLACK);
        }

        if (!dto.getQuyenNguyenLieu()) {
            LabelNguyenLieu.setForeground(new Color(150, 150, 150));
            LabelNguyenLieu.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            LabelNguyenLieu.setBackground(new Color(240, 240, 240));
        } else {
            LabelNguyenLieu.setForeground(Color.BLACK);
        }

        if (!dto.getQuyenLichLam()) {
            lLichLam.setForeground(new Color(150, 150, 150));
            lLichLam.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            lLichLam.setBackground(new Color(240, 240, 240));
        } else {
            lLichLam.setForeground(Color.BLACK);
        }

        if (!dto.getQuyenKhuyenMaiUuDai()) {
            LabelKhuyenMai.setForeground(new Color(150, 150, 150));
            LabelKhuyenMai.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            LabelKhuyenMai.setBackground(new Color(240, 240, 240));
        } else {
            LabelKhuyenMai.setForeground(Color.BLACK);
        }

        if (!dto.getQuyenNhaCungCap()) {
            LabelNhaCungCap.setForeground(new Color(150, 150, 150));
            LabelNhaCungCap.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            LabelNhaCungCap.setBackground(new Color(240, 240, 240));
        } else {
            LabelNhaCungCap.setForeground(Color.BLACK);
        }

        if (!dto.getQuyenNhanVien()) {
            LabelNhanVien.setForeground(new Color(150, 150, 150));
            LabelNhanVien.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            LabelNhanVien.setBackground(new Color(240, 240, 240));
        } else {
            LabelNhanVien.setForeground(Color.BLACK);
        }

        if (!dto.getQuyenThongKe()) {
            LabelThongKe.setForeground(new Color(150, 150, 150));
            LabelThongKe.setOpaque(true); // Đảm bảo JLabel hiển thị màu nền
            LabelThongKe.setBackground(new Color(240, 240, 240));
        } else {
            LabelThongKe.setForeground(Color.BLACK);
        }

        return dto;
    }

}
