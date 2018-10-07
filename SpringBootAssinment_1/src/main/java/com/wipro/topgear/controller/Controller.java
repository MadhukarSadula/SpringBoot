package com.wipro.topgear.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/bank")
public class Controller {
	
	@RequestMapping("/name")
	public String getName() {
	 
	  return "HDFC bank";
	  }
	
	@RequestMapping("/address")
	public String getAddress() {
		
	    return "HDFC bank,hyderabad";

	}
}
