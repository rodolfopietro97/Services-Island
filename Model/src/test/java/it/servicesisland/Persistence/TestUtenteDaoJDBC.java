/**
 * 
 */
package it.servicesisland.Persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Utente;

/**
 * @author rodolfo
 * Utente dao testing class
 */
public class TestUtenteDaoJDBC {
	
	/**
	 * Testing instances
	 */
	Utente user;
	UtenteDaoJDBC userDao;

	public TestUtenteDaoJDBC() {
		user = new Utente(null, "ippolito", "bruno", "F", "ippolito@prova.it", "prova", false, 333333333L);
		userDao = new UtenteDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
	}
	
	@Test
	public void testDataSourceUserAdd() {
		userDao.save(user);
		assertEquals(user.getCodice(), userDao.findByEmail("ippolito@prova.it").getCodice());
	}
	
}
