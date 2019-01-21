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
		<form class="sidebar-form">
			<input class="form-control" type="text" placeholder="Search...">
			<button type="submit" class="btn-link">
				<span class="fas fa-search"></span>
			</button>
		</form>
		<ul class="nav nav-pills nav-stacked flex-column">
			<p>${sessionScope.email}</p>
			<c:choose>
				<c:when test="${not empty sessionScope.professionist}">
					<p>Professionista</p>
				</c:when>
				<c:otherwise>
					<p>Utente</p>
				</c:otherwise>
			</c:choose>
			
			<p>${pageContext.request.servletPath}</p>

			<jsp:include page="forms/logoutForm.jsp"></jsp:include>

			<li class="nav-header">Menu</li>
			
			<li class="nav-item"><a class="nav-link active"
				href="../index-light/index.html">Home</a></li>


			<li class="nav-header">Menu Utente</li>



		</ul>
		<hr class="visible-xs mt-3">
	</div>
</nav>


