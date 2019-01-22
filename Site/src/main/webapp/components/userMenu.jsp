<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<nav class="sidebar-nav">
	<div class="sidebar-header">
		<button class="nav-toggler nav-toggler-md sidebar-toggler"
			type="button" data-toggle="collapse" data-target="#nav-toggleable-md">
			<span class="sr-only">Menu Navigazione</span>
		</button>

	</div>
	<br> <br>
	<div class="collapse nav-toggleable-md" id="nav-toggleable-md">
	
		<jsp:include page="forms/searchForm.jsp"></jsp:include>
		
		<ul class="nav nav-pills nav-stacked flex-column">
			<li class="nav-header">
				<p><strong>${sessionScope.email}</strong></p>
				<c:choose>

					<c:when test="${not empty sessionScope.professionist}">
						<p>RUOLO: Professionista</p>
					</c:when>
					<c:otherwise>
						<p>RUOLO: <strong>Utente</strong></p>
					</c:otherwise>
				</c:choose>
				
<%-- 				<p>${pageContext.request.servletPath}</p>
 --%>	
				<jsp:include page="forms/logoutForm.jsp"></jsp:include>
			</li>
			
			<li class="nav-header">Menu</li>
			
			<li class="nav-item"><a class="nav-link"
				href="/Site">Home</a></li>


			<li class="nav-header">Menu Utente</li>
			
			<li class="nav-item">
				<a class="nav-link" href="user.jsp?page=services">
					Gestione servizi
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="user.jsp?page=payments">
					Area pagamenti
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="user.jsp?page=settings">
					Impostazioni
				</a>
			</li>

		</ul>
		<hr class="visible-xs mt-3">
	</div>
</nav>


