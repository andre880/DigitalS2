<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Curso</title>
<c:url value="/resources/css/bootstrap.min.css" var="css"/>
<link rel="stylesheet" type="text/css" href="${css }"> 
</head>
<body>

	<div class="container">
		<c:url value="/curso/editar" var="action"/>
		<form:form action="${action }" method="post" commandName="curso">
			<form:hidden path="codigo"/>
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
			<div class="form-group">
				<form:label path="data">Data</form:label>
				<form:input path="data" cssClass="form-control"/>
				<form:errors path="data"/>
			</div>
			<div class="form-group">
				<form:label path="cargaHoraria">Horas</form:label>
				<form:input path="cargaHoraria" cssClass="form-control"/>
				<form:errors path="cargaHoraria"/>
			</div>
			<input type="submit" value="Salvar" class="btn btn-primary">
		</form:form>
	</div>

</body>
</html>