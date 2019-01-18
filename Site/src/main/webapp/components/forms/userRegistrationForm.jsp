<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form>

	Nome<br> <input type="text" name="nome"><br> Cognome<br>
	<input type="text" name="cognome"><br> Codice Fiscale<br>
	<input type="text" name="codiceFiscale"><br> Data di
	Nascita<br> <input type="text" name="dataDiNascita"><br>
	Email<br> <input type="text" name="email"><br>
	Conferma Email<br> <input type="text" name="confermaEmail"><br>
	Password<br> <input type="text" name="password"><br>
	Ripeti Password<br> <input type="text" name="confermaPassword">
	</p>


	Paese<br> <select name="paese">
		<option value="I">Italia</option>
		<option value="E">Estero</option>
	</select><br>
	</p>

	Residenza<br> <input type="text" name="residenza"><br>
	</p>

	Sesso<br> <input type="radio" name="sesso" value="M"> M<br>
	<input type="radio" name="sesso" value="F"> F<br> <br>
	<br> <input type="submit" value="Submit"> <input
		type="submit" value="Submit with Facebook">

</form>