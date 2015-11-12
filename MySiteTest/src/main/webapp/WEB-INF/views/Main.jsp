<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Мой сайт</title>

<script   src="<c:url value="/js/jquery-2.1.4.min.js" />"> </script> 

<script type="text/javascript">
	$(document).ready(function() {
		var UserId=${inf.getId()};
        var r=0;
	    $('#posts').submit(function(e) {
			$.ajax({ 
		    url : "PostServlet", 
			type : "post", 
			dataType:"json",
			data: ({ UserId :UserId, text:$("#text").val()}),
			success : function(data) {
				
			if(r==0 && data!=""){
			$('#table').append("<thead>"+ "<tr>"+"<th>"+"Комментарий"+"</th>"+"<th>"+"Пользователь"+"</th>"+"<th>"+"Дата"+"</th>"+"<th>"+"Время"+"</th>"+"</tr>"+"</thead>");
			i=0;
			r=1;
			} else if(data!="" ){
				i=data.length-1;
			}
			if(data=="") alert("Пустое поле!!!");
			for(var i;i<=data.length;i++){
			$('#table').append("<tr>"+"<td>"+data[i].text+"</td>"+"<td>"+data[i].email+"</td>"+"<td>"+data[i].date+"</td>"+"<td>"+data[i].time+"</td>");
			
			}
			
			} 
			}); 
			return false;
		}); 
	}); 
</script>

</head>
<body>

<br><h2>Добро пожаловать,	${inf.getEmail()} !!!</h2>  


<form id="posts"> 
<br><textarea id="text" name="text" rows=5 cols=30 ></textarea>

<br><input type="submit" id="submit" value="Отправить" > 
<table id="table" border=2 bordercolor=red >
</table>
</form> 

<div id='answer'>
</div>




<br > <a href="<c:url value="/views/Start.jsp"/>"> Выйти</a>
</body>
</html>