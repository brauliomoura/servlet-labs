package br.com.impacta.javaweb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javaweb.servlets.bean.Usuario;

/**
 * Servlet implementation class ValidaLogin
 */
@WebServlet("/valida-login")
public class ValidaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
				
		if(usuario == null) {
			
			usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			request.getSession().setAttribute("usuario", usuario);

		}	
		
		
		if(senha != null && senha.equals("impacta123")) {
			//encaminhar para a servlet sistema - pagina principal do sistema
			RequestDispatcher rd = request.getRequestDispatcher("/sistema");
			rd.forward(request, response);
		}else {
			//redirecionar a requisicao para a pagina de erro
			response.sendRedirect("http://localhost:8080/servlet-labs/erroLogin.html");
		}
		
		
	}

}
