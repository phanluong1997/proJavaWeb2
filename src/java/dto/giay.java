/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class giay {
    private int idgiay;
    private String tengiay;
    private String hinhanh;
    private int gia;
    private int idloaigiay;

    public giay() {
    }

    public giay(int idgiay, String tengiay, String hinhanh, int gia, int idloaigiay) {
        this.idgiay = idgiay;
        this.tengiay = tengiay;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.idloaigiay = idloaigiay;
    }

    public int getIdgiay() {
        return idgiay;
    }

    public void setIdgiay(int idgiay) {
        this.idgiay = idgiay;
    }

    public String getTengiay() {
        return tengiay;
    }

    public void setTengiay(String tengiay) {
        this.tengiay = tengiay;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getIdloaigiay() {
        return idloaigiay;
    }

    public void setIdloaigiay(int idloaigiay) {
        this.idloaigiay = idloaigiay;
    }
    
    
}
