<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Ingressos</title>
<c:url value="/resources/css/bootstrap.min.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css}">
</head>
<body>

	<h1>Lista de Ingressos</h1>
	<table class="table">
		<tr>
			<th>Cadeira</th>
			<th>Data</th>
			<th>Setor</th>
			<th>Valor</th>
		</tr>
		<c:forEach items="${lista }" var="i">
			<tr>
				<td>${i.cadeira }</td>
				<td>
					<fmt:formatDate value="${i.data.time}"
						pattern="dd/MM/yyyy" />
				</td>
				<td>${i.setor.nome }</td>
				<td>${i.setor.valor }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>