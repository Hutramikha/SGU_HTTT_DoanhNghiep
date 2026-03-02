package BUS;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Util.InputValidator;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import Util.dialog;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

public class NhanVienBUS {

   private ArrayList<NhanVienDTO> listNV = null;
   private NhanVienDAO nvDAO = new NhanVienDAO();

   public NhanVienBUS() {
       docDanhSach();
   }

   public void docDanhSach() {
       listNV = nvDAO.getDanhSachNhanVien();
   }

   public ArrayList<NhanVienDTO> getlistNV() {
       if (listNV == null) {
           docDanhSach();
       }
       return listNV;
   }

   public NhanVienDTO getById(String maNV) {
       return nvDAO.getNhanVien(maNV);
   }

   public boolean themNhanVien(String ten, String gioitinh, String dienThoai,Date ngaysinh, String chucvu,String diachi,int luong, int trangThai) {
        ten = ten.trim();
        dienThoai = dienThoai.trim();
       
        NhanVienDTO nv = new NhanVienDTO();
        nv.setTenNhanVien(ten);
        nv.setGioiTinhNhanVien(gioitinh);
        nv.setSoDienThoaiNhanVien(dienThoai);
        nv.setNgaySinhNhanVien(ngaysinh);
        nv.setChucVuNhanVien(chucvu);
        nv.setDiaChi(diachi);
        nv.setLuongNhanVien(luong);
        nv.setTrangThaiNhanVien(trangThai);

        boolean flag = nvDAO.themNhanVien(nv);
        if (flag) {
            new dialog("Thêm thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Thêm thất bại!", dialog.ERROR_DIALOG);
        }
        return flag;
   }

    public boolean checkExistAdmin(){
        for (NhanVienDTO nv : listNV) {
            if (nv.getChucVuNhanVien().equals("Quản Trị Viên") ) {
                return true;
            }
        }
        return false;
    }

    public boolean updateNhanVien(String ma,String ten, String gioitinh, String dienThoai,Date ngaysinh, String chucvu,String diachi,int luong, int trangThai) {
        ten = ten.trim();
        dienThoai = dienThoai.trim();
        if (ten.equals("")) {
           new dialog("Tên không được để trống!", dialog.ERROR_DIALOG);
           return false;
        }
        if (dienThoai.equals("")) {
           new dialog("Điện thoại không được để trống!", dialog.ERROR_DIALOG);
           return false;
         }
        NhanVienDTO nv = new NhanVienDTO();
        nv.setTenNhanVien(ten);
        nv.setGioiTinhNhanVien(gioitinh);
        nv.setSoDienThoaiNhanVien(dienThoai);
        nv.setNgaySinhNhanVien(ngaysinh);
        nv.setChucVuNhanVien(chucvu);
        nv.setDiaChi(diachi);
        nv.setLuongNhanVien(luong);
        System.out.println(luong);
        System.out.println(ma);
        nv.setTrangThaiNhanVien(trangThai);
        boolean flag = nvDAO.updateInfoNhanVien(nv,ma);
        if (flag) {
            new dialog("Cập nhập thất bại!", dialog.ERROR_DIALOG);
        } else {
            new dialog("Cập nhập thành công!", dialog.SUCCESS_DIALOG);
        }
        return flag;
   }

   public void timNhanVienMa(String tuKhoa,JTable tbl) {
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã NV", "Tên NV", "Giới tính", "SĐT", "Ngày sinh", "Chức vụ", "Địa chỉ", "Lương", "Trạng thái"
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
       ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
       for (NhanVienDTO nv : listNV) {
           if (nv.getMaNhanVien().toLowerCase().contains(tuKhoa) ) {
               dsnv.add(nv);
           }
       }

       for (NhanVienDTO nv : dsnv) {
        Vector<Object> vec = new Vector<>();
        vec.add(nv.getMaNhanVien());
        vec.add(nv.getTenNhanVien());
        vec.add(nv.getGioiTinhNhanVien());
        vec.add(nv.getSoDienThoaiNhanVien());
        vec.add(nv.getNgaySinhNhanVien());
        vec.add(nv.getChucVuNhanVien());
        vec.add(nv.getDiaChi());
        vec.add(nv.getLuongNhanVien());
        // vec.add(nv.getTrangThaiNhanVien());

        int trangThai = nv.getTrangThaiNhanVien();
        if (trangThai == 1) {
            vec.add("Hoạt động");
        }
        if (trangThai == 0) {
            vec.add("Nghỉ việc");
        } else {
            vec.add("Chưa có");
        }
        model.addRow(vec);
    }
   }

