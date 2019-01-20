package businesslogic.servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.util.PSQLException;

import it.servicesisland.Connection.handlers.ConnectionInfo;
import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Utente;
import it.servicesisland.Persistence.DataSource;
import it.servicesisland.Persistence.UtenteDaoJDBC;


/**
 * Servlet implementation class UserHandler
 */
public class UserHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHandler() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		

		if(request.getParameter("op").equals("login")) {
			response.getOutputStream().println("<h1>" + request.getParameter("op") + "</h1>");
			response.getOutputStream().println(request.getParameter("txtEmail"));
			response.getOutputStream().println(request.getParameter("txtPassword"));
		}
		else if(request.getParameter("op").equals("registerUser")) {			

			
			try {
				final DataSource dataSource = StandardDataSource.getInstance().getDefaultDataSource();
				response.getOutputStream().print("<h1>registrazione utente</h1>");
				
				final String nome = request.getParameter("txtNome").toString(); 
				final String cognome =  request.getParameter("txtCognome").toString();
				final String sesso = request.getParameter("sltSesso").toString();
				final String email = request.getParameter("txtEmail").toString();
				final String password =  request.getParameter("txtPassword").toString();
				final long numero =  Long.parseLong(request.getParameter("txtNumeroTelefonico").toString());
		
				
				
				final Utente temp = new Utente(
						nome, 
						cognome,
						sesso, 
						email, 
						password, 
						false, 
						numero);
				
				final UtenteDaoJDBC register = new UtenteDaoJDBC(dataSource);
				register.save(temp);
				response.getOutputStream().print("<h1>utente aggiunto con successo</h1>");

			} 
			catch (Exception e) {
				if(e instanceof PSQLException) {
					response.getOutputStream().print("<h1>Impossibile aggiungere l'utente</h1>");

				}
				else {
					doPost(request, response);
				}
			}
		}
		
	}

}
