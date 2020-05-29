/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dto.giay;
import dto.loaigiay;
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
public class DAOloaigiay {
    Connection con;
        DBConnection dbc = new DBConnection();
        ResultSet rs ;
        private ArrayList<loaigiay> list = new ArrayList<>();

    
        public void ReadAll() {
			con = dbc.openConnection();
			try {
				rs = con.createStatement().executeQuery("SELECT * FROM loaigiay");
				while (rs.next()) {
					loaigiay s = new loaigiay();
					s.setIdloaigiay(rs.getInt("idloaigiay"));
					s.setTenloai(rs.getString("tenloai"));
					list.add(s);
				}
			} catch (SQLException ex) {
			}
			dbc.closeConnection();
		}
        
        
       public loaigiay readById(int id ) {
            loaigiay s = null;
        con = dbc.openConnection();
        try {
            PreparedStatement ps = con.prepareStatement("CALL read_by_idloaigiay(?)");
            ps.setInt(1,id);
            rs =ps.executeQuery();
            while (rs.next()) {
              s=new loaigiay();
                s.setIdloaigiay(rs.getInt("idloaigiay"));
                s.setTenloai(rs.getNString("tenloai"));
                               
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOgiay.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbc.closeConnection();
        return s;
        } 
        
        
        public boolean Create(loaigiay s){
        con = dbc.openConnection();
            try {
                PreparedStatement ps = con.prepareStatement("CALL create_loaigiay(?,?)");
                ps.setInt(1, s.getIdloaigiay());
                ps.setNString(2, s.getTenloai());
                
            
                ps.executeUpdate();
             return true;
                        } catch (SQLException ex) {
                Logger.getLogger(DAOloaigiay.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                
                dbc.closeConnection();
            }
            return false;
        }
        
       public boolean Select(String tenloai) {
        con = dbc.openConnection();
			try {
				rs = con.createStatement().executeQuery("SELECT idloaigiay,tenloai FROM loaigiay where tenloai like '%" +tenloai+ "%'");
				while (rs.next()) {
					loaigiay s = new loaigiay();
                                        s.setIdloaigiay(rs.getInt("idloaigiay"));
					s.setTenloai(rs.getString("tenloai"));
					list.add(s);
                                       return true; 
				}
			} catch (SQLException ex) {
			}
			dbc.closeConnection();
                        return false;
       }
       
       public boolean Update(loaigiay s){
            con =dbc.openConnection();
            try {
                PreparedStatement ps = con.prepareStatement("CALL update_by_loaigiay(?,?) ");
                ps.setInt(1, s.getIdloaigiay());
                    ps.setNString(2, s.getTenloai());
           
            ps.executeUpdate();
            return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAOgiay.class.getName()).log(Level.SEVERE, null, ex);
            }

	dbc.closeConnection();
	return false;
        }
       
       public boolean Delete(loaigiay s){
        
        con = dbc.openConnection();
            try {
                PreparedStatement  ps = con.prepareStatement("DELETE FROM loaigiay WHERE idloaigiay  = ?");
                ps.setInt(1, s.getIdloaigiay());
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DAOgiay.class.getName()).log(Level.SEVERE, null, ex);
            }
         dbc.closeConnection();
         return false;
        }
        
        
       public void display() {
        for (loaigiay s : list) {
            System.out.println(s.getIdloaigiay()+ " " + s.getTenloai());
        }
    }
         public ArrayList<loaigiay> getList() {
        return list;
    }

    public boolean Select(loaigiay s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
