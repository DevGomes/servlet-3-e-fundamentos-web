package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class BuscaEmpresa implements Acao{
	
	public String executa(HttpServletRequest req, HttpServletResponse resp){
		
		// Pega o parametro digitado pelo usuario na requisição
		String paramFiltro = req.getParameter("filtro");
		
		// Retorna uma lista de empresa de acordo a informação do cliente passado via parametro
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(paramFiltro);
		
		req.setAttribute("empresas", empresas); // Passando para view a lista de empresas do filtro

		return "/WEB-INF/paginas/buscaEmpresa.jsp";
		
	}
}
