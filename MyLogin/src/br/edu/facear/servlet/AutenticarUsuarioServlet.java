package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/AutenticarUsuarioServlet")
public class AutenticarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Acesso não permitido!!!!");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		AutenticarUsuarioService service = new AutenticarUsuarioService();
		//Obter de Banco de Dados
		Cliente c = null;
		try {
			c = service.autenticar(email, senha);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Colocar na area de memoria sessao
		request.setAttribute("cliente", c);
		
		String nextPage = "/index.html";
		
		if(c != null)
			//nextPage = "/principal.html";
		    nextPage = "/principal.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
		
		rd.forward(request, response);
		

		//System.out.println("Ola :  " + usuario + "sua senha é = " +senha);
	}

}
