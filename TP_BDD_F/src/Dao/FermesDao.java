package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Classe.Fermes;

public class FermesDao extends BaseDao {
	Connection con = getConnection();

	public void Obtenir(DefaultTableModel defaultTableModel_fermes) {
		ArrayList<Fermes> list = FermesList();
		for (Fermes f : list) {
			 String[]
			 str={String.valueOf(f.getCodF()),f.getCodT(),f.getDateD(),f.getDateF(),f.getCause()};
			defaultTableModel_fermes.addRow(str);

		}
	}

	public int Add(int codf, String codt, String dated, String datef, String cause) {
		String sql = " select CodF from Fermes " + "where CodF = " + codf + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1 = p.executeQuery();
			if (rs_1.next()) {
				return 2;
			} else {
				String sql1 = " insert into Fermes (CodF,CodT,DateD,DateF,Cause)  " + "values ( " + codf + ",'" + codt + "','"
						+ dated + "','" + datef + "','" + cause + "')";
				PreparedStatement p1 = con.prepareStatement(sql1);
				p1.executeUpdate();
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void Update(int codf, String codt, String dated, String datef, String cause, int fs) {
		String sql = " update  Fermes set CodF=" + codf + ",CodT='" + codt + "',DateD = '" + dated + "',"
				+ "DateF = '" + datef + "',Cause = '" + cause + "' where CodF = "+ fs + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Delete(int id) {
		String sql = " delete from Fermes where CodF=" + id + "";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Fermes> FermesList() {
		ArrayList<Fermes> list = new ArrayList<Fermes>();

		String sql = " select * from Fermes";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Fermes f = new Fermes(Integer.parseInt(rs.getString("CodF")), rs.getString("CodT"),
						rs.getString("DateD"),rs.getString("DateF"),rs.getString("Cause"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
