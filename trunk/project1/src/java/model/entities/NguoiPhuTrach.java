/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entities;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NguoiPhuTrach {
    private int maNPT;
    private String hoTen;
    private Date namSinh;
    private String queQuan;
    private String hocVi;
    private String chucVu;
    private String SDT;
    private String email;
    private DiaPhuong diaPhuong;

    public NguoiPhuTrach() {
    }

    public NguoiPhuTrach(int maNPT, String hoTen, Date namSinh, String queQuan, String hocVi, String chucVu, String SDT, String email, DiaPhuong diaPhuong) {
        this.maNPT = maNPT;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.hocVi = hocVi;
        this.chucVu = chucVu;
        this.SDT = SDT;
        this.email = email;
        this.diaPhuong = diaPhuong;
    }

    public int getMaNPT() {
        return maNPT;
    }

    public void setMaNPT(int maNPT) {
        this.maNPT = maNPT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DiaPhuong getDiaPhuong() {
        return diaPhuong;
    }

    public void setDiaPhuong(DiaPhuong diaPhuong) {
        this.diaPhuong = diaPhuong;
    }
    
    
}
