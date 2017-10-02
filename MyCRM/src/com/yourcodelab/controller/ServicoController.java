package com.yourcodelab.controller;

import java.util.List;

import com.yourcodelab.dao.ServicoDAO;
import com.yourcodelab.model.Cliente;
import com.yourcodelab.model.Servico;

public class ServicoController {

	private ServicoDAO dao = new ServicoDAO();
	
	public void inserirServico(Servico s){
		if(s != null)
			dao.inserirServico(s);
	}
	
	public List<Servico> listarTodos(){
		return dao.listarTodos();
	}
}
