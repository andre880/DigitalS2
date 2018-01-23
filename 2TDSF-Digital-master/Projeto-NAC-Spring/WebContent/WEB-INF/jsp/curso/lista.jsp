<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Cursos</title>
<c:url value="/resources/css/bootstrap.min.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css }"> 
</head>
<body>

	<div class="container">
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg }</div>
		</c:if>
		<table class="table">
			<tr>
				<th>Nome</th>
				<th>Carga Horária</th>
				<th>Valor</th>
				<th>Data</th>
				<th></th>
			</tr>
			<c:forEach items="${cursos }" var="c">
				<tr>
					<td>${c.nome }</td>
					<td>${c.cargaHoraria }</td>
					<td>${c.valor }</td>
					<td>
						<fmt:formatDate 
							pattern="dd/MM/yyyy"
							value="${c.data.time }" />
					</td>
					<td>
						<c:url value="/curso/editar/${c.codigo}" var="link"/>
						<a href="${link }">Editar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>