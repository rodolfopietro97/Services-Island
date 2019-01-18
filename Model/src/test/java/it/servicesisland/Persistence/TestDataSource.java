package it.servicesisland.Persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import it.servicesisland.Connection.handlers.ConnectionInfo;

/**
 * @author rodolfo
 * Data Source testing class
 */
public class TestDataSource {

	/**
	 * Testing instance
	 */
	DataSource dataSource;

	/**
	 * Constructor without parameters 
	 */
	public TestDataSource() {
		ConnectionInfo connectionInfo = new ConnectionInfo("DBInfo.json");
		dataSource = new DataSource(connectionInfo.getDBUrl(), connectionInfo.getDBUser(), connectionInfo.getDBPassword());
	}
	
	/**
	 * Test if Data Source work (using DBInfo.json)
	 */
	@Test
	public void testDataSourceConnection() {
		System.out.println("Test of DataSource");
		assertNotEquals(null, dataSource.getConnection());
	}
}
