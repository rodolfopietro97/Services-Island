package businesslogic.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;
import it.servicesisland.Persistence.DataSource;
import it.servicesisland.Persistence.ServizioDaoJDBC;

/**
 * Servlet implementation class ServicesHandler
 */
public class ServicesHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * dao instance
	 */
	ServizioDaoJDBC dao;
	
	
	/**
	 * datasource instance
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
    public ServicesHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		dataSource = StandardDataSource.getInstance().getDefaultDataSource();
		dao= new ServizioDaoJDBC(dataSource);
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
			ArrayList<Servizio> servizi = new ArrayList<>();
			for(Servizio i : servizioDaoJDBC.findByDescrizione(request.getParameter("txtSearch").toString())) {
				if(i.isApprovato())
					servizi.add(i);
			}
			if(servizi.isEmpty()) {
				request.setAttribute("result", null);
				request.getRequestDispatcher("user.jsp?page=search").forward(request, response);

			}
			else {
				request.setAttribute("result", servizi);
				request.getRequestDispatcher("user.jsp?page=search").forward(request, response);
			}
		}
		else if(request.getParameter("op").equals("findService")) {
			ServizioDaoJDBC servizioDaoJDBC = new ServizioDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
			Servizio servizio = servizioDaoJDBC.findByPrimaryKey(Long.parseLong(request.getParameter("serviceId").toString()));
			request.setAttribute("result", servizio);
			request.getRequestDispatcher("user.jsp?page=serviceInfo").forward(request, response);			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		if(request.getParameter("op").equals("addService")) {
	
		Servizio temp = new Servizio(null, 
					Double.parseDouble(request.getParameter("txtPrezzo")), 
					Time.valueOf(request.getParameter("txtOrarioInizio")), 
					Date.valueOf(request.getParameter("txtDataInizio")), 
					Time.valueOf(request.getParameter("txtOrarioFine")), 
					Date.valueOf(request.getParameter("txtDataFine")), 
					request.getParameter("txtDescrizione"), 
					request.getParameter("txtNomeServizio"), 
					Time.valueOf(request.getParameter("txtTempoMedio")), 
					false, 
					14, 
					"none");
		
		
		dao.save(temp);
		}
	}

}
