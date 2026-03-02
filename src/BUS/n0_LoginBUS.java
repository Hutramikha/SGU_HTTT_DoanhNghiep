package BUS;

import DAO.n0_LoginDAO;
import DTO.TaiKhoanDTO;

public class n0_LoginBUS {
      private n0_LoginDAO loginDAO;
      public n0_LoginBUS(){
            this.loginDAO = new n0_LoginDAO();
      }
      public TaiKhoanDTO checkLogin(String username, String password) {
            return loginDAO.checkLogin(username, password);
      }
}
