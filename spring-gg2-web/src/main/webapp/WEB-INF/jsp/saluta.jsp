<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello! Mi hai trovato!</h1>
	<h2>Oggi: ${adesso}</h2>
	
	<ul>
		<c:forEach items="${persone}" var="p">
			<li>${p.nome} ${p.cognome}</li>
		</c:forEach>
	</ul>
<h1>${ inesistente }</h1>
</body>
</html>