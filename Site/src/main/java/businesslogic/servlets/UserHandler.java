package businesslogic.servlets;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//request.setCharacterEncoding("utf-8");
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
			response.getOutputStream().print("registrazione utente");
			
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
			
			final UtenteDaoJDBC register = new UtenteDaoJDBC(new DataSource("jdbc:postgresql://tantor.db.elephantsql.com:5432/clbwfexq", "clbwfexq", "WhDf3DdXmdH5Iupu1BFjD6n7Z4CJ1lrS"));
			register.save(temp);
			response.getOutputStream().print("utente aggiunto con successo");

			
//			
//			new UtenteDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource()).save(temp);
		}
		
	}

}
