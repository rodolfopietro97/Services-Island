<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="post" action="UserHandler?op=registerUser">


		<div class="form-group">
			<p>Nome</p>
			<input class="form-control" type="text" name="txtNome">
		</div>
		
		<div class="form-group">
			<p>Cognome</p>
			<input class="form-control" type="text" name="txtCognome">
		</div>
		
		<div class="form-group">
			<p>Sesso</p>
			<select class="form-control" name="sltSesso">
					<option value="M">Maschio</option>
					<option value="F">Femmina</option>
			</select>
		</div>
		
		<div class="form-group">
			<p>Numero telefonico</p>
			<input class="form-control" type="number" name="txtNumeroTelefonico">
		</div>
		
		<div class="form-group">
			<p>Email</p>
			<input class="form-control" type="email" name="txtEmail">
		</div>
		
		<div class="form-group">
			<p>Password</p>
			<input class="form-control" type="password" name="txtPassword">
		</div>
		
		<div class="form-group">
			<p>Conferma password</p>
			<input class="form-control" type="password" name="txtConfermaPassword">
		</div>
		
		
		<div class="form-group">
			<input class="btn btn-primary" type="submit" value="Registrati">
		</div>


</form>