<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form method="post" action="ServicesHandler?op=addService">

	<div class="form-group">
		<p>Nome servizio</p>
		<input class="form-control" type="text" name="txtNomeServizio" id="txtNomeServizio">
	</div>

	<div class="form-group">
		<p>Prezzo</p>
		<input class="form-control" type="number" name="txtPrezzo" id="txtPrezzo">
	</div>

	<div class="form-group">
		<p>Durata media servizio</p>
		<input class="form-control" type="time" name="txtTempoMedio" id="txtTempoMedio">
	</div>

	<div class="form-group">
		<p>Data inizio</p>
		<input class="form-control" type="date" name="txtDataInizio" id="txtDataInizio">
	</div>
	
	<div class="form-group">
		<p>Data fine</p>
		<input class="form-control" type="date" name="txtDataFine" id="txtDataFine">
	</div>

	<div class="form-group">
		<p>Orario inizio</p>
		<input class="form-control" type="time" name="txtOrarioInizio" id="txtOrarioInizio">
	</div>
	
	<div class="form-group">
		<p>Orario fine</p>
		<input class="form-control" type="time" name="txtOrarioFine" id="txtOrarioFine">
	</div>

	<div class="form-group">
		<p>Descrizione</p>
		<input class="form-control" type="text" name="txtDescrizione" id="txtDescrizione">
	</div>

	<div class="form-group">
		<p>Dettagli aggiuntivi</p>
		<input class="form-control" type="text" name="txtAltriDettagli" id="txtAltriDettagli">
	</div>
	
	<div class="form-group">
		<p>Foto</p>
		<input class="form-control" type="file" name="txtContenutiMultimediali" id="txtContenutiMultimediali">
	</div>
	

	<div class="form-group">
		<input style="cursor: pointer;" class="btn btn-primary" type="submit" value="Registra il servizio">
	</div>
</form>