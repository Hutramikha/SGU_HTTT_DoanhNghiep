package BUS;

import Util.dialog;
import DAO.n1_CTHoaDonDAO;
import DAO.n4_MonDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.MonDTO;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CTHoaDonBUS {

    n1_CTHoaDonDAO CTHD = new n1_CTHoaDonDAO();

    public ArrayList<ChiTietHoaDonDTO> getlistCTHD() {
        return CTHD.getListCTHD();
    }

    public boolean Insert(ChiTietHoaDonDTO cTHoaDon) {
        if (!CTHD.addCTHoaDon(cTHoaDon)) {
            new dialog("Lỗi thêm chi tiết hóa đơn!", dialog.ERROR_DIALOG);
            return false;
        }
        return true;
    }

    public void HienThiChiTietHoaDon(JTable tble, String MHD ){
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền"
            }, 
            0 // Bắt đầu với 0 hàng
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa ô
            }
        };
        
        tble.setModel(model);
        ArrayList<ChiTietHoaDonDTO> listCTHD = new ArrayList<>();
        listCTHD = getlistCTHD();
        n4_MonDAO mon = new n4_MonDAO();
        for (int i = 0; i < listCTHD.size(); i++) {
            if (listCTHD.get(i).getMaHoaDon().equals(MHD)) {
                System.out.println(listCTHD.get(i).getMaMon());
                Object[] data = {listCTHD.get(i).getMaMon(), mon.getMonById(listCTHD.get(i).getMaMon()).getTenMon(), listCTHD.get(i).getDonGia(), listCTHD.get(i).getSoLuong(), listCTHD.get(i).getThanhTien()};
                model.addRow(data);
            }
        }
    }
}
