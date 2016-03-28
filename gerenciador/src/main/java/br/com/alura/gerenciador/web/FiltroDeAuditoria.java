package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Exemplo de como fazer uma auditoria de acesso ao sistema
 * Usando um filtro onde todas as solicitações de acesso 
 * passa por aqui primeiro. 
 * */
//@WebFilter(urlPatterns="/*") // *** Detalhe diferente da outras classe Servlet
public class FiltroDeAuditoria /*implements Filter*/{

	/*@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request; // Recebe a solicitação do usuário
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String urlAcessada = req.getRequestURI(); // Obtém a URI solicitada pelo usuário

		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		String usuario = "<deslogado>";
		if(cookie != null) {
			cookie.setMaxAge(10*60); // Define para durar 10min o tempo de vida do cookie
			resp.addCookie(cookie); // Atualizar o tempo de vida do cookie mandando de votla para o cliente
			usuario = cookie.getValue(); // Pega o usuario logado
		}
		System.out.println("Usuário "+ usuario +" acessou a URI: "+urlAcessada);

		chain.doFilter(request, response); //Informa a servlet para continua seu fluxo de chamadas 
	}
	
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}*/
	
}
