<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Hidden menu for mobile devices -->
<menu class="stage-shelf stage-shelf-right hidden" id="sidebar">
	<ul class="nav nav-bordered nav-stacked flex-column">
		<li class="nav-header">Menu Navigazione</li>
		<li class="nav-item">
			<a class="nav-link active" href="/Site">Home</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="about.jsp">Info</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="terms.jsp">Termini</a>
		</li>
	</ul>
</menu>

<div class="stage" id="stage">

	<div class="block block-inverse block-fill-height app-header"
		style="background-color: #33749a; height: auto;">

		<div class="container py-4 fixed-top app-navbar">
			<nav
				class="navbar navbar-transparent navbar-padded navbar-toggleable-sm">
				<button class="navbar-toggler navbar-toggler-right hidden-md-up"
					type="button" data-target="#stage" data-toggle="stage"
					data-distance="-250">
					<span class="navbar-toggler-icon"></span>
				</button>

				<a class="navbar-brand mr-auto" href="/Site" id="navbarBrand">
					<strong>Services Island</strong>
				</a>

				<!-- Menu for normal devices -->
				<div class="hidden-sm-down text-uppercase nav nav-tabs border"
					style="background: #28669f; /* Old browsers */ background: -moz-linear-gradient(top, #28669f 0%, #357ea9 100%); /* FF3.6-15 */ background: -webkit-linear-gradient(top, #28669f 0%, #357ea9 100%); /* Chrome10-25,Safari5.1-6 */ background: linear-gradient(to bottom, #28669f 0%, #357ea9 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */ filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#28669f', endColorstr='#357ea9', GradientType=0); /* IE6-9 */ border-top-left-radius: 5px; border-top-right-radius: 5px;">
					<ul class="navbar-nav">
						<li class="nav-item px-1"><a class="nav-link" href="/Site">Home</a>
						</li>
						<li class="nav-item px-1 "><a class="nav-link"
							href="about.jsp">Info</a></li>
						<li class="nav-item px-1 "><a class="nav-link"
							href="terms.jsp">Termini</a></li>

					</ul>
				</div>
			</nav>
		</div>


		<img class="app-graph" src="assets/style/images/backgroundHeader.svg">

		<div class="container">
			<!-- if we aren't in registration page -->
			<c:if test="${pageContext.request.servletPath ne '/registrationPage.jsp'}">
				<jsp:include page="components/forms/loginForm.jsp"></jsp:include>
			</c:if>
		</div>
	</div>
</div>