<%@page import="java.util.List"%>
<%@page import="br.com.base.service.*"%>
<%@page import="br.com.base.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Contato</title>
</head>
<body style="background-color: aqua;">
	<fieldset style="color: black;">
		<div align="center">
			<h2>Cadastro de Contato</h2>
			
			<form action="CadastroContatoController" method="POST">
				Nome : <input id="nome" name="nome" type="text" /><br/><br/>
				E-mail : <input id="email" name="email" type="text" /><br/><br/> 
				Tel. : <input id="tel" name="telefone" type="text" /><br/><br/>
				
				<div align="center">
					<input id="enviar" value="Enviar" type="submit"/>
					<input id="limpar" value="Limpar" type="reset"/>
				</div>
			</form>
		</div>
		<div align="left">
		<br>
		<br>
				<table>
				  <tr>
				    <th>ID</th>
				    <th>Nome</th>
				    <th>Email</th>
				    <th>Telefone</th>
				    <th>Operação</th>
				  </tr>
		
			<%
				ContatoService service = new ContatoService();
				List<Contato> contatos = service.listarContato();
				
				for(Contato c : contatos){ %>
<!-- 				<br/> -->
<%-- 				<p>Nome : <%= c.getNome()%></p> --%>
<%-- 				<p>Email :<%= c.getEmail()%></p> --%>
<%-- 				<p>Telefone : <%= c.getTelefone()%></p> --%>
<!-- 				<br/> -->
				  <tr>
				    <td><%= c.getId().toString() %></td>
				    <td><%= c.getNome()%></td>
				    <td><%= c.getEmail()%></td>
				    <td><%= c.getTelefone()%></td>
				    <td><button type="submit" ac>Apagar</button></td>
				  </tr>
				</table>
				
				<hr>
			<% } %>		
				
		
		</div>
	</fieldset>
	
</body>
</html>