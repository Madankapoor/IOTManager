<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page import="global.coda.iotmanager.models.*"%>
<%@page import="global.coda.iotmanager.utils.*" %>
<%@page import="java.sql.*" %>


<!DOCTYPE html>
<html>
 <head>
         <jsp:include page="/WEB-INF/views/partials/header.jsp"/>
        <style>
       
		<%@include file="/WEB-INF/resources/core/css/index.css" %>
		<%@include file="/WEB-INF/resources/core/css/addsensor.css" %>
		
		</style>
       
        
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/partials/authnavbar.jsp"/> 
        
        
         <div class="container">

            <form:form class="form-horizontal" role="form" method="post" modelAttribute="company" action="addcompany">
                
                <h2>Add Company  Form</h2>
               
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Name</label>
                    <div class="col-sm-9">
                        <form:input path="name" type="text"  name="name" placeholder="Company Name" class="form-control" />
                    	<form:errors path="name" cssClass="alert-danger-text" />
                    </div>
                </div>
              
                <div class="form-group">
                    <label  class="col-sm-3 control-label"> Address Line 1</label>
                    <div class="col-sm-9">
                        <input path="" type="text"  name="add1" placeholder="" class="form-control" />
                    </div>
                </div>
               
                
               <div class="form-group">
                    <label  class="col-sm-3 control-label">Address Line 2</label>
                    <div class="col-sm-9">
                        <input type="text"  name="add2" placeholder="" class="form-control">
                    </div>
                </div>
               
                
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Create</button>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
                
            </form:form> <!-- /form -->
        </div> <!-- ./container -->
        
        </div>
        </body>
        </html>