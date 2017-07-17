<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="global.coda.iotmanager.models.*"%>
<!DOCTYPE html>
<html>
 <head>
         <jsp:include page="/WEB-INF/views/partials/header.jsp"/>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js" integrity="sha256-SiHXR50l06UwJvHhFY4e5vzwq75vEHH+8fFNpkXePr0=" crossorigin="anonymous"></script>
  
       <style>
        <%@include file="/WEB-INF/resources/core/css/addsensor.css"  %>
        </style>
        
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/partials/authnavbar.jsp"/> 
        
        
        <div class="container">
            <form:form class="form-horizontal" role="form" method="post" modelAttribute="sensor" >
                <h2>Add Sensor  Form</h2>
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Unique Name</label>
                    <div class="col-sm-9">
                        <form:input type="text"  path="id" name="id" placeholder="Sensor Name" class="form-control"  />
                    	<form:errors path="id" cssClass="alert-danger-text" />
                    </div>
                </div>
              
               <input type="hidden" name="companyid" value="<%=  request.getParameter("ID") %>" />
               
               
               <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Type</label>
                    <div class="col-sm-9">
                        <form:input type="text"  path="type" name="type" placeholder="Type Name" class="form-control"  />
                    	<form:errors path="type" cssClass="alert-danger-text" />
                    </div>
                </div>
              
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Min Reading</label>
                    <div class="col-sm-9">
                        <form:input type="number" path="minvalue"  name="minvalue" placeholder="0" class="form-control"  />
                   		<form:errors path="minvalue" cssClass="alert-danger-text" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Max Reading</label>
                    <div class="col-sm-9">
                        <form:input type="number" path="maxvalue" name="maxivalue" placeholder="100" class="form-control"  />
                    	<form:errors path="maxvalue" cssClass="alert-danger-text" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Unit Name</label>
                    <div class="col-sm-9">
                        <form:input type="text"  path="unit" name="unitname" placeholder="°C" class="form-control"  />
                    	<form:errors path="unit" cssClass="alert-danger-text" />
                    </div>
                </div>
                	<form:input type="hidden"  path="companyId"   value="${companyId}"/>
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Create</button>
                    </div>
                </div>
            </form:form> <!-- /form -->
        </div>
        </body>
        </html>
        