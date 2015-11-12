
var count=50;

function text1Change()
{
 a=document.reg.text1.value.length;
 if((a)>count) document.reg.text1.value=document.reg.text1.value.substring(0,count);
 a=document.reg.text1.value.length;
 document.getElementById('change').innerHTML=count-a;
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
