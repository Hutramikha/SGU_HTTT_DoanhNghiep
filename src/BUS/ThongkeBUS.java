package BUS;

import java.lang.reflect.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.poi.hslf.record.DocInfoListContainer;

//import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DAO.n1_HoaDonDAO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DAO.n10_ThongKeDAO;

public class ThongkeBUS {
    HoaDonDTO hd = new HoaDonDTO();
    n1_HoaDonDAO HoaDon = new n1_HoaDonDAO();
    n10_ThongKeDAO TK = new n10_ThongKeDAO();
    NhanVienBUS listnv = new NhanVienBUS();
    ArrayList<NhanVienDTO> list = listnv.getlistNV();
    NhanVienDTO nv = new NhanVienDTO();
    NhanVienDAO listNhanVienDAO = new NhanVienDAO();
    KhachHangDTO kh = new KhachHangDTO();
    public ThongkeBUS (){
    }

    /////////////////////////////mặc định
    public int getTongTienHoaDonngay (Date date){
        int Tong = 0;
        Tong = TK.TongtienHoadonngay(date);
        return Tong;
    }
    public int getTongTienHoaDonthang (){
        int Tong = 0;
        Tong = TK.TongtienHoadonThangHienTai();
        return Tong;
    }
    public int getTongTienPhieunhapthang (){
        int Tong = 0;
        Tong = TK.TongtienPhieuNhapThangHienTai();
        return Tong;
    }
    public int getTongTienLuongthang (){
        int Tong = 0;
        Tong = TK.getTongLuongNhanVienThangHienTai();
        return Tong;
    }
    public int getsoluongKH(){
        int Soluong = 0;
        Soluong = TK.SoluongKHmoi();
        return Soluong;
    }
    public int getsoluongNV(){
        int Soluong = 0;
        Soluong = TK.Soluongnvien();
        return Soluong;
    }
    public int getsoluongPN(){
        int Soluong = 0;
        Soluong = TK.SoluongPhieuNhapTrongThangHienTai();
        return Soluong;
    }
    public int getsluongNL(){
        int Soluong=0;
        Soluong=TK.SoluongNguyenlieu();
        return Soluong;
    }
    public int getsluongNCC(){
        int Soluong=0;
        Soluong=TK.Soluongncc();
        return Soluong;
    }

    public int getsoluongHD(Date date){
        int Soluong = 0;
        Soluong = TK.SoluongHDmoi(date);
        return Soluong;
    }
    public int getSoluongMon(Date date){
        int Soluong=0;
        Soluong= TK.Tongmondaban(date);
        return Soluong;
    }
    public ArrayList<Integer> getArrayDoanhthuTuan(){
        ArrayList<Integer> Dthutuan = new ArrayList<>();
        int[] a = TK.getTongTienHoaDonTrongTuan();
        for (int d : a) {
            Dthutuan.add(d);
        }
        return Dthutuan;
    }
    ////////////////////mặc định
    /// loaddata
    //////////////lấy hóa đơn theo quý
    public ArrayList<Integer> getArrayDoanhthuquy(){
        ArrayList<Integer> Dthuquy = new ArrayList<>();
        int[] a = TK.getTongtienHoadonTheoQuy();
        for (int d : a) {
            Dthuquy.add(d);
        }
        return Dthuquy;
    }
    /////////////////lấy hóa đơn quý hiện tại
    public int getTongDoanhthuQuyHientai() {
        ArrayList<Integer> doanhThuQuy = getArrayDoanhthuquy();
        int quyHientai = (java.time.LocalDate.now().getMonthValue()+2)/3; // Tính quý hiện tại
        if (quyHientai > 0 && quyHientai <= doanhThuQuy.size()) {
            return doanhThuQuy.get(quyHientai - 1); // Lấy doanh thu của quý hiện tại
        }
        return 0;
    }
    ///////////lấy doanh thu theo tháng
    public ArrayList<Integer> getArrayDoanhthunam(){
        ArrayList<Integer> Dthunam = new ArrayList<>();
        int[] a = TK.getTongTienTheoThang();
        for (int d : a) {
            Dthunam.add(d);
        }
        return Dthunam;
    }
    public int getTongDthunam(){
        int tongtien=0;
        int[] a=TK.getTongTienTheoThang();
        for(int i=0;i<12;i++){
            tongtien = tongtien + a[i];
        }
        return tongtien;
    }
    //////////////lấy giá trị phiếu nhập theo tháng trong năm hiện tại
    public ArrayList<Integer> getArrayphieunhapnam(){
        ArrayList<Integer> Phieunhapnam = new ArrayList<>();
        int[] a = TK.getTongtienPhieunhap();
        for (int d : a) {
            Phieunhapnam.add(d);
        }
        return Phieunhapnam;
    }
    public ArrayList<Integer> getArrayphieunhapnamtheoquy(){
        ArrayList<Integer> Phieunhaptheoquy = new ArrayList<>();
        int[] a = TK.getTongTienPhieuNhapTheoQuy();
        for (int d : a) {
            Phieunhaptheoquy.add(d);
        }
        return Phieunhaptheoquy;
    }
    ///////////lấy giá trị lương nhân viên theo tháng
    public ArrayList<Integer> getArrayLuongnhanvien(String MaNV){
        ArrayList<Integer> luongTheoThang = new ArrayList<>();
        int[] a = TK.getLuongTheoThang(MaNV);
        for (int d : a) {
            luongTheoThang.add(d);
        }
        return luongTheoThang;

    }
    public ArrayList<Integer> getArrayTongLuongnhanvientheothang(){
        ArrayList<Integer> tongluongTheoThang = new ArrayList<>();
        int[] a = TK.getTongLuongTheoThangTrongNamHienTai();
        for (int d : a) {
            tongluongTheoThang.add(d);
        }
        return tongluongTheoThang;

    }
    public int getTongLuongnhanviennam() {
        int tong = 0;
        int[] a = TK.getTongLuongTheoThangTrongNamHienTai();
        
        for (int d : a) {
            tong += d;
    }
        return tong;
    }
    public int getTongphieunhapnam() {
        int tong = 0;
        int[] a = TK.getTongtienPhieunhap();
        for (int d : a) {
                tong += d;
        }
        return tong;
    }
    

