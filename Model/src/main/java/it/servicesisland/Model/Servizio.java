package it.servicesisland.Model;


import java.sql.Date;
import java.sql.Time;

/**
 * Service simple class
 * @author tiziana
 */
public class Servizio {
	
	private Long codice;
	private double prezzo;
	private Time orario;
	private Date giorno;	
	private String descrizione;
	private boolean approvato;
	private int professionista;
	
	/**
	 * Constructor without parameters
	 */
	public Servizio() {
		this.codice = null;
		this.prezzo = 0;
		this.orario = null;
		this.giorno = null;
		this.descrizione = null;
		this.approvato = false;
		this.professionista = 0;
	}
	
	
	/**
	 * Constructor with parameters
	 * @param codice of Servizio
	 * @param prezzo of Servizio
	 * @param orario of Servizio
	 * @param giorno of Servizio
	 * @param descrizione of Servizio
	 * @param approvato of Servizio
	 * @param professionista of Servizio
	 */
	public Servizio(Long codice, double prezzo, Time orario, Date giorno, String descrizione, boolean approvato,
			int professionista) {
		this.codice = codice;
		this.prezzo = prezzo;
		this.orario = orario;
		this.giorno = giorno;
		this.descrizione = descrizione;
		this.approvato = approvato;
		this.professionista = professionista;
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
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}
	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	/**
	 * @return the orario
	 */
	public Time getOrario() {
		return orario;
	}
	/**
	 * @param orario the orario to set
	 */
	public void setOrario(Time orario) {
		this.orario = orario;
	}
	/**
	 * @return the giorno
	 */
	public Date getGiorno() {
		return giorno;
	}
	/**
	 * @param giorno the giorno to set
	 */
	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}
	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/**
	 * @return the approvato
	 */
	public boolean isApprovato() {
		return approvato;
	}
	/**
	 * @param approvato the approvato to set
	 */
	public void setApprovato(boolean approvato) {
		this.approvato = approvato;
	}
	/**
	 * @return the professionista
	 */
	public int getProfessionista() {
		return professionista;
	}
	/**
	 * @param professionista the professionista to set
	 */
	public void setProfessionista(int professionista) {
		this.professionista = professionista;
	}
	
	
	
	
	/*
	codice SERIAL PRIMARY KEY,
	prezzo INTEGER not null,
	orario TIME,
	giorno DATE,
	descrizione VARCHAR(500) not null,
	approvato BOOLEAN not null,
	valutazione INTEGER,
	recensione VARCHAR(500),
	professionista BIGINT,
	FOREIGN KEY (professionista) REFERENCES utente(codice)
*/
}
