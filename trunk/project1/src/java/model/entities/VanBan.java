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
public class VanBan {
    private int maVB;
    private String tenVB;
    private String loaiVB;
    private String noiBanHanh;
    private Date ngayBanHanh;
    private String noiNhan;
    private String noiDung;
    private int active;

    public VanBan() {
    }

    public VanBan(int maVB, String tenVB, String loaiVB, String noiBanHanh, Date ngayBanHanh, String noiNhan, String noiDung, int active) {
        this.maVB = maVB;
        this.tenVB = tenVB;
        this.loaiVB = loaiVB;
        this.noiBanHanh = noiBanHanh;
        this.ngayBanHanh = ngayBanHanh;
        this.noiNhan = noiNhan;
        this.noiDung = noiDung;
        this.active = active;
    }

    public int getMaVB() {
        return maVB;
    }

    public void setMaVB(int maVB) {
        this.maVB = maVB;
    }

    public String getTenVB() {
        return tenVB;
    }

    public void setTenVB(String tenVB) {
        this.tenVB = tenVB;
    }

    public String getLoaiVB() {
        return loaiVB;
    }

    public void setLoaiVB(String loaiVB) {
        this.loaiVB = loaiVB;
    }

    public String getNoiBanHanh() {
        return noiBanHanh;
    }

    public void setNoiBanHanh(String noiBanHanh) {
        this.noiBanHanh = noiBanHanh;
    }

    public Date getNgayBanHanh() {
        return ngayBanHanh;
    }

    public void setNgayBanHanh(Date ngayBanHanh) {
        this.ngayBanHanh = ngayBanHanh;
    }

    public String getNoiNhan() {
        return noiNhan;
    }

    public void setNoiNhan(String noiNhan) {
        this.noiNhan = noiNhan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

}
