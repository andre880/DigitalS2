<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Cadastro de Tipo de Cerveja">
	<h1>Cadastro de Tipo de Cerveja</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg }</div>
	</c:if>
	
	<c:url value="/tipo/cadastrar" var="action"/>
	<form:form action="${action }" method="post" commandName="tipo">
		<div class="form-group">
			<form:label path="descricao">Descrição</form:label>
			<form:input path="descricao" cssClass="form-control"/>
		</div>			
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form:form>
	
</tag:template>



