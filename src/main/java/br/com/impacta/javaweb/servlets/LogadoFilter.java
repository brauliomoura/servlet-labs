package br.com.impacta.javaweb.servlets;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javaweb.servlets.bean.Usuario;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/sistema" })
public class LogadoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//Verificar se o usuario está na sessão, se não estiver direciono para a tela de login (redirect)
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Usuario user = (Usuario) httpRequest.getSession().getAttribute("usuario");
		
		if(user == null) {
			((HttpServletResponse) response).sendRedirect("http://localhost:8080/servlet-labs/login.html");
		}//else {
			chain.doFilter(request, response);	
		//}
		
	}
}
