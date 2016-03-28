package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie cookie = new Cookies(request.getCookies()).getUsuarioLogado();
		if(cookie != null) {
			cookie.setMaxAge(0); // Mata o cookie
			response.addCookie(cookie); // Envia o cookie morto na resposta de volta para o cliente
		}
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>Logout efetuado </body></html>");
	}

}
