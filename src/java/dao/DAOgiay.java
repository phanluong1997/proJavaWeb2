/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.giay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.DBConnection;

/**
 *
 * @author Admin
 */
public class DAOgiay {
    
        Connection con;
        DBConnection dbc = new DBConnection();
        ResultSet rs ;
        private ArrayList<giay> list = new ArrayList<>();
        
        
        
        public boolean Create(giay s){
        con = dbc.openConnection();
            try {
                PreparedStatement ps = con.prepareStatement("CALL create_giay(?,?,?,?,?)");
                ps.setInt(1, s.getIdgiay());
                ps.setNString(2, s.getTengiay());
                ps.setNString(3, s.getHinhanh());
                ps.setInt(4, s.getGia());
                ps.setInt(5, s.getIdloaigiay());
            
                ps.executeUpdate();
             return true;
                        } catch (SQLException ex) {
                Logger.getLogger(DAOgiay.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                
                dbc.closeConnection();
            }
            return false;
        }
        
        
        public giay readById(int id ) {
            giay s = null;
        con = dbc.openConnection();
        try {
            PreparedStatement ps = con.prepareStatement("CALL read_by_idgiay(?)");
            ps.setInt(1,id);
            rs =ps.executeQuery();
            while (rs.next()) {
              s=new giay();
                s.setIdgiay(rs.getInt("idgiay"));
                s.setTengiay(rs.getNString("tengiay"));
                s.setHinhanh(rs.getNString("hinhanh"));
                s.setGia(rs.getInt("gia"));
                s.setIdloaigiay(rs.getInt("idloaigiay"));
                               
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOgiay.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbc.closeConnection();
        return s;
        }
        
        public void ReadAll() {
			con = dbc.openConnection();
			try {
				rs = con.createStatement().executeQuery("SELECT * FROM giay");
				while (rs.next()) {
					giay s = new giay();
					s.setIdgiay(rs.getInt("idgiay"));
					s.setTengiay(rs.getString("tengiay"));
					s.setHinhanh(rs.getString("hinhanh"));
                                        s.setGia(rs.getInt("gia"));
                                        s.setIdloaigiay(rs.getInt("idloaigiay"));
					list.add(s);
				}
			} catch (SQLException e) {
			}
			dbc.closeConnection();
		}
        
        public boolean Update(giay s){
            con =dbc.openConnection();
            try {
                PreparedStatement ps = con.prepareStatement("CALL update_giay(?,?,?,?,?) ");
                ps.setInt(1, s.getIdgiay());
                    ps.setNString(2, s.getTengiay());
           ps.setNString(3, s.getHinhanh());
            ps.setInt(4, s.getGia());
            ps.setInt(5, s.getIdloaigiay());
            ps.executeUpdate();
            return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAOgiay.class.getName()).log(Level.SEVERE, null, ex);
            }

	dbc.closeConnection();
	return false;
        }
        
        
        public boolean Delete(giay s){
        
        con = dbc.openConnection();
            try {
                PreparedStatement  ps = con.prepareStatement("DELETE FROM giay WHERE idgiay  = ?");
                ps.setInt(1, s.getIdgiay());
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAOgiay.class.getName()).log(Level.SEVERE, null, ex);
            }
         dbc.closeConnection();
         return false;
        }

   
         public void display() {
        for (giay s : list) {
            System.out.println(s.getTengiay()+ " " + s.getGia());
        }
    }
        
        
        public ArrayList<giay> getList() {
        return list;
    }

    
}
