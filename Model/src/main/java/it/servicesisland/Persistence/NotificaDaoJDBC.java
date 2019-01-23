package it.servicesisland.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.servicesisland.Model.Notifica;

public class NotificaDaoJDBC {

	/**
	 * Instance of DataSource
	 */
	private DataSource dataSource;

	
	/**
	 * Constructor with parameters
	 * @param dataSource of connection
	 */
	public NotificaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
		//dataSource=new DataSource("jdbc:postgresql://localhost:5432/services_island","postgres","postgres");
	}
	
	/**
	 * salva l'istanza di notifica
	 * @param n
	 */
	public void save(Notifica n) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			
			 
			String insert = "insert into notifica(utente, titolo, contenuto) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setLong(1, n.getUtente());
			statement.setString(2, n.getTitolo());
			statement.setString(3, n.getContenuto());
						
						
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
	
}
