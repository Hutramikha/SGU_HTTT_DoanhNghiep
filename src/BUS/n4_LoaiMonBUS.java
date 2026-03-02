package BUS;

import java.util.ArrayList;

import DAO.n4_LoaiMonDAO;
import DTO.LoaiMonDTO;

public class n4_LoaiMonBUS {
      private n4_LoaiMonDAO loaiMonDAO;
      public n4_LoaiMonBUS() {
            loaiMonDAO = new n4_LoaiMonDAO();
      }
      public ArrayList<LoaiMonDTO> getAll() {
            return loaiMonDAO.getAll();
      }
      public LoaiMonDTO getLoaiMonById(String maLoaiMon) {
            return loaiMonDAO.getLoaiMonById(maLoaiMon);
      }
      public boolean addLoaiMon(LoaiMonDTO loaiMon) {
            return loaiMonDAO.addLoaiMon(loaiMon);
      }

      public boolean deleteLoaiMon(String maLoaiMon) {
            return loaiMonDAO.deleteLoaiMon(maLoaiMon);
      }

      public boolean updateLoaiMon(LoaiMonDTO loaiMon) {
            return loaiMonDAO.updateLoaiMon(loaiMon);
      }
}
