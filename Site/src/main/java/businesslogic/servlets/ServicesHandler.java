package businesslogic.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.servlets.handler.ServletHandler;
import businesslogic.servlets.handler.strategiesinstances.Strategies;

/**
 * Servlet implementation class ServicesHandler
 */
public class ServicesHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
    public ServicesHandler() {
        super();
    }

    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*
		 * Search service operation request
		 */
		if(request.getParameter("op").equals("search"))
			ServletHandler.handle(Strategies.getInstance().getSearchStrategy(), request, response);
		
		/*
		 * View service by id operation request (after search)
		 */
		else if(request.getParameter("op").equals("findService"))
			ServletHandler.handle(Strategies.getInstance().getFindServiceByIdStrategy(), request, response);
		
		/*
		 * Delete a prenotation of a user
		 */
		else if(request.getParameter("op").equals("deletePrenotation"))
			ServletHandler.handle(Strategies.getInstance().getRemoveUserPrenotationStrategy(), request, response);
		
		/*
		 * Delete a service of a professionist
		 */
		else if(request.getParameter("op").equals("deleteService"))
			ServletHandler.handle(Strategies.getInstance().getDeleteServiceOfProfessionistStrategy(), request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		/*
		 * Add service operation
		 */
		if(request.getParameter("op").equals("addService")) 
			ServletHandler.handle(Strategies.getInstance().getAddNewServiceStrategy(), request, response);
		
		/*
		 * Get notification list of a user by id
		 */
		else if(request.getParameter("op").equals("notifications"))
			ServletHandler.handle(Strategies.getInstance().getGetListOfUserNotificationsStrategy(), request, response);
		
		
		/*
		 * Make a service prenotation
		 */
		else if(request.getParameter("op").equals("prenotation"))
			ServletHandler.handle(Strategies.getInstance().getMakeServicePrenotationStrategy(), request, response);
		
		/*
		 * Get the list of all prenotations by user id
		 */
		else if(request.getParameter("op").equals("getPrenotations"))
			ServletHandler.handle(Strategies.getInstance().getViewUserPrenotationsStrategy(), request, response);
		
		/*
		 * Get the list of all prenotations in a service offered by a professionist 
		 */
		else if(request.getParameter("op").equals("getPrenotationsOfProfessionist")) {
//			final long userId = Long.parseLong(request.getParameter("utente").toString());
//			StandardDataSource
//				.getInstance()
//				.getPrenotazioneDaoJDBC()
//				.findByUserId(userId)
//				.forEach(i -> {
//					try {
//						final long day = i.getData_prenotazione().getDay();
//						final long year = i.getData_prenotazione().getYear();
//						final long month = i.getData_prenotazione().getMonth();
//						response.getOutputStream().println(
//								"<p>Prenotazione in data: " + day + "/" + month + "/" + year + "</p>"
//						);
//						response.getOutputStream().println(
//								"<a href='ServicesHandler?op=deletePrenotation&user=" + i.getUtente() + "&service=" + i.getServizio() + "'>" + 
//								"<i class=\"fas fa-trash-alt\"></i></a><br>"
//						);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				});
		}
		
		/*
		 * Get the list of all services by user id
		 */
		else if(request.getParameter("op").equals("getServices"))
			ServletHandler.handle(Strategies.getInstance().getViewUserServicesStrategy(), request, response);
		
		
	}

}
