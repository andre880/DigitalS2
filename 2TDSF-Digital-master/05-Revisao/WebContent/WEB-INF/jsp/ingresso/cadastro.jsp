<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Ingresso</title>
<c:url value="/resources/css/bootstrap.min.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css}">
</head>
<body>
	
	<h1>Cadastro de Ingresso</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg }</div>
	</c:if>
	<c:url value="/ingresso/cadastrar" var="action"/>
	<form:form action="${action }" method="post" commandName="ingresso">
		<div class="form-group">
			<form:label path="cadeira">Cadeira</form:label>
			<form:input path="cadeira" cssClass="form-control"/>
			<form:errors path="cadeira"/>
		</div>
		<div class="form-group">
			<form:label path="setor">Setor</form:label>
			<form:select path="setor.codigo" cssClass="form-control">
				<form:options items="${setores }"
					itemLabel="nome" itemValue="codigo"/>
			</form:select>
			<form:errors path="setor"/>
		</div>
		<div class="form-group">
			<form:label path="data">Data</form:label>
			<form:input path="data" cssClass="form-control"/>
			<form:errors path="data"/>
		</div>
		<input type="submit" value="OK" class="btn btn-primary">
	</form:form>

</body>
</html>





