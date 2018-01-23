<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tag:template title="Edição de Boteco">
	<h1>Editar Boteco</h1>
	<c:url value="/boteco/alterar" var="action"/>
	<form:form action="${action }" 
				method="post" commandName="boteco">
		<form:hidden path="codigo"/>		
		<div class="form-group">
			<form:label path="Nome">Nome</form:label>
			<form:input path="Nome" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="Endereco">Endereço</form:label>
			<form:input path="Endereco" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="Entrada">Entrada</form:label>
			<form:input path="Entrada" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:checkbox path="TaxaServico"/>
			<form:label path="TaxaServico">Taxa Serviço</form:label>
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
	</form:form>
</tag:template>