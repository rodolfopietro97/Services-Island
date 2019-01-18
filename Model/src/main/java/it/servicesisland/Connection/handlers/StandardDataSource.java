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
	
	private static StandardDataSource instance;
	private DataSource defaultDataSource;
	
	private StandardDataSource() {
		instance = null;
		
		final ConnectionInfo connectionInfo =  new ConnectionInfo("DBInfo.json");
		defaultDataSource = new DataSource(connectionInfo.getDBUrl(), connectionInfo.getDBUser(), connectionInfo.getDBPassword());
	}
	
	public DataSource getDefaultDataSource() {
		return defaultDataSource;
	}
	
	public static StandardDataSource getInstance() {
		if(instance == null) {
			instance = new StandardDataSource();
		}
		return instance;
	}

}
