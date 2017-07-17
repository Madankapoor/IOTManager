
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="global.coda.iotmanager.models.*"%>
<!DOCTYPE html>
<html>
 <head>
         <jsp:include page="/WEB-INF/views/partials/header.jsp"/>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js" integrity="sha256-SiHXR50l06UwJvHhFY4e5vzwq75vEHH+8fFNpkXePr0=" crossorigin="anonymous"></script>
  
       <style>
        <%@include file="/WEB-INF/resources/core/css/index.css"  %>
        </style>
        
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/partials/authnavbar.jsp"/> 
        
        <%@page import="global.coda.iotmanager.utils.*" %>
        <%@page import="java.sql.*" %>
        <div class="container">
            <div class="row">
                <div class="col-md-12" >
                    <h3>${sensorId}</h3>
                </div>
               <div class="col-md-12">
                     <div class="chart-container" style="height:40vh; width:80vw;" >
                        <canvas id="chart"></canvas>
                    </div>
                    
                </div>
               
            </div>
        </div>
        
         <script>
    

   
    var ctx = document.getElementById("chart").getContext("2d");
   
    var LineChart = new Chart(ctx,{
        type:'line',
        data: {
            labels: [${sensorData.getLabelsString()}],
            datasets: [
            {
                label: "Sensor Data",
                fillColor: "rgba(220,220,220,0.2)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: [${sensorData.getDataString()}],
                fill:false
            }
        ]
        },
        options: {
                responsive: true
               
            }
    });
   
     var polling=function(){
     
       $.get('getupdate?SID=${sensorId}').done(function(data){
                                var parser = new DOMParser();
                                var Doc = parser.parseFromString(data,"text/html");
                            
                                var dlabel=JSON.parse(Doc.getElementById("label").innerHTML);
                                var ddata=JSON.parse(Doc.getElementById("data").innerHTML);
                                
                                
                             
                              

                                LineChart.data.datasets[0].data = ddata;
                                LineChart.data.labels = dlabel;  
                                LineChart.update(0);
                                });
                                
     };
     setInterval(polling, 4000);
         </script>
    </body>
</html>