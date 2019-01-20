/**
 * 
 */
package businesslogic.utils.usermanagment;

import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import it.servicesisland.Model.Utente;
import it.servicesisland.Persistence.UtenteDaoJDBC;

/**
 * @author rodolfo
 * User strategy class.
 * THe strategies could be:
 * 	Add new User,
 *  Add new Professionists,
 *  make login,
 *  make logout,
 *  ecc...
 */
public abstract class UserStrategy {

	/**
	 * User instance
	 */
	protected Utente utente;
	
	
	/**
	 * User Dao instance
	 */
	protected UtenteDaoJDBC utenteDao;
	
	
	/**
	 * Constructor with parameters
	 * @param utente
	 * @param utenteDao
	 */
	public UserStrategy(Utente utente, UtenteDaoJDBC utenteDao) {
		this.utente = utente;
		this.utenteDao = utenteDao;
	}

	/**
	 * Handle function
	 * @throws Exception if there are problems in user operation
	 */
	public abstract void handle() throws Exception;
	
}
