/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.entities;

import java.util.List;

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
    private int active;
    
    private List<TieuChi> tcList = null;

    public DiaPhuong() {
    }

    public DiaPhuong(int maDP, String tenDP, String SDT, String noiNhan, float dienTich, float soDan, int active) {
        this.maDP = maDP;
        this.tenDP = tenDP;
        this.SDT = SDT;
        this.noiNhan = noiNhan;
        this.dienTich = dienTich;
        this.soDan = soDan;
        this.active = active;
    }

    public List<TieuChi> getTcList() {
        return tcList;
    }

    public void setTcList(List<TieuChi> tcList) {
        this.tcList = tcList;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

}
