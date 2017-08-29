package br.edu.facear.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.AutenticarUsuarioService;

/**
 * Servlet implementation class AutenticarUsuarioServlet
 */
@WebServlet("/Login")
public class AutenticarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		AutenticarUsuarioService usuario = new AutenticarUsuarioService();
		
		
		System.out.println(email+"   "+senha);
		
		//obter do banco de dados
		Cliente c = usuario.autenticar(email, senha);
		
		//colocar na area de memoria da sessão
		
		request.setAttribute("cliente", c);
		
		
		
		String nextPage = "/index2.html";
		
		if(c !=null)
			nextPage = "/principal.jsp";
		
			
		RequestDispatcher rd= getServletContext().getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
	}

}
