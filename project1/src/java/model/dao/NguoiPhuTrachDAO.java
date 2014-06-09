/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import model.dao.service.NguoiPhuTrachDAOService;
import model.entities.NguoiPhuTrach;

/**
 *
 * @author Admin
 */
public class NguoiPhuTrachDAO implements NguoiPhuTrachDAOService{

    @Override
    public List<NguoiPhuTrach> getNPTList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NguoiPhuTrach> getNPTListByName(String tenNPT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NguoiPhuTrach getNPTByID(int maNPT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NguoiPhuTrach> findNguoiPhuTrachByDP(int maDP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createNPT(NguoiPhuTrach npt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateNPT(NguoiPhuTrach npt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deteleNPT(int maNPT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
