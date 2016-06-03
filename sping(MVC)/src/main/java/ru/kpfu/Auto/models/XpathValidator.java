package ru.kpfu.Auto.models;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class XpathValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		 return Xpath.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
	    ValidationUtils.rejectIfEmpty(e, "xpathF", "xpathF.empty");
	    ValidationUtils.rejectIfEmpty(e, "Urlx", "Urlx.empty");
	    Xpath a = (Xpath) obj;
	    try {
	      new URL(a.getUrlx());
	    } catch (MalformedURLException ex) {
	      e.rejectValue("Urlx", "Urlx.incorrect");
	    }
	  }
}
