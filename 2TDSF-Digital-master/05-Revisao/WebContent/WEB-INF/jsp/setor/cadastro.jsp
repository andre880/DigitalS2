<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Setor</title>
<c:url value="/resources/css/bootstrap.min.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css}">
</head>
<body>

	<h1>Cadastro de Setor</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg }</div>
	</c:if>
	<c:url value="/setor/cadastrar" var="action"/>
	<form:form action="${action}" method="post" commandName="setor">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
			<form:errors path="nome"/>
		</div>
		<div class="form-group">
			<form:label path="valor">Valor</form:label>
			<form:input path="valor" cssClass="form-control"/>
			<form:errors path="valor"/>
		</div>
		<input type="submit" value="OK" class="btn btn-primary">
	</form:form>

</body>
</html>




