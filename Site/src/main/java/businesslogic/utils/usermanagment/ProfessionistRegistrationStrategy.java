package businesslogic.utils.usermanagment;

import org.apache.commons.codec.digest.DigestUtils;

import it.servicesisland.Model.Utente;
import it.servicesisland.Persistence.UtenteDaoJDBC;

public class ProfessionistRegistrationStrategy extends UserStrategy {

	
	public ProfessionistRegistrationStrategy(Utente utente, UtenteDaoJDBC utenteDao) {
		super(utente, utenteDao);
	}
	
	@Override
	public void handle() throws Exception {
		
		utente.setPassword(DigestUtils.sha256Hex(utente.getPassword()));
		utenteDao.saveProfessionista(utente);
	}

}
