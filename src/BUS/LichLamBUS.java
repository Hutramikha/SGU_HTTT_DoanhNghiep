package BUS;

import DAO.n6_CaLamDAO;
import DAO.n6_LichLamDAO;
import DTO.LichLamDTO;
import javax.swing.JOptionPane;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LichLamBUS {

    public static LichLamBUS getInstance() {
        return new LichLamBUS();
    }

    public void hienThi_NgayHienTai(JLabel LabelNgay) {
        LocalDate today = LocalDate.now();

        Date date = Date.valueOf(today);
        List<Date> tuan = Util.LichLam_CaLam.DauTuan_CuoiTuan(date);

        String DauTuan = Util.LichLam_CaLam.yyyy_mm_dd__to__dd_mm_yyyy(String.valueOf(tuan.get(0)));
        String CuoiTuan = Util.LichLam_CaLam.yyyy_mm_dd__to__dd_mm_yyyy(String.valueOf(tuan.get(1)));
        DauTuan = DauTuan.replaceAll("[-\\.,]", "/");
        CuoiTuan = CuoiTuan.replaceAll("[-\\.,]", "/");

        String period = DauTuan + "   ->   " + CuoiTuan;
        LabelNgay.setText(period);
    }

    public Boolean Khoi_tao_ngay_lam(String Ngay) {
        Date NgayDate = Date.valueOf(Ngay);

        n6_LichLamDAO dao = n6_LichLamDAO.getInstance();
        Boolean dao_insert = dao.tao_LichLam_TheoNgay(NgayDate);
        if (dao_insert) {
            JOptionPane.showMessageDialog(null, "Khởi tạo thành công");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Khởi tạo thất bại");
            return false;
        }
    }

    public void Dieu_chinh(String TenCaLam, String TenNhanVien, String Ngay) {
        n6_LichLamDAO dao = n6_LichLamDAO.getInstance();

        String MaCaLam = dao.tim_maCaLam_theo_TenCaLam(TenCaLam);
        String MaNhanVien = dao.tim_maNhanVien_theo_TenNhanVien(TenNhanVien);
        System.out.println(MaCaLam + " " + MaNhanVien);
        Date NgayDate = Date.valueOf(Ngay);
        System.out.println(Ngay);

        LichLamDTO dto = new LichLamDTO(MaCaLam, MaNhanVien, NgayDate);

        Boolean dao_update = dao.update(dto);
        if (dao_update) {
            JOptionPane.showMessageDialog(null, "Điều chỉnh thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Điều chỉnh thất bại");
        }
    }

    public void Xoa(String TenNhanVien, String Ngay) {
        n6_LichLamDAO dao = n6_LichLamDAO.getInstance();

        String MaNhanVien = dao.tim_maNhanVien_theo_TenNhanVien(TenNhanVien);
        Date NgayDate = Date.valueOf(Ngay);

        LichLamDTO dto = new LichLamDTO("", MaNhanVien, NgayDate);

        Boolean dao_update = dao.delete(dto);
        if (dao_update) {
            JOptionPane.showMessageDialog(null, "Tắt lịch làm thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Tắt lịch làm thất bại");
        }
    }

    public String TimKiem(String Ngay_Str_preformatted) {
        Ngay_Str_preformatted = Ngay_Str_preformatted.replaceAll("[/\\.,]", "-");
        if (Ngay_Str_preformatted == null || !Ngay_Str_preformatted.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng. Ví dụ: 01-01-2024");
            return null;
        }

        try {
            // Định dạng ngày từ dd-MM-yyyy sang yyyy-MM-dd
            String Ngay_Str_formatted = Util.LichLam_CaLam.dd_mm_yyyy__to__yyyy_mm_dd(Ngay_Str_preformatted);

            // Chuyển chuỗi đã định dạng thành đối tượng Date
            Date Ngay_Date = Date.valueOf(Ngay_Str_formatted);

            // Tìm ngày đầu tuần và cuối tuần từ ngày đã chọn
            List<Date> tuan = Util.LichLam_CaLam.DauTuan_CuoiTuan(Ngay_Date);

            // Định dạng ngày đầu tuần và cuối tuần về lại dạng dd-MM-yyyy
            String DauTuan = Util.LichLam_CaLam.yyyy_mm_dd__to__dd_mm_yyyy(String.valueOf(tuan.get(0)));
            String CuoiTuan = Util.LichLam_CaLam.yyyy_mm_dd__to__dd_mm_yyyy(String.valueOf(tuan.get(1)));
            DauTuan = DauTuan.replaceAll("[-\\.,]", "/");
            CuoiTuan = CuoiTuan.replaceAll("[-\\.,]", "/");

            // Tìm kiếm danh sách Lịch làm trong tuần
            ArrayList<LichLamDTO> list = n6_LichLamDAO.getInstance().TimKiem_theoNgay(Ngay_Date);
//            for (LichLamDTO lich : list) {
//                System.out.println(lich.toString());
//            }

            String period = DauTuan + "   ->   " + CuoiTuan;
            return period;

        } catch (Exception e) {
            // Xử lý khi có lỗi
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xử lý ngày. Vui lòng thử lại!");
            System.out.println("Lỗi khi xử lý ngày: " + e.getMessage());
            return null;
        }
    }

    public void data(JTable table, String dateStr) {
        n6_CaLamDAO.getInstance().taoMaCaLam_off();
        Date date = Date.valueOf(dateStr);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        ArrayList<String> dsLichLam = n6_LichLamDAO.getInstance().showAll(date);

        for (String row : dsLichLam) {
            String[] rowData = row.split(", ");
            model.addRow(rowData);
        }
        if (dsLichLam.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Rất tiếc, không tìm thấy tuần làm phù hợp ! \nVui lòng kiểm tra lại thông tin.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
