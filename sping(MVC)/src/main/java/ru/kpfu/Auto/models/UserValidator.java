package ru.kpfu.Auto.models;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class UserValidator  implements Validator {

	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		 
		    User u = (User) obj;
		    if (u.getAge() < 0) {
	            e.rejectValue("age", "negativevalue");
	        } else if (u.getAge() > 110) {
	            e.rejectValue("age", "too.darn.old");
	        }
		    
		    
		    
		   
		    ValidationUtils.rejectIfEmptyOrWhitespace(e, "fullName", "registration.username.empty");
	        ValidationUtils.rejectIfEmptyOrWhitespace(e, "username", "registration.email.empty");
	        ValidationUtils.rejectIfEmptyOrWhitespace(e, "password", "registration.password.empty");
	        ValidationUtils.rejectIfEmptyOrWhitespace(e, "passwordRepeat", "registration.repeatPassword.empty");
	        ValidationUtils.rejectIfEmptyOrWhitespace(e, "age", "age.empty");
	        if (!u.getPassword().equals(u.getPasswordRepeat())) {
	            e.rejectValue("passwordRepeat", "registration.repeatPassword.notEquals");
	        }
	        validateEmailSyntax(u.getUsername(), "username", "registration.email.wrongPattern", e);
	       
	        
	    }
	 
	    public void validateEmailSyntax(String email, String field, String errorCode, Errors errors) {
	        Pattern p = Pattern.compile("^[\\w]{1}[\\w-\\.]*@[\\w-]+\\.[a-z]{2,4}$");
	        if (!p.matcher(email).find()) {
	            errors.rejectValue(field, errorCode);
	        }
	    }
	   
	   
	    
	}


