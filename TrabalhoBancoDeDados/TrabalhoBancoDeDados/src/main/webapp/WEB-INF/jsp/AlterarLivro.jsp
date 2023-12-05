<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<td><font color="red" size="14"><%= request.getSession().getAttribute("mensagem")!= null ?request.getSession().getAttribute("mensagem"):""  %></font>
	<form name="form1" method="get" action="/alterarLivro">
		<table>
			<tr>
				<td><font color="red" size="14"><%= request.getSession().getAttribute("mensagem")!= null ?request.getSession().getAttribute("mensagem"):""  %></font>
			</tr>
			<tr>
				<td>Digite os dados do livro</td>
			</tr>
		
			<tr>
				<td>Título do livro para alterar</td>
				<td><input type="text" name="titulo"></td>
			</tr>
			
			<tr>
				<td>Novo título</td>
				<td><input type="text" name="novoTitulo"></td>
			</tr>
			
			<tr>
				<td>Nova Editora(Caso não queira alterar a editora, deixe em branco)</td>
				<td><input type="text" name="novaEditora"></td>
			</tr>
			<tr>
				<td><button type="submit" >Enviar</button></td>
				<td><input type="reset" value="Limpar"></td>
			</tr>
		
		</table>
</form>
<% request.getSession().removeAttribute("mensagem"); %>
</body>
</html>