<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<article>
    <input type="hidden" value="${sessionScope.id}" name="txtCodiceUtente" id="txtCodiceUtente" >
	<h1>Le tue prenotazioni:</h1>
	<div id="bookingContainer" style="text-align: center; margin-top: 20px;">
	</div>
</article>


<script>
	$(document).ready(function(){
		setInterval(function(){ 
			$.ajax({
				url: "ServicesHandler",
				type: "post",
				async: true,
				data: {
					"op" : "getPrenotations",
					"utente" : $('#txtCodiceUtente').val()
				},
				error : function(request, state, error){
					console.log("Errore nelle notifiche" + request + state + error);
				},
				success : function(result){
					if(result != ""){
						$('#bookingContainer').empty();
						$('#bookingContainer').append(result);
					}
					else{
						$('#bookingContainer').empty();
						$('#bookingContainer').append("<p> NON ci sono prenotazioni effettuate</p>");
					}
				}
			});
		}, 1000);
	
	});
</script>