   public void timNhanVienTheoTen(String tuKhoa,JTable tbl) {
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã NV", "Tên NV", "Giới tính", "SĐT", "Ngày sinh", "Chức vụ", "Địa chỉ", "Lương", "Trạng thái"
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
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nv : listNV) {
            if (nv.getTenNhanVien().toLowerCase().contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        for (NhanVienDTO nv : dsnv) {
            Vector<Object> vec = new Vector<>();
            vec.add(nv.getMaNhanVien());
            vec.add(nv.getTenNhanVien());
            vec.add(nv.getGioiTinhNhanVien());
            vec.add(nv.getSoDienThoaiNhanVien());
            vec.add(nv.getNgaySinhNhanVien());
            vec.add(nv.getChucVuNhanVien());
            vec.add(nv.getDiaChi());
            vec.add(nv.getLuongNhanVien());

            int trangThai = nv.getTrangThaiNhanVien();
            if (trangThai == 1) {
                vec.add("Hoạt động");
            }
            if (trangThai == 0) {
                vec.add("Nghỉ việc");
            } else {
                vec.add("Chưa có");
            }
            model.addRow(vec);
        }
    }

   public boolean xoaNhanVien(String ma) {
       try {
           dialog dlg = new dialog("Bạn có chắc chắn muốn xoá không?", dialog.WARNING_DIALOG);
           boolean flag = false;
           if (dlg.getAction() == dialog.OK_OPTION) {
               flag = nvDAO.deleteNhanVien(ma);
               if (flag) {
                   new dialog("Xoá thành công!", dialog.SUCCESS_DIALOG);
               } else {
                   new dialog("Xoá thất bại!", dialog.ERROR_DIALOG);
               }
           }
           return flag;
       } catch (Exception e) {
           new dialog("Bạn chưa chọn nhân viên!", dialog.ERROR_DIALOG);
       }
       return false;
   }

   public boolean xoaFKHoadon_PhieuNhap_NV() {
       nvDAO.deletaFKHoandon_PhieuNhap();
       boolean ketqua = nvDAO.deletaFKHoandon_PhieuNhap();
       return ketqua;
   }

   public boolean updateFKHoadon_PhieuNhap_NV() {
       nvDAO.updateFKHoandon_PhieuNhap();
       boolean ketqua = nvDAO.updateFKHoandon_PhieuNhap();
       return ketqua;
   }

   public boolean xoaAllNhanVien() {
       nvDAO.xoaAllInfor();
       boolean ketqua = nvDAO.xoaAllInfor();
       return ketqua;
   }
   
   //Hàm nhập excel 
   public boolean nhapExcel(String ma,String ten, String gioitinh, String dienThoai,Date NgaySinh, String chucvu,String diachi,int luong, int trangThai) {
       NhanVienDTO nv = new NhanVienDTO();
       nv.setMaNhanVien(ma);
       nv.setTenNhanVien(ten);
       nv.setGioiTinhNhanVien(gioitinh);
       nv.setSoDienThoaiNhanVien(dienThoai);
       nv.setNgaySinhNhanVien(NgaySinh);
       nv.setChucVuNhanVien(chucvu);
       nv.setDiaChi(diachi);
       nv.setLuongNhanVien(luong);
       nv.setTrangThaiNhanVien(trangThai);;
       boolean flag = nvDAO.importNhanVienFromExcel(nv);
       return flag;
   }
    
    public void loadDataTblNhanVien(JTable tbl){
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã NV", "Tên NV", "Giới tính", "SĐT", "Ngày sinh", "Chức vụ", "Địa chỉ", "Lương", "Trạng thái"
            }, 
            0 
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl.setModel(model);
        docDanhSach();
        ArrayList<NhanVienDTO> dsnv = getlistNV();

        for (NhanVienDTO nv : dsnv) {
            Vector<Object> vec = new Vector<>();
            vec.add(nv.getMaNhanVien());
            vec.add(nv.getTenNhanVien());
            vec.add(nv.getGioiTinhNhanVien());
            vec.add(nv.getSoDienThoaiNhanVien());
            vec.add(convertSqlDateToString(nv.getNgaySinhNhanVien()));
            vec.add(nv.getChucVuNhanVien());
            vec.add(nv.getDiaChi());
            vec.add(formatCurrency(nv.getLuongNhanVien()));
           

            int trangThai = nv.getTrangThaiNhanVien();
            if (trangThai == 1) {
                vec.add("Hoạt động");
            }
            if (trangThai == 0) {
                vec.add("Nghỉ việc");
            } else {
                vec.add("Chưa có");
            }
            model.addRow(vec);
        }
    }

    public String convertSqlDateToString(Date sqlDate) {
        if (sqlDate == null) {
            return null; 
        }

        
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());

        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(utilDate);
    }

    public String LayQuyenTheoMa(String manv){
        NhanVienDTO nv = new NhanVienDTO();
        nv = nvDAO.getNhanVien(manv);
        return nv.getChucVuNhanVien();
    }

   public void CapNhatChucVu(NhanVienDTO nv) {
       if (!nvDAO.capNhatChucVu(nv)) {
           new dialog("Cập nhật chức vụ thất bại", dialog.ERROR_DIALOG);
       }
   }

   public String layMaNhanVien(String manv){
        return nvDAO.layMaNhanVien(manv);
   }

   public String formatCurrency(int amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        
        String formatted = formatter.format(amount);
        return formatted + "VNĐ";
    }

    public boolean checkSDT(String sdt){
        for (NhanVienDTO nv : listNV) {
            if (nv.getSoDienThoaiNhanVien().equals(sdt) ) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSDTBanThan(String sdt, String manv){
        NhanVienDTO nv = nvDAO.getNhanVien(manv);
        for (NhanVienDTO nv1 : listNV) {
            if (nv1.getSoDienThoaiNhanVien().equals(sdt) && !(nv.getSoDienThoaiNhanVien().equals(sdt))) {
                return false;
            }
        }
        return true;
    }

       public String getChucVuNhanVienTheoMa(String ma){
        return nvDAO.getChucVuTheoMa(ma);
    }

}
