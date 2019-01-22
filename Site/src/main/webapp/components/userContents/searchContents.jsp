<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:choose>
	<c:when test="${not empty requestScope.result}">
		<article>
			<c:forEach items="${requestScope.result}" var="i">
				<p>${i.nome}</p>
				<p>${i.descrizione}</p>
			</c:forEach>
		</article>
	</c:when>

	<c:otherwise>
		<article>
			<h1>La ricerca non ha prodotto risultati</h1>
		</article>
	</c:otherwise>
</c:choose>
