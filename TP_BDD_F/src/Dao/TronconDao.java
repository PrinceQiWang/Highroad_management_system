package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Classe.Troncon;

public class TronconDao extends BaseDao {
	Connection con = getConnection();

	public void Obtenir(DefaultTableModel defaultTableModel,ArrayList l) {
		ArrayList<Troncon> list = List();
		for (Troncon t : list) {
			 String[]
			 str={t.getCodT(),t.getCodR(),t.getNodeP(),t.getNodeT(),String.valueOf(t.getTKm()),String.valueOf(t.getType())};
			defaultTableModel.addRow(str);
			l.add(t.getCodT());
		}
	}

	public int Add(String codt,String codr,String notep,String notet,String TKm,String t) {
		String sql = " select CodT from Troncons " + "where CodT = '" + codt + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1 = p.executeQuery();
			if (rs_1.next()) {
				return 2;
			} else {
				String sql1 = " insert into Troncons (CodT,CodR,NodeP,NodeT,TKm,TypeT)  " + "values ( '"+codt+"','"+codr+"','"+notep+"','"+notet+"',"+TKm+","+t+")";
				PreparedStatement p1 = con.prepareStatement(sql1);
				p1.executeUpdate();
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void Update(String codt,String codr,String notep,String notet,String TKm,String t, String ts) {
		String sql = " update  Troncons set CodT=" + codt + ",CodR='" + codr + "',NoteP = '" + notep + "',"
				+ "NoteT = '" + notet + "',TKm = " + TKm + ",TypeT="+t+" where CodT = "+ ts + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Delete(String id) {
		String sql = " delete from Troncons where CodT='" + id + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Troncon> List() {
		ArrayList<Troncon> list = new ArrayList<Troncon>();

		String sql = " select * from Troncons";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Troncon t = new Troncon(rs.getString("CodT"),rs.getString("CodR"),rs.getString("NodeP"),rs.getString("NodeT"),Integer.parseInt(rs.getString("TKm")),Integer.parseInt(rs.getString("TypeT")));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
