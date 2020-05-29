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
public class loaigiay {
    private int idloaigiay;
    private String tenloai;

    public loaigiay() {
    }

    public loaigiay(int idloaigiay, String tenloai) {
        this.idloaigiay = idloaigiay;
        this.tenloai = tenloai;
    }

    public loaigiay(String tenloai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdloaigiay() {
        return idloaigiay;
    }

    public void setIdloaigiay(int idloaigiay) {
        this.idloaigiay = idloaigiay;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    

    
    
    
}
