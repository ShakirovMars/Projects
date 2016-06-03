package ru.kpfu.Auto.controllers;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.Auto.aspect.MyLog;
import ru.kpfu.Auto.exceptions.NotFoundException;
import ru.kpfu.Auto.models.Auto;
import ru.kpfu.Auto.models.User;
import ru.kpfu.Auto.repositories.AddressAutoDealerRepository;
import ru.kpfu.Auto.repositories.AutoDealerRepository;
import ru.kpfu.Auto.repositories.AutoRepository;

@Controller
@RequestMapping("/Car")
public class AutoController {

	@Autowired
	private AutoRepository autoRepository;
	
	@Autowired
	private AutoDealerRepository autoDealerRepository;
	@Autowired
	private AddressAutoDealerRepository addressAutoDealerRepository;
	
	
	@MyLog
	@RequestMapping(value = "/auto/{id}", method = RequestMethod.GET)
	public String autoById(@PathVariable int id, ModelMap map) {
        Auto auto=autoRepository.findOne(id);
        if(auto==null){
        	 throw new NotFoundException("auto");
        }
        map.put("addresses",addressAutoDealerRepository.findByAutoDealerId(auto.getAutoDealer()));

		map.put("auto", auto);
		return "auto/autoById";
	}
	
	
	@RequestMapping(value = "/new_auto", method = RequestMethod.GET)
	 @PreAuthorize("hasRole('ROLE_USER')OR hasRole('ROLE_ADMIN')")
	public String newAuto(ModelMap map) {
		Auto auto= new Auto();
		map.put("auto", auto);
		return showForm(map);
	}

	@RequestMapping(value = "/new_auto", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_USER')OR hasRole('ROLE_ADMIN')")
	public String addAuto(RedirectAttributes redirectAttributes, @Valid  @ModelAttribute("auto") Auto auto, BindingResult result, ModelMap map) {
		if (result.hasErrors() ){
			return showForm(map);
          } 
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			auto.setUser(user);
			autoRepository.save(auto);
			redirectAttributes.addFlashAttribute("message","<span style=\"color:green\">Auto \"" + auto.getModel() + "\" has been added successfully</span>");
		    redirectAttributes.addFlashAttribute("messageType", "success");
			return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#newAuto").build();
		

	}

	protected String showForm(ModelMap map) {
	    map.put("autoDealers",  autoDealerRepository.findAll());
	    return "auto/auto_form";
	  }
	

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String getList(@RequestParam(value = "page", defaultValue = "1") Integer page,ModelMap map) {

        map.put("pages",3);
		map.put("cars", autoRepository.findAll(new PageRequest(page-1,2)).getContent());
		return "auto/carsShow";
	}
	
	 protected String showFormAuto(ModelMap map) {
		    map.put("autoDealers", autoDealerRepository.findAll());
		    return "auto/auto_form";
		  }
		
		@RequestMapping(value = "/auto/edit/{id}", method = RequestMethod.GET)
		  @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER') ")
		  public String editAuto(@PathVariable int id, ModelMap map) {
		   Auto auto = autoRepository.findOne(id);
		   
		    if (auto == null) {
		      throw new NotFoundException("auto");
		    }
		   
		    map.put("auto", auto);
		    return showFormAuto(map);
		  }
		
		
		  @RequestMapping(value = "/auto/edit/{id}", method = RequestMethod.POST)
		  @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
		  public String editAutoHandler(
		    RedirectAttributes redirectAttributes,
		     @Valid @ModelAttribute("auto") Auto auto,
		    BindingResult result,
		    ModelMap map
		  ) {
		    if (result.hasErrors()) {
		      return showFormAuto(map);
		    } else{
		    
		        auto.setUser(autoRepository.findOne(auto.getId()).getUser());
		    	autoRepository.save(auto);
		      redirectAttributes.addFlashAttribute("message", "Auto \"" + auto.getModel() + "\" has been saved successfully");
		      redirectAttributes.addFlashAttribute("messageType", "success");
		      return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#editAuto").arg(0, auto.getId()).build();
		    }
		    
		  }
		  
		  @RequestMapping(value = "/autoUpdate/{id}", method = RequestMethod.GET)
			 @PreAuthorize("hasRole('ROLE_ADMIN')")
			public String autoUpdate(@PathVariable int id,ModelMap map) {
			  Auto auto=autoRepository.findOne(id);
		        if(auto==null){
		        	 throw new NotFoundException("auto");
		        }
				map.put("auto",auto);
		        map.put("addresses",addressAutoDealerRepository.findByAutoDealerId(auto.getAutoDealer()));

				return "admin/autoUpdate";
			}
		
}
