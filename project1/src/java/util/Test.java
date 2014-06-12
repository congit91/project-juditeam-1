/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.List;
import model.dao.DiaPhuongDAO;
import model.dao.DiaPhuong_TieuChiDAO;
import model.dao.NguoiPhuTrachDAO;
import model.dao.TaiKhoanDAO;
import model.dao.TieuChiDAO;
import model.dao.VanBanDAO;
import model.dao.service.DPTCDAOService;
import model.entities.DiaPhuong;
import model.entities.NguoiPhuTrach;
import model.entities.TaiKhoan;
import model.entities.TieuChi;
import model.entities.VanBan;

/**
 *
 * @author Admin
 */
public class Test {
    public static void test(){
//        TieuChi tc = TieuChiDAO.getInstance().getTCByName("Tiêu cHí giao thông");
//        System.out.println(tc.getTenTC());
        DiaPhuong dp = DiaPhuongDAO.getInstance().getDiaPhuongByTenDP("xã bình triều");
        List<TieuChi> nptList = dp.getTcList();
        System.out.println(nptList.size());
//        System.out.println(nptList.get(0).getDiaPhuong().getTenDP());
//        NguoiPhuTrach npt = NguoiPhuTrachDAO.getInstance().getNPTByID(1);
//        System.out.println(npt.getDiaPhuong().getTenDP());
//        System.out.println(npt.getChucVu());

    }
    public static void main(String[] args) {
        test();
    }
}
