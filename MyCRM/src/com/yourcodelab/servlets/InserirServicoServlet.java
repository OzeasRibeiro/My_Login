package com.yourcodelab.servlets;

import java.io.IOException;
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
 * Servlet implementation class InserirServicoServlet
 */
@WebServlet("/InserirServicoServlet")
public class InserirServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirServicoServlet() {
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
		ServicoController control = new ServicoController();
		
		//Obter parãmetros do formulário
		String categoria = request.getParameter("categoria");
		String status = request.getParameter("status");
		
		System.out.println(categoria);
		System.out.println(status);
		
		//Instanciar objeto cliente, o limite precisa ser convertido de String para float
		Servico s = new Servico(new Integer(0),categoria,status);
		
		//Invocar a camada de negócio
		control.inserirServico(s);
		
		//Obter a lista atualizada de Clientes
		List<Servico> lista = control.listarTodos();
		
		if(lista == null)
			lista = new ArrayList<Servico>();
		
		request.setAttribute("listaServico", lista);
		
		String nextJSP = "/servico/listarServico.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
	}

}
