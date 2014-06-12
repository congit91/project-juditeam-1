/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao.service;

import java.util.List;
import model.entities.DiaPhuong;
import model.entities.DiaPhuong_TieuChi;
import model.entities.TieuChi;

/**
 *
 * @author Admin
 */
public interface DPTCDAOService {
    public List<DiaPhuong_TieuChi> getAllList();
    public DiaPhuong_TieuChi getDPTCByID(int maDPTC);
    public DiaPhuong_TieuChi getDPTCByDPTC(int maDP, int maTC);
    public List<DiaPhuong> getDPByTC(int matc);
    public List<TieuChi> getTCByDP(int madp);
    public List<DiaPhuong_TieuChi> getDPTCByDP(int maDP);
    public List<DiaPhuong_TieuChi> getDPTCByTC(int maTC);
    public boolean checkCreate(int maDP, int maTC);
    public boolean create(DiaPhuong_TieuChi dptc);
    public boolean update(DiaPhuong_TieuChi dptc);
    public boolean delete(DiaPhuong_TieuChi dptc);
}
