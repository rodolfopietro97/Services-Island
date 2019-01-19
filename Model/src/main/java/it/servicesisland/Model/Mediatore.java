package it.servicesisland.Model;

/**
 * 
 * @author Tiziana
 *
 */

public class Mediatore {
	
	private Long codice;
	private String nome;
	private String email;
	private String password;
	
	
	public Mediatore() {
		super();
		this.nome = null;
		this.email = null;
		this.password = null;
	}
	
	/**
	 * 
	 * @param nome
	 * @param email
	 * @param password
	 */
	public Mediatore(String nome, String email, String password) {
		super();
		this.nome = nome;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * 
	 * @return codice
	 */
	public Long getCodice() {
		return codice;
	}
	
	/**
	 * 
	 * @param codice
	 */
	public void setCodice(Long codice) {
		this.codice = codice;
	}
	
	/**
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param set the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param set the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
