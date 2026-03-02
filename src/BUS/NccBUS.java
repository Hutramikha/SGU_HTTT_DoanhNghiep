package BUS;

import DAO.NccDAO;
import DTO.NhaCungCapDTO;
import Util.dialog;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class NccBUS {

    private NccDAO nccDAO;

    public NccBUS() {
        nccDAO = new NccDAO();
        NhaCungCapDTO nccDTO = new NhaCungCapDTO();
    }
    public List<NhaCungCapDTO> getlistncc(){
        List<NhaCungCapDTO> ncc = new ArrayList();
        ncc = nccDAO.getDanhSachNhaCungCap();
        return ncc;
    }
    public void loadDataToTable_NhaCungCap(JTable table) {
        List<NhaCungCapDTO> data = nccDAO.getDanhSachNhaCungCap();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data
        for (NhaCungCapDTO ncc : data) {
            model.addRow(new Object[] {
                    ncc.getMaNhaCungCap(),
                    ncc.getTenNhaCungCap(),
                    ncc.getDiaChiNhaCungCap(),
                    ncc.getSoDienThoaiNhaCungCap()
            });
        }
    }

    public void timKiem(JTable table, String tenNhaCungCap) {
        // Gọi phương thức tìm kiếm từ DAO
        List<NhaCungCapDTO> danhSachKQ = nccDAO.timKiemTheoTen(tenNhaCungCap);

        // Hiển thị kết quả tìm kiếm trên bảng
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa các dữ liệu cũ trong bảng

        // Thêm kết quả tìm kiếm vào bảng
        for (NhaCungCapDTO ncc : danhSachKQ) {
            model.addRow(new Object[] {
                    ncc.getMaNhaCungCap(),
                    ncc.getTenNhaCungCap(),
                    ncc.getDiaChiNhaCungCap(),
                    ncc.getSoDienThoaiNhaCungCap()
            });
        }
    }

    public NhaCungCapDTO getNcc (String mancc) {
        return nccDAO.getNhaCungCapByMa(mancc);
    }

    public String taomaNCC() {
        return nccDAO.taoMaNCC();
    }

    public void themNhaCungCap( String TenNCC, String Diachi, String sodt) {
        String manccNew = nccDAO.taoMaNCC();
        NhaCungCapDTO ncc = new NhaCungCapDTO(manccNew, TenNCC, Diachi, sodt, true);
        boolean isAdd = nccDAO.themNhaCungCap(ncc);
        if (isAdd) {
            JOptionPane.showMessageDialog(null, "thêm nhà cung cấp thành thông với mã nhà cung cấp là : "+manccNew);
        } else {
            JOptionPane.showMessageDialog(null,
                    "lỗi thêm nhà cung cấp, vui lòng kiểm tra thông tin",
                    "Lỗi",
                    dialog.ERROR_DIALOG);
            return;
        }
    }

    // Phương thức sửa thông tin nhà cung cấp
    public boolean capNhatNhaCungCap(String maNCC, String TenNCC, String Diachi, String sodt) {
        for(int i= 0;i<nccDAO.getDanhSachNhaCungCap().size();i++){
            if(nccDAO.getDanhSachNhaCungCap().get(i).getSoDienThoaiNhaCungCap().equals(sodt)){
                JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại");
                return false;
            }
        }
        NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, TenNCC, Diachi, sodt, true);
        boolean isUpdated = nccDAO.capNhat(ncc);
        if (isUpdated) {
            JOptionPane.showMessageDialog(null, "Cập nhật nhà cung cấp thành công!");
        }
        return true;
    }
    public static void main(){
        NhaCungCapDTO a = new NhaCungCapDTO();
        
    }
}
