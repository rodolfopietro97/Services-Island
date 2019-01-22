package businesslogic.servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.postgresql.util.PSQLException;

import businesslogic.utils.usermanagment.UserManager;
import businesslogic.utils.usermanagment.UserRegistrationStrategy;
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
	 * User manager instance
	 */
	UserManager userManager;
	
	/**
	 * Data source instance
	 */
	DataSource dataSource;
	

	/**
	 * Load postgre driver
	 */
	static {
	    try {
	      Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	      System.err.println("PostgreSQL DataSource unable to load PostgreSQL JDBC Driver");
	    }
	 }
	
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
		dataSource = StandardDataSource.getInstance().getDefaultDataSource();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		if(request.getParameter("op").equals("logout")) {			
			doLogout(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);


		
		if(request.getParameter("op").equals("login")) {
			doLogin(request, response);
		}
		else if(request.getParameter("op").equals("registerUser")) {			
			registerUser(request, response);
		}
		else if(request.getParameter("op").equals("registerProfessonist")) {			
			registerProfessionist(request, response);
		}
		
	}

	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession loginSession = request.getSession();
		loginSession.invalidate();
		
		request.setAttribute("reportMessage", "Logout andato a buon fine!");
		request.getRequestDispatcher("/report.jsp").forward(request, response);
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//			response.getOutputStream().println("<h1>" + request.getParameter("op") + "</h1>");
		//			response.getOutputStream().println(request.getParameter("txtEmail"));
		//			response.getOutputStream().println(request.getParameter("txtPassword"));
		//			
					final String password = DigestUtils.sha256Hex(request.getParameter("txtPassword").toString());
					final String email = request.getParameter("txtEmail").toString();
					

					
					final UtenteDaoJDBC utenteDao = new UtenteDaoJDBC(dataSource);
					final Utente tempUtente = utenteDao.findByEmail(email);
					
					if(tempUtente.getPassword().equals(password)) {
						HttpSession loginSession = request.getSession(true);
			
						loginSession.setAttribute("email", email);
			
						if(tempUtente.isProfessionista()) {
							loginSession.setAttribute("professionist", true);
						}
						
						request.setAttribute("reportMessage", "Login andato a buon fine!");
						request.getRequestDispatcher("/report.jsp").forward(request, response);
					}
					else {
						request.setAttribute("reportMessage", "Credenziali errate");
						request.getRequestDispatcher("/report.jsp").forward(request, response);
					}
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void registerUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final Utente temp = new Utente(
				request.getParameter("txtNome").toString(), 
				request.getParameter("txtCognome").toString(),
				request.getParameter("sltSesso").toString(), 
				request.getParameter("txtEmail").toString(), 
				request.getParameter("txtPassword").toString(),  
				Long.parseLong(request.getParameter("txtNumeroTelefonico").toString()));
		
		
		userManager = new UserManager(new UserRegistrationStrategy(temp, new UtenteDaoJDBC(this.dataSource)));
		
		try {
//				response.getOutputStream().print("<h1>... registrazione utente ...</h1>");
			userManager.handle();
			
			request.setAttribute("reportMessage", "Registrazione andata a buon fine!");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("reportMessage", "Errore nella registrazione utente");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		}
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void registerProfessionist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final Utente temp = new Utente(
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
		
		userManager = new UserManager(new UserRegistrationStrategy(temp, new UtenteDaoJDBC(this.dataSource)));
		
		try {
//				response.getOutputStream().print("<h1>... registrazione utente ...</h1>");
			userManager.handle();
			
			request.setAttribute("reportMessage", "Registrazione andata a buon fine!");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("reportMessage", "Errore nella registrazione del professionista");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
		}
	}

}
