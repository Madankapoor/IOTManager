
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="global.coda.iotmanager.models.*"%>

<!DOCTYPE html>
<html>
    <head>
          <jsp:include page="/WEB-INF/views/partials/header.jsp"/>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js" integrity="sha256-SiHXR50l06UwJvHhFY4e5vzwq75vEHH+8fFNpkXePr0=" crossorigin="anonymous"></script>
  
       <style>
        <%@include file="/WEB-INF/resources/core/css/simulate.css"  %>
        </style>
        
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/partials/authnavbar.jsp"/> 
        
        <%@page import="global.coda.iotmanager.utils.*" %>
        <%@page import="java.sql.*" %>
      
       
      <div class="card-container container" >
          <div class="row">
              <div class="col-md-12">
                <div class="card">
                    <div  style="text-align:center;">
                        <p> Sensor: ${sensorId}</p>
                        <div  class="well" id="sensormain">
                            <div id="sensorvalue" > ${value} ${unit} </div>
                        </div>
                        <a href="simulate?ID=${companyId}&SID=${sensorId}" class="btn btn-primary" ><span class="glyphicon glyphicon-eye"></span>Take Reading</a>
                        <a href="graph?ID=${companyId}&SID=${sensorId}" class="btn btn-primary" ><span class="glyphicon glyphicon-graph"></span>Graph</a>
                    </div>
                </div>
              </div>
          </div>
      </div>
                    
                    <script>
                        
                            var polling=function(){
                                
                                $.get(window.location.href).done(function(data){
                                var parser = new DOMParser();
                                var Doc = parser.parseFromString(data,"text/html");
                            
                                var read=Doc.getElementById("sensorvalue");

                                $('#sensormain').html(read);
                                });
                                
                                
                            };
                            setInterval(polling, 2000);
                      
                    </script>
    </body>
</html>
