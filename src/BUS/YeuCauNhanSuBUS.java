package BUS;

import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;
import DAO.YeuCauNhanSuDAO;
import DTO.YeuCauNhanSuDTO;
import Util.dialog;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class YeuCauNhanSuBUS {
    public static final String LOAI_NGHI_PHEP = "NGHI_PHEP";
    public static final String LOAI_NGHI_VIEC = "NGHI_VIEC";

    public static final String TRANG_THAI_CHO_DUYET = "CHO_DUYET";
    public static final String TRANG_THAI_DA_DUYET = "DA_DUYET";
    public static final String TRANG_THAI_TU_CHOI = "TU_CHOI";

    private final YeuCauNhanSuDAO yeuCauDAO = new YeuCauNhanSuDAO();
    private final NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private final TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

    public boolean guiYeuCau(String maNhanVien, String loaiYeuCau, Date tuNgay, Date denNgay, String lyDo) {
        if (maNhanVien == null || maNhanVien.trim().isEmpty()) {
            new dialog("Không xác định nhân viên gửi yêu cầu.", dialog.ERROR_DIALOG);
            return false;
        }
        if (loaiYeuCau == null || loaiYeuCau.trim().isEmpty()) {
            new dialog("Vui lòng chọn loại yêu cầu.", dialog.ERROR_DIALOG);
            return false;
        }
        if (LOAI_NGHI_PHEP.equals(loaiYeuCau)) {
            if (tuNgay == null || denNgay == null) {
                new dialog("Vui lòng chọn đủ ngày nghỉ.", dialog.ERROR_DIALOG);
                return false;
            }
            if (tuNgay.after(denNgay)) {
                new dialog("Ngày bắt đầu không được sau ngày kết thúc.", dialog.ERROR_DIALOG);
                return false;
            }
        } else if (LOAI_NGHI_VIEC.equals(loaiYeuCau)) {
            if (tuNgay == null) {
                new dialog("Vui lòng chọn ngày nghỉ việc.", dialog.ERROR_DIALOG);
                return false;
            }
        }

        YeuCauNhanSuDTO dto = new YeuCauNhanSuDTO();
        dto.setMaYeuCau(yeuCauDAO.layMaYeuCauCuoiCung());
        dto.setMaNhanVien(maNhanVien);
        dto.setLoaiYeuCau(loaiYeuCau);
        dto.setTuNgay(tuNgay);
        dto.setDenNgay(denNgay);
        dto.setLyDo(lyDo);
        dto.setTrangThai(TRANG_THAI_CHO_DUYET);
        dto.setNgayTao(Date.valueOf(LocalDate.now()));
        dto.setNgayDuyet(null);

        boolean ok = yeuCauDAO.themYeuCau(dto);
        if (ok) {
            new dialog("Đã gửi yêu cầu, chờ quản lý duyệt.", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Gửi yêu cầu thất bại.", dialog.ERROR_DIALOG);
        }
        return ok;
    }

    public ArrayList<YeuCauNhanSuDTO> layDanhSachChoDuyet() {
        return yeuCauDAO.getByTrangThai(TRANG_THAI_CHO_DUYET);
    }

    public ArrayList<YeuCauNhanSuDTO> layTheoNhanVien(String maNhanVien) {
        return yeuCauDAO.getByMaNhanVien(maNhanVien);
    }

    public boolean duyetYeuCau(String maYeuCau, String maQuanLy, boolean chapNhan) {
        YeuCauNhanSuDTO yc = yeuCauDAO.getById(maYeuCau);
        if (yc == null) {
            new dialog("Không tìm thấy yêu cầu.", dialog.ERROR_DIALOG);
            return false;
        }

        String trangThai = chapNhan ? TRANG_THAI_DA_DUYET : TRANG_THAI_TU_CHOI;
        Date ngayDuyet = Date.valueOf(LocalDate.now());

        boolean ok = yeuCauDAO.updateTrangThai(maYeuCau, trangThai, maQuanLy, ngayDuyet);
        if (!ok) {
            new dialog("Cập nhật trạng thái thất bại.", dialog.ERROR_DIALOG);
            return false;
        }

        if (chapNhan && LOAI_NGHI_VIEC.equals(yc.getLoaiYeuCau())) {
            nhanVienDAO.updateTrangThaiNhanVien(yc.getMaNhanVien(), 0);
            taiKhoanDAO.capNhatNgayNghiViec(yc.getMaNhanVien(), ngayDuyet);
            // Mark all future shifts as unpaid leave/resigned
            LichLamBUS.getInstance().capNhatTrangThaiNghi(yc.getMaNhanVien(), yc.getTuNgay(), yc.getDenNgay(), 3);
        } else if (chapNhan && LOAI_NGHI_PHEP.equals(yc.getLoaiYeuCau())) {
            // Mark shifts as paid leave
            LichLamBUS.getInstance().capNhatTrangThaiNghi(yc.getMaNhanVien(), yc.getTuNgay(), yc.getDenNgay(), 2);
        }

        new dialog(chapNhan ? "Đã duyệt yêu cầu." : "Đã từ chối yêu cầu.", dialog.SUCCESS_DIALOG);
        return true;
    }
}
