package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.service.ClienteService;

/**
 * Servlet implementation class DeletarClienteServlet
 */
@WebServlet("/DeletarClienteServlet")
public class DeletarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Passo 1 - obter parametro Id pela URL
				String id = request.getParameter("id");
				
				String nextPage = "/listarClientes.jsp";
				//Passo 2 - Converter Id para integer
				if(id != null){
					Integer x =  new Integer(Integer.parseInt(id));
					
					//Passo 3 - Inserir lógica para chamar service
					ClienteService service = new ClienteService();
					try {
						
						service.deletarCliente(x);
						
						nextPage = "/principal.jsp";
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			
				//Passo 4 - redirecionar

				RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
				rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
