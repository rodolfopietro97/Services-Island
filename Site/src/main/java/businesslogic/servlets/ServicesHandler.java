package businesslogic.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;
import it.servicesisland.Persistence.ServizioDaoJDBC;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		if(request.getParameter("op").equals("search")) {			
			ServizioDaoJDBC servizioDaoJDBC = new ServizioDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
			ArrayList<Servizio> servizi = servizioDaoJDBC.findByDescrizione(request.getParameter("txtSearch").toString());
			if(servizi.isEmpty()) {
				request.setAttribute("result", null);
				request.getRequestDispatcher("user.jsp?page=search").forward(request, response);

			}
			else {
				request.setAttribute("result", servizi);
				request.getRequestDispatcher("user.jsp?page=search").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
