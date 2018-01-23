<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>   


<tag:template title="Cadastro de Boteco">
	<h1>Cadastro de Boteco</h1>
	<form:form action="cadastrar" method="post" 
									commandName="boteco">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
			<form:errors path="nome"/>
		</div>
		<div class="form-group">
			<form:label path="endereco">Endere�o</form:label>
			<form:input path="endereco" cssClass="form-control"/>
			<form:errors path="endereco"/>			
		</div>
		<div class="form-group">
			<form:checkbox path="taxaServico"/>
			<form:label path="taxaServico">Taxa Servi�o</form:label>
		</div>
		<div class="form-group">
			<form:label path="entrada">Entrada</form:label>
			<form:input path="entrada" cssClass="form-control"/>
			<form:errors path="entrada"/>
		</div>
		<div class="form-group">
			<form:label path="dataInauguracao">Data de Inaugura��o</form:label>
			<form:input path="dataInauguracao" cssClass="form-control"/>
			<form:errors path="dataInauguracao"/>
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form:form>
</tag:template>