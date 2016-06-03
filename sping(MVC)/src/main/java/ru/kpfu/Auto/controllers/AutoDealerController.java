package ru.kpfu.Auto.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.Auto.models.AddressAutoDealer;
import ru.kpfu.Auto.models.AutoDealer;
import ru.kpfu.Auto.repositories.AddressAutoDealerRepository;
import ru.kpfu.Auto.repositories.AutoDealerRepository;

@Controller
@RequestMapping("/autoDealer")
public class AutoDealerController {
	@Autowired
	private AutoDealerRepository autoDealerRepository;
	@Autowired
	private AddressAutoDealerRepository addressAutoDealerRepository;

	@RequestMapping(value = "/autoDealers", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String autoDealers(ModelMap map) {
		map.put("autoDealers", autoDealerRepository.findAll());
		return "admin/autoDealers";
	}

	@RequestMapping(value = "/new_autoDealer", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String newAutoDealer(ModelMap map) {
		AutoDealer autoDealer = new AutoDealer();
		map.put("autoDealer", autoDealer);
		return "admin/autoDealer_form";
	}

	@RequestMapping(value = "/new_autoDealer", method = RequestMethod.POST)
	@PreAuthorize(" hasRole('ROLE_ADMIN')")
	public String addAutoDealer(RedirectAttributes redirectAttributes,
			@Valid @ModelAttribute("autoDealer") AutoDealer autoDealer, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/autoDealer_form";
		}

		autoDealerRepository.save(autoDealer);
		redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">AutoDealer \""
				+ autoDealer.getName() + "\" has been added successfully</span>");
		redirectAttributes.addFlashAttribute("messageType", "success");
		return "redirect:" + MvcUriComponentsBuilder.fromMappingName("ADC#newAutoDealer").build();

	}

	@RequestMapping(value = "/addAddress", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String newAutoDealerAddress(@RequestParam int autoDealerId, ModelMap map) {
		AddressAutoDealer addressAutoDealer = new AddressAutoDealer();
		map.put("autoDealer", autoDealerRepository.findOne(autoDealerId));
		map.put("autoDealerAddress", addressAutoDealer);
		return "admin/autoDealerAddress";
	}

	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	@PreAuthorize(" hasRole('ROLE_ADMIN')")
	public String addAddress(@RequestParam int autoDealerId, @Valid AddressAutoDealer addressAutoDealer,
			BindingResult result, ModelMap map) {
		if (result.hasErrors()) {
			return "admin/autoDealerAddress";
		}
		addressAutoDealer.setAutoDealerId(autoDealerRepository.findOne(autoDealerId));
		addressAutoDealerRepository.save(addressAutoDealer);
		return "redirect:"
				+ MvcUriComponentsBuilder.fromMappingName("ADC#newAutoDealerAddress").arg(0, autoDealerId).build();

	}

}
