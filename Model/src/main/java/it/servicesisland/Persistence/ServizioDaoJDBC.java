package it.servicesisland.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.servicesisland.Model.*;

/**
 * @author tiziana
 * Servizio jdbc dao class
 */
public class ServizioDaoJDBC {

	/**
	 * Instance of DataSource
	 */
	private DataSource dataSource;

	/**
	 * Constructor with parameters
	 * @param dataSource of connection
	 */
	public ServizioDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
		//dataSource=new DataSource("jdbc:postgresql://localhost:5432/services_island","postgres","postgres");
	}
	
	/**
	 * Add new service in the database
	 * @param servizio to save
	 */
	public void save(Servizio servizio) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			
			 
			String insert = "insert into servizio(prezzo, orario, giorno, descrizione, approvato, professionista) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setDouble(1, servizio.getPrezzo());
			statement.setTime(2, servizio.getOrario());
			statement.setDate(3, servizio.getGiorno());
			statement.setString(4, servizio.getDescrizione());
			statement.setBoolean(5, servizio.isApprovato());
			statement.setInt(6, servizio.getProfessionista());

						
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
	 * Find the Servizio by primary key
	 * @param id of service
	 * @return the Servizio which has a primary key id
	 */
	public Servizio findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Servizio servizio = null;
		try {
			PreparedStatement statement;
			String query = "select * from servizio where codice = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				servizio = new Servizio();
				servizio.setCodice(result.getLong("codice"));				
				servizio.setPrezzo(result.getDouble("prezzo"));
				servizio.setApprovato(result.getBoolean("approvato"));
				servizio.setDescrizione(result.getString("descrizione"));
				servizio.setGiorno(result.getDate("giorno"));
				servizio.setOrario(result.getTime("orario"));
				servizio.setProfessionista(result.getInt("professionista"));
				
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
		return servizio;
	}
	
/**
 * Delete a given instance of Servizio, finding it by primary key	
 * @param id
 */
public void delete(Long id) {
		
		Connection connection = this.dataSource.getConnection();
		try {
		PreparedStatement statement;
		String query = "delete from servizio where codice = ?";
		statement = connection.prepareStatement(query);
		statement.setLong(1, id);
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
