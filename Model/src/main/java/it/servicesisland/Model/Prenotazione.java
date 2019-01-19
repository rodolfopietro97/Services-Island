package it.servicesisland.Model;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 * @author Tiziana
 *
 */

public class Prenotazione {

	private Time orario;
	private Date giorno;
	private int utente;
	private int servizio;
	
	
	/**
	 * Constructor without parameters
	 */
	public Prenotazione() {
		
		this.orario=null;
		this.giorno=null;
		this.servizio=0;
		this.utente=0;
	}
	
	/**
	 * Constructor with parameters
	 * @param orario
	 * @param giorno
	 * @param utente
	 * @param servizio
	 */
	public Prenotazione(Time orario, Date giorno, int utente, int servizio) {
		super();
		this.orario = orario;
		this.giorno = giorno;
		this.utente = utente;
		this.servizio = servizio;
	}
	
	/**
	 * 
	 * @return orario
	 */
	public Time getOrario() {
		return orario;
	}
	
	/**
	 * 
	 * @param the orario to be set
	 */
	public void setOrario(Time orario) {
		this.orario = orario;
	}
	
	/**
	 * 
	 * @return giorno
	 */
	public Date getGiorno() {
		return giorno;
	}
	
	/**
	 * 
	 * @param giorno
	 */
	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}
	
	/**
	 * 
	 * @return utente
	 */
	public int getUtente() {
		return utente;
	}
	
	/**
	 * 
	 * @param utente
	 */
	public void setUtente(int utente) {
		this.utente = utente;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getServizio() {
		return servizio;
	}
	
	/**
	 * 
	 * @param servizio
	 */
	public void setServizio(int servizio) {
		this.servizio = servizio;
	}
	
	
}
