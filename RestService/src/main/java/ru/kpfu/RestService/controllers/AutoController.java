package ru.kpfu.RestService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.kpfu.RestService.models.Auto;
import ru.kpfu.RestService.services.AutoService;

@RestController
@RequestMapping("/Auto")
public class AutoController {

	@Autowired
	private AutoService autoService;

	@RequestMapping(value = "/auto", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public Auto autoById(@RequestParam int id) {
		Auto auto = autoService.findOne(id);
		return auto;
	}

	@RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
	public String hello() {
		return "There is a connection to the server";
	}

	@RequestMapping(value = "/delete/auto", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	public String deleteBook(@RequestParam int id) {
		try {
			autoService.delete(id);
			return "The car was successfully removed";
		} catch (Exception e) {
			return "Failed to delete";
		}

	}

	@RequestMapping(value = "/cars", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
	public List<Auto> getList() {

		List<Auto> cars = autoService.findAll();
		return cars;

	}

	@RequestMapping(value = "/new_auto", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	public String addAuto(@RequestParam("model") String model, @RequestParam("yearAuto") int yearAuto,
			@RequestParam("cost") int cost, @RequestParam("typeAuto") String typeAuto) {
		try {
			Auto auto = new Auto(model, yearAuto, cost, typeAuto);
			autoService.save(auto);
			return "The car was successfully added";
		} catch (Exception e) {
			return "Error adding";

		}
	}

	@RequestMapping(value = "/auto/edit", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)

	public String editAutoHandler(@RequestParam("id") int id, @RequestParam("model") String model,
			@RequestParam("yearAuto") int yearAuto, @RequestParam("cost") int cost,
			@RequestParam("typeAuto") String typeAuto) {
		try {
			autoService.update(id, model, yearAuto, cost, typeAuto);
			return "The car was successfully edited";

		} catch (Exception e) {

			return "Error updating";
		}
	}

}
