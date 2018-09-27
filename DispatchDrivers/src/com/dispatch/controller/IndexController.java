package com.dispatch.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dispatch.beans.PojoDock;
import com.dispatch.beans.PojoDriver;

public class IndexController {

	@GetMapping("/IndexController")
	public ModelAndView index01(@Value("#{request.getAttribute('key')}") HashMap<Integer, PojoDock> obj) {
		Map<String, String> model = new HashMap();

		HashMap<Integer, PojoDock> dcs = null;
		for (Integer _key : dcs.keySet()) {
			PojoDock value = dcs.get(_key);
			model.put("key" + _key, value.toString());
		}

		return new ModelAndView("view001", model);
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("attr003", "attr003");
	}

	@RequestMapping(value = "/addDriver", method = RequestMethod.POST)
	public String submit(@ModelAttribute("driver") PojoDriver dock) {
		// Code that uses the employee object

		return "driverView";
	}

	@GetMapping("/showView001")
	public String passParametersWithModel(Model model) {
		Map<String, String> map = new HashMap<>();
		map.put("spring", "mvc");
		model.addAttribute("attr001", "Data to display1");
		model.addAttribute("attr002", "Data to display2");
		model.mergeAttributes(map);
		addAttributes(model);
		return "view001"; // html or jsp target resource @ DispatchDrivers/WEB-INF/jsp/view001.jsp
	}

	@GetMapping("/showView002")
	public String passParametersWithModelMap(ModelMap map) {
		// The advantage of ModelMap is it gives us the ability to pass a collection of
		// values and treat these values as if they were within a Map
		map.addAttribute("attr001", "attr001");
		map.addAttribute("attr002", "attr002");
		return "view001";
	}

	@GetMapping("/showView003")
	public ModelAndView passParametersWithModelAndView() {
		// This interface allows us to pass all the information required by Spring MVC
		// in one return
		ModelAndView modelAndView = new ModelAndView("view001");
		modelAndView.addObject("attr001", "attr001");
		modelAndView.addObject("attr002", "attr002");
		return modelAndView;
	}

	@RequestMapping(value = "someurl", method = RequestMethod.GET)
	// if the request attribute name does not match the method parameter name
	public String handleSomeUrlw1(@RequestAttribute(name = "userAttributeName") String str) {
		return "return: " + str;
	}

	@RequestMapping(value = "someurl_", method = RequestMethod.GET)
	// if the request attribute name does not match the method parameter name
	public String handleSomeUrlw(@RequestAttribute(name = "userAttributeName") PojoDriver dock) {
		return null;

	}
}
