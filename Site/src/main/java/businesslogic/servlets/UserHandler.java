package servlets;



import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Utente;
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
			response.getOutputStream().print("REGISTRA UN UTENTE");
			for(Object i : request.getParameterMap().entrySet()) {
				response.getOutputStream().print(i.toString());
			}
			Utente temp = new Utente(null, 
					request.getParameter("nome"), 
					request.getParameter("cognome"), 
					"m", 
					request.getParameter("email"), 
					request.getParameter("password"), 
					false, 
					null);
			
			new UtenteDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource()).save(temp);
		}
		
	}

}
