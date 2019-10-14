<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<jsp:include page = "/mainhead.inc.jsp" />


<div class="container-full">
  <div class="container-fluid">   
	
	
	<div class="alert alert-danger">
		  <strong>Ops!</strong> <s:property value="getText('error.label')" />
		       <s:actionerror />
		</div>
	
	
    		
    </div>  
  </div>


<jsp:include page = "/javascripts.jsp" />

<jsp:include page = "/mainfooter.inc.jsp" />