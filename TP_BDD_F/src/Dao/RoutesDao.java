package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import Classe.Routes;

public class RoutesDao extends BaseDao {
	Connection con = getConnection();

	public void Obtenir(DefaultTableModel defaultTableModel_fermes,ArrayList j) {
		ArrayList<Routes> list = List();
		for (Routes r: list) {
			 String[] str={r.getCodR(),r.getNomR(),r.getVilleP(),r.getVilleT(),String.valueOf(r.getRKm())};
			defaultTableModel_fermes.addRow(str);
			j.add(r.getCodR());
		}
	}
	
	public ArrayList<Routes> List() {
		ArrayList<Routes> list = new ArrayList<Routes>();

		String sql = "select CodR,NomR,v1.NomV Vp,v2.nomV Vt,RKm from Routes,Ville v1,Ville v2 where v1.CodPT = Routes.VilleP and v2.CodPT = Routes.VilleT Group by CodR";

		
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Routes r = new Routes(rs.getString("CodR"), rs.getString("NomR"),rs.getString("Vp"),rs.getString("Vt"),Integer.parseInt(rs.getString("RKm")));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public int Add(String codr, String nomr, String vp, String vf, String longl) {
		String sql = " select CodPT,NomV from Ville " + "where NomV = '" + vp + "' or NomV = '" +vf + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1 = p.executeQuery();
			if (rs_1.next()) {
				String [][] str=new String[2][2];
				str[0][0]=rs_1.getString("NomV");
				str[0][1]=rs_1.getString("CodPT");
				//System.out.println(str[0][1]);
				rs_1.next();
				str[1][0]=rs_1.getString("NomV");
				str[1][1]=rs_1.getString("CodPT");
				//System.out.println(str[1][1]);
				
				String sql1=null;
				if(str[0][0].equals(vp)){
				 sql1 = " insert into Routes (CodR,NomR,VilleP,VilleT,RKm)  " + "values (' " + codr + "','" + nomr + "',"
						+ str[0][1] + "," + str[1][1] + "," + longl + ")";
				}
				else{
					 sql1 = " insert into Routes (CodR,NomR,VilleP,VilleT,RKm)  " + "values ('" + codr + "','" + nomr + "',"
							+ str[1][1] + "," + str[0][1] + "," + longl + ")";
					}
				PreparedStatement p1 = con.prepareStatement(sql1);
				p1.executeUpdate();
				
				return 2;
			} else {
				
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int Update(String codr, String nomr, String vp, String vf, String longl,String rs) {
		String sql = " select CodPT,NomV from Ville " + "where NomV = '" + vp + "' or NomV = '" +vf + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1 = p.executeQuery();
			if (rs_1.next()) {
				String [][] str=new String[2][2];
				str[0][0]=rs_1.getString("NomV");
				str[0][1]=rs_1.getString("CodPT");
				rs_1.next();
				str[1][0]=rs_1.getString("NomV");
				str[1][1]=rs_1.getString("CodPT");
				
				String sql1=null;
				if(str[0][0].equals(vp)){
				 sql1 = " update  Routes set CodR = '"+codr + "',NomR='" + nomr + "',VilleP="
						+ str[0][1] + ",VilleT=" + str[1][1] + ",RKm=" + longl + " where CodR='"+rs+"'";
				}
				else{
					 sql1 = " update  Routes set CodR = '"+codr + "',NomR='" + nomr + "',VilleP="
								+ str[1][1] + ",VilleT=" + str[0][1] + ",RKm=" + longl + " where CodR='"+rs+"'";
					}
				PreparedStatement p1 = con.prepareStatement(sql1);
				p1.executeUpdate();
				
				return 2;
			} else {
				
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void Delete(String id) {
		String sql = " delete from Routes where CodR='" + id + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
