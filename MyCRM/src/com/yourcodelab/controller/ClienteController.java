package com.yourcodelab.controller;

import java.sql.SQLException;
import java.util.List;

import com.yourcodelab.dao.ClienteDAO;
import com.yourcodelab.model.Cliente;

public class ClienteController {
	private ClienteDAO dao = new ClienteDAO();
	
	public void inserirCliente(Cliente c){
		if(c != null)
			dao.inserir(c);
	}
	
	public List<Cliente> listarTodos(){
		return dao.listarTodos();
	}
	
	public void alterarCliente(Cliente c) throws ClassNotFoundException, SQLException{
		if(c != null)
			dao.alterarCliente(c);
	}
}
