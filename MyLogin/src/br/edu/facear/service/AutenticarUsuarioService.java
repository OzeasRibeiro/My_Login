package br.edu.facear.service;

import java.io.IOException;
import java.sql.SQLException;

import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class AutenticarUsuarioService {
	
	public Cliente autenticar(String email, String senha) throws ClassNotFoundException, SQLException{
		ClienteDAO dao = new ClienteDAO();
		Cliente c = null;
	
			try {
					c = dao.autenticar(email, senha);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        return c ;
    }
}