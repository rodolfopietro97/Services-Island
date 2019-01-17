package it.servicesisland.Persistence;
//package it.privately.persistance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.servicesisland.Model.Servizio;
import it.servicesisland.Model.Utente;



public class UtenteDaoJDBC {
	
	private DataSource dataSource;

	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
		//dataSource=new DataSource("jdbc:postgresql://localhost:5432/services_island","postgres","postgres");
	}
	
	public void save(Utente utente){
		Connection connection = this.dataSource.getConnection();
		try {
			
			
			String insert = "insert into utente(nome, cognome, sesso,email, password, professionista, telefono) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getSesso());
			statement.setString(4, utente.getEmail());
			statement.setString(5, utente.getPassword());
			statement.setBoolean(6, utente.getProfessionista());
			statement.setLong(7, utente.getTelefono());
					
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					//throw new PersistenceException(e.getMessage());
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
			//	throw new PersistenceException(e.getMessage());
			}
		}
	}
	
	public Utente findByEmail(String email) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		
		try {
			PreparedStatement statement;
			String query = "select * from utente where email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setCodice(result.getLong("codice"));				
				utente.setNome(result.getString("nome"));
				utente.setCognome(result.getString("cognome"));
				utente.setSesso(result.getString("sesso"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));
				utente.setProfessionista(result.getBoolean("professionista"));
				utente.setTelefono(result.getLong("telefono"));
				
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
		return utente;
	}
	
	public List<Servizio> findAllServices(String email) {
		Connection connection = this.dataSource.getConnection();
		List<Servizio> servizi = new ArrayList<>();
		try {			
			Servizio servizio;
			PreparedStatement statement;
			String query = "select servizio.codice as codice"
					+ " from utente inner join servizio on utente.codice=servizio.professionista"
					+ " where utente.email= ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			
			ServizioDaoJDBC servizioDao= new ServizioDaoJDBC(this.dataSource);
			while (result.next()) {
				
				servizio= servizioDao.findByPrimaryKey(result.getLong("codice"));
				servizi.add(servizio);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return servizi;
	}
	
	public double averageRating() {
		return (Double) null;
	}
}