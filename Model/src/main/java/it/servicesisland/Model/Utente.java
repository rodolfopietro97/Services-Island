package it.servicesisland.Model;


/**
 * User simple class
 * @author tiziana
 */
public class Utente {
	
	private Long codice;
	private String nome;
	private String cognome;
	private String sesso;
	private String email;
	private String password;
	private boolean professionista;
	private Long telefono;
	
	
	/**
	 * Constructor without parameters
	 */
	public Utente() {
		this.codice = null;
		this.nome = null;
		this.cognome = null;
		this.sesso = null;
		this.email = null;
		this.password =null;
		this.professionista = false;
		this.telefono = null;
	}
	
	/**
	 * Constructor with parameters
	 * @param codice of Utente
	 * @param nome of Utente
	 * @param cognome of Utente
	 * @param sesso of Utente
	 * @param email of Utente
	 * @param password of Utente
	 * @param professionista of Utente
	 * @param telefono of Utente
	 */
	public Utente(Long codice, String nome, String cognome, String sesso, String email, String password,
			boolean professionista, Long telefono) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.email = email;
		this.password = password;
		this.professionista = professionista;
		this.telefono = telefono;
	}

	/**
	 * @return the codice
	 */
	public Long getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(Long codice) {
		this.codice = codice;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the sesso
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * @param sesso the sesso to set
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the professionista
	 */
	public boolean isProfessionista() {
		return professionista;
	}

	/**
	 * @param professionista the professionista to set
	 */
	public void setProfessionista(boolean professionista) {
		this.professionista = professionista;
	}

	/**
	 * @return the telefono
	 */
	public Long getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	
	

}
