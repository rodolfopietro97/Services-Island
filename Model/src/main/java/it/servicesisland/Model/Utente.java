package it.servicesisland.Model;


public class Utente {
	
	private Long codice;
	private String nome;
	private String cognome;
	private String sesso;
	private String email;
	private String password;
	private boolean professionista;
	private Long telefono;
	
	public void setCodice(Long codice) {
		this.codice = codice;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public String getSesso() {
		return this.sesso;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean getProfessionista() {
		return this.professionista;
	}
	
	public Long getTelefono() {
		return this.telefono;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setProfessionista(boolean professionista) {
		this.professionista = professionista;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	
	

}
