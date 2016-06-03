package ru.kpfu.Auto.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.Auto.models.forms.LoginForm;


@Controller
public class SecurityController {


	  @RequestMapping(value = "/login")
	  @PreAuthorize("isAnonymous()")
	  public String login(@RequestParam(required = false) String error, @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap map) {
	    map.put("error", error);
	    return "user/login_form";
	  }
	  
	  

  
}
