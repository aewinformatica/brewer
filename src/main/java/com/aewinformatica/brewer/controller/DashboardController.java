package com.aewinformatica.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

	@GetMapping("/")
	public ModelAndView home(){
		
		ModelAndView mv = new ModelAndView("Dashboard");
		return mv;
	}
}
