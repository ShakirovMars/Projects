
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
     <title><s:message code="Cars"/></title>
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
			    	        <li><a href="${s:mvcUrl('AC#newAuto').build()}"><s:message code="AddNewAuto" /> </a></li>
                    	    <li> <a href="${s:mvcUrl('UC#getList').build()}"><s:message code="Users" /></a></li>
                    	    <li>  <a href="${s:mvcUrl('XC#newXpath').build()}"><s:message code="Parsing" /></a></li>
                    	    <li class="active"><a  href="${s:mvcUrl('AC#getList').build()}"><s:message code="Cars" /></a></li>
                    	    <li><a href="${s:mvcUrl('UC#getMyAuto').build()}"><s:message code="MyCars" /></a></li>
                    	    
                    	   
                    </security:authorize>
             <security:authorize access="isAnonymous()">
                           <li><a  href="${spring:mvcUrl('UC#register').build()}"><s:message code="UserRegistration" /></a></li>
                           <li class="active"><a  href="${s:mvcUrl('AC#getList').build()}"><s:message code="Cars" /></a></li>
					 </security:authorize>
			
				</ul>
			  </div> 
			</div>
		</div>

	<div class="container">
	    <p>  <br> <br>
  
       <c:choose>
    <c:when test="${not empty cars}">
      <c:forEach var="auto" items="${cars}" varStatus="loop">
      
            <h3 ><a href="${spring:mvcUrl("AC#autoById").arg(0, auto.id).build()}"> ${auto.model}</a></h3>
          
          
      </c:forEach>
    </c:when>
    <c:otherwise>
      <h3><s:message code="NoCarsToShow"/></h3>
    </c:otherwise>
  </c:choose>
        <c:forEach var="page" begin="1" end="${pages}">
        <a class="btn btn-primary" href="<s:url value="/Car/cars?page=${page}"/>"> <c:out value="${page}"/></a>
    </c:forEach>
				
<jsp:include page="/WEB-INF/jsp/blocks/Author.jsp"/>
	</div>

	</body>
</html>
			