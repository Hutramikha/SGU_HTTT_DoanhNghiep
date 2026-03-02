package BUS;

import DAO.n6_CaLamDAO;
import DTO.CaLamDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CaLamBUS {

    public static CaLamBUS getInstance() {
        return new CaLamBUS();
    }

    public String MaTuDong() {
        String ma = n6_CaLamDAO.getInstance().taoMaCaLam();
        return ma;
    }

    public Boolean insert(String MaCaLam, String TenCaLam, String ThoiGianVaoCaLam, String ThoiGianRaCaLam) {
        CaLamDTO ca_dto = new CaLamDTO(MaCaLam, TenCaLam, ThoiGianVaoCaLam, ThoiGianRaCaLam, true);
        Boolean ca_dao_insert = n6_CaLamDAO.getInstance().insert(ca_dto);
        if (ca_dao_insert) {
            JOptionPane.showMessageDialog(null, "Ca làm đã được tạo thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Mã ca làm đã tồn tại.\n Để tạo ca làm, vui lòng tải lại trang !", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public int update(String MaCaLam, String TenCaLam, String ThoiGianVaoCaLam, String ThoiGianRaCaLam) {
        CaLamDTO ca_dto = new CaLamDTO(MaCaLam, TenCaLam, ThoiGianVaoCaLam, ThoiGianRaCaLam, true);
        int ca_dao_update = n6_CaLamDAO.getInstance().update(ca_dto);
        if (ca_dao_update == 1) {
            JOptionPane.showMessageDialog(null,
                    "Cập nhật thông tin ca làm thành công! Cảm ơn bạn đã sử dụng hệ thống.",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else if (ca_dao_update == 0) {
            JOptionPane.showMessageDialog(null,
                    "Không thể cập nhật thông tin ca làm. Vui lòng kiểm tra lại thông tin.",
                    "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else if (ca_dao_update == 2) {
            JOptionPane.showMessageDialog(null, "Thông tin ca làm không có thay đổi nào mới. Vui lòng kiểm tra lại dữ liệu đã nhập!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return ca_dao_update;
    }

    public boolean delete(String MaCaLam) {
        Boolean ca_dao_delete = n6_CaLamDAO.getInstance().delete(MaCaLam);
        if (ca_dao_delete) {
            JOptionPane.showMessageDialog(null, "Ca làm đã được xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Không tồn tại mã ca làm!");
            return false;
        }
    }

    public void data(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<CaLamDTO> ds = n6_CaLamDAO.getInstance().showAll();
        int i = 1;
        for (CaLamDTO ca : ds) {
            model.addRow(new Object[]{i, ca.getMaCaLam(), ca.getTenCaLam(), Util.LichLam_CaLam.time_sql_sang_hhmm(ca.getThoiGianVaoCaLam()),
                Util.LichLam_CaLam.time_sql_sang_hhmm(ca.getThoiGianRaCaLam())
            });
            i++;
        }
    }

    public void TimKiem(JTable table, String MaCaLam, String TenCaLam, String ThoiGianVaoCaLam, String ThoiGianRaCaLam) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<CaLamDTO> ds = n6_CaLamDAO.getInstance().search(MaCaLam, TenCaLam, ThoiGianVaoCaLam, ThoiGianRaCaLam);
        int i = 1;
        for (CaLamDTO ca : ds) {
            model.addRow(new Object[]{i, ca.getMaCaLam(), ca.getTenCaLam(), Util.LichLam_CaLam.time_sql_sang_hhmm(ca.getThoiGianVaoCaLam()),
                Util.LichLam_CaLam.time_sql_sang_hhmm(ca.getThoiGianRaCaLam())
            });
            i++;
        }
        if (ds.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Rất tiếc, không tìm thấy ca làm phù hợp ! \nVui lòng kiểm tra lại thông tin.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public static void main(String args[]) {
        CaLamBUS ca_bus = CaLamBUS.getInstance();
        n6_CaLamDAO ca_dao = n6_CaLamDAO.getInstance();
        CaLamDTO ca_DTO = new CaLamDTO(ca_dao.taoMaCaLam(), "Ca D", "10:00", "14:00", true);
    }
}
