<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src='<spring:url value="/resources/js/contact.home.js" />'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h1><spring:message code="contact.list.title"></spring:message></h1>
<div>
	<a href='<spring:url value="/contact/add" />' class="btn btn-primary"><spring:message code="contact.label.add.link"/></a>
	<div id="contact-list">
		<c:choose>
			<c:when test="${empty contacts}">
				<p><spring:message code="contact.list.label.no.contacts" /></p>
			</c:when>
			<c:otherwise>
				<c:forEach items="${contacts}" var="contact">
					<div class="well contact-list-item">
						<a href='<spring:url value="/contact/${contact.id}" />'> <c:out value="${contact.firstName}"/> <c:out value="${contact.lastName}"/></a>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>