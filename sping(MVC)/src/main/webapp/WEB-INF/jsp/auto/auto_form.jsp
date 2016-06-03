
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
  
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="site icon" href="<c:url value="/ico/SiteIcon.ico"/>">
     <title><s:message code="AutoForm"/></title>
     <link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
     <link  type="text/css" rel="stylesheet"  href="<c:url value="/css/dashboard.css"/>">
     <script type="text/javascript" src="<c:url value="/js/language.js"/>"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
     <script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>
  </head>
  <body>
<jsp:include page="/WEB-INF/jsp/blocks/main_menu.jsp"/>


	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
			        <security:authorize access="hasRole('ROLE_USER')">
			                <li> <a href="${spring:mvcUrl('UC#profile').build()}"><s:message code="Profile" /></a></li>
			    	        <li class="active"><a  href="${s:mvcUrl('AC#newAuto').build()}"><s:message code="AddNewAuto" /> </a></li>
                    	    <li> <a href="${s:mvcUrl('UC#getList').build()}"><s:message code="Users" /></a></li>
                    	    <li>  <a href="${s:mvcUrl('XC#newXpath').build()}"><s:message code="Parsing" /></a></li>
                    	    <li><a href="${s:mvcUrl('AC#getList').build()}"><s:message code="Cars" /></a></li>
                    	    <li><a href="${s:mvcUrl('UC#getMyAuto').build()}"><s:message code="MyCars" /></a></li>
                    	    
                    	   
                    </security:authorize>
                    
                      <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li> <a href="${spring:mvcUrl('UC#profile').build()}"><s:message code="Profile" /></a></li>
			    	        <li  class="active" ><a href="${s:mvcUrl('AC#newAuto').build()}"><s:message code="AddNewAuto" /> </a></li>
                    	    <li> <a href="${s:mvcUrl('AC#updateUsers').build()}"><s:message code="Users" /></a></li>
                    	    <li>  <a href="${s:mvcUrl('XC#newXpath').build()}"><s:message code="Parsing" /></a></li>
                    	    <li><a href="${s:mvcUrl('AC#carsUpdate').build()}"><s:message code="Cars" /></a></li>
                    	     <li><a href="${s:mvcUrl('UC#getMyAuto').build()}"><s:message code="MyCars" /></a></li>
                    	      <li><a href="${s:mvcUrl('ADC#newAutoDealer').build()}"><s:message code="AddAutoDealer" /></a></li>
                    	      <li><a  href="${s:mvcUrl('ADC#autoDealers').build()}"><s:message code="AutoDealers" /></a></li>
                      </security:authorize>
                      
				</ul>
			  </div> 
			</div>
		</div>



<div class="container">
 <p> 
   <br> <br>
     <c:if test="${not empty message}">
      <h1>${message}</h1>
    </c:if>
    <form:form  class="form-horizontal" method="POST" commandName="auto" modelAttribute="auto">
     <div class="form-group">
      <form:label  class="col-sm-3 control-label"  for="model" path="model"><s:message code="Model"/></form:label>
       <div class="col-sm-offset-1 col-sm-7">
      <form:input class="form-control"  path="model"/>
      <form:errors path="model" /><br>
      </div>
      </div>
       <div class="form-group">
       <form:label class="col-sm-3 control-label" path="yearAuto"><s:message code="Year"/></form:label>
        <div class="col-sm-offset-1 col-sm-7">
      <form:input class="form-control"   path="yearAuto"/>
      <form:errors path="yearAuto" /><br>
      </div>
      </div>
      <div class="form-group"> 
       <form:label class="col-sm-3 control-label" path="cost"><s:message code="Cost"/></form:label>
        <div class="col-sm-offset-1 col-sm-7">
      <form:input class="form-control"  path="cost"/>
      <form:errors path="cost" /><br>
      </div>
      </div>
    
     <div class="form-group">
        <form:label  class="col-sm-3 control-label"  path="typeAuto"><s:message code="Type"/></form:label>
        <div class="col-sm-offset-1 col-sm-7">
        <form:input class="form-control"  path="typeAuto"/>
      <form:errors path="typeAuto" /><br>
      </div>
      </div>
        <div class="form-group">
     <form:label  class="col-sm-3 control-label"  path="mark"><s:message code="Mark"/></form:label>
   <div class="col-sm-offset-1 col-sm-7">
      <form:input class="form-control"  path="mark"/>
      <form:errors path="mark" /><br>
      </div>
      </div>
      <div class="form-group">
       <form:label  class="col-sm-3 control-label"  path="transmission"><s:message code="Transmission"/></form:label>
       <div class="col-sm-offset-1 col-sm-7">
      <form:input class="form-control"  path="transmission"/>
      <form:errors path="transmission" /><br>
      </div>
      </div>
        <div class="form-group">
       <form:label   class="col-sm-3 control-label"  path="equipment"><s:message code="Equipment"/></form:label>
      <div class="col-sm-offset-1 col-sm-7">
      <form:input class="form-control"  path="equipment"/>
      <form:errors path="equipment" /><br>
      </div>
      </div>
      
       <div class="form-group">
 
   <form:label   class="col-sm-3 control-label" path="autoDealer">  <s:message code="AutoDealer"/>:</form:label>
   <div class="col-sm-offset-1 col-sm-7">
   
    <form:select class="form-control"  path="autoDealer">
        <c:forEach items="${autoDealers}" var="autoDealer">
            <form:option value="${autoDealer.id}" label="${autoDealer.name}"/>
        </c:forEach>
    </form:select>

</div>
      
      
      </div>
         
            
            <div class="form-group">
      <form:label   class="col-sm-3 control-label"  path="description"><s:message code="Description"/></form:label>
      <div class="col-sm-offset-1 col-sm-7">
      <form:textarea type="text" class="form-control"  path="description"/>
      <form:errors path="description" /><br>
      </div>
            </div>
               
           
       <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
       <button type="submit" class="btn btn-success"><s:message code="Send"/></button>
       </div>
       </div>
       
      
    </form:form>
    
    </p>

     
      
<jsp:include page="/WEB-INF/jsp/blocks/Author.jsp"/>
	</div>

	</body>
</html>
			