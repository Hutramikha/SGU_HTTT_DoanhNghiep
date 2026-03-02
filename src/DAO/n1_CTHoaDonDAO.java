package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChiTietHoaDonDTO;
import Util.JDBCUtil;

public class n1_CTHoaDonDAO {

    public static n1_HoaDonDAO getInstance() {
        return new n1_HoaDonDAO();
    }
    
    public ArrayList<ChiTietHoaDonDTO> getListCTHD(){
        ArrayList<ChiTietHoaDonDTO> lsCTHD = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM ChiTietHoaDon";
            Statement stmt = JDBCUtil.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                ChiTietHoaDonDTO tempCTHD = new ChiTietHoaDonDTO();
                tempCTHD.setMaHoaDon(rs.getString(1));
                tempCTHD.setMaMon(rs.getString(2));
                tempCTHD.setDonGia(rs.getInt(3));
                tempCTHD.setThanhTien(rs.getInt(4));
                tempCTHD.setSoLuong(rs.getInt(5));
                lsCTHD.add(tempCTHD);
            }
        }
        catch (SQLException ex){
        }
        return lsCTHD;
    }
    public boolean addCTHoaDon(ChiTietHoaDonDTO cthd) {
        boolean result = false;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "INSERT INTO ChiTietHoaDon VALUES(?,?,?,?,?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, cthd.getMaHoaDon());
            prep.setString(2, cthd.getMaMon());
            prep.setInt(3, cthd.getDonGia());
            prep.setInt(4, cthd.getThanhTien());
            prep.setInt(5, cthd.getSoLuong());
            result = prep.executeUpdate() > 0;
            JDBCUtil.closeConnection(c);
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }
    public boolean updateCTHoaDon(String MaHoaDon, String MaMon, ChiTietHoaDonDTO cthd) {
        boolean result = false;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "UPDATE ChiTietHoaDon SET MaHoaDon=?, MaMon=?, DonGia=?, ThanhTien=?, SoLuong=? " + "WHERE MaHoaDon=? AND MaMon  =?";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, cthd.getMaHoaDon());
            prep.setString(2, cthd.getMaMon());
            prep.setInt(3, cthd.getDonGia());
            prep.setInt(4, cthd.getThanhTien());
            prep.setInt(5, cthd.getSoLuong());
            prep.setString(6, MaHoaDon);
            prep.setString(7, MaMon);
            result = prep.executeUpdate() > 0;
            JDBCUtil.closeConnection(c);
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }

    public static void main(String[] args) {
        n1_CTHoaDonDAO list = new n1_CTHoaDonDAO();
        ChiTietHoaDonDTO new1 = new ChiTietHoaDonDTO("HD003", "M002", 30000, 30000, 1);
        list.updateCTHoaDon("HD003","M002",new1);
        ArrayList<ChiTietHoaDonDTO> listcthd = list.getListCTHD();
        System.out.println(listcthd);
    }
}
