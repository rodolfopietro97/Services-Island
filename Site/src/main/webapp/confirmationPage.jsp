<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jstl/core"
prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

    <title>
      Services Island - Confirmation Page
    </title>

	<link rel="shortcut icon" href="assets/favicon.ico" />
    <link href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic" rel="stylesheet">
    
    <!-- Light Ui theme stylesheets -->
    <link href="assets/style/statisticsTemplate/toolkit-light.css" rel="stylesheet">
    <link href="assets/style/statisticsTemplate/application.css" rel="stylesheet">

    <style>
      /* note: this is a hack for ios iframe for bootstrap themes shopify page */
      /* this chunk of css is not part of the toolkit :) */
      body {
        width: 1px;
        min-width: 100%;
        *width: 100%;
      }
    </style>
  </head>


<body>

  <div class="container">
  
 
	<jsp:include page="components/userMenu.jsp"></jsp:include>
	        
	<jsp:include page="components/userHeader.jsp"></jsp:include>
	
	<jsp:include page="components/confirmationContents.jsp"></jsp:include>

    <script src="assets/script/jquery.min.js"></script>
    <script src="assets/script/tether.min.js"></script>
    <script src="assets/script/chart.js"></script>
    <script src="assets/script/tablesorter.min.js"></script>
    <script src="assets/script/toolkit.js"></script>

    <script src="assets/script/applicationStatistics.js"></script>



    <script>
      // execute/clear BS loaders for docs
      $(function(){while(window.BS&&window.BS.loader&&window.BS.loader.length){(window.BS.loader.pop())()}})
    </script>
  </body>
</html>