package br.com.impacta.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lab1")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String sobreNome = request.getParameter("sobrenome");
		
		PrintWriter writer = response.getWriter();
		writer.println("<HTML><H3>Nome informado: " + nome + "<p>");
		writer.println("Sobrenome informado: " + sobreNome + "</H3></HTML>");
		
	}

}
