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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import it.servicesisland.Connection.handlers.StandardDataSource;
import it.servicesisland.Model.Notifica;
import it.servicesisland.Model.Prenotazione;
import it.servicesisland.Model.Servizio;

import it.servicesisland.Persistence.MediatoreDaoJDBC;
import it.servicesisland.Persistence.NotificaDaoJDBC;
import it.servicesisland.Persistence.PrenotazioneDaoJDBC;
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
			ArrayList<Servizio> servizi = servizioDaoJDBC.findByDescrizione(request.getParameter("txtSearch").toString());
			servizi.removeIf(s -> !s.isApprovato());

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
						request.getParameter("txtDescrizione").toString(), 
						request.getParameter("txtNomeServizio").toString(), 
						Time.valueOf(request.getParameter("txtTempoMedio")), 
						false, 
						Integer.parseInt(request.getSession().getAttribute("id").toString()), 
						request.getParameter("txtAltriDettagli").toString());
			
			dao.save(temp);
			
			Notifica notifica = new Notifica(
					Long.parseLong(request.getSession().getAttribute("id").toString()),
					"Richiesta inserimento servizio!", 
					"Il servizio " + temp.getNome() + " è in fase di approvazione...");
			NotificaDaoJDBC notificaDaoJDBC = new NotificaDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
			notificaDaoJDBC.save(notifica);
			
			request.setAttribute("reportMessage", "Inserimento servizio andato a buon fine!");
			request.getRequestDispatcher("/report.jsp").forward(request, response);
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
			
			// metti quì l'id dell'utente in base al servizio
			ServizioDaoJDBC servizioDaoJDBC = new ServizioDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
			Servizio temp = servizioDaoJDBC.findByPrimaryKey(Long.parseLong(request.getParameter("serviceCode").toString()));

			Notifica notifica = new Notifica(
					(long) temp.getProfessionista(),
					"Servizio approvato!", 
					"Il servizio " + request.getParameter("serviceCode").toString() + " è stato approvato!");
			
			NotificaDaoJDBC notificaDaoJDBC = new NotificaDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
			notificaDaoJDBC.save(notifica);
			
		}
		
		else if(request.getParameter("op").equals("notifications")) {
			NotificaDaoJDBC notificaDaoJDBC = new NotificaDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
			List<Notifica> notifiche = notificaDaoJDBC.findByUser(Long.parseLong(request.getSession().getAttribute("id").toString()));
			
			for(Notifica i : notifiche) {
				response.getOutputStream().print("<li class='dropdown-item'><strong>" + i.getTitolo() + "</strong><br>" + i.getContenuto() + "<li>");
				response.getOutputStream().print("<div class='dropdown-divider'></div>");

			}
		}
		
		else if(request.getParameter("op").equals("prenotation")) {
			PrenotazioneDaoJDBC prenotazioneDaoJDBC = new PrenotazioneDaoJDBC(StandardDataSource.getInstance().getDefaultDataSource());
			prenotazioneDaoJDBC.save(
					new Prenotazione(
							Time.valueOf(request.getParameter("orario").toString()), 
							Date.valueOf(request.getParameter("giorno").toString()), 
							Integer.parseInt(request.getParameter("utente").toString()), 
							Integer.parseInt(request.getParameter("servizio").toString())
							    	 )
					);
			
			// per ora va bene, ma serve il controllo date!
			// aggiungi lla notifica all'utente
			
			response.getOutputStream().print("success");

		}
	}

}
