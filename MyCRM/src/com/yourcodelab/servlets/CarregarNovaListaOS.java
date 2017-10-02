package com.yourcodelab.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourcodelab.controller.ClienteController;
import com.yourcodelab.controller.ServicoController;
import com.yourcodelab.model.Cliente;
import com.yourcodelab.model.Servico;

/**
 * Servlet implementation class CarregarListaNovaOS
 */
@WebServlet("/CarregarListaNovaOS")
public class CarregarNovaListaOS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarregarNovaListaOS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				ServicoController servicocontroller = new ServicoController();
				
				List<Servico> listaservico = new ArrayList<Servico>();
				listaservico = servicocontroller.listarTodos();
				
				ClienteController clientecontroller = new ClienteController();
				List<Cliente> listacliente = clientecontroller.listarTodos();
				
				request.setAttribute("listaClientes", listacliente);
				
				request.setAttribute("listaServicos", listaservico);
				

				String nextJSP = "/inserirOS.jsp";
		        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		        dispatcher.forward(request, response);
				
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
