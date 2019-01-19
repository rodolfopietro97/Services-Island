package it.servicesisland.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.servicesisland.Model.*;


/**
 * 
 * @author Tiziana
 * Servizio jdbc dao class
 */
public class MediatoreDaoJDBC {
	
	/**
	 * Instance of DataSource
	 */
	private DataSource dataSource;

	
	/**
	 * Constructor with parameters
	 * @param dataSource of connection
	 */
	public MediatoreDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
		//dataSource=new DataSource("jdbc:postgresql://localhost:5432/services_island","postgres","postgres");
	}
	
	/**
	 * Add new mediatore to the database
	 * @param mediatore
	 */
	public void save(Mediatore mediatore) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			
			 
			String insert = "insert into mediatore(nome, email, password) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setString(1, mediatore.getNome());
			
			statement.setString(2, mediatore.getEmail());
		
			statement.setString(3, mediatore.getPassword());			
						
			statement.executeUpdate();
			
		} catch (SQLException e) {
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
	 * Find an istance of mediatore by email
	 * @param email
	 * @return the mediatore found
	 */
	public Mediatore findByEmail(String email) {
		
		Connection connection = this.dataSource.getConnection();
		Mediatore mediatore = null;
		
		try {
			PreparedStatement statement;
			String query = "select * from mediatore where email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				mediatore = new Mediatore();
				mediatore.setCodice(result.getLong("codice"));				
				mediatore.setNome(result.getString("nome"));
				mediatore.setEmail(result.getString("email"));
				mediatore.setPassword(result.getString("password"));
				
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
		return mediatore;
	}
	
}
