package BUS;

import Util.dialog;
import DAO.n1_CTHoaDonDAO;
import DAO.n4_MonDAO;
import DAO.n1_HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.n7_KhuyenMaiDAO;
import DAO.n7_UuDaiThanhVienDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.MonDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import DTO.UuDaiThanhVienDTO;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CTHoaDonBUS {

    n1_CTHoaDonDAO CTHD = new n1_CTHoaDonDAO();
    private n1_HoaDonDAO HDDAO = new n1_HoaDonDAO();
    private KhachHangDAO KHDAO = new KhachHangDAO();
    private n7_KhuyenMaiDAO KMDAO = new n7_KhuyenMaiDAO();
    private n7_UuDaiThanhVienDAO UDTVDAO = new n7_UuDaiThanhVienDAO();

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

    // ✅ NEW: Get customer name by invoice ID through BUS layer
    public String getCustomerNameByInvoiceId(String MHD) {
        HoaDonDTO invoice = HDDAO.getHoaDonTheoMHD(MHD);
        if (invoice == null || invoice.getMaKhachHang() == null) {
            return "";
        }
        KhachHangDTO customer = KHDAO.getKhachHangByMaKH(invoice.getMaKhachHang());
        return customer != null ? customer.getTenKhachHang() : "";
    }

    // ✅ NEW: Get promotion name by invoice ID through BUS layer
    public String getPromotionNameByInvoiceId(String MHD) {
        HoaDonDTO invoice = HDDAO.getHoaDonTheoMHD(MHD);
        if (invoice == null || invoice.getMaKhuyenMai() == null) {
            return "";
        }
        KhuyenMaiDTO promotion = KMDAO.getKhuyenMaiById(invoice.getMaKhuyenMai());
        return promotion != null ? promotion.getTenKhuyenMai() : "";
    }

    // ✅ NEW: Get benefit name by invoice ID through BUS layer
    public String getBenefitNameByInvoiceId(String MHD) {
        HoaDonDTO invoice = HDDAO.getHoaDonTheoMHD(MHD);
        if (invoice == null || invoice.getMaUuDai() == null) {
            return "";
        }
        UuDaiThanhVienDTO benefit = UDTVDAO.getUuDaiById(invoice.getMaUuDai());
        return benefit != null ? benefit.getTenUuDai() : "";
    }

    // ✅ NEW: Get total invoice amount by invoice ID through BUS layer
    public String getTotalAmountByInvoiceId(String MHD) {
        HoaDonDTO invoice = HDDAO.getHoaDonTheoMHD(MHD);
        return invoice != null ? String.valueOf(invoice.getTongTienHoaDon()) : "0";
    }

    public void HienThiChiTietHoaDon(JTable tble, String MHD) {
        DefaultTableModel model = new DefaultTableModel(
                new String[] {
                        "Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền"
                },
                0 // Bắt đầu với 0 hàng
        ) {
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
                Object[] data = { listCTHD.get(i).getMaMon(), mon.getMonById(listCTHD.get(i).getMaMon()).getTenMon(),
                        listCTHD.get(i).getDonGia(), listCTHD.get(i).getSoLuong(), listCTHD.get(i).getThanhTien() };
                model.addRow(data);
            }
        }
    }
}
