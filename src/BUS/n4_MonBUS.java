package BUS;

import java.util.ArrayList;

import DAO.n4_MonDAO;
import DTO.MonDTO;

public class n4_MonBUS {
      private n4_MonDAO monDAO;
      public n4_MonBUS() {
            monDAO = new n4_MonDAO();
      }
      public ArrayList<MonDTO> getAll() {
            return monDAO.getAll();
      }
      public boolean addMon(MonDTO mon) {
            return monDAO.addMon(mon);
      }

      public boolean deleteMon(String maMon) {
            return monDAO.deleteMon(maMon);
      }

      public boolean updateMon(MonDTO mon) {
            return monDAO.updateMon(mon);
      }
      public MonDTO getMonById(String maMon) {
            return monDAO.getMonById(maMon);
      }
}
