<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${usuarioLogado != null}">
    Voce esta logado como ${usuarioLogado.email}<br/>
</c:if>
<br/>

<form action="executar" method="POST">
	<input type="hidden" name="acao" value="NovaEmpresa" />
	Nome: <input type="text" name="nome" /><br />
	<input type="submit" value="Enviar" />
</form>

<form action="executar" method="POST">
	<input type="hidden" name="acao" value="LoginSession"> <!-- Passa os parametros "?acao=LoginSession" -->
	Email:<input type="email" name="email"/>
	Senha:<input type="password" name="senha" />
	<input type="submit" value="Login"/>
</form>

<form action="executar" method="POST">
	<input type="hidden" name="acao" value="LogoutSession"> <!-- Passa os parametros "?acao=LogoutSession" -->
	<input type="submit" value="Logout" />
</form>

</body>
</html>