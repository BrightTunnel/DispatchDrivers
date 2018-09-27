package com.dispatch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dispatch.beans.PojoDriver;

@Controller
@ControllerAdvice
public class TestController {

	private Map<Long, PojoDriver> employeeMap = new HashMap<>();

	@RequestMapping(value = "/addDriver", method = RequestMethod.POST)
	// @RequestMapping(value = "/addDriver", method = RequestMethod.GET)
	public String submit(@ModelAttribute("newDriver") PojoDriver driver, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("name", driver.getFirstName());
		model.addAttribute("id", driver.getDriverID());
		employeeMap.put(driver.getDriverID(), driver);
		return "driverView";
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("msg", "xs");
	}
}