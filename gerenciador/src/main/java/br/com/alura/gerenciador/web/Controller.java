package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Classe servlet unica que trata todos os redirecionamentos do sistema
 * */
@WebServlet(urlPatterns="/executar")
public class Controller extends HttpServlet {
	
	public Controller() {
		System.out.println("Instanciando uma servlet do tipo FazTudo "+this);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		System.out.println("Inicializando uma servelt do tipo FazTudo "+this);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
		System.out.println("Destruindo uma servlet do tipo FazTudo "+this);
	}
	
	// Método que é chamado tanto para todo tipo de requisição (Post, GET e etc.)
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Tarefa a ser executada pelo sistema 
		String acao = request.getParameter("acao");
		
		if(acao == null){
			throw new IllegalArgumentException("Você esqueceu de passar a ação");
		}
		
		// Pacote onde contem as classes de ação
		acao = "br.com.alura.gerenciador.web." + acao;
		
		try {
			Class<?> tipo = Class.forName(acao); // Instrução que devolve uma classe
			Acao instancia = (Acao) tipo.newInstance(); // Com o tipo obtido na instrução anterior, instancia o objeto
			
			String pagina = instancia.executa(request, response); // Executa a logia da classe de ação
			
			// Faz redirecionamento no lado do servidor
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		} 
		
	}
}
