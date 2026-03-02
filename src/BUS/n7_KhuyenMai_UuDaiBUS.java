package BUS;

import DAO.n7_KhuyenMaiDAO;
import DAO.n7_UuDaiThanhVienDAO;
import DTO.*;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

public class n7_KhuyenMai_UuDaiBUS {

    public static n7_KhuyenMai_UuDaiBUS getInstance() {
        return new n7_KhuyenMai_UuDaiBUS();
    }

    public void search_KM(JTable table, String ma, String ten, Date ngayBD, Date ngayKT, Float phanTram, int DieuKien) {
        KhuyenMaiDTO dto_search = new KhuyenMaiDTO(ma, ten, ngayBD, ngayKT, phanTram, DieuKien);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<KhuyenMaiDTO> ds = n7_KhuyenMaiDAO.getInstance().search(dto_search);
        int i = 1;
        for (KhuyenMaiDTO dto : ds) {
            model.addRow(new Object[]{dto.getMaKhuyenMai(), dto.getTenKhuyenMai(), yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayBatDauKhuyenMai()),
                yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayKetThucKhuyenMai()),
                setFoatToInt(dto.getPhanTramKhuyenMai()), set_Tien_VND(dto.getDieuKienKhuyenMai()), checkHan(dto.getNgayBatDauKhuyenMai(), dto.getNgayKetThucKhuyenMai())
            });
            i++;
        }
        if (ds.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Rất tiếc, hiện tại không tìm thấy chương trình khuyến mãi phù hợp! \nVui lòng kiểm tra lại thông tin.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void getListKhuyenMai(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<KhuyenMaiDTO> ds = n7_KhuyenMaiDAO.getInstance().getListKhuyenMai();
        int i = 1;
        for (KhuyenMaiDTO dto : ds) {
            model.addRow(new Object[]{dto.getMaKhuyenMai(), dto.getTenKhuyenMai(), yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayBatDauKhuyenMai()),
                yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayKetThucKhuyenMai()),
                setFoatToInt(dto.getPhanTramKhuyenMai()), set_Tien_VND(dto.getDieuKienKhuyenMai()), checkHan(dto.getNgayBatDauKhuyenMai(), dto.getNgayKetThucKhuyenMai())
            });
            i++;
        }
    }

    public void getListKhuyenMai_theoTen(JTable table, String ten) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<KhuyenMaiDTO> ds = n7_KhuyenMaiDAO.getInstance().getListKhuyenMai_theoTen(ten);
        int i = 1;
        for (KhuyenMaiDTO dto : ds) {
            model.addRow(new Object[]{dto.getMaKhuyenMai(), dto.getTenKhuyenMai(), yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayBatDauKhuyenMai()),
                yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayKetThucKhuyenMai()),
                setFoatToInt(dto.getPhanTramKhuyenMai()), set_Tien_VND(dto.getDieuKienKhuyenMai()), checkHan(dto.getNgayBatDauKhuyenMai(), dto.getNgayKetThucKhuyenMai())
            });
            i++;
        }
        if (ds.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Rất tiếc, hiện tại không tìm thấy chương trình khuyến mãi phù hợp! \nVui lòng kiểm tra lại thông tin.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void getListKhuyenMai_theoMa(JTable table, String ten) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<KhuyenMaiDTO> ds = n7_KhuyenMaiDAO.getInstance().getListKhuyenMai_theoMa(ten);
        int i = 1;
        for (KhuyenMaiDTO dto : ds) {
            model.addRow(new Object[]{dto.getMaKhuyenMai(), dto.getTenKhuyenMai(), yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayBatDauKhuyenMai()),
                yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayKetThucKhuyenMai()),
                setFoatToInt(dto.getPhanTramKhuyenMai()), set_Tien_VND(dto.getDieuKienKhuyenMai()), checkHan(dto.getNgayBatDauKhuyenMai(), dto.getNgayKetThucKhuyenMai())
            });
            i++;
        }
        if (ds.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Rất tiếc, hiện tại không tìm thấy chương trình khuyến mãi phù hợp! \nVui lòng kiểm tra lại thông tin.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public String taoMaKhuyenMai() {
        return n7_KhuyenMaiDAO.getInstance().taoMaKhuyenMai();
    }

    public boolean insert_khuyenMai(String ma, String ten, Date ngayBD, Date ngayKT, Float phanTram, int DieuKien) {
        KhuyenMaiDTO dto = new KhuyenMaiDTO(ma, ten, ngayBD, ngayKT, phanTram, DieuKien);
        boolean dao = n7_KhuyenMaiDAO.getInstance().insert_khuyenMai(dto);
        if (dao) {
            JOptionPane.showMessageDialog(null, "Khuyến mãi đã được tạo thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Mã Khuyến mãi đã tồn tại.\n Để tạo mã khuyến mãi mới, vui lòng tải lại trang!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public int update_khuyenMai(String ma, String ten, Date ngayBD, Date ngayKT, Float phanTram, int DieuKien) {
        KhuyenMaiDTO dto = new KhuyenMaiDTO(ma, ten, ngayBD, ngayKT, phanTram, DieuKien);
        int dao = n7_KhuyenMaiDAO.getInstance().update_khuyenMai(dto);

        switch (dao) {
            case 1:
                JOptionPane.showMessageDialog(null,
                        "Cập nhật thông tin khuyến mãi thành công!\n Cảm ơn bạn đã sử dụng hệ thống.",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 0:
                JOptionPane.showMessageDialog(null,
                        "Không thể cập nhật thông tin khuyến mãi.\n Vui lòng kiểm tra lại thông tin.",
                        "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Thông tin khuyến mãi không có thay đổi nào mới.\n Vui lòng kiểm tra lại dữ liệu đã nhập!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                break;
        }
        return dao;
    }

    public void getListUuDai(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<UuDaiThanhVienDTO> ds = n7_UuDaiThanhVienDAO.getInstance().getListUuDai();
        int i = 1;
        for (UuDaiThanhVienDTO dto : ds) {
            model.addRow(new Object[]{dto.getMaUuDai(), dto.getTenUuDai(), yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayBatDauUuDai()),
                yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayKetThucUuDai()),
                setFoatToInt(dto.getPhanTramUuDai()), set_Tien_VND(dto.getDieuKienUuDai()), checkHan(dto.getNgayBatDauUuDai(), dto.getNgayKetThucUuDai())
            });
            i++;
        }
    }

    public int setFoatToInt(Float phantram) {
        return Math.round(phantram);
    }

    public void getListUuDai_theoTen(JTable table, String ten) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<UuDaiThanhVienDTO> ds = n7_UuDaiThanhVienDAO.getInstance().getListUuDai_theoTen(ten);
        int i = 1;
        for (UuDaiThanhVienDTO dto : ds) {
            model.addRow(new Object[]{dto.getMaUuDai(), dto.getTenUuDai(), yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayBatDauUuDai()),
                yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayKetThucUuDai()),
                setFoatToInt(dto.getPhanTramUuDai()), set_Tien_VND(dto.getDieuKienUuDai()), checkHan(dto.getNgayBatDauUuDai(), dto.getNgayKetThucUuDai())
            });
            i++;
        }
        if (ds.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Rất tiếc, hiện tại không tìm thấy chương trình ưu đãi thành viên phù hợp! \nVui lòng kiểm tra lại thông tin.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void getListUuDai_theoMa(JTable table, String ten) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<UuDaiThanhVienDTO> ds = n7_UuDaiThanhVienDAO.getInstance().getListUuDai_theoMa(ten);
        int i = 1;
        for (UuDaiThanhVienDTO dto : ds) {
            model.addRow(new Object[]{dto.getMaUuDai(), dto.getTenUuDai(), yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayBatDauUuDai()),
                yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayKetThucUuDai()),
                setFoatToInt(dto.getPhanTramUuDai()), set_Tien_VND(dto.getDieuKienUuDai()), checkHan(dto.getNgayBatDauUuDai(), dto.getNgayKetThucUuDai())
            });
            i++;
        }
        if (ds.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Rất tiếc, hiện tại không tìm thấy chương trình ưu đãi thành viên phù hợp! \nVui lòng kiểm tra lại thông tin.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public String taoMaUuDai() {
        return n7_UuDaiThanhVienDAO.getInstance().taoMaUuDai();
    }

    public boolean insert_uuDai(String ma, String ten, Date ngayBD, Date ngayKT, Float phanTram, int DieuKien) {
        UuDaiThanhVienDTO dto = new UuDaiThanhVienDTO(ma, ten, ngayBD, ngayKT, phanTram, DieuKien);
        boolean dao = n7_UuDaiThanhVienDAO.getInstance().insert_uuDai(dto);
        if (dao) {
            JOptionPane.showMessageDialog(null, "Ưu đãi thành viên đã được tạo thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Mã ưu đãi thành viên đã tồn tại.\n Để tạo mã ưu đãi mới, vui lòng tải lại trang!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public int update_uuDai(String ma, String ten, Date ngayBD, Date ngayKT, Float phanTram, int DieuKien) {
        UuDaiThanhVienDTO dto = new UuDaiThanhVienDTO(ma, ten, ngayBD, ngayKT, phanTram, DieuKien);
        int dao = n7_UuDaiThanhVienDAO.getInstance().update_uuDai(dto);
        switch (dao) {
            case 1:
                JOptionPane.showMessageDialog(null,
                        "Cập nhật thông tin ưu đãi thành viên thành công!\n Cảm ơn bạn đã sử dụng hệ thống.",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 0:
                JOptionPane.showMessageDialog(null,
                        "Không thể cập nhật thông tin ưu đãi thành viên.\n Vui lòng kiểm tra lại thông tin.",
                        "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Thông tin ưu đãi thành viên không có thay đổi nào mới.\n Vui lòng kiểm tra lại dữ liệu đã nhập!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                break;
        }
        return dao;
    }

    public void search(JTable table, String ma, String ten, Date ngayBD, Date ngayKT, Float phanTram, int DieuKien) {
        UuDaiThanhVienDTO dto_search = new UuDaiThanhVienDTO(ma, ten, ngayBD, ngayKT, phanTram, DieuKien);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<UuDaiThanhVienDTO> ds = n7_UuDaiThanhVienDAO.getInstance().search(dto_search);
        int i = 1;
        for (UuDaiThanhVienDTO dto : ds) {
            model.addRow(new Object[]{dto.getMaUuDai(), dto.getTenUuDai(), yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayBatDauUuDai()),
                yyyy_mm_dd__to__dd_mm_yyyy(dto.getNgayKetThucUuDai()),
                setFoatToInt(dto.getPhanTramUuDai()), set_Tien_VND(dto.getDieuKienUuDai()), checkHan(dto.getNgayBatDauUuDai(), dto.getNgayKetThucUuDai())
            });
            i++;
        }
        if (ds.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Rất tiếc, hiện tại không tìm thấy chương trình ưu đãi thành viên phù hợp! \nVui lòng kiểm tra lại thông tin.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private String checkHan(Date start, Date end) {
        String thongTin = "Ngưng";

        if (start == null || end == null) {
            return thongTin; // Nếu start hoặc end null, trả về "Ngừng"
        }

        // Đặt giờ phút giây về 0 để chỉ so sánh ngày
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date currentDate = calendar.getTime();

        // Kiểm tra ngày hiện tại có nằm trong khoảng start và end
        if (!currentDate.before(start) && !currentDate.after(end)) {
            thongTin = "Áp dụng";
        }

        return thongTin;
    }

    public String yyyy_mm_dd__to__dd_mm_yyyy(Date ngayBanDau) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String ngayLucSau = dateFormat.format(ngayBanDau);

        return ngayLucSau;
    }

    // Chuyển từ dd-MM-yyyy (String) sang yyyy-MM-dd (Date)
    public Date dd_mm_yyyy__to__yyyy_mm_dd(String ngayBanDau) {
        Date ngayLucSau = null;
        SimpleDateFormat sdfInput = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date intermediateDate = sdfInput.parse(ngayBanDau);
            String formattedDate = sdfOutput.format(intermediateDate);
            ngayLucSau = sdfOutput.parse(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ngayLucSau;
    }

    public String set_Tien_VND(long gia) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(gia);
    }

    public int set_Tien_VND_sang_int(String gia) {
        System.out.println(gia);
        try {
            gia = gia.replaceAll("[^\\d]", "");
            return Integer.parseInt(gia);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0; // Trả về 0 nếu có lỗi
        }
    }

    public boolean check_input_Rong(JTextField ma, JTextField ten, JDateChooser bd, JDateChooser kt, JTextField phanTram, JTextField dieuKien) {
        boolean check = true;

        // Kiểm tra tên
        if (ten.getText().equals("") && check) {
            ten.requestFocus();
            JOptionPane.showMessageDialog(null, "Tên ưu đãi không được bỏ trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            check = false;
        }

        // Kiểm tra ngày bắt đầu
        if (bd.getDate() == null && check) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu áp dụng chương trình!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            check = false;
        }

        // Kiểm tra ngày kết thúc
        if (kt.getDate() == null && check) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày kết thúc áp dụng chương trình!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            check = false;
        }

        // Kiểm tra ngày kết thúc lớn hơn ngày bắt đầu
        if (kt.getDate().before(bd.getDate()) && check) {
            JOptionPane.showMessageDialog(null, "Ngày kết thúc phải lớn hơn ngày bắt đầu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            check = false;
        }

        // Kiểm tra phần trăm giảm giá
        if (phanTram.getText().equals("") && check) {
            phanTram.requestFocus();
            JOptionPane.showMessageDialog(null, "Phần trăm giảm giá không được bỏ trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            check = false;
        }
        
        if (Integer.parseInt(phanTram.getText()) < 0 && check) {
            phanTram.requestFocus();
            JOptionPane.showMessageDialog(null, "Phần trăm giảm giá phải lớn hơn 0%!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            check = false;
        }

        if (!isNumeric(phanTram.getText()) && check) {
            phanTram.requestFocus();
            phanTram.setText("");
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ cho phần trăm giảm giá!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            check = false;
        }

        // Kiểm tra điều kiện áp mã
        if (dieuKien.getText().equals("") && check) {
            dieuKien.requestFocus();
            JOptionPane.showMessageDialog(null, "Điều kiện áp mã không được bỏ trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            check = false;
        }

        if (!isNumeric(dieuKien.getText()) && check) {
            dieuKien.requestFocus();
            dieuKien.setText("");
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ cho điều kiện áp mã!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            check = false;
        }

        return check;
    }

    private boolean isNumeric(String str) {
        str = str.replaceAll("[^\\d]", "");
        if (str == null || str.isEmpty()) {
            return false; // Không hợp lệ nếu null hoặc rỗng
        }
        try {
            Double.parseDouble(str); // Kiểm tra chuyển đổi được sang số không
            return true;
        } catch (NumberFormatException e) {
            return false; // Không phải số
        }
    }
}
