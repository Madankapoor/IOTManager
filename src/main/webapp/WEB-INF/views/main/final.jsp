<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
        <jsp:include page="/WEB-INF/views/partials/header.jsp"/>
        
        <style>
        <%@include file="/WEB-INF/resources/core/css/index.css"  %>
        </style>
        
		
		
      	
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/partials/authnavbar.jsp"/> 
        
        <jsp:include page="/WEB-INF/views/company/sensors.jsp"/> 
        
        <jsp:include page="/WEB-INF/views/company/users.jsp"/> 
    </body>
</html>