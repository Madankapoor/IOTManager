<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
        <jsp:include page="/WEB-INF/views/partials/header.jsp"/>
        <spring:url value="/resources/core/css/main.css" var="coreCss" />
		
		<link href="${coreCss}" rel="stylesheet" />
      
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/partials/nonauthnavbar.jsp"/> 
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    </body>
</html>