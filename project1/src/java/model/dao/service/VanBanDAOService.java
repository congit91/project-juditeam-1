/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao.service;

import java.sql.Date;
import java.util.List;
import model.entities.VanBan;

/**
 *
 * @author Admin
 */
public interface VanBanDAOService {
    /**
     * get All VanBan from DB
     * @return VanBan List by the vb's status
     */
    public List<VanBan> getVanBanAll();

    /**
     * Lay danh sach van ban theo ho ten
     * @param tenVB la ho ten cua van ban
     * @return danh sach van ban
     */
    public List<VanBan> getVanBanByTenVB(String tenVB);

    /**
     * Lay danh sach van ban theo ho ten
     * @param loaiVB la ho ten cua van ban
     * @return danh sach van ban
     */
    public List<VanBan> getVanBanByLoaiVB(String loaiVB);

    /**
     * Get van ban theo ma VB
     * @param maVB Ma van ban
     * @return VanBan by maVB
     */
    public VanBan getVanBanByID(int maVB);
    
    /**
     * Tìm kiếm nâng cao 1 văn bản theo nhiều tiêu chí
     * @param tenVB tên của văn bản
     * @param loaiVB loại văn bản
     * @param noiBanHanh nơi ban hành
     * @param ngayBanHanh ngày ban hành
     * @param noiNhan nơi nhận
     * @return danh sách Văn bản tìm thấy theo các tiêu chí trên.
     */
    public List<VanBan> findVanBanAdvance(String tenVB, String loaiVB, String noiBanHanh, Date ngayBanHanh, String noiNhan);

    /**
     * Create new VanBan
     * @param vb is a Object VanBan
     * @return true if create VanBan successful. false if failed!
     */
    public boolean createVanBan(VanBan vb);

    /**
     * Update vb's profile by VanBan
     * @param vb is a Object VanBan
     * @return true if update Profile of VanBan successful. false if failed!
     */
    public boolean updateVanBan(VanBan vb);

    /**
     * remove The VanBan's active
     *
     * @param maVB is a Object VanBan
     * @return true if remove The vb's status successful. false if failed!
     */
    public boolean removeVanBan(int maVB);

    /**
     * restore The VanBan's active
     *
     * @param maVB is a Object VanBan
     * @return true if remove The vb's status successful. false if failed!
     */
    public boolean restoreVanBan(int maVB);

    /**
     * Delete VanBan
     *
     * @param maVB VanBanID will be delete
     * @return true if delete The vb's status successful. false if failed!
     */
    public boolean deleteVanBan(int maVB);
}
