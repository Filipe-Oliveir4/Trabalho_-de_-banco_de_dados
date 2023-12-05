<%@ page import="java.util.*, com.u2.web.SpringDojo.model.LivroModel"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar livros</title>
</head>
<body>
	<% if(request.getSession().getAttribute("mensagem").equals("Não há livros")){
		out.println(request.getSession().getAttribute("mensagem"));
		request.getSession().removeAttribute("mensagem");
	}else{
		Queue<LivroModel> livros= (Queue<LivroModel>)request.getSession().getAttribute("livros");
		while(!livros.isEmpty()){
			LivroModel livro = livros.poll();
			out.println(livro.getTitulo()+" - "+livro.getEditora()+"</br>");
		}
	}
	
	%>
</body>
</html>