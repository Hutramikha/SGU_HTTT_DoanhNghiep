package GUI;

import java.awt.*;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.knowm.xchart.*;

import BUS.NhanVienBUS;
import BUS.ThongkeBUS;
import DTO.NguyenLieuDTO;
import BUS.n5_NguyenLieuBUS;
import DTO.NhanVienDTO;
import Util.XuLyFileExcel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author phanloc
 */
public class n10_ThongkePanel extends javax.swing.JPanel {

    /**
     * 
     */
    CardLayout cardLayout = new CardLayout();
    CardLayout cardLayout1 = new CardLayout();
    CardLayout cardLayout2 = new CardLayout();
    CardLayout cardLayout3 = new CardLayout();
    CardLayout cardLayout4 = new CardLayout();
    ThongkeBUS TK = new ThongkeBUS();
    NhanVienBUS listnv = new NhanVienBUS();
    ArrayList<NhanVienDTO> list = listnv.getlistNV();
    Date date = new Date(System.currentTimeMillis());
    n5_NguyenLieuBUS NLBUS = new n5_NguyenLieuBUS();

    public n10_ThongkePanel() {
        initComponents();
        // loaddata();
        initUI();
        addControl();
    }

    private void initUI() {
        ////////////////// dữ liệu
        String Dthungay = (toCurrency(TK.getTongTienHoaDonngay(date)));
        txtDthungay.setText(Dthungay);
        String SoLuongHoaDon = (String.valueOf(TK.getsoluongHD(date)));
        String SoluongKh = String.valueOf(TK.getsoluongKH());
        String Soluongmon = String.valueOf(TK.getSoluongMon(date));
        String Dthuthang = toCurrency(TK.getTongTienHoaDonthang());
        String Dthnam = toCurrency(TK.getTongDthunam());
        String ChiphiNhaphang = toCurrency(TK.getTongTienPhieunhapthang());
        String ChiphiLuongNhanvien = toCurrency(TK.getTongTienLuongthang());
        String Tongchiphi = toCurrency(TK.getTongTienLuongthang() + TK.getTongTienPhieunhapthang());
        String Loinhuanngay = toCurrency(TK.getTongTienHoaDonngay(date));
        String Loinhuanthang = toCurrency(TK.getTongTienHoaDonthang()-TK.getTongTienPhieunhapthang()-TK.getTongTienLuongthang());
        String LoinhuanTong = toCurrency(TK.getTongDthunam()-TK.getTongLuongnhanviennam()-TK.getTongphieunhapnam());
        String SlNhanvien = String.valueOf(TK.getsoluongNV());
        String TongluongnvThang = toCurrency(TK.getTongTienLuongthang());
        String Tongluongnvnam = toCurrency(TK.getTongLuongnhanviennam());
        String SoluongPhieunhap = String.valueOf(TK.getsoluongPN());
        String SoluongNL = String.valueOf(TK.getsluongNL());
        String SoluongNCC = String.valueOf(TK.getsluongNCC());
        ///////////////
        jTextField6.setText(Dthungay);
        jTextField7.setText(Dthuthang);
        jTextField8.setText(Dthnam);
        jTextField9.setText(ChiphiNhaphang );
        jTextField10.setText(ChiphiLuongNhanvien );
        jTextField11.setText(Tongchiphi );
        jTextField18.setText(Loinhuanngay);
        jTextField19.setText(Loinhuanthang );
        jTextField20.setText(LoinhuanTong);
        jTextField12.setText(SlNhanvien + " Nhân Viên");
        jTextField13.setText(TongluongnvThang );
        jTextField14.setText(Tongluongnvnam );
        jTextField15.setText(SoluongPhieunhap + " Phiếu nhập");
        jTextField16.setText(SoluongNL + " Nguyên liệu");
        jTextField17.setText(SoluongNCC + " Nhà Cung Cấp");
        ///////////////
        txtDthungay.setText(Dthungay);
        txtSLHoadonngay.setText(SoLuongHoaDon + " Hóa đơn");
        Slmondabanngay.setText(Soluongmon + " Món");
        SoluongKH.setText(SoluongKh + " Khách hàng");
        Dthuthanghientai.setText(Dthuthang);
        Slmondabanngay.setEditable(false);
        SoluongKH.setEditable(false);
        Dthuthanghientai.setEditable(false);

        
//////////////////////////////// biểu đồ đường mặc định
        List<Integer> xData = Arrays.asList(2,3,4,5,6,7,8);
        // List<Integer> yData = Arrays.asList(1.0, 4.0, 3.0, 5.0, 4.0, 3.0, 5.0, 4.0,
        // 3.0, 5.0, 5.0, 4.0, 3.0, 1.0, 4.0, 3.0, 5.0, 4.0);
        ArrayList<Integer> yData = TK.getArrayDoanhthuTuan();
        List<String> seriesNamedthutuan = List.of("doanh thu");
        // Tạo biểu đồ
        XYChart chartDefault = n10_ChartCreator.createLineChart(xData, yData,seriesNamedthutuan, "doanh thu tuần", "thứ",
                "Doanh thu (trăm)");
        XChartPanel<XYChart> chartPanel = new XChartPanel<>(chartDefault);
        content_Panel.setLayout(new BorderLayout());
        content_Panel.add(chartPanel, BorderLayout.NORTH);

//////////////////////////////// biểu đồ đường doanh thu
        /// ////////////////theo tháng
        List<String> xdataDthu = Arrays.asList("tháng 1", "tháng 2", "tháng 3", "tháng 4", "tháng 5", "tháng 6", "tháng 7", "tháng 8", "tháng 9", "tháng 10", "tháng 11", "tháng 12");
        List<Integer> xIndexDThu = new ArrayList<>();
        for (int i = 1; i < xdataDthu.size()+1; i++) {
            xIndexDThu.add(i);
        }
        List<String> seriesNamedthu = List.of("doanh thu");
        List<Integer> ydataDthu = TK.getArrayDoanhthunam();
        XYChart ChartDthu = n10_ChartCreator.createLineChart(xIndexDThu, ydataDthu,seriesNamedthu, "Biểu đồ doanh thu năm theo Tháng",
                "tháng", "doanh thu");

        XChartPanel<XYChart> ChartPanelDthu = new XChartPanel<XYChart>(ChartDthu);

        Main_DtPn1.setLayout(new BorderLayout());
        Main_DtPn1.add(ChartPanelDthu, BorderLayout.NORTH);
        // /////////////////theo quý
        List<Integer> xdataDthuQuy = Arrays.asList(1,2,3,4);
        List<Integer> ydataDthuQUy = TK.getArrayDoanhthuquy();
        List<String> seriesNamedthuquy = List.of("doanh thu");
        XYChart ChartDthuquy = n10_ChartCreator.createLineChart(xdataDthuQuy, ydataDthuQUy,seriesNamedthuquy,
                "Biểu đồ doanh thu năm theo quý", "Quý", "doanh thu (Triệu)");

        XChartPanel<XYChart> ChartPanelDthuquy = new XChartPanel<XYChart>(ChartDthuquy);

        Main_DtPn2.setLayout(new BorderLayout());
        Main_DtPn2.add(ChartPanelDthuquy, BorderLayout.NORTH);

////////////////////////////////////// biểu đồ cột chi phí
        /// ////////////////tháng
        List<String> xdataCphi = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        List<List<Integer>> yDataList = List.of(TK.getArrayTongLuongnhanvientheothang(), TK.getArrayphieunhapnam());
        List<String> seriesName = List.of("lương nhân viên", "nhập hàng");

        CategoryChart ChartChiphi = n10_ChartCreator.createBarChart(xdataCphi, yDataList, seriesName, "Biểu đồ chi phí",
                "Tháng", "Chi phí");
        XChartPanel<CategoryChart> ChartChiphipanel = new XChartPanel<CategoryChart>(ChartChiphi);
        ContentCphi1.setLayout(new BorderLayout());
        ContentCphi1.add(ChartChiphipanel, BorderLayout.NORTH);
        //////////////// quý
        List<String> xdataCphiquy = Arrays.asList("quý 1", "quý 2", "quý 3", "quý 4");
        List<List<Integer>> yDataListQuy = List.of(TK.getArrayTongLuongnhanvientheoquy(),
                TK.getArrayphieunhapnamtheoquy());
        List<String> seriesNameQuy = List.of("lương nhân viên", "nhập hàng");

        CategoryChart ChartChiphiQuy = n10_ChartCreator.createBarChart(xdataCphiquy, yDataListQuy, seriesNameQuy,
                "Biểu đồ chi phí", "Tháng", "Chi phí ");
        XChartPanel<CategoryChart> ChartChiphipanelQuy = new XChartPanel<CategoryChart>(ChartChiphiQuy);
        ContentCphi2.setLayout(new BorderLayout());
        ContentCphi2.add(ChartChiphipanelQuy, BorderLayout.NORTH);
////////////////////////////////////// biểu đồ cột lợi nhuận
        List<String> xdataLoinhuan = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        ArrayList<Integer> Dthu = TK.getArrayDoanhthunam();
        ArrayList<Integer> ChiPhi = TK.getArrayphieunhapnam();
        ArrayList<Integer> LuongNV = TK.getArrayTongLuongnhanvientheothang();
        ArrayList<Integer> LoiNhuan = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int LoiNhuanthang = Dthu.get(i) - ChiPhi.get(i) - LuongNV.get(i);
            LoiNhuan.add(LoiNhuanthang);
        }
        List<List<Integer>> yDataList1 = List.of(LoiNhuan);
        List<String> seriesName1 = List.of("Lợi nhuận");
        CategoryChart ChartLoinhuan = n10_ChartCreator.createBarChart(xdataLoinhuan, yDataList1, seriesName1,
                "Biểu đồ lợi nhuận", "Tháng", "lợi nhuận");
        XChartPanel<CategoryChart> ChartLoinhuanpanel = new XChartPanel<CategoryChart>(ChartLoinhuan);
        contentTKLnhuan1.setLayout(new BorderLayout());
        contentTKLnhuan1.add(ChartLoinhuanpanel, BorderLayout.NORTH);
        ///////////////////////// quý
        List<String> xdataLoinhuanquy = Arrays.asList("1", "2", "3", "4");
        ArrayList<Integer> Dthuquy = TK.getArrayDoanhthuquy();
        ArrayList<Integer> ChiPhiQuy = TK.getArrayphieunhapnamtheoquy();
        ArrayList<Integer> LuongNVQuy = TK.getArrayTongLuongnhanvientheoquy();

