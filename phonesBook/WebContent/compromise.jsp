<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Phones Book - Contatos</title>
	<link rel="stylesheet" href="src/css/style.css">
	
<!-- 	<link rel="stylesheet"href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" /> -->
<!-- 	<script src="http://code.jquery.com/jquery-1.8.2.js"></script> -->
<!-- 	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script> -->
</head>

<body>
	<div class="container">
		<div class="title-box">
			<div class="" style="width: 100%;">
				<span class="title">Registrar Compromisso</span>
			</div>
		</div>

		<form class="add-form" action="add-compromises" method="post">
			<div class="form-group">
				<label for="title">Título</label> <input type="text" id="title" name="title" placeholder="Título" autofocus>
			</div>

			<div class="form-group">
				<textarea rows="4" cols="50" id="desc" name="desc" for="desc">Insira a descrição...</textarea>
			</div>

			<div class="form-group">
				<label for="type">Tipo</label>
				<select id="type" name="type" style="height: 35px">
					<option value="reuniao">REUNIÃO</option>
					<option value="medico" selected>MÉDICO</option>
					<option value="exercicio">EXERCÍCIO</option>
					<option value="tarefa">TAREFA</option>
					<option value="outros" >OUTROS</option>
				</select>
			</div>

			<div class="form-group">
<!-- 				<input type="text" id="email_address" name="email_address" class="" -->
<!-- 					placeholder="E-mail"> -->
<!-- 				<p> -->
<!-- 					Data: <input type="text" id="calendario" /> -->
<!-- 				</p> -->
				<label for="date" >Data</label>
				<input  type="text" id="date" name="date" placeholder="DD/MM/YYYY" autofocus>
			</div>

			<div class="form-group">
				<label for="time" class="">Hora</label> 
				<input type="text" id="time" name="time" placeholder="HH:MM" autofocus>
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