/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao.service;

import java.util.List;
import model.entities.TaiKhoan;

/**
 *
 * @author Admin
 */
public interface TaiKhoanDAOService {
    /**
     * get All TaiKhoan from DB
     * @return TaiKhoan List by the tk's status
     */
    public List<TaiKhoan> getTaiKhoanAll();

    /**
     * Lay danh sach tai khoan theo ho ten
     * @param hoTen la ho ten cua chu tai khoan
     * @return danh sach tai khoan
     */
    public List<TaiKhoan> getTaiKhoanByHoTen(String hoTen);
    /**
     * Lay danh sach tai khoan theo ho ten
     * @param tenTK la tên của tài khoản
     * @return danh sach tai khoan
     */
    public List<TaiKhoan> findTaiKhoanByTenTK(String tenTK);

    /**
     * Get Tai khoan theo ma TK
     * @param maTK Ma tai khoan
     * @return TaiKhoan by maTK
     */
    public TaiKhoan getTaiKhoanByID(int maTK);

    /**
     * Get TaiKhoanList by maTK
     * @param tenTK is name of tk
     * @return TaiKhoan by TaiKhoanID
     */
    public TaiKhoan getTaiKhoanByTenTK(String tenTK);

    
    /**
     * Check ten TK va matkhau khi dang nhap
     * @param tenTK name of TaiKhoan
     * @param password password of TaiKhoan
     * @return true if tenTK and password == true. The opposite is false
     */
    public boolean checkDangNhap(String tenTK, String password);

    /**
     * Check isExist of TaiKhoan when create new TaiKhoan
     * @param tenTK name of TaiKhoan
     * @return true if tenTK is Exist. The opposite is false
     */
    public boolean checkTaiKhoan(String tenTK);

    /**
     * Create new TaiKhoan
     * @param tk is a Object TaiKhoan
     * @return true if create TaiKhoan successful. false if failed!
     */
    public boolean createTaiKhoan(TaiKhoan tk);

    /**
     * Update tk's profile by TaiKhoan
     * @param tk is a Object TaiKhoan
     * @return true if update Profile of TaiKhoan successful. false if failed!
     */
    public boolean updateTaiKhoan(TaiKhoan tk);
    
    /**
     * Update tk's password by TaiKhoan
     * @param tk is a Object TaiKhoan
     * @return true if update Profile of TaiKhoan successful. false if failed!
     */
    public boolean updateMatKhau(TaiKhoan tk);

    /**
     * remove The TaiKhoan's active
     *
     * @param tk is a Object TaiKhoan
     * @return true if remove The tk's status successful. false if failed!
     */
    public boolean removeTaiKhoan(TaiKhoan tk);

    /**
     * restore The TaiKhoan's active
     *
     * @param tk is a Object TaiKhoan
     * @return true if remove The tk's status successful. false if failed!
     */
    public boolean restoreTaiKhoan(TaiKhoan tk);

    /**
     * Delete TaiKhoan
     *
     * @param maTK TaiKhoanID will be delete
     * @return true if delete The tk's status successful. false if failed!
     */
    public boolean deleteTaiKhoan(int maTK);
}
