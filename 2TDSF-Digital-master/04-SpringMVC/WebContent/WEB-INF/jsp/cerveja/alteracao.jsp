<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Cadastro de Cerveja">
	<h1>Atualiza��o de Cerveja</h1>
	
	<c:url value="/cerveja/alterar" var="action"/>
	<form:form action="${action}" method="post" 
								commandName="cerveja">
		<form:hidden path="codigo" />						
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
		</div>	
		<div class="form-group">
			<form:label path="marca">Marca</form:label>
			<form:input path="marca" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="preco">Pre�o</form:label>
			<form:input path="preco" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="teorAlcoolico">Teor</form:label>
			<form:input path="teorAlcoolico" cssClass="form-control"/>
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
	</form:form>
</tag:template>