    public ArrayList<Integer> getArrayTongLuongnhanvientheoquy(){
        ArrayList<Integer> tongluongTheoQuy = new ArrayList<>();
        int[] a = TK.getTongLuongTheoQuyTrongNamHienTai();
        for (int d : a) {
            tongluongTheoQuy.add(d);
        }
        return tongluongTheoQuy;

    }
    
    public int[] tinhLuongTheoQuy(int[] luongTheoThang) {
    int[] luongTheoQuy = new int[4];

    // Tính tổng lương cho từng quý
    luongTheoQuy[0] = luongTheoThang[0] + luongTheoThang[1] + luongTheoThang[2]; // Quý 1
    luongTheoQuy[1] = luongTheoThang[3] + luongTheoThang[4] + luongTheoThang[5]; // Quý 2
    luongTheoQuy[2] = luongTheoThang[6] + luongTheoThang[7] + luongTheoThang[8]; // Quý 3
    luongTheoQuy[3] = luongTheoThang[9] + luongTheoThang[10] + luongTheoThang[11]; // Quý 4

    return luongTheoQuy;
}
    public String[][] getkhoiluongNL(){
        return TK.getKhoiLuongTungNguyenLieu();
    }
    public static void main(String[] args) {
        ThongkeBUS tk = new ThongkeBUS();
        NhanVienDAO nv = new NhanVienDAO();
        NhanVienBUS lnv = new NhanVienBUS();
        Date date = new Date(System.currentTimeMillis());
        int a=tk.getTongTienHoaDonngay(date);
        int b=tk.getTongTienHoaDonthang();
        int c=tk.getsoluongKH();
        int d =tk.getsoluongHD(date);
        int e = tk.getSoluongMon(date);
        int t = tk.getTongDoanhthuQuyHientai();
        String z;
        ArrayList<NhanVienDTO> list = lnv.getlistNV();
        ArrayList<Integer> f = tk.getArrayDoanhthuTuan();
        ArrayList<Integer> i = tk.getArrayDoanhthuquy();
        ArrayList<Integer>  h= tk.getArrayDoanhthunam();
        ArrayList<Integer>  x= tk.getArrayphieunhapnam();

        for (int s=0; s<list.size();s++){
            z=list.get(s).getMaNhanVien();
            System.out.println( tk.getArrayLuongnhanvien(z));

            
        }
        

        System.out.println(a+","+b+","+c+","+d+","+e);
        System.out.println(f);
        System.out.println(i);
        System.out.println(h);
        System.out.println(x);
        System.out.println(list);
        System.out.println(t);

    }
}

