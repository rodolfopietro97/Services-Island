package it.servicesisland.Model;


import java.sql.Date;
import java.sql.Time;

public class Servizio {
	
	private Long codice;
	private double prezzo;
	private Time orario;
	private Date giorno;	
	private String descrizione;
	private boolean approvato;
	private int professionista;
	
	public Long getCodice() {
		return codice;
	}
	public void setCodice(Long codice) {
		this.codice = codice;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public Time getOrario() {
		return orario;
	}
	public void setOrario(Time orario) {
		this.orario = orario;
	}
	public Date getGiorno() {
		return giorno;
	}
	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public boolean isApprovato() {
		return approvato;
	}
	public void setApprovato(boolean approvato) {
		this.approvato = approvato;
	}
	public int getProfessionista() {
		return professionista;
	}
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
