<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title> Регистрация</title>
<script type="text/javascript">

var count=50;
function load1()
{
 document.reg.t1.value=count;
 document.reg.t2.value=count;
}
function text1Change()
{
 a=document.reg.text1.value.length;
 if((a)>count)document.reg.text1.value=document.reg.text1.value.substring(0,count);
 a=document.reg.text1.value.length;
 document.reg.t2.value=count-a;
}
function valid(){
	
    var email=form.email.value;
	var password=form.password.value;
	var state=form.sex.value;
	
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
   if(state=="" ){
	document.getElementById('sexf').innerHTML='*Не указан пол';
	   return false;
   }
	

	
}

</script>
</head>
<link rel="stylesheet" type="text/css" href="Registration.css">
<body onload=load1()>
	<div class="form">
		<form name="reg" id="form"   action="http://localhost:8080/Forms/ServletController" method="Post" onsubmit='return valid()' >
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
				<br><textarea name="text1" rows=5 cols=30  onkeyup="text1Change()"></textarea>
                 Ограничение символов:
                 <input type="text" name="t1"  size="4" maxlength="4" disabled><br>
                 Осталось:
                <input type="text" name="t2"  size="4" maxlength="4" disabled>
			    <br><input type="submit" name="shipping" value="Отправить">
				<input type="reset" name="Reset" value="Очистить форму">
			    <br>*- поля обязательные для заполнения!
			    <br>Запомнить меня<input name="remember" type="checkbox" value="remembered">
			    <br > <a href="http://localhost:8080/Forms/Start.jsp"> Выполнить вход</a>
			    </div>
			</fieldset>
		</form>
	</div>
</body>
</html>