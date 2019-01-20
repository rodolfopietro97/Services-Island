/**
 * 
 */
package businesslogic.utils.usermanagment;

import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;
import org.postgresql.util.PSQLException;

import it.servicesisland.Model.Utente;
import it.servicesisland.Persistence.UtenteDaoJDBC;

/**
 * @author rodolfo
 * User registration strategy.
 * It register an "Utente" in the database
 */
public class UserRegistrationStrategy extends UserStrategy{

	/**
	 * Constructor with parameters
	 * @param utente
	 * @param utenteDao
	 */
	public UserRegistrationStrategy(Utente utente, UtenteDaoJDBC utenteDao) {
		super(utente, utenteDao);
	}

	/* (non-Javadoc)
	 * @see businesslogic.utils.usermanagment.UserStrategy#handle()
	 */
	@Override
	public void handle() throws Exception {
		// Encript password
		utente.setPassword(DigestUtils.sha256Hex(utente.getPassword()));
		// Mail confirmation
		// ... TODO
		utenteDao.save(utente);
	}

}
