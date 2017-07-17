<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
        <jsp:include page="/WEB-INF/views/partials/header.jsp"/>		
		
		<style>
		<%@include file="/WEB-INF/resources/core/css/login.css" %>
		</style>
		 
		
      
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/partials/nonauthnavbar.jsp"/> 
       
        
         <div class="container">
        <div class="card card-container">
            <jsp:include page="/WEB-INF/views/partials/error.jsp"/>
            
           
             
            <form class="form-signin" 
		  		 method='POST' action='login' >
              
            
             <p id="profile-name" class="profile-name-card"></p>
            	
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" id="inputEmail" class="form-control" placeholder="Email address" name="username" required autofocus>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required  name="password">
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"  value = "Login!">Sign in</button>
             </form>
            <a href="#" class="forgot-password" >
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container --> 
   
    </body>
</html>