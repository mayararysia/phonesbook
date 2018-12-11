<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.phonesbook.model.Contacts" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Phones Book - Contatos</title>
		<link rel="stylesheet" href="src/css/style.css">
	</head>
	
	<body>
		<div class="container">
			<div class="title-box">
				<div class="" style="width: 100%;"><span class="title">Alterar Contato</span></div>
			</div>
			
			<form class="add-form" action="edit-contacts" method="post" var<%=request.getAttribute("contact")%>>
				<div class="form-group" hidden="true">				
					<label for="id" class="id"></label>
	      			<input type="text" id="id" name="id" class="" value="${contact.id}" placeholder="Id" autofocus>
	      		</div>
				
				<div class="form-group">				
					<label for="name" class="">Nome</label>
	      			<input type="text" id="name" name="name" class="" value="${contact.name}" placeholder="Nome" autofocus>
	      		</div>
	      		
	      		<div class="form-group">
	      			<label for="phone_number" class="">Telefone Fixo</label>
	      			<input type="text" id="phone_number" name="phone_number" class="" value="${contact.phone_number}" placeholder="Telefone Fixo">
	      		</div>
	      		
	      		<div class="form-group">
	      			<label for="mobile_number" class="">Telefone Celular</label>
	      			<input type="text" id="mobile_number" name="mobile_number" class="" value="${contact.mobile_number}" placeholder="Telefone Celular">
	      		</div>
	      		
	      		<div class="form-group">
	      			<label for="email_address" class="">E-mail</label>
	      			<input type="text" id="email_address" name="email_address" class="" value="${contact.email_address}" placeholder="E-mail">
	      		</div>
	      		
	      		<div class="form-group">
	      			<input type="submit" value="Salvar" class="btn btn-lg btn-primary btn-block">
	      		</div>
	
	      		<div class="register mb-3">
	      			<label title="Voltar"><a href="/phonesBook/" class="waves-effect"><img src="src/img/voltar-50px.png"/></a></label>
	      		</div>
			</form>
	    </div>
	</body>
</html>