<%@page import="br.infnet.domain.Aluno"%>
<%@page import="br.infnet.dao.AlunoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alunos Cadastrados</title>
</head>
<body>
<h2>Alunos Cadastrados</h2>
<h3><a href="AddAluno.jsp">Incluir</a></h3>
	<table border=2>
		<tr>
			<th align="left">Matricula</th>
			<th align="left">Nome</th>
			<th> </th>
		</tr>
		<tr>
			<%
				AlunoDAO dao = new AlunoDAO();
				for (Aluno aluno : dao.selecionar()) {
			%>
		
		<tr>
			<td>
				<%
					out.print(aluno.getMatricula());
				%>
			</td>

			<td>
				<%
					out.print(aluno.getNome());
				%>
			</td>
			<td><a href="AtualizarAluno?id=<%
					out.print(aluno.getMatricula());
				%>"  >Editar
			</a>
			<a href="ExcluirAluno?id=<%
					out.print(aluno.getMatricula());
				%>"  >Excluir
			</a>
			</td>
		</tr>
		<%} %>
	</table>

</body>
</html>