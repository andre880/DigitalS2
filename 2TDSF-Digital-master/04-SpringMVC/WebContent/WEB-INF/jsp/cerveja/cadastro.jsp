<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Cadastro de Cerveja">
	<h1>Cadastro de Cerveja</h1>
	
	<c:url value="/cerveja/cadastrar" var="action"/>
	<form:form action="${action}" method="post" 
								commandName="cerveja">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
			<form:errors path="nome" cssClass="text-danger"/>
		</div>	
		<div class="form-group">
			<form:label path="tipo">Tipo</form:label>
			<form:select path="tipo.codigo" cssClass="form-control">
				<form:options items="${tipos }"
					itemLabel="descricao" itemValue="codigo"/>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="tipo">Recipiente</form:label>
			<form:select path="recipiente" cssClass="form-control">
				<form:options items="${recipientes }"
					itemLabel="label"/>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="marca">Marca</form:label>
			<form:input path="marca" cssClass="form-control"/>
			<form:errors path="marca" cssClass="text-danger"/>
		</div>
		<div class="form-group">
			<form:label path="preco">Preço</form:label>
			<form:input path="preco" cssClass="form-control"/>
			<form:errors path="preco" cssClass="text-danger"/>
		</div>
		<div class="form-group">
			<form:label path="teorAlcoolico">Teor</form:label>
			<form:input path="teorAlcoolico" cssClass="form-control"/>
			<form:errors path="teorAlcoolico" cssClass="text-danger"/>
		</div>
		<div class="form-group">
			<form:label path="dataValidade">Data Validade</form:label>
			<form:input path="dataValidade" cssClass="form-control"/>
			<form:errors path="dataValidade" cssClass="text-danger"/>
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
	</form:form>
</tag:template>