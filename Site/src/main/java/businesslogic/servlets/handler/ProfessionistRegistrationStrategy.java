/**
 * 
 */
package businesslogic.servlets.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Utente;

/**
 * @author rodolfo
 * Professionist User registration operation
 */
public class ProfessionistRegistrationStrategy extends Strategy {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final Utente utente = new Utente(
				request.getParameter("txtNome").toString(), 
				request.getParameter("txtCognome").toString(),
				request.getParameter("sltSesso").toString(), 
				request.getParameter("txtEmail").toString(), 
				request.getParameter("txtPassword").toString(),
				Long.parseLong(request.getParameter("txtNumeroTelefonico").toString()));
				request.getParameter("txtCodiceF").toString();
				request.getParameter("txtPartitaIVA").toString();
				request.getParameter("txtProfessione").toString();
				request.getParameter("txtSettore").toString();
				request.getParameter("txtSedeFiscale").toString();
				request.getParameter("txtSedeLegale").toString();
				
		try {
			utente.setPassword(DigestUtils.sha256Hex(utente.getPassword()));
			StandardDataSource
				.getInstance()
				.getUtenteDaoJDBC()
				.saveProfessionista(utente);
			
			request.setAttribute("reportMessage", "Registrazione andata a buon fine!");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("reportMessage", "Errore nella registrazione del professionista");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		}
	}

}
