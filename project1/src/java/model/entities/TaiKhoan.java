/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entities;

/**
 *
 * @author Admin
 */
public class TaiKhoan {
    private int maTK;
    private String tenTK;
    private String matkhau;
    private String hoTen;
    private String email;
    private String SDT;
    private int trangThaiHD;

    public TaiKhoan() {
    }

    public TaiKhoan(int maTK, String tenTK, String matkhau, String hoTen, String email, String SDT, int trangThaiHD) {
        this.maTK = maTK;
        this.tenTK = tenTK;
        this.matkhau = matkhau;
        this.hoTen = hoTen;
        this.email = email;
        this.SDT = SDT;
        this.trangThaiHD = trangThaiHD;
    }

    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getTrangThaiHD() {
        return trangThaiHD;
    }

    public void setTrangThaiHD(int trangThaiHD) {
        this.trangThaiHD = trangThaiHD;
    }


}
