<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Lista de Cervejas">
	<h1>Cervejas Disponíveis</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg }</div>
	</c:if>
	
	<table class="table">
		<tr>
			<th>Nome</th>
			<th>Marca</th>
			<th>Preço</th>
			<th>Teor</th>
			<th>Data Validade</th>
			<th>Tipo</th>
			<th>Recipiente</th>
			<th></th>
		</tr>
		<c:forEach items="${cervejas }" var="c">
			<tr>
				<td>${c.nome }</td>
				<td>${c.marca }</td>
				<td>${c.preco }</td>
				<td>${c.teorAlcoolico }</td>
				<td>
					<fmt:formatDate value="${c.dataValidade.time }"
						pattern="dd/MM/yyyy" /> </td>
				<td>${c.tipo.descricao }</td>
				<td>${c.recipiente }</td>
				<td>
					<c:url value="/cerveja/alterar/${c.codigo }" var="link"/>
					<a href="${link }">Alterar</a>
					<c:url value="/cerveja/excluir/${c.codigo }" var="link2"/>
					<a href="${link2 }">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</tag:template>