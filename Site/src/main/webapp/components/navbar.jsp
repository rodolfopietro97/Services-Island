<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<div class="stage-shelf stage-shelf-right hidden" id="sidebar">
  <ul class="nav nav-bordered nav-stacked flex-column">
    <li class="nav-header">Menu</li>
    <li class="nav-item">
      <a class="nav-link active" href="index.html">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="minimal/index.html">About</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="bold/index.html">Registration</a>
    </li>
    <li class="nav-divider"></li>
    <li class="nav-header">Languages</li>
    <li class="nav-item">
      <a class="nav-link" href="docs/index.html">Italian</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="http://getbootstrap.com">English</a>
    </li>
  </ul>
</div>

<div class="stage" id="stage">

<div class="block block-inverse block-fill-height app-header"
     style="background-color: #33749a; height: auto;">

  <div class="container py-4 fixed-top app-navbar">
  <nav class="navbar navbar-transparent navbar-padded navbar-toggleable-sm">
    <button
      class="navbar-toggler navbar-toggler-right hidden-md-up"
      type="button"
      data-target="#stage"
      data-toggle="stage"
      data-distance="-250">
      <span class="navbar-toggler-icon"></span>
    </button>

    <a class="navbar-brand mr-auto" href="">
      <strong style="background: #fff; padding: 12px; border-radius: 4px; color: /* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#28669f+0,357ea9+100 */
      background: #28669f; /* Old browsers */
      background: -moz-linear-gradient(top, #28669f 0%, #357ea9 100%); /* FF3.6-15 */
      background: -webkit-linear-gradient(top, #28669f 0%,#357ea9 100%); /* Chrome10-25,Safari5.1-6 */
      background: linear-gradient(to bottom, #28669f 0%,#357ea9 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
      filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#28669f', endColorstr='#357ea9',GradientType=0 ); /* IE6-9 */ ">Services Island</strong>
    </a>

    <div class="hidden-sm-down text-uppercase nav nav-tabs border" style="/* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#28669f+0,357ea9+100 */
    background: #28669f; /* Old browsers */
    background: -moz-linear-gradient(top, #28669f 0%, #357ea9 100%); /* FF3.6-15 */
    background: -webkit-linear-gradient(top, #28669f 0%,#357ea9 100%); /* Chrome10-25,Safari5.1-6 */
    background: linear-gradient(to bottom, #28669f 0%,#357ea9 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#28669f', endColorstr='#357ea9',GradientType=0 ); /* IE6-9 */ border-top-left-radius: 5px; border-top-right-radius: 5px;">
      <ul class="navbar-nav">
        <li class="nav-item px-1">
          <a class="nav-link" href="#">Home</a>
        </li>
        <li class="nav-item px-1 ">
          <a class="nav-link" href="minimal/index.html">About</a>
        </li>
        <li class="nav-item px-1 ">
          <a class="nav-link" href="#registration">Registration</a>
        </li>

      </ul>
    </div>
  </nav>
</div>


  <img class="app-graph"  src="assets/style/images/startup-0.svg">

    <div class="container">


		<c:if test="${pageContext.request.servletPath ne '/registrationPage.jsp'}">
	        <div class="col-md-3 offset-md-3 float-right" style="margin-top: 50px;">
	
	                <form class="px-4 py-3" method="POST" action="UserHandler?op=login">
	                  <div class="form-group">
	                    <label for="exampleDropdownFormEmail1">Email address</label>
	                    <input name="txtEmail" type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com" style="min-width: 150px;">
	                  </div>
	                  <div class="form-group">
	                    <label for="exampleDropdownFormPassword1">Password</label>
	                    <input name="txtPassword" type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password" style="min-width: 150px;">
	                  </div>
	                  
	                  <div style="">
	                  <ul>
	                  	<li style="float: left; list-style-type: none; margin: 2px;">
							<a href="#registration" class="btn btn-primary float-right">Sing Up</a>	                  	
	                  	</li>
	                  </ul>
	                  <ul>
		                  <li style="float: left; list-style-type: none; margin: 2px;">
							<button type="submit" class="btn btn-primary float-right">Login</button>		                  
		                  </li>
	                  </ul>
	                  </div>

	                  	
	
	                </form>
	
	        </div>		
		</c:if>



    </div>
</div>