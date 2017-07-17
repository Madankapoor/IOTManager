<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<%@page import="global.coda.iotmanager.models.*"%>


<c:if test = "${companyId!=null}">  
<c:if test = "${cmp.validateAdmin(email)==true}"> 
          <div class="row">

		<section class="content">
                    <h1>Users</h1>
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="pull-right">
							<div class="btn-group">
								<button  class="btn btn-success btn-filter" data-toggle="modal" data-target="#adduser">Add User</button>
							</div>
						</div>
						<div class="table-container">
							<table class="table table-filter">
								<tbody>
                               <c:forEach items="${cmp.getUsersEmail()}" var="company_userEmail" varStatus="loop">    
									<tr> 
                                                                            <td>
											<div class="media">
												
												<div class="media-body">
                                                                                                   
												<h4 class="title">
														   ${company_userEmail}  
													
													</h4>
													<p class="summary"> ${cmp.getUsersRole().get(loop.index)}</p>
												</div>
											</div>
										</td>
                                                                               <!-- <td>
                                                                                    <a href="" class="btn btn-primary">Change Role</a>
										</td class="pull-right">
                                                                                 <td>
                                                                                     <a href="" class="btn btn-danger">Remove</a>
										</td> -->
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
</div>
	

<div class="modal fade" id="adduser" role="dialog">
    <div class="modal-dialog modal-sm card-container">
       
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add / Invite User</h4>
              </div>
              <div class="modal-body card">

                    
                          <label for="email">Email</label>
                          <input id="emailadded" type="email" name="email" placeholder="Enter the email of the user"  ></input>
                
                    
                  </form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-success" id="buttontoadd"data-dismiss="modal" onclick="addemail()" >Add / Invite</button>
                
              </div>
            </div>
       
    </div>
  </div>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>         
    <script>
                
                 
                 function addemail()
                 {
                     var email=$('#emailadded').val();
                     
                   
                        $.ajax({
                         type: 'GET',
                         url: 'adduser?addemail='+email+"&ID=${companyId}" 
                        }).done(function(data) { 
                     
                                    alert(data);
                                    window.location.reload();
                                
                        });
                      
                       
                   //$("#adduser").modal("toggle");  
                 };
             </script>
   </c:if>          
     </c:if>    
      