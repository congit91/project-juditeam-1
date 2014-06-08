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
public class DiaPhuong {
    private int maDP;
    private String tenDP;
    private String SDT;
    private String noiNhan;
    private float dienTich;
    private float soDan;
    private TieuChi tieuChi;

    public DiaPhuong() {
    }

    public DiaPhuong(int maDP, String tenDP, String SDT, String noiNhan, float dienTich, float soDan, TieuChi tieuChi) {
        this.maDP = maDP;
        this.tenDP = tenDP;
        this.SDT = SDT;
        this.noiNhan = noiNhan;
        this.dienTich = dienTich;
        this.soDan = soDan;
        this.tieuChi = tieuChi;
    }

    public int getMaDP() {
        return maDP;
    }

    public void setMaDP(int maDP) {
        this.maDP = maDP;
    }

    public String getTenDP() {
        return tenDP;
    }

    public void setTenDP(String tenDP) {
        this.tenDP = tenDP;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNoiNhan() {
        return noiNhan;
    }

    public void setNoiNhan(String noiNhan) {
        this.noiNhan = noiNhan;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public float getSoDan() {
        return soDan;
    }

    public void setSoDan(float soDan) {
        this.soDan = soDan;
    }

    public TieuChi getTieuChi() {
        return tieuChi;
    }

    public void setTieuChi(TieuChi tieuChi) {
        this.tieuChi = tieuChi;
    }
    
    
}
