package it.servicesisland.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.servicesisland.Model.*;


/**
 * 
 * @author Tiziana
 *
 */
public class PrenotazioneDaoJDBC {

	/**
	 * Instance of DataSource
	 */
	private DataSource dataSource;

	/**
	 * Constructor with parameters
	 * @param dataSource of connection
	 */
	public PrenotazioneDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
		//dataSource=new DataSource("jdbc:postgresql://localhost:5432/services_island","postgres","postgres");
	}
	
	/**
	 * Add new booking in the database
	 * @param prenotazione to save
	 */
	public void save(Prenotazione prenotazione) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			
			 
			String insert = "insert into prenotazione(orario_prenotazione, data_prenotazione, utente, servizio) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setTime(1, prenotazione.getOrario_prenotazione());
			statement.setDate(2, prenotazione.getData_prenotazione());
			statement.setInt(3, prenotazione.getUtente());
			statement.setInt(4, prenotazione.getServizio());
						
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					excep.printStackTrace();
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * finds a prenotazione by primary key
	 * @param idUs
	 * @param idSe
	 * @return the found instance of prenotazione
	 */
	public Prenotazione findByPrimaryKey(Long idUs, Long idSe) {
		
		Connection connection = this.dataSource.getConnection();
		Prenotazione prenotazione = null;
		try {
			PreparedStatement statement;
			String query = "select * from prenotazione where utente = ? and servizio = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, idUs);
			statement.setLong(2, idSe);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				prenotazione = new Prenotazione();
				prenotazione.setData_prenotazione(result.getDate("data_prenotazione"));
				prenotazione.setOrario_prenotazione(result.getTime("orario_prenotazione"));
				prenotazione.setUtente(result.getInt("utente"));
				prenotazione.setServizio(result.getInt("servizio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return prenotazione;
	}
	
	/**
	 * Delete a given instance of Prenotazione, finding it by primary key	
	 * @param id of user, id of service
	 */
	public void delete(Long idUs, Long idSe) {
			
			Connection connection = this.dataSource.getConnection();
			try {
			PreparedStatement statement;
			String query = "delete from prenotazione where utente = ? and servizio = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, idUs);
			statement.setLong(2, idSe);
			statement.execute();
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
}
