package br.edu.facear.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.edu.facear.model.Cliente;
import br.edu.facear.util.ConnectDB;

public class ClienteDAO extends GenericDAO {

	private PreparedStatement ps;
	
	private Connection connect;
	
	private String LOGIN_SQL = "SELECT * FROM CLIENTE WHERE EMAIL = ? AND SENHA = ?;";
	
	private String LISTAR_CLIENTE = "SELECT * FROM CLIENTE;";
	
	private String OBTER_ID = "SELECT * FROM CLIENTE WHERE ID = ?;";
	
	public Cliente autenticar(String email, String senha) throws ClassNotFoundException, IOException, SQLException{
		Cliente c = null;
		//abrir conecxao
		connect = ConnectDB.getInstance().getConnection();
		
		//prepare statement
		ps = connect.prepareStatement(LOGIN_SQL);
		ps.setString(1, email);
		ps.setString(2, senha);
		
		
		ResultSet rs = ps.executeQuery();
	
			while(rs.next()){
				System.out.println("entrou");
				System.out.println(rs.getString("email"));
				c = new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"),rs.getString("email"),rs.getString("senha"));	
			}
		
		
		return c;
		
		
	}
	
public List<Cliente> listar() throws ClassNotFoundException,IOException,SQLException{
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		connect = ConnectDB.getInstance().getConnection();
		
		ps = connect.prepareStatement(LISTAR_CLIENTE);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs != null){
			while(rs.next()){
				Cliente c = new Cliente(rs.getInt("id"), 
										rs.getString("nome"),
										rs.getString("cpf"), 
										rs.getString("email"), 
										rs.getString("senha"));
				lista.add(c);
			}
		}
		closeConnection();
		
		return lista;
}

	public Cliente obertClientePorId(Integer id)throws ClassNotFoundException, IOException, SQLException{
		Cliente c = null;
		//abrir conecxao
		connect = ConnectDB.getInstance().getConnection();
		
		//prepare statement
		ps = connect.prepareStatement(OBTER_ID);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
	
			while(rs.next()){
			//	System.out.println("entrou");
			//	System.out.println(rs.getString("email"));
				c = new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"),rs.getString("email"),rs.getString("senha"));	
			}
		
		return c;
	}

}
