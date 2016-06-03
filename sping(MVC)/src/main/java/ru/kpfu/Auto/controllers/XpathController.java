package ru.kpfu.Auto.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.kpfu.Auto.models.Xpath;
import ru.kpfu.Auto.models.XpathValidator;

import ru.kpfu.Auto.services.SearchXpathService;

@Controller
@RequestMapping("/Xpath")
public class XpathController {

	@Autowired
	@Qualifier("searchXpathXml")
	private SearchXpathService searchXpathXml;

	@Autowired
	@Qualifier("searchXpathHtml")
	private SearchXpathService searchXpathHtml;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(new XpathValidator());
	}

	@RequestMapping(value = "/new_xpath", method = RequestMethod.GET)
	public String newXpath(ModelMap map) {
		map.put("xpath", new Xpath());

		return "services/xpathService";
	}

	@RequestMapping(value = "/new_xpath", method = RequestMethod.POST)
	public String search(RedirectAttributes redirectAttributes, @Validated Xpath xpath, BindingResult result,
			ModelMap map, @RequestParam String typeSearh) throws Exception

	{
		if (result.hasErrors()) {
			return "services/xpathService";

		} else {
			ArrayList<String> res = new ArrayList<String>();
			if (typeSearh.equals("Html")) {
				res = searchXpathHtml.search(xpath.getXpathF(), xpath.getUrlx());

			} else if (typeSearh.equals("Xml")) {
				res = searchXpathXml.search(xpath.getXpathF(), xpath.getUrlx());

			}

			redirectAttributes.addFlashAttribute("res", res);
			return "redirect:" + MvcUriComponentsBuilder.fromMappingName("XC#newXpath").build();
		}

	}
}