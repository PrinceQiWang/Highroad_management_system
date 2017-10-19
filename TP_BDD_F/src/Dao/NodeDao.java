package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import Classe.Node;
import Classe.Ville;

public class NodeDao extends BaseDao {
	Connection con = getConnection();
	
	public int count(){
		int count=0;
		String sql =" select COUNT(*) c from Node Group by CodP";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs= p.executeQuery();
			if(rs.next()){
				count=Integer.parseInt(rs.getString("c"));
			}}catch (SQLException e) {
				e.printStackTrace();
			}
		return count;
	}
	
	public void Obtenir(DefaultTableModel defaultTableModel_node,ArrayList j){
		ArrayList<Node> list=NodeList();
		for(Node n:list){
			String[] str={n.getCodP(),n.getCodR()};
			defaultTableModel_node.addRow(str);
			j.add(n.getCodP());
		}
	}
	
	public ArrayList<Node> NodeList(){
		ArrayList<Node> list =new ArrayList<Node>();
		
		String sql =" select * from Node";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs= p.executeQuery();
			while(rs.next()){
				Node n=new Node(rs.getString("CodP"),rs.getString("CodR"));
				list.add(n);
			}}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return list;
	}
	
	public int Add(String codp,String codr){
		String sql =" select CodP from Node " + "where CodP = '" + codp + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs_1= p.executeQuery();
			if(rs_1.next()){
				return 2;
			}
			else{
					String sql1 = " insert into Node (CodP,CodR)  " + "values ('"+codp+"','"+codr+"')";
					PreparedStatement p1=con.prepareStatement(sql1);
					p1.executeUpdate();
					return 1;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void Update(String codp,String codr,String ns){
		String sql =" update  Node set CodP='" +codp+"' ,CodR='" + codr + "' 6 where CodP = '" + ns + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void Delete(int id){
		String sql =" delete from Node where CodP='" + id + "'";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
