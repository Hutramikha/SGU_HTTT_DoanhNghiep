package BUS;

import java.util.ArrayList;

import DAO.n4_CongThucDAO;
import DTO.CongThucDTO;

public class n4_CongThucBUS {
      private n4_CongThucDAO congThucDAO;
      public n4_CongThucBUS() {
            congThucDAO = new n4_CongThucDAO();
      }
      public ArrayList<CongThucDTO> getAll() {
            return congThucDAO.getAll();
      }
      public ArrayList<CongThucDTO> getCongThucByMaMon(String maMon) {
            return congThucDAO.getCongThucByMaMon(maMon);
      }
      public CongThucDTO getCongThucByMaMonVaMaNguyenLieu(CongThucDTO CongThuc) {
            return congThucDAO.getCongThucByMaMonVaMaNguyenLieu(CongThuc);
      }
      public boolean addCongThuc(CongThucDTO CongThuc) {
            return congThucDAO.addCongThuc(CongThuc);
      }

      public boolean deleteCongThuc(CongThucDTO CongThuc) {
            return congThucDAO.deleteCongThuc(CongThuc);
      }

      public boolean updateCongThuc(CongThucDTO CongThuc) {
            return congThucDAO.updateCongThuc(CongThuc);
      }
}
