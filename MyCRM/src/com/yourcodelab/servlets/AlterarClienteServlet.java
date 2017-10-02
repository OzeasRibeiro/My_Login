package com.yourcodelab.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourcodelab.controller.ClienteController;
import com.yourcodelab.model.Cliente;

/**
 * Servlet implementation class AlterarClienteServlet
 */
@WebServlet("/AlterarClienteServlet")
public class AlterarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/listarClientes.jsp";
		
		String id = request.getParameter("id");
		String nomeCompleto = request.getParameter("nomeCompleto");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String limiteCredito = request.getParameter("limiteCredito");
		
		if(id != null){
			Integer x = new Integer(Integer.parseInt(id));
		try{
			Cliente cliente = new Cliente(x, nomeCompleto, cpf, email, Float.valueOf(limiteCredito));
			ClienteController controll = new ClienteController();
			controll.alterarCliente(cliente);
			 
			request.setAttribute("cliente", cliente);
			
			nextPage = "/listarClientes.jsp";
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
  }
}
