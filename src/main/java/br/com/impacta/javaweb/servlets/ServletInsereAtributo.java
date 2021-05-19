package br.com.impacta.javaweb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insere-atributo")
public class ServletInsereAtributo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int contador = 1;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contador++;
		
		//escopo de request
		request.setAttribute("contador", contador);
		
		//escopo de sessao
		request.getSession().setAttribute("contador", contador);
		
		//escopo de aplicação/contexto
		this.getServletContext().setAttribute("contador", contador);
		
		
	}
	
	
	
	

}
