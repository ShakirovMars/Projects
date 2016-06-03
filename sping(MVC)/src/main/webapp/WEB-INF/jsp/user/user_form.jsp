
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
     <title><s:message code="UserForm"/></title>
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
			   
         
                      
                      
                     <security:authorize access="isAnonymous()">
                           <li class="active"><a  href="${spring:mvcUrl('UC#register').build()}"><s:message code="UserRegistration" /></a></li>
                           <li><a href="${s:mvcUrl('AC#getList').build()}"><s:message code="Cars" /></a></li>
					 </security:authorize>
                      
                   
			
				</ul>
			  </div> 
			</div>
		</div>


 <div class="container">
     <p>  <br> <br>
    <c:if test="${not empty message}">
      <h1>${message}</h1>
    </c:if>
    <form:form  class="form-horizontal" method="POST" commandName="user">
     <div class="form-group">
      <form:label class="col-sm-3 control-label"  path="fullName"><s:message code="Name"/></form:label>
        <div class="col-sm-offset-1 col-sm-7">
      <form:input class="form-control"   path="fullName"/>
      <form:errors path="fullName" /><br>
      </div>
      </div>
       <div class="form-group">
      <form:label class="col-sm-3 control-label" path="password"><s:message code="Password"/></form:label>
        <div class="col-sm-offset-1 col-sm-7">
      <form:input type="password"  class="form-control"   path="password" />
      <form:errors path="password" /><br>
      </div>
      </div>
      <div class="form-group">
       <form:label class="col-sm-3 control-label" path="passwordRepeat"><s:message code="PasswordRepeat"/></form:label>
        <div class="col-sm-offset-1 col-sm-7">
      <form:input type="password"  class="form-control"  path="passwordRepeat" />
      <form:errors path="passwordRepeat" /><br>
      </div>
      </div>
      <div class="form-group">
       <form:label class="col-sm-3 control-label" path="age"><s:message code="Age" /></form:label>
       <div class="col-sm-offset-1 col-sm-7">
      <form:input class="form-control"  path="age" />
      <form:errors path="age" /><br>
      </div>
      </div>
       <div class="form-group">
        <form:label class="col-sm-3 control-label" path="username"><s:message code="Email"/></form:label>
         <div class="col-sm-offset-1 col-sm-7">
      <form:input class="form-control"   path="username"/>
      <form:errors path="username" /><br>
      </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
       <button type="submit" class="btn btn-success"><s:message code="Register"/></button>
       </div>
       </div>
     
    </form:form>
	
  
<jsp:include page="/WEB-INF/jsp/blocks/Author.jsp"/>
	</div>

	</body>
</html>
			
