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
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Servizio;
import it.servicesisland.Persistence.MediatoreDaoJDBC;
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		if(request.getParameter("op").equals("addService")) {
	
			
			response.getOutputStream().print("<p>" + Double.parseDouble(request.getParameter("txtPrezzo")) + "</p>");
//			Date dataInizio = Date.valueOf(LocalDate.parse(request.getParameter("txtDataInizio").toString(), DateTimeFormatter.ofPattern("aa-mm-dd")));
//			Date dataFine = Date.valueOf(LocalDate.parse(request.getParameter("txtDataFine").toString(), DateTimeFormatter.ofPattern("aa-mm-dd")));
			Time tempoMedio = Time.valueOf(request.getParameter("txtTempoMedio").toString());
			response.getOutputStream().print("<p>" + tempoMedio.toLocaleString() + "</p>");



			
			
//			response.getOutputStream().print("<p>" + request.getParameter("txtTempoMedio") + "</p>");
			response.getOutputStream().print("<p>" + request.getParameter("txtDataInizio") + "</p>");
			response.getOutputStream().print("<p>" + request.getParameter("txtContenutiMultimediali") + "</p>");

//			Servizio temp = new Servizio(null, 
//					Double.parseDouble(request.getParameter("txtPrezzo")), 
//					orario_inizio, 
//					data_inizio, 
//					orario_fine, 
//					data_fine, 
//					descrizione, 
//					nome, 
//					tempo_medio, 
//					approvato, 
//					professionista, 
//					altri_dettagli);
		}
		// Mediator login
		else if(request.getParameter("op").equals("mediatore")) {
			MediatoreDaoJDBC mediatoreDaoJDBC = new MediatoreDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
			if(mediatoreDaoJDBC.existMediatore(request.getParameter("key"))){
				ServizioDaoJDBC servizioDaoJDBC = new ServizioDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
				List<Servizio> servizi = servizioDaoJDBC.findUnapproved();
				if(servizi.isEmpty()) {
					response.getOutputStream().print("NON ci sono servizi al momento");
				}
				else {
					response.getOutputStream().println("CODICE SERVIZIO: " + servizi.get(0).getCodice());
					response.getOutputStream().println("NOME SERVIZIO: " + servizi.get(0).getNome());
					response.getOutputStream().println("DESCRIZIONE SERVIZIO: " + servizi.get(0).getDescrizione());
				}
			}
			else {
				response.getOutputStream().print("error");
			}
		}
		// mediator approvation
		else if(request.getParameter("op").equals("approvation")) {
			MediatoreDaoJDBC mediatoreDaoJDBC = new MediatoreDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
			mediatoreDaoJDBC.approve(Long.parseLong(request.getParameter("serviceCode").toString()));
		}
	}

}
