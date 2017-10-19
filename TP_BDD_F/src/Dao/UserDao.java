package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classe.Usager;
import UI.Administrateur;
import UI.Documentaliste;

public class UserDao extends BaseDao{
	Connection con = getConnection();
	String RightPassword = null;
	String RightUserType = null;
	
	public Usager LogIn (String UserID) {
		String sql = "select UserPW,UserType from Usager " + "where UserID = '" + UserID + "'";
		Usager usager = new Usager();
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs= p.executeQuery();
			if (rs.next()){
				RightUserType = rs.getString("UserType");
				RightPassword = rs.getString("UserPW");
				usager.setUserType(Integer.parseInt(RightUserType));
				usager.setUserPW(RightPassword);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return usager;
	}
	public ArrayList<Usager> ListUsager(int i){
		ArrayList<Usager> list=new ArrayList<Usager>();
		String sql =" select * from Usager where UserType="+i;
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs= p.executeQuery();
			while(rs.next()){
				Usager u=new Usager(rs.getString("UserID"),rs.getString("UserPW"),Integer.parseInt(rs.getString("UserType")));
				list.add(u);
			}}catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	public int SignIn (String UserID, String UserPW,String RUserPW,String UserType) {
		String sql =" select UserID from Usager " + "where UserID = '" + UserID + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1= p.executeQuery();
			if(rs_1.next()){
				return 2;
			}
			else{
				if (UserPW.equals(RUserPW)){
					String sql1 = " insert into Usager (UserID,UserPW,UserType)  " + "values ( '"+UserID+"','"+UserPW+"','"+UserType+"')";
					return 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 3;
	}
	public int AddUsager (String UserID, String UserPW,int UserType) {
		String sql =" select UserID from Usager " + "where UserID = '" + UserID + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1= p.executeQuery();
			if(rs_1.next()){
				return 2;
			}
			else{
					String sql1 = " insert into Usager (UserID,UserPW,UserType)  " + "values ( '"+UserID+"','"+UserPW+"',"+UserType+")";
					PreparedStatement p1=con.prepareStatement(sql1);
					p1.executeUpdate();
					return 1;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 3;
	}
	public void UpdateUsager(String id,String pw,String ids){
		String sql =" update  Usager set UserPW='" + pw+"',UserID='" + id + "'where UserID='" + ids + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void DeleteUsager(String id){
		String sql =" delete from Usager where UserID='" + id + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int  ChangePW(String id,String pw,String ids){
		String sql =" update  Usager set UserPW='" + pw+"'where UserID='" + ids + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			return p.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
