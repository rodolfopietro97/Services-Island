<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h1>I tuoi dati (seleziona i campi da modificare): </h1>

<form method="post" action="UserHandler?op=registerProfessonist" id="professionistRegistrationForm">


		<div class="form-group">
			<p>Nome</p>
			<input placeholder="${sessionScope.nome }" maxlength="40" class="form-control" type="text" name="txtNome" id="txtNome">
		</div>
		
		<div class="form-group">
			<p>Cognome</p>
			<input placeholder="${sessionScope.cognome }" maxlength="40" class="form-control" type="text" name="txtCognome" id="txtCognome">
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
			<input placeholder="${sessionScope.numero }" maxlength="10" class="form-control" type="number" name="txtNumeroTelefonico" id="txtNumeroTelefonico">
		</div>
		
		<div class="form-group">
			<p>Email</p>
			<input placeholder="${sessionScope.email }" maxlength="254" class="form-control" type="email" name="txtEmail" id="txtEmail">
		</div>
		
		<div class="form-group">
			<p>Password</p>
			<input maxlength="64" class="form-control" type="password" name="txtPassword" id="txtPassword">
		</div>
		
		<div class="form-group">
			<p>Conferma password</p>
			<input maxlength="64" class="form-control" type="password" name="txtConfermaPassword" id="txtConfermaPassword">
		</div>
		
	<c:if test="${not empty sessionScope.professionist}">
		<div class="form-group">
			<p>Codice Fiscale</p>
			<input placeholder="${sessionScope.codice_fiscale }" maxlength="16" class="form-control" type="text" name="txtCodiceF" id="txtCodiceF">
		</div>
		
		<div class="form-group">
			<p>Partira IVA</p>
			<input placeholder="${sessionScope.partita_iva }" maxlength="16" class="form-control" type="text" name="txtPartitaIVA" id="txtPartitaIVA">
		</div>
		
		<div class="form-group">
			<p>Professione</p>
			<input placeholder="${sessionScope.professione }" maxlength="40" class="form-control" type="text" name="txtProfessione" id="txtProfessione">
		</div>
		
		<div class="form-group">
			<p>Settore</p>
			<input placeholder="${sessionScope.settore }" maxlength="40" class="form-control" type="text" name="txtSettore" id="txtSettore">
		</div>
		
		<div class="form-group">
			<p>Sede fiscale</p>
			<input placeholder="${sessionScope.sede_fiscale }" maxlength="50" class="form-control" type="text" name="txtSedeFiscale" id="txtSedeFiscale">
		</div>
		
		<div class="form-group">
			<p>Sede legale</p>
			<input placeholder="${sessionScope.sede_legale }" maxlength="50" class="form-control" type="text" name="txtSedeLegale" id="txtSedeLegale">
		</div>
		

	</c:if>
	
		<div class="form-group">
			<input style="cursor: pointer;" class="btn btn-primary" type="submit" value="Modifica" id="btnSubmit">
		</div>

</form>