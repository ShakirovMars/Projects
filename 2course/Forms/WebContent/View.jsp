<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title> Регистрация</title>
</head>
<body>
	<div align="center">
		<form action=http://localhost:8080/Forms/ServletController method="GET">
			<fieldset title="Ввод данных">
				<legend>Заполните форму</legend>
				<br>Введите свой e-mail: <br>
				<input type="text" name="email" style="width: 400px" >
				<br>Введите пароль <br>
				<input type="password" name="pass" size="10" maxlength="5">
				<br>Укажите пол: <br>
				<input name="sex"  type="radio" value="male">м 
				<input name="sex"  type="radio" value="female"> ж 
				<br>Желаете подписаться? <br>
				<input name="subscription" type="checkbox" value="signed">
			    <br><input type="submit" name="shipping" value="Отправить">
				<input type="reset" name="Reset" value="Очистить форму">
			    <br>*- поля обязательные для заполнения!
			</fieldset>
		</form>
	</div>
</body>
</html>