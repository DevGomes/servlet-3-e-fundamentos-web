package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Acao {
	
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String nome = req.getParameter("nome");
		
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		
		req.setAttribute("infoEmpresa", empresa); // Envia um atributo para página JSP (View).
		System.out.println(">>>>>> Empresa adicionada com sucesso <<<<<<");
		
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
	
}


