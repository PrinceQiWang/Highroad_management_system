package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Classe.Societe;

public class SocieteDao extends BaseDao{
	Connection con=getConnection();
	
	public void Obtenir(DefaultTableModel defaultTableModel_societe,ArrayList l){
		ArrayList<Societe> list=SocieteList();
		for(Societe s:list){
			String[] str={s.getCodS(),s.getNomS()};
			defaultTableModel_societe.addRow(str);
			l.add(s.getNomS());
		}
	}
	
	public int Add(String cods,String noms){
		String sql =" select CodS from Societe " + "where CodS = '" + cods + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1= p.executeQuery();
			if(rs_1.next()){
				return 2;
			}
			else{
					String sql1 = " insert into Societe (CodS,NomS)  " + "values ( '"+cods+"','"+noms+"')";
					PreparedStatement p1=con.prepareStatement(sql1);
					p1.executeUpdate();
					return 1;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void Update(String cods,String noms,String ss){
		String sql =" update  Societe set CodS='" +cods+"',NomS='" + noms + "' where CodS = '" + ss + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void Delete(String id){
		String sql =" delete from Societe where CodS='" + id + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Societe> SocieteList(){
		ArrayList<Societe> list =new ArrayList<Societe>();
		
		String sql =" select * from Societe";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs= p.executeQuery();
			while(rs.next()){
				Societe s=new Societe(rs.getString("CodS"),rs.getString("NomS"));
				list.add(s);
			}}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return list;
	}

}
