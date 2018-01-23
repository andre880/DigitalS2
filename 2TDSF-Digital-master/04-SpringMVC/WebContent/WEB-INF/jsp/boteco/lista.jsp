<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Lista de Botecos">
	<h1>Lista de Boteco</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<table class="table">
		<tr>
			<th>Nome</th>
			<th>Endereço</th>
			<th>Taxa</th>
			<th>Entrada</th>
			<th>Data Inauguração</th>
			<th></th>
		</tr>
		<c:forEach items="${botecos }" var="b">
			<tr>
				<td>${b.nome }</td>
				<td>${b.endereco }</td>
				<td>${b.taxaServico }</td>
				<td>${b.entrada }</td>
				<td>
					<fmt:formatDate pattern="dd/MM/yyyy"
						 value="${b.dataInauguracao.time}"/>
				</td>
				<td>
					<c:url value="/boteco/alterar/${b.codigo }" var="link"/>
					<a href="${link }">Editar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</tag:template>