        ArrayList<Integer> LoiNhuanQuy = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int LoiNhuan2 = Dthuquy.get(i) - ChiPhiQuy.get(i) - LuongNVQuy.get(i);
            LoiNhuanQuy.add(LoiNhuan2);
        }
        List<List<Integer>> yDataList2 = List.of(LoiNhuanQuy);
        List<String> seriesName2 = List.of("Lợi nhuận");
        CategoryChart ChartLoinhuanQuy = n10_ChartCreator.createBarChart(xdataLoinhuanquy, yDataList2, seriesName2,
                    "Biểu đồ lợi nhuận", "Quý", "lợi nhuận");
        XChartPanel<CategoryChart> ChartLoinhuanpanelquy = new XChartPanel<CategoryChart>(ChartLoinhuanQuy);
        contentTKLnhuan2.setLayout(new BorderLayout());
        contentTKLnhuan2.add(ChartLoinhuanpanelquy, BorderLayout.NORTH);
////////////////////////////////////// biểu đồ cột chi phí
        List<String> xdataCLuong = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
        List<List<Integer>> yDataList3 = new ArrayList<>();
        List<String> seriesName3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String z;
            String y;
            z = list.get(i).getMaNhanVien();
            y = list.get(i).getTenNhanVien();
            if (list.get(i).getTrangThaiNhanVien() == 0) {
                seriesName3.add(z + ":" + y + " (đã nghỉ)");
            } else {
                seriesName3.add(z + ":" + y);
            }
            ArrayList<Integer> listluong = new ArrayList<>();
            for (int d : TK.getArrayLuongnhanvien(z)) {
                listluong.add(d);

            }
            yDataList3.add(listluong);
        }

        CategoryChart ChartLuong = n10_ChartCreator.createBarChart(xdataCLuong, yDataList3, seriesName3,
                "Biểu đồ lương", "Tháng", "Chi phí");
        XChartPanel<CategoryChart> ChartLuongPn = new XChartPanel<CategoryChart>(ChartLuong);
        ContentLuong1.setLayout(new BorderLayout());
        ContentLuong1.add(ChartLuongPn, BorderLayout.NORTH);
        ////// biểu đồ bánh
    
        
        // Thêm dữ liệu vào biểu đồ Pie
        ArrayList <String> datanl = new ArrayList<>();
        ArrayList <Double> khoiluongnl = new ArrayList<>();
        String a[][]= TK.getkhoiluongNL();
        Double sumkl=0.0;
        for(int i= 0; i< TK.getsluongNL();i++){
            sumkl = sumkl + Integer.parseInt(a[i][1]);
        }
        for(int i= 0; i< TK.getsluongNL();i++){
            datanl.add(a[i][0]);
            khoiluongnl.add(Double.parseDouble(a[i][1])/sumkl*100);
        }
        PieChart piechart = n10_ChartCreator.createPieChart(datanl, khoiluongnl, "biểu đồ tỉ khối nguyên liệu trong kho");
        // Tạo XChartPanel để hiển thị biểu đồ
        XChartPanel<PieChart> ChartpnKho = new XChartPanel<>(piechart);
        ContentKhohang1.setLayout(new BorderLayout());
        ContentKhohang1.add(ChartpnKho, BorderLayout.NORTH);
    }

    private void addControl() {

        String[] columnNames = { "Tháng", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "tổng năm" + date.toLocalDate().getYear() };
        String[] columnNamesquy = { "Quý", "1", "2", "3", "4", "tổng năm" + date.toLocalDate().getYear() };

        ArrayList<Integer> dataDthu = TK.getArrayDoanhthunam(); // Doanh thu
        ArrayList<Integer> dataDthuquy = TK.getArrayDoanhthuquy(); // Doanh thu
        ArrayList<Integer> datapn = TK.getArrayphieunhapnam(); // Phí nhập hàng
        ArrayList<Integer> datapnquy = TK.getArrayphieunhapnamtheoquy(); // Phí nhập hàng theo quý
        ArrayList<Integer> dataluong = TK.getArrayTongLuongnhanvientheothang(); // Lương nhân viên
        ArrayList<Integer> dataluongQuy = TK.getArrayTongLuongnhanvientheoquy(); // Lương nhân viên Quý

        // Tạo mảng 2 chiều String để lưu dữ liệu
        String[][] stringArrayDthu = new String[1][14];
        String[][] stringArrayDthuquy = new String[1][6];
        String[][] stringArrayChiphi = new String[2][14];
        String[][] stringArrayChiphiquy = new String[2][6];
        String[][] stringArrayloinhuan = new String[1][14];
        String[][] stringArrayloinhuanquy = new String[1][6];
        String[][] stringArrayDefault = new String[4][14];
        
        


        Double sumDT= 0.0;
        Double sumpn = 0.0;
        Double sumluong = 0.0;
        Double sumluongnv = 0.0;
        Double Sumloinhuan = 0.0;
        Double sumDTquy= 0.0;
        Double sumpnquy = 0.0;
        Double sumluongquy = 0.0;
        Double Sumloinhuanquy = 0.0;
        // Đặt tiêu đề cho từng dòng
        stringArrayDthu[0][0] = "Doanh thu";
        stringArrayDthuquy[0][0] = "Doanh thu";
        stringArrayChiphi[0][0] = "Phí nhập hàng";
        stringArrayChiphi[1][0] = "Lương nhân viên";
        stringArrayChiphiquy[0][0] = "Phí nhập hàng";
        stringArrayChiphiquy[1][0] = "Lương nhân viên";
        stringArrayloinhuan[0][0] = "lợi nhuận";
        stringArrayloinhuanquy[0][0] = "Phí nhập hàng";
// EXPORT
// Gán dữ liệu vào các cột tháng (1 đến 12)
        //mạc định
        
        // doanh thu
        for (int j = 0; j < 12; j++) {
            // Gán doanh thu cho từng tháng
            stringArrayDthu[0][j + 1] = String.valueOf(dataDthu.get(j));
            sumDT= sumDT+ dataDthu.get(j);
            stringArrayDthu[0][13] = String.valueOf(sumDT);
        //     System.out.println(sumDT);
        }
        for (int j = 0; j < 4; j++) {
            // Gán doanh thu cho từng quý
            stringArrayDthuquy[0][j + 1] = String.valueOf(dataDthuquy.get(j));
            sumDTquy= sumDTquy+ dataDthuquy.get(j);
            stringArrayDthuquy[0][5] = String.valueOf(sumDTquy);
        //     System.out.println(sumDTquy);

        }
        // chi phí
        for (int j = 0; j < 12; j++) {
            // Gán doanh thu cho từng tháng
            stringArrayChiphi[0][j + 1] = String.valueOf(datapn.get(j));
            sumpn = sumpn + datapn.get(j);
            stringArrayChiphi[0][13] = String.valueOf(sumpn);

            stringArrayChiphi[1][j + 1] = String.valueOf(dataluong.get(j));
            sumluong += dataluong.get(j);
        //     System.out.print(dataluong.get(j));
        //     System.out.print(sumluong);
            stringArrayChiphi[1][13] = String.valueOf(sumluong);
        }
        /// quý
        for (int j = 0; j < 4; j++) {
            // Gán doanh thu cho từng tháng
            stringArrayChiphiquy[0][j + 1] = String.valueOf(datapnquy.get(j));
            sumpnquy = sumpnquy + datapnquy.get(j);
            stringArrayChiphiquy[0][5] = String.valueOf(sumpnquy);

            stringArrayChiphiquy[1][j + 1] = String.valueOf(dataluongQuy.get(j));
            sumluongquy = sumluongquy + dataluongQuy.get(j);
            stringArrayChiphiquy[1][5] = String.valueOf(sumluongquy);
        }
        ////// lợi nhuận
        for (int j = 0; j < 12; j++) {
            
            stringArrayloinhuan[0][j + 1] = String.valueOf(dataDthu.get(j) - dataluong.get(j) - datapn.get(j));
            Sumloinhuan = Sumloinhuan + (dataDthu.get(j) - dataluong.get(j) - datapn.get(j));
            stringArrayloinhuan[0][13] = String.valueOf(Sumloinhuan);
        }
        for (int j = 0; j < 4; j++) {
            
            stringArrayloinhuanquy[0][j + 1] = String
                    .valueOf(dataDthuquy.get(j) - dataluongQuy.get(j) - datapnquy.get(j));
            Sumloinhuanquy = Sumloinhuanquy + (dataDthuquy.get(j) - dataluongQuy.get(j) - datapnquy.get(j));
            stringArrayloinhuanquy[0][5] = String.valueOf(Sumloinhuanquy);
        }
        //////////// lương nhân viên
        String[][] stringArrayluongnv = new String[list.size()][14];
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> a = TK.getArrayLuongnhanvien(list.get(i).getMaNhanVien());
            stringArrayluongnv[i][0] = list.get(i).getTenNhanVien();
            sumluongnv = 0.0;
            for (int j = 0; j < 12; j++) {
                stringArrayluongnv[i][j + 1] = String.valueOf(a.get(j));
                sumluongnv += a.get(j);
            }
            stringArrayluongnv[i][13] = String.valueOf(sumluongnv);

        }
        ////////////////kho
        DefaultTableModel tableModeldsnl = new DefaultTableModel();
        tableModeldsnl.addColumn("Tên Nguyên Liệu");
        tableModeldsnl.addColumn("Khối Lượng");
        ArrayList<NguyenLieuDTO> list = NLBUS.getAll();
       for(int i = 0; i < list.size(); i++) {
            tableModeldsnl.addRow(new Object[] {
               list.get(i).getTenNguyenLieu(),
               list.get(i).getKhoiLuongNguyenLieu(),
               
           });
       }
       //mặc định
       for (int j = 0; j < 12; j++) {
        // Gán doanh thu cho từng tháng
        stringArrayDefault[0][j ] = stringArrayDthu[0][j];
        stringArrayDefault[1][j ] = stringArrayChiphi[0][j];
        stringArrayDefault[2][j ] = stringArrayChiphi[1][j];
        stringArrayDefault[3][j ] = stringArrayloinhuan[0][j];
        stringArrayDefault[0][13] = String.valueOf(sumDT);
        stringArrayDefault[1][13] = String.valueOf(sumpn);
        stringArrayDefault[2][13] = String.valueOf(sumluong);
        stringArrayDefault[3][13] = String.valueOf(Sumloinhuan);
    }
   
        // Tạo DefaultTableModel với dữ liệu từ stringArray và columnNames
        DefaultTableModel tableModeldt = new DefaultTableModel(stringArrayDthu, columnNames);
        DefaultTableModel tableModeldtquy = new DefaultTableModel(stringArrayDthuquy, columnNamesquy);
        DefaultTableModel tableModelchiphi = new DefaultTableModel(stringArrayChiphi, columnNames);
        DefaultTableModel tableModelchiphiquy = new DefaultTableModel(stringArrayChiphiquy, columnNamesquy);
        DefaultTableModel tableModelloinhuan = new DefaultTableModel(stringArrayloinhuan, columnNames);
        DefaultTableModel tableModelloinhuanquy = new DefaultTableModel(stringArrayloinhuanquy, columnNamesquy);
        DefaultTableModel tableModelluongnv = new DefaultTableModel(stringArrayluongnv, columnNames);
        DefaultTableModel tableModelmDefaul = new DefaultTableModel(stringArrayDefault, columnNames);
        

        // Gán model cho JTable
        tableDT.setModel(tableModeldt);
        tableDTquy.setModel(tableModeldtquy);
        tableCP.setModel(tableModelchiphi);
        tableCPquy.setModel(tableModelchiphiquy);
        tableLN.setModel(tableModelloinhuan);
        tableLNquy.setModel(tableModelloinhuanquy);
        tableLuong.setModel(tableModelluongnv);
        tableKho.setModel(tableModeldsnl);
        tableDf.setModel(tableModelmDefaul);

        ThongkePanel.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
            @Override
            protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
                return 0;
            }

            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
                return 0;
            }

            @Override
            protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        HeaderTk = new javax.swing.JPanel();
        BtnExport = new javax.swing.JButton();
        Combobox_TK = new javax.swing.JComboBox<>();
        ThongkePanel = new javax.swing.JTabbedPane();
        DefaultTK = new javax.swing.JScrollPane();
        Panel_default = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        DtNgayPn = new javax.swing.JPanel();
        txtDthungay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        SLdonhangPn = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSLHoadonngay = new javax.swing.JTextField();
        SLspBanPn = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Slmondabanngay = new javax.swing.JTextField();
        KhMoiPn = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        SoluongKH = new javax.swing.JTextField();
        TongDtPn = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Dthuthanghientai = new javax.swing.JTextField();
        content_Panel = new javax.swing.JPanel();
        TK_doanhthu = new javax.swing.JScrollPane();
        PnDthu = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        DetailDtPn = new javax.swing.JPanel();
        TongDThungay = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        DthuthangHtai = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        DTnamHtai = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Main_DtPn = new javax.swing.JPanel();
        Main_DtPn1 = new javax.swing.JPanel();
        Main_DtPn2 = new javax.swing.JPanel();
        selectPn = new javax.swing.JPanel();
        CbboxDthu = new javax.swing.JComboBox<>();
        TK_chiphi = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        DetailChiphi = new javax.swing.JPanel();
        ChiphiPnhapHtai = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ChiphiluongNV = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        TongchiphiThang = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        ContentCphi = new javax.swing.JPanel();
        ContentCphi1 = new javax.swing.JPanel();
        ContentCphi2 = new javax.swing.JPanel();
        selectPnCphi = new javax.swing.JPanel();
        CbboxChiphi = new javax.swing.JComboBox<>();
        TK_loinhuan = new javax.swing.JScrollPane();
        jPanel72 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        detailLoinhuan = new javax.swing.JPanel();
        Loinhuanngay = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        Loinhuanthang = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        LoinhanTong = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        contentTKLnhuan = new javax.swing.JPanel();
        contentTKLnhuan1 = new javax.swing.JPanel();
        contentTKLnhuan2 = new javax.swing.JPanel();
        selectPnLoinhuan = new javax.swing.JPanel();
        CbboxLoinhuan = new javax.swing.JComboBox<>();
        TK_luong = new javax.swing.JScrollPane();
        jPanel80 = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        detailLuong = new javax.swing.JPanel();
        SluongNV = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        TongluongnvThang = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        TongLuongnvnam = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        ContentLuong = new javax.swing.JPanel();
        ContentLuong1 = new javax.swing.JPanel();
        ContentLuong2 = new javax.swing.JPanel();
        selectPnLuong = new javax.swing.JPanel();
        CbboxLuong = new javax.swing.JComboBox<>();
        TK_khohang = new javax.swing.JScrollPane();
        jPanel88 = new javax.swing.JPanel();
        jPanel89 = new javax.swing.JPanel();
        detailKhohang = new javax.swing.JPanel();
        SoluongPhieunhap = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        SoluongNguyenlieu = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        SoluongNcc = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        ContentKhohang = new javax.swing.JPanel();
        ContentKhohang1 = new javax.swing.JPanel();
        ContentKhohang3 = new javax.swing.JPanel();
        selectKhohang = new javax.swing.JPanel();
        CbboxKhohang = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        

        setBackground(new java.awt.Color(122, 74, 74));
        setMaximumSize(new java.awt.Dimension(1125, 667));
        setPreferredSize(new java.awt.Dimension(1120, 667));

        jPanel1.setPreferredSize(new java.awt.Dimension(1125, 658));

        HeaderTk.setBackground(new java.awt.Color(255, 255, 255));
        HeaderTk.setPreferredSize(new java.awt.Dimension(1120, 93));

        BtnExport.setBackground(new java.awt.Color(217, 217, 217));
        BtnExport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnExport.setText("Tạo báo cáo ");
        BtnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XuLyFileExcel ex = new XuLyFileExcel();
                if (Combobox_TK.getSelectedItem().equals("Doanh Thu")) {
                

                    if (CbboxDthu.getSelectedItem().equals("Tháng")) {
                        ex.xuatExcel(tableDT);
                    } else {
                        ex.xuatExcel(tableDTquy);
                    }
                } else if (Combobox_TK.getSelectedItem().equals("Chi phí")) {
                    if (CbboxChiphi.getSelectedItem().equals("Tháng")) {
                        ex.xuatExcel(tableCP);
                    } else {
                        ex.xuatExcel(tableCPquy);
                    }

                } else if (Combobox_TK.getSelectedItem().equals("Lợi nhuận")) {
                    if (CbboxLoinhuan.getSelectedItem().equals("Tháng")) {
                        ex.xuatExcel(tableLN);
                    } else {
                        ex.xuatExcel(tableLNquy);
                    }

                } else if (Combobox_TK.getSelectedItem().equals("Lương")) {
                    ex.xuatExcel(tableLuong);

                } else if(Combobox_TK.getSelectedItem().equals("Mặc định")) {
                    if (CbboxLoinhuan.getSelectedItem().equals("Tháng")) {
                        ex.xuatExcel(tableDf);
                    } else {
                        ex.xuatExcel(tableDfquy);
                    }
                } else{
                    ex.xuatExcel(tableKho);
                }

            }
        });

        Combobox_TK.setBackground(new java.awt.Color(219, 189, 142));
        Combobox_TK.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Mặc định", "Doanh Thu", "Chi phí", "Lợi nhuận", "Lương", "Kho hàng" }));
        Combobox_TK.setToolTipText("");
        Combobox_TK.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Combobox_TK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Combobox_TK.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        Combobox_TK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combobox_TKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderTkLayout = new javax.swing.GroupLayout(HeaderTk);
        HeaderTk.setLayout(HeaderTkLayout);
        HeaderTkLayout.setHorizontalGroup(
                HeaderTkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeaderTkLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(Combobox_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 726,
                                        Short.MAX_VALUE)
                                .addComponent(BtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)));
        HeaderTkLayout.setVerticalGroup(
                HeaderTkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeaderTkLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(HeaderTkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BtnExport, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Combobox_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(34, Short.MAX_VALUE)));

        ThongkePanel.setBackground(new java.awt.Color(255, 255, 255));
        ThongkePanel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        ThongkePanel.setTabPlacement(1);
        ThongkePanel.setPreferredSize(new java.awt.Dimension(1120, 500));

        DefaultTK.setBackground(new java.awt.Color(219, 189, 142));
        DefaultTK.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        DefaultTK.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultTK.setPreferredSize(new java.awt.Dimension(1120, 450));

        Panel_default.setBackground(new java.awt.Color(204, 0, 51));
        Panel_default.setEnabled(false);
        Panel_default.setMaximumSize(new java.awt.Dimension(590, 600));
        Panel_default.setPreferredSize(new java.awt.Dimension(1000, 1000));
        Panel_default.setLayout(new javax.swing.BoxLayout(Panel_default, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(219, 189, 142));
        jPanel5.setPreferredSize(new java.awt.Dimension(1090, 500));

        headerPanel.setBackground(new java.awt.Color(219, 189, 142));
        headerPanel.setEnabled(false);
        headerPanel.setMaximumSize(new java.awt.Dimension(590, 600));
        headerPanel.setMinimumSize(new java.awt.Dimension(300, 218));
        headerPanel.setPreferredSize(new java.awt.Dimension(1090, 218));
        headerPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 60, 20));

        DtNgayPn.setBackground(new java.awt.Color(217, 217, 217));
        DtNgayPn.setPreferredSize(new java.awt.Dimension(200, 100));

        txtDthungay.setBackground(new java.awt.Color(217, 217, 217));
        txtDthungay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDthungay.setText("ngày");
        txtDthungay.setBorder(null);
        txtDthungay.setEditable(false);

        jLabel1.setBackground(new java.awt.Color(168, 154, 143));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Doanh thu ngày");
        jLabel1.setToolTipText("");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout DtNgayPnLayout = new javax.swing.GroupLayout(DtNgayPn);
        DtNgayPn.setLayout(DtNgayPnLayout);
        DtNgayPnLayout.setHorizontalGroup(
                DtNgayPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DtNgayPnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtDthungay, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DtNgayPnLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        DtNgayPnLayout.setVerticalGroup(
                DtNgayPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DtNgayPnLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(txtDthungay, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        headerPanel.add(DtNgayPn);

        SLdonhangPn.setBackground(new java.awt.Color(217, 217, 217));
        SLdonhangPn.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel2.setBackground(new java.awt.Color(168, 154, 143));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Đơn hàng");
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 20));

        txtSLHoadonngay.setBackground(new java.awt.Color(217, 217, 217));
        txtSLHoadonngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSLHoadonngay.setText("100");
        txtSLHoadonngay.setBorder(null);
        txtSLHoadonngay.setEditable(false);

        javax.swing.GroupLayout SLdonhangPnLayout = new javax.swing.GroupLayout(SLdonhangPn);
        SLdonhangPn.setLayout(SLdonhangPnLayout);
        SLdonhangPnLayout.setHorizontalGroup(
                SLdonhangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SLdonhangPnLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(SLdonhangPnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtSLHoadonngay, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        SLdonhangPnLayout.setVerticalGroup(
                SLdonhangPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SLdonhangPnLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(txtSLHoadonngay, javax.swing.GroupLayout.DEFAULT_SIZE, 38,
                                        Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        headerPanel.add(SLdonhangPn);

        SLspBanPn.setBackground(new java.awt.Color(217, 217, 217));
        SLspBanPn.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel3.setBackground(new java.awt.Color(168, 154, 143));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sản phẩm bán ra");
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(200, 20));

        Slmondabanngay.setBackground(new java.awt.Color(217, 217, 217));
        Slmondabanngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Slmondabanngay.setText("100000");
        Slmondabanngay.setBorder(null);

        javax.swing.GroupLayout SLspBanPnLayout = new javax.swing.GroupLayout(SLspBanPn);
        SLspBanPn.setLayout(SLspBanPnLayout);
        SLspBanPnLayout.setHorizontalGroup(
                SLspBanPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SLspBanPnLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(SLspBanPnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Slmondabanngay, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        SLspBanPnLayout.setVerticalGroup(
                SLspBanPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SLspBanPnLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(Slmondabanngay, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        headerPanel.add(SLspBanPn);

        KhMoiPn.setBackground(new java.awt.Color(217, 217, 217));
        KhMoiPn.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel5.setBackground(new java.awt.Color(168, 154, 143));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Khách hàng mới");
        jLabel5.setOpaque(true);
        jLabel5.setPreferredSize(new java.awt.Dimension(200, 20));

        SoluongKH.setBackground(new java.awt.Color(217, 217, 217));
        SoluongKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SoluongKH.setText("100000");
        SoluongKH.setBorder(null);

        javax.swing.GroupLayout KhMoiPnLayout = new javax.swing.GroupLayout(KhMoiPn);
        KhMoiPn.setLayout(KhMoiPnLayout);
        KhMoiPnLayout.setHorizontalGroup(
                KhMoiPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KhMoiPnLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(KhMoiPnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(SoluongKH, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        KhMoiPnLayout.setVerticalGroup(
                KhMoiPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhMoiPnLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(SoluongKH, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        headerPanel.add(KhMoiPn);

        /////////////////////
        jTextField6.setText("jTextField6");
        jTextField6.setMinimumSize(new java.awt.Dimension(200, 22));
        jTextField6.setPreferredSize(new java.awt.Dimension(195, 50));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField7.setText("jTextField6");
        jTextField7.setMinimumSize(new java.awt.Dimension(200, 22));
        jTextField7.setPreferredSize(new java.awt.Dimension(195, 50));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField8.setText("jTextField6");
        jTextField8.setMinimumSize(new java.awt.Dimension(200, 22));
        jTextField8.setPreferredSize(new java.awt.Dimension(195, 50));
        jTextField8.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField11.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField12.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField13.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField14.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField15.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField16.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField17.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField18.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField19.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField20.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField11.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField12.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField13.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField14.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField15.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField16.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField17.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField18.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField19.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField20.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField6.setOpaque(false);
        jTextField7.setOpaque(false);
        jTextField8.setOpaque(false);
        jTextField9.setOpaque(false);
        jTextField10.setOpaque(false);
        jTextField11.setOpaque(false);
        jTextField12.setOpaque(false);
        jTextField13.setOpaque(false);
        jTextField14.setOpaque(false);
        jTextField15.setOpaque(false);
        jTextField16.setOpaque(false);
        jTextField17.setOpaque(false);
        jTextField18.setOpaque(false);
        jTextField19.setOpaque(false);
        jTextField20.setOpaque(false);
        jTextField6.setOpaque(false);
        jTextField7.setOpaque(false);
        jTextField8.setOpaque(false);
        jTextField9.setOpaque(false);
        jTextField10.setOpaque(false);
        jTextField11.setOpaque(false);
        jTextField12.setOpaque(false);
        jTextField13.setOpaque(false);
        jTextField14.setOpaque(false);
        jTextField15.setOpaque(false);
        jTextField16.setOpaque(false);
        jTextField17.setOpaque(false);
        jTextField18.setOpaque(false);
        jTextField19.setOpaque(false);
        jTextField20.setOpaque(false);
        jTextField6.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
        jTextField9.setEditable(false);
        jTextField10.setEditable(false);
        jTextField11.setEditable(false);
        jTextField12.setEditable(false);
        jTextField13.setEditable(false);
        jTextField14.setEditable(false);
        jTextField15.setEditable(false);
        jTextField16.setEditable(false);
        jTextField17.setEditable(false);
        jTextField18.setEditable(false);
        jTextField19.setEditable(false);
        jTextField20.setEditable(false);
        jLabel36.setOpaque(true);
        jLabel36.setBackground(new java.awt.Color(168, 154, 143));
        jLabel37.setOpaque(true);
        jLabel37.setBackground(new java.awt.Color(168, 154, 143));
        jLabel38.setOpaque(true);
        jLabel38.setBackground(new java.awt.Color(168, 154, 143));
        jLabel39.setOpaque(true);
        jLabel39.setBackground(new java.awt.Color(168, 154, 143));
        jLabel40.setOpaque(true);
        jLabel40.setBackground(new java.awt.Color(168, 154, 143));
        jLabel41.setOpaque(true);
        jLabel41.setBackground(new java.awt.Color(168, 154, 143));
        jLabel42.setOpaque(true);
        jLabel42.setBackground(new java.awt.Color(168, 154, 143));
        jLabel43.setOpaque(true);
        jLabel43.setBackground(new java.awt.Color(168, 154, 143));
        jLabel44.setOpaque(true);
        jLabel44.setBackground(new java.awt.Color(168, 154, 143));
        jLabel45.setOpaque(true);
        jLabel45.setBackground(new java.awt.Color(168, 154, 143));
        jLabel36.setOpaque(true);
        jLabel36.setBackground(new java.awt.Color(168, 154, 143));
        jLabel37.setOpaque(true);
        jLabel37.setBackground(new java.awt.Color(168, 154, 143));
        jLabel38.setOpaque(true);
        jLabel38.setBackground(new java.awt.Color(168, 154, 143));
        jLabel39.setOpaque(true);
        jLabel39.setBackground(new java.awt.Color(168, 154, 143));
        jLabel40.setOpaque(true);
        jLabel40.setBackground(new java.awt.Color(168, 154, 143));
        jLabel41.setOpaque(true);
        jLabel41.setBackground(new java.awt.Color(168, 154, 143));
        jLabel42.setOpaque(true);
        jLabel42.setBackground(new java.awt.Color(168, 154, 143));
        jLabel43.setOpaque(true);
        jLabel43.setBackground(new java.awt.Color(168, 154, 143));
        jLabel44.setOpaque(true);
        jLabel44.setBackground(new java.awt.Color(168, 154, 143));
        jLabel45.setOpaque(true);
        jLabel45.setBackground(new java.awt.Color(168, 154, 143));
        jLabel6.setOpaque(true);
        jLabel6.setBackground(new java.awt.Color(168, 154, 143));
        jLabel7.setOpaque(true);
        jLabel7.setBackground(new java.awt.Color(168, 154, 143));
        jLabel8.setOpaque(true);
        jLabel8.setBackground(new java.awt.Color(168, 154, 143));
        jLabel6.setOpaque(true);
        jLabel6.setBackground(new java.awt.Color(168, 154, 143));
        jLabel6.setText("Doanh thu hôm nay");
        jLabel7.setOpaque(true);
        jLabel7.setBackground(new java.awt.Color(168, 154, 143));
        jLabel7.setText("Doanh thu tháng " + date.toLocalDate().getMonthValue());
        jLabel8.setOpaque(true);
        jLabel8.setBackground(new java.awt.Color(168, 154, 143));
        jLabel8.setText("Doanh thu năm " + date.toLocalDate().getYear());

        // for(int i=6;i<=20;i++){
        // // System.out.println("jTextField"+i+".setFont(new java.awt.Font(\"Segoe
        // UI\", 1, 18));");
        // System.out.println("jTextField"+i+".setEditable(false);");

        // //
        // System.out.println("jTextField"+i+".setHorizontalAlignment(javax.swing.JTextField.CENTER);");
        // //
        // System.out.println("jTextField"+i+".setBorder(javax.swing.BorderFactory.createEmptyBorder(1,
        // 1, 1, 1));");
        // // System.out.println("jLabel"+i+".setOpaque(true);");
        // // System.out.println("jLabel"+i+".setBackground(new java.awt.Color(168, 154,
        // 143));");

        // }
        TongDtPn.setBackground(new java.awt.Color(217, 217, 217));
        TongDtPn.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel4.setBackground(new java.awt.Color(168, 154, 143));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tổng doanh thu");
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 20));

        Dthuthanghientai.setBackground(new java.awt.Color(217, 217, 217));
        Dthuthanghientai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Dthuthanghientai.setText("100000");
        Dthuthanghientai.setBorder(null);

        javax.swing.GroupLayout TongDtPnLayout = new javax.swing.GroupLayout(TongDtPn);
        TongDtPn.setLayout(TongDtPnLayout);
        TongDtPnLayout.setHorizontalGroup(
                TongDtPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TongDtPnLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(TongDtPnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Dthuthanghientai, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        TongDtPnLayout.setVerticalGroup(
                TongDtPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TongDtPnLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(Dthuthanghientai, javax.swing.GroupLayout.DEFAULT_SIZE, 38,
                                        Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        headerPanel.add(TongDtPn);

        content_Panel.setBackground(new java.awt.Color(219,189,142));
        content_Panel.setToolTipText("");
        content_Panel.setMaximumSize(new java.awt.Dimension(1090, 1000));
        content_Panel.setPreferredSize(new java.awt.Dimension(1090, 450));

        javax.swing.GroupLayout content_PanelLayout = new javax.swing.GroupLayout(content_Panel);
        content_Panel.setLayout(content_PanelLayout);
        content_PanelLayout.setHorizontalGroup(
                content_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1090, Short.MAX_VALUE));
        content_PanelLayout.setVerticalGroup(
                content_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 702, Short.MAX_VALUE));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(content_Panel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(content_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                                .addContainerGap()));

        Panel_default.add(jPanel5);

        DefaultTK.setViewportView(Panel_default);

        ThongkePanel.addTab("", DefaultTK);

        TK_doanhthu.setBackground(new java.awt.Color(219, 189, 142));
        TK_doanhthu.setPreferredSize(new java.awt.Dimension(1120, 450));

        PnDthu.setBackground(new java.awt.Color(204, 0, 51));
        PnDthu.setEnabled(false);
        PnDthu.setMaximumSize(new java.awt.Dimension(1000, 600));
        PnDthu.setPreferredSize(new java.awt.Dimension(1000, 1000));
        PnDthu.setLayout(new javax.swing.BoxLayout(PnDthu, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setBackground(new java.awt.Color(219, 189, 142));
        jPanel12.setMaximumSize(new java.awt.Dimension(1120, 32767));
        jPanel12.setPreferredSize(new java.awt.Dimension(1120, 667));

        DetailDtPn.setBackground(new java.awt.Color(219, 189, 142));
        DetailDtPn.setEnabled(false);
        DetailDtPn.setMaximumSize(new java.awt.Dimension(590, 600));
        DetailDtPn.setMinimumSize(new java.awt.Dimension(300, 218));
        DetailDtPn.setPreferredSize(new java.awt.Dimension(1125, 218));
        DetailDtPn.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 50, 5));

        TongDThungay.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel6.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout TongDThungayLayout = new javax.swing.GroupLayout(TongDThungay);
        TongDThungay.setLayout(TongDThungayLayout);
        TongDThungayLayout.setHorizontalGroup(
                TongDThungayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        TongDThungayLayout.setVerticalGroup(
                TongDThungayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TongDThungayLayout.createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        DetailDtPn.add(TongDThungay);

        DthuthangHtai.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout DthuthangHtaiLayout = new javax.swing.GroupLayout(DthuthangHtai);
        DthuthangHtai.setLayout(DthuthangHtaiLayout);
        DthuthangHtaiLayout.setHorizontalGroup(
                DthuthangHtaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(DthuthangHtaiLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        DthuthangHtaiLayout.setVerticalGroup(
                DthuthangHtaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                DthuthangHtaiLayout.createSequentialGroup()
                                        .addGap(0, 84, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        DetailDtPn.add(DthuthangHtai);

        DTnamHtai.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout DTnamHtaiLayout = new javax.swing.GroupLayout(DTnamHtai);
        DTnamHtai.setLayout(DTnamHtaiLayout);
        DTnamHtaiLayout.setHorizontalGroup(
                DTnamHtaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(DTnamHtaiLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        DTnamHtaiLayout.setVerticalGroup(
                DTnamHtaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DTnamHtaiLayout.createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        DetailDtPn.add(DTnamHtai);

        Main_DtPn.setBackground(new java.awt.Color(219, 189, 142));
        Main_DtPn.setToolTipText("");
        Main_DtPn.setMaximumSize(new java.awt.Dimension(1090, 1000));
        Main_DtPn.setPreferredSize(new java.awt.Dimension(1090, 450));
        Main_DtPn.setLayout(cardLayout);

        Main_DtPn1.setBackground(new java.awt.Color(219,189,142));
        Main_DtPn1.setToolTipText("");
        Main_DtPn1.setMaximumSize(new java.awt.Dimension(1090, 1000));
        Main_DtPn1.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout Main_DtPn1Layout = new javax.swing.GroupLayout(Main_DtPn1);
        Main_DtPn1.setLayout(Main_DtPn1Layout);
        Main_DtPn1Layout.setHorizontalGroup(
                Main_DtPn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1090, Short.MAX_VALUE));
        Main_DtPn1Layout.setVerticalGroup(
                Main_DtPn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        Main_DtPn.add(Main_DtPn1, "Tháng");

        Main_DtPn2.setBackground(new java.awt.Color(219,189,142));
        Main_DtPn2.setToolTipText("");
        Main_DtPn2.setMaximumSize(new java.awt.Dimension(1090, 1000));
        Main_DtPn2.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout Main_DtPn2Layout = new javax.swing.GroupLayout(Main_DtPn2);
        Main_DtPn2.setLayout(Main_DtPn2Layout);
        Main_DtPn2Layout.setHorizontalGroup(
                Main_DtPn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1090, Short.MAX_VALUE));
        Main_DtPn2Layout.setVerticalGroup(
                Main_DtPn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        Main_DtPn.add(Main_DtPn2, "Quý");

        selectPn.setBackground(new java.awt.Color(219, 189, 142));

        CbboxDthu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "Quý" }));
        CbboxDthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbboxDthuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectPnLayout = new javax.swing.GroupLayout(selectPn);
        selectPn.setLayout(selectPnLayout);
        selectPnLayout.setHorizontalGroup(
                selectPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectPnLayout.createSequentialGroup()
                                .addContainerGap(144, Short.MAX_VALUE)
                                .addComponent(CbboxDthu, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        selectPnLayout.setVerticalGroup(
                selectPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(selectPnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CbboxDthu, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel12Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Main_DtPn, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(DetailDtPn, javax.swing.GroupLayout.PREFERRED_SIZE, 797,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(selectPn, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel12Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DetailDtPn, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectPn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Main_DtPn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        PnDthu.add(jPanel12);

        TK_doanhthu.setViewportView(PnDthu);

        ThongkePanel.addTab("", TK_doanhthu);

        TK_chiphi.setBackground(new java.awt.Color(219, 189, 142));
        TK_chiphi.setPreferredSize(new java.awt.Dimension(1120, 450));

        //////////////////////
        jTextField9.setText("jTextField6");
        jTextField9.setMinimumSize(new java.awt.Dimension(200, 22));
        jTextField9.setPreferredSize(new java.awt.Dimension(195, 50));
        jTextField10.setText("jTextField6");
        jTextField10.setMinimumSize(new java.awt.Dimension(200, 22));
        jTextField10.setPreferredSize(new java.awt.Dimension(195, 50));
        jTextField11.setText("jTextField6");
        jTextField11.setMinimumSize(new java.awt.Dimension(200, 22));
        jTextField11.setPreferredSize(new java.awt.Dimension(195, 50));

        jPanel18.setBackground(new java.awt.Color(204, 0, 51));
        jPanel18.setEnabled(false);
        jPanel18.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel18.setPreferredSize(new java.awt.Dimension(1000, 1000));
        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.Y_AXIS));

        jPanel65.setBackground(new java.awt.Color(219, 189, 142));
        jPanel65.setMaximumSize(new java.awt.Dimension(1122, 32767));
        jPanel65.setPreferredSize(new java.awt.Dimension(1120, 1000));

        DetailChiphi.setBackground(new java.awt.Color(219, 189, 142));
        DetailChiphi.setEnabled(false);
        DetailChiphi.setMaximumSize(new java.awt.Dimension(590, 600));
        DetailChiphi.setMinimumSize(new java.awt.Dimension(300, 218));
        DetailChiphi.setPreferredSize(new java.awt.Dimension(1125, 218));
        DetailChiphi.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 50, 5));

        ChiphiPnhapHtai.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel9.setBackground(new java.awt.Color(168, 154, 143));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Chi phi nhập hàng tháng " + date.toLocalDate().getMonthValue());
        jLabel9.setPreferredSize(new java.awt.Dimension(200, 20));
        jLabel9.setOpaque(true);

        javax.swing.GroupLayout ChiphiPnhapHtaiLayout = new javax.swing.GroupLayout(ChiphiPnhapHtai);
        ChiphiPnhapHtai.setLayout(ChiphiPnhapHtaiLayout);
        ChiphiPnhapHtaiLayout.setHorizontalGroup(
                ChiphiPnhapHtaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        ChiphiPnhapHtaiLayout.setVerticalGroup(
                ChiphiPnhapHtaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                ChiphiPnhapHtaiLayout.createSequentialGroup()
                                        .addGap(0, 84, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );

        DetailChiphi.add(ChiphiPnhapHtai);

        ChiphiluongNV.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel10.setBackground(new java.awt.Color(168, 154, 143));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Chi phí luong nhân viên tháng " + date.toLocalDate().getMonthValue());
        jLabel10.setPreferredSize(new java.awt.Dimension(200, 20));
        jLabel10.setOpaque(true);

        javax.swing.GroupLayout ChiphiluongNVLayout = new javax.swing.GroupLayout(ChiphiluongNV);
        ChiphiluongNV.setLayout(ChiphiluongNVLayout);
        ChiphiluongNVLayout.setHorizontalGroup(
                ChiphiluongNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(ChiphiluongNVLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        ChiphiluongNVLayout.setVerticalGroup(
                ChiphiluongNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                ChiphiluongNVLayout.createSequentialGroup()
                                        .addGap(0, 84, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );

        DetailChiphi.add(ChiphiluongNV);

        TongchiphiThang.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel36.setBackground(new java.awt.Color(168, 154, 143));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Tổng chi phí tháng " + date.toLocalDate().getMonthValue());
        jLabel36.setPreferredSize(new java.awt.Dimension(200, 20));
        jLabel36.setOpaque(true);

        javax.swing.GroupLayout TongchiphiThangLayout = new javax.swing.GroupLayout(TongchiphiThang);
        TongchiphiThang.setLayout(TongchiphiThangLayout);
        TongchiphiThangLayout.setHorizontalGroup(
                TongchiphiThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(TongchiphiThangLayout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        TongchiphiThangLayout.setVerticalGroup(
                TongchiphiThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                TongchiphiThangLayout.createSequentialGroup()
                                        .addGap(0, 84, Short.MAX_VALUE)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );

        DetailChiphi.add(TongchiphiThang);

        ContentCphi.setBackground(new java.awt.Color(219, 189, 142));
        ContentCphi.setToolTipText("");
        ContentCphi.setMaximumSize(new java.awt.Dimension(1090, 1000));
        ContentCphi.setPreferredSize(new java.awt.Dimension(1090, 450));
        ContentCphi.setLayout(cardLayout1);

        ContentCphi1.setBackground(new java.awt.Color(219,189,142));
        ContentCphi1.setToolTipText("");
        ContentCphi1.setMaximumSize(new java.awt.Dimension(1090, 1000));
        ContentCphi1.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout ContentCphi1Layout = new javax.swing.GroupLayout(ContentCphi1);
        ContentCphi1.setLayout(ContentCphi1Layout);
        ContentCphi1Layout.setHorizontalGroup(
                ContentCphi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1090, Short.MAX_VALUE));
        ContentCphi1Layout.setVerticalGroup(
                ContentCphi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        ContentCphi.add(ContentCphi1, "Tháng");

        ContentCphi2.setBackground(new java.awt.Color(219,189,142));
        ContentCphi2.setToolTipText("");
        ContentCphi2.setMaximumSize(new java.awt.Dimension(1090, 1000));
        ContentCphi2.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout ContentCphi2Layout = new javax.swing.GroupLayout(ContentCphi2);
        ContentCphi2.setLayout(ContentCphi2Layout);
        ContentCphi2Layout.setHorizontalGroup(
                ContentCphi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1090, Short.MAX_VALUE));
        ContentCphi2Layout.setVerticalGroup(
                ContentCphi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        ContentCphi.add(ContentCphi2, "Quý");

        selectPnCphi.setBackground(new java.awt.Color(219, 189, 142));

        CbboxChiphi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "Quý" }));
        CbboxChiphi.setToolTipText("");
        CbboxChiphi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbboxChiphiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectPnCphiLayout = new javax.swing.GroupLayout(selectPnCphi);
        selectPnCphi.setLayout(selectPnCphiLayout);
        selectPnCphiLayout.setHorizontalGroup(
                selectPnCphiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectPnCphiLayout.createSequentialGroup()
                                .addContainerGap(144, Short.MAX_VALUE)
                                .addComponent(CbboxChiphi, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        selectPnCphiLayout.setVerticalGroup(
                selectPnCphiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(selectPnCphiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CbboxChiphi, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
                jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel65Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel65Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ContentCphi, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel65Layout.createSequentialGroup()
                                                .addComponent(DetailChiphi, javax.swing.GroupLayout.PREFERRED_SIZE, 797,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(selectPnCphi, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel65Layout.setVerticalGroup(
                jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel65Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel65Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(DetailChiphi, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectPnCphi, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ContentCphi, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        jPanel18.add(jPanel65);

        TK_chiphi.setViewportView(jPanel18);

        ThongkePanel.addTab("", TK_chiphi);

        TK_loinhuan.setBackground(new java.awt.Color(219, 189, 142));
        TK_loinhuan.setPreferredSize(new java.awt.Dimension(1120, 450));

        //////////////////////
        jTextField18.setText("jTextField18");
        jTextField18.setPreferredSize(new java.awt.Dimension(195, 50));
        jTextField19.setText("jTextField18");
        jTextField19.setPreferredSize(new java.awt.Dimension(195, 50));
        jTextField20.setText("jTextField18");
        jTextField20.setPreferredSize(new java.awt.Dimension(195, 50));

        jPanel72.setBackground(new java.awt.Color(204, 0, 51));
        jPanel72.setEnabled(false);
        jPanel72.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel72.setPreferredSize(new java.awt.Dimension(1000, 1000));
        jPanel72.setLayout(new javax.swing.BoxLayout(jPanel72, javax.swing.BoxLayout.Y_AXIS));

        jPanel73.setBackground(new java.awt.Color(219, 189, 142));
        jPanel73.setMaximumSize(new java.awt.Dimension(1122, 32767));
        jPanel73.setPreferredSize(new java.awt.Dimension(1120, 1000));

        detailLoinhuan.setBackground(new java.awt.Color(219, 189, 142));
        detailLoinhuan.setEnabled(false);
        detailLoinhuan.setMaximumSize(new java.awt.Dimension(590, 600));
        detailLoinhuan.setMinimumSize(new java.awt.Dimension(300, 218));
        detailLoinhuan.setPreferredSize(new java.awt.Dimension(1125, 218));
        detailLoinhuan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 50, 5));

        Loinhuanngay.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Lợi nhuận hôm nay");
        jLabel37.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout LoinhuanngayLayout = new javax.swing.GroupLayout(Loinhuanngay);
        Loinhuanngay.setLayout(LoinhuanngayLayout);
        LoinhuanngayLayout.setHorizontalGroup(
                LoinhuanngayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        LoinhuanngayLayout.setVerticalGroup(
                LoinhuanngayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoinhuanngayLayout.createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );

        detailLoinhuan.add(Loinhuanngay);

        Loinhuanthang.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Lợi nhuận tháng " + date.toLocalDate().getMonthValue());
        jLabel38.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout LoinhuanthangLayout = new javax.swing.GroupLayout(Loinhuanthang);
        Loinhuanthang.setLayout(LoinhuanthangLayout);
        LoinhuanthangLayout.setHorizontalGroup(
                LoinhuanthangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(LoinhuanthangLayout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        LoinhuanthangLayout.setVerticalGroup(
                LoinhuanthangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                LoinhuanthangLayout.createSequentialGroup()
                                        .addGap(0, 84, Short.MAX_VALUE)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );

        detailLoinhuan.add(Loinhuanthang);

        LoinhanTong.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Tổng lợi nhuận năm " + date.toLocalDate().getYear());
        jLabel39.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout LoinhanTongLayout = new javax.swing.GroupLayout(LoinhanTong);
        LoinhanTong.setLayout(LoinhanTongLayout);
        LoinhanTongLayout.setHorizontalGroup(
                LoinhanTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(LoinhanTongLayout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        LoinhanTongLayout.setVerticalGroup(
                LoinhanTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoinhanTongLayout.createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );

        detailLoinhuan.add(LoinhanTong);

        contentTKLnhuan.setBackground(new java.awt.Color(219, 189, 142));
        contentTKLnhuan.setToolTipText("");
        contentTKLnhuan.setMaximumSize(new java.awt.Dimension(1090, 1000));
        contentTKLnhuan.setPreferredSize(new java.awt.Dimension(1090, 450));
        contentTKLnhuan.setLayout(cardLayout2);

        contentTKLnhuan1.setBackground(new java.awt.Color(219,189,142));
        contentTKLnhuan1.setToolTipText("");
        contentTKLnhuan1.setMaximumSize(new java.awt.Dimension(1090, 1000));
        contentTKLnhuan1.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout contentTKLnhuan1Layout = new javax.swing.GroupLayout(contentTKLnhuan1);
        contentTKLnhuan1.setLayout(contentTKLnhuan1Layout);
        contentTKLnhuan1Layout.setHorizontalGroup(
                contentTKLnhuan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1090, Short.MAX_VALUE));
        contentTKLnhuan1Layout.setVerticalGroup(
                contentTKLnhuan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        contentTKLnhuan.add(contentTKLnhuan1, "Tháng");

        contentTKLnhuan2.setBackground(new java.awt.Color(219,189,142));
        contentTKLnhuan2.setToolTipText("");
        contentTKLnhuan2.setMaximumSize(new java.awt.Dimension(1090, 1000));
        contentTKLnhuan2.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout contentTKLnhuan2Layout = new javax.swing.GroupLayout(contentTKLnhuan2);
        contentTKLnhuan2.setLayout(contentTKLnhuan2Layout);
        contentTKLnhuan2Layout.setHorizontalGroup(
                contentTKLnhuan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1090, Short.MAX_VALUE));
        contentTKLnhuan2Layout.setVerticalGroup(
                contentTKLnhuan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        contentTKLnhuan.add(contentTKLnhuan2, "Quý");

        selectPnLoinhuan.setBackground(new java.awt.Color(219, 189, 142));

        CbboxLoinhuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "Quý" }));
        CbboxLoinhuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbboxLoinhuanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectPnLoinhuanLayout = new javax.swing.GroupLayout(selectPnLoinhuan);
        selectPnLoinhuan.setLayout(selectPnLoinhuanLayout);
        selectPnLoinhuanLayout.setHorizontalGroup(
                selectPnLoinhuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                selectPnLoinhuanLayout.createSequentialGroup()
                                        .addContainerGap(144, Short.MAX_VALUE)
                                        .addComponent(CbboxLoinhuan, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()));
        selectPnLoinhuanLayout.setVerticalGroup(
                selectPnLoinhuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(selectPnLoinhuanLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CbboxLoinhuan, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
                jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel73Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel73Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(contentTKLnhuan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel73Layout.createSequentialGroup()
                                                .addComponent(detailLoinhuan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        797, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(selectPnLoinhuan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel73Layout.setVerticalGroup(
                jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel73Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel73Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(detailLoinhuan, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectPnLoinhuan, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contentTKLnhuan, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        jPanel72.add(jPanel73);

        TK_loinhuan.setViewportView(jPanel72);

        ThongkePanel.addTab("", TK_loinhuan);

        TK_luong.setBackground(new java.awt.Color(219, 189, 142));
        TK_luong.setPreferredSize(new java.awt.Dimension(1120, 450));
        //////////////////////////
        jTextField12.setText("jTextField12");
        jTextField12.setMinimumSize(new java.awt.Dimension(195, 50));
        jTextField12.setPreferredSize(new java.awt.Dimension(195, 55));
        jTextField13.setText("jTextField12");
        jTextField13.setMinimumSize(new java.awt.Dimension(195, 50));
        jTextField13.setPreferredSize(new java.awt.Dimension(195, 55));
        jTextField14.setText("jTextField12");
        jTextField14.setMinimumSize(new java.awt.Dimension(195, 50));
        jTextField14.setPreferredSize(new java.awt.Dimension(195, 55));

        jPanel80.setBackground(new java.awt.Color(204, 0, 51));
        jPanel80.setEnabled(false);
        jPanel80.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel80.setPreferredSize(new java.awt.Dimension(1000, 1000));
        jPanel80.setLayout(new javax.swing.BoxLayout(jPanel80, javax.swing.BoxLayout.Y_AXIS));

        jPanel81.setBackground(new java.awt.Color(219, 189, 142));
        jPanel81.setMaximumSize(new java.awt.Dimension(1122, 32767));
        jPanel81.setPreferredSize(new java.awt.Dimension(1120, 1000));

        detailLuong.setBackground(new java.awt.Color(219, 189, 142));
        detailLuong.setEnabled(false);
        detailLuong.setMaximumSize(new java.awt.Dimension(590, 600));
        detailLuong.setMinimumSize(new java.awt.Dimension(300, 218));
        detailLuong.setPreferredSize(new java.awt.Dimension(1125, 218));
        detailLuong.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 50, 5));

        SluongNV.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Sô lượng nhân viên");
        jLabel40.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout SluongNVLayout = new javax.swing.GroupLayout(SluongNV);
        SluongNV.setLayout(SluongNVLayout);
        SluongNVLayout.setHorizontalGroup(
                SluongNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        SluongNVLayout.setVerticalGroup(
                SluongNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SluongNVLayout.createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        detailLuong.add(SluongNV);

        TongluongnvThang.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Tổng lương nhân viên tháng " + date.toLocalDate().getMonthValue());
        jLabel41.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout TongluongnvThangLayout = new javax.swing.GroupLayout(TongluongnvThang);
        TongluongnvThang.setLayout(TongluongnvThangLayout);
        TongluongnvThangLayout.setHorizontalGroup(
                TongluongnvThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(TongluongnvThangLayout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        TongluongnvThangLayout.setVerticalGroup(
                TongluongnvThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TongluongnvThangLayout
                                .createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        detailLuong.add(TongluongnvThang);

        TongLuongnvnam.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Tổng lương nhân viên năm " + date.toLocalDate().getYear());
        jLabel42.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout TongLuongnvnamLayout = new javax.swing.GroupLayout(TongLuongnvnam);
        TongLuongnvnam.setLayout(TongLuongnvnamLayout);
        TongLuongnvnamLayout.setHorizontalGroup(
                TongLuongnvnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(TongLuongnvnamLayout.createSequentialGroup()
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        TongLuongnvnamLayout.setVerticalGroup(
                TongLuongnvnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                TongLuongnvnamLayout.createSequentialGroup()
                                        .addGap(0, 84, Short.MAX_VALUE)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );

        detailLuong.add(TongLuongnvnam);

        ContentLuong.setBackground(new java.awt.Color(219, 189, 142));
        ContentLuong.setToolTipText("");
        ContentLuong.setMaximumSize(new java.awt.Dimension(1090, 1000));
        ContentLuong.setPreferredSize(new java.awt.Dimension(1090, 450));
        ContentLuong.setLayout(cardLayout3);

        ContentLuong1.setBackground(new java.awt.Color(219,189,142));
        ContentLuong1.setToolTipText("");
        ContentLuong1.setMaximumSize(new java.awt.Dimension(1090, 1000));
        ContentLuong1.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout ContentLuong1Layout = new javax.swing.GroupLayout(ContentLuong1);
        ContentLuong1.setLayout(ContentLuong1Layout);
        ContentLuong1Layout.setHorizontalGroup(
                ContentLuong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        ContentLuong1Layout.setVerticalGroup(
                ContentLuong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        ContentLuong.add(ContentLuong1, "Tháng");

        ContentLuong2.setBackground(new java.awt.Color(2, 189, 1));
        ContentLuong2.setToolTipText("");
        ContentLuong2.setMaximumSize(new java.awt.Dimension(1090, 1000));
        ContentLuong2.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout ContentLuong2Layout = new javax.swing.GroupLayout(ContentLuong2);
        ContentLuong2.setLayout(ContentLuong2Layout);
        ContentLuong2Layout.setHorizontalGroup(
                ContentLuong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        ContentLuong2Layout.setVerticalGroup(
                ContentLuong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        ContentLuong.add(ContentLuong2, "Quý");

        selectPnLuong.setBackground(new java.awt.Color(219, 189, 142));

        CbboxLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "Quý" }));
        CbboxLuong.setVisible(false);
        CbboxLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbboxLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectPnLuongLayout = new javax.swing.GroupLayout(selectPnLuong);
        selectPnLuong.setLayout(selectPnLuongLayout);
        selectPnLuongLayout.setHorizontalGroup(
                selectPnLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                selectPnLuongLayout.createSequentialGroup()
                                        .addContainerGap(144, Short.MAX_VALUE)
                                        .addComponent(CbboxLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()));
        selectPnLuongLayout.setVerticalGroup(
                selectPnLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(selectPnLuongLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CbboxLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
                jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel81Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel81Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ContentLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel81Layout.createSequentialGroup()
                                                .addComponent(detailLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 797,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(selectPnLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel81Layout.setVerticalGroup(
                jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel81Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel81Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(detailLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectPnLuong, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ContentLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                                .addContainerGap()));

        jPanel80.add(jPanel81);

        TK_luong.setViewportView(jPanel80);

        ThongkePanel.addTab("", TK_luong);

        TK_khohang.setBackground(new java.awt.Color(219, 189, 142));
        TK_khohang.setPreferredSize(new java.awt.Dimension(1120, 450));
        ////////////////////////////
        jTextField15.setText("jTextField15");
        jTextField15.setMinimumSize(new java.awt.Dimension(195, 50));
        jTextField15.setPreferredSize(new java.awt.Dimension(195, 55));
        jTextField16.setText("jTextField15");
        jTextField16.setMinimumSize(new java.awt.Dimension(195, 50));
        jTextField16.setPreferredSize(new java.awt.Dimension(195, 55));
        jTextField17.setText("jTextField15");
        jTextField17.setMinimumSize(new java.awt.Dimension(195, 50));
        jTextField17.setPreferredSize(new java.awt.Dimension(195, 55));

        jPanel88.setBackground(new java.awt.Color(204, 0, 51));
        jPanel88.setEnabled(false);
        jPanel88.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel88.setPreferredSize(new java.awt.Dimension(1000, 1000));
        jPanel88.setLayout(new javax.swing.BoxLayout(jPanel88, javax.swing.BoxLayout.Y_AXIS));

        jPanel89.setBackground(new java.awt.Color(219, 189, 142));
        jPanel89.setMaximumSize(new java.awt.Dimension(1122, 32767));
        jPanel89.setPreferredSize(new java.awt.Dimension(1120, 1000));

        detailKhohang.setBackground(new java.awt.Color(219, 189, 142));
        detailKhohang.setEnabled(false);
        detailKhohang.setMaximumSize(new java.awt.Dimension(590, 600));
        detailKhohang.setMinimumSize(new java.awt.Dimension(300, 218));
        detailKhohang.setPreferredSize(new java.awt.Dimension(1125, 218));
        detailKhohang.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 50, 5));

        SoluongPhieunhap.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Sô lượng phiếu nhập");
        jLabel43.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout SoluongPhieunhapLayout = new javax.swing.GroupLayout(SoluongPhieunhap);
        SoluongPhieunhap.setLayout(SoluongPhieunhapLayout);
        SoluongPhieunhapLayout.setHorizontalGroup(
                SoluongPhieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        SoluongPhieunhapLayout.setVerticalGroup(
                SoluongPhieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SoluongPhieunhapLayout
                                .createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        detailKhohang.add(SoluongPhieunhap);

        SoluongNguyenlieu.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Số lượng nguyên liệu");
        jLabel44.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout SoluongNguyenlieuLayout = new javax.swing.GroupLayout(SoluongNguyenlieu);
        SoluongNguyenlieu.setLayout(SoluongNguyenlieuLayout);
        SoluongNguyenlieuLayout.setHorizontalGroup(
                SoluongNguyenlieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(SoluongNguyenlieuLayout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        SoluongNguyenlieuLayout.setVerticalGroup(
                SoluongNguyenlieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SoluongNguyenlieuLayout
                                .createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        detailKhohang.add(SoluongNguyenlieu);

        SoluongNcc.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Số lượng nhà cung cấp");
        jLabel45.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout SoluongNccLayout = new javax.swing.GroupLayout(SoluongNcc);
        SoluongNcc.setLayout(SoluongNccLayout);
        SoluongNccLayout.setHorizontalGroup(
                SoluongNccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(SoluongNccLayout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

        );
        SoluongNccLayout.setVerticalGroup(
                SoluongNccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SoluongNccLayout.createSequentialGroup()
                                .addGap(0, 84, Short.MAX_VALUE)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        detailKhohang.add(SoluongNcc);

        ContentKhohang.setBackground(new java.awt.Color(219, 189, 142));
        ContentKhohang.setToolTipText("");
        ContentKhohang.setMaximumSize(new java.awt.Dimension(1090, 1000));
        ContentKhohang.setPreferredSize(new java.awt.Dimension(1090, 450));
        ContentKhohang.setLayout(cardLayout4);

        ContentKhohang1.setBackground(new java.awt.Color(219,189,142));
        ContentKhohang1.setToolTipText("");
        ContentKhohang1.setMaximumSize(new java.awt.Dimension(1090, 1000));
        ContentKhohang1.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout ContentKhohang1Layout = new javax.swing.GroupLayout(ContentKhohang1);
        ContentKhohang1.setLayout(ContentKhohang1Layout);
        ContentKhohang1Layout.setHorizontalGroup(
                ContentKhohang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1090, Short.MAX_VALUE));
        ContentKhohang1Layout.setVerticalGroup(
                ContentKhohang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        ContentKhohang.add(ContentKhohang1, "Tháng");

        ContentKhohang3.setBackground(new java.awt.Color(219, 19, 142));
        ContentKhohang3.setToolTipText("");
        ContentKhohang3.setMaximumSize(new java.awt.Dimension(1090, 1000));
        ContentKhohang3.setPreferredSize(new java.awt.Dimension(1090, 702));

        javax.swing.GroupLayout ContentKhohang3Layout = new javax.swing.GroupLayout(ContentKhohang3);
        ContentKhohang3.setLayout(ContentKhohang3Layout);
        ContentKhohang3Layout.setHorizontalGroup(
                ContentKhohang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1090, Short.MAX_VALUE));
        ContentKhohang3Layout.setVerticalGroup(
                ContentKhohang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 862, Short.MAX_VALUE));

        ContentKhohang.add(ContentKhohang3, "Quý");

        selectKhohang.setBackground(new java.awt.Color(219, 189, 142));

        CbboxKhohang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "Quý" }));
        CbboxKhohang.setVisible(false);
        CbboxKhohang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbboxKhohangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectKhohangLayout = new javax.swing.GroupLayout(selectKhohang);
        selectKhohang.setLayout(selectKhohangLayout);
        selectKhohangLayout.setHorizontalGroup(
                selectKhohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                selectKhohangLayout.createSequentialGroup()
                                        .addContainerGap(144, Short.MAX_VALUE)
                                        .addComponent(CbboxKhohang, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()));
        selectKhohangLayout.setVerticalGroup(
                selectKhohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(selectKhohangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CbboxKhohang, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
                jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel89Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel89Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ContentKhohang, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel89Layout.createSequentialGroup()
                                                .addComponent(detailKhohang, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        797, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(selectKhohang, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel89Layout.setVerticalGroup(
                jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel89Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel89Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(detailKhohang, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectKhohang, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ContentKhohang, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        jPanel88.add(jPanel89);

        TK_khohang.setViewportView(jPanel88);

        ThongkePanel.addTab("", TK_khohang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(HeaderTk, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ThongkePanel, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap())));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 658, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(HeaderTk, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ThongkePanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 9, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Thống Kê");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đặt hành động khi đóng cửa sổ
                frame.setSize(1150, 690); // Thiết lập kích thước cho JFrame

                n10_ThongkePanel n10 = new n10_ThongkePanel();
                n10.initComponents(); // Khởi tạo các thành phần trong JPanel
                n10.addControl();
                n10.initUI();
                n10.setVisible(true);

                frame.add(n10); // Thêm JPanel vào JFrame
                frame.setVisible(true); // Hiển thị JFrame
            }
        });
    }

    // GEN-LAST:event_BtnExportActionPerformed

    private void Combobox_TKActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Combobox_TKActionPerformed
        int selectedIndex = Combobox_TK.getSelectedIndex();
        ThongkePanel.setSelectedIndex(selectedIndex);
        

    }// GEN-LAST:event_Combobox_TKActionPerformed

    private void CbboxDthuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CbboxDthuActionPerformed
        String selectedCard = (String) CbboxDthu.getSelectedItem();
        // Chuyển sang trang tương ứng
        cardLayout.show(Main_DtPn, selectedCard);
    }// GEN-LAST:event_CbboxDthuActionPerformed

    private void CbboxChiphiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CbboxChiphiActionPerformed
        String selectedCard = (String) CbboxChiphi.getSelectedItem();
        // Chuyển sang trang tương ứng
        cardLayout1.show(ContentCphi, selectedCard);
    }// GEN-LAST:event_CbboxChiphiActionPerformed

    private void CbboxLoinhuanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CbboxLoinhuanActionPerformed
        String selectedCard = (String) CbboxLoinhuan.getSelectedItem();
        // Chuyển sang trang tương ứng
        cardLayout2.show(contentTKLnhuan, selectedCard);
    }// GEN-LAST:event_CbboxLoinhuanActionPerformed

    private void CbboxKhohangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CbboxKhohangActionPerformed
        String selectedCard = (String) CbboxKhohang.getSelectedItem();
        // Chuyển sang trang tương ứng
        cardLayout4.show(ContentKhohang, selectedCard);
    }// GEN-LAST:event_CbboxKhohangActionPerformed

    private void CbboxLuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CbboxLuongActionPerformed
        String selectedCard = (String) CbboxLuong.getSelectedItem();
        // Chuyển sang trang tương ứng
        cardLayout3.show(ContentLuong, selectedCard);
    }// GEN-LAST:event_CbboxLuongActionPerformed
    public String toCurrency(int giaTien) {
        // Sử dụng NumberFormat để định dạng tiền tệ
       NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("vi-VN"));
       String formattedNumber = numberFormat.format(giaTien);
       // Thêm ký hiệu tiền tệ "đ"
       return formattedNumber + "đ";
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExport;
    private javax.swing.JComboBox<String> CbboxChiphi;
    private javax.swing.JComboBox<String> CbboxDthu;
    private javax.swing.JComboBox<String> CbboxKhohang;
    private javax.swing.JComboBox<String> CbboxLoinhuan;
    private javax.swing.JComboBox<String> CbboxLuong;
    private javax.swing.JComboBox<String> Combobox_TK;
    private javax.swing.JPanel ContentCphi;
    private javax.swing.JPanel ContentCphi1;
    private javax.swing.JPanel ContentCphi2;
    private javax.swing.JPanel ContentKhohang;
    private javax.swing.JPanel ContentKhohang1;
    private javax.swing.JPanel ContentKhohang3;
    private javax.swing.JPanel ContentLuong;
    private javax.swing.JPanel ContentLuong1;
    private javax.swing.JPanel ContentLuong2;
    private javax.swing.JPanel DTnamHtai;
    private javax.swing.JScrollPane DefaultTK;
    private javax.swing.JPanel DetailChiphi;
    private javax.swing.JPanel DetailDtPn;
    private javax.swing.JPanel DtNgayPn;
    private javax.swing.JPanel DthuthangHtai;
    private javax.swing.JPanel HeaderTk;
    private javax.swing.JPanel KhMoiPn;
    private javax.swing.JPanel Main_DtPn;
    private javax.swing.JPanel Main_DtPn1;
    private javax.swing.JPanel Main_DtPn2;
    private javax.swing.JPanel Panel_default;
    private javax.swing.JPanel PnDthu;
    private javax.swing.JPanel SLdonhangPn;
    private javax.swing.JPanel SLspBanPn;
    private javax.swing.JScrollPane TK_chiphi;
    private javax.swing.JScrollPane TK_doanhthu;
    private javax.swing.JScrollPane TK_khohang;
    private javax.swing.JScrollPane TK_loinhuan;
    private javax.swing.JScrollPane TK_luong;
    private javax.swing.JTabbedPane ThongkePanel;
    private javax.swing.JPanel TongDThungay;
    private javax.swing.JPanel TongDtPn;
    private javax.swing.JPanel contentTKLnhuan;
    private javax.swing.JPanel contentTKLnhuan1;
    private javax.swing.JPanel contentTKLnhuan2;
    private javax.swing.JPanel content_Panel;
    private javax.swing.JPanel detailKhohang;
    private javax.swing.JPanel detailLoinhuan;
    private javax.swing.JPanel detailLuong;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel ChiphiPnhapHtai;
    private javax.swing.JPanel ChiphiluongNV;
    private javax.swing.JPanel TongchiphiThang;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel Loinhuanngay;
    private javax.swing.JPanel Loinhuanthang;
    private javax.swing.JPanel LoinhanTong;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel SluongNV;
    private javax.swing.JPanel TongluongnvThang;
    private javax.swing.JPanel TongLuongnvnam;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel SoluongPhieunhap;
    private javax.swing.JPanel SoluongNguyenlieu;
    private javax.swing.JPanel SoluongNcc;
    private javax.swing.JTextField txtSLHoadonngay;
    private javax.swing.JTextField txtDthungay;
    private javax.swing.JTextField Slmondabanngay;
    private javax.swing.JTextField SoluongKH;
    private javax.swing.JTextField Dthuthanghientai;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JPanel selectKhohang;
    private javax.swing.JPanel selectPn;
    private javax.swing.JPanel selectPnCphi;
    private javax.swing.JPanel selectPnLoinhuan;
    private javax.swing.JPanel selectPnLuong;
    JTable tableDf = new JTable();
    JTable tableDfquy = new JTable();
    JTable tableDT = new JTable();
    JTable tableDTquy = new JTable();
    JTable tableCP = new JTable();
    JTable tableCPquy = new JTable();
    JTable tableLN = new JTable();
    JTable tableLNquy = new JTable();
    JTable tableLuong = new JTable();
    JTable tableKho = new JTable();
    // End of variables declaration//GEN-END:variables
}
