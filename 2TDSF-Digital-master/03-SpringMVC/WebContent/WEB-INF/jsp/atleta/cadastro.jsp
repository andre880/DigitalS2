<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Atleta</title>
</head>
<body>

	<h1>Cadastro de Atleta</h1>
	<form action="cadastrar" method="post">
		<div>
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="id-nome">
		</div>
		<div>
			<label for="id-altura">Altura</label>
			<input type="text" name="altura" id="id-altura">
		</div>
		<div>
			<label for="id-peso">Peso</label>
			<input type="text" name="peso" id="id-peso">
		</div>
		<input type="submit" value="Cadastrar">
	</form>

</body>
</html>