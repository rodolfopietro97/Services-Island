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

import businesslogic.utils.NotificationHandler;
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
			doSearch(request, response);
		
		/*
		 * View service by id operation request (after search)
		 */
		else if(request.getParameter("op").equals("findService"))
			findServiceById(request, response);	
		
		/*
		 * Delete a prenotation of a user
		 */
		else if(request.getParameter("op").equals("deletePrenotation"))
			removeUserPrenotation(request, response);
		
		/*
		 * Delete a service of a professionist
		 */
		else if(request.getParameter("op").equals("deleteService"))
			removeService(request, response);
		
		
	}


	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void removeUserPrenotation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final long user = Long.parseLong(request.getParameter("user").toString());
		final long service = Long.parseLong(request.getParameter("service").toString());

		StandardDataSource
			.getInstance()
			.getPrenotazioneDaoJDBC()
			.delete(user, service);
		
		NotificationHandler.notificateToUser(
				user, 
				"Prenotazione eliminata", 
				"Prenotazione del servizio con id: " + service + " rimossa");
		
		request.setAttribute("reportMessage", "Prenotazione eliminata con successo!");
		request.getRequestDispatcher("/report.jsp").forward(request, response);
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void removeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final long service = Long.parseLong(request.getParameter("service").toString());
		final long user = Long.parseLong(request.getParameter("user").toString());

		StandardDataSource
			.getInstance()
			.getServizioDaoJDBC()
			.delete(service);
		
		NotificationHandler.notificateToUser(
				user, 
				"Servizio eliminato", 
				"Servizio con id: " + service + " rimosso");
		
		request.setAttribute("reportMessage", "Servizio eliminato con successo!");
		request.getRequestDispatcher("/report.jsp").forward(request, response);
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
			addNewService(request, response);
		
		/*
		 * Send unapproved services to mediatore legale
		 */
		else if(request.getParameter("op").equals("mediatore")) 
			sendUnapprovedServicesToMediatore(request, response);
		
		/*
		 * Approvation request of a service by mediatore legale
		 */
		else if(request.getParameter("op").equals("approvation"))
			approveServiceByServiceCode(request);
		
		/*
		 * Get notification list of a user by id
		 */
		else if(request.getParameter("op").equals("notifications"))
			getListOfNotificationsByUserId(request, response);
		
		
		/*
		 * Make a service prenotation
		 */
		else if(request.getParameter("op").equals("prenotation"))
			makeServicePrenotation(request, response);
		
		/*
		 * Get the list of all prenotations by user id
		 */
		else if(request.getParameter("op").equals("getPrenotations"))
			viewUserPrenotations(request, response);
		
		/*
		 * Get the list of all services by user id
		 */
		else if(request.getParameter("op").equals("getServices"))
			viewUserServices(request, response);
		
		
	}


	/**
	 * @param request
	 * @param response
	 */
	private void viewUserServices(HttpServletRequest request, HttpServletResponse response) {
		final long userId = Long.parseLong(request.getParameter("utente").toString());
		
		StandardDataSource
			.getInstance()
			.getServizioDaoJDBC()
			.findByProfessionist(userId)
			.forEach(i -> {
				try {
					response.getOutputStream().println(
							"<p>Servizio: " + i.getNome() + "</p>"
					);
					response.getOutputStream().println(
							"<a href='ServicesHandler?op=deleteService&user="+ i.getProfessionista() + "&service=" + i.getCodice() + "'>" + 
							"<i class=\"fas fa-trash-alt\"></i></a><br>"
					);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	}
	
	/**
	 * @param request
	 * @param response
	 */
	private void viewUserPrenotations(HttpServletRequest request, HttpServletResponse response) {
		final long userId = Long.parseLong(request.getParameter("utente").toString());
		StandardDataSource
			.getInstance()
			.getPrenotazioneDaoJDBC()
			.findByUserId(userId)
			.forEach(i -> {
				try {
					final long day = i.getData_prenotazione().getDay();
					final long year = i.getData_prenotazione().getYear();
					final long month = i.getData_prenotazione().getMonth();
					response.getOutputStream().println(
							"<p>Prenotazione in data: " + day + "/" + month + "/" + year + "</p>"
					);
					response.getOutputStream().println(
							"<a href='ServicesHandler?op=deletePrenotation&user=" + i.getUtente() + "&service=" + i.getServizio() + "'>" + 
							"<i class=\"fas fa-trash-alt\"></i></a><br>"
					);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	}


	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void makeServicePrenotation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final Prenotazione prenotazione = new Prenotazione(
				Time.valueOf(request.getParameter("orario").toString()), 
				Date.valueOf(request.getParameter("giorno").toString()), 
				Integer.parseInt(request.getParameter("utente").toString()), 
				Integer.parseInt(request.getParameter("servizio").toString())
		);
		
		StandardDataSource
			.getInstance()
			.getPrenotazioneDaoJDBC()
			.save(prenotazione);

		response.getOutputStream().print("success");
//			
//			// TODO Date and time control
		
		NotificationHandler.notificateToUser(
				Integer.parseInt(request.getParameter("utente").toString()), 
				"Prenotazione effettuata", 
				"Hai appena prenotato il servizio con id " + request.getParameter("servizio").toString());
	}


	/**
	 * @param request
	 * @param response
	 */
	private void getListOfNotificationsByUserId(HttpServletRequest request, HttpServletResponse response) {
		final long userId = Long.parseLong(request.getSession().getAttribute("id").toString());
		StandardDataSource
			.getInstance()
			.getNotificaDaoJDBC()
			.findByUser(userId)
			.forEach(i -> {
				try {
					response.getOutputStream().print("<li class='dropdown-item'><strong>" + i.getTitolo() + "</strong><br>" + i.getContenuto() + "<li>");
					response.getOutputStream().print("<div class='dropdown-divider'></div>");

				} catch (IOException e) {
					e.printStackTrace();
				}
			});
	}


	/**
	 * @param request
	 */
	private void approveServiceByServiceCode(HttpServletRequest request) {
		final long serviceKey = Long.parseLong(request.getParameter("serviceCode").toString());
		
		StandardDataSource
			.getInstance()
			.getMediatoreDaoJDBC()
			.approve(serviceKey);
		
		final Servizio servizio = StandardDataSource
									.getInstance()
									.getServizioDaoJDBC()
									.findByPrimaryKey(serviceKey);
		
		NotificationHandler.notificateToUser(
				servizio.getProfessionista(), 
				"Servizio approvato!",
				"Il servizio " + servizio.getNome() + " è stato approvato!");
	}


	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void sendUnapprovedServicesToMediatore(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		final String mediatorKey = request.getParameter("key").toString();
		
		if(StandardDataSource
				.getInstance()
				.getMediatoreDaoJDBC()
				.existMediatore(mediatorKey)) 
		{
			
			final List<Servizio> unapprovedServices = StandardDataSource
													  	.getInstance()
													  	.getServizioDaoJDBC()
													  	.findUnapproved();
			
			if(unapprovedServices.isEmpty())
				response.getOutputStream().print("NON ci sono servizi al momento");
			else {
				response.getOutputStream().println("CODICE SERVIZIO: " + unapprovedServices.get(0).getCodice());
				response.getOutputStream().println("NOME SERVIZIO: " + unapprovedServices.get(0).getNome());
				response.getOutputStream().println("DESCRIZIONE SERVIZIO: " + unapprovedServices.get(0).getDescrizione());
				response.getOutputStream().println("ALTRI DETTAGLI SERVIZIO: " + unapprovedServices.get(0).getAltri_dettagli());
			}
			
		}
		else {
			response.getOutputStream().print("error");
		}
	}


	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addNewService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final Servizio servizio = new Servizio(null, 
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
		
		StandardDataSource
				.getInstance()
				.getServizioDaoJDBC()
				.save(servizio);
		
		NotificationHandler
				.notificateToUser(
						Long.parseLong(request.getSession().getAttribute("id").toString()), 
						"Richiesta inserimento servizio!", 
						"Servizio " + servizio.getNome() + " in fase di approvazione...");
		
		request.setAttribute("reportMessage", "Inserimento servizio andato a buon fine!");
		request.getRequestDispatcher("/report.jsp").forward(request, response);
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findServiceById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final long serviceKey = Long.parseLong(request.getParameter("serviceId").toString());
		final Servizio servizio = StandardDataSource
				.getInstance()
				.getServizioDaoJDBC()
				.findByPrimaryKey(serviceKey);
		request.setAttribute("result", servizio);
		request.getRequestDispatcher("user.jsp?page=serviceInfo").forward(request, response);
	}


	/**
	 * Search operation
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String searchKey = request.getParameter("txtSearch").toString();
		
		final ArrayList<Servizio> servizi = StandardDataSource
				.getInstance()
				.getServizioDaoJDBC()
				.findByDescrizione(searchKey);
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

}
