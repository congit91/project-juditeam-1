/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao.service;

import java.util.List;
import model.entities.TieuChi;

/**
 *
 * @author Admin
 */
public interface TieuChiDAOService {
    public List<TieuChi> getTCList();
    public TieuChi getTCByName(String tenTC);
    public TieuChi getTCByID(int maTC);

    public boolean createTC(TieuChi tc);
    public boolean updateTC(TieuChi tc);
    public boolean deteleTC(int maTC);
}
