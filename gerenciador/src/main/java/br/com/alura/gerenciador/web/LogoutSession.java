package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutSession implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response){
		
		// Remove o atribudo da sessão do usuario - logout do usuario
		request.getSession().removeAttribute("usuarioLogado"); 
		//request.getSession().invalidate(); // Removendo toda a sessão do usuario - outra forma do logout do usuario
		
		return "/WEB-INF/paginas/logout.html";
	}

}
