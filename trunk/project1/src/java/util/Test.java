/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import model.dao.TaiKhoanDAO;
import model.entities.TaiKhoan;

/**
 *
 * @author Admin
 */
public class Test {
    public static void test(){
        TaiKhoanDAO userDAO = new TaiKhoanDAO();
        TaiKhoan tk = new TaiKhoan(1, "thanhnv", "thanhnv", "Nguyễn Văn Thanh", "thanhnv.itedu@gmail.com", "0982200444", 0);
        System.out.println(userDAO.createTaiKhoan(tk));
    }
    public static void main(String[] args) {
        test();
    }
}
