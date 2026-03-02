package BUS;

import Util.InputValidator;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import Util.dialog;

import java.sql.Date;
import java.time.LocalDate;

import DAO.NhanVienDAO;
import DAO.PhanQuyenDAO;

public class TaiKhoanBUS {

    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    private PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();
    private NhanVienDAO nvDAO = new NhanVienDAO();

    public String getTenDangNhapTheoMa(String ma) {
        System.out.println("tkbus");
        return taiKhoanDAO.layTenDangNhapTheoMa(ma);
    }

    public String getQuyenTheoMa(String ma) {
        return taiKhoanDAO.layQuyenTheoMa(ma);
    }

    public void datLaiMatKhau(String ma, String tenDangNhap) {
        boolean flag = taiKhoanDAO.datLaiMatKhau(ma, tenDangNhap);
        if (flag) {
            new dialog("Đặt lại thành công! Mật khẩu mới là: " + tenDangNhap, dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Đặt lại thất bại!", dialog.ERROR_DIALOG);
        }
    }

    public void datLaiQuyen(String ma, String quyen) {
        if (quyen.equals("")) {
            new dialog("Không tìm thấy quyền", dialog.ERROR_DIALOG);
            return;
        }
        boolean flag = taiKhoanDAO.datLaiQuyen(ma, quyen);
        if (flag) {
            new dialog("Đặt lại thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Đặt lại thất bại!", dialog.ERROR_DIALOG);
        }
    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        return taiKhoanDAO.kiemTraTrungTenDangNhap(tenDangNhap);
    }

    public TaiKhoanDTO getById(String maNV) {
        return taiKhoanDAO.selectById(maNV, 1);
    }

    public boolean hasAccount(String maNV) {
        TaiKhoanDTO taiKhoan = taiKhoanDAO.selectById(maNV, 0); // lấy tất cả tài khoản bao gồm tk đã bị khóa
        if (taiKhoan == null) {
            return false;
        }
        if (taiKhoan.getTrangThaiTaiKhoan() >=0 ) {
            new dialog("Nhân viên đã có tài khoản", dialog.ERROR_DIALOG);
            return true;
        }
       
        return true;
    }

    public static Date getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        return Date.valueOf(localDate);
    }

    // public boolean  updateNgayNghiViecTaiKhoan(String ma){
    //     Date currentDate = getCurrentDate();
    //     TaiKhoanDTO tk = new TaiKhoanDTO(null,"tenDangNhap","tenDangNhap", "maQuyen",ma,null,currentDate, 1);
    //     boolean flag = taiKhoanDAO.insert(tk);
    //     return flag;
    // }

    // public boolean  updateNgayMoKhoaTaiKhoan(String ma){
    //     TaiKhoanDTO tk = new TaiKhoanDTO(null,"tenDangNhap","tenDangNhap", "maQuyen",ma,null,null, 1);
    //     boolean flag = taiKhoanDAO.updateMoKhoaTK(tk);
    //     return flag;
    // }
    

    public boolean themTaiKhoan(String ma, String tenDangNhap, String tenQuyen) {
        // int maNV = Integer.parseInt(ma);
        if (tenDangNhap.trim().equals("")) {
            new dialog("Không được để trống Tên đăng nhập!", dialog.ERROR_DIALOG);
            return false;
        }
        if (!InputValidator.isValidPass(tenDangNhap.strip())) { // kiểm tra ký tự
            new dialog("Tên đăng nhập không được có ký tự đặc biệt", dialog.ERROR_DIALOG);
            return false;
        }
        // if (kiemTraTrungTenDangNhap(tenDangNhap)) {
        //     dialog dlg = new dialog("Tên đăng nhập bị trùng!\nCó thể tài khoản bị khoá,\nthực hiện mở khoá?", dialog.WARNING_DIALOG);
        //     if (dlg.getAction() == dialog.OK_OPTION) {
        //         moKhoaTaiKhoan(ma);
        //         return true;
        //     }
        //     return false;
        // }

        String maQuyen = phanQuyenDAO.getIdByName(tenQuyen); // tìm mã quyền bằng tên quyền
        if (maQuyen.equals("")) {
            new dialog("Không tìm thấy quyền", dialog.ERROR_DIALOG);
            return false;
        }

        if(ma.equals(taiKhoanDAO.getIdNV(ma))){
            if(taiKhoanDAO.getTrangThai(ma) == 0)
                new dialog("Tài khoản đang bị khóa,\nthực hiện mở khóa?", 0);
            else {
                new dialog("Tài khoản đã tồn tại không thể thực hiện thao tác thêm", dialog.ERROR_DIALOG);
                return false;
            }
        }
        
        Date currentDate = getCurrentDate();
        TaiKhoanDTO tk = new TaiKhoanDTO(null,tenDangNhap,tenDangNhap, maQuyen,ma,currentDate,null, 1);
        boolean flag = taiKhoanDAO.insert(tk);
        if (flag) {
            new dialog("Cấp tài khoản thành công! Mật khẩu là " + tenDangNhap, dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Cấp tài khoản thất bại!", dialog.ERROR_DIALOG);
        }
        return flag;
    }

    public void khoaTaiKhoan(String ma) {
        // int maNV = Integer.parseInt(ma);
        String manv = ma.trim();
        int ttNV = nvDAO.getTrangThai(manv);
        if (ttNV==0) {
            boolean flag3 = taiKhoanDAO.moKhoaTaiKhoan(manv);
            boolean flag4 = nvDAO.moKhoaNhanVien(manv);
            dialog dlg = new dialog("Tài khoản hiện đang bị khóa, \n tiến hành mở khóa ?", dialog.WARNING_DIALOG);
            if (dlg.getAction() != dialog.OK_OPTION) {
                return;
            }
            if (flag3 && flag4) {
                new dialog("Mở khóa tài khoản thành công!", dialog.SUCCESS_DIALOG);
            } else {
                new dialog("Mở khóa tài khoản thất bại!", dialog.ERROR_DIALOG);
            }
        }
        else if (ttNV==1) {
            boolean flag = nvDAO.deleteNhanVien(manv);
            boolean flag1 = taiKhoanDAO.khoaTaiKhoan(manv);
            if(flag && flag1)
                new dialog("Khoá tài khoản thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Khoá tài khoản thất bại!", dialog.ERROR_DIALOG);
        }
    }

    public void moKhoaTaiKhoan(String ma) {
        boolean flag = taiKhoanDAO.moKhoaTaiKhoan(ma);
        // boolean flag
        if (flag) {
            new dialog("Mở khoá tài khoản thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Mở khoá tài khoản thất bại!", dialog.ERROR_DIALOG);
        }
    }

    public String getMatKhauByMaNV(String ma){
        return taiKhoanDAO.getMkByMaNhanVien(ma);
    }

    public boolean doiMatKhau(String matKhauMoi, String matKhauCu, String maNV) {
        
        boolean flag = taiKhoanDAO.doiMatKhauAdmin(matKhauMoi, matKhauCu,maNV);
        if (flag) {
            new dialog("Đổi thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Đổi mật khẩu không thành công!", dialog.ERROR_DIALOG);
        }
        return flag;
    }

    public int getTrangThai(String maNV) {
        return taiKhoanDAO.getTrangThai(maNV);
    }

    public static void main(String[] args){
        TaiKhoanBUS t = new TaiKhoanBUS();
        t.khoaTaiKhoan("NV001");
    }
}

