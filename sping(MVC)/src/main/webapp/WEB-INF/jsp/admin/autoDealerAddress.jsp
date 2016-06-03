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
     <title><s:message code="AddAutoDealer"/></title>
     <link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
     <link  type="text/css" rel="stylesheet"  href="<c:url value="/css/dashboard.css"/>">
     <script type="text/javascript" src="<c:url value="/js/language.js"/>"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
     <script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>
    <script src="//api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
          <script src="<c:url value="/js/event_properties.js"/>" type="text/javascript"></script>
          
  </head>
  <body>
<jsp:include page="/WEB-INF/jsp/blocks/main_menu.jsp"/>


	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
			      
                    
                      <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li> <a href="${spring:mvcUrl('UC#profile').build()}" id="profil"><s:message code="Profile" /></a></li>
			    	        <li ><a href="${s:mvcUrl('AC#newAuto').build()}" id="addNewAuto"><s:message code="AddNewAuto" /> </a></li>
                    	    <li> <a href="${s:mvcUrl('AC#updateUsers').build()}" id="users"><s:message code="Users" /></a></li>
                    	    <li>  <a href="${s:mvcUrl('XC#newXpath').build()}" id="parsing"><s:message code="Parsing" /></a></li>
                    	    <li><a href="${s:mvcUrl('AC#carsUpdate').build()}" id="cars"><s:message code="Cars" /></a></li>
                    	     <li><a href="${s:mvcUrl('UC#getMyAuto').build()}" id="MyCars"><s:message code="MyCars" /></a></li>
                    	      <li ><a  href="${s:mvcUrl('ADC#newAutoDealer').build()}" id="addAutoDealer"><s:message code="AddAutoDealer" /></a></li>
                    	      <li><a  href="${s:mvcUrl('ADC#autoDealers').build()}" id="autoDealers"><s:message code="AutoDealers" /></a></li>
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
    
    <h3 class="text-success">${autoDealer.name}</h3>
    
    
    <div id="contentBalloon" >

    <form:form  class="form-horizontal" method="POST" commandName="autoDealerAddress">
     <div class="form-group">
      <form:label  class="col-sm-3 control-label"   path="x">X:</form:label>
       <div class="col-sm-offset-1 col-sm-7">
        <form:input id="x"   name="x"  class="form-control" path="x"/>
      <form:errors path="x" /><br>
      </div>
      </div>
       <div class="form-group">
      <form:label  class="col-sm-3 control-label"   path="y">Y:</form:label>
       <div class="col-sm-offset-1 col-sm-7">
        <form:input id="y"   name="y"  class="form-control" path="y"/>
      <form:errors path="y" /><br>
      </div>
      </div>
       <div class="form-group">
      <form:label  class="col-sm-3 control-label"   path="x"><s:message code="Address"/></form:label>
       <div class="col-sm-offset-1 col-sm-7">
     <form:input id="address"   name="address" class="form-control"  path="address"/>
      <form:errors path="x" /><br>
      </div>
      </div>
      
        <input type="hidden" value="${autoDealer.id}" name="autoDealerId"/>
   
           
       <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
       <button type="submit" class="btn btn-success"><s:message code="Add"/></button>
       </div>
       </div>
       
         <div class="form-group">
        <div class="col-sm-offset-1 col-sm-7" id="map" style="width:800px; height:500px"></div>
        </div>
      
    </form:form>
    
    </div>
    

     
      
<jsp:include page="/WEB-INF/jsp/blocks/Author.jsp"/>
	</div>

	</body>
</html>