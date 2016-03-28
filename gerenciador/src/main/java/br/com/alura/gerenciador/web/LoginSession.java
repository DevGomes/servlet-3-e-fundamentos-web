package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class LoginSession implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		if(usuario == null) {
			request.setAttribute("mensagemLogin", "Usuário ou senha inválida");			
			return "/WEB-INF/paginas/mensagemLogin.jsp";
		} 
		
		HttpSession session = request.getSession(); // Pega a sessão do usuario
		session.setAttribute("usuarioLogado", usuario); // Armazena no servidor a sessão do usuario
		request.setAttribute("mensagemLogin", "Usuário logado: "+email + "");
		
		return "/WEB-INF/paginas/mensagemLogin.jsp";
	}
}
