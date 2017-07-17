<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
        <jsp:include page="/WEB-INF/views/partials/header.jsp"/>
        
       
		
      	<style>
		<%@include file="/WEB-INF/resources/core/css/register.css" %>
		</style>
		 
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/partials/nonauthnavbar.jsp"/> 
        
        
        
        <div class="container">
            <form:form class="form-horizontal" role="form" method="post" action="register" modelAttribute="user">
                <h2>Registration Form</h2>
                <jsp:include page="/WEB-INF/views/partials/error.jsp"/>  
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">First Name</label>
                    <div class="col-sm-9">
                        <form:input path="firstname" type="text" id="firstName" name="firstname" placeholder="First Name" class="form-control" />
                        <form:errors path="firstname" cssClass="alert-danger-text" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">Last Name</label>
                    <div class="col-sm-9">
                        <form:input path="lastname" type="text" name="lastname" id="lastName" placeholder="Last Name" class="form-control" />
                    	<form:errors path="lastname" cssClass="alert-danger-text" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <form:input path="email" type="email" id="email" placeholder="Email" class="form-control" name="email" />
                    	<form:errors path="email" cssClass="alert-danger-text" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-9">
                        <form:input  path="password" type="password"  placeholder="Password" class="form-control" name="password" />
                    	<form:errors path="password" cssClass="alert-danger-text" />
                    
                    </div>
                    
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Confirm Password</label>
                    <div class="col-sm-9">
                        <form:input path="conf_password" type="password" id="conf_password" placeholder="Confirm Password" class="form-control" name="conf_password" />
                    	<form:errors path="conf_password" cssClass="alert-danger-text" />
                    
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label" >Date of Birth</label>
                    <div class="col-sm-9">
                        <form:input path="birthDate" type="date" id="birthDate" class="form-control" name="dob" />
                   		<form:errors path="birthDate"  cssClass="alert-danger-text" />
                    
                    </div>
                    
                </div>
               
               
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">I accept <a href="#">terms</a>
                            </label>
                        </div>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </div>
                </div>
            </form:form> <!-- /form -->
        </div> <!-- ./container -->
      
        
    </body>
</html>