package br.com.impacta.javaweb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javaweb.servlets.bean.Usuario;

/**
 * Servlet implementation class SistemaServlet
 */
@WebServlet("/sistema")
public class SistemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		doPost(request,response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		Cookie[] cookies = request.getCookies();
		String cookEmail = null;

		// busca de um cookie gravado de nome email
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("email")) {
					cookEmail = cookie.getValue();
					break;
				}
			}
		}

		// caso o valor seja nulo, direciona a requisição para a servlet com url
		// /coletaEmail
		if (cookEmail == null || cookEmail.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/coletaEmail");
			rd.forward(request, response);
		}

		response.getWriter().append("<HTML><BODY><H1>Bem vindo " + usuario.getLogin() + "!</H1>")
				.append("<BR>Seu email é: " + cookEmail).append("<BR>Esta é a página principal do sistema.")
				.append("<BR><BR><a href=\"/servlet-labs/login.html\">Logout</a>").append("</BODY></HTML>");
	}

}
