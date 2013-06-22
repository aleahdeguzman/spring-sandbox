package org.jubot.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String printHelloWorld(Locale locale, Model model) {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		
		model.addAttribute("serverTime", formatter.format(date));
		
		
		
		return "helloWorld";
	}
	
	/**
	 * Old way passing parameter using query string
	 * sample input: http://localhost:8080/SpringMVCWithJQuery/index.htm?name=aleah
	 * @param locale
	 * @param model
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/index.htm", method=RequestMethod.GET)
	public String helloName(Locale locale, Model model, @RequestParam String name) {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		
		model.addAttribute("serverTime", formatter.format(date));
		model.addAttribute("name", name);
		
		return "helloWorld";
	}
	
	/**
	 * RESTful way to pass parameter
	 * sample input: http://localhost:8080/SpringMVCWithJQuery/index.htm/name/aleah/age/34
	 * @param locale
	 * @param model
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/index.htm/name/{name}/age/{age}", method=RequestMethod.GET)
	public String helloNameRest(Locale locale, Model model, @PathVariable String name, @PathVariable String age) {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		
		model.addAttribute("serverTime", formatter.format(date));
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "helloWorld";
	}

}
