
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

   <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		    <div class="container">
			<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value="/"/>"> <s:message code="Home" /> </a>
			</div>
			
			<div class="navbar-collapse collapse">
			
		    <div class="nav navbar-nav navbar-right">
		    
		    <ul class="nav navbar-nav">
		     <security:authorize access="isAnonymous()">
			<li><a class="navbar-brand"  href="<spring:url value="/login" />">	<s:message code="Sign" /></a></li>	
	        </security:authorize>
		<security:authorize access="isAuthenticated()">
     <li><a class="navbar-brand"  href="<spring:url value="/logout" />"><s:message code="LogOut" /></a></li>
       </security:authorize>
					<li><button type="button" class="btn  btn-primary"
						onclick='ChangeLanguage("ru")'>Ru</button></li>

					<li><button type="submit" class="btn  btn-primary"
						onclick='ChangeLanguage("en")'>En</button></li>
				</ul>
			</div>
			</div>
		</div>
	</div>
