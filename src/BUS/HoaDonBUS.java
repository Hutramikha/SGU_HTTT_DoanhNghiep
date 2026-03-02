package BUS;

import Util.InputValidator;
import Util.dialog;
import DAO.n1_HoaDonDAO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class HoaDonBUS {

    private n1_HoaDonDAO HDDAO = new n1_HoaDonDAO();
    private ArrayList <HoaDonDTO> currentList = new ArrayList<>();
    private HoaDonDTO HD = new HoaDonDTO();
    DefaultTableModel modelTmp ;

    public ArrayList<HoaDonDTO> getlistHD() {
        return HDDAO.getListHoaDon();
    }


    // public ArrayList<HoaDonDTO> getlistHDtheoDateVaTongTien(Date DateMin, Date DateMax, int TongTienMin, int TongTienMax) {
    //     if (DateMin.after(DateMax)) {
    //         new dialog("Khoảng ngày không hợp lệ!", dialog.ERROR_DIALOG);
    //         return null;
    //     }
    //     if (TongTienMin > TongTienMax) {
    //         new dialog("Khoảng tiền không hợp lệ", dialog.ERROR_DIALOG);
    //     }
    //     return HDDAO.getListHoaDonTheoDateVaTongTien((java.sql.Date) DateMin, (java.sql.Date) DateMax, TongTienMin, TongTienMax);
    // }

    public HoaDonDTO getlisttheoMHD(String MHD) {
        if (HDDAO.getHoaDonTheoMHD(MHD) == null) {
            return null;
        }
        return HDDAO.getHoaDonTheoMHD(MHD);
    }

    public ArrayList<HoaDonDTO> getListHD_Price_Date(Date Min, Date Max, String GiaMin, String GiaMax) throws SQLException {
        if (currentList == null){
            currentList = HDDAO.getListHoaDon();
        }
        GiaMin = GiaMin.trim();
        GiaMax = GiaMax.trim();
        java.sql.Date sqlMin = null;
        java.sql.Date sqlMax = null;
        if (Min != null) {
            sqlMin = new java.sql.Date(Min.getTime());
        }
        if (Max != null) {
            sqlMax = new java.sql.Date(Max.getTime());
        }
        
        if (GiaMin.equals("") && GiaMax.equals("")) {
            if (sqlMin == null && sqlMax == null) {
                return currentList = HDDAO.getListHoaDon(); 
            } 
            else if (sqlMin != null && sqlMax == null) {
                // Chỉ có ngày bắt đầu
                return currentList = HDDAO.getListHoaDonTheoDateMin(sqlMin);
            } 
            else if (sqlMin == null && sqlMax != null) {
                
                return currentList = HDDAO.getListHoaDonTheoDateMax( sqlMax);
            } 
            else if(sqlMin==sqlMax){
                return currentList=HDDAO.getListHoaDonTheoDateBang(sqlMin);
            }
            else {
                
                return currentList = HDDAO.getListHoaDonTheoDate(sqlMin, sqlMax);
            }
        }

        if (Min==null && Max==null) {

            if (GiaMax.equals("") && !GiaMin.equals("")){
                int PriceMin = Integer.parseInt(GiaMin);
                currentList = HDDAO.getListHoaDonTheoGiaMin(PriceMin);
                return currentList;
            }
            if (!GiaMax.equals("") && GiaMin.equals("")){
                int PriceMin = Integer.parseInt(GiaMin);
                currentList = HDDAO.getListHoaDonTheoGiaMin(PriceMin);
                return currentList;
            }

            if(Integer.parseInt(GiaMax)==Integer.parseInt(GiaMin)){
                currentList = HDDAO.getListHoaDonTheoGia(Integer.parseInt(GiaMin));
                return currentList;
            }
        } 

        if (!InputValidator.IsEmpty(GiaMin) && !InputValidator.IsEmpty(GiaMax) && Max !=null && Min != null) {
            int giamin=Integer.parseInt(GiaMin);
            int giamax=Integer.parseInt(GiaMax);
            return currentList = HDDAO.getListHoaDonTheoDateVaTongTien(sqlMin, sqlMax, giamin, giamax);

        }

        if(Max !=null && Min != null&&!InputValidator.IsEmpty(GiaMin)){
            return currentList = HDDAO.getListHoaDonTheoDateVaGiaMin(sqlMin, sqlMax, Integer.parseInt(GiaMin));
        }

        if(Max !=null && Min != null&&!InputValidator.IsEmpty(GiaMax)){
            return currentList = HDDAO.getListHoaDonTheoDateVaGiaMax(sqlMin, sqlMax, Integer.parseInt(GiaMax));
        }

        if(!InputValidator.IsEmpty(GiaMin) && !InputValidator.IsEmpty(GiaMax)&& Max !=null){
            return currentList=HDDAO.getListHoaDonTheoDateMaxVaTongTien(sqlMax,Integer.parseInt(GiaMin),Integer.parseInt(GiaMax));
        }

        if(!InputValidator.IsEmpty(GiaMin) && !InputValidator.IsEmpty(GiaMax)&& Min !=null){
            System.out.println("min");
            return currentList=HDDAO.getListHoaDonTheoDateMinVaTongTien(sqlMin,Integer.parseInt(GiaMin),Integer.parseInt(GiaMax));
        }
        if(!InputValidator.IsEmpty(GiaMin)&& Min !=null){
            return currentList=HDDAO.getListHoaDonTheoDateMinAndGiaMin(sqlMin,Integer.parseInt(GiaMin));
        }

        if(!InputValidator.IsEmpty(GiaMax)&& Min !=null){
            return currentList=HDDAO.getListHoaDonTheoDateMinAndGiaMax(sqlMin,Integer.parseInt(GiaMax));
        }
        if(!InputValidator.IsEmpty(GiaMin)&& Max !=null){
            return currentList=HDDAO.getListHoaDonTheoDateMaxAndGiaMin(sqlMax,Integer.parseInt(GiaMin));
        }
        if(!InputValidator.IsEmpty(GiaMax)&& Max !=null){
            return currentList=HDDAO.getListHoaDonTheoDateMaxAndGiaMax(sqlMax,Integer.parseInt(GiaMax));
        }

        return currentList;
    }

    public String getNewId() {
        return HDDAO.getNewId();
    }

    public boolean Insert(HoaDonDTO hoaDon) {
        if (HDDAO.addHoaDon(hoaDon)) {
            new dialog("Thanh toán thành công!", dialog.SUCCESS_DIALOG);
            return true;
        }
        new dialog("Thanh toán không thành công!", dialog.ERROR_DIALOG);
        return false;
    }

    public void loadData(JTable table){
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Mã khuyến mãi","Mã ưu đãi", "Ngày lập", "Tổng tiền"
            }, 
            0 
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        table.setModel(model);
        HoaDonBUS list = new HoaDonBUS();
        ArrayList<HoaDonDTO> listHD = list.getlistHD();
        for (int i = 0; i < list.getlistHD().size(); i++) {
            Object[] newRowData = {listHD.get(i).getMaHoaDon(), listHD.get(i).getMaKhachHang(), listHD.get(i).getMaNhanVien(), listHD.get(i).getMaKhuyenMai(), listHD.get(i).getMaUuDai(), listHD.get(i).getNgayLapHoaDon(), listHD.get(i).getTongTienHoaDon()};
            model.addRow(newRowData);
        }
        modelTmp = model;
    }

    public void TimHoaDonTheoMa(JTable table, String MAHD){
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Mã khuyến mãi", "Ngày lập" ,"Mã ưu đãi", "Tổng tiền"
            }, 
            0 
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        table.setModel(model);
        ArrayList<HoaDonDTO> dshd1=getlistHD();
        MAHD=MAHD.toLowerCase();
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        for (HoaDonDTO hd:dshd1) {
            if (hd.getMaHoaDon().toLowerCase().contains(MAHD) )
                dshd.add(hd);
            }
        for (HoaDonDTO hd : dshd) {
        Vector<Object> vec = new Vector<>();
        vec.add(hd.getMaHoaDon());
        vec.add((hd.getMaKhachHang()));
        vec.add((hd.getMaNhanVien()));
        vec.add((hd.getMaKhuyenMai()));
        vec.add((hd.getNgayLapHoaDon()));
        vec.add((hd.getMaUuDai()));
        vec.add((hd.getTongTienHoaDon()));
        model.addRow(vec);
        }
    }

    public void TimKiemHoaDonTheoNgay_TongTien(JDateChooser JDTuNgay,JDateChooser JDDenNgay,JTextField TextFieldGiaTu,JTextField TextFieldDenGia,JTable TblHoaDon){
        DefaultTableModel model = new DefaultTableModel(
            new String[] {
                "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Mã khuyến mãi", "Mã ưu đãi", "Ngày lập", "Tổng tiền"
            }, 
            0 
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TblHoaDon.setModel(model);
        HoaDonBUS list = new HoaDonBUS();
        ArrayList<HoaDonDTO> listHD = null;
        try {
            listHD = list.getListHD_Price_Date(JDTuNgay.getDate(), JDDenNgay.getDate(), TextFieldGiaTu.getText(), TextFieldDenGia.getText());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        if (listHD != null) {
            for (int i = 0; i < listHD.size(); i++) {
                Object[] newRowData = {listHD.get(i).getMaHoaDon(), listHD.get(i).getMaKhachHang(), listHD.get(i).getMaNhanVien(), listHD.get(i).getMaKhuyenMai(), listHD.get(i).getMaUuDai(), listHD.get(i).getNgayLapHoaDon(), listHD.get(i).getTongTienHoaDon()};
                model.addRow(newRowData);
            }
        }
    }

}
