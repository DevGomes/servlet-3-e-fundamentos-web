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

import br.com.alura.gerenciador.Usuario;

/*
 * Exemplo de como fazer uma auditoria de acesso ao sistema
 * Usando um filtro onde todas as solicitações de acesso 
 * passa por aqui primeiro. 
 * */
@WebFilter(urlPatterns="/*") // *** Detalhe diferente da outras classe Servlet
public class FiltroDeAuditoriaSession implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request; // Recebe a solicitação do usuário
		
		String urlAcessada = req.getRequestURI(); // Obtém a URI solicitada pelo usuário

		String usuario = getUsuario(req);
		
		System.out.println("Usuário "+ usuario +" acessou a URI: "+urlAcessada);

		chain.doFilter(request, response); //Informa a servlet para continua seu fluxo de chamadas 
	}
	
	public String getUsuario(HttpServletRequest req) {
		
		// Verifica se o usuario logou na sua sessão
		Usuario usuario = (Usuario)req.getSession().getAttribute("usuarioLogado");
		// Quando qualquer pagina do sistema for chamada o Servlet gera um cookie com um ID da sessão do usuário
		// e envia para ele a sua sessão, agora a session gerencia totalmente a sessão do usuario. 
		
		if(usuario == null) {
			return "<deslogado>";
		}
		
		return usuario.getEmail();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
