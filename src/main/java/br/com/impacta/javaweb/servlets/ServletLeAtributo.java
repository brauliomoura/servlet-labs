package br.com.impacta.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/le-atributo")
public class ServletLeAtributo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//escopo de request
		Integer cont1 = (Integer) request.getAttribute("contador");
		
		//escopo de sessao
		Integer cont2 = (Integer) request.getSession().getAttribute("contador");
		
		//escopo de aplicação/contexto
		Integer cont3 = (Integer) this.getServletContext().getAttribute("contador");
		
		PrintWriter out = response.getWriter();
		
		out.println("<HTML><H2>");
		out.println("Contador escopo request = " + cont1);
		out.println("Contador escopo sessão = " + cont2);
		out.println("Contador escopo aplicacao = " + cont3);
		out.println("</H2></HTML>");
		
		
	}

}
