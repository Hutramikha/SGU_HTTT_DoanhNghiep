package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

public class TrangChuBUS {

    public static TrangChuBUS getInstance() {
        return new TrangChuBUS();
    }

    public void hienThi_NgayHienTai(JLabel LabelDate) {
        LocalDate today = LocalDate.now();

        // Định dạng ngày theo kiểu "dd-MM-yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String pre_ngay = today.format(formatter);
        String ngay = pre_ngay.substring(0, 2);
        String thang = pre_ngay.substring(3, 5);
        String nam = pre_ngay.substring(6, 10);
        // Lấy thứ trong tuần
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        String lich = "";
        if (dayOfWeek.getValue() == 7) {
            lich = "Chủ Nhật, " + ngay + " tháng " + thang + " năm " + nam;
        } else {
            lich = "Thứ " + (dayOfWeek.getValue() + 1) + ", " + ngay + " tháng " + thang + " năm " + nam;
        }

//        System.out.println(lich);
        LabelDate.setText(lich);
    }

    public NhanVienDTO get_NhanVien(String Ma) {
        NhanVienDAO dao = new NhanVienDAO();
        NhanVienDTO nv = dao.getNhanVien(Ma);
        return nv;
    }

    public static void main(String[] args) {
        JLabel LabelDate = new JLabel();
        TrangChuBUS.getInstance().hienThi_NgayHienTai(LabelDate);
    }
}
