package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import Classe.Ville;

public class VilleDao extends BaseDao{
	Connection con = getConnection();
	
	public String cherchenode(String nom){
		String sql =" select CodP from Ville " + "where NomV = '" + nom + "'";
		String codp=null;
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs= p.executeQuery();
			if(rs.next()){
				codp=rs.getString("CodP");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codp;
	}
	
	public void Obtenir(DefaultTableModel defaultTableModel_ville,ArrayList jComboBox_ville){
		ArrayList<Ville> list=VilleList();
		for(Ville v:list){
			String[] str={String.valueOf(v.getCodPT()),v.getNomV(),v.getCodP()};
			defaultTableModel_ville.addRow(str);
			jComboBox_ville.add(v.getNomV());
		}
	}
	
	public int AddVille(int codpt,String nomv,String codp){
		String sql =" select CodPT from Ville " + "where CodPT = " + codpt + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1= p.executeQuery();
			if(rs_1.next()){
				return 2;
			}
			else{
					String sql1 = " insert into Ville (CodPT,NomV,CodP)  " + "values ( "+codpt+",'"+nomv+"','"+codp+"')";
					PreparedStatement p1=con.prepareStatement(sql1);
					p1.executeUpdate();
					return 1;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void Update(int codpt,String nomv,String codp,int vs){
		String sql =" update  Ville set CodPT=" +codpt+",NomV='" + nomv + "',CodP = '"+codp+"' where CodPT = " + vs + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void Delete(int id){
		String sql =" delete from Ville where CodPT=" + id + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Ville> VilleList(){
		ArrayList<Ville> list =new ArrayList<Ville>();
		
		String sql =" select * from Ville";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs= p.executeQuery();
			while(rs.next()){
				Ville v=new Ville(Integer.parseInt(rs.getString("CodPT")),rs.getString("NomV"),rs.getString("CodP"));
				list.add(v);
			}}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return list;
	}
}
