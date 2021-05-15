package br.com.impacta.javaweb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletParam
 */
@WebServlet(description = "Criando um formulário web de cadastro de usuários", urlPatterns = { "/sucesso" })
public class ServletParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		StringBuilder html = new StringBuilder();
		
		html.append("<!DOCTYPE html><html><head>"); 
		html.append("<meta charset=\"ISO-8859-1\">"); 
		html.append("<title>Sucesso</title>"); 
		html.append("</head><body>");
		html.append("<h1>Cadastro realizado com sucesso!</h1>");
		html.append("<h3>Nome:</h3>");
		html.append("<p>");
		html.append(nome);
		html.append("</p>");
		html.append("<h3>Login:</h3>");
		html.append("<p>");
		html.append(login);
		html.append("</p>");
		html.append("</body></html>");
		
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
