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
public class DiaPhuong_TieuChi {
    private int maDPTC;
    private DiaPhuong diaPhuong;
    private TieuChi tieuChi;
    private String noiDung;

    public DiaPhuong_TieuChi() {
    }

    public DiaPhuong_TieuChi(int maDPTC, DiaPhuong diaPhuong, TieuChi tieuChi, String noiDung) {
        this.maDPTC = maDPTC;
        this.diaPhuong = diaPhuong;
        this.tieuChi = tieuChi;
        this.noiDung = noiDung;
    }

    public int getMaDPTC() {
        return maDPTC;
    }

    public void setMaDPTC(int maDPTC) {
        this.maDPTC = maDPTC;
    }

    public DiaPhuong getDiaPhuong() {
        return diaPhuong;
    }

    public void setDiaPhuong(DiaPhuong diaPhuong) {
        this.diaPhuong = diaPhuong;
    }

    public TieuChi getTieuChi() {
        return tieuChi;
    }

    public void setTieuChi(TieuChi tieuChi) {
        this.tieuChi = tieuChi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    
}
