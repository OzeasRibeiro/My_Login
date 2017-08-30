package br.edu.facear.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class ClienteService {
	private ClienteDAO dao;
	
	public ClienteService(){
		dao = new ClienteDAO();
	}
	
	public Cliente obterClientePorId(Integer id) throws ClassNotFoundException, IOException, SQLException{
		return dao.obertClientePorId(id);
	}
	
	public List<Cliente> listar() throws ClassNotFoundException, IOException, SQLException{
		return dao.listar();
	}
	
	public Cliente alterarCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
		return dao.ALTERAR_CLIENTE(cliente);
		
	}
}
