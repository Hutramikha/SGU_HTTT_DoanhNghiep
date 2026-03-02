package BUS;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import Util.dialog;

public class KhachHangBUS {
    private ArrayList<KhachHangDTO> listKH = null;
    private KhachHangDAO khDAO = new KhachHangDAO();

    public KhachHangBUS() {
       docDanhSach();
    }

    public void docDanhSach() {
       listKH = khDAO.getDanhSachKhachHang();
    }

    public ArrayList<KhachHangDTO> getlistKH() {
       if (listKH == null) {
           docDanhSach();
       }
       return listKH;
    }

    public KhachHangDTO getById(String maKH) {
       return khDAO.getKhachHangByMaKH(maKH);
    }

    public void timKhachHangTheoMa(String tuKhoa,JTable tbl) {
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã KH", "Tên KH", "Giới tính", "Số điện thoại", "Ngày sinh", "Tổng chi tiêu"
            }, 
            0 
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        tbl.setModel(model); 
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO kh : listKH) {
             if (kh.getMaKhachHang().toLowerCase().contains(tuKhoa) ) {
               dskh.add(kh);
            }
        }

       for (KhachHangDTO kh : dskh) {
            Vector<Object> vec = new Vector<>();
            vec.add(kh.getMaKhachHang());
            vec.add(kh.getTenKhachHang());
            vec.add(kh.getGioiTinhKhachHang());
            vec.add(kh.getSoDienThoaiKhachHang());
            vec.add(kh.getNgaySinhKhachHang());
            vec.add(kh.getChiTieuKhachHang());
            model.addRow(vec);
        }
   }

   public void timKhachHangTheoTen(String tuKhoa,JTable tbl) {
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã KH", "Tên KH", "Giới tính", "Số điện thoại", "Ngày sinh", "Tổng chi tiêu"
            }, 
            0 
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        tbl.setModel(model);
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHangDTO> dsKH = new ArrayList<>();
        for (KhachHangDTO KH : listKH) {
            if (KH.getTenKhachHang().toLowerCase().contains(tuKhoa)) {
                dsKH.add(KH);
            }
        }
        for (KhachHangDTO KH : dsKH) {
            Vector<Object> vec = new Vector<>();
            vec.add(KH.getMaKhachHang());
            vec.add(KH.getTenKhachHang());
            vec.add(KH.getGioiTinhKhachHang());
            vec.add(KH.getSoDienThoaiKhachHang());
            vec.add(KH.getNgaySinhKhachHang());
            vec.add(KH.getChiTieuKhachHang());
            model.addRow(vec);
        }
    }

    public boolean capNhatThongTinKhachHang(String ma, String ten, String dienThoai,String gioiTinh,Date ngaySinh, int tongCT){
        
        KhachHangDTO kh = new KhachHangDTO();
        kh.setMaKhachHang(ma);
        kh.setTenKhachHang(ten);
        kh.setGioiTinhKhachHang(gioiTinh);
        kh.setSoDienThoaiKhachHang(dienThoai);
        kh.setNgaySinhKhachHang(ngaySinh);
        kh.setChiTieuKhachHang(tongCT);
        boolean flag = khDAO.updateInfoKhachHang(kh);

        if (flag) {
            new dialog("Cập nhập thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Cập nhập thất bại!", dialog.ERROR_DIALOG);
        }
    return flag;
   }

   public boolean themKhachHang(String ten, Date ngaysinh, String gioitinh, String dienThoai, int chiTieu) {
        ten = ten.trim();
        dienThoai = dienThoai.trim();
        KhachHangDTO kh = new KhachHangDTO();
        kh.setTenKhachHang(ten);
        kh.setGioiTinhKhachHang(gioitinh);
        kh.setSoDienThoaiKhachHang(dienThoai);
        kh.setNgaySinhKhachHang(ngaysinh);
        kh.setChiTieuKhachHang(chiTieu);
        boolean flag = khDAO.themKhachHang(kh);
        if (flag) {
                new dialog("Thêm thành công!", dialog.SUCCESS_DIALOG);
        } else {
                new dialog("Thêm thất bại!", dialog.ERROR_DIALOG);
        }
        return flag;
   }

   public void loadDataTblNhanVien(JTable tbl){
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã KH", "Tên KH", "Giới tính", "Số điện thoại", "Ngày sinh",  "Tổng Chi tiêu"
            }, 
            0 
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa ô
            }
        };
        tbl.setModel(model);
        docDanhSach();
        ArrayList<KhachHangDTO> dsnv = getlistKH();

        for (KhachHangDTO nv : dsnv) {
            Vector<Object> vec = new Vector<>();
            vec.add(nv.getMaKhachHang());
            vec.add(nv.getTenKhachHang());
            vec.add(nv.getGioiTinhKhachHang());
            vec.add(nv.getSoDienThoaiKhachHang());
            vec.add(nv.getNgaySinhKhachHang());
            vec.add(formatCurrency(nv.getChiTieuKhachHang()));
            model.addRow(vec);
        }
    }

    public String formatCurrency(int amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        
        String formatted = formatter.format(amount);
        return formatted + "VNĐ";
    }

    public boolean checkSDT(String sdt){
        for (KhachHangDTO kh : listKH) {
            if (kh.getSoDienThoaiKhachHang().equals(sdt) ) {
                return false;
            }
        }
        return true;
       }

}
