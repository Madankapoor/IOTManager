<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page import="global.coda.iotmanager.models.*"%>
<%@page import="global.coda.iotmanager.utils.*" %>
<%@page import="java.sql.*" %>


                    
                
<c:if test = "${companyId!=null}">           
      <div class="container">
	<div class="row">
                
		<section class="content">
			<h1>Sensors</h1>
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="pull-right">
							<div class="btn-group">
								<a href="addsensor?ID=${companyId}" class="btn btn-success btn-filter" data-target="pagado">Add Sensor</a>
							</div>
						</div>
						<div class="table-container">
							<table class="table table-filter">
								<tbody>
                                    <c:forEach items="${cmp.getSensorsId()}" var="sid" >    
									  
									<tr> 
                                                                            <td>
											<div class="media">
												
												<div class="media-body">
                                          		 
													<h4 class="title">
														${sid}
													
													</h4>
													<p class="summary"> Sensor </p>
												</div>
											</div>
										</td>
                                                                                <td>
                                                                                    <a href="simulate?ID=${companyId}&SID=${sid}" class="btn btn-primary">Simulate</a>
										</td>
                                                                                 <td >
                                                                                     <a href="graph?ID=${companyId}&SID=${sid}" class="btn btn-primary">View Data</a>
										</td>
									</tr>
								    </c:forEach>	
								</tbody>
							</table>
						</div>
					</div>
				</div>
				
			</div>
		</section>
		
	</div>
	
	</c:if>
                
   <c:if test = "${companyId==null}">   
                <h1 class="well">Select a company or add a company</h1> </c:if>
                