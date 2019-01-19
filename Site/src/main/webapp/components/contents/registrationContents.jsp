<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h1>Registrazione</h1>
<c:choose>
	<c:when test="${param.userType eq 'p'}">
		<jsp:include page="../forms/professionistRegistrationForm.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.userType eq 'u'}">
		<jsp:include page="../forms/userRegistrationForm.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="../forms/userRegistrationForm.jsp"></jsp:include>
	</c:otherwise>
</c:choose>