
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
  <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
  
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="site icon" href="<c:url value="/ico/SiteIcon.ico"/>">
     <title><s:message code="AutoShow"/></title>
     <link type="text/css" rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
     <link  type="text/css" rel="stylesheet"  href="<c:url value="/css/dashboard.css"/>">
     <script type="text/javascript" src="<c:url value="/js/language.js"/>"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
     <script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>
           <script src="//api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
     
  </head>
  <body>
<jsp:include page="/WEB-INF/jsp/blocks/main_menu.jsp"/>
  
  <div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
			       
                    
                      <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li> <a href="${spring:mvcUrl('UC#profile').build()}"><s:message code="Profile" /></a></li>
			    	        <li><a href="${s:mvcUrl('AC#newAuto').build()}"><s:message code="AddNewAuto" /> </a></li>
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
     <c:if test="${not empty auto}">
             <h3 class="text-success">${auto.model}</h3>
          <div class="text-right">
          <a  href="${spring:mvcUrl("AC#deleteAuto").arg(0, auto.id).build()}" class="text-danger"><i class="glyphicon glyphicon-remove"></i></a>
          <a href="${spring:mvcUrl("AC#editAuto").arg(0, auto.id).build()}" class="text-success"><i class="glyphicon glyphicon-edit"></i></a>
             </div> 
            
              <p class="text-primary"><s:message code="AutoDealer"/>: ${auto.autoDealer.name} </p>
              <p class="text-primary"> <s:message code="Year"/>: ${auto.yearAuto} </p>
                <p class="text-primary"><s:message code="Cost"/>: ${auto.cost} </p> 
                <p class="text-primary">  <s:message code="Type"/>: ${auto.typeAuto}</p>
               <p class="text-primary">  <s:message code="Mark"/>: ${auto.mark} </p>
               <p class="text-primary"> <s:message code="Equipment"/>: ${auto.equipment}</p> 
               <p class="text-primary">  <s:message code="Transmission"/>: ${auto.transmission}</p>
              <p class="text-primary">${auto.description} </p>
              
             <script  type="text/javascript">
        ymaps.ready(init);
        var myMap;

        function init() {
            myMap = new ymaps.Map("map", {
                center: [55.793637, 49.115739],
                zoom: 10,
            });

            <c:if test="${addresses != null}">
            <c:forEach var="address" items="${addresses}">
           
            var placemark = new ymaps.Placemark([${address.x}, ${address.y}], {
                hintContent: '${auto.autoDealer.name}',
                balloonContent:'${address.address}'
            });

            myMap.geoObjects.add(placemark);
            </c:forEach>
            </c:if>

            balloonHandler();
        }
    </script>
              
       
               
              <div  id="map" style="width:800px; height:500px"></div>
    </c:if>
    
</p>
  <jsp:include page="/WEB-INF/jsp/blocks/Author.jsp"/>
	</div>

	</body>
</html>
		
