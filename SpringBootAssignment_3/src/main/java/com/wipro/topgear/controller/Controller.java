package com.wipro.topgear.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller

@RequestMapping("/bank")
public class Controller {
	
	@RequestMapping("/details")
@ResponseBody
	public String getBankdetails() {
	 
	  return "bankdetails";
	  }
	
	@RequestMapping("/services")
	@ResponseBody
	public String getServices() {
		
	    return "bankservices";

	}
}
