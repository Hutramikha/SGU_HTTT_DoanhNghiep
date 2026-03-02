package BUS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.n5_NguyenLieuDAO;
import DTO.NguyenLieuDTO;
import Util.JDBCUtil;

public class n5_NguyenLieuBUS {
      private n5_NguyenLieuDAO nguyenLieuDAO;
      public n5_NguyenLieuBUS() {
            nguyenLieuDAO = new n5_NguyenLieuDAO();
      }
      public ArrayList<NguyenLieuDTO> getAll() {
            return nguyenLieuDAO.getAll();
      }
      public NguyenLieuDTO getNguyenLieuById(String maNguyenLieu) {
            return nguyenLieuDAO.getNguyenLieuById(maNguyenLieu);
      }
      public boolean addNguyenLieu(NguyenLieuDTO nguyenLieu) {
            return nguyenLieuDAO.addNguyenLieu(nguyenLieu);
      }

      public boolean deleteNguyenLieu(String maNguyenLieu) {
            return nguyenLieuDAO.deleteNguyenLieu(maNguyenLieu);
      }

      public boolean updateNguyenLieu(NguyenLieuDTO nguyenLieu) {
            return nguyenLieuDAO.updateNguyenLieu(nguyenLieu);
      }
}
