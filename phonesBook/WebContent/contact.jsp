<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Phones Book - Contatos</title>
		<link rel="stylesheet" href="src/css/style.css">
	</head>
	
	<body>
		<div class="container">
			<div class="title-box">
				<div class="" style="width: 100%;"><span class="title">Contato</span></div>
			</div>
			
			<form class="add-form" action="add-contacts" method="post">
				<div class="form-group">				
					<label for="name" class="">Nome</label>
	      			<input type="text" id="name" name="name" class="" placeholder="Nome" autofocus>
	      		</div>
	      		
	      		<div class="form-group">
	      			<label for="phone_number" class="">Telefone Fixo</label>
	      			<input type="text" id="phone_number" name="phone_number" class="" placeholder="Telefone Fixo">
	      		</div>
	      		
	      		<div class="form-group">
	      			<label for="mobile_number" class="">Telefone Celular</label>
	      			<input type="text" id="mobile_number" name="mobile_number" class="" placeholder="Telefone Celular">
	      		</div>
	      		
	      		<div class="form-group">
	      			<label for="email_address" class="">E-mail</label>
	      			<input type="text" id="email_address" name="email_address" class="" placeholder="E-mail">
	      		</div>
	      		
	      		<div class="form-group">
	      			<input type="submit" value="Salvar" class="btn btn-lg btn-primary btn-block">
	      		</div>
	
	      		<div class="register mb-3">
	      			<label title="Voltar" ><a href="/phonesBook/" class="waves-effect"><img src="src/img/voltar-50px.png"/></a></label>
	      		</div>
			</form>
	    </div>
	</body>
</html>