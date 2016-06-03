package ru.kpfu.Auto.controllers;



import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.Auto.exceptions.NotFoundException;
import ru.kpfu.Auto.models.User;
import ru.kpfu.Auto.models.UserValidator;
import ru.kpfu.Auto.repositories.AutoRepository;
import ru.kpfu.Auto.repositories.UserRepository;
import ru.kpfu.Auto.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
 @Autowired
 private UserService userService;
 @Autowired
 private AutoRepository autoRepository;

 @Autowired
	private UserRepository userRepository;
 

	@InitBinder
	  private void initBinder(WebDataBinder binder) {
	    binder.setValidator(new UserValidator());
	  }

	
	
	
	  @RequestMapping(value = "/cars", method = RequestMethod.GET)
		 @PreAuthorize("hasRole('ROLE_ADMIN')")
		public String carsUpdate(ModelMap map) {
			map.put("cars", autoRepository.findAll());
			return "admin/carsUpdate";
		}

	 
	  @RequestMapping("/auto/delete/{id}")
	  public String deleteAuto(@PathVariable int id, RedirectAttributes redirectAttributes, ModelMap map) {
	    try {
	    	autoRepository.delete(id);
	      redirectAttributes.addFlashAttribute("message", "Auto has been deleted successfully");
	      redirectAttributes.addFlashAttribute("messageType", "success");
	    } catch (EmptyResultDataAccessException e) {
	      redirectAttributes.addFlashAttribute("message", "Can't find auto with id " + id);
	      redirectAttributes.addFlashAttribute("messageType", "fail");
	    } catch (DataAccessException e) {
	      redirectAttributes.addFlashAttribute("message", "Can't delete auto with id " + id);
	      redirectAttributes.addFlashAttribute("messageType", "fail");
	    }
	    return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#carsUpdate").build();
	  }
	  

     @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
     @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
     public String editUser( @PathVariable int id,ModelMap map) {
    	  User user = userRepository.findOne(id);
          if (user == null) {
            throw new NotFoundException("user");
          }
       try{
         userService.updateUser(user);
        
         return usersUpdate( map);
       }
       catch(EntityNotFoundException ex){
         throw new NotFoundException("user");
       }
     }       
	  
     protected String usersUpdate(ModelMap map) {
    	 map.put("users", userRepository.findAll());
 	    return "admin/usersUpdate";
 	  }
     
	  @RequestMapping("/updateUsers")
     @PreAuthorize("hasRole('ROLE_ADMIN')")
     public String updateUsers(ModelMap map) {
       map.put("users", userRepository.findAll());
       return "admin/usersUpdate";
     }
}
