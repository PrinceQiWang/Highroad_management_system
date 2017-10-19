package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Classe.Peage;

public class PeageDao extends BaseDao {
	Connection con = getConnection();

	public int cherchepeage(String codp){
		String sql =" select CodPG from Peage " + "where CodP = '" + codp + "'";
		int codpg=-1;
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs= p.executeQuery();
			if(rs.next()){
				codpg=Integer.parseInt(rs.getString("CodPG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codpg;
	}
	
	public void Obtenir(DefaultTableModel defaultTableModel_peage) {
		ArrayList<Peage> list = PeageList();
		for (Peage pe : list) {
			 String[]
			 str={String.valueOf(pe.getCodPG()),pe.getCodT(),pe.getCodS(),String.valueOf(pe.getFrais()),pe.getDateD(),pe.getDateF()};
			defaultTableModel_peage.addRow(str);
		}
	}

	public int Add(int codpg, String codt, String cods, int frais, String dated,String datef) {
		String sql = " select CodPG from Peage " + "where CodPG = " + codpg + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1 = p.executeQuery();
			if (rs_1.next()) {
				return 2;
			} else {
				String sql1 = " insert into Peage (CodPG,CodP,CodS,Frais,DateD,DateF)  " + "values ( " + codpg + ",'" + codt + "','" + cods + "'," +frais + ",'"+ dated + "','" + datef + "')";
				PreparedStatement p1 = con.prepareStatement(sql1);
				p1.executeUpdate();
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void Update(int codpg, String codt, String cods, int frais, String dated, String datef, int ps) {
		String sql = " update  Peage set CodPG=" + codpg + ",CodP='" + codt + "',CodS='" + cods + "',Frais=" + frais + ","
				+ "DateD = '" + dated + "',"+ "DateF = '" + datef + "' where CodPG = "+ ps + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Delete(int id) {
		String sql = " delete from Peage where CodPG=" + id + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Peage> PeageList() {
		ArrayList<Peage> list = new ArrayList<Peage>();

		String sql = " select * from Peage";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Peage pe = new Peage(Integer.parseInt(rs.getString("CodPG")), Integer.parseInt(rs.getString("Frais")),rs.getString("CodS"),
						rs.getString("CodP"),rs.getString("DateD"),rs.getString("DateF"));
				list.add(pe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
