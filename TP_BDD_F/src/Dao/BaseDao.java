package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import UI.Login;

public class BaseDao {
	public Connection getConnection(){
		String username = "root";
		String password = "123456";
		String driver = "com.mysql.jbdc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/ROUTES";
		try {
			//Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
		}  catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
