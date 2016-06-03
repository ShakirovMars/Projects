package ru.kpfu.Auto.models;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AutoValidator  implements Validator {

	public boolean supports(Class<?> clazz) {
		
		return Auto.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {

//	    Auto a = (Auto) obj;
        
	    ValidationUtils.rejectIfEmptyOrWhitespace(e, "model", "registration.model.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "yearAuto", "registration.yearAuto.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "cost", "registration.cost.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "typeAuto", "registration.typeAuto.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "equipment", "registration.equipment.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "mark", "registration.mark.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "transmission", "registration.transmission.empty");
        
        
    
		
	
	
	}
	
}
