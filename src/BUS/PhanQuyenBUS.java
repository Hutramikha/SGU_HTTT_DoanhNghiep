package BUS;

import Util.dialog;
import DAO.PhanQuyenDAO;
import DTO.NhanVienDTO;
import DTO.PhanQuyenDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PhanQuyenBUS {

   public static PhanQuyenDTO currentQuyen = null;
   private ArrayList<PhanQuyenDTO> listPQ = null;
   private PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();

   public PhanQuyenBUS() {}

   public void docDanhSachQuyen(){
        listPQ = phanQuyenDAO.selectAll();
   }



   public ArrayList<PhanQuyenDTO> getListPhanQuyen(){
        docDanhSachQuyen();
        return listPQ;
   }

   public ArrayList<String> getListTenPhanQuyen(){
    ArrayList<PhanQuyenDTO> danhSachQuyen = phanQuyenDAO.selectAll();
        ArrayList<String> dsQuyen = new ArrayList<>();
        for(int i=0;i<danhSachQuyen.size();i++){
            dsQuyen.add(danhSachQuyen.get(i).getTenQuyen());
        }
        return dsQuyen;
}

   private boolean checkDuplicateName(String tenQuyen) {
       ArrayList<PhanQuyenDTO> phanQuyens = phanQuyenDAO.selectAll();
       for (PhanQuyenDTO phanQuyen : phanQuyens) {
           if (phanQuyen.getTenQuyen().equals(tenQuyen.strip())) {
               new dialog("Tên quyền đã tồn tại", dialog.ERROR_DIALOG);
               return true;
           }
       }
       return false;
   }

   public String layMaTheoTenQuyen(String tenQuyen){
        return phanQuyenDAO.getIdByName(tenQuyen);
   }

   public boolean Insert(String tenQuyen) {
       if (checkDuplicateName(tenQuyen)) {
           return false;
       }
       String maQuyen = getNextMaQuyen();
       if (phanQuyenDAO.insert(new PhanQuyenDTO(maQuyen, tenQuyen, false, false, false, false, false, false, false, false, false, false, true)) == 0) {
           new dialog("Không thể thêm quyền", dialog.ERROR_DIALOG);
           return false;
       }
       new dialog("Thêm quyền thành công", dialog.SUCCESS_DIALOG);
       return true;
   }

   public boolean Update(PhanQuyenDTO t) {
       if (phanQuyenDAO.update(t) == 0) {
           new dialog("Không thể sửa quyền", dialog.ERROR_DIALOG);
           return false;
       }
       new dialog("Sửa quyền thành công", dialog.SUCCESS_DIALOG);
       return true;
   }

   public boolean Delete(String ma) {
       if (phanQuyenDAO.delete(ma) == 0) {
           new dialog("Không thể xóa", dialog.ERROR_DIALOG);
           return false;
       }
       new dialog("Xóa thành công", dialog.SUCCESS_DIALOG);
       return true;
   }

   public PhanQuyenDTO getById(String ma) {
       return phanQuyenDAO.selectById(new PhanQuyenDTO(ma, null, false, false, false, false, false, false, false, false, false, false, false));
   }

   public ArrayList<PhanQuyenDTO> getList() {
       return phanQuyenDAO.selectAll();
   }

//    public void UpdateCurrentQuyen() {
//        if (DNBUS.taiKhoanLogin == null) {
//            return;
//        }
//        String maQuyen = DangNhapBUS.taiKhoanLogin.getMaQuyen();
//        PhanQuyenDTO phanQuyentmp = new PhanQuyenDTO();
//        phanQuyentmp.setMaPhanQuyen(maQuyen);
//        currentQuyen = phanQuyenDAO.selectById(phanQuyentmp);
//    }

   private String getNextMaQuyen() {
       return phanQuyenDAO.LayMaPhanQuyenCuoiCung();
   }

   public void loadData(JTable table){
        DefaultTableModel model = new DefaultTableModel(
                new String[] {
                    "Mã", "Tên","Khách Hàng","Bán Hàng", "Nhập Hàng", "Món", "Nguyên Liệu", "Lịch Làm", "Khuyến Mãi", "NCC","Nhân Viên", "Thống Kê"
                }, 
                0 // Bắt đầu với 0 hàng
            ){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Không cho phép chỉnh sửa ô
                }
            };
            table.setModel(model);
            // getListPhanQuyen();
            ArrayList<PhanQuyenDTO> dsq= getListPhanQuyen();

            for (PhanQuyenDTO quyen : dsq) {
                Vector<Object> vec = new Vector<>();
                vec.add(quyen.getMaPhanQuyen());
                vec.add(quyen.getTenQuyen());
                vec.add(quyen.getQuyenKhachHang());
                vec.add(quyen.getQuyenBanHang());
                vec.add(quyen.getQuyenNhapHang());
                vec.add(quyen.getQuyenMon());
                vec.add(quyen.getQuyenNguyenLieu());
                vec.add(quyen.getQuyenLichLam());
                vec.add(quyen.getQuyenKhuyenMaiUuDai());
                vec.add(quyen.getQuyenNhaCungCap());
                vec.add(quyen.getQuyenNhanVien());
                vec.add(quyen.getQuyenThongKe());
                model.addRow(vec);
            }
   }

   public void loadChecbox(ArrayList<JCheckBox> listckb, String tenQuyen){
        for (JCheckBox checkBox : listckb) {
            checkBox.setSelected(false);
        }
        PhanQuyenDTO phanQuyen = phanQuyenDAO.selectByName(tenQuyen);
        if (phanQuyen == null) {
            new dialog("Không tìm thấy quyền", dialog.ERROR_DIALOG);
            return;
        }
        if (phanQuyen.getQuyenKhachHang() == true) {
            listckb.get(0).setSelected(true);
        }
        if (phanQuyen.getQuyenBanHang() == true) {
            listckb.get(1).setSelected(true);
        }
        if (phanQuyen.getQuyenNhapHang() == true) {
            listckb.get(2).setSelected(true);
        }
        if (phanQuyen.getQuyenMon() == true) {
            listckb.get(3).setSelected(true);
        }
        if (phanQuyen.getQuyenNguyenLieu() == true) {
            listckb.get(4).setSelected(true);
        }
        if (phanQuyen.getQuyenLichLam() == true) {
            listckb.get(5).setSelected(true);
        }
        if (phanQuyen.getQuyenKhuyenMaiUuDai() == true) {
            listckb.get(6).setSelected(true);
        }
        if (phanQuyen.getQuyenNhaCungCap() == true) {
            listckb.get(7).setSelected(true);
        }
        if (phanQuyen.getQuyenNhanVien() == true) {
            listckb.get(8).setSelected(true);
        }
        if (phanQuyen.getQuyenThongKe() == true) {
            listckb.get(9).setSelected(true);
        }
   }
}

