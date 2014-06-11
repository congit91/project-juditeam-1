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
public class TieuChi {

    private int maTC;
    private String tenTC;

    private List<DiaPhuong> dpList = null;

    public TieuChi() {
    }

    public TieuChi(int maTC, String tenTC) {
        this.maTC = maTC;
        this.tenTC = tenTC;
    }

    public int getMaTC() {
        return maTC;
    }

    public void setMaTC(int maTC) {
        this.maTC = maTC;
    }

    public String getTenTC() {
        return tenTC;
    }

    public void setTenTC(String tenTC) {
        this.tenTC = tenTC;
    }

    public List<DiaPhuong> getDpList() {
        return dpList;
    }

    public void setDpList(List<DiaPhuong> dpList) {
        this.dpList = dpList;
    }

}
