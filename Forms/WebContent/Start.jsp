<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>Главная</title>
<script type="text/javascript">
function valid(){
	
    var email=form.email.value;
	var password=form.password.value;
	
	
	var pattern=/^\s*[\w]{1}[\w-\.]*@[\w-]+\.[a-z]{2,4}$/;
	if(email==""){
		document.getElementById('emailf').innerHTML='*данное поле обязательно для заполнения';
	      return false;
	  
} 
	if(pattern.test(email)==false){
		document.getElementById('emailf').innerHTML='*e-mail введен не верно';
		  return false;
	}
	if(password==""){
	document.getElementById('passwordf').innerHTML='*данное поле обязательно для заполнения';
		  return false;
	}
	if(password.length!=5){
		document.getElementById('passwordf').innerHTML='*пароль должен содержать 5 символов';
		  return false;
	}
}

</script>
</head>
<body>
	<div align="center">
		<form name="reg" id="form" action="http://localhost:8080/Forms/StartServlet" method="Post" onsubmit='return valid()'>
			<fieldset title="Ввод данных">
				<legend>Выполните вход</legend> 
				
				<br>Введите свой e-mail: <br>
				 <input id="email" type="text" name="email" style="width: 400px">  <br> <span style='color:red' id='emailf'></span>
				 <br>Введите пароль
				<br> <input id="password"type="password" name="pass" size="10" maxlength="5">  <br><span style='color:red' id='passwordf'></span>
				
				<br>
				<input type="submit" name="shipping" value="Отправить">
				 <input	type="reset" name="Reset" value="Очистить форму"> 
				 <br>Запомнить меня<input name="remember" type="checkbox" value="remembered">
				<br > <a href="http://localhost:8080/Forms/Registration.jsp"> Зарегистрироваться</a>
			</fieldset>
		</form>
	</div>
	
</body>
</html>