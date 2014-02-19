<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Aluno</title>
</head>
<body>
	<form method="post" action="InserirAluno">
		<table>
			<tr>
				<td>Matricula:</td>
				<td><input type="text"  id="matricula" name="matricula"    /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" id="nome" name="nome"   /></td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="submit" value="Salvar">
			</td>
		</table>
	</form>
</body>
</html>