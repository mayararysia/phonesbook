<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.phonesbook.model.Contacts" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Phones Book - Contatos</title>
		<link rel="stylesheet" href="src/css/style.css">
	</head>
	
	<body>
		<div class="container">
			<div>
				<div class="left div-70"><span class="title">Contatos</span></div>
				
				<div class="right div-30">
					<label title="Adicionar Contato"><a href="/phonesBook/add-contacts"><img src="src/img/plus-25px.png" /></a></label>
				</div>
				
				<div class="right div-30">
					<label title="Adicionar Compromisso"><a href="/phonesBook/add-compromises"><img src="src/img/add-rule-25px.png"/></a></label>
				</div>
			</div>
			
			<table class="list-contacts-table">
		        <thead>
			        <tr>
			          <th style="width:25%;">Nome</th>
			          <th style="width:15%;">Telefone</th>
			          <th style="width:15%;">Celular</th>
			          <th style="width:25%;">E-mail</th>
			          <th style="width:10%;">Favorito</th>
			          <th></th>
			          <th style="width:10%;">Opção</th>
		          	</tr>
		        </thead>
		      
		        <tbody>
		        	<% ArrayList<Contacts> contacts = (ArrayList<Contacts>) request.getAttribute("contacts");%>
		        	<% for (Contacts contact : contacts) { %>
		        		<tr>
		        			<td><%= contact.getName() %></td>
		        			<td><%= contact.getPhone_number()  == null ? "" : contact.getPhone_number()   %></td>
		        			<td><%= contact.getMobile_number() == null ? "" : contact.getMobile_number()  %></td>
		        			<td><%= contact.getEmail_address() == null ? "" : contact.getEmail_address()  %></td>
		        			<td title="Favorito" style="text-align:center;">
		        				<% if(contact.getIs_favorite()) { %>
		        					<img src="src/img/star-filled.png" />
		        				<% } else { %>
		        					<img src="src/img/star.png" />
		        				<% } %>
		        			</td>
		        			<td></td>
		        			<td>
		        				<a title="Remover" class="left" href="/phonesBook/contacts?id=<%= contact.getId() %>&action=delete">
		        					<img src="src/img/delete.png" />
		        				</a>
		        				<a title="Editar" href="/phonesBook/contacts?id=<%= contact.getId() %>&action=edit">
		        					<img src="src/img/edit.png" />
		        				</a>
		        			</td>
		        		</tr>
		        	<% } %>
		      	</tbody>
		    </table>
	    </div>
	</body>
</html>