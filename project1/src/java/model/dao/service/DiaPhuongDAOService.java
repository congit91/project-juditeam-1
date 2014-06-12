/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao.service;

import java.util.List;
import model.entities.DiaPhuong;

/**
 *
 * @author Admin
 */
public interface DiaPhuongDAOService {
    /**
     * get All DiaPhuong from DB
     * @return DiaPhuong List by the dp's status
     */
    public List<DiaPhuong> getDiaPhuongAll();

    /**
     * Lay danh sach dia phuong theo ho ten
     * @param tenDP la ho ten cua dia phuong
     * @return danh sach dia phuong
     */
    public DiaPhuong getDiaPhuongByTenDP(String tenDP);

    /**
     * Get dia phuong theo ma DP
     * @param maDP Ma dia phuong
     * @return DiaPhuong by maDP
     */
    public DiaPhuong getDiaPhuongByID(int maDP);
    

    /**
     * Create new DiaPhuong
     * @param dp is a Object DiaPhuong
     * @return true if create DiaPhuong successful. false if failed!
     */
    public boolean createDiaPhuong(DiaPhuong dp);

    /**
     * Update dp's profile by DiaPhuong
     * @param dp is a Object DiaPhuong
     * @return true if update Profile of DiaPhuong successful. false if failed!
     */
    public boolean updateDiaPhuong(DiaPhuong dp);

    /**
     * remove The DiaPhuong's active
     *
     * @param maDP is a Object DiaPhuong
     * @return true if remove The dp's status successful. false if failed!
     */
    public boolean removeDiaPhuong(int maDP);

    /**
     * restore The DiaPhuong's active
     *
     * @param maDP is a Object DiaPhuong
     * @return true if remove The dp's status successful. false if failed!
     */
    public boolean restoreDiaPhuong(int maDP);

    /**
     * Delete DiaPhuong
     *
     * @param maDP DiaPhuongID will be delete
     * @return true if delete The dp's status successful. false if failed!
     */
    public boolean deleteDiaPhuong(int maDP);
    public List<DiaPhuong> fintDiaPhuongByTen(String tenDP);
}
