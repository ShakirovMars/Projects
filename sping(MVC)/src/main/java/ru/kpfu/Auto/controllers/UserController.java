package ru.kpfu.Auto.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.Auto.models.User;
import ru.kpfu.Auto.models.UserValidator;
import ru.kpfu.Auto.repositories.AutoRepository;
import ru.kpfu.Auto.repositories.UserRepository;
import ru.kpfu.Auto.services.UserService;

@Controller
@RequestMapping("/User")
public class UserController {

	
//	  @Autowired
//	  @Qualifier("myAuthenticationManager")
//	    protected AuthenticationManager authenticationManager;
	  
	  
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	@Autowired
	private AutoRepository autoRepository;
	@InitBinder
	  private void initBinder(WebDataBinder binder) {
	    binder.setValidator(new UserValidator());
	  }
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("isAnonymous()")
	public String register(ModelMap map) {
		map.put("user", new User());
		return "user/user_form";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("isAnonymous()")
	public String registerHandler(RedirectAttributes redirectAttributes, @ModelAttribute("user") @Validated User user,
			BindingResult result, ModelMap map) {
		if (!result.hasErrors()) {
			try {
				
				userService.registerUser(user);
				redirectAttributes.addFlashAttribute("message", "You has been registered successfully");
				redirectAttributes.addFlashAttribute("messageType", "success");
				
			
				return "redirect:" + MvcUriComponentsBuilder.fromPath("/login").build();
		
			} catch (DuplicateKeyException ex) {
				result.rejectValue("username", "entry.duplicate", "There is account with such email already.");
			}
		}
		return "user/user_form";
	}
	

	@RequestMapping("/profile")
	@PreAuthorize("hasRole('ROLE_USER')OR hasRole('ROLE_ADMIN')")
	public String profile(HttpServletRequest request) {
		return "user/profile";
	}

	@RequestMapping("/users")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String getList(ModelMap map) {
		map.put("users", userRepository.findAll());
		return "user/showUsers";
	}

	@RequestMapping(value = "/myCars", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	public String getMyAuto(ModelMap map) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
		map.put("cars", autoRepository.findByUser(user));
		return "user/MyCars";
	}

}
