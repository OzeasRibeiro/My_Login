package br.edu.facear.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private Connection con;
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public ConnectDB(){
		driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		url = "jdbc:sqlserver://localhost:1433;databaseName=MY_LOGIN";
		username = "sa";
		password = "693277268677";
	}
	public Connection getConnection() throws IOException,ClassNotFoundException,SQLException{
		Class.forName(driver);
		this.con = DriverManager.getConnection(url,username,password);
		return this.con;
	}
}
