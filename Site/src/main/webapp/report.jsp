<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<!-- Tipical initial page template -->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">

    <title>
        Services Island - Pagina di report
    </title>

	<link rel="shortcut icon" href="assets/favicon.ico" />
	<link href='https://fonts.googleapis.com/css?family=Lora:400,400italic|Work+Sans:300,400,500,600' rel='stylesheet' type='text/css'>

	<!-- Startup theme stylesheets -->
	<link href="assets/style/homeTemplate/toolkit-startup.css" rel="stylesheet">
	<link href="assets/style/homeTemplate/application-startup.css" rel="stylesheet">
	<link href="assets/style/homeTemplate/iosIframeHack.css" rel="stylesheet">
    
    <script src="assets/script/jquery.min.js"></script>
    <script src="assets/script/tether.min.js"></script>
    <script src="assets/script/toolkit.js"></script>
    <script src="assets/script/application.js"></script>
    
  </head>


<body>

	<%@ include file="components/navbar.jsp" %>

	<c:if test="${empty requestScope.reportMessage}">
		<c:redirect url="../Site"></c:redirect>
	</c:if>
	<h1>${requestScope.reportMessage}</h1>

	<%@ include file="components/footer.jsp" %>


  </body>
</html>
