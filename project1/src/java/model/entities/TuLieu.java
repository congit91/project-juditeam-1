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
public class TuLieu {
    private int maTL;
    private String website;
    private String baiBao;
    private String hinhAnh;
    private String video;

    public TuLieu() {
    }

    public TuLieu(int maTL, String website, String baiBao, String hinhAnh, String video) {
        this.maTL = maTL;
        this.website = website;
        this.baiBao = baiBao;
        this.hinhAnh = hinhAnh;
        this.video = video;
    }

    public int getMaTL() {
        return maTL;
    }

    public void setMaTL(int maTL) {
        this.maTL = maTL;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBaiBao() {
        return baiBao;
    }

    public void setBaiBao(String baiBao) {
        this.baiBao = baiBao;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    
}
