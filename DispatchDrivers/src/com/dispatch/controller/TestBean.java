package com.dispatch.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dispatch.beans.PojoDriver;

@Controller
public class TestBean {

	@GetMapping("/TestBean")
	public void RunBeanTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		PojoDriver drvr = (PojoDriver) context.getBean("driverBeanID");
		System.out.println(drvr.getFirstName());
	}

	// @GetMapping is a composed annotation that acts as a shortcut for
	// @RequestMapping(method = RequestMethod.GET).
	// @GetMapping is the newer annotaion. It supports consumes.
	// Consume options are :
	// consumes = "text/plain"
	// consumes = {"text/plain", "application/*"}
// For further details see:
// https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/request-mapping-variants.html
// Spring 4.3 introduced new annotations which serve the same purpose as @RequestMapping having predefined 'method' (HTTP verb) value.
// Those annotations are actually themselves meta-annotated with @RequestMapping with the related value of 'method' element.
// Followings are those annotations:
//		@GetMapping
//		@PostMapping
//		@PutMapping
//		@DeleteMapping
//		@PatchMapping

	@GetMapping("/DriverBean")
	public ModelAndView passParametersWithModelAndView() {
		// This interface allows us to pass all the information required by Spring MVC
		// in one return
		ModelAndView modelAndView = new ModelAndView("view001");
		modelAndView.addObject("attr001", "Driver001");
		modelAndView.addObject("attr002", "Driver002");
		return modelAndView;
	}

	@GetMapping("test")
	public String handleGetRequest() {
		System.out.println("GetMapping-view");
		return "GetMapping-view";
	}

	@PostMapping("test")
	public String handlePostRequest() {
		return "PostMapping-view";
	}

	@PutMapping("test")
	public String handlePutRequest() {
		return "PutMapping-view";
	}

	@DeleteMapping("test")
	public String handleDeleteRequest() {
		return "DeleteMapping-view";
	}

	@PatchMapping("test")
	public String handlePatchRequest() {
		return "PatchMapping-view";
	}

}
