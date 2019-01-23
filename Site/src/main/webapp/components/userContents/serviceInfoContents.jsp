<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<article>
	<h1>
		${requestScope.result.nome}
	</h1>
	<h3>
		${requestScope.result.descrizione}
	</h3>
	<h3>
		le altre info poi le metto...
	</h3>
</article>
