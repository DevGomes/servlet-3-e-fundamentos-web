<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado da busca</title>
</head>
<body>	
	<p>Resultado da busca: </p>
	<ul>
		<c:forEach var="empresa" items="${empresas}">
			<li>${empresa.id }: ${empresa.nome }</li>
		</c:forEach>
	</ul>
</body>
</html>