/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.List;
import model.dao.TaiKhoanDAO;
import model.dao.VanBanDAO;
import model.entities.TaiKhoan;
import model.entities.VanBan;

/**
 *
 * @author Admin
 */
public class Test {
    public static void test(){
        List<VanBan> vbList = VanBanDAO.getInstance().getVanBanByTenVB("H");
        System.out.println(vbList.size());
    }
    public static void main(String[] args) {
        test();
    }
}
