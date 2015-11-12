<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title> Регистрация</title>
<script src="<c:url value="/js/comment.js" />" type="text/javascript">
</script>
</head>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/Registration.css"/>">
<body >
	<div class="form">
		<form name="reg" id="form"   action="<c:url value="/ServletController"/>" method="Post" onsubmit='return valid()' >
			<fieldset title="Ввод данных">
				<legend>Заполните форму</legend>
				<div class="content" align=center >
				<br>Введите свой e-mail: <br>
				<input id="email" type="text" name="email" style="width: 300px" > <br> <span style='color:red' id='emailf'></span>
				<br>Введите пароль <br>
				<input id="password" type="password" name="pass" size="10" maxlength="5">  <br><span style='color:red' id='passwordf'></span>
				<br>Укажите пол: <br>
				<input id="male" name="sex"  type="radio" value="male">м 
				<input  id="female" name="sex"  type="radio" value="female"> ж  <br> <span style='color:red' id='sexf'></span>
				<br>Желаете подписаться? 
				<input name="subscription" type="checkbox" value="signed">
				<br>О себе:
				<br><textarea name="text1" rows=5 cols=30 maxlength="50" onkeyup="text1Change()"></textarea>
                 Ограничение символов:
                  50<br>
                 Осталось:
                 <span id='change'></span>

			    <br><input type="submit" name="shipping" value="Отправить">
				<input type="reset" name="Reset" value="Очистить форму">
			    <br>*- поля обязательные для заполнения!
			    <br>Запомнить меня<input name="remember" type="checkbox" value="remembered">
			    <br > <a href="<c:url value="/views/Start.jsp"/>"> Выполнить вход</a>
			    </div>
			</fieldset>
		</form>
	</div>
</body>
</html>