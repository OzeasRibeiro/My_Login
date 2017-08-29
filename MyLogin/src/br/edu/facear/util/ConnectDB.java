package br.edu.facear.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static ConnectDB conexaoUtil;

	public static ConnectDB getInstance() {
		if (conexaoUtil == null) {
			conexaoUtil = new ConnectDB();
		}
		return conexaoUtil;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost/mybd";
		String usuario = "root";
		String senha = "";
		Connection con = DriverManager.getConnection(url, usuario, senha);

		return con;
	}

	public static void main(String[] args) {
		try {
			System.out.println(getInstance().getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}