/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.service;

import java.util.List;
import model.entities.NguoiPhuTrach;

/**
 *
 * @author Admin
 */
public interface NguoiPhuTrachDAOService {

    public List<NguoiPhuTrach> getNPTList();

    public List<NguoiPhuTrach> getNPTListByName(String tenNPT);

    public NguoiPhuTrach getNPTByID(int maNPT);

    /**
     * Tìm kiếm nâng cao 1 địa phương theo nhiều tiêu chí
     *
     * @param maDP mã địa phương.
     * @return Tiêu chí của địa phương.
     */
    public List<NguoiPhuTrach> findNguoiPhuTrachByDP(int maDP);

    public NguoiPhuTrach findNPTByDP(int maNPT, int maDP);

    public boolean createNPT(NguoiPhuTrach npt);

    public boolean updateNPT(NguoiPhuTrach npt);
    
    public boolean updateNPT_DP(int maNPT, int maDP);

    public boolean deteleNPT(int maNPT);
}
