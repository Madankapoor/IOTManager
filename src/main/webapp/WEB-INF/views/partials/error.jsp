<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test="${flash_success!=null}" > 
    <div class="alert alert-success" >
        ${flash_success}
    </div>
</c:if>
<c:if test="${flash_danger!=null}" > 
    <div class="alert alert-danger">
        ${flash_danger}
    </div>
</c:if>

