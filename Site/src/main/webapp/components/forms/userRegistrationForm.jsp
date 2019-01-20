<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="post" action="UserHandler?op=registerUser" id="userRegistrationForm">


		<div class="form-group">
			<p>Nome</p>
			<input maxlength="40" class="form-control" type="text" name="txtNome" id="txtNome">
		</div>
		
		<div class="form-group">
			<p>Cognome</p>
			<input maxlength="40" class="form-control" type="text" name="txtCognome" id="txtCognome">
		</div>
		
		<div class="form-group">
			<p>Sesso</p>
			<select class="form-control" name="sltSesso"  id="sltSesso">
					<option value="M">Maschio</option>
					<option value="F">Femmina</option>
			</select>
		</div>
		
		<div class="form-group">
			<p>Numero telefonico</p>
			<input maxlength="10" class="form-control" type="number" name="txtNumeroTelefonico" id="txtNumeroTelefonico">
		</div>
		
		<div class="form-group">
			<p>Email</p>
			<input maxlength="254" class="form-control" type="email" name="txtEmail" id="txtEmail">
		</div>
		
		<div class="form-group">
			<p>Password</p>
			<input maxlength="64" class="form-control" type="password" name="txtPassword" id="txtPassword">
		</div>
		
		<div class="form-group">
			<p>Conferma password</p>
			<input maxlength="64" class="form-control" type="password" name="txtConfermaPassword" id="txtConfermaPassword">
		</div>
		
		
		<div class="form-group">
			<input style="cursor: pointer;" class="btn btn-primary" type="submit" value="Registrati" id="btnSubmit">
		</div>

</form>

	<script>
	
	$( "#userRegistrationForm" ).submit(function( event ) {
		var emptyField = false;
		
		// passwords will be equals
		if($("#txtPassword").val() != $("#txtConfermaPassword").val()){
			alert("Le password non corrispondono");
			event.preventDefault();
		}
		else{
			// all field MUST be not empty
			$("input").each(function(){
				if($(this).val() == "" ){
					alert("Campo/i mancante, impossibile continuare");
					emptyField = true;
					return false;
					
				}
			});
			if(emptyField){
				event.preventDefault();
			}
		}

	});
	
	</script>