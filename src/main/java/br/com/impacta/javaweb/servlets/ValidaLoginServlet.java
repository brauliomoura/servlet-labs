package br.com.impacta.javaweb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidaLoginServlet
 */
@WebServlet("/valida-login")
public class ValidaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(senha.equals("impacta123")) {
			//forward para a servlet de sistema
			RequestDispatcher dispatcher = request.getRequestDispatcher("/sistema");
			dispatcher.forward(request, response);
			
		}else {
			//redirect para pagina de erro
			response.sendRedirect("http://localhost:8080/servlet-labs/erroLogin.html");
		}
		
	}

}
