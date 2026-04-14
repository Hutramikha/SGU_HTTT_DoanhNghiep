package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.MonDTO;
import Util.JDBCUtil;

public class n4_MonDAO {

    public static n4_MonDAO getInstance() {
        return new n4_MonDAO();
    }

    public ArrayList<MonDTO> getAll() {
        ArrayList<MonDTO> listMon = new ArrayList<>();
        String sql = "SELECT * FROM Mon WHERE TrangThaiMon = 1";
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(sql);
                ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                String maMon = rs.getString(1);
                String maLoaiMon = rs.getString(2);
                String tenMon = rs.getString(3);
                String hinhAnh = rs.getString(4);
                int donGiaMon = rs.getInt(5);
                boolean trangThaiMon = rs.getBoolean(6);
                MonDTO mon = new MonDTO(maMon, maLoaiMon, tenMon, hinhAnh, donGiaMon, trangThaiMon);
                listMon.add(mon);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listMon;
    }

    public MonDTO getMonById(String maMon) {
        MonDTO mon = null;
        String sql = "SELECT * FROM Mon WHERE MaMon = ?";
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement pre = c.prepareStatement(sql)) {
            pre.setString(1, maMon);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                String maLoaiMon = rs.getString(2);
                String tenMon = rs.getString(3);
                String hinhAnh = rs.getString(4);
                int donGiaMon = rs.getInt(5);
                boolean trangThaiMon = rs.getBoolean(6);
                mon = new MonDTO(maMon, maLoaiMon, tenMon, hinhAnh, donGiaMon, trangThaiMon);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return mon;
    }

    public boolean addMon(MonDTO mon) {
        boolean result = false;
        String sql = "INSERT INTO Mon VALUES(?,?,?,?,?,?)";
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement prep = c.prepareStatement(sql)) {
            prep.setString(1, getNewId());
            prep.setString(2, mon.getMaLoaiMon());
            prep.setString(3, mon.getTenMon());
            prep.setString(4, mon.getHinhAnh());
            prep.setInt(5, mon.getDonGiaMon());
            prep.setBoolean(6, mon.getTrangThaiMon());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

    public boolean deleteMon(String maMon) {
        boolean result = false;
        String sql = "UPDATE Mon SET trangThaiMon=0 WHERE MaMon= ? ";
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement prep = c.prepareStatement(sql)) {
            prep.setString(1, maMon);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

    public boolean updateMon(MonDTO mon) {
        boolean result = false;
        String sql = "UPDATE Mon SET MaLoaiMon=?, TenMon=?, HinhAnh=?, DonGiaMon=?, TrangThaiMon=? WHERE MaMon=?";
        try (Connection c = JDBCUtil.getConnection();
                PreparedStatement prep = c.prepareStatement(sql)) {
            prep.setString(1, mon.getMaLoaiMon());
            prep.setString(2, mon.getTenMon());
            prep.setString(3, mon.getHinhAnh());
            prep.setInt(4, mon.getDonGiaMon());
            prep.setBoolean(5, mon.getTrangThaiMon());
            prep.setString(6, mon.getMaMon());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

    public String getNewId() {
        String maMon = "M001";
        String sql = "SELECT MAX(MaMon) AS MaMon FROM Mon";
        try (Connection c = JDBCUtil.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                String lastMaM = rs.getString("MaMon");
                if (lastMaM != null) {
                    String numberPart = lastMaM.substring(1);
                    int number = Integer.parseInt(numberPart);
                    number++;
                    maMon = String.format("M%03d", number);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maMon;
    }
}
