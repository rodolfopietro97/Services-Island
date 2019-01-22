<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="post" action="UserHandler?op=registerProfessonist" id="professionistRegistrationForm">


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
			<p>Codice Fiscale</p>
			<input maxlength="16" class="form-control" type="text" name="txtCodiceF" id="txtCodiceF">
		</div>
		
		<div class="form-group">
			<p>Partira IVA</p>
			<input maxlength="16" class="form-control" type="text" name="txtPartitaIVA" id="txtPartitaIVA">
		</div>
		
		<div class="form-group">
			<p>Professione</p>
			<input maxlength="40" class="form-control" type="text" name="txtProfessione" id="txtProfessione">
		</div>
		
		<div class="form-group">
			<p>Settore</p>
			<input maxlength="40" class="form-control" type="text" name="txtSettore" id="txtSettore">
		</div>
		
		<div class="form-group">
			<p>Sede fiscale</p>
			<input maxlength="50" class="form-control" type="text" name="txtSedeFiscale" id="txtSedeFiscale">
		</div>
		
		<div class="form-group">
			<p>Sede legale</p>
			<input maxlength="50" class="form-control" type="text" name="txtSedeLegale" id="txtSedeLegale">
		</div>
		
		<div class="form-group">
			<input style="cursor: pointer;" class="btn btn-primary" type="submit" value="Registrati" id="btnSubmit">
		</div>

</form>

	<script>
	
	$( "#professionistRegistrationForm" ).submit(function( event ) {
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

<!-- <form>
	Nome<br>
 	<input type="text" name="nome"><br>
 	Cognome<br>
 	<input type="text" name="cognome"><br>
	Codice Fiscale<br>
	<input type="text" name="codiceFiscale"><br>
	Data di Nascita<br>
	<input type="text" name="dataDiNascita"><br>
	Email<br>
 	<input type="text" name="email"><br>
	Conferma Email<br>
	<input type="text" name="confermaEmail"><br>
	Password<br> 
	<input type="text" name="password"><br>
	Conferma Password<br> 
	<input type="text" name="confermaPassword"><br>
	Partita Iva<br>
	<input type="text" name="partitaIva"><br>
	Professione<br>
	<input type="text" name="professione"><br>
	Indirizzo Sede Legale<br>
	<input type="text" name="indirizzoSedeLegale"><br>
	Indirizzo Sede Fisica<br>
	<input type="text" name="indirizzoSedeFisica"><br></p>
	
	Paese<br>
	<select name="paese">
	<option value="I">Italia</option>
	<option value="E">Estero</option>
	</select><br>

	Residenza<br>
 	<input type="text" name="residenza"><br>
	
	
 	Sesso<br>
  	<input type="radio" name="sesso" value="M"> M<br>
  	<input type="radio" name="sesso" value="F"> F<br></p>
	
    Titolo di Studio<br>
	<select name="titoloDiStudio">
	<option value="I">SI</option>
	<option value="E">NO</option>
	</select><br>
   
	Qualifica<br>
	<select name="titoloDiStudio">
	<option value="Diploma">Diploma</option>
	<option value="Laurea Triennale">Laurea Triennale</option>
	<option value="Laurea Magistrale">Laurea Magistrale</option>
	</select><br>

	Laurea In<br>
	<input type="text" name="nomeLaurea"><br>
	

    
	<br><br>
  	<input type="submit" value="Submit">	<input type="submit" value="Submit with Facebook">	

</form>
 -->

