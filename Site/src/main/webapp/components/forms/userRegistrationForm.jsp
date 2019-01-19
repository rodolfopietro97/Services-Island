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
			<p>Codice fiscale</p>
			<input class="form-control" type="text" name="txtCodiceFiscale">
		</div>
		<div class="form-group">
			<p>Data di nascita</p>
			<input class="form-control" type="date" name="txtData">
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
			<p>Nazionalità</p>
			<select class="form-control" name="sltNazionalita">
					<option value="I">Italia</option>
					<option value="E">Estero</option>
			</select>
		</div>
		
		<div class="form-group">
			<p>Residenza</p>
			<select name="sltResidenza">
					<option value="I">Italia</option>
					<option value="E">Estero</option>
			</select>
		</div>
		
		<div class="form-group">
			<p>Sesso</p>
			<select class="form-control" name="sltSesso">
					<option value="I">Italia</option>
					<option value="E">Estero</option>
			</select>
		</div>
		
		<div class="form-group">
			<input class="btn btn-primary" type="submit" value="Registrati">
		</div>


</form>