<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>                        
            </button>
            <a class="navbar-brand" href="#">IOT Manager</a>
          </div>
          <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
              <li class="active"><a href="/IOTManager/?ID=${cmp.getId()}">DashBoard: ${cmp.getName()} </a></li>
            </ul>
            
            
     		 
            <ul class="nav navbar-nav navbar-right">
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> <span class="glyphicon glyphicon-th-large"></span><span class="caret"></span></a>
         		 
         		 
         		 <ul class="dropdown-menu dropdown-cart" role="menu">
	            	 <c:forEach items="${companies}" var="company">
			  <li>
                <span class="item">
                    <span class="item-left">
                        <span class="item-info">
                            <span id="${company.getId()}" > ${company.getName()}</span>
                        </span>
                    </span>
                    <c:set var="cid" value="${company.getId()}"/>  
                    <span class="item-right">
                    	<c:if test = "${companyId==null || !cid.equals(companyId) }">
          
                         <a class="btn btn-xs btn-primary pull-right" href="/IOTManager/?ID=${company.getId()}"><span class="glyphicon glyphicon-list-alt"></span></a>
                      
                        </c:if>
                    </span>
                </span>
              </li>
     		 </c:forEach>
	            	<li class="divider"></li>
	            	<li >
	            	<a class="text-center" href="/IOTManager/addcompany" class="text-center">
	            	Add vehicle <span class="glyphicon glyphicon-plus  pull-left">
	            	</a>
	            	</li>
	            	<li >
	            	<a class="text-center" href="#" class="text-center">
	            	<form action="/IOTManager/logout" method="post">
	            	<span class="glyphicon glyphicon-log-out pull-left"></span><button class="mybutton">logout</button>
	            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	            	</form>
	            	</a>
	            	</li>
             	</ul>
             </li>
             </ul>
          </div>
        </div>
      </nav>
       