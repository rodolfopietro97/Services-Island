/**
 * 
 */
package it.servicesisland.Connection.handlers;

import it.servicesisland.Persistence.DataSource;

/**
 * @author rodolfo
 * Standard singleton data source
 */
public class StandardDataSource {
	
	/**
	 * Data source instance
	 */
	private static StandardDataSource instance;
	
	/**
	 * Default data source (Using {@link ConnectionInfo} 
	 * with DBInfo.json)
	 */
	private DataSource defaultDataSource;
	
	
	/**
	 * Singleton empty constructor
	 */
	private StandardDataSource() {
		instance = null;
		
		final ConnectionInfo connectionInfo =  new ConnectionInfo("DBInfo.json");
		defaultDataSource = new DataSource(connectionInfo.getDBUrl(), connectionInfo.getDBUser(), connectionInfo.getDBPassword());
	}
	
	/**
	 * Get the default {@link DataSource}
	 * @return the default data source
	 */
	public DataSource getDefaultDataSource() {
		return defaultDataSource;
	}
	
	/**
	 * Get the SINGLE instance of class
	 * @return instance
	 */
	public static StandardDataSource getInstance() {
		if(instance == null) {
			instance = new StandardDataSource();
		}
		return instance;
	}
	

}